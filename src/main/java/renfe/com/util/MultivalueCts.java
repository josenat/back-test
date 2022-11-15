package renfe.com.util;

public abstract class MultivalueCts {
    
    // TIPO DE TITULO
    public static final String T102_TIPO_TITULO_A	= "A";
    public static final String T102_TIPO_TITULO_B	= "B";
    
    // TIPO INFRAESTRUCTURA
    public static final String T104_TIPO_INFR_LINEA 	= "L";
    public static final String T104_TIPO_INFR_ENTORNO 	= "E";
    public static final String T104_TIPO_INFR_TRAMOS 	= "T";
    
    // PROVINCIA
    public static final Integer T106_PROVINCIA_EXTRANJERO = new Integer(53);
    public static final Integer T106_PROVINCIA_GENERICA = new Integer(99);
    
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

    // MOTIVOS PSICOFISICO
    public static final Integer T110_PSICOMOTI_OBTENCION 		= new Integer(1);
    public static final Integer T110_PSICOMOTI_RENOVACION 		= new Integer(2);
    public static final Integer T110_PSICOMOTI_REACTIVACION 	= new Integer(3);
    public static final Integer T110_PSICOMOTI_REC_ADICIONAL 	= new Integer(4);
    
    // CALIFICACIONES
    public static final Integer T115_CALIFICAC_REVISION_APTO_SIN_LIMIT_TEMP 	= new Integer(1);
    public static final Integer T115_CALIFICAC_REVISION_APTO_CON_LIMIT_TEMP 	= new Integer(2);
    public static final Integer T115_CALIFICAC_REVISION_NO_APTO_SIN_LIMIT_TEMP 	= new Integer(3);
    public static final Integer T115_CALIFICAC_REVISION_NO_APTO_CON_LIMIT_TEMP 	= new Integer(4);
   
    public static final Integer T115_CALIFICAC_RECICLAJES_SUPERADO 				= new Integer(5);
    public static final Integer T115_CALIFICAC_RECICLAJES_PENDIENTE 			= new Integer(6);
    public static final Integer T115_CALIFICAC_RECICLAJES_NO_SUPERADO 			= new Integer(7);

    public static final Integer T115_CALIFICAC_CURSOS_APTO 						= new Integer(8);
    public static final Integer T115_CALIFICAC_CURSOS_PENDIENTE 				= new Integer(9);
    public static final Integer T115_CALIFICAC_CURSOS_NO_APTO 					= new Integer(10);
    public static final Integer T115_CALIFICAC_GENERICA 						= new Integer(11);
    
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
    // RNF09-000005197 RFASG001
    public static final Integer T116_ESTADOS_SUSPENSION_CAUTELAR    = new Integer(20);
    // Fin RNF09-000005197 
    
    // TIPO DE HABILITACIONES
    public static final Integer T123_TIPOHABIL_CONDUCCION_INFRAESTRUCTURA 	= new Integer(1);
    public static final Integer T123_TIPOHABIL_CONDUCCION_MATERIAL 			= new Integer(2);
    public static final Integer T123_TIPOHABIL_AUX_OPERACIONES_TREN 		= new Integer(3);
    public static final Integer T123_TIPOHABIL_CARGADOR 					= new Integer(4);
    public static final Integer T123_TIPOHABIL_OPERADOR_VEHICULO_MANIOBRAS 	= new Integer(5);      
    public static final Integer T123_TIPOHABIL_RESPONSABLE_OPERACIONES_CARGA = new Integer(7);
    public static final Integer T123_TIPOHABIL_RECICLAJE_TITULO_CONDUCCION 	= new Integer(9);
    public static final Integer T123_TIPOHABIL_AUXILIAR_CABINA	 	= new Integer(10);
    public static final Integer T123_TIPOHABIL_AUX_CABINA_ALCANCE_AMPLIADO 	= new Integer(11);
    public static final Integer T123_TIPOHABIL_AOT_MANIOBRAS_AYUDA_CABINA 	= new Integer(12);
     
    // NACIÓN
    public static final Integer T134_NACION_SPAIN = new Integer(67);
    
    // TIPO DE DEPENDENCIA
    public static final Integer T140_TIPO_DEPENDENCIA_GENERICA = new Integer(1);
    
    // TIPO DE CURSO
    public static final String T146_TIPO_CURSO_TEORICO				= "TE";
    public static final String T146_TIPO_CURSO_PRACTICO				= "PR";
    public static final String T146_TIPO_CURSO_TEORICO_PRACTICO		= "TP";
    public static final String T146_TIPO_CURSO_TEORICO_Y_PRACTICO	= "TYP";
    public static final String T146_TIPO_CURSO_RECICLAJE			= "RE";
    public static final String T146_TIPO_CURSO_TITULO_CONDUCCION	= "TC";
    
    // TIPO ACREDITACIÓN
    public static final String T262_PERSONAL_AUTORIZ_PUERTOS		= "05";
    public static final String T262_AUXILIAR_CIRCULACION_FGR		= "06";
    public static final String T262_CONDUCTOR_TRANVIAS      		= "07";
    public static final String T262_AUXILIAR_CIRCULACION        	= "08";
            
    // TIPO DE DOCUMENTO (IDENTIFICATIVO)
    public static final Integer T150_TIPODOC_NIF 							= new Integer(1);
    public static final Integer T150_TIPODOC_NIE 							= new Integer(2);
    public static final Integer T150_TIPODOC_PASAPORTE 						= new Integer(3);
    public static final Integer T150_TIPODOC_TARJETA_RESIDENTE_COMUNITARIO 	= new Integer(4);
    public static final Integer T150_TIPODOC_PERMISO_RESIDENTE_Y_TRABAJO 	= new Integer(5);
    
    //ESTADOS ACREDITACIÓN
    public static final String T266_ACREDITACION_OTORGADA				= "01";
    public static final String T266_ACREDITACION_CADUCADA				= "02";
    public static final String T266_ACREDITACION_ABIERTA				= "03";
    
    //ESTADOS DE LA CALIFICACION
    public static final String T115_CALIFICACION_APTO  =  "8";
    public static final String T115_CALIFICACION_NO_APTO  =  "10";
    
    // ESPECIALIDADES
    public static final Integer T137_ESPECIALI_MERCANCIAS_PELIGROSAS	 	= new Integer(29);
    
    // EMPRESA RENFE
    public static final String T125_EMPRESA_RENFE			= "RENFE";
    public static final String T125_CIF_EMPRESA_RENFE		= "Q2801659J";
    
    // PROCESOS SAP
    public static final String SAP_HEALTH_PROCESS_NAME           = "I_SALU_1";  
    public static final String SAP_ACTIVE_STAFF_PROCESS_NAME     = "I_RRHH_1";   
    public static final String SAP_INACTIVE_STAFF_PROCESS_NAME   = "I_RRHH_2";
    public static final String SAP_TRAINING_PROCESS_NAME         = "I_FORM_1";
    // EVOL 70589
    public static final String SAP_DEPENDENCIAS_PROCESS_NAME = "I_DEP_1";
    
    public static final String ACREDITA_CADUC_PROCESS_NAME = "I_ACRE_1";
    public static final String ACREDITA_PROX_CADUC_PROCESS_NAME = "I_ACRE_2";
    
    public static final String ACREDITA_CADUC_DIARIA_PROCESS_NAME = "I_ACRE_3";
    
    // Constantes para el envío de correo electrónico
    public static final String SMTP_HOST = "mail.smtp.host";
    public static final String SMTP_PORT = "mail.smtp.port";
    public static final String SMTP_EMAIL_SENDER = "mail.smtp.mail.sender";
    public static final String SMTP_MAIL_SENDPARTIAL = "mail.smtp.sendpartial";
    public static final String SMTP_AUTH = "mail.smtp.auth";
    public static final String SMTP_MAIL_START_ENABLE = "mail.smtp.starttls.enable";
    public static final String PROTOCOL = "mail.smtp.protocol";
    public static final String SMTP_USER = "mail.smtp.user";
    public static final String SMTP_PASSWORD = "mail.smtp.password";
    public static final String SMTP_EMAIL_FROM = "mail.smtp.mail.from"; 
    public static final String SMTP_EMAIL_TO = "mail.smtp.mail.to";
    public static final String ASUNTO_MAIL = "Error en actualización tabla dependencias";
    public static final String SUBJECT = "mail.smtp.subject";
    public static final String SUBJECT2 = "mail.smtp.subject2";

    public static final String RESOURCE_DEPENDENCIAS = "ibatis/SqlMapConfigPAI.xml";
    public static final String CODIGO_CARGO= "K9B";
    // FIN EVOL 70589  
    
    //INICIO PPM 168672
    // Constantes para el envío de correo electrónico por Formacion Complementaria de Idiomas
    public static final String SMTP_HOST_IDIOMAS = "mail.smtp.host.idiomas";
    public static final String SMTP_PORT_IDIOMAS = "mail.smtp.port.idiomas";
    public static final String SMTP_EMAIL_SENDER_IDIOMAS = "mail.smtp.mail.sender.idiomas";
    public static final String SMTP_AUTH_IDIOMAS = "mail.smtp.auth.idiomas";
    public static final String PROTOCOL_IDIOMAS = "mail.smtp.protocol.idiomas";
    public static final String SMTP_USER_IDIOMAS = "mail.smtp.user.idiomas";
    public static final String SMTP_PASSWORD_IDIOMAS = "mail.smtp.password.idiomas";
    public static final String SMTP_EMAIL_FROM_IDIOMAS = "mail.smtp.mail.from.idiomas"; 
    public static final String SMTP_EMAIL_TO_IDIOMAS = "mail.smtp.mail.to.idiomas";
    public static final String SUBJECT_IDIOMAS = "mail.smtp.subject.idiomas";
    //FIN PPM 168672
    

    
    // EVOL 71914
    /**
    * Formato de fecha
    */
    public static final String FORMATO_FECHA = "yyyy-MM-dd";

    /**
    * Fecha nacimiento persona a dar de alta en TBASG100_PERSONA cuando se produce un error
    */
    public static final String FECHA_NAC_PERSONA = "1901-01-01";

    /**
    * Fecha contrato persona a dar de alta en TBASG100_PERSONA cuando se produce un error
    */
    public static final String FCHA_CONTRATO_PERSONA = "1901-01-01";

    /**
    * Nombre de la persona a dar de alta en TBASG100_PERSONA cuando se produce un error
    */
    public static final String T_NOMBRE_PERSONA = "SIN NOMBRE";

    /**
    * Primer apellido de la persona a dar de alta en TBASG100_PERSONA cuando se produce un error
    */
    public static final String T_APELL1_PERSONA = "SIN APELLIDO";

    /**
    * Código área activa de la persona a dar de alta en TBASG100_PERSONA cuando se produce un error
    */
    public static final Integer T_CDGO_AREACT = new Integer(0);
    // FIN EVOL 71914
    
    // FORMACIÓN COMPLEMENTARIA, CERTIFICADO DE IDIOMA 
    public static final Integer T155_FC_CATEGORIA_CERTIF_IDIOMA  = new Integer(1);
    public static final Integer T155_FC_CATEGORIA_CERTIF_SEGURIDAD_TREN = new Integer(2);
    public static final Integer T155_FC_CATEGORIA_CERTIF_IDIOMA_AOT  = new Integer(3);
    
    // ALCANCEOT
    public static final Integer T131_ALCANCEOT_CON_MANIOBRAS = new Integer(2);
    public static final Integer T131_ALCANCEOT_SIN_MANIOBRAS = new Integer(3);

    // @INC000001034925@INDRA.SCEXU9D.SDC@17/08/2015@INICIO
    // 107953 RQ0001 Responsable operaciones de carga
    // Nuevo tipo de habilitación --> responsable de operaciones de carga
    public static final Integer T123_TIPOHABIL_RESPONSABLE_OP_CARGA = new Integer(7);
    // @INC000001034925@INDRA.SCEXU9D.SDC@17/08/2015@FIN
}

