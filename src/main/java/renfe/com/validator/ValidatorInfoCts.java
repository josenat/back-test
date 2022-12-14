package renfe.com.validator;

abstract class ValidatorInfoCts {

    // MANDATORY
    protected static final String ERROR_MSG_TIPO_IDENTIF_MANDATORY 	= "TIPO DE IDENTIFICADOR OBLIGATORIO";
    protected static final String ERROR_MSG_NUM_IDENTIF_MANDATORY 	= "NÚMERO DE IDENTIFICACIÓN OBLIGATORIO";
    protected static final String ERROR_MSG_TIPO_INFRA_MANDATORY	= "PARA EL TIPO DE HABILITACIÓN 1 EL TIPO DE INFRAESTRUCTURA ES OBLIGATORIO";
    protected static final String ERROR_MSG_TIPO_HAB_MANDATORY 		= "EL TIPO DE HABILITACIÓN ES OBLIGATORIO CUANDO SE RELLENA EL ALCANCE";

    // INCORRECT
    protected static final String ERROR_MSG_TIPO_IDENTIF_INCORRECT 	= "TIPO DE IDENTIFICADOR INCORRECTO";
    protected static final String ERROR_MSG_NIF_INCORRECT 			= "NIF INCORRECTO";
    protected static final String ERROR_MSG_NIE_INCORRECT 			= "NIE INCORRECTO";
    protected static final String ERROR_MSG_MATRICULA_INCORRECT		= "MATRÍCULA INCORRECTA";
    protected static final String ERROR_MSG_TIPO_HABIL_INCORRECT 	= "CÓDIGO TIPO HABILITACIÓN INCORRECTO";
    protected static final String ERROR_MSG_TIPO_INFRA_INCORRECT 	= "TIPO DE INFRAESTRUCTURA INCORRECTO";
    protected static final String ERROR_MSG_ESTADO_INCORRECT 		= "CÓDIGO ESTADO INCORRECTO";

    protected static final String ERROR_MSG_ALCANCE_INFR_LINEA_INCORRECT 	= "ALCANCE DE LÍNEA INCORRECTO";
    protected static final String ERROR_MSG_ALCANCE_INFR_ENTORNO_INCORRECT 	= "ALCANCE DE ENTORNO INCORRECTO";
    protected static final String ERROR_MSG_ALCANCE_MATERIAL_INCORRECT 		= "ALCANCE DE MATERIAL INCORRECTO";
    protected static final String ERROR_MSG_ALCANCE_AOT_INCORRECT 			= "ALCANCE DE AUX. O.T. INCORRECTO";
    protected static final String ERROR_MSG_ALCANCE_CARGADOR_INCORRECT 		= "ALCANCE DE CARGADOR INCORRECTO";
    protected static final String ERROR_MSG_ALCANCE_OP_VEHIC_MANIOBRAS		= "ALCANCE DE OPERADOR DE VEHÍCULO DE MANIOBRAS INCORRECTO";

}
