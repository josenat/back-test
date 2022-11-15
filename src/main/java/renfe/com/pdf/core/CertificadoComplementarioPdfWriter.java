package renfe.com.pdf.core;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.ResourceBundle;
import java.awt.Color;
import java.util.Base64;

import com.lowagie.text.BadElementException;
import com.lowagie.text.Cell;
import com.lowagie.text.Chunk;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Graphic;

import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPCellEvent;
import com.lowagie.text.pdf.PdfPRow;
import com.lowagie.text.pdf.PdfPTable;

import renfe.com.dto.GetTramosOrderByCodLineaDTO;
import renfe.com.model.dto.Tbasg260HabilifuncDto;
import renfe.com.pdf.beans.CertificadoComplementarioBean;
import renfe.com.util.CertificadoComplementarioPdfCts;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CertificadoComplementarioPdfWriter extends AsgPdfWriter {

	private String imgPath_1 = null;
	private String imgPath_2 = null;
	private Font fontCabecera = null;
	private Font fontPunto = null;
	private Font fontParrafo = null;
	private Font fontDato = null;
	private Font fontDatoPeq = null;
	private Font fontDatoMasPeq = null;
	private Font fontDatoMasPeqAun = null;
	private ArrayList listAltoCol = new ArrayList();
	private ArrayList listNumRegPaginas = new ArrayList();
	private float proporcion = 1.00f;
	private float anchoPagina = 25.6f * proporcion; // cm
	// INICIO PPM 181883
	private float altoPagina = 22.05f * proporcion; // cm
	// FIN PPM 181883
	// private float altoPagina = 16.05f * proporcion; // cm

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(CertificadoComplementarioPdfWriter.class);

	public CertificadoComplementarioPdfWriter(String imgPath_1, String imgPath_2) {

		super();

		this.imgPath_1 = imgPath_1;
		this.imgPath_2 = imgPath_2;

		this.defaultFont = new Font();
		this.defaultFont.setFamily(CertificadoComplementarioPdfCts.DEFAULT_FONT_FAMILY);
		this.defaultFont.setSize(CertificadoComplementarioPdfCts.DEFAULT_FONT_SIZE);

		this.defaultAlignment = CertificadoComplementarioPdfCts.DEFAULT_ALIGNMENT;

		fontCabecera = createFont(new int[] { Font.NORMAL });
		fontCabecera.setFamily(CertificadoComplementarioPdfCts.DEFAULT_FONT_FAMILY);
		fontCabecera.setSize(6.5f);

		fontPunto = createFont(new int[] { Font.BOLD });
		fontPunto.setFamily(CertificadoComplementarioPdfCts.DEFAULT_FONT_FAMILY);
		fontPunto.setSize(8);

		fontParrafo = createFont(new int[] { Font.NORMAL });
		fontParrafo.setFamily(CertificadoComplementarioPdfCts.DEFAULT_FONT_FAMILY);
		fontParrafo.setSize(9);

		fontDato = createFont(new int[] { Font.NORMAL });
		fontDato.setFamily(CertificadoComplementarioPdfCts.DEFAULT_FONT_FAMILY);
		fontDato.setSize(8);

		fontDatoPeq = createFont(new int[] { Font.NORMAL });
		fontDatoPeq.setFamily(CertificadoComplementarioPdfCts.DEFAULT_FONT_FAMILY);
		fontDatoPeq.setSize(7.5f);

		fontDatoMasPeq = createFont(new int[] { Font.NORMAL });
		fontDatoMasPeq.setFamily(CertificadoComplementarioPdfCts.DEFAULT_FONT_FAMILY);
		fontDatoMasPeq.setSize(7);

		fontDatoMasPeqAun = createFont(new int[] { Font.NORMAL });
		fontDatoMasPeqAun.setFamily(CertificadoComplementarioPdfCts.DEFAULT_FONT_FAMILY);
		fontDatoMasPeqAun.setSize(6);

	}

	/**
	 * Pasa los centimetros a puntos del pdf
	 * 
	 * @param centimetros
	 * @return float
	 */
	public float getPuntos(float centimetros) {
		return (72f * centimetros) / 2.54f;
	}


	protected void writeDocument(Object object, ResourceBundle bundleMgr) throws DocumentException {
		logger.debug("writeDocument Inicio");
		CertificadoComplementarioBean bean = (CertificadoComplementarioBean) object;

		// MARCO
		PdfPTable marco = new PdfPTable(1);
		marco.setWidthPercentage(100f);

		// PRIMERA PAGINA
		PdfPTable tablePagina1 = new PdfPTable(3);
		tablePagina1.setTotalWidth(
				new float[] { getPuntos(anchoPagina / 3), getPuntos(anchoPagina / 3), getPuntos(anchoPagina / 3) });
		tablePagina1.setLockedWidth(true);
		tablePagina1.getDefaultCell().setBorder(0);
		tablePagina1.setHorizontalAlignment(Element.ALIGN_CENTER);
		tablePagina1.setWidthPercentage(100.0f);
		PdfPCell c1 = getCellConocimientos(bean, bundleMgr);
		c1.setFixedHeight(getPuntos(altoPagina));
		tablePagina1.addCell(c1);
		PdfPCell c2 = getCellDatos(bean, bundleMgr);
		c2.setFixedHeight(getPuntos(altoPagina));
		tablePagina1.addCell(c2);
		PdfPCell c3 = getCellPortada(bean, bundleMgr);
		c3.setFixedHeight(getPuntos(altoPagina));
		tablePagina1.addCell(c3);

		PdfPCell cellMarco = new PdfPCell(tablePagina1);
		cellMarco.setBorder(PdfPCell.NO_BORDER);
		cellMarco.setFixedHeight(document.getPageSize().height() - document.bottomMargin() - document.topMargin());
		cellMarco.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
		marco.addCell(cellMarco);
		document.add(marco);

		// SEGUNDA PAGINA
		PdfPTable tablePagina2 = null;
		int numeroPaginaActual = 0;
		do {
			document.newPage();

			// MARCO
			marco = new PdfPTable(1);
			marco.setWidthPercentage(100f);

			tablePagina2 = new PdfPTable(3);
			tablePagina2.setTotalWidth(
					new float[] { getPuntos(anchoPagina / 3), getPuntos(anchoPagina / 3), getPuntos(anchoPagina / 3) });
			tablePagina2.setLockedWidth(true);
			tablePagina2.getDefaultCell().setBorder(0);
			tablePagina2.setHorizontalAlignment(Element.ALIGN_CENTER);
			tablePagina2.setWidthPercentage(100.0f);
			PdfPCell c6 = getCellInfraestructuraDer(bean, numeroPaginaActual, bundleMgr);
			c6.setFixedHeight(getPuntos(altoPagina));
			PdfPCell c4 = getCellMaterial(bean, numeroPaginaActual, bundleMgr);
			c4.setFixedHeight(getPuntos(altoPagina));
			tablePagina2.addCell(c4);
			PdfPCell c5 = getCellInfraestructuraIzq(bean, numeroPaginaActual, bundleMgr);
			c5.setFixedHeight(getPuntos(altoPagina));
			tablePagina2.addCell(c5);
			tablePagina2.addCell(c6);

			cellMarco = new PdfPCell(tablePagina2);
			cellMarco.setBorder(PdfPCell.NO_BORDER);
			cellMarco.setFixedHeight(
					document.getPageSize().height() - document.bottomMargin() - document.topMargin());
			cellMarco.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
			marco.addCell(cellMarco);
			document.add(marco);

			numeroPaginaActual++;
			listAltoCol.clear();
		} while (hayPaginaSiguiente(listNumRegPaginas, bean));
		logger.debug("writeDocument Fin");
	}

	/**
	 * Devuelve verdadero si quedan paginas por imprimir.
	 * 
	 * @param lPaginas
	 * @param bean
	 * @return
	 */
	private boolean hayPaginaSiguiente(List lPaginas, CertificadoComplementarioBean bean) {
		logger.debug("hayPaginaSiguiente Inicio");
		int numeroMaterial = 0;
		int numeroInfra = 0;
		int numeroFilas = 0;

		List listaMat = bean.getListMaterial();
		logger.debug("listaMat {} ", listaMat);
		List listaLin = bean.getListLineas();
		List listaTra = bean.getListTramos();
		if (listaMat != null)
			numeroMaterial = listaMat.size();
		if (listaLin != null)
			numeroInfra = listaLin.size();
		if (listaTra != null)
			numeroInfra = numeroInfra + listaTra.size();

		for (int i = 0; i < lPaginas.size(); i++) {
			numeroFilas += ((Integer) lPaginas.get(i)).intValue();
		}

		int numeroMayor = 0;
		if (numeroMaterial >= numeroInfra) {
			numeroMayor = numeroMaterial;
		} else {
			numeroMayor = numeroInfra;
		}
		if (numeroFilas < numeroMayor)
			return true;
		else
			return false;
	}

	/**
	 * TABLA DE CATEGORIAS Y CONOCIMIENTOS
	 * 
	 * @return
	 */
	private PdfPCell getCellConocimientos(CertificadoComplementarioBean bean, ResourceBundle bundleMgr) {

		String text = null;

		/*
		 * TODO Construir el locale con el idioma String language; String country;
		 * 
		 * language = new String("en"); country = new String("US");
		 * 
		 * Locale currentLocale; currentLocale = new Locale(language, country);
		 */

		PdfPCell cell = null;
		cell = new PdfPCell();
		cell.setBackgroundColor(CertificadoComplementarioPdfCts.COLOR_FONDO);
		cell.setPadding(15);
		cell.setPaddingTop(5);
		cell.setBorder(Rectangle.RIGHT);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);

		// CABECERA Para generar el informe en otro idioma aniadir el
		// currentLocale en la llamada al método

		text = bundleMgr.getString(CertificadoComplementarioPdfCts.BUNDLE_CTS_CABECERA);
		Paragraph cabecera = new Paragraph(text, fontCabecera);
		cabecera.setAlignment(Element.ALIGN_CENTER);
		cell.addElement(cabecera);
		// LINEA CABECERA
		cell.addElement(getLineaHorizontal());
		cell.addElement(getElementoVacio());

		// 3. CATEGORIAS DE CONDUCCION
		text = bundleMgr.getString(CertificadoComplementarioPdfCts.BUNDLE_CTS_3);
		Paragraph punto3 = new Paragraph(text, fontPunto);
		punto3.setAlignment(Element.ALIGN_CENTER);
		cell.addElement(punto3);

		text = bundleMgr.getString(CertificadoComplementarioPdfCts.BUNDLE_CTS_3_1);
		Paragraph punto3_1 = new Paragraph(text, fontParrafo);
		punto3_1.setAlignment(Element.ALIGN_LEFT);
		cell.addElement(punto3_1);

		cell.addElement(getElementoVacio());

		// TABLA CUADROS
		float[] tamanoColumnas = { 15f, 15f, 15f, 15f, 15f, 15f };
		PdfPTable tableCuadros = new PdfPTable(tamanoColumnas);
		tableCuadros.getDefaultCell().setBorder(0);
		tableCuadros.setHorizontalAlignment(0);
		tableCuadros.setWidthPercentage(100.0f);
		String textA = bundleMgr.getString(CertificadoComplementarioPdfCts.BUNDLE_CTS_3_2);
		String textB = bundleMgr.getString(CertificadoComplementarioPdfCts.BUNDLE_CTS_3_3);
		String textV = bundleMgr.getString(CertificadoComplementarioPdfCts.BUNDLE_CTS_3_4);
		tableCuadros.addCell(getRecuadro(textA));
		tableCuadros.addCell(getRecuadro(textV));
		tableCuadros.addCell(getRecuadro(textV));
		tableCuadros.addCell(getRecuadro(textV));
		tableCuadros.addCell(getRecuadro(textV));
		tableCuadros.addCell(getRecuadro(textV));
		tableCuadros.addCell(getRecuadro(textB));
		tableCuadros.addCell(getRecuadro(textV));
		tableCuadros.addCell(getRecuadro(textV));
		tableCuadros.addCell(getElementoVacio());
		tableCuadros.addCell(getElementoVacio());
		tableCuadros.addCell(getElementoVacio());
		cell.addElement(tableCuadros);

		cell.addElement(getElementoVacio());

		// TABLA NOTAS
		PdfPCell celdaNotas = new PdfPCell();
		celdaNotas.setVerticalAlignment(Element.ALIGN_TOP);
		celdaNotas.setPadding(0);
		text = bundleMgr.getString(CertificadoComplementarioPdfCts.BUNDLE_CTS_3_5);

		if ("RAM".equals(bean.getrestrinRam())) {
			Paragraph notas = new Paragraph(text + " Alcance solo RAM", fontParrafo);
			notas.setAlignment(Element.ALIGN_LEFT);
			notas.setLeading(10);
			notas.setIndentationLeft(8);
			celdaNotas.addElement(notas);
		} else if ("RFIG".equals(bean.getrestrinRam())) {
			Paragraph notas = new Paragraph(text + " Alcance solo RFIG", fontParrafo);
			notas.setAlignment(Element.ALIGN_LEFT);
			notas.setLeading(10);
			notas.setIndentationLeft(8);
			celdaNotas.addElement(notas);
		} else {
			Paragraph notas = new Paragraph(text + " Alcance RAM + RFIG", fontParrafo);
			notas.setAlignment(Element.ALIGN_LEFT);
			notas.setLeading(10);
			notas.setIndentationLeft(8);
			celdaNotas.addElement(notas);
		}

		celdaNotas.addElement(getElementoVacio());
		celdaNotas.addElement(getElementoVacio());
		celdaNotas.addElement(getElementoVacio());
		PdfPTable tableNotas = new PdfPTable(1);
		tableNotas.getDefaultCell().setBorder(0);
		tableNotas.setHorizontalAlignment(0);
		tableNotas.setWidthPercentage(100.0f);
		tableNotas.addCell(celdaNotas);
		cell.addElement(tableNotas);

		cell.addElement(getElementoVacio());

		// 4. INFORMACION ADICIONAL
		text = bundleMgr.getString(CertificadoComplementarioPdfCts.BUNDLE_CTS_4);
		Paragraph punto4 = new Paragraph(text, fontPunto);
		punto4.setAlignment(Element.ALIGN_CENTER);
		cell.addElement(punto4);

		// PPM102758 - Modificaciones en el certificado complementario - INICIO

		cell.addElement(getElementoVacio());

		// TABLA INFORMACIÓN ADICIONAL
		cell.addElement(getTablaInformacionAdic(bean.getListInformacionAdic(), bundleMgr));

		cell.addElement(getElementoVacio());

		// PPM102758 - Modificaciones en el certificado complementario - FIN

		// 5. CONOCIMIENTOS LINGUISTICOS
		text = bundleMgr.getString(CertificadoComplementarioPdfCts.BUNDLE_CTS_5);
		Paragraph punto5 = new Paragraph(text, fontPunto);
		punto5.setAlignment(Element.ALIGN_CENTER);
		cell.addElement(punto5);

		cell.addElement(getElementoVacio());

		// TABLA CONOCIMIENTOS
		cell.addElement(getTablaConocimientos(bean.getListConocimientos(), bundleMgr));
		cell.addElement(getElementoVacio());

		// 6. RESTRICCIONES
		text = bundleMgr.getString(CertificadoComplementarioPdfCts.BUNDLE_CTS_6);

		Paragraph punto6 = new Paragraph(text, fontPunto);
		punto6.setAlignment(Element.ALIGN_CENTER);
		cell.addElement(punto6);

		if ("S".equals(bean.getProtAudi())) {
			cell.addElement(getLineaTexto("", "RESTRICCION AUDITIVA"));
		}

		if ("S".equals(bean.getCorrVisual())) {
			cell.addElement(getLineaTexto("", "RESTRICCION VISUAL"));
		}

		cell.addElement(getLineaTexto("", ""));
		cell.addElement(getElementoVacio());
		cell.addElement(getLineaTexto("", ""));

		cell.addElement(getElementoVacio());
		return cell;
	}

	// PPM102758 - Modificaciones en el certificado complementario - INICIO
	private PdfPTable getTablaInformacionAdic(List lInfoAdic, ResourceBundle bundleMgr) {
		String text = null;

		float[] tamanoColumnas = { 80f, 20f };
		PdfPTable tabla = new PdfPTable(tamanoColumnas);
		tabla.getDefaultCell().setBorder(Rectangle.BOTTOM);
		tabla.getDefaultCell().setFixedHeight(14);
		tabla.getDefaultCell().setVerticalAlignment(Element.ALIGN_BOTTOM);
		tabla.setHorizontalAlignment(0);
		tabla.setWidthPercentage(100.0f);

		text = bundleMgr.getString(CertificadoComplementarioPdfCts.BUNDLE_CTS_4_COL_1);
		tabla.addCell(new Phrase(text, fontParrafo));
		text = bundleMgr.getString(CertificadoComplementarioPdfCts.BUNDLE_CTS_4_COL_2);
		tabla.addCell(new Phrase(text, fontParrafo));
		// INICIO PPM 181883
		int numeroTotalFilas = 14;

		int numeroFilas = 0;
		if (lInfoAdic != null && lInfoAdic.size() > 0) {
			HashMap hsInfoAdic = null;
			for (int i = 0; i < lInfoAdic.size() && numeroFilas < numeroTotalFilas; i++) {
				hsInfoAdic = (HashMap) lInfoAdic.get(i);
				tabla.addCell(new Phrase((String) hsInfoAdic.get("descripcionCualificacion"), fontDatoMasPeq));
				tabla.addCell(new Phrase((String) hsInfoAdic.get("fchaExpedicion"), fontDatoMasPeq));
				numeroFilas++;
			}
		}
		// Rellenamos las siguientes filas
		for (int i = numeroFilas; i < numeroTotalFilas; i++) {
			tabla.addCell(getElementoVacio());
			tabla.addCell(getElementoVacio());
		}
		return tabla;
	}

	// PPM102758 - Modificaciones en el certificado complementario - FIN

	private PdfPTable getTablaConocimientos(List lConocimientos, ResourceBundle bundleMgr) {
		String text = null;

		float[] tamanoColumnas = { 22f, 30f, 48f };
		PdfPTable tabla = new PdfPTable(tamanoColumnas);
		tabla.getDefaultCell().setBorder(Rectangle.TOP + Rectangle.BOTTOM);
		tabla.getDefaultCell().setFixedHeight(14);
		tabla.getDefaultCell().setVerticalAlignment(Element.ALIGN_BOTTOM);
		tabla.setHorizontalAlignment(0);
		tabla.setWidthPercentage(100.0f);

		text = bundleMgr.getString(CertificadoComplementarioPdfCts.BUNDLE_CTS_5_COL_1);
		tabla.addCell(new Phrase(text, fontParrafo));
		text = bundleMgr.getString(CertificadoComplementarioPdfCts.BUNDLE_CTS_5_COL_2);
		tabla.addCell(new Phrase(text, fontParrafo));
		text = bundleMgr.getString(CertificadoComplementarioPdfCts.BUNDLE_CTS_5_COL_3);
		tabla.addCell(new Phrase(text, fontParrafo));

		int numeroTotalFilas = 2;
		int numeroFilas = 0;
		if (lConocimientos != null && lConocimientos.size() > 0) {
			HashMap hsConocimiento = null;
			for (int i = 0; i < lConocimientos.size() && numeroFilas < numeroTotalFilas; i++) {
				hsConocimiento = (HashMap) lConocimientos.get(i);
				tabla.addCell(new Phrase((String) hsConocimiento.get("fchaExpedicion"), fontDato));
				tabla.addCell(new Phrase((String) hsConocimiento.get("lengua"), fontDato));
				tabla.addCell(new Phrase((String) hsConocimiento.get("notas"), fontDato));
				numeroFilas++;
			}
		}
		// Rellenamos las siguientes filas
		for (int i = numeroFilas; i < numeroTotalFilas; i++) {
			tabla.addCell(getElementoVacio());
			tabla.addCell(getElementoVacio());
			tabla.addCell(getElementoVacio());
		}
		return tabla;
	}

	/**
	 * TABLA DE LOS DATOS SOBRE EL EMPLEADOR Y TITULAR
	 * 
	 * @return
	 */
	private PdfPCell getCellDatos(CertificadoComplementarioBean bean, ResourceBundle bundleMgr) {
		String text = null;

		PdfPCell cell = null;
		cell = new PdfPCell();
		cell.setBackgroundColor(CertificadoComplementarioPdfCts.COLOR_FONDO);
		cell.setPadding(15);
		cell.setPaddingTop(5);

		cell.setBorder(Rectangle.RIGHT);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);

		// CABECERA
		text = bundleMgr.getString(CertificadoComplementarioPdfCts.BUNDLE_CTS_CABECERA);
		Paragraph cabecera = new Paragraph(text, fontCabecera);
		cabecera.setAlignment(Element.ALIGN_CENTER);
		cell.addElement(cabecera);
		// LINEA CABECERA
		cell.addElement(getLineaHorizontal());
		cell.addElement(getElementoVacio());

		// 1. DATOS SOBRE EL CONTRATANTE
		text = bundleMgr.getString(CertificadoComplementarioPdfCts.BUNDLE_CTS_1);
		Paragraph punto1 = new Paragraph(text, fontPunto);
		punto1.setAlignment(Element.ALIGN_CENTER);
		cell.addElement(punto1);
		cell.addElement(getElementoVacio());
		cell.addElement(getElementoVacio());

		// DENOMINACION SOCIAL
		String campo = bundleMgr.getString(CertificadoComplementarioPdfCts.BUNDLE_CTS_1_1);
		String valor = bundleMgr.getString(CertificadoComplementarioPdfCts.BUNDLE_CTS_1_1_1);
		cell.addElement(getLineaTexto(campo, valor, Element.ALIGN_CENTER, 0, 0, false));
		cell.addElement(getElementoVacio());
		cell.addElement(getElementoVacio());

		// EMPRESA FERROVIARIA
		cell.addElement(getTablaEmpFerroviaria(bundleMgr));

		// LUGAR DE TRABAJO
		campo = bundleMgr.getString(CertificadoComplementarioPdfCts.BUNDLE_CTS_1_3);
		valor = bundleMgr.getString(CertificadoComplementarioPdfCts.BUNDLE_CTS_1_3_1);
		cell.addElement(getLineaTexto(campo, valor));
		cell.addElement(getElementoVacio());

		// DOMICILIO POSTAL
		campo = bundleMgr.getString(CertificadoComplementarioPdfCts.BUNDLE_CTS_1_4);
		valor = bundleMgr.getString(CertificadoComplementarioPdfCts.BUNDLE_CTS_1_4_1);
		cell.addElement(getLineaTexto(campo, valor));
		cell.addElement(getElementoVacio());

		// LOCALIDAD - PAIS
		campo = bundleMgr.getString(CertificadoComplementarioPdfCts.BUNDLE_CTS_1_5);
		valor = bundleMgr.getString(CertificadoComplementarioPdfCts.BUNDLE_CTS_1_5_1);
		cell.addElement(getLineaTexto(campo, valor));
		cell.addElement(getElementoVacio());

		// 2. DATOS SOBRE EL TITULAR
		text = bundleMgr.getString(CertificadoComplementarioPdfCts.BUNDLE_CTS_2);
		Paragraph punto2 = new Paragraph(text, fontPunto);
		punto2.setAlignment(Element.ALIGN_CENTER);
		cell.addElement(punto2);
		cell.addElement(getElementoVacio());

		// LUGAR DE NACIMIENTO
		campo = bundleMgr.getString(CertificadoComplementarioPdfCts.BUNDLE_CTS_2_1);
		valor = bean.getLugarNacimiento();
		cell.addElement(getLineaTexto(campo, valor));
		cell.addElement(getElementoVacio());

		// FECHA DE NACIMIENTO
		campo = bundleMgr.getString(CertificadoComplementarioPdfCts.BUNDLE_CTS_2_2);
		valor = bean.getFchaNacimiento();
		cell.addElement(getTablaFecha(campo, valor));
		cell.addElement(getElementoVacio());

		// NACIONALIDAD
		campo = bundleMgr.getString(CertificadoComplementarioPdfCts.BUNDLE_CTS_2_3);
		valor = bean.getNacionalidad();
		cell.addElement(getLineaTexto(campo, valor));
		cell.addElement(getElementoVacio());

		// DIRECCION POSTAL
		campo = bundleMgr.getString(CertificadoComplementarioPdfCts.BUNDLE_CTS_2_4);
		valor = bean.getDireccionPostal();
		cell.addElement(getLineaTexto(campo, valor, true));
		cell.addElement(getElementoVacio());

		// LOCALIDAD - FIRMA - FOTO
		cell.addElement(getTablaFoto(bean, bundleMgr));

		// INICIO 183509
		if (bean.getFchaExpiracion() != null) {
			if (bean.getFchaExpiracion().contains("X")) {
				cell.addElement(getElementoVacio());
				cell.addElement(getElementoVacio());
				cell.addElement(getLineaTexto("", "Empleado de baja en la empresa", true));
			}
		}
		// FIN 183509
		return cell;
	}

	private PdfPTable getTablaEmpFerroviaria(ResourceBundle bundleMgr) {
		String text = null;

		float[] tamanoColumnas = { 33f, 5f, 57f, 5f };
		PdfPTable tabla = new PdfPTable(tamanoColumnas);
		tabla.getDefaultCell().setBorder(0);
		tabla.setHorizontalAlignment(0);
		tabla.setWidthPercentage(100.0f);

		PdfPCell c1 = new PdfPCell();
		text = bundleMgr.getString(CertificadoComplementarioPdfCts.BUNDLE_CTS_1_2_1);
		c1.setBorder(PdfPCell.NO_BORDER);
		Paragraph p = new Paragraph(text, fontDatoPeq);
		p.setLeading(5);
		c1.addElement(p);
		c1.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
		tabla.addCell(c1);
		tabla.addCell(getCuadro("X"));

		PdfPCell c2 = new PdfPCell();
		text = bundleMgr.getString(CertificadoComplementarioPdfCts.BUNDLE_CTS_1_2_2);
		c2.setBorder(PdfPCell.NO_BORDER);
		p = new Paragraph(text, fontDatoPeq);
		p.setLeading(5);
		p.setIndentationLeft(5);
		c2.addElement(p);
		c2.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
		tabla.addCell(c2);
		tabla.addCell(getCuadro(""));
		return tabla;
	}

	private PdfPTable getTablaFoto(CertificadoComplementarioBean bean, ResourceBundle bundleMgr) {

		float[] tamanoColumnas = { 6f, 4f };
		PdfPTable tabla = new PdfPTable(tamanoColumnas);
		tabla.getDefaultCell().setBorder(0);
		tabla.setHorizontalAlignment(0);
		tabla.setWidthPercentage(100.0f);

		PdfPCell celdaIzq = new PdfPCell();
		celdaIzq.setBorder(Cell.NO_BORDER);
		celdaIzq.setPadding(0);
		// LOCALIDAD
		String campo = bundleMgr.getString(CertificadoComplementarioPdfCts.BUNDLE_CTS_2_5);
		String valor = bean.getLocalidad();
		celdaIzq.addElement(getLineaTexto(campo, valor, Element.ALIGN_LEFT, 0, 4, false));
		celdaIzq.addElement(getElementoVacio());

		// LOCALIDAD - PAIS
		campo = bundleMgr.getString(CertificadoComplementarioPdfCts.BUNDLE_CTS_2_6);
		valor = bean.getLocPais();
		celdaIzq.addElement(getLineaTexto(campo, valor, Element.ALIGN_LEFT, 0, 4, false));
		celdaIzq.addElement(getElementoVacio());

		// FIRMA
		campo = bundleMgr.getString(CertificadoComplementarioPdfCts.BUNDLE_CTS_2_7);
		valor = "";
		celdaIzq.addElement(getLineaTexto(campo, valor, Element.ALIGN_CENTER, 0, 4, false));
		celdaIzq.addElement(getElementoVacio());

		// FOTO
		Image image = null;
		// INICIO CORRECTIVO 171260
		BufferedImage imagen = null;
		byte[] imageByte;
		// BASE64Decoder decoder = new BASE64Decoder();
		/*try {

			// imageByte = decoder.decodeBuffer(this.imgPath_2);
			imageByte = null;
			ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
			imagen = ImageIO.read(bis);
			bis.close();
			image = Image.getInstance(imagen, null);
			// FIN CORRECTIVO 171260
			image.scaleToFit(getPuntos(2.85f), getPuntos(3.2f));
		} catch (BadElementException e) {
		} catch (MalformedURLException e) {
		} catch (IOException e) {
		}*/
		
		PdfPCell celdaDer = null;
		if (image != null)
			celdaDer = new PdfPCell(image);
		else
			celdaDer = new PdfPCell();
		celdaDer.setBorder(Cell.NO_BORDER);
		celdaDer.setCellEvent(new FotoBordeEvent());
		celdaDer.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
		celdaDer.setHorizontalAlignment(Element.ALIGN_CENTER);

		tabla.addCell(celdaIzq);
		tabla.addCell(celdaDer);

		return tabla;
	}

	/**
	 * TABLA CERTIFICADO COMPLEMENTARIO
	 * 
	 * @return
	 * @throws DocumentException
	 */
	private PdfPCell getCellPortada(CertificadoComplementarioBean bean, ResourceBundle bundleMgr)
			throws DocumentException {
		String text = null;

		PdfPCell cell = null;
		cell = new PdfPCell();
		cell.setBackgroundColor(CertificadoComplementarioPdfCts.COLOR_FONDO);
		cell.setPadding(15);
		cell.setPaddingTop(5);
		cell.setPaddingBottom(0);

		cell.setBorder(PdfPCell.NO_BORDER);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);

		cell.addElement(getElementoVacio());
		cell.addElement(getElementoVacio());

		// LOGOTIPOS
		cell.addElement(getTablaLogotipo(bundleMgr));
		cell.addElement(getElementoVacio());

		// REFERENCIA
		//El desgNifpas es el segundo parametro
		cell.addElement(getTablaReferencia(bean.isNumEin(), bean.getNumRef(), bundleMgr));
		cell.addElement(getElementoVacio());
		cell.addElement(getLineaHorizontal());

		// CERTIFICADO COMPLEMENTARIO
		text = bundleMgr.getString(CertificadoComplementarioPdfCts.BUNDLE_CTS_0);
		Paragraph punto0 = new Paragraph(text, fontPunto);
		punto0.setAlignment(Element.ALIGN_CENTER);
		cell.addElement(punto0);

		text = bundleMgr.getString(CertificadoComplementarioPdfCts.BUNDLE_CTS_0_3);
		Paragraph punto0_1 = new Paragraph(text, fontParrafo);
		punto0_1.setAlignment(Element.ALIGN_CENTER);
		punto0_1.setSpacingBefore(8);
		punto0_1.setLeading(10);
		cell.addElement(punto0_1);

		// APELLIDO(S)
		String campo = bundleMgr.getString(CertificadoComplementarioPdfCts.BUNDLE_CTS_0_4);
		String valor = bean.getApellidos();
		cell.addElement(getLineaTexto(campo, valor, Element.ALIGN_CENTER, 0, 0, false));

		// NOMBRE
		campo = bundleMgr.getString(CertificadoComplementarioPdfCts.BUNDLE_CTS_0_5);
		valor = bean.getNombre();
		cell.addElement(getLineaTexto(campo, valor, Element.ALIGN_CENTER, 0, 0, false));

		// NUMERO REFERENCIA EMPLEADOR
		text = bundleMgr.getString(CertificadoComplementarioPdfCts.BUNDLE_CTS_0_6);
		Paragraph numRef = new Paragraph(text, fontParrafo);
		numRef.setAlignment(Element.ALIGN_CENTER);
		numRef.setSpacingAfter(0);
		numRef.setSpacingBefore(0);
		cell.addElement(numRef);
		cell.addElement(getElementoVacio());
		cell.addElement(getTablaRefEmpleador());
		cell.addElement(getElementoVacio());

		// FECHA EXPEDICION
		campo = bundleMgr.getString(CertificadoComplementarioPdfCts.BUNDLE_CTS_0_7);
		valor = bean.getFechaexpedient();
		cell.addElement(getTablaFecha(campo, valor));
		cell.addElement(getElementoVacio());

		// FECHA EXPIRACION
		campo = bundleMgr.getString(CertificadoComplementarioPdfCts.BUNDLE_CTS_0_8);
		valor = bean.getFchaExpiracion();
		cell.addElement(getTablaFecha(campo, valor));
		cell.addElement(getElementoVacio());
		cell.addElement(getLineaHorizontal());

		// ORGANISMO EMISOR
		campo = bundleMgr.getString(CertificadoComplementarioPdfCts.BUNDLE_CTS_0_9);
		
		if(bean.getCdgoAreaAct() == 4 || bean.getCdgoAreaAct() == 38 || bean.getCdgoAreaAct() == 48) {
			valor = bundleMgr.getString(CertificadoComplementarioPdfCts.BUNDLE_CTS_0_9_3);
		}else if(bean.getCdgoAreaAct() == 9 || bean.getCdgoAreaAct() == 2 || bean.getCdgoAreaAct() == 3
				|| bean.getCdgoAreaAct() == 37) {
			valor = bundleMgr.getString(CertificadoComplementarioPdfCts.BUNDLE_CTS_0_9_2);
		}else {
			valor = bundleMgr.getString(CertificadoComplementarioPdfCts.BUNDLE_CTS_0_9_1);
		}

		cell.addElement(getLineaTextoOrg(campo, valor));
		cell.addElement(getElementoVacio());

		// DIRECCION POSTAL
		campo = bundleMgr.getString(CertificadoComplementarioPdfCts.BUNDLE_CTS_0_10);
		
		if(bean.getCdgoAreaAct() == 4 || bean.getCdgoAreaAct() == 38 || bean.getCdgoAreaAct() == 48) {
			valor = bundleMgr.getString(CertificadoComplementarioPdfCts.BUNDLE_CTS_0_10_3);
		}else if(bean.getCdgoAreaAct() == 9 || bean.getCdgoAreaAct() == 2 || bean.getCdgoAreaAct() == 3
				|| bean.getCdgoAreaAct() == 37) {
			valor = bundleMgr.getString(CertificadoComplementarioPdfCts.BUNDLE_CTS_0_10_2);
		}else {
			valor = bundleMgr.getString(CertificadoComplementarioPdfCts.BUNDLE_CTS_0_10_1);
		}
		
		cell.addElement(getLineaTexto(campo, valor));

		// MATRICULA Y SELLO
		cell.addElement(getTablaMatriculaSello(bean, bundleMgr));

		return cell;
	}

	private PdfPTable getTablaLogotipo(ResourceBundle bundleMgr) throws DocumentException {
		String text = null;

		float[] tamanoColumnas = { 50f, 21f, 20f, 9f };
		PdfPTable tabla = new PdfPTable(tamanoColumnas);
		tabla.getDefaultCell().setBorder(0);
		tabla.setHorizontalAlignment(0);
		tabla.setWidthPercentage(100.0f);

		// IMAGEN RENFE
		Image image = null;

		try {
			byte[] imageByte = Base64.getDecoder().decode(CertificadoComplementarioPdfCts.LOGO);		
			image = Image.getInstance(imageByte);
			image.scaleToFit(getPuntos(3.6f), getPuntos(1.9f));
			
		} catch (BadElementException | IOException e) {
			logger.error("ERROR  {}",e);
		}

		/*if (image != null) {
			image.setAbsolutePosition(30f, 750f);
			image.scaleAbsolute(80f, 50f);
			//document.add(image);
		}*/

		PdfPCell c = null;
		if (image != null)
			c = new PdfPCell(image);
		else
			c = new PdfPCell();
		c.setBorder(Cell.NO_BORDER);
		c.setCellEvent(new ImgRenfeEvent());
		c.setFixedHeight(getPuntos(1.9f));
		c.setVerticalAlignment(Element.ALIGN_MIDDLE);
		c.setHorizontalAlignment(Element.ALIGN_CENTER);
		tabla.addCell(c);

		// IMAGEN MODELO EUROPEO
		image = null;

		try {
			byte[] imageByte = Base64.getDecoder().decode(CertificadoComplementarioPdfCts.MODELO_EUROPEO);
			image = Image.getInstance(imageByte);
			image.scaleToFit(getPuntos(1.9f), getPuntos(1f));
			
		} catch (BadElementException | IOException e) {
			logger.error("ERROR  {}",e);
		}

		/*if (image != null) {
			image.setAbsolutePosition(30f, 750f);
			image.scaleAbsolute(80f, 50f);
		}*/

		if (image != null)
			c = new PdfPCell(image);
		else
			c = new PdfPCell();
		c.setBorder(Cell.NO_BORDER);
		c.setVerticalAlignment(Element.ALIGN_BOTTOM);
		c.setHorizontalAlignment(Element.ALIGN_CENTER);
		tabla.addCell(c);

		// MODELO EUROPEO
		c = new PdfPCell();
		c.setBorder(Cell.NO_BORDER);
		c.setVerticalAlignment(Cell.ALIGN_BOTTOM);
		text = bundleMgr.getString(CertificadoComplementarioPdfCts.BUNDLE_CTS_0_1);
		Paragraph p = new Paragraph(text, fontDato);
		p.setAlignment(Element.ALIGN_LEFT);
		p.setLeading(8f);
		p.setSpacingAfter(7f);
		c.addElement(p);
		tabla.addCell(c);

		// COLUMNA RELLENO
		c = new PdfPCell();
		c.setBorder(Cell.NO_BORDER);
		tabla.addCell(c);

		return tabla;
	}

	private PdfPTable getTablaReferencia(Boolean eur, String referencia, ResourceBundle bundleMgr) {
		String text = null;

		float[] tamanoColumnas = { 20f, 60f };
		PdfPTable tabla = new PdfPTable(tamanoColumnas);

		tabla.getDefaultCell().setBorder(0);
		tabla.setHorizontalAlignment(0);
		tabla.setWidthPercentage(100.0f);

		text = bundleMgr.getString(CertificadoComplementarioPdfCts.BUNDLE_CTS_0_2);
		tabla.addCell(new Phrase(text, fontParrafo));

		PdfPTable tablaRef = null;

		if (eur == true) {
			float[] tamanoColumnasRef = { 5f, 5f, 5f, 5f, 5f, 5f, 5f, 5f, 5f, 5f, 5f, 5f, 5f };
			tablaRef = new PdfPTable(tamanoColumnasRef);
		} else {
			float[] tamanoColumnasRef = { 5f, 5f, 5f, 5f, 5f, 5f, 5f, 5f, 5f, 5f, 5f, 5f };
			tablaRef = new PdfPTable(tamanoColumnasRef);
		}

		tablaRef.getDefaultCell().setBorder(0);
		tablaRef.setHorizontalAlignment(0);
		tablaRef.setWidthPercentage(100.0f);

		PdfPCell c = new PdfPCell(new Phrase(" ", fontCabecera));
		c.setBorder(PdfPCell.NO_BORDER);
		tablaRef.addCell(c);

		if (eur == true) {
			for (int i = referencia.length(); i < 12; i++) {
				tablaRef.addCell(getCuadro(" "));
			}

		} else {
			c.setColspan(12);
			tablaRef.addCell(c);
			for (int i = referencia.length(); i < 12; i++) {
				tablaRef.addCell(getCuadro(" "));
			}
		}

		for (int i = referencia.length() - 1; i >= 0; --i) {
			tablaRef.addCell(getCuadro(String.valueOf(referencia.charAt(referencia.length() - 1 - i))));
		}
		tabla.addCell(tablaRef);
		return tabla;
	}

	private PdfPTable getTablaRefEmpleador() {
		float[] tamanoColumnas = { 5f, 5f, 5f, 5f, 5f, 5f, 5f, 5f, 5f, 5f, 5f, 5f, 5f, 5f };
		PdfPTable tabla = new PdfPTable(tamanoColumnas);
		tabla.getDefaultCell().setBorder(0);
		tabla.setHorizontalAlignment(0);
		tabla.setWidthPercentage(100.0f);

		tabla.addCell(new Phrase(" "));
		tabla.addCell(getCuadro(" "));
		tabla.addCell(getCuadro(" "));
		tabla.addCell(getCuadro(" "));
		tabla.addCell(getCuadro(" "));
		tabla.addCell(getCuadro(" "));
		tabla.addCell(getCuadro(" "));
		tabla.addCell(getCuadro(" "));
		tabla.addCell(getCuadro(" "));
		tabla.addCell(getCuadro(" "));
		tabla.addCell(getCuadro(" "));
		tabla.addCell(getCuadro(" "));
		tabla.addCell(getCuadro(" "));
		tabla.addCell(new Phrase(" "));

		return tabla;
	}

	private PdfPTable getTablaMatriculaSello(CertificadoComplementarioBean bean, ResourceBundle bundleMgr)
			throws DocumentException {
		float[] tamanoColumnas = { 60f, 5f, 35f };
		PdfPTable tabla = new PdfPTable(tamanoColumnas);
		tabla.getDefaultCell().setBorder(0);
		tabla.setHorizontalAlignment(0);
		tabla.setWidthPercentage(100.0f);

		PdfPCell celdaIzq = new PdfPCell();
		celdaIzq.setBorder(Cell.NO_BORDER);
		// MATRICULA
		String campo = bundleMgr.getString(CertificadoComplementarioPdfCts.BUNDLE_CTS_0_11);
		String valor = bean.getMatricula();
		celdaIzq.addElement(getLineaTexto(campo, valor));
		celdaIzq.addElement(getElementoVacio());
		celdaIzq.addElement(getElementoVacio());

		celdaIzq.addElement(getLineaHorizontal());

		// SELLO
		Image image = null;

		try {
			if (bean.getCdgoAreaAct() == 4 || bean.getCdgoAreaAct() == 38 || bean.getCdgoAreaAct() == 48) {
				byte[] imageByte = Base64.getDecoder().decode(CertificadoComplementarioPdfCts.SELLOMERC);
			    image = Image.getInstance(imageByte);
			    }else if(bean.getCdgoAreaAct() == 9 || bean.getCdgoAreaAct() == 2 || bean.getCdgoAreaAct() == 3
						|| bean.getCdgoAreaAct() == 37) {
			    byte[] imageByte = Base64.getDecoder().decode(CertificadoComplementarioPdfCts.SELLOVIAJ);
				image = Image.getInstance(imageByte);	
			    }else {
			    	byte[] imageByte = Base64.getDecoder().decode(CertificadoComplementarioPdfCts.SELLO);
					image = Image.getInstance(imageByte);		
			    }

			image.scaleToFit(getPuntos(2.2f), getPuntos(2.2f));
			image.setAlignment(Element.ALIGN_CENTER);
			
		} catch (BadElementException | IOException e) {
			logger.error("ERROR  {}",e);
		}

		/*if (image != null) {
			image.setAbsolutePosition(30f, 750f);
			image.scaleAbsolute(80f, 50f);
			//document.add(image);
		}*/

		PdfPCell celdaDer = null;
		if (image != null) {
			celdaDer = new PdfPCell();
			Chunk cu = new Chunk(image, 0, 0, false);
			celdaDer.addElement(cu);
		} else {
			celdaDer = new PdfPCell();
		}
		celdaDer.setBorder(Cell.NO_BORDER);
		celdaDer.setVerticalAlignment(Element.ALIGN_MIDDLE);
		celdaDer.setPaddingTop(36);

		tabla.addCell(celdaIzq);
		tabla.addCell(new Phrase(""));
		tabla.addCell(celdaDer);

		return tabla;
	}

	/**
	 * TABLA MATERIAL
	 * 
	 * @return
	 */
	private PdfPCell getCellMaterial(CertificadoComplementarioBean bean, int numeroPaginaActual,
			ResourceBundle bundleMgr) {
		String text = null;

		PdfPCell cell = null;
		cell = new PdfPCell();
		cell.setBackgroundColor(CertificadoComplementarioPdfCts.COLOR_FONDO);
		cell.setPadding(15);
		cell.setPaddingTop(5);

		cell.setBorder(Rectangle.RIGHT);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);

		// CABECERA
		text = bundleMgr.getString(CertificadoComplementarioPdfCts.BUNDLE_CTS_CABECERA);
		Paragraph cabecera = new Paragraph(text, fontCabecera);
		cabecera.setAlignment(Element.ALIGN_CENTER);
		cell.addElement(cabecera);
		// LINEA CABECERA
		cell.addElement(getLineaHorizontal());
		cell.addElement(getElementoVacio());

		// 7. MATERIAL
		text = bundleMgr.getString(CertificadoComplementarioPdfCts.BUNDLE_CTS_7);
		Paragraph punto3 = new Paragraph(text, fontPunto);
		punto3.setAlignment(Element.ALIGN_CENTER);
		cell.addElement(punto3);

		cell.addElement(getElementoVacio());

		// TABLA MATERIAL
		cell.addElement(getTablaMaterial(bean, numeroPaginaActual, bundleMgr));

		return cell;
	}

	private PdfPTable getTablaMaterial(CertificadoComplementarioBean bean, int numeroPaginaActual,
			ResourceBundle bundleMgr) {
		PdfPCell c = null;
		String text = null;
		String descripcion = "";
		DashedLineEvent border = new DashedLineEvent(4, 4);

		float[] tamanoColumnas = { 22f, 56f, 22f };
		PdfPTable tabla = new PdfPTable(tamanoColumnas);
		tabla.getDefaultCell().setBorder(Cell.NO_BORDER);
		tabla.setHorizontalAlignment(0);
		tabla.setWidthPercentage(100.0f);

		// Fecha
		text = bundleMgr.getString(CertificadoComplementarioPdfCts.BUNDLE_CTS_7_COL_1);
		tabla.addCell(getCeldaColumna(text, border));

		// Descripcion
		text = bundleMgr.getString(CertificadoComplementarioPdfCts.BUNDLE_CTS_7_COL_2);
		tabla.addCell(getCeldaColumna(text, border));

		// Notas
		text = bundleMgr.getString(CertificadoComplementarioPdfCts.BUNDLE_CTS_7_COL_3);
		tabla.addCell(getCeldaColumna(text, border));

		int numeroFilas = 0;
		List lMaterial = bean.getListMaterial();
		if (lMaterial != null) {
			if (listNumRegPaginas != null && listNumRegPaginas.size() == numeroPaginaActual + 1) {
				int inicio = 0;
				int fin = 0;
				if (numeroPaginaActual > 0) {
					for (int i = 0; i < listNumRegPaginas.size() - 1; i++) {
						inicio += ((Integer) listNumRegPaginas.get(i)).intValue();
					}
				}
				fin = inicio + ((Integer) listNumRegPaginas.get(numeroPaginaActual)).intValue();
				if (lMaterial.size() > inicio) {
					int i = inicio;
					do {
						Map mapMaterial = (Map) lMaterial.get(i);
						logger.debug(" TAMAÑOMATERIAL {} ", lMaterial.get(i));

						// Fecha
						text = mapMaterial.get("fchaEstado").toString();
						c = getCeldaDato(text, border);
						c.setFixedHeight(((Float) listAltoCol.get(numeroFilas)).floatValue());
						tabla.addCell(c);

						// Descripcion						
						text = mapMaterial.get("serie").toString();
						if (mapMaterial.containsKey("subSerie"))
							text = text + " ("
									+ mapMaterial.get("subSerie").toString()
									+ ")";
						c = getCeldaDato(text, border);
						c.setFixedHeight(((Float) listAltoCol.get(numeroFilas)).floatValue());
						tabla.addCell(c);

						// Notas
						text = "";
						c = getCeldaDato(text, border);
						c.setFixedHeight(((Float) listAltoCol.get(numeroFilas)).floatValue());
						tabla.addCell(c);

						numeroFilas++;
						i++;
					} while (i < fin && i < lMaterial.size());
				}
			}
		}

		// Rellenamos las siguientes filas
		for (int i = numeroFilas; i <= CertificadoComplementarioPdfCts.NUMERO_ELEMENTOS_PAGINA; i++) {
			text = "";
			if (listAltoCol.size() > i) {
				c = getCeldaDato(" ", border);
				c.setFixedHeight(((Float) listAltoCol.get(i)).floatValue());
				// Fecha
				tabla.addCell(c);
				// Descripcion
				tabla.addCell(c);
				// Notas
				tabla.addCell(c);
			} else {
				tabla.addCell(getCeldaDato(text, border));
				tabla.addCell(getCeldaDato(text, border));
				tabla.addCell(getCeldaDato(text, border));
			}
		}

		return tabla;
	}

	/**
	 * TABLA INFRAESTRUCTURA FECHA Y EXTENSION
	 * 
	 * @return
	 */
	private PdfPCell getCellInfraestructuraIzq(CertificadoComplementarioBean bean, int numeroPaginaActual,
			ResourceBundle bundleMgr) {
		String text = null;

		PdfPCell cell = null;
		cell = new PdfPCell();
		cell.setBackgroundColor(CertificadoComplementarioPdfCts.COLOR_FONDO);
		cell.setPadding(15);
		cell.setPaddingTop(5);

		cell.setBorder(Rectangle.RIGHT);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);

		// CABECERA
		text = bundleMgr.getString(CertificadoComplementarioPdfCts.BUNDLE_CTS_CABECERA);
		Paragraph cabecera = new Paragraph(text, fontCabecera);
		cabecera.setAlignment(Element.ALIGN_CENTER);
		cell.addElement(cabecera);
		// LINEA CABECERA
		cell.addElement(getLineaHorizontal());
		cell.addElement(getElementoVacio());

		// 8. INFRAESTRUCTURA IZQ
		text = bundleMgr.getString(CertificadoComplementarioPdfCts.BUNDLE_CTS_8);
		Paragraph punto3 = new Paragraph(text, fontPunto);
		punto3.setAlignment(Element.ALIGN_CENTER);
		cell.addElement(punto3);

		cell.addElement(getElementoVacio());

		// TABLA INFRAESTRUCTURA IZQ
		cell.addElement(getTablaInfraestructuraIzq(bean, numeroPaginaActual, bundleMgr));

		return cell;
	}

	private PdfPTable getTablaInfraestructuraIzq(CertificadoComplementarioBean bean, int numeroPaginaActual,
			ResourceBundle bundleMgr) {
		PdfPCell c = null;
		String text = null;
		DashedLineEvent border = new DashedLineEvent(4, 4);

		float[] tamanoColumnas = { 22f, 56f, 22f };
		PdfPTable tabla = new PdfPTable(tamanoColumnas);
		tabla.getDefaultCell().setBorder(Cell.NO_BORDER);
		tabla.setHorizontalAlignment(0);
		tabla.setWidthPercentage(100.0f);

		// Fecha
		text = bundleMgr.getString(CertificadoComplementarioPdfCts.BUNDLE_CTS_8_COL_1);
		tabla.addCell(getCeldaColumna(text, border));

		// Extension
		text = bundleMgr.getString(CertificadoComplementarioPdfCts.BUNDLE_CTS_8_COL_2);
		tabla.addCell(getCeldaColumna(text, border));

		// Notas
		text = bundleMgr.getString(CertificadoComplementarioPdfCts.BUNDLE_CTS_8_COL_3);
		tabla.addCell(getCeldaColumna(text, border));

		int numeroFilas = 0;
		List lLineas = bean.getListLineas();
		List lTramos = bean.getListTramos();
		if (lLineas != null && lTramos != null) {
			if (listNumRegPaginas != null && listNumRegPaginas.size() == numeroPaginaActual + 1) {
				int inicio = 0;
				int fin = 0;
				if (numeroPaginaActual > 0) {
					for (int i = 0; i < listNumRegPaginas.size() - 1; i++) {
						inicio += ((Integer) listNumRegPaginas.get(i)).intValue();
					}
				}
				fin = inicio + ((Integer) listNumRegPaginas.get(numeroPaginaActual)).intValue();

				int totalReg = lLineas.size() + lTramos.size();
					
				if (totalReg > inicio) {
					int i = inicio;
					do {
						if (i < lLineas.size()) {
							// LINEAS
							Map mapLineas = (Map) lLineas.get(i);

							// Fecha
							text = mapLineas.get("fchaEstado").toString();
							c = getCeldaDato(text, border);
							c.setFixedHeight(((Float) listAltoCol.get(numeroFilas)).floatValue());
							tabla.addCell(c);

							// Extension
							text = "L. " + mapLineas.get("cdgoLinea").toString();
							c = getCeldaDato(text, border);
							c.setFixedHeight(((Float) listAltoCol.get(numeroFilas)).floatValue());
							tabla.addCell(c);

							// Notas
							text = "";
							c = getCeldaDato("", border);
							c.setFixedHeight(((Float) listAltoCol.get(numeroFilas)).floatValue());
							tabla.addCell(c);
						} else {
							// TRAMOS
							GetTramosOrderByCodLineaDTO mapTramos = (GetTramosOrderByCodLineaDTO) lTramos.get(i - lLineas.size());
										
							// Fecha
							SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
							text = sdf.format(mapTramos.getFchaEstado());
							c = getCeldaDato(text, border);
							c.setFixedHeight(((Float) listAltoCol.get(numeroFilas)).floatValue());
							tabla.addCell(c);

							// Extension
							text = "L. " + mapTramos.getCdgoLinea();
							c = getCeldaDato(text, border);
							c.setFixedHeight(((Float) listAltoCol.get(numeroFilas)).floatValue());
							tabla.addCell(c);

							// Notas
							text = "";
							c = getCeldaDato("", border);
							c.setFixedHeight(((Float) listAltoCol.get(numeroFilas)).floatValue());
							tabla.addCell(c);
						}

						numeroFilas++;
						i++;
					} while (i < fin && i < totalReg);
				}
			}
		}

		// Rellenamos las siguientes filas
		for (int i = numeroFilas; i < CertificadoComplementarioPdfCts.NUMERO_ELEMENTOS_PAGINA; i++) {
			text = "";
			if (listAltoCol.size() > i) {
				c = getCeldaDato(" ", border);
				c.setFixedHeight(((Float) listAltoCol.get(i)).floatValue());
				// Fecha
				tabla.addCell(c);
				// Extension
				tabla.addCell(c);
				// Notas
				tabla.addCell(c);
			} else {
				tabla.addCell(getCeldaDato(text, border));
				tabla.addCell(getCeldaDato(text, border));
				tabla.addCell(getCeldaDato(text, border));
			}
		}

		return tabla;
	}

	/**
	 * TABLA INFRAESTRUCTURA DESCRIPCION
	 * 
	 * @return
	 */
	private PdfPCell getCellInfraestructuraDer(CertificadoComplementarioBean bean, int numeroPaginaActual,
			ResourceBundle bundleMgr) {
		String text = null;

		PdfPCell cell = null;
		cell = new PdfPCell();
		cell.setBackgroundColor(CertificadoComplementarioPdfCts.COLOR_FONDO);
		cell.setPadding(15);
		cell.setPaddingTop(5);

		cell.setBorder(PdfPCell.NO_BORDER);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);

		// CABECERA
		text = bundleMgr.getString(CertificadoComplementarioPdfCts.BUNDLE_CTS_CABECERA);
		Paragraph cabecera = new Paragraph(text, fontCabecera);
		cabecera.setAlignment(Element.ALIGN_CENTER);
		cell.addElement(cabecera);
		// LINEA CABECERA
		cell.addElement(getLineaHorizontal());
		cell.addElement(getElementoVacio());

		// 8. INFRAESTRUCTURA DER
		text = bundleMgr.getString(CertificadoComplementarioPdfCts.BUNDLE_CTS_9);
		Paragraph punto3 = new Paragraph(text, fontPunto);
		punto3.setAlignment(Element.ALIGN_CENTER);
		cell.addElement(punto3);

		cell.addElement(getElementoVacio());

		// TABLA INFRAESTRUCTURA DER
		PdfPTable t = getTablaInfraestructuraDer(bean, numeroPaginaActual, bundleMgr);
		for (int i = 1; i < t.getRows().size(); i++) {
			listAltoCol.add(new Float(((PdfPRow) t.getRows().get(i)).getMaxHeights()));
		}
		cell.addElement(t);

		return cell;
	}

	private PdfPTable getTablaInfraestructuraDer(CertificadoComplementarioBean bean, int numeroPaginaActual,
			ResourceBundle bundleMgr) {
		String text = null;
		DashedLineEvent border = new DashedLineEvent(4, 4);

		float[] tamanoColumnas = { 100f };
		PdfPTable tabla = new PdfPTable(tamanoColumnas);
		tabla.getDefaultCell().setBorder(Cell.NO_BORDER);
		tabla.setHorizontalAlignment(0);
		tabla.setWidthPercentage(100.0f);
		tabla.setTotalWidth(getPuntos(anchoPagina / 3) - 15f - 8f - 2f - 7);
		tabla.setLockedWidth(true);

		// Descripcion
		text = bundleMgr.getString(CertificadoComplementarioPdfCts.BUNDLE_CTS_9_COL_1);
		tabla.addCell(getCeldaColumna(text, border));

		int numeroFilas = 0;
		List lLineas = bean.getListLineas();
		List lTramos = bean.getListTramos();
		if (lLineas != null && lTramos != null) {
			if (listNumRegPaginas != null && listNumRegPaginas.size() == numeroPaginaActual) {

				int inicio = 0;
				int fin = 0;
				if (numeroPaginaActual > 0) {
					for (int i = 0; i < listNumRegPaginas.size(); i++) {
						inicio += ((Integer) listNumRegPaginas.get(i)).intValue();
					}
				}
				fin = inicio + CertificadoComplementarioPdfCts.NUMERO_ELEMENTOS_PAGINA;

				int totalReg = lLineas.size() + lTramos.size();
				if (totalReg > inicio) {
					int i = inicio;
					do {
						if (i < lLineas.size()) {
							// LINEAS
							Map mapLineas = (Map) lLineas.get(i);

							// Descripcion
							text = mapLineas.get("descripcion").toString();
							PdfPCell c = getCeldaDato(text, border);
							tabla.addCell(c);
						} else {
							// TRAMOS
							GetTramosOrderByCodLineaDTO mapTramos = (GetTramosOrderByCodLineaDTO) lTramos.get(i - lLineas.size());

							// Descripcion
							text = mapTramos.getDesgNomLargoOrigen() + " - " + mapTramos.getDesgNomLargoDestino();
							tabla.addCell(getCeldaDato(text, border));
						}
						if (tabla.getTotalHeight() > getPuntos(altoPagina) - 68f) {
							// No cabe en la pagina
							fin = -1;
						}
						numeroFilas++;
						i++;
					} while (i < fin && i < totalReg);
					if (i == totalReg) {
						if (fin == -1) {
							// Tenemos que quitar el registro que no ha llegado
							// a verse
							// para imprimirlo en la siguiente pagina
							listNumRegPaginas.add(new Integer(numeroFilas - 1));
						} else {
							// Se ha mostrado toda la lista.
							listNumRegPaginas.add(new Integer(CertificadoComplementarioPdfCts.NUMERO_ELEMENTOS_PAGINA));
						}
					} else {
						if (fin == -1) {
							// Tenemos que quitar el registro que no ha llegado
							// a verse
							// para imprimirlo en la siguiente pagina
							listNumRegPaginas.add(new Integer(numeroFilas - 1));
						} else {
							// Se ha completado la pagina
							listNumRegPaginas.add(new Integer(numeroFilas));
						}
					}
				} else {
					// Para que siga la lista de material si quedan elementos
					listNumRegPaginas.add(new Integer(CertificadoComplementarioPdfCts.NUMERO_ELEMENTOS_PAGINA));
				}
			}
		}

		// Rellenamos las siguientes filas
		for (int i = numeroFilas; i < CertificadoComplementarioPdfCts.NUMERO_ELEMENTOS_PAGINA; i++) {
			// Descripcion
			text = "";
			tabla.addCell(getCeldaDato(text, border));
		}

		return tabla;
	}

	/**
	 * UTILIDADES
	 * 
	 * @param texto
	 * @param fecha
	 * @return
	 */
	private PdfPTable getTablaFecha(String texto, String fecha) {
		float[] tamanoColumnas = { 30f, 5f, 5f, 5f, 5f, 3f, 5f, 5f, 3f, 5f, 5f };
		int height = 14;

		PdfPTable tabla = new PdfPTable(tamanoColumnas);
		tabla.getDefaultCell().setBorder(0);
		tabla.setHorizontalAlignment(0);
		tabla.setWidthPercentage(100.0f);

		PdfPCell c = new PdfPCell(new Phrase(texto, fontDato));
		c.setBorder(PdfPCell.NO_BORDER);
		c.setVerticalAlignment(Element.ALIGN_MIDDLE);
		c.setFixedHeight(height);
		tabla.addCell(c);
		if (fecha != null && !fecha.equals("") && fecha.length() == 10) {
			tabla.addCell(getCuadro(String.valueOf(fecha.charAt(6))));
			tabla.addCell(getCuadro(String.valueOf(fecha.charAt(7))));
			tabla.addCell(getCuadro(String.valueOf(fecha.charAt(8))));
			tabla.addCell(getCuadro(String.valueOf(fecha.charAt(9))));
			tabla.addCell(getGuion());
			tabla.addCell(getCuadro(String.valueOf(fecha.charAt(3))));
			tabla.addCell(getCuadro(String.valueOf(fecha.charAt(4))));
			tabla.addCell(getGuion());
			tabla.addCell(getCuadro(String.valueOf(fecha.charAt(0))));
			tabla.addCell(getCuadro(String.valueOf(fecha.charAt(1))));
		} else {
			tabla.addCell(getCuadro(" "));
			tabla.addCell(getCuadro(" "));
			tabla.addCell(getCuadro(" "));
			tabla.addCell(getCuadro(" "));
			tabla.addCell(getGuion());
			tabla.addCell(getCuadro(" "));
			tabla.addCell(getCuadro(" "));
			tabla.addCell(getGuion());
			tabla.addCell(getCuadro(" "));
			tabla.addCell(getCuadro(" "));
		}

		return tabla;
	}

	private PdfPCell getCuadro(String texto) {
		CheckEvent ce = new CheckEvent();
		PdfPCell celda = new PdfPCell();

		Paragraph p = new Paragraph(texto, fontDato);
		p.setLeading(7);
		p.setAlignment(Paragraph.ALIGN_CENTER);

		celda.addElement(p);
		celda.setBorder(Cell.NO_BORDER);
		celda.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
		celda.setCellEvent(ce);
		celda.setFixedHeight(14);

		return celda;
	}

	private PdfPCell getGuion() {
		PdfPCell guion = new PdfPCell();
		Paragraph p = new Paragraph("-", fontDato);
		p.setAlignment(Paragraph.ALIGN_CENTER);
		p.setLeading(6);
		guion.setBorder(PdfPCell.NO_BORDER);
		guion.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
		guion.addElement(p);
		guion.setFixedHeight(14);
		return guion;
	}

	private PdfPTable getLineaTexto(String campo, String valor) {
		return getLineaTexto(campo, valor, Element.ALIGN_LEFT, 0, 0, false);
	}

	private PdfPTable getLineaTextoOrg(String campo, String valor) {
		return getLineaTextoOrg(campo, valor, Element.ALIGN_LEFT, 0, 0, false);
	}

	private PdfPTable getLineaTexto(String campo, String valor, boolean doblelinea) {
		return getLineaTexto(campo, valor, Element.ALIGN_LEFT, 0, 0, doblelinea);
	}

	private PdfPTable getLineaTexto(String campo, String valor, int alineacionCampo, int margenIzq, int margenDer,
			boolean doblelinea) {
		DashedLineEvent border = new DashedLineEvent(margenIzq, margenDer);
		PdfPTable t = new PdfPTable(1);
		t.setWidthPercentage(100f);

		PdfPCell c = new PdfPCell();
		c.setBorder(Cell.NO_BORDER);
		c.setPadding(0);
		if (doblelinea) {
			c.setMinimumHeight(14);
			c.setVerticalAlignment(Element.ALIGN_BOTTOM);
		} else {
			c.setFixedHeight(14);
		}
		c.setCellEvent(border);

		Paragraph p = null;
		if (valor != null && !valor.equals(""))
			p = new Paragraph(valor, fontDato);
		else
			p = new Paragraph(" ", fontDato);
		p.setAlignment(Element.ALIGN_LEFT);
		p.setIndentationLeft(0);
		p.setSpacingAfter(2);
		if (doblelinea)
			p.setLeading(8);

		c.addElement(p);
		t.addCell(c);
		if (campo != null && !campo.equals("")) {
			PdfPCell c2 = new PdfPCell();
			c2.setBorder(PdfPCell.NO_BORDER);
			c2.setPadding(0);

			Paragraph p_1 = null;
			p_1 = new Paragraph(campo, fontDato);
			p_1.setAlignment(alineacionCampo);
			p_1.setIndentationLeft(0);
			p_1.setLeading(10);
			c2.addElement(p_1);

			t.addCell(c2);
		}
		return t;
	}

	private PdfPTable getLineaTextoOrg(String campo, String valor, int alineacionCampo, int margenIzq, int margenDer,
			boolean doblelinea) {
		DashedLineEvent border = new DashedLineEvent(margenIzq, margenDer);
		PdfPTable t = new PdfPTable(1);
		t.setWidthPercentage(100f);

		PdfPCell c = new PdfPCell();
		c.setBorder(Cell.NO_BORDER);
		c.setPadding(0);
		if (doblelinea) {
			c.setMinimumHeight(14);
			c.setVerticalAlignment(Element.ALIGN_BOTTOM);
		} else {
			c.setFixedHeight(14);
		}
		c.setCellEvent(border);

		Paragraph p = null;
		if (valor != null && !valor.equals(""))
			p = new Paragraph(valor, fontDatoMasPeqAun);
		else
			p = new Paragraph(" ", fontDatoMasPeqAun);
		p.setAlignment(Element.ALIGN_LEFT);
		p.setIndentationLeft(0);
		p.setSpacingAfter(2);
		if (doblelinea)
			p.setLeading(8);

		c.addElement(p);
		t.addCell(c);
		if (campo != null && !campo.equals("")) {
			PdfPCell c2 = new PdfPCell();
			c2.setBorder(PdfPCell.NO_BORDER);
			c2.setPadding(0);

			Paragraph p_1 = null;
			p_1 = new Paragraph(campo, fontDatoMasPeqAun);
			p_1.setAlignment(alineacionCampo);
			p_1.setIndentationLeft(0);
			p_1.setLeading(10);
			c2.addElement(p_1);

			t.addCell(c2);
		}
		return t;
	}

	private PdfPCell getRecuadro(String texto) {
		RecuadroEvent r = new RecuadroEvent();
		PdfPCell celda = new PdfPCell();
		Paragraph p = new Paragraph(texto, fontParrafo);
		p.setSpacingAfter(5);
		p.setAlignment(Paragraph.ALIGN_CENTER);
		celda.setBorder(Cell.NO_BORDER);
		celda.setCellEvent(r);
		celda.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
		celda.addElement(p);
		return celda;
	}

	private PdfPTable getLineaHorizontal() {
		 Graphic horizontalLine = new Graphic();
		
		  horizontalLine.setHorizontalLine(0.5f, 100f, new Color(0, 0, 0),
		  Element.ALIGN_CENTER);
		 
		PdfPCell c430 = new PdfPCell(new Phrase(" "));
		c430.setBorder(PdfPCell.NO_BORDER);
	    c430.addElement(horizontalLine);
		c430.addElement(null);
		c430.setPaddingLeft(0);
		c430.setPaddingRight(0);
		PdfPTable table = new PdfPTable(1);
		table.setWidthPercentage(100.0f);
		table.addCell(c430);

		return table;
	}

	private Paragraph getElementoVacio() {
		Paragraph p = new Paragraph(" ", fontDato);
		p.setLeading(5f);
		return p;
	}

	private PdfPCell getCeldaColumna(String valor, DashedLineEvent border) {
		Paragraph p = null;

		if (valor != null && !valor.equals(""))
			p = new Paragraph(valor, fontParrafo);
		else
			p = new Paragraph(" ", fontParrafo);
		p.setLeading(9);
		p.setIndentationLeft(2);
		PdfPCell cell = new PdfPCell();
		cell.setBorder(PdfPCell.NO_BORDER);
		cell.setCellEvent(border);
		cell.addElement(p);
		return cell;
	}

	private PdfPCell getCeldaDato(String valor, DashedLineEvent border) {
		Paragraph p = null;

		if (valor != null && !valor.equals(""))
			p = new Paragraph(valor, fontDato);
		else
			p = new Paragraph(" ", fontDato);
		p.setLeading(9);
		p.setIndentationLeft(2);
		PdfPCell cell = new PdfPCell();
		cell.setBorder(PdfPCell.NO_BORDER);
		cell.setVerticalAlignment(PdfPCell.ALIGN_BOTTOM);
		cell.setCellEvent(border);
		cell.addElement(p);
		cell.setMinimumHeight(getPuntos(0.53f));
		return cell;
	}

	private class DashedLineEvent implements PdfPCellEvent {
		private int margenIzq = 0;
		private int margenDer = 0;

		public DashedLineEvent(int margenIzq, int margenDer) {
			super();
			this.margenIzq = margenIzq;
			this.margenDer = margenDer;
		}

		public void cellLayout(PdfPCell cell, Rectangle rect, PdfContentByte[] canvas) {
			PdfContentByte cb = canvas[PdfPTable.LINECANVAS];
			cb.setLineDash(2, 2, 0);
			cb.moveTo(rect.left() + this.margenIzq, rect.bottom());
			cb.lineTo(rect.right() - this.margenDer, rect.bottom());
			cb.stroke();
		}
	}

	private class RecuadroEvent implements PdfPCellEvent {
		public void cellLayout(PdfPCell cell, Rectangle rect, PdfContentByte[] canvas) {
			PdfContentByte cb = canvas[PdfPTable.LINECANVAS];
			cb.setLineWidth(0.5f);
			cb.rectangle(rect.left() + (rect.right() - rect.left()) / 2 - 15.5f,
					rect.bottom() + (rect.top() - rect.bottom()) / 2 - 7.5f, 31f, 15f);
			cb.stroke();
		}
	}

	private class CheckEvent implements PdfPCellEvent {
		public void cellLayout(PdfPCell cell, Rectangle rect, PdfContentByte[] canvas) {
			PdfContentByte cb = canvas[PdfPTable.LINECANVAS];

			cb.setLineWidth(0.5f);
			cb.rectangle(rect.left() + (rect.right() - rect.left()) / 2 - 5f,
					rect.bottom() + (rect.top() - rect.bottom()) / 2 - 5f, 10f, 10f);
			cb.stroke();
		}
	}

	private class FotoBordeEvent implements PdfPCellEvent {
		public void cellLayout(PdfPCell cell, Rectangle rect, PdfContentByte[] canvas) {
			PdfContentByte cb = canvas[PdfPTable.LINECANVAS];
			cb.setColorStroke(CertificadoComplementarioPdfCts.COLOR_FONDO);
			float ancho = getPuntos(2.85f);
			float alto = getPuntos(3.2f);
			cb.setLineWidth(0.5f);
			cb.rectangle(rect.left() + (rect.right() - rect.left()) / 2 - ancho / 2,
					rect.bottom() + (rect.top() - rect.bottom()) / 2 - alto / 2, ancho + 1, alto + 1);
			cb.stroke();
		}
	}

	private class ImgRenfeEvent implements PdfPCellEvent {
		public void cellLayout(PdfPCell cell, Rectangle rect, PdfContentByte[] canvas) {
			PdfContentByte cb = canvas[PdfPTable.LINECANVAS];
			cb.setColorStroke(CertificadoComplementarioPdfCts.COLOR_FONDO);
			float ancho = getPuntos(3.6f);
			float alto = getPuntos(1.9f);
			cb.setLineWidth(0.5f);
			cb.rectangle(rect.left() + (rect.right() - rect.left()) / 2 - ancho / 2,
					rect.bottom() + (rect.top() - rect.bottom()) / 2 - alto / 2, ancho + 1, alto + 1);
			cb.stroke();
		}
	}

	@Override
	protected void writeDocument(Object bean, ResourceBundle message, String tipoHabi, List<Tbasg260HabilifuncDto> listaFunciones) throws DocumentException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void writeDocument(Object bean) throws DocumentException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void writeDocument(Object bean, ResourceBundle message, String tipoHabi) throws DocumentException {

		// TODO Auto-generated method stub
		
	}


}
