package renfe.com.pdf.core;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import renfe.com.dto.GetFindPersonaAltasBajasDTO;
import renfe.com.model.dto.Tbasg260HabilifuncDto;
import renfe.com.pdf.beans.AcreditacionBean;
import renfe.com.pdf.beans.CertificadoComplementarioAOTBean;
import renfe.com.pdf.beans.CertificadoComplementarioBean;
import renfe.com.pdf.beans.HabilitacionEstadoBean;
import renfe.com.pdf.beans.InformeAltaBajaBean;
import renfe.com.pdf.beans.OrdenActivacionBean;
import renfe.com.pdf.beans.OrdenSuspensionBean;
import renfe.com.util.DownloadPdfCts;
@Service
@Configurable
public class DownloadPdf {

	/*
	 * @Autowired Tbasg100PersonaRepositoryImpl tbasg100PersonaRepositoryImpl;
	 */

	// private Logger log = Logger.getLogger(DownloadPdfServlet.class.getName());
	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(DownloadPdf.class);

//  IGC  RNF09-00005511
	private String Documento = "";
	
	@Autowired
	DossierPersonalPdfWriter pdfWriter;
	
	public DownloadPdf() {
		super();
	}

	/*
	 * protected void doGet(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException {
	 * 
	 * String cdgoDoc = request.getParameter(DownloadPdfCts.PARAMETER_CDGO_DOC); if
	 * (cdgoDoc == null || cdgoDoc.trim().equals("")) { doErrorForward(request,
	 * response, DownloadPdfCts.BUNDLE_CTS_PDF_DOC_UNKNOWN); }
	 * 
	 * if (cdgoDoc.equals(DownloadPdfCts.CDGO_DOC_SOLICITUD_HAB)) {
	 * solicitudHab(request, response); } else if
	 * (cdgoDoc.equals(DownloadPdfCts.CDGO_DOC_HABILITACION_ESTADO)) {
	 * habilitacionEstado(request, response);
	 * 
	 * } // IGC RNF09-00005511 else if
	 * (cdgoDoc.equals(DownloadPdfCts.CDGO_DOC_DOSSIER_EMPLEADO)) { this.Documento =
	 * request.getParameter("Documento"); DossierEmpleado(request, response); } else
	 * if (cdgoDoc.equals(DownloadPdfCts.CDGO_DOC_CERTIFICADO_COMPLEMENTARIO)) {
	 * //certificadoComplementario(request, response); } // PPM102758 - Certificado
	 * Complementario AOT - INICIO else if
	 * (cdgoDoc.equals(DownloadPdfCts.CDGO_DOC_CERTIFICADO_COMPLEMENTARIO_AOT)) {
	 * certificadoComplementarioAOT(request, response); } // PPM102758 - Certificado
	 * Complementario AOT - FIN else if
	 * (cdgoDoc.equals(DownloadPdfCts.CDGO_DOC_ORDEN_SUSPENSION)) {
	 * ordenSuspension(request, response); } else if
	 * (cdgoDoc.equals(DownloadPdfCts.CDGO_DOC_ORDEN_ACTIVACION)) {
	 * ordenActivacion(request, response); } else if
	 * (cdgoDoc.equals(DownloadPdfCts.CDGO_INFORME_ALTA_BAJA)) {
	 * informeAltaBaja(request, response); } else if
	 * (cdgoDoc.equals(DownloadPdfCts.CDGO_DOC_INFORME_ACREDITACIONES)) {
	 * generaPDFAcreditaciones(request, response); } else { doErrorForward(request,
	 * response, DownloadPdfCts.BUNDLE_CTS_PDF_DOC_UNKNOWN); } }
	 * 
	 * protected void doPost(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException {
	 * 
	 * doGet(request, response); }
	 */

//  IGC  RNF09-00005511
	private void DossierEmpleado(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition", "attachment; filename=" + DownloadPdfCts.PDF_FILE_NAME);
		ServletOutputStream outputStream = response.getOutputStream();
		// String imgPath = getServletContext().getRealPath("gif");
		/*
		 * try { Imprimir pdfWriter = new Imprimir(imgPath, this.Documento);
		 * pdfWriter.createPDF(null,outputStream); } catch (InternalErrorException e) {
		 * ExceptionDumper.dump(log, "ERROR GENERATING \"Solicitud Habilitación\" PDF",
		 * e); doErrorForward(request, response,
		 * DownloadPdfCts.BUNDLE_CTS_UNEXPECTED_ERROR); }
		 */
	}

	private void solicitudHab(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String aux = request.getParameter(DownloadPdfCts.PARAMETER_CDGO_EXPEDIENT);
		if (aux == null || aux.trim().equals("")) {
			doErrorForward(request, response, DownloadPdfCts.BUNDLE_CTS_CDGO_EXP_MANDATORY);
		}

		Integer cdgoExpedient = null;
		try {
			cdgoExpedient = Integer.valueOf(aux);
		} catch (NumberFormatException e1) {
			doErrorForward(request, response, DownloadPdfCts.BUNDLE_CTS_CDGO_EXP_INCORRECT);
		}

		/*
		 * SolicitudHabBean bean = null; try {
		 * 
		 * AsgPdfMgr asgPdfMgr = new AsgPdfMgr(); bean =
		 * asgPdfMgr.getSolicitudHabBean(cdgoExpedient); } catch (InternalErrorException
		 * e2) { ExceptionDumper.dump(log, "ERROR GETTING SOLICITUD HAB DATA", e2);
		 * doErrorForward(request, response,
		 * DownloadPdfCts.BUNDLE_CTS_UNEXPECTED_ERROR); } if(bean == null) {
		 * doErrorForward(request, response,
		 * DownloadPdfCts.BUNDLE_CTS_EXP_NO_CONFIRMED); }
		 */

		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition", "attachment; filename=" + DownloadPdfCts.PDF_FILE_NAME);
		ServletOutputStream outputStream = response.getOutputStream();
		// String imgPath = getServletContext().getRealPath("gif");
		/*
		 * try { SolicitudHabPdfWriter pdfWriter = new SolicitudHabPdfWriter(imgPath);
		 * pdfWriter.createPDF(bean,outputStream); } catch (InternalErrorException e) {
		 * ExceptionDumper.dump(log, "ERROR GENERATING \"Solicitud Habilitación\" PDF",
		 * e); doErrorForward(request, response,
		 * DownloadPdfCts.BUNDLE_CTS_UNEXPECTED_ERROR); }
		 */
	}

	public void habilitacionEstado(HttpServletResponse response, Object tbasg104ExpedientDto)
			throws ServletException, IOException {

		/*
		 * String sCdgoPersona =
		 * request.getParameter(DownloadPdfCts.PARAMETER_CDGO_PERSONA); if (sCdgoPersona
		 * == null || sCdgoPersona.trim().equals("")) { doErrorForward(request,
		 * response, DownloadPdfCts.BUNDLE_CTS_CDGO_EXP_MANDATORY); } Integer
		 * cdgoPersona = null; try { cdgoPersona = Integer.valueOf(sCdgoPersona); }
		 * catch (NumberFormatException e1) { doErrorForward(request, response,
		 * DownloadPdfCts.BUNDLE_CTS_CDGO_EXP_INCORRECT); }
		 * 
		 * String sCdgoEstado =
		 * request.getParameter(DownloadPdfCts.PARAMETER_CDGO_ESTADO); Integer
		 * cdgoEstado = null; try { if (sCdgoEstado != null && !"".equals(sCdgoEstado))
		 * cdgoEstado = Integer.valueOf(sCdgoEstado); } catch (NumberFormatException e1)
		 * { doErrorForward(request, response,
		 * DownloadPdfCts.BUNDLE_CTS_CDGO_ESTADO_INCORRECT); }
		 */

		HabilitacionEstadoBean bean = new HabilitacionEstadoBean();
		/*
		 * try {
		 *
		 * AsgPdfMgr asgPdfMgr = new AsgPdfMgr(); bean =
		 * asgPdfMgr.getHabilitacionEstadoBean(cdgoPersona, cdgoEstado); } catch
		 * (InternalErrorException e2) { ExceptionDumper.dump(log,
		 * "ERROR GETTING SOLICITUD HAB DATA", e2); doErrorForward(request, response,
		 * DownloadPdfCts.BUNDLE_CTS_UNEXPECTED_ERROR); } if(bean == null) {
		 * doErrorForward(request, response,
		 * DownloadPdfCts.BUNDLE_CTS_EXP_NO_CONFIRMED); }
		 */

		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition", "attachment; filename=" + DownloadPdfCts.PDF_FILE_NAME);
		ServletOutputStream outputStream = response.getOutputStream();

		// String imgPath = getServletContext().getRealPath("gif");
		String imgPath = null;
		try {
			HabilitacionEstadoPdfWriter pdfWriter = new HabilitacionEstadoPdfWriter(imgPath);
			pdfWriter.createPDF(bean, outputStream, true, true, tbasg104ExpedientDto);

		} catch (InternalErrorException e) {
			// ExceptionDumper.dump(log, "ERROR GENERATING \"Habilitación\" PDF", e);
			// doErrorForward(request, response,
			// DownloadPdfCts.BUNDLE_CTS_UNEXPECTED_ERROR);
			logger.debug("Error Habilitacion Estado {} ", e);
		}
	}

	public void generaPDFAcreditaciones(HttpServletResponse response, Object tbasg267ExpedAcredDto)
			throws ServletException, IOException {

		/*
		 * String sCdgoPersona =
		 * request.getParameter(DownloadPdfCts.PARAMETER_CDGO_PERSONA); if (sCdgoPersona
		 * == null || sCdgoPersona.trim().equals("")) { doErrorForward(request,
		 * response, DownloadPdfCts.BUNDLE_CTS_CDGO_EXP_MANDATORY); } Integer
		 * cdgoPersona = null; try { cdgoPersona = Integer.valueOf(sCdgoPersona); }
		 * catch (NumberFormatException e1) { doErrorForward(request, response,
		 * DownloadPdfCts.BUNDLE_CTS_CDGO_EXP_INCORRECT); }
		 */

		AcreditacionBean bean = new AcreditacionBean();

		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition", "attachment; filename=" + DownloadPdfCts.PDF_FILE_NAME);
		ServletOutputStream outputStream = response.getOutputStream();

		try {
			InformeAcreditacionesPdfWriter pdfWriter = new InformeAcreditacionesPdfWriter();
			pdfWriter.createPDF(bean, outputStream, true, false, tbasg267ExpedAcredDto);
			logger.debug("Fin de certificado complementario");
		} catch (InternalErrorException e) {
			logger.debug("Error Informe Acreditaciones {} ", e);

		}
	}
	public void dossierPersonal(Integer cdgoPersona, HttpServletResponse response)throws IOException {
		
		response.setContentType("application/pdf");
		logger.debug("application/pdf");
		response.setHeader("Content-Disposition", "attachment; filename=" + DownloadPdfCts.PDF_FILE_NAME);
		OutputStream outputStream = response.getOutputStream();
		logger.debug("OUTPUTSTREAM0");
		String imgPath = null;
		try {
			pdfWriter.I_Init(imgPath, cdgoPersona);
			pdfWriter.createPDF(null, outputStream);
			logger.debug("Fin de certificado complementario");
		} catch (Exception e) {
			logger.debug("Error certificado complementario {} ", e);
		}
		logger.debug("Final del metodo");
	}

	public void certificadoComplementario(String cdgoIdioma, HttpServletResponse response, Object tbasg104ExpedientDto)
			throws ServletException, IOException {

		// String sIdioma = request.getParameter(DownloadPdfCts.PARAMETER_IDIOMA);
		String sIdioma = cdgoIdioma;

		// Creamos el reource bundle con el idioma elegido

		String language = sIdioma.toLowerCase();
		String country = sIdioma;
		Locale currentLocale = new Locale(language, country);

		ResourceBundle message = ResourceBundle.getBundle("locale/CertificadoComplementario", currentLocale);

		CertificadoComplementarioBean bean = new CertificadoComplementarioBean();
		// List<Tbasg100Persona> persona =
		// this.tbasg100PersonaRepositoryImpl.getPersona(sCdgoPersona);
		// bean = asgPdfMgr.getCertificadoComplementarioBean(cdgoPersona);

		response.setContentType("application/pdf");
		logger.debug("application/pdf");
		response.setHeader("Content-Disposition", "attachment; filename=" + DownloadPdfCts.PDF_FILE_NAME);
		ServletOutputStream outputStream = response.getOutputStream();

		// FotoPersonal fotoPersonal = new FotoPersonal();
		// String imgPath_1 = getServletContext().getRealPath("gif");
		// String imgPath_2 = fotoPersonal.getPathAbsolute(bean.getMatricula(),
		// bean.getNifPas());

		String imgPath_1 = null;
		String imgPath_2 = null;
		try {
			CertificadoComplementarioPdfWriter pdfWriter = new CertificadoComplementarioPdfWriter(imgPath_1, imgPath_2);

			pdfWriter.createPDFCertifComplementario(bean, outputStream, true, true, message, tbasg104ExpedientDto);
			logger.debug("Fin de certificado complementario");
		} catch (InternalErrorException e) {
			// System.out.println("Error certificado complementario" + e);
			logger.debug("Error certificado complementario {} ", e);
			// ExceptionDumper.dump(log, "ERROR GENERATING \"Certificado Complementario\"
			// PDF", e);
		}

	}

	public void certificadoComplementarioAOT(String cdgoIdioma, String cdgoTipoHabi, HttpServletResponse response,
			Object tbasg104ExpedientDto, List<Tbasg260HabilifuncDto> listaFunciones)
			throws ServletException, IOException {

		String sIdioma = cdgoIdioma;

		// Creamos el reource bundle con el idioma elegido

		String language = sIdioma.toLowerCase();
		String country = sIdioma;
		Locale currentLocale = new Locale(language, country);

		ResourceBundle message = ResourceBundle.getBundle("locale/CertificadoComplementarioAOT", currentLocale);

		CertificadoComplementarioAOTBean bean = new CertificadoComplementarioAOTBean();

		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition", "attachment; filename=" + DownloadPdfCts.PDF_FILE_NAME);
		ServletOutputStream outputStream = response.getOutputStream();
		// FotoPersonal fotoPersonal = new FotoPersonal();
		// String imgPath_1 = getServletContext().getRealPath("gif");
		// String imgPath_2 = fotoPersonal.getPathAbsolute(bean.getMatricula(),
		// bean.getNifPas());

		String imgPath_1 = null;
		String imgPath_2 = null;
		try {
			CertificadoComplementarioAOTPdfWriter pdfWriter = new CertificadoComplementarioAOTPdfWriter(imgPath_1,
					imgPath_2);
			pdfWriter.createPDFAOT(bean, outputStream, true, true, message, cdgoTipoHabi, tbasg104ExpedientDto,
					listaFunciones);
		} catch (InternalErrorException e) {
			logger.debug("Error certificado complementario {} ", e);
		}
	}

	// PPM102758 - Certificado Complementario AOT - FIN

	public void ordenSuspension(OrdenSuspensionBean bean, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition", "attachment; filename=" + DownloadPdfCts.PDF_FILE_NAME);
		ServletOutputStream outputStream = response.getOutputStream();

		String imgPath_1 = null;

		try {
			OrdenSuspensionPdfWriter pdfWriter = new OrdenSuspensionPdfWriter(imgPath_1);
			pdfWriter.createPDF(bean, outputStream, false, false);

		} catch (InternalErrorException e) {
			logger.debug("Error al generar documento de suspension {} ", e);
		}
	}

	public void ordenActivacion(OrdenActivacionBean bean, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition", "attachment; filename=" + DownloadPdfCts.PDF_FILE_NAME);
		ServletOutputStream outputStream = response.getOutputStream();

		String imgPath_1 = null;

		try {
			OrdenActivacionPdfWriter pdfWriter = new OrdenActivacionPdfWriter(imgPath_1);
			pdfWriter.createPDF(bean, outputStream, false, false);

		} catch (InternalErrorException e) {
			logger.debug("Error al generar documento de activacion {} ", e);
		}
	}

	// Aquí tengo que jugar con los parámetros que le tengo que pasar
	public void informeAltaBaja(HttpServletResponse response, Object getFindPersonaAltas, String fecDesde, String fecHasta)
			throws ServletException, IOException {

		List<GetFindPersonaAltasBajasDTO> personasAltas = (List<GetFindPersonaAltasBajasDTO>) getFindPersonaAltas;

		try {

			response.setContentType("application/pdf");
			response.setHeader("Content-Disposition", "attachment; filename=" + DownloadPdfCts.PDF_FILE_NAME);
			ServletOutputStream outputStream = response.getOutputStream();

			InformeAltaBajaPdfWriter pdfWriter = new InformeAltaBajaPdfWriter();

			InformeAltaBajaBean informe = new InformeAltaBajaBean();
			informe.setPersonas(personasAltas);
			informe.setfDesde(fecDesde.toString());
			informe.setfHasta(fecHasta.toString());

			pdfWriter.createPDF(informe, outputStream, false, false, informe);

		} catch (InternalErrorException e) {
			doErrorForward(null, response, DownloadPdfCts.BUNDLE_INFALTABAJA_UNEXPECTED_ERROR);
		}

	}

	private void doErrorForward(HttpServletRequest request, HttpServletResponse response, String msgKey)
			throws ServletException, IOException {

		/*
		 * String msg = BundleMgr.getInstance().resolve(msgKey);
		 * request.setAttribute(DownloadPdfCts.ATTRIBUTE_ERROR_MSG, msg);
		 * RequestDispatcher dispatcher =
		 * request.getRequestDispatcher(ConstantsJSP.CTE_JSP_PDF_ERROR);
		 * dispatcher.forward(request, response);
		 */
	}

}
