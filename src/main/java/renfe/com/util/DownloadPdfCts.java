package renfe.com.util;

public abstract class DownloadPdfCts {

	public static final String PARAMETER_CDGO_DOC = "cdgoDoc";
	public static final String PARAMETER_CDGO_EXPEDIENT = "cdgoExpedient";
	public static final String PARAMETER_CDGO_ESTADO = "cdgoEstado";
	public static final String PARAMETER_CDGO_PERSONA = "cdgoPersona";
	public static final String PARAMETER_CDGO_INFRPER = "cdgoInfrper";
	public static final String PARAMETER_CDGO_IDIOMA = "cdgoIdioma";
	public static final String PARAMETER_IDIOMA = "idioma";

	public static final String PARAMETER_FEC_DESDE = "fecDesde";
	public static final String PARAMETER_FEC_HASTA = "fecHasta";
	public static final String PARAMETER_ALTAS = "altas";
	public static final String PARAMETER_BAJAS = "bajas";
	public static final String PARAMETER_MERCANCIAS = "AreaUser";
	public static final String PARAMETER_OPE_PRINCIPAL = "operprinc";
	public static final String PARAMETER_VIAJ_PRINCIPAL = "viajprinc";
	public static final String PARAMETER_SOCIEDADES = "sociedades";

	public static final String PARAMETER_MERCA = "mercancias";
	public static final String PARAMETER_OPERADORA = "operadora";
	public static final String PARAMETER_VIAJEROS = "viajeros";
	public static final String PARAMETER_FABRICAC = "fabricac";
	public static final String PARAMETER_ALQUILER = "alquiler";
	public static final String PARAMETER_SOCIEDAD = "sociedad";

	public static final String ATTRIBUTE_ERROR_MSG = "errorMsg";
	public static final String ATTRIBUTE_ERRORES_VALIDACION = "errorValidacion";

	public static final String PDF_FILE_NAME = "documento.pdf";

	// CDGO DOC
	public static final String CDGO_DOC_SOLICITUD_HAB = "1";
	public static final String CDGO_DOC_HABILITACION_ESTADO = "2";
	public static final String CDGO_DOC_DOSSIER_EMPLEADO = "3";
	public static final String CDGO_DOC_CERTIFICADO_COMPLEMENTARIO = "4";
	public static final String CDGO_DOC_ORDEN_SUSPENSION = "5";
	public static final String CDGO_DOC_ORDEN_ACTIVACION = "6";

	public static final String CDGO_INFORME_ALTA_BAJA = "7";

	public static final String CDGO_DOC_CERTIFICADO_COMPLEMENTARIO_AOT = "8";
	public static final String CDGO_DOC_INFORME_ACREDITACIONES = "9";

	// BUNDLE CONSTANTS
	public static final String BUNDLE_CTS_PDF_DOC_UNKNOWN = "pdf.solicitudHab.pdf.doc.unknown";
	public static final String BUNDLE_CTS_UNEXPECTED_ERROR = "pdf.solicitudHab.unexpected.error";

	public static final String BUNDLE_CTS_CDGO_EXP_MANDATORY = "pdf.solicitudHab.codigoExpedient.mandatory";
	public static final String BUNDLE_CTS_CDGO_EXP_INCORRECT = "pdf.solicitudHab.codigoExpedient.incorrect";
	public static final String BUNDLE_CTS_EXP_NO_CONFIRMED = "pdf.solicitudHab.expedient.no.confirmed";
	public static final String BUNDLE_CTS_ACRE_NO_DATA = "pdf.informe.acreditacion.no.data";

	public static final String BUNDLE_CTS_CDGO_ESTADO_MANDATORY = "pdf.habilitacionEstado.codigoEstado.mandatory";
	public static final String BUNDLE_CTS_CDGO_ESTADO_INCORRECT = "pdf.habilitacionEstado.codigoEstado.incorrect";

	public static final String BUNDLE_CTS_CDGO_INFR_MANDATORY = "pdf.ordenSuspension.codigoInfrper.mandatory";
	public static final String BUNDLE_CTS_CDGO_INFR_INCORRECT = "pdf.ordenSuspension.codigoInfrper.incorrect";

	public static final String BUNDLE_FEC_DESDE_MANDATORY = "pdf.ordenSuspension.codigoInfrper.mandatory";
	public static final String BUNDLE_FEC_HASTA_MANDATORY = "pdf.ordenSuspension.codigoInfrper.incorrect";

	// EVOL 71914
	/**
	 * Mensaje para las fechas para informes de alta/baja
	 */
	public static final String BUNDLE_CTS_FECHAS_MANDATORY = "pdf.informeAltaBaja.fechas.mandatory";

	/**
	 * Mensaje para un error inesperado
	 */
	public static final String BUNDLE_INFALTABAJA_UNEXPECTED_ERROR = "pdf.informeAltaBajb.unexpected.error";

}
