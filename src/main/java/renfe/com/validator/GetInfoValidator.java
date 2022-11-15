package renfe.com.validator;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import renfe.com.model.dto.*;
import renfe.com.service.*;
import renfe.com.util.MultivalueCts;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class GetInfoValidator extends ValidatorBase {

    /** The Constant logger. */
    private static final Logger logger = LoggerFactory.getLogger(GetInfoValidator.class);

    private final Tbasg127LineasService tbasg127LineasService;

    private final Tbasg129EntornosService tbasg129EntornosService;

    private final Tbasg131AlcanceotService tbasg131AlcanceotService;

    private final Tbasg133SerieService tbasg133SerieService;

    private final Tbasg137EspecialiService tbasg137EspecialiService;

    public GetInfoValidator(
            Tbasg127LineasService tbasg127LineasService,
            Tbasg129EntornosService tbasg129EntornosService,
            Tbasg131AlcanceotService tbasg131AlcanceotService,
            Tbasg133SerieService tbasg133SerieService,
            Tbasg137EspecialiService tbasg137EspecialiService) {
        this.tbasg127LineasService = tbasg127LineasService;
        this.tbasg129EntornosService = tbasg129EntornosService;
        this.tbasg131AlcanceotService = tbasg131AlcanceotService;
        this.tbasg133SerieService = tbasg133SerieService;
        this.tbasg137EspecialiService = tbasg137EspecialiService;
    }


    public ValidationResult validateGetInfo(int tipoId, String id, BigInteger codTipoHabil,
                                                   String tipoInfra, String codAlcanceHab, BigInteger codEstado) {

        List errors = new ArrayList();

        if ( tipoId < 0 || tipoId > 4 )
            errors.add(ValidatorInfoCts.ERROR_MSG_TIPO_IDENTIF_INCORRECT);

        if( !mandatory(id) )
            errors.add(ValidatorInfoCts.ERROR_MSG_NUM_IDENTIF_MANDATORY);

        // Valor comprendido entre el 1 y el 4
        if( id!= null && tipoId == 1)
        {
            if(!checkNIF(id)){
                errors.add(ValidatorInfoCts.ERROR_MSG_NIF_INCORRECT);
            }
        }
        // Comprobación del NIE
        if( id!= null && tipoId == 2)
        {
            if(!checkNIE(id)){
                errors.add(ValidatorInfoCts.ERROR_MSG_NIE_INCORRECT);
            }
        }
        // Comprobación de la Matrícula
        if( id!= null && tipoId == 4)
        {
            if(id.length() != 7){
                errors.add(ValidatorInfoCts.ERROR_MSG_MATRICULA_INCORRECT);
            }
        }

        // Comprobamos el codigo de Tipo de Habilitación si no es nulo
        if( null != codTipoHabil )
        {
            if( codTipoHabil.intValue() < MultivalueCts.T123_TIPOHABIL_CONDUCCION_INFRAESTRUCTURA.intValue()
                    || codTipoHabil.intValue() > MultivalueCts.T123_TIPOHABIL_OPERADOR_VEHICULO_MANIOBRAS.intValue() )
            {
                errors.add(ValidatorInfoCts.ERROR_MSG_TIPO_HABIL_INCORRECT);
            }
            else if ( codTipoHabil.intValue() == MultivalueCts.T123_TIPOHABIL_CONDUCCION_INFRAESTRUCTURA.intValue() )
            {
                // Si es de tipoInfraestructura, es necesario que venga relleno el Tipo de Infraestructura
                // VALORES VÁLIDOS L y E.
                if (!mandatory(tipoInfra)){

                    errors.add(ValidatorInfoCts.ERROR_MSG_TIPO_INFRA_MANDATORY);
                }else if (!MultivalueCts.T104_TIPO_INFR_LINEA.equals(tipoInfra)
                        && !MultivalueCts.T104_TIPO_INFR_ENTORNO.equals(tipoInfra)){

                    errors.add(ValidatorInfoCts.ERROR_MSG_TIPO_INFRA_INCORRECT);
                }
            }
        }

        // Comprobamos el codigo del alcance
        if(mandatory(codAlcanceHab)){

            if(codTipoHabil == null){

                errors.add(ValidatorInfoCts.ERROR_MSG_TIPO_HAB_MANDATORY);
            } else {

                if(codTipoHabil.intValue() == MultivalueCts.T123_TIPOHABIL_CONDUCCION_INFRAESTRUCTURA.intValue()){

                    if (mandatory(tipoInfra)){

                        if(tipoInfra.equals(MultivalueCts.T104_TIPO_INFR_LINEA)){

                            if(codAlcanceHab.trim().length() != 3){

                                errors.add(ValidatorInfoCts.ERROR_MSG_ALCANCE_INFR_LINEA_INCORRECT);
                            } else {
                                String aux = checkAlcanceLinea(codAlcanceHab);
                                if(aux != null) {
                                    errors.add(aux);
                                }
                            }
                        } else if(tipoInfra.equals((MultivalueCts.T104_TIPO_INFR_ENTORNO))){

                            String aux = checkAlcanceEntorno(codAlcanceHab);
                            if(aux != null) {
                                errors.add(aux);
                            }
                        }
                    }

                } else if(codTipoHabil.intValue() == MultivalueCts.T123_TIPOHABIL_CONDUCCION_MATERIAL.intValue()){

                    String aux = checkAlcanceMaterial(codAlcanceHab);
                    if(aux != null) {
                        errors.add(aux);
                    }
                } else if(codTipoHabil.intValue() == MultivalueCts.T123_TIPOHABIL_AUX_OPERACIONES_TREN.intValue()){

                    String aux = checkAlcanceOT(codAlcanceHab);
                    if(aux != null) {
                        errors.add(aux);
                    }
                } else if(codTipoHabil.intValue() == MultivalueCts.T123_TIPOHABIL_CARGADOR.intValue()
                        // @INC000001034925@INDRA.SCEXU9D.SDC@18/08/2015@INICIO
                        // 107953 RQ0001 Responsable operaciones de carga
                        || codTipoHabil.intValue() == MultivalueCts.T123_TIPOHABIL_RESPONSABLE_OP_CARGA.intValue()) {
                    // @INC000001034925@INDRA.SCEXU9D.SDC@18/08/2015@FIN

                    String aux = checkAlcanceCargador(codAlcanceHab);
                    if(aux != null) {
                        errors.add(aux);
                    }
                } else if(codTipoHabil.intValue() == MultivalueCts.T123_TIPOHABIL_OPERADOR_VEHICULO_MANIOBRAS.intValue()){

                    try {
                        Integer.valueOf(codAlcanceHab);
                    } catch (NumberFormatException e) {
                        errors.add(ValidatorInfoCts.ERROR_MSG_ALCANCE_OP_VEHIC_MANIOBRAS);
                    }
                }
            }
        }

        // Comprobamos el codigo del estado
        if(null != codEstado) {

            if(codEstado.intValue() != MultivalueCts.T116_ESTADOS_SUSPENDIDO.intValue()
                    && codEstado.intValue() != MultivalueCts.T116_ESTADOS_REVOCADO.intValue()
                    && codEstado.intValue() != MultivalueCts.T116_ESTADOS_RENOVADO.intValue()
                    && codEstado.intValue() != MultivalueCts.T116_ESTADOS_REACTIVADO.intValue()
                    && codEstado.intValue() != MultivalueCts.T116_ESTADOS_OTORGADO.intValue()) {

                errors.add(ValidatorInfoCts.ERROR_MSG_ESTADO_INCORRECT);
            }
        }

        ValidationResult result = null;
        if(errors.isEmpty())
            result = new ValidationResult(true, errors);
        else
            result = new ValidationResult(false, errors);

        return result;
    }

    private String checkAlcanceLinea(String cdgoAlcance)  {


        List<Tbasg127LineasDto> lineas = this.tbasg127LineasService.getLineas(cdgoAlcance);

        if(lineas.isEmpty()) {

            return ValidatorInfoCts.ERROR_MSG_ALCANCE_INFR_LINEA_INCORRECT;
        }
        return null;
    }

    private String checkAlcanceEntorno(String cdgoAlcance) {


        List<Tbasg129EntornosDto> entorno = this.tbasg129EntornosService.getEntornosByNomCorto(cdgoAlcance);

        if(entorno.isEmpty()) {

            return ValidatorInfoCts.ERROR_MSG_ALCANCE_INFR_ENTORNO_INCORRECT;
        }
        return null;
    }

    private String checkAlcanceMaterial(String cdgoAlcance) {

        if(cdgoAlcance.trim().length() != 3){

            return ValidatorInfoCts.ERROR_MSG_ALCANCE_MATERIAL_INCORRECT;
        } else {

            String cdgoSerie = cdgoAlcance.trim();
            logger.debug("cdgoSerie: " + cdgoSerie);
            logger.debug("this.tbasg133SerieService");
            logger.debug(this.tbasg133SerieService.toString());
            logger.debug(new Gson().toJson(this.tbasg133SerieService.getSerie(cdgoSerie)));
            List<Tbasg133SerieDto> listSerie = this.tbasg133SerieService.getSerie(cdgoSerie);

            if(listSerie.isEmpty()) {
                return ValidatorInfoCts.ERROR_MSG_ALCANCE_MATERIAL_INCORRECT;
            }
        }
        return null;
    }

    private String checkAlcanceOT(String cdgoAlcance) {

        Integer codigo = null;

        try {
            codigo = new Integer(cdgoAlcance);
        } catch (NumberFormatException e) {
            // cod de alcance incorrecto
        }

        List<Tbasg131AlcanceotDto> alcanceOT = null;

        if(codigo != null && codigo.intValue() != 1) {

           alcanceOT = this.tbasg131AlcanceotService.getAlcanceOt(codigo);

        }

        if(alcanceOT.isEmpty()) {

            return ValidatorInfoCts.ERROR_MSG_ALCANCE_AOT_INCORRECT;
        }
        return null;
    }

    private String checkAlcanceCargador(String cdgoAlcance)  {

        Integer codigo = null;

        try {
            codigo = new Integer(cdgoAlcance);
        } catch (NumberFormatException e) {
            // cod de alcance incorrecto
        }

        List<Tbasg137EspecialiDto> especiali = null;

        if(codigo != null && codigo.intValue() != 1) {

            especiali = this.tbasg137EspecialiService.getEspeciali(codigo);

        }

        if(especiali.isEmpty()) {

            return ValidatorInfoCts.ERROR_MSG_ALCANCE_CARGADOR_INCORRECT;
        }
        return null;
    }
}