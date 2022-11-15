package renfe.com.dto;

public class MultivalueCts {
	
	// AMBITOS PSICOFISICO    
    public static final Integer T109_PSICOAMBI_TIPO_1_EN_DESUSO = new Integer(1);
    public static final Integer T109_PSICOAMBI_TIPO_2_EN_DESUSO = new Integer(2);
    public static final Integer T109_PSICOAMBI_TIPO_3_EN_DESUSO = new Integer(3);
    public static final Integer T109_PSICOAMBI_TIPO_4_EN_DESUSO = new Integer(4);
    public static final Integer T109_PSICOAMBI_TIPO_5_EN_DESUSO = new Integer(5);
    public static final Integer T109_PSICOAMBI_TIPO_6_EN_DESUSO = new Integer(6);
    
    public static final Integer T109_PSICOAMBI_TIPO_1 = new Integer(7);
    public static final Integer T109_PSICOAMBI_TIPO_2 = new Integer(8);
    public static final Integer T109_PSICOAMBI_TIPO_3 = new Integer(9);
    public static final Integer T109_PSICOAMBI_TIPO_4 = new Integer(10);
    public static final Integer T109_PSICOAMBI_TIPO_5 = new Integer(11);
    
	// TIPO DE HABILITACIONES
    public static final Integer T123_TIPOHABIL_AUX_OPERACIONES_TREN = new Integer(3);
    
    // ALCANCEOT
    public static final Integer T131_ALCANCEOT_CON_MANIOBRAS = new Integer(2);
    public static final Integer T131_ALCANCEOT_SIN_MANIOBRAS = new Integer(3);
    
    // ESTADOS 
    public static final Integer T116_ESTADOS_ABIERTO 				= new Integer(1);
    public static final Integer T116_ESTADOS_CERRADO 				= new Integer(2);            
	public static final Integer T116_ESTADOS_SUSPENDIDO 			= new Integer(3);
    public static final Integer T116_ESTADOS_REVOCADO 				= new Integer(4);    
    public static final Integer T116_ESTADOS_RENOVADO 				= new Integer(5);
    public static final Integer T116_ESTADOS_VIGENTE 				= new Integer(6);           
	public static final Integer T116_ESTADOS_REACTIVADO 			= new Integer(7);    
    public static final Integer T116_ESTADOS_CONFIRMADO 			= new Integer(8);    
    public static final Integer T116_ESTADOS_OTORGADO 				= new Integer(9);            
    public static final Integer T116_ESTADOS_OTORGADO_RECHAZADO 	= new Integer(10);
    public static final Integer T116_ESTADOS_OTORGADO_ENVIADO 		= new Integer(11);    
    public static final Integer T116_ESTADOS_PENDIENTE_REACTIVAR	= new Integer(12);
    public static final Integer T116_ESTADOS_PENDIENTE_REVOCAR 		= new Integer(13);            
    public static final Integer T116_ESTADOS_PENDIENTE_SUSPENDER 	= new Integer(14); 
    public static final Integer T116_ESTADOS_PENDIENTE_RENOVAR 		= new Integer(15);
    public static final Integer T116_ESTADOS_PENDIENTE_CONFIRMAR 	= new Integer(16);    
    public static final Integer T116_ESTADOS_PROPUESTA_OTORGAMIENTO	= new Integer(17);
    public static final Integer T116_ESTADOS_PROPUESTA_RESOLUCION 	= new Integer(18);
    public static final Integer T116_ESTADOS_TRAMITACION 			= new Integer(19);
    public static final Integer T116_ESTADOS_SUSPENSION_CAUTELAR    = new Integer(20);

    // TIPO DE HABILITACIONES
    public static final Integer T123_TIPOHABIL_CONDUCCION_INFRAESTRUCTURA 	= new Integer(1);
    public static final Integer T123_TIPOHABIL_CONDUCCION_MATERIAL 			= new Integer(2);
    
 // Margenes temporales para la consulta de pendientes
 	public static final String PENDIENTE_NUMBER_MONTH_LOW_LEVEL = "PENDIENTE_NUMBER_MONTH_LOW_LEVEL";
 	public static final String PENDIENTE_NUMBER_MONTH_MEDIUM_LEVEL = "PENDIENTE_NUMBER_MONTH_MEDIUM_LEVEL";
 	public static final String PENDIENTE_NUMBER_MONTH_HIGH_LEVEL = "PENDIENTE_NUMBER_MONTH_HIGH_LEVEL";
 	
 	//DiccionarioCTS
 	public static final int VALUE_TABLA_124	   = 124;
 	public static final int VALUE_TABLA_128    = 128;
 	public static final int VALUE_TABLA_129    = 129;
 	public static final int VALUE_TABLA_131    = 131;
 	public static final int VALUE_TABLA_133    = 133;
 	public static final int VALUE_TABLA_137	   = 137;
 	public static final int VALUE_TABLA_170 	= 170;
 	public static final int VALUE_TABLA_256	   = 256;
 	public static final int VALUE_TABLA_257	   = 257;
 	
 	public static final int CTE_CADUCIDAD_CERTIFICADOS = 2;
}

