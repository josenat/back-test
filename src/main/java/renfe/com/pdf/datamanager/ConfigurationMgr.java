package renfe.com.pdf.datamanager;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import renfe.com.pdf.core.InitializationException;

public class ConfigurationMgr {
	
	private static ConfigurationMgr instance = null;	
	private DataSource dataSource = null;
	private Map values = null;
	
	private boolean useJNDI = true;
	private String jndiName = null;
	// File with Driver Manager configuration values
	private String dmConfigFile = null;	
	// Driver Manager configuration values
	private String dmDriver = null;
	private String dmUrl = null;
	private String dmUser = null;
	private String dmPassword = null;  
	
	public static final String DM_DRIVER_PROPERTY = "driver";
	public static final String DM_URL_PROPERTY = "url";
	public static final String DM_USER_PROPERTY = "user";
	public static final String DM_PASSWORD_PROPERTY = "password";	
	
	// TIPOS
	private static final String INTEGER_TYPE = "INTEGER";
	private static final String STRING_TYPE = "STRING";
	private static final String FLOAT_TYPE = "FLOAT";
	private static final String BOOLEAN_TYPE = "BOOLEAN";
	
	// ================================================================================================
	// 											CAMPOS
	// ================================================================================================
	
	// Nombre base de los ficheros de SAP
	public static final String FILE_NAME_PREFIX_SAP_SALUD 			= "FILE_NAME_PREFIX_SAP_SALUD";
	public static final String FILE_NAME_PREFIX_SAP_RRHH_ACTIVOS 	= "FILE_NAME_PREFIX_SAP_RRHH_ACTIVOS"; 
	public static final String FILE_NAME_PREFIX_SAP_RRHH_INACTIVOS 	= "FILE_NAME_PREFIX_SAP_RRHH_INACTIVOS"; 		
	public static final String FILE_NAME_PREFIX_SAP_FORMACION 		= "FILE_NAME_PREFIX_SAP_FORMACION";
	public static final String FILE_NAME_PREFIX_HABILITA_FORMACION 	= "FILE_NAME_PREFIX_HABILITA_FORMACION";	
	public static final String FILE_NAME_PREFIX_HABILITA_ALCANCE 	= "FILE_NAME_PREFIX_HABILITA_ALCANCE";
	public static final String FILE_NAME_PREFIX_ACREDITA_CADUCAD 	= "FILE_NAME_PREFIX_ACREDITA_CADUCAD";
	
	// Path de los ficheros de SAP
	public static final String PATH_FILE_SAP_SALUD 					= "PATH_FILE_SAP_SALUD";		
	public static final String PATH_FILE_SAP_RRHH_ACTIVOS			= "PATH_FILE_SAP_RRHH_ACTIVOS";
	public static final String PATH_FILE_SAP_RRHH_INACTIVOS			= "PATH_FILE_SAP_RRHH_INACTIVOS";
	public static final String PATH_FILE_SAP_FORMACION 				= "PATH_FILE_SAP_FORMACION";
	public static final String PATH_FILE_HABILITA_FORMACION 		= "PATH_FILE_HABILITA_FORMACION";
	public static final String PATH_FILE_ACREDITA_CADUCAD   		= "PATH_FILE_ACREDITA_CADUCAD";
	
	// RNF10-00004685 RQ ASGRF001: Crear proceso batch carga centros contables en bbdd
	// Path del fichero de entrada al proceso de carga de centros contables
	public static final String PATH_FILE_HABILITA_CENTROS_CONTABLES 		= "PATH_FILE_HABILITA_CENTROS_CONTABLES";
	// Nombre base deL fichero de entrada al proceso de carga de centros contables
	public static final String FILE_NAME_PREFIX_HABILITA_CENTROS_CONTABLES 	= "FILE_NAME_PREFIX_HABILITA_CENTROS_CONTABLES";
	// FIN RNF10-00004685 RQ ASGRF001
	
	// Valor multievaluado SAP SALUD, Motivo de la revisión
	public static final String MULTIVAL_SAP_SALUD_MOTIVO_REVISION_OBTENCION 				= "MULTIVAL_SAP_SALUD_MOTIVO_REVISION_OBTENCION";
	public static final String MULTIVAL_SAP_SALUD_MOTIVO_REVISION_RENOVACION 				= "MULTIVAL_SAP_SALUD_MOTIVO_REVISION_RENOVACION";
	public static final String MULTIVAL_SAP_SALUD_MOTIVO_REVISION_REACTIVACION 				= "MULTIVAL_SAP_SALUD_MOTIVO_REVISION_REACTIVACION";	
	public static final String MULTIVAL_SAP_SALUD_MOTIVO_REVISION_REC_FISICO_ADICIONAL_1 	= "MULTIVAL_SAP_SALUD_MOTIVO_REVISION_REC_FISICO_ADICIONAL_1";
	public static final String MULTIVAL_SAP_SALUD_MOTIVO_REVISION_REC_FISICO_ADICIONAL_2 	= "MULTIVAL_SAP_SALUD_MOTIVO_REVISION_REC_FISICO_ADICIONAL_2";
	public static final String MULTIVAL_SAP_SALUD_MOTIVO_REVISION_REC_FISICO_ADICIONAL_3 	= "MULTIVAL_SAP_SALUD_MOTIVO_REVISION_REC_FISICO_ADICIONAL_3";
	public static final String MULTIVAL_SAP_SALUD_MOTIVO_REVISION_REC_FISICO_ADICIONAL_4 	= "MULTIVAL_SAP_SALUD_MOTIVO_REVISION_REC_FISICO_ADICIONAL_4";
	                                   		
	// Valor multievaluado SAP SALUD, Calificación
	public static final String MULTIVAL_SAP_SALUD_CALIFICACION_APTO_SIN_LIMIT_TEMP 		= "MULTIVAL_SAP_SALUD_CALIFICACION_APTO_SIN_LIMIT_TEMP";
	public static final String MULTIVAL_SAP_SALUD_CALIFICACION_APTO_CON_LIMIT_TEMP 		= "MULTIVAL_SAP_SALUD_CALIFICACION_APTO_CON_LIMIT_TEMP";
	public static final String MULTIVAL_SAP_SALUD_CALIFICACION_NO_APTO_SIN_LIMIT_TEMP 	= "MULTIVAL_SAP_SALUD_CALIFICACION_NO_APTO_SIN_LIMIT_TEMP";
	public static final String MULTIVAL_SAP_SALUD_CALIFICACION_NO_APTO_CON_LIMIT_TEMP 	= "MULTIVAL_SAP_SALUD_CALIFICACION_NO_APTO_CON_LIMIT_TEMP";
	
	// Valor multievaluado SAP SALUD, Ambito de validez del  certificado
	public static final String MULTIVAL_SAP_SALUD_AMBITO_VALIDEZ_CERTIFICADO_TIPO_1 = "MULTIVAL_SAP_SALUD_AMBITO_VALIDEZ_CERTIFICADO_TIPO_1";
	public static final String MULTIVAL_SAP_SALUD_AMBITO_VALIDEZ_CERTIFICADO_TIPO_2 = "MULTIVAL_SAP_SALUD_AMBITO_VALIDEZ_CERTIFICADO_TIPO_2";
	public static final String MULTIVAL_SAP_SALUD_AMBITO_VALIDEZ_CERTIFICADO_TIPO_3 = "MULTIVAL_SAP_SALUD_AMBITO_VALIDEZ_CERTIFICADO_TIPO_3";
	public static final String MULTIVAL_SAP_SALUD_AMBITO_VALIDEZ_CERTIFICADO_TIPO_4 = "MULTIVAL_SAP_SALUD_AMBITO_VALIDEZ_CERTIFICADO_TIPO_4";
	public static final String MULTIVAL_SAP_SALUD_AMBITO_VALIDEZ_CERTIFICADO_TIPO_5 = "MULTIVAL_SAP_SALUD_AMBITO_VALIDEZ_CERTIFICADO_TIPO_5";
	public static final String MULTIVAL_SAP_SALUD_AMBITO_VALIDEZ_CERTIFICADO_TIPO_6 = "MULTIVAL_SAP_SALUD_AMBITO_VALIDEZ_CERTIFICADO_TIPO_6";
		
	// Valor multievaluado SAP PERSONAL INACTIVO, Medida Baja
	public static final String MULTIVAL_SAP_PER_INAC_MEDIDA_BAJA_SUBVENCIONADA 	= "MULTIVAL_SAP_PER_INAC_MEDIDA_BAJA_SUBVENCIONADA"; 
	public static final String MULTIVAL_SAP_PER_INAC_MEDIDA_BAJA_DEFINITIVA 	= "MULTIVAL_SAP_PER_INAC_MEDIDA_BAJA_DEFINITIVA"; 
	public static final String MULTIVAL_SAP_PER_INAC_MEDIDA_BAJA_EXCEDENCIA 	= "MULTIVAL_SAP_PER_INAC_MEDIDA_BAJA_EXCEDENCIA"; 
	
	// Margenes temporales para la consulta de pendientes
	public static final String PENDIENTE_NUMBER_MONTH_LOW_LEVEL = "PENDIENTE_NUMBER_MONTH_LOW_LEVEL";
	public static final String PENDIENTE_NUMBER_MONTH_MEDIUM_LEVEL = "PENDIENTE_NUMBER_MONTH_MEDIUM_LEVEL";
	public static final String PENDIENTE_NUMBER_MONTH_HIGH_LEVEL = "PENDIENTE_NUMBER_MONTH_HIGH_LEVEL";
	
	// Valores para la generación de documentos PDF
	public static final String PDF_SOLICITUD_HAB_DESTINATARIO = "PDF_SOLICITUD_HAB_DESTINATARIO";
	public static final String PDF_SOLICITUD_HAB_CARGO_DESTINATARIO = "PDF_SOLICITUD_HAB_CARGO_DESTINATARIO";
	
	// Fotos Personal
	public static final String PATH_FILE_FOTOS_PERSONAL = "PATH_FILE_FOTOS_PERSONAL";
	public static final String PATH_FILE_FOTOS_PERSONAL_EXTERNO = "PATH_FILE_FOTOS_PERSONAL_EXTERNO";
	public static final String PATH_FILE_FOTOS_PERSONAL_PDF = "PATH_FILE_FOTOS_PERSONAL_PDF";
	
	// Valores de configuración de los schedulers
	public static final String SCHEDULER_HORA_HAB_CADUCADAS = "SCHEDULER_HORA_HAB_CADUCADAS";
	public static final String SCHEDULER_HORA_DATOS_FIJOS_BD = "SCHEDULER_HORA_DATOS_FIJOS_BD";		
	
	public static final String SCHEDULER_FLAG_EXECUTE_HORA_HAB_CADUCADAS = "SCHEDULER_FLAG_EXECUTE_HORA_HAB_CADUCADAS";		
	public static final String SCHEDULER_FLAG_EXECUTE_DATOS_FIJOS_BD = "SCHEDULER_FLAG_EXECUTE_DATOS_FIJOS_BD";	
	
	public static final String SCHEDULER_FLAG_EXECUTE_WS_REF_ALTA_HAB = "SCHEDULER_FLAG_EXECUTE_WS_REF_ALTA_HAB";
	public static final String SCHEDULER_FLAG_EXECUTE_WS_REF_MODIF_DOMICILIO_TIT_COND = "SCHEDULER_FLAG_EXECUTE_WS_REF_MODIF_DOMICILIO_TIT_COND";
	public static final String SCHEDULER_FLAG_EXECUTE_WS_REF_MODIF_HAB = "SCHEDULER_FLAG_EXECUTE_WS_REF_MODIF_HAB";
	public static final String SCHEDULER_FLAG_EXECUTE_WS_REF_RENOV_TIT_COND = "SCHEDULER_FLAG_EXECUTE_WS_REF_RENOV_TIT_COND";
	
	// WEB SERVICE REF (SERVICIO DEL MINISTERIO)
	public static final String WEB_SERVICE_REF_END_POINT = "WEB_SERVICE_REF_END_POINT";
	
	// Tamaño de página para los menús de firma eletrónica (confirmación y otorgamiento)
	public static final String PAGE_SIZE_FOR_ELECTRONIC_SIGNATURE = "PAGE_SIZE_FOR_ELECTRONIC_SIGNATURE";
	
	// Ficheros de salida de Personal, habilitaciones generales, de material y de habilitación de infraestructuras.
	// Fichero zip de los ficheros de salida
	public static final String PATH_FILE_REF_ZIP = "PATH_FILE_REF_ZIP";
	public static final String PATH_FILE_REF_TMP = "PATH_FILE_REF_TMP";
	public static final String FILE_NAME_PREFIX_REF_PERSONAL = "FILE_NAME_PREFIX_REF_PERSONAL";
	public static final String FILE_NAME_PREFIX_REF_HAB_GENERAL = "FILE_NAME_PREFIX_REF_HAB_GENERAL";
	public static final String FILE_NAME_PREFIX_REF_HAB_MATERIAL = "FILE_NAME_PREFIX_REF_HAB_MATERIAL";
	public static final String FILE_NAME_PREFIX_REF_HAB_INFRAESTRUCTURA = "FILE_NAME_PREFIX_REF_HAB_INFRAESTRUCTURA";
	public static final String FILE_NAME_PREFIX_REF_ZIP = "FILE_NAME_PREFIX_REF_ZIP";
	
	public static final String PATH_FILE_ACRE_CADUC = "PATH_FILE_ACRE_CADUC";
	public static final String FILE_NAME_PREFIX_ACRE_CADUC = "FILE_NAME_PREFIX_ACRE_CADUC";
	public static final String FILE_NAME_PREFIX_PROX_CADUC = "FILE_NAME_PREFIX_PROX_CADUC";
	
	// Nuevo flag SHOW_ALL_EXPEDIENT define si todos los usuarios acceden a nuevos expedientes o sólo a los que 
	// tengan acceso por su sociedad otorgante
	public static final String SHOW_ALL_EXPEDIENT="SHOW_ALL_EXPEDIENT";
	
	// Interesa
	public static final String INTERESA_BUZON_DEFECTO = "INTERESA_BUZON_DEFECTO";
	
	//================================================================================================	
	
	private ConfigurationMgr() {
		super();
	}
	
	public static ConfigurationMgr getInstance(){
		
		if(instance == null){
			instance = new ConfigurationMgr();
		}
		return instance;
	}	
	
	public void initJNDI(String jndiName) throws InitializationException {
			
	    this.dataSource = null;
	    this.useJNDI = true;
		try {
			
			if(jndiName == null){
				throw new InitializationException("JNDI name is NULL");
			}
								
			this.jndiName = jndiName;				
			this.values = new HashMap();
			loadTable();
			
		} catch (RuntimeException e) {
			throw new InitializationException(e);
		}
	}
	
	public void initDriverMgr(String configFile) throws InitializationException {
	    
	    this.dataSource = null;
	    this.useJNDI = false;
	    try {
	        
	        if(configFile == null){
	            throw new InitializationException("Configuration File name is NULL");
	        }
	        
	        this.dmConfigFile = configFile;
	        
	        InputStream inputStream = ConfigurationMgr.class.getClassLoader().getResourceAsStream(this.dmConfigFile);
	        Properties properties = new Properties();
	        try {
                properties.load(inputStream);
            } catch (IOException e1) {
                throw new InitializationException("Error loading properties in file: " + this.dmConfigFile);
            }
	        this.dmDriver = properties.getProperty(DM_DRIVER_PROPERTY);
	        if(this.dmDriver == null){
	            throw new InitializationException("Error loading properties in file " + this.dmConfigFile 
	                    + " property " + DM_DRIVER_PROPERTY + " not found");
	        }
	        this.dmUrl = properties.getProperty(DM_URL_PROPERTY);
	        if(this.dmUrl == null){
	            throw new InitializationException("Error loading properties in file " + this.dmConfigFile 
	                    + " property " + DM_URL_PROPERTY + " not found");
	        }
	        this.dmUser = properties.getProperty(DM_USER_PROPERTY);
	        if(this.dmUser == null){
	            throw new InitializationException("Error loading properties in file " + this.dmConfigFile 
	                    + " property " + DM_USER_PROPERTY + " not found");
	        }
	        this.dmPassword = properties.getProperty(DM_PASSWORD_PROPERTY);
	        if(this.dmPassword == null){
	            throw new InitializationException("Error loading properties in file " + this.dmConfigFile 
	                    + " property " + DM_PASSWORD_PROPERTY + " not found");
	        }	        
	        	        
	        this.values = new HashMap();
	        loadTable();
	        
	    } catch (RuntimeException e) {
	        throw new InitializationException(e);
	    }
	}	
	
	private DataSource getDataSource() {
		
	    if (dataSource == null) {
	        
	        if(this.useJNDI){
	            
	            Context ctx = null;	           
	            try {
	                ctx = new InitialContext();
	                dataSource = (DataSource) ctx.lookup(this.jndiName);
	            } catch (NamingException e) {
	                
	                throw new RuntimeException("ConfigurationMgr: DataSource not found, JNDI name: " + this.jndiName);
	            }
	            
	        } else {
	            
	            try {
	    	        Class.forName(this.dmDriver).newInstance();
	    	    } catch (InstantiationException e) {
	    	        throw new RuntimeException("Error instantiating class " + this.dmDriver);
	    	    } catch (IllegalAccessException e) {
	    	        throw new RuntimeException("Error instantiating class " + this.dmDriver);
	    	    } catch (ClassNotFoundException e) {
	    	        throw new RuntimeException("Error instantiating class " + this.dmDriver);
	    	    }
	    	    
	    	    return new AuxDataSource(this.dmUrl, this.dmUser, this.dmPassword);
	        }
	    }
	    return dataSource;
	}    
	
	private class AuxDataSource implements DataSource {
        
    	private String url = null;
    	private String user = null;
    	private String password = null;
    	
    	public AuxDataSource(String url, String user, String password){
    	    
    	    this.url = url;
    	    this.user = user;
    	    this.password = password;
    	}
    	
        public Connection getConnection(String username, String password) throws SQLException {
            
            return DriverManager.getConnection(this.url, username, password);
        }
        
        public Connection getConnection() {
            
            Connection cn = null;
            try {
                cn = DriverManager.getConnection(this.url, this.user, this.password);
            } catch (SQLException e) {
                throw new RuntimeException("Error getting DB connection, url: " + this.url + ", user: " + this.user);
            }
            return cn;
        }
        
        public java.io.PrintWriter getLogWriter() throws SQLException {
            return null;
        }
        
        public void setLogWriter(java.io.PrintWriter out) throws SQLException {
        }
        
        public void setLoginTimeout(int seconds) throws SQLException {				
        }
        
        public int getLoginTimeout() throws SQLException {
            
            return 0;
        }

		@Override
		public <T> T unwrap(Class<T> iface) throws SQLException {
			return null;
		}

		@Override
		public boolean isWrapperFor(Class<?> iface) throws SQLException {
			return false;
		}

		@Override
		public Logger getParentLogger() throws SQLFeatureNotSupportedException {
			// TODO Auto-generated method stub
			return null;
		}
    };
	
	
	private static final String SQL_LOAD_VALUES   = "SELECT CLAVE, VALOR, TIPO FROM PASG.TBASG199_DAT_CONF";

//IGC RNF09-00005906
	private static final String SQL_LOAD_VALUES_A = "SELECT CLAVE, VALOR, TIPO FROM PASG.TBASG199_DAT_CONF_A";
	private static final String SQL_LOAD_VALUES_B = "SELECT CLAVE, VALOR, TIPO FROM PASG.TBASG199_DAT_CONF_B";
	private static final String SQL_LOAD_VALUES_C = "SELECT CLAVE, VALOR, TIPO FROM PASG.TBASG199_DAT_CONF_C";
	private static final String SQL_LOAD_VALUES_D = "SELECT CLAVE, VALOR, TIPO FROM PASG.TBASG199_DAT_CONF_D";
	
	private void loadTable() throws InitializationException {
				
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		
		String localHost="";
		
		try{
			localHost=java.net.InetAddress.getLocalHost().getHostName();
		}catch(Exception e){}

		
		try {
			
			cn = getDataSource().getConnection();
			st = cn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
// IGC RNF09-00005906
			if(localHost.equals("MADDE67273")) 
				rs = st.executeQuery(SQL_LOAD_VALUES_A);
			else if(localHost.equals("MADDE59825"))
				rs = st.executeQuery(SQL_LOAD_VALUES_B);
			//else if(localHost.equals("xxxxxxxxxxx")) 
			//    rs = st.executeQuery(SQL_LOAD_VALUES_C);
			//else if(localHost.equals("xxxxxxxxxxx"))
			//    rs = st.executeQuery(SQL_LOAD_VALUES_D);
			else rs = st.executeQuery(SQL_LOAD_VALUES);
			while(rs.next()){
				
				String clave = (String) rs.getString("CLAVE");
				String valor = (String) rs.getString("VALOR");
				String tipo = (String) rs.getString("TIPO");
				loadRow(clave, valor, tipo);
			}
			
		} catch(SQLException e) {
			
			throw new InitializationException("SQL Error loadding Configuration Table", e);
		} finally{
			
			try {
				if(rs != null) rs.close();
			} catch (SQLException e1) {	}
			try {
				if(st != null) st.close();
			} catch (SQLException e1) {	}
			try {
				if(cn != null) cn.close();
			} catch (SQLException e1) {	}
		}
	}
	
	private void loadRow(String key, String value, String type) throws InitializationException{
	
		key = key.trim();
		value = value.trim();
		type = type.trim();
		Object aux = null;
		if(type.trim().equalsIgnoreCase(INTEGER_TYPE)){
		
			try {
				aux = Integer.valueOf(value);
			} catch (NumberFormatException e) {
				throw new InitializationException("Integer Format Error, value: " + value);
			}
		} else if(type.trim().equalsIgnoreCase(STRING_TYPE)){
			
			aux = value;
		} else if(type.trim().equalsIgnoreCase(FLOAT_TYPE)){
			
			try {
				aux = Float.valueOf(value);
			} catch (NumberFormatException e) {
				throw new InitializationException("Float Format Error, value: " + value);
			}
		} else if(type.trim().equalsIgnoreCase(BOOLEAN_TYPE)){
			
			aux = Boolean.valueOf(value);
		} else {
			
			throw new InitializationException("UNKNOWN DATA TYPE: " + type);
		}	
		values.put(key, aux);		
	}
	
	public Object getValue(String key){
		
		return this.values.get(key);
	}
	
	public Integer getInteger(String key){
		
		return (Integer) this.values.get(key);
	}
	
	public String getString(String key){
		
		return (String) this.values.get(key);
	}
	
	public Boolean getBoolean(String key){
		
		return (Boolean) this.values.get(key);
	}
	
	public Float getFloat(String key){
		
		return (Float) this.values.get(key);
	}
	
	public String toString() {
	
		StringBuffer sb = new StringBuffer();
		sb.append(" ConfigurationMgr. Values: \n");
		
		if(this.values.isEmpty()){
			
			sb.append(" \n\t - EMPTY VALUE LIST");
		} else {
			
			Set keySet = this.values.keySet();
			Iterator it = keySet.iterator();
			while(it.hasNext()){
			
				String key = (String) it.next();
				String value = this.values.get(key).toString();
				sb.append(" \n\t - ").append(key).append(": ").append(value);				
			}			
		}
		sb.append("\n");
		return sb.toString();				
	}
  
}

