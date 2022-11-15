package renfe.com.webservicesoap;

import com.renfe.webservicesoap.GetCertificadoComplementarioRequest;
import com.renfe.webservicesoap.GetCertificadoComplementarioResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import renfe.com.dto.GetFechaProxRecicTitConDTO;
import renfe.com.pdf.core.CertificadoComplementarioPdfWriter;
import renfe.com.pdf.datamanager.BundleMgr;
import renfe.com.pdf.datamanager.TextFormat;
import renfe.com.repository.impl.Tbasg100PersonaRepositoryImpl;
import renfe.com.service.Tbasg100PersonaService;
import renfe.com.service.Tbasg104ExpedientService;
import renfe.com.util.*;
import com.renfe.webservicesoap.ObjectFactory;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import com.google.gson.Gson;

@Endpoint
public class CertComplEndPoint {
    private static final String NAMESPACE_URI = "http://renfe.com/webservicesoap";
    public static final String ERROR = "ERROR: ";

    @Autowired
    private Tbasg100PersonaService tbasg100PersonaService;

    @Autowired
    private Tbasg104ExpedientService tbasg104ExpedientService;

    /** The Constant logger. */
    private static final Logger logger = LoggerFactory.getLogger(Tbasg100PersonaRepositoryImpl.class);

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCertificadoComplementarioRequest")
    @ResponsePayload
    public GetCertificadoComplementarioResponse getCertificadoComplementario(@RequestPayload GetCertificadoComplementarioRequest request) {

        ObjectFactory factory = new ObjectFactory();
        GetCertificadoComplementarioResponse certcomplResponse = factory.createGetCertificadoComplementarioResponse();
        certcomplResponse.setGetCertificadoComplementarioReturn(factory.createGetCertificadoComplementarioResponseGetCertificadoComplementarioReturn());

        byte[]pdf = null;
        int status = ResponseCts.PDF_KO;
        boolean blnEsVigente = false;

        try {

            List<GetFechaProxRecicTitConDTO> fecha = this.tbasg100PersonaService.getFechaProxRecicTitConByMatricula(request.getIdMaquinista());

            Date fechaVigencia = fecha.get(0).getFchaCursoInc();
            Date fechaActual = new Date(Calendar.getInstance().getTime().getTime());

            String dFecha = TextFormat.format(fechaVigencia,"/");

            if(null != fechaVigencia)
            {
                try {
                    certcomplResponse.getGetCertificadoComplementarioReturn().setFechaExpiracion(dFecha);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                if(fechaActual.equals(fechaVigencia)||fechaVigencia.after(fechaActual))
                {
                    blnEsVigente = true;
                }
            }
            else
            {
                status = ResponseCts.NOT_HAVE_TITLE;
            }
        } catch (NumberFormatException e) {
            logger.error("ERROR ",e);
        } catch (Exception e) {
            logger.error("ERROR ",e);
        }

        if(blnEsVigente)
        {
            pdf = crearPdf(request.getIdMaquinista());
        }

        if(pdf!=null){
            status=ResponseCts.OK;

        }

        crearRespuesta(status, blnEsVigente, certcomplResponse);

        if(blnEsVigente){

            certcomplResponse.getGetCertificadoComplementarioReturn().setPdf(pdf);
        }
        return certcomplResponse;
    }

    private byte[] crearPdf(String idMaquinista) {

        logger.info("Creadon pdf  de certificado complementario del maquinista: "+idMaquinista);
        byte []pdf = null ;
        String sIdioma = "ES";

        //  Creamos el reource bundle con el idioma elegido
        String language = sIdioma.toLowerCase();
        String country = sIdioma;
        Locale currentLocale = new Locale(language, country);

        ResourceBundle message = ResourceBundle.getBundle("locale/CertificadoComplementario", currentLocale);

        Object bean = null;

        try {
            bean = tbasg104ExpedientService.getCertificadoComplementarioActionbyMatricula(idMaquinista);

        }catch (Exception e){
            logger.error("Error al crear el bean del certificado complementario del maquinista: "+ idMaquinista+" Error:" +e );
        }

        if(bean == null) {
            logger.error("Error al crear el bean del certificado complementario del maquinista: "+ idMaquinista+" Bean null");
        }

        //FotoPersonal fotoPersonal = new FotoPersonal();
        //String imgPath_1 = "gif";
        String imgPath_1 = null;
        String imgPath_2 = null;

        //String imgPath_2 = fotoPersonal.getPathAbsolute(bean.getMatricula(), bean.getNifPas());

        try {
            CertificadoComplementarioPdfWriter pdfWriter = new CertificadoComplementarioPdfWriter(imgPath_1, imgPath_2);
            pdf = pdfWriter.createPDFCertifComplementarioWs(bean, true, true, message);

        } catch (Exception e) {
            logger.error("Error al crear el pdf del certificado complementario del maquinista: "+ idMaquinista+" Error:" +e );
        }
        return pdf;
    }

    private void crearRespuesta(int status, boolean blnEsVigente, GetCertificadoComplementarioResponse certcomplResponse){

        certcomplResponse.getGetCertificadoComplementarioReturn().setStatus(status);
        certcomplResponse.getGetCertificadoComplementarioReturn().setBlnEsVigente(blnEsVigente);

        String msg = BundleMgr.getInstance().resolve(Integer.toString(status));

        certcomplResponse.getGetCertificadoComplementarioReturn().setMessage(msg);

    }

}