package renfe.com.util;

import java.awt.Color;

import com.lowagie.text.Element;

public abstract class OrdenSuspensionPdfCts {

    // IMAGES
    public static final String LOGO = "/9j/4AAQSkZJRgABAgEASABIAAD/7QeiUGhvdG9zaG9wIDMuMAA4QklNA+0AAAAAABAASAAAAAEAAgBIAAAAAQACOEJJTQQNAAAAAAAEAAAAeDhCSU0D8wAAAAAACAAAAAAAAAAAOEJJTQQKAAAAAAABAAA4QklNJxAAAAAAAAoAAQAAAAAAAAACOEJJTQP1AAAAAABIAC9mZgABAGxmZgAGAAAAAAABAC9mZgABAKGZmgAGAAAAAAABADIAAAABAFoAAAAGAAAAAAABADUAAAABAC0AAAAGAAAAAAABOEJJTQP4AAAAAABwAAD/////////////////////////////A+gAAAAA/////////////////////////////wPoAAAAAP////////////////////////////8D6AAAAAD/////////////////////////////A+gAADhCSU0EAAAAAAAAAgABOEJJTQQCAAAAAAAEAAAAADhCSU0ECAAAAAAAEAAAAAEAAAJAAAACQAAAAAA4QklNBBQAAAAAAAQAAAACOEJJTQQMAAAAAAX0AAAAAQAAAHAAAAAsAAABUAAAOcAAAAXYABgAAf/Y/+AAEEpGSUYAAQIBAEgASAAA/+4ADkFkb2JlAGSAAAAAAf/bAIQADAgICAkIDAkJDBELCgsRFQ8MDA8VGBMTFRMTGBEMDAwMDAwRDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAENCwsNDg0QDg4QFA4ODhQUDg4ODhQRDAwMDAwREQwMDAwMDBEMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwM/8AAEQgALABwAwEiAAIRAQMRAf/dAAQAB//EAT8AAAEFAQEBAQEBAAAAAAAAAAMAAQIEBQYHCAkKCwEAAQUBAQEBAQEAAAAAAAAAAQACAwQFBgcICQoLEAABBAEDAgQCBQcGCAUDDDMBAAIRAwQhEjEFQVFhEyJxgTIGFJGhsUIjJBVSwWIzNHKC0UMHJZJT8OHxY3M1FqKygyZEk1RkRcKjdDYX0lXiZfKzhMPTdePzRieUpIW0lcTU5PSltcXV5fVWZnaGlqa2xtbm9jdHV2d3h5ent8fX5/cRAAICAQIEBAMEBQYHBwYFNQEAAhEDITESBEFRYXEiEwUygZEUobFCI8FS0fAzJGLhcoKS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kRRQVMYgU6YtC8ezq+53G4zzXd7yvtcl3Ias5jkBJ9TSUAk+dRnz6F28+8S7/e3W6bv7bcuTbrMdTzGCcOzfxsEuFRmPmSprxNT1ZP1psOHrPZWE2VBuje+9hh0qBLursbctXu3eeaqKurnrJ6zN52rSJqmYy1BVEjjighiVY440RQAD7y5N5cyXBhjjDfhjUKgxSgUcP5knJNeoo3XcW3W/uL9rS3g8Qj9OBBHEgAAARBwGM1JJNSSSel/7T9F/Xvfuvde9+691737r3X//1N/j37r3Xvfuvde9+691737r3Xvfuvde9+691737r3QP937U7h3rsOq2/wBIduYPpHetZW0l9/5rrGDtk4/Dr5f4jTYja9bvDZ+MizdTdPBWVclbT0+ltVJKWBRdt01hb3Ky7lYNc24B7BJ4VT5VYI50+oFCf4h0d8v3mx2G4pc8wbLJuFgqn9FLg22pvwlpBFK2geaqFZvJ18yu/Cj+XL0f8JazsDe+2a7dfaPfHcWTr813B8guz62ly3Y++8hlMrLncjA0tFS0eMwGCqc1UNUtR0cMYmlWNqh53ijdTnmPmzcuY1tLadUh2u3ULFBGKRoAKDjUsaYqTjNAAT0LefvdHmHn6PbbC7jhtOXbFFS2s7cFYIVVQimhJZ3CimpiaCoUKCQbAvYY6jfr3v3Xuve/de697917r3v3Xuve/de697917r//1d/j37r3Xvfuvde9+691737r3Xvfuvde9+691737r3Xvfuvde9+691737r3Xvfuvde9+691737r3Xvfuvde9+691737r3X//2Q==";
    
    // DEFAULT VALUES
    public static final String DEFAULT_FONT_FAMILY = "Arial";
    public static final float DEFAULT_FONT_SIZE = 10;
    public static final int DEFAULT_ALIGNMENT = Element.ALIGN_JUSTIFIED;
    
    public static final Color COLOR_FONDO = new Color(140,0,75);
    public static final Color COLOR_FONDO_TABLA = new Color(220, 220, 220);
    public static final Color COLOR_BLANCO = new Color(255,255,255);
    
    public static final String DATE_NOT_FILL = "__________";

    // CTS BUNDLE
    public static final String BUNDLE_NAME = "locale/OrdenSuspension";

    // CONSTANTES FIJAS
    public static final String BUNDLE_CTS_0_1 				= "ordenSuspension.text.0_1";
    public static final String BUNDLE_CTS_0_2 				= "ordenSuspension.text.0_2";
    public static final String BUNDLE_CTS_0_3 				= "ordenSuspension.text.0_3";
    public static final String BUNDLE_CTS_0_4 				= "ordenSuspension.text.0_4";
    public static final String BUNDLE_CTS_0_5 				= "ordenSuspension.text.0_5";
    public static final String BUNDLE_CTS_0_6 				= "ordenSuspension.text.0_6";
    public static final String BUNDLE_CTS_0_7 				= "ordenSuspension.text.0_7";
    
    public static final String BUNDLE_CTS_2 					= "ordenSuspension.text.2";
    
    public static final String BUNDLE_CTS_4 					= "ordenSuspension.text.4";
    
    public static final String BUNDLE_CTS_6 					= "ordenSuspension.text.6";
    
    public static final String BUNDLE_CTS_7 					= "ordenSuspension.text.7";
    
    public static final String BUNDLE_CTS_8_1				= "ordenSuspension.text.8_1";
    public static final String BUNDLE_CTS_8_2				= "ordenSuspension.text.8_2";
    public static final String BUNDLE_CTS_8_3				= "ordenSuspension.text.8_3";
    public static final String BUNDLE_CTS_8_4				= "ordenSuspension.text.8_4";
    public static final String BUNDLE_CTS_8_5				= "ordenSuspension.text.8_5";

    public static final String BUNDLE_CTS_9_1 				= "ordenSuspension.text.9_1";
    public static final String BUNDLE_CTS_9_2 				= "ordenSuspension.text.9_2";
    public static final String BUNDLE_CTS_9_3 				= "ordenSuspension.text.9_3";

    public static final String BUNDLE_CTS_10 				= "ordenSuspension.text.10";

    public static final String BUNDLE_CTS_11 				= "ordenSuspension.text.11";

    public static final String BUNDLE_CTS_12 				= "ordenSuspension.text.12";

    public static final String BUNDLE_CTS_13_1 				= "ordenSuspension.text.13_1";
    public static final String BUNDLE_CTS_13_2 				= "ordenSuspension.text.13_2";
    
    public static final String BUNDLE_CTS_P2_0 				= "ordenSuspension.text.2.0";
    
    public static final String BUNDLE_CTS_P2_1 				= "ordenSuspension.text.2.1";
    
    public static final String BUNDLE_CTS_P2_2 				= "ordenSuspension.text.2.2";
    
    public static final String BUNDLE_CTS_P2_3 				= "ordenSuspension.text.2.3";
    
    public static final String BUNDLE_CTS_P2_4 				= "ordenSuspension.text.2.4";
    public static final String BUNDLE_CTS_P2_4_1				= "ordenSuspension.text.2.4_1";
    public static final String BUNDLE_CTS_P2_4_2				= "ordenSuspension.text.2.4_2";
    public static final String BUNDLE_CTS_P2_4_3				= "ordenSuspension.text.2.4_3";
    public static final String BUNDLE_CTS_P2_4_4				= "ordenSuspension.text.2.4_4";
    
    public static final String BUNDLE_CTS_P2_5 				= "ordenSuspension.text.2.5";

    public static final String BUNDLE_CTS_P2_6 				= "ordenSuspension.text.2.6";
    
    public static final String BUNDLE_CTS_P2_7 				= "ordenSuspension.text.2.7";
    
    public static final String BUNDLE_CTS_P2_8 				= "ordenSuspension.text.2.8";

    public static final String BUNDLE_CTS_P2_9 				= "ordenSuspension.text.2.9";

    public static final String BUNDLE_CTS_P2_10 				= "ordenSuspension.text.2.10";

    
	public static final int ID_DOCUMENTO						= 1;
	
    // CONSTANTES DEFINIDAS
	public static final String C_001_NOMBRE_CABECERA			= "001_NOMBRE_CABECERA";
	public static final String C_002_CARGO_CABECERA				= "002_CARGO_CABECERA";
	public static final String C_003_DESTINATARIO_NOMBRE		= "003_DESTINATARIO_NOMBRE";
	public static final String C_004_DESTINATARIO_CARGO			= "004_DESTINATARIO_CARGO";
    public static final String C_005_DESTINATARIO_AREA			= "005_DESTINATARIO_AREA";
    public static final String C_006_CC_NOMBRE					= "006_CC_NOMBRE";
    public static final String C_007_CC_CARGO					= "007_CC_CARGO";
    public static final String C_008_CC_AREA					= "008_CC_AREA";
    public static final String C_009_ESTIMADO_NOMBRE			= "009_ESTIMADO_NOMBRE";
    public static final String C_010_ORDENANTE					= "010_ORDENANTE";
    public static final String C_011_MOTIVO_SUSPENSION			= "011_MOTIVO_SUSPENSION";
    public static final String C_012_PLAZO_SUSPENSION			= "012_PLAZO_SUSPENSION";
    public static final String C_013_CONDICIONES_REACTIVACION	= "013_CONDICIONES_REACTIVACION";
    public static final String C_014_FIRMADO_AREA				= "014_FIRMADO_AREA";
    
    // VARIABLES USUARIO
    public static final Integer V_NUMERO_DOCUMENTO				= new Integer(1);
    public static final Integer V_ANYO_REFERENCIA				= new Integer(2);
    public static final Integer V_FECHA_DOCUMENTO				= new Integer(3);
    public static final Integer V_ASUNTO						= new Integer(4);
    public static final Integer V_FECHA_ENTRADA					= new Integer(5);
    public static final Integer V_FECHA_EFECTIVA				= new Integer(6);
    public static final Integer V_HABILITACION_A_SUSPENDER		= new Integer(7);
    public static final Integer V_MOTIVO_SUSPENSION				= new Integer(8);
    public static final Integer V_PLAZO_SUSPENSION				= new Integer(9);
    public static final Integer V_CONDICIONES_REACTIVACION		= new Integer(10);
    public static final Integer V_NOMBRE_ORDENANTE				= new Integer(11);
    public static final Integer V_CARGO_ORDENANTE				= new Integer(12);
    public static final Integer V_DEPARTAMENTO_ORDENANTE		= new Integer(13);
    public static final Integer V_NOMBRE_DESTINATARIO			= new Integer(14);
    public static final Integer V_CARGO_DESTINATARIO			= new Integer(15);
    public static final Integer V_DIRECCION_GENERAL_DESTINATARIO	= new Integer(16);
    public static final Integer V_NOMBRE_PILA_DESTINATARIO			= new Integer(17);
    public static final Integer V_RESPONSABLE_GERENCIA_TERRITORIAL	= new Integer(18);
    public static final Integer V_NOMBRE_GERENCIA_TERRITORIAL		= new Integer(19);
    public static final Integer V_DIRECCION_GERENCIA_TERRITORIAL	= new Integer(20);
    public static final Integer V_ARTICULO_SUSPENSION				= new Integer(21);
    public static final Integer V_SUSPENDIDO_CAUTELARMENTE			= new Integer(22);
    public static final Integer V_CIRCULAR_OPERATIVA_NUM_1			= new Integer(23);

}
