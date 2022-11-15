package renfe.com.util;

import com.lowagie.text.Element;

public class InformesAltaBajaPdfCts {

	/**
	 * Texto para la cabecera del informe
	 */
	public static final String CABECERA_INFORME = "\n\nAGENCIA ESTATAL DE SEGURIDAD FERROVIARIA\n" +
	                                              "                                          ";
	
	/**
	 * Título principal del informe
	 * 
	 */
	//Posteriormente se cambiaran las cadenas de los títulos dependeindo del informe
	public static final String TITULO_INFORME = "ALTAS/BAJAS DE PERSONAL DE CONDUCCIÓN EN EMPRESAS FERROVIARIAS: ";
	public static final String TITULO_INFORME_MERCANCIAS = "ALTAS/BAJAS DE PERSONAL DE CONDUCCIÓN EN EMPRESAS FERROVIARIAS: ";
	public static final String TITULO_INFORME2 = " AL ";
	
	public static final String TITULO_INFORMEV = "ALTAS/BAJAS DE PERSONAL DE CONDUCCIÓN EN EMPRESAS FERROVIARIAS: ";
	/**
	 * Literal para el NIF de la empresa
	 */
	public static final String NIF_EMPRESA = "NIF de la Empresa";
	
	/**
	 * Columna para el tipo de documento
	 */
	public static final String TIPO_DOCUMENTO = "Tipo de documento";
	
	/**
	 * Columna para el Número de documento del conductor
	 */
	public static final String DOCUMENTO_CONDUCTOR = "Nº documento conductor";
	
	/**
	 * Columna para el Título de la persona
	 */
	public static final String TITULO_PERSONA = "Título";
	
	/**
	 * Columna para indicar si está de alta o de baja
	 */
	public static final String ALTA_BAJA = "Alta/Baja";

	/**
	 * Columna para la fecha de alta o de baja
	 */
	public static final String FECHA = "Fecha";
	
	/**
	 * Columna para el código de sociedad
	 */
	public static final String SOCIEDAD = "Sociedad";
	
	
	
	/**
	 * Fuente por defecto
	 */
	public static final String DEFAULT_FONT_FAMILY = "Arial";
	
	/**
	 * Fuente por defecto
	 */
	public static final float DEFAULT_FONT_SIZE = 10;
	
	/**
	 * Alineación horizontal por defecto
	 */
	public static final int DEFAULT_ALIGNMENT = Element.ALIGN_LEFT;
	
	/**
	 * Logo para el Ministerio de fomento
	 */
	public static final String TOP_IMG = "gif/ministerio_fomento.png";
	
	/**
	 * Logo Agencia Estatal de Seguridad Ferroviaria
	 */	
	public static final String IMG_AGENCIA = "gif/AES.jpg";
	
	/**
	 * Texto para el pie del informe para la fecha
	 */
	public static final String FECHA_ACTUAL_DIA = "Fecha, a";
	
	/**
	 * Texto para el pie del informe para la fecha
	 */
	public static final String FECHA_ACTUAL_DE = "de";
	
	/**
	 * Formato de las fechas del informe
	 */
	public static final String FORMATO_FECHA = "yyyy-MM-dd";
	
	/**
	 * Mes de Enero
	 */
	public static final String MES_ENERO = "Enero";
	
	/**
	 * Mes de Febrero
	 */
	public static final String MES_FEBRERO = "Febrero";
	
	/**
	 * Mes de Marzo
	 */
	public static final String MES_MARZO = "Marzo";
	
	/**
	 * Mes de Abril
	 */
	public static final String MES_ABRIL = "Abril";
	
	/**
	 * Mes de Mayo
	 */
	public static final String MES_MAYO = "Mayo";
	
	/**
	 * Mes de Junio
	 */
	public static final String MES_JUNIO = "Junio";
	
	/**
	 * Mes de Julio
	 */
	public static final String MES_JULIO = "Julio";
	
	/**
	 * Mes de Agosto
	 */
	public static final String MES_AGOSTO = "Agosto";
	
	/**
	 * Mes de Septiembre
	 */
	public static final String MES_SEPTIEMBRE = "Septiembre";
	
	/**
	 * Mes de Octubre
	 */
	public static final String MES_OCTUBRE = "Octubre";
	
	/**
	 * Mes de Noviembre
	 */
	public static final String MES_NOVIEMBRE = "Noviembre";
	
	/**
	 * Mes de Diciembre
	 */
	public static final String MES_DICIEMBRE = "Diciembre";
}
