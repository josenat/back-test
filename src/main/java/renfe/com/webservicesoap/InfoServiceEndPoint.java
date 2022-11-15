package renfe.com.webservicesoap;

import com.renfe.webservicesoap.GetInfoHabilitacionRequest;
import com.renfe.webservicesoap.GetInfoHabilitacionResponse;
import com.renfe.webservicesoap.ObjectFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import renfe.com.pdf.datamanager.BundleMgr;
import renfe.com.service.*;
import renfe.com.util.ResponseCts;
import renfe.com.validator.GetInfoValidator;
import renfe.com.validator.ValidationResult;

import java.math.BigInteger;
import java.util.List;

@Endpoint
public class InfoServiceEndPoint {

    private static final String NAMESPACE_URI = "http://renfe.com/webservicesoap";

    private final Tbasg127LineasService tbasg127LineasService;

    private final Tbasg129EntornosService tbasg129EntornosService;

    private final Tbasg131AlcanceotService tbasg131AlcanceotService;

    private final Tbasg133SerieService tbasg133SerieService;

    private final Tbasg137EspecialiService tbasg137EspecialiService;
    /** The Constant logger. */
    private static final Logger logger = LoggerFactory.getLogger(InfoServiceEndPoint.class);

    @Autowired
    private Tbasg104ExpedientService tbasg104ExpedientService;

    String tipoInfra;
    String id;
    String codAlcanceHab;
    int tipoId;
    BigInteger codTipoHabil;
    BigInteger codEstado;
    Boolean indActaPsico;
    Boolean indActaForm;
    Boolean indHistoric;

    public InfoServiceEndPoint(Tbasg127LineasService tbasg127LineasService, Tbasg129EntornosService tbasg129EntornosService, Tbasg131AlcanceotService tbasg131AlcanceotService, Tbasg133SerieService tbasg133SerieService, Tbasg104ExpedientService tbasg104ExpedientService, Tbasg137EspecialiService tbasg137EspecialiService) {
        this.tbasg127LineasService = tbasg127LineasService;
        this.tbasg129EntornosService = tbasg129EntornosService;
        this.tbasg131AlcanceotService = tbasg131AlcanceotService;
        this.tbasg133SerieService = tbasg133SerieService;
        this.tbasg104ExpedientService = tbasg104ExpedientService;
        this.tbasg137EspecialiService = tbasg137EspecialiService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getInfoHabilitacionRequest")
    @ResponsePayload
    public GetInfoHabilitacionResponse getInfoHabilitacion(@RequestPayload GetInfoHabilitacionRequest request) throws Exception {

        ObjectFactory factory = new ObjectFactory();
        GetInfoHabilitacionResponse infohabilResponse = factory.createGetInfoHabilitacionResponse();
        infohabilResponse.setGetInfoHabilitacionReturn(factory.createGetInfoHabilitacionResponseGetInfoHabilitacionReturn());

        if(request.getId() != null) id = request.getId().trim();
        if(request.getTipoInfra() != null) tipoInfra = request.getTipoInfra().trim();
        if(request.getCodAlcanceHab() != null) codAlcanceHab = request.getCodAlcanceHab().trim();

        tipoId = request.getTipoId();
        codTipoHabil = request.getCodTipoHabil();
        codEstado =request.getCodEstado();
        indActaPsico = request.isIndActaPsico();
        indActaForm = request.isIndActaForm();
        indHistoric = request.isIndHistoric();



        GetInfoValidator getinfovali = new GetInfoValidator(
                tbasg127LineasService,
                tbasg129EntornosService,
                tbasg131AlcanceotService,
                tbasg133SerieService,
                tbasg137EspecialiService
        );

        // Válidamos los parámetros de entrada
        ValidationResult objValidationResult =
                getinfovali.validateGetInfo(tipoId, id, codTipoHabil, tipoInfra, codAlcanceHab, codEstado);
        if (!objValidationResult.isOk()){

            createResponse(ResponseCts.DATA_VALIDATION_ERRORS,
                    objValidationResult.getErrors(), infohabilResponse);
        } else {

            GetInfoHabilitacionResponse objAction = tbasg104ExpedientService.getInfoHabilitacionAction(tipoId, id, indActaPsico,
                    indActaForm, indHistoric, codTipoHabil, tipoInfra, codAlcanceHab, codEstado);


            try  {

                infohabilResponse = objAction;

            } catch (Exception ex) {

                logger.debug("ERROR DATA getInfoHabilitacion");
            }
        }

        logOutput(infohabilResponse);
        return infohabilResponse;

    }

    private void logOutput(GetInfoHabilitacionResponse infohabilResponse){

        if(logger.isInfoEnabled()){

            StringBuffer sb = new StringBuffer();
            sb.append(" OUTPUT | ")
                    .append("Status: ").append(infohabilResponse.getGetInfoHabilitacionReturn().getStatus())
                    .append(" | Message: ").append(infohabilResponse.getGetInfoHabilitacionReturn().getMessage());

            logger.info(sb.toString());
        }
    }

    private void logInput(int tipoId, java.lang.String id, java.lang.Boolean indActaPsico,
                          java.lang.Boolean indActaForm, java.lang.Boolean indHistoric, java.math.BigInteger codTipoHabil,
                          java.lang.String tipoInfra, java.lang.String codAlcanceHab, java.math.BigInteger codEstado){

        if(logger.isInfoEnabled()){

            StringBuffer sb = new StringBuffer();
            sb.append(" INPUT (tipoId, id, indActaPsico, indActaForm, indHistoric, ")
                    .append("codTipoHabil, tipoInfra, codAlcanceHab, codEstado): ");

            sb.append("(")
                    .append(tipoId).append(", ")
                    .append(id).append(", ")
                    .append(indActaPsico).append(", ")
                    .append(indActaForm).append(", ")
                    .append(indHistoric).append(", ")
                    .append(codTipoHabil).append(", ")
                    .append(tipoInfra).append(", ")
                    .append(codAlcanceHab).append(", ")
                    .append(codEstado)
                    .append(")");

            logger.info(sb.toString());
        }
    }

    private void createResponse(Integer status, List explainMsgList,GetInfoHabilitacionResponse infohabilResponse) {

        infohabilResponse.getGetInfoHabilitacionReturn().setStatus(status.intValue());

        String msg = BundleMgr.getInstance().resolve(status.toString());
        if(explainMsgList != null) {
            String explainMsg = buildExplainMsg(explainMsgList);
            infohabilResponse.getGetInfoHabilitacionReturn().setMessage(msg + explainMsg);
        } else {
            infohabilResponse.getGetInfoHabilitacionReturn().setMessage(msg);
        }

    }

    private String buildExplainMsg(List values) {

        if(values != null && !values.isEmpty()){

            StringBuffer sb = new StringBuffer();
            sb.append(" (");
            sb.append(values.get(0));
            for(int i = 1; i < values.size(); i++){

                sb.append(", ").append(values.get(i));
            }
            sb.append(") ");
            return sb.toString();
        } else {
            return "";
        }
    }
}
