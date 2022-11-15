package renfe.com.util;

public abstract class ResponseCts {

    // BUNDLE NAME
    public static final String BUNDLE_NAME_ASG_MESSAGE = "locale/responseMsg";

    // CONSTANTS
    public static final Integer OK 						= new Integer(0);
    public static final Integer DATA_VALIDATION_ERRORS 	= new Integer(1);
    public static final Integer LINE_NOT_EXIST 			= new Integer(2);
    public static final Integer CENT_MEDIC_NOT_EXIST 	= new Integer(3);
    public static final Integer CENT_FORMA_NOT_EXIST 	= new Integer(4);
    public static final Integer NIF_PAS_NOT_FOUND 		= new Integer(5);
    public static final Integer ALREADY_HAVE_TITLE 		= new Integer(6);
    public static final Integer UNKNOWN_TIPO_TITULO 	= new Integer(7);
    public static final Integer INCORRECT_CDGO_ESTADO 	= new Integer(8);
    public static final Integer ESTACION_NOT_EXIST 		= new Integer(9);
    public static final Integer NOT_HAVE_TITLE 			= new Integer(10);
    public static final Integer PDF_KO 					= new Integer(11);
}
