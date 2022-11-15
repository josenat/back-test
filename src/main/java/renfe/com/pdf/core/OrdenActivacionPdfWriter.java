package renfe.com.pdf.core;

import java.awt.Color;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ResourceBundle;

import com.lowagie.text.BadElementException;
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
import com.lowagie.text.pdf.PdfPTable;

import renfe.com.model.dto.Tbasg260HabilifuncDto;
import renfe.com.pdf.beans.OrdenActivacionBean;
import renfe.com.pdf.datamanager.BundleMgr;
import renfe.com.util.OrdenActivacionPdfCts;
import renfe.com.util.OrdenSuspensionPdfCts;

import java.util.Base64;
import java.util.List;

public class OrdenActivacionPdfWriter extends AsgPdfWriter {

	private String imgPath = null;
	private Font fontCabecera = null;
	private Font fontCabeceraCursiva = null;
	private Font fontCabeceraBlanca = null;
	private Font fontParrafo = null;
	private Font fontPuntoOrden = null;
	private Font fontDatoOrden = null;
	private Font fontColumnaOrden = null;
	private Font fontParrafoBold = null;
	
	public OrdenActivacionPdfWriter(String imgPath) 
	{
        super();
        
        this.imgPath = imgPath;

        this.defaultFont =  new Font();
        this.defaultFont.setFamily(OrdenActivacionPdfCts.DEFAULT_FONT_FAMILY);        
        this.defaultFont.setSize(OrdenActivacionPdfCts.DEFAULT_FONT_SIZE);        
        
        this.defaultAlignment = OrdenActivacionPdfCts.DEFAULT_ALIGNMENT;
        
        fontCabecera = new Font();
        fontCabecera.setStyle(Font.NORMAL); 
        fontCabecera.setFamily(OrdenActivacionPdfCts.DEFAULT_FONT_FAMILY);
        fontCabecera.setSize(6f);
        
        fontCabeceraCursiva = new Font();
        fontCabeceraCursiva.setStyle(Font.ITALIC); 
        fontCabeceraCursiva.setFamily(OrdenActivacionPdfCts.DEFAULT_FONT_FAMILY);
        fontCabeceraCursiva.setSize(7f);
        fontCabeceraCursiva.setColor(OrdenActivacionPdfCts.COLOR_FONDO);

        fontCabeceraBlanca = new Font();
        fontCabeceraBlanca.setStyle(Font.ITALIC | Font.BOLD); 
        fontCabeceraBlanca.setFamily(OrdenActivacionPdfCts.DEFAULT_FONT_FAMILY);
        fontCabeceraBlanca.setSize(12f);
        fontCabeceraBlanca.setColor(OrdenActivacionPdfCts.COLOR_BLANCO);
        
        fontParrafo = new Font();
        fontParrafo.setStyle(Font.NORMAL); 
        fontParrafo.setFamily(OrdenActivacionPdfCts.DEFAULT_FONT_FAMILY);
        fontParrafo.setSize(10);
        
        fontPuntoOrden = new Font();
        fontPuntoOrden.setStyle(Font.BOLDITALIC); 
        fontPuntoOrden.setFamily(OrdenActivacionPdfCts.DEFAULT_FONT_FAMILY);
        fontPuntoOrden.setSize(9);
        
        fontDatoOrden = new Font();
        fontDatoOrden.setStyle(Font.NORMAL); 
        fontDatoOrden.setFamily(OrdenActivacionPdfCts.DEFAULT_FONT_FAMILY);
        fontDatoOrden.setSize(9);

        fontParrafoBold = new Font();
        fontParrafoBold.setStyle(Font.BOLD); 
        fontParrafoBold.setFamily(OrdenActivacionPdfCts.DEFAULT_FONT_FAMILY);
        fontParrafoBold.setSize(9);
        
        fontColumnaOrden = new Font();
        fontColumnaOrden.setStyle(Font.NORMAL); 
        fontColumnaOrden.setFamily(OrdenActivacionPdfCts.DEFAULT_FONT_FAMILY);
        fontColumnaOrden.setSize(8);

    }
	
    /* (sin Javadoc)
     * @see es.renfe.asg.pdf.AsgPdfWriter#writeDocument(java.lang.Object)
     */
    protected void writeDocument(Object object) throws DocumentException 
	{
    	OrdenActivacionBean bean = (OrdenActivacionBean) object;

        // MARCO PRIMERA PAGINA
    	PdfPTable marco = new PdfPTable(1);
    	marco.setWidthPercentage(100f);
    	marco.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
    	marco.getDefaultCell().setPadding(0);
    	marco.setExtendLastRow(true);
    	
    	// CABECERA PRIMERA PAGINA
    	marco.addCell(getCellCabecera());
    	
    	// CUERPO PRIMERA PAGINA
    	marco.addCell(getCellCuerpo(bean));
    	
    	// PIE PRIMERA PAGINA
    	marco.addCell(getCellPie(bean));
    	
    	document.add(marco);
    	
    	document.newPage();
    	
    	// MARCO SEGUNDA PAGINA
    	marco = new PdfPTable(1);
    	marco.setWidthPercentage(100f);
    	marco.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
    	marco.getDefaultCell().setPadding(0);
    	marco.setExtendLastRow(true);
    	
    	// CABECERA SEGUNDA PAGINA
    	marco.addCell(getCellCabeceraOrden());
    	
    	// CUERPO SEGUNDA PAGINA
    	PdfPCell c = new PdfPCell(getCellCuerpoOrden(bean));
    	c.setPaddingLeft(10f);
    	c.setPaddingRight(8f);
    	c.setBorder(PdfPCell.NO_BORDER);
    	marco.addCell(c);
    	
    	// PIE SEGUNDA PAGINA
    	marco.addCell(getCellPieOrden(bean));
    	
    	document.add(marco);

    }
    
    
    /////////////////////////////////////////////////////////////////////
    //                      PRIMERA PAGINA                             //
    /////////////////////////////////////////////////////////////////////
    
    /**
     * Muestra la cabecera de la primera pagina de la orden
     * de activacion
     * @return
     * @throws DocumentException
     */
	private PdfPCell getCellCabecera() throws DocumentException 
	{
		BundleMgr bundleMgr = BundleMgr.getInstance();
		
		PdfPCell celda = null;
		Paragraph p = null;
		String texto = "";
		PdfPCell c = new PdfPCell();
		c.setPadding(0f);
		c.setMinimumHeight(45f);
		c.setBorder(PdfPCell.NO_BORDER);

		float [] dimensiones = new float[]{0.65f, 1.4f, 0.8f, 1.2f};
		PdfPTable tablaCabecera = new PdfPTable(dimensiones);
		tablaCabecera.setWidthPercentage(100f);
		tablaCabecera.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
		
		// IMAGEN RENFE
        Image image = null;
        try {
            //image = Image.getInstance(this.imgPath + OrdenActivacionPdfCts.LOGO);
            byte[] imageByte = Base64.getDecoder().decode(OrdenActivacionPdfCts.LOGO);
            image = Image.getInstance(imageByte);             
            image.scaleToFit(100, 50);
        } catch (BadElementException e) {            
            throw new DocumentException(e);
        } catch (MalformedURLException e) {
            throw new DocumentException(e);
        } catch (IOException e) {
            throw new DocumentException(e);
        }
        
        celda = new PdfPCell();
        if (image != null) {
        	Chunk chunk = new Chunk(image, 0, 0, true);
        	celda.addElement(chunk);
        	celda.setPaddingTop(15);
        	celda.setPaddingLeft(0);
        }
    	celda.setBorder(PdfPCell.NO_BORDER);
        
		tablaCabecera.addCell(celda);
		
		// DEPARTAMENTO
		celda = new PdfPCell();
		texto = bundleMgr.resolve(OrdenActivacionPdfCts.BUNDLE_CTS_0_1, OrdenActivacionPdfCts.BUNDLE_NAME);
		p = new Paragraph(texto, fontCabecera);
		celda.addElement(p);
		texto = bundleMgr.resolve(OrdenActivacionPdfCts.BUNDLE_CTS_0_2, OrdenActivacionPdfCts.BUNDLE_NAME);
		p = new Paragraph(texto, fontCabecera);
		celda.setBorder(PdfPCell.NO_BORDER);
		celda.addElement(p);
		
		tablaCabecera.addCell(celda);
		
		// DIRECCION
		celda = new PdfPCell();
		texto = bundleMgr.resolve(OrdenActivacionPdfCts.BUNDLE_CTS_0_3, OrdenActivacionPdfCts.BUNDLE_NAME);
		p = new Paragraph(texto, fontCabecera);
		celda.addElement(p);
		texto = bundleMgr.resolve(OrdenActivacionPdfCts.BUNDLE_CTS_0_4, OrdenActivacionPdfCts.BUNDLE_NAME);
		p = new Paragraph(texto, fontCabecera);
		celda.addElement(p);
		texto = bundleMgr.resolve(OrdenActivacionPdfCts.BUNDLE_CTS_0_5, OrdenActivacionPdfCts.BUNDLE_NAME);
		p = new Paragraph(texto, fontCabecera);
		celda.setBorder(PdfPCell.NO_BORDER);
		celda.addElement(p);
		
		tablaCabecera.addCell(celda);
		
		// TELEFONOS
		celda = new PdfPCell();
		texto = bundleMgr.resolve(OrdenActivacionPdfCts.BUNDLE_CTS_0_6, OrdenActivacionPdfCts.BUNDLE_NAME);
		p = new Paragraph(texto, fontCabecera);
		celda.addElement(p);
		texto = bundleMgr.resolve(OrdenActivacionPdfCts.BUNDLE_CTS_0_7, OrdenActivacionPdfCts.BUNDLE_NAME);
		p = new Paragraph(texto, fontCabecera);
		celda.setBorder(PdfPCell.NO_BORDER);
		celda.addElement(p);
		
		tablaCabecera.addCell(celda);
		
		c.addElement(tablaCabecera);
		return c;
	}
	
	/**
	 * Muestra el cuerpo de la primera pagina de la orden
	 * de activacion
	 * @return
	 * @throws DocumentException
	 */
	private PdfPTable getCellCuerpo(OrdenActivacionBean bean) throws DocumentException 
	{
		PdfPTable cuerpo = new PdfPTable(1);
		cuerpo.setWidthPercentage(100f);
		cuerpo.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
		cuerpo.getDefaultCell().setPadding(0);
		
    	// NOMBRE Y CARGO CABECERA
		cuerpo.addCell(getCellNombreCargoCabecera(bean));
    	// REFERENCIA
		cuerpo.addCell(getCellReferencia(bean));
		// DESTINATARIO
		cuerpo.addCell(getCellDestinatario(bean));
    	// CC
		cuerpo.addCell(getCellCC(bean));
    	// FECHA
		cuerpo.addCell(getCellFechaDocumento(bean));
		// ASUNTO
		cuerpo.addCell(getCellAsunto(bean));
		// ESTIMADO
		cuerpo.addCell(getCellEstimado(bean));
		// EXPOSICION
		cuerpo.addCell(getCellExposicion(bean));
		// CONCLUSION
		cuerpo.addCell(getCellConclusion(bean));
		// COMUNICACION
		cuerpo.addCell(getCellComunicacion());
		// SALUDOS
		cuerpo.addCell(getCellSaludos());
		return cuerpo;
	}

	/**
	 * Muestra el pie de pagina de la primera pagina
	 * de la orden de activacion
	 * @return
	 */
	private PdfPTable getCellPie(OrdenActivacionBean bean)
	{
		BundleMgr bundleMgr = BundleMgr.getInstance();
		
		Paragraph p = null;
		String texto = "";
		PdfPCell c = null;
		float anchoBajo = 42f;

		float [] dimensiones = new float[]{5.5f, 4.5f};
		PdfPTable tabla = new PdfPTable(dimensiones);
		tabla.setWidthPercentage(100f);
		tabla.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
		tabla.getDefaultCell().setPadding(0);
		
		// Fdo
		texto = bundleMgr.resolve(OrdenActivacionPdfCts.BUNDLE_CTS_12_1, OrdenActivacionPdfCts.BUNDLE_NAME);
		p = new Paragraph(texto, fontParrafo);
		p.setLeading(12f);
		p.setAlignment(Element.ALIGN_RIGHT);
		p.setSpacingAfter(12f+anchoBajo);
		c = new PdfPCell();
		c.setPadding(0);
		c.addElement(p);
		c.setBorder(PdfPCell.NO_BORDER);
		c.setVerticalAlignment(PdfPCell.ALIGN_BOTTOM);
		tabla.addCell(c);
		
		// Fdo Der
		texto = bean.getOrderPersonDepartment(); //texto = getTextoVariable( bean , OrdenActivacionPdfCts.V_DEPARTAMENTO_ORDENANTE );
		p = new Paragraph(texto, fontParrafo);
		p.setLeading(12f);
		p.setSpacingAfter(anchoBajo);
		c = new PdfPCell();
		c.setPadding(0f);
		c.setPaddingLeft(5f);
		c.setPaddingRight(50f);
		c.setBorder(PdfPCell.NO_BORDER);
		c.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
		c.setVerticalAlignment(PdfPCell.ALIGN_BOTTOM);
		c.addElement(p);
		tabla.addCell(c);
		
		return tabla;
	}

	/**
	 * Muestra el nombre y el cargo de la cabecera de la primera
	 * pagina de la orden de activacion
	 * @param bean
	 * @return
	 */
	private PdfPCell getCellNombreCargoCabecera(OrdenActivacionBean bean) 
	{
		PdfPCell celda = null;
		Paragraph p = null;
		String texto = "";
		PdfPCell c = new PdfPCell();
		c.setPadding(0f);
		c.setMinimumHeight(45f);
		c.setBorder(PdfPCell.NO_BORDER);

		float [] dimensiones = new float[]{0.65f, 1.4f, 0.8f, 1.2f};
		PdfPTable tablaCabecera = new PdfPTable(dimensiones);
		tablaCabecera.setWidthPercentage(100f);
		tablaCabecera.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
		
		// COLUMNA 1
        celda = new PdfPCell();
    	celda.setBorder(PdfPCell.NO_BORDER);
		tablaCabecera.addCell(celda);
		
		// COLUMNA 2
		celda = new PdfPCell();
		texto = bean.getOrderPersonName(); //texto = getTextoVariable(bean, OrdenActivacionPdfCts.V_NOMBRE_ORDENANTE);
		p = new Paragraph(texto, fontCabecera);
		celda.addElement(p);
		texto = bean.getOrderPersonPosition(); //texto = getTextoVariable(bean, OrdenActivacionPdfCts.V_CARGO_ORDENANTE);
		p = new Paragraph(texto, fontCabecera);
		celda.addElement(p);
		celda.setBorder(PdfPCell.NO_BORDER);
		tablaCabecera.addCell(celda);
		
		// COLUMNA 3
		celda = new PdfPCell();
		celda.setBorder(PdfPCell.NO_BORDER);
		tablaCabecera.addCell(celda);
		
		// COLUMNA 4
		celda = new PdfPCell();
		celda.setBorder(PdfPCell.NO_BORDER);
		tablaCabecera.addCell(celda);
		
		c.addElement(tablaCabecera);
		return c;
	}

	/**
	 * Muestra la referencia de la primera pagina de la 
	 * orden de activacion
	 * @param bean
	 * @return
	 */
	private PdfPCell getCellReferencia(OrdenActivacionBean bean) 
	{
		BundleMgr bundleMgr = BundleMgr.getInstance();
		
		Paragraph p = null;
		String texto = "";
		PdfPCell c = new PdfPCell();
		c.setPadding(5f);
		c.setPaddingLeft(35f);
		c.setMinimumHeight(45f);
		c.setBorder(PdfPCell.NO_BORDER);

		// REFERENCIA
		texto = bundleMgr.resolve(OrdenActivacionPdfCts.BUNDLE_CTS_2, OrdenActivacionPdfCts.BUNDLE_NAME) + bean.getReferenceNum() + "/" + bean.getReferenceYear();

        /*
		texto = bundleMgr.resolve(OrdenActivacionPdfCts.BUNDLE_CTS_2, OrdenActivacionPdfCts.BUNDLE_NAME) +  
			getTextoVariable(bean, OrdenActivacionPdfCts.V_NUMERO_DOCUMENTO) + "/" +
			getTextoVariable(bean, OrdenActivacionPdfCts.V_ANYO_REFERENCIA);
        */

		p = new Paragraph(texto, fontParrafo);
		c.addElement(p);

		return c;
	}

	/**
	 * Muestra los datos del destinatario de la primera pagina
	 * de la orden de actviacion
	 * @param bean
	 * @return
	 */
	private PdfPCell getCellDestinatario(OrdenActivacionBean bean) 
	{
		Paragraph p = null;
		String texto = "";
		PdfPCell c = new PdfPCell();
		c.setPadding(5f);
		c.setPaddingLeft(35f);
		c.setMinimumHeight(70f);
		c.setBorder(PdfPCell.NO_BORDER);

		// DESTINATARIO NOMBRE
		texto = bean.getAddresseeName(); //texto = getTextoVariable( bean , OrdenActivacionPdfCts.V_NOMBRE_DESTINATARIO );
		p = new Paragraph(texto, fontParrafo);
		p.setLeading(14f);
		c.addElement(p);

		// DESTINATARIO CARGO
		texto = bean.getAddresseePosition(); //texto = getTextoVariable( bean , OrdenActivacionPdfCts.V_CARGO_DESTINATARIO );
		p = new Paragraph(texto, fontParrafo);
		p.setLeading(14f);
		c.addElement(p);

		// DESTINATARIO AREA
		texto = bean.getAddresseeArea(); //texto = getTextoVariable( bean , OrdenActivacionPdfCts.V_DIRECCION_GENERAL_DESTINATARIO);
		p = new Paragraph(texto, fontParrafo);
		p.setLeading(14f);
		c.addElement(p);

		return c;
	}

	/**
	 * Muestra los datos del CC de la primera pagina
	 * de la orden de activacion
	 * @param bean
	 * @return
	 */
	private PdfPTable getCellCC(OrdenActivacionBean bean) 
	{
		BundleMgr bundleMgr = BundleMgr.getInstance();
		
		Paragraph p = null;
		String texto = "";
		PdfPCell c = null;
		float anchoMinimo = 22f; 

		float [] dimensiones = new float[]{1.2f, 8.8f};
		PdfPTable tabla = new PdfPTable(dimensiones);
		tabla.setWidthPercentage(100f);
		tabla.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
		tabla.getDefaultCell().setPadding(0);
		
		// CC
		texto = bundleMgr.resolve(OrdenActivacionPdfCts.BUNDLE_CTS_4, OrdenActivacionPdfCts.BUNDLE_NAME);
		p = new Paragraph(texto, fontParrafo);
		p.setLeading(14f);
		p.setAlignment(Element.ALIGN_LEFT);
		c = new PdfPCell();
		c.setPadding(0);
		c.setPaddingLeft(35f);
		c.addElement(p);
		c.setBorder(PdfPCell.NO_BORDER);
		c.setVerticalAlignment(PdfPCell.ALIGN_RIGHT);
		tabla.addCell(c);
		
		// GERENCIA TERRITORIAL RESPONSABLE
		texto = bean.getTerritorialMgtResponsible(); //texto = getTextoVariable(bean, OrdenActivacionPdfCts.V_RESPONSABLE_GERENCIA_TERRITORIAL);
		p = new Paragraph(texto, fontParrafo);
		p.setLeading(14f);
		c = new PdfPCell();
		c.setPadding(0);
		c.setBorder(PdfPCell.NO_BORDER);
		c.setVerticalAlignment(PdfPCell.ALIGN_LEFT);
		c.addElement(p);
		tabla.addCell(c);

		// VACIA
		c = new PdfPCell();
		c.setPaddingLeft(35f);
		c.setBorder(PdfPCell.NO_BORDER);
		tabla.addCell(c);
		
		// GERENCIA TERRITORIAL NOMBRE
		texto = bean.getTerritorialMgtName(); //texto = getTextoVariable(bean, OrdenActivacionPdfCts.V_NOMBRE_GERENCIA_TERRITORIAL);
		p = new Paragraph(texto, fontParrafo);
		p.setLeading(18f);
		c = new PdfPCell();
		c.setPadding(0);
		c.setBorder(PdfPCell.NO_BORDER);
		c.setVerticalAlignment(PdfPCell.ALIGN_LEFT);
		c.addElement(p);
		tabla.addCell(c);

		// VACIA
		c = new PdfPCell();
		c.setPaddingLeft(35f);
		c.setBorder(PdfPCell.NO_BORDER);
		c.setMinimumHeight(anchoMinimo);
		tabla.addCell(c);
		
		// GERENCIA TERRITORIAL DIRECCION
		texto = bean.getTerritorialMgtAddress(); //texto = getTextoVariable(bean, OrdenActivacionPdfCts.V_DIRECCION_GERENCIA_TERRITORIAL);
		p = new Paragraph(texto, fontParrafo);
		p.setLeading(14f);
		c = new PdfPCell();
		c.setPadding(0);
		c.setBorder(PdfPCell.NO_BORDER);
		c.setVerticalAlignment(PdfPCell.ALIGN_LEFT);
		c.setMinimumHeight(anchoMinimo);
		c.addElement(p);
		tabla.addCell(c);
		
		return tabla;
	}
	
	/**
	 * Muestra el texto de la fecha del documento de la primera
	 * pagina de la orden de activacion
	 * @param bean
	 * @return
	 */
	private PdfPCell getCellFechaDocumento(OrdenActivacionBean bean) 
	{
		Paragraph p = null;
		String texto = "";
		PdfPCell c = new PdfPCell();
		c.setPadding(5f);
		c.setPaddingLeft(35f);
		c.setMinimumHeight(37f);
		c.setBorder(PdfPCell.NO_BORDER);

		// FECHA DOCUMENTO
		texto = bean.getDocumentDate(); //texto = getTextoVariable(bean, OrdenActivacionPdfCts.V_FECHA_DOCUMENTO);
		p = new Paragraph(texto, fontParrafo);
		c.addElement(p);

		return c;
	}

	/**
	 * Muestra la parte del asunto de la primera parte
	 * de la orden de activacion
	 * @param bean
	 * @return
	 */
	private PdfPCell getCellAsunto(OrdenActivacionBean bean)
	{
		BundleMgr bundleMgr = BundleMgr.getInstance();
		
		Paragraph p = null;
		String texto = "";
		PdfPCell c = new PdfPCell();
		c.setPadding(5f);
		c.setPaddingLeft(35f);
		c.setBorder(PdfPCell.NO_BORDER);
		c.addElement(getLineaHorizontal());
		
		// ASUNTO
		float [] dimensiones = new float[]{1f, 10f};
		PdfPTable tabla = new PdfPTable(dimensiones);
		tabla.setWidthPercentage(100f);
		tabla.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
		tabla.getDefaultCell().setPadding(0);

		PdfPCell celda = new PdfPCell();
		texto = bundleMgr.resolve(OrdenActivacionPdfCts.BUNDLE_CTS_6, OrdenActivacionPdfCts.BUNDLE_NAME);
		p = new Paragraph(texto, fontParrafoBold);
		p.setLeading(10f);
		celda.addElement(p);
		celda.setBorder(PdfPCell.NO_BORDER);
		tabla.addCell(celda);

		celda = new PdfPCell();
		texto = bean.getSubject(); //texto = getTextoVariable(bean, OrdenActivacionPdfCts.V_ASUNTO);
		p = new Paragraph(texto, fontParrafo);
		p.setLeading(10f);
		p.setAlignment(Element.ALIGN_JUSTIFIED);
		p.setSpacingAfter(10f);
		celda.setBorder(PdfPCell.NO_BORDER);
		celda.addElement(p);
		tabla.addCell(celda);
		
		c.addElement(tabla);
		c.addElement(getLineaHorizontal());
		
		return c;
	}

	/**
	 * Muestra el campo estimado de la primera pagina de
	 * la orden de activacion
	 * @param bean
	 * @return
	 */
	private PdfPCell getCellEstimado(OrdenActivacionBean bean)
	{
		BundleMgr bundleMgr = BundleMgr.getInstance();
		
		Paragraph p = null;
		String texto = "";
		PdfPCell c = new PdfPCell();
		c.setPadding(5f);
		c.setPaddingLeft(35f);
		c.setMinimumHeight(38f);
		c.setBorder(PdfPCell.NO_BORDER);

		// ESTIMADO
		texto = bundleMgr.resolve(OrdenActivacionPdfCts.BUNDLE_CTS_7, OrdenActivacionPdfCts.BUNDLE_NAME) + " " + bean.getAddresseeFirstName();
        /*
		texto = bundleMgr.resolve(OrdenActivacionPdfCts.BUNDLE_CTS_7, OrdenActivacionPdfCts.BUNDLE_NAME) + " " + 
			getTextoVariable(bean, OrdenActivacionPdfCts.V_NOMBRE_PILA_DESTINATARIO);
        */

		p = new Paragraph(texto, fontParrafo);
		c.addElement(p);

		return c;
	}

	/**
	 * Muestra el parrafo de exposicion de la primera pagina
	 * de la orden de activacion
	 * @param bean
	 * @return
	 */
	private PdfPCell getCellExposicion(OrdenActivacionBean bean) 
	{
		BundleMgr bundleMgr = BundleMgr.getInstance();
		
		Paragraph p = null;
		String texto = "";
		PdfPCell c = new PdfPCell();
		c.setPadding(5f);
		c.setPaddingLeft(35f);
		c.setPaddingRight(30f);
		c.setMinimumHeight(108f);
		c.setBorder(PdfPCell.NO_BORDER);

		// EXPOSICION
		texto = bundleMgr.resolve(OrdenActivacionPdfCts.BUNDLE_CTS_8_1, OrdenActivacionPdfCts.BUNDLE_NAME) + " " + 
				bean.getNombreCompleto() + " " +
				bundleMgr.resolve(OrdenActivacionPdfCts.BUNDLE_CTS_8_2, OrdenActivacionPdfCts.BUNDLE_NAME) + " " + 
				bean.getMatricula() + " " +
				bundleMgr.resolve(OrdenActivacionPdfCts.BUNDLE_CTS_8_3, OrdenActivacionPdfCts.BUNDLE_NAME) + " " + 
				bean.getNifPas() + " " +
				bundleMgr.resolve(OrdenActivacionPdfCts.BUNDLE_CTS_8_4, OrdenActivacionPdfCts.BUNDLE_NAME) + " " +
				getTextoOrdenSuspension(bean, OrdenSuspensionPdfCts.V_ARTICULO_SUSPENSION) + 
				bundleMgr.resolve(OrdenActivacionPdfCts.BUNDLE_CTS_8_5, OrdenActivacionPdfCts.BUNDLE_NAME);
		p = new Paragraph(texto, fontParrafo);
		p.setLeading(12f);
		p.setFirstLineIndent(2f);
		p.setAlignment(Element.ALIGN_JUSTIFIED);
		c.addElement(p);

		return c;
	}

	/**
	 * Muestra el texto de conclusion de la primera pagina
	 * de la orden de activacion
	 * @param bean
	 * @return
	 */
	private PdfPCell getCellConclusion(OrdenActivacionBean bean) 
	{
		BundleMgr bundleMgr = BundleMgr.getInstance();
		
		Paragraph p = null;
		String texto = "";
		PdfPCell c = new PdfPCell();
		c.setPadding(5f);
		c.setPaddingLeft(35f);
		c.setPaddingRight(20f);
		c.setMinimumHeight(38f);
		c.setBorder(PdfPCell.NO_BORDER);

		// HABILITACION A SUSPENDER
		getTextoOrdenSuspension(bean, OrdenSuspensionPdfCts.V_HABILITACION_A_SUSPENDER);
		p = new Paragraph(texto, fontParrafo);
		p.setLeading(12f);
		p.setAlignment(Element.ALIGN_JUSTIFIED);
		c.addElement(p);

		return c;
	}
	
	/**
	 * Muestra el texto de comunicacion de la primera
	 * pagina de la orden de activacion
	 * @return
	 */
	private PdfPCell getCellComunicacion() 
	{
		BundleMgr bundleMgr = BundleMgr.getInstance();
		
		Paragraph p = null;
		String texto = "";
		PdfPCell c = new PdfPCell();
		c.setPadding(5f);
		c.setPaddingLeft(35f);
		c.setMinimumHeight(28f);
		c.setBorder(PdfPCell.NO_BORDER);

		// COMUNICACION
		texto = bundleMgr.resolve(OrdenActivacionPdfCts.BUNDLE_CTS_10, OrdenActivacionPdfCts.BUNDLE_NAME);
		p = new Paragraph(texto, fontParrafo);
		p.setLeading(12f);
		c.addElement(p);

		return c;
	}

	/**
	 * Muestra el texto de saludos de la primera pagina
	 * de la orden de activacion
	 * @return
	 */
	private PdfPCell getCellSaludos() 
	{
		BundleMgr bundleMgr = BundleMgr.getInstance();
		
		Paragraph p = null;
		String texto = "";
		PdfPCell c = new PdfPCell();
		c.setPadding(5f);
		c.setPaddingLeft(35f);
		c.setMinimumHeight(20f);
		c.setBorder(PdfPCell.NO_BORDER);

		// FECHA DOCUMENTO
		texto = bundleMgr.resolve(OrdenActivacionPdfCts.BUNDLE_CTS_11, OrdenActivacionPdfCts.BUNDLE_NAME);
		p = new Paragraph(texto, fontParrafo);
		p.setLeading(12f);
		c.addElement(p);

		return c;
	}
	
    /////////////////////////////////////////////////////////////////////
    //                      SEGUNDA PAGINA                             //
    /////////////////////////////////////////////////////////////////////
	
	/**
	 * Muestra la cabecera de la segunda pagina de la orden
	 * de activacion
	 */
	private PdfPCell getCellCabeceraOrden() 
		throws DocumentException 
	{
		BundleMgr bundleMgr = BundleMgr.getInstance();
		
		PdfPCell celda = null;
		Paragraph p = null;
		String texto = "";
		PdfPCell c = new PdfPCell();
		c.setPadding(0f);
		c.setMinimumHeight(70f);
		c.setBorder(PdfPCell.NO_BORDER);
		
		PdfPCell cVacia = new PdfPCell();
		cVacia.setBorder(PdfPCell.NO_BORDER);

		float [] dimensiones = new float[]{0.65f, 1.4f, 0.8f, 1.2f};
		PdfPTable tablaCabecera = new PdfPTable(dimensiones);
		tablaCabecera.setWidthPercentage(100f);
		tablaCabecera.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
		
		// IMAGEN RENFE
        Image image = null;
        try {
            //image = Image.getInstance(this.imgPath + OrdenActivacionPdfCts.LOGO); 
            byte[] imageByte = Base64.getDecoder().decode(OrdenActivacionPdfCts.LOGO);
            image = Image.getInstance(imageByte);               
            image.scaleToFit(130, 90);
        } catch (BadElementException e) {            
            throw new DocumentException(e);
        } catch (MalformedURLException e) {
            throw new DocumentException(e);
        } catch (IOException e) {
            throw new DocumentException(e);
        }
        
        celda = new PdfPCell();
        if (image != null) {
        	Chunk chunk = new Chunk(image, 0, 0, true);
        	celda.addElement(chunk);
        	celda.setPaddingTop(15);
        	celda.setPaddingLeft(0);
        }
    	celda.setBorder(PdfPCell.NO_BORDER);
        celda.setPaddingLeft(-2f);
		tablaCabecera.addCell(celda);
		
		tablaCabecera.addCell(cVacia);
		tablaCabecera.addCell(cVacia);
		tablaCabecera.addCell(cVacia);
		
		// DIRECCION
		celda = new PdfPCell();
		texto = bundleMgr.resolve(OrdenActivacionPdfCts.BUNDLE_CTS_0_1, OrdenActivacionPdfCts.BUNDLE_NAME);
		p = new Paragraph(texto, fontCabeceraCursiva);
		p.setLeading(2f);
		celda.addElement(p);
		celda.setColspan(2);
		celda.setPadding(0f);
		celda.setPaddingLeft(10f);
		celda.setBorder(PdfPCell.NO_BORDER);
		tablaCabecera.addCell(celda);
		

		tablaCabecera.addCell(cVacia);
		tablaCabecera.addCell(cVacia);
		
		// DIRECCION 2
		celda = new PdfPCell();
		texto = bundleMgr.resolve(OrdenActivacionPdfCts.BUNDLE_CTS_0_2, OrdenActivacionPdfCts.BUNDLE_NAME);
		p = new Paragraph(texto, fontCabeceraCursiva);
		p.setLeading(9f);
		celda.addElement(p);
		celda.setColspan(2);
		celda.setPadding(0f);
		celda.setPaddingLeft(10f);
		celda.setBorder(PdfPCell.NO_BORDER);
		tablaCabecera.addCell(celda);
		
		tablaCabecera.addCell(cVacia);
		tablaCabecera.addCell(cVacia);
		
		c.addElement(tablaCabecera);
		return c;
	}

	/**
	 * Muestra el cuerpo de la segunda pagina
	 * de la orden de activacion
	 * @return
	 */
	private PdfPTable getCellCuerpoOrden(OrdenActivacionBean bean) 
	{
		PdfPTable cuerpo = new PdfPTable(1);
		cuerpo.setWidthPercentage(100f);
		cuerpo.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
		cuerpo.getDefaultCell().setPadding(0f);
		
    	// CABECERA CUERPO
		cuerpo.addCell(getCellCabeceraCuerpo(bean));
		// ORDENANTE Y FECHAS
		cuerpo.addCell(getCellOrdenante(bean));
		// AGENTE
		cuerpo.addCell(getCellAgente(bean));
		// HABILITACION A ACTIVAR
		cuerpo.addCell(getCellHabilitacionActivar(bean));
		// MOTIVO
		cuerpo.addCell(getCellMotivo(bean));
		// RECIBI
		cuerpo.addCell(getCellRecibi());
		return cuerpo;
	}

	/**
	 * Muestra el pie de la segunda pagina de la
	 * orden de activacion
	 * @param bean
	 * @return
	 */
	private PdfPTable getCellPieOrden(OrdenActivacionBean bean)
	{
		BundleMgr bundleMgr = BundleMgr.getInstance();
		
		Paragraph p = null;
		String texto = "";
		PdfPCell c = null;
		float anchoBajo = 42f;

		float [] dimensiones = new float[]{0.6f, 2.2f, 0.5f, 2.7f};
		PdfPTable tabla = new PdfPTable(dimensiones);
		tabla.setWidthPercentage(100f);
		tabla.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
		tabla.getDefaultCell().setPadding(0);
		
		// Fdo:
		texto = bundleMgr.resolve(OrdenActivacionPdfCts.BUNDLE_CTS_P2_9, OrdenActivacionPdfCts.BUNDLE_NAME);
		p = new Paragraph(texto, fontParrafo);
		p.setLeading(12f);
		p.setAlignment(Element.ALIGN_RIGHT);
		p.setSpacingAfter(100f);
		
		c = new PdfPCell();
		c.setPadding(0);
		c.addElement(p);
		c.setBorder(PdfPCell.NO_BORDER);
		c.setVerticalAlignment(PdfPCell.ALIGN_BOTTOM);
		tabla.addCell(c);		
		
		// Fdo Izq
		texto = getTextoConstante(bean, OrdenActivacionPdfCts.C_011_FIRMADO_AREA);
		p = new Paragraph(texto, fontParrafo);
		p.setLeading(12f);
		p.setAlignment(Element.ALIGN_LEFT);
		p.setSpacingAfter(88f);
		
		c = new PdfPCell();
		c.setPadding(0);
		c.setPaddingLeft(5f);
		c.setPaddingRight(65f);
		c.addElement(p);
		c.setBorder(PdfPCell.NO_BORDER);
		c.setVerticalAlignment(PdfPCell.ALIGN_BOTTOM);
		tabla.addCell(c);
		
		// Fdo
		texto = bundleMgr.resolve(OrdenActivacionPdfCts.BUNDLE_CTS_P2_9, OrdenActivacionPdfCts.BUNDLE_NAME);
		p = new Paragraph(texto, fontParrafo);
		p.setLeading(12f);
		p.setAlignment(Element.ALIGN_RIGHT);
		p.setSpacingAfter(12f+anchoBajo);
		
		c = new PdfPCell();
		c.setPadding(0);
		c.addElement(p);
		c.setBorder(PdfPCell.NO_BORDER);
		c.setVerticalAlignment(PdfPCell.ALIGN_BOTTOM);
		tabla.addCell(c);
		
		// Fdo Der
		texto = bean.getOrderPersonDepartment(); //texto = getTextoVariable(bean, OrdenActivacionPdfCts.V_DEPARTAMENTO_ORDENANTE);
		p = new Paragraph(texto, fontParrafo);
		p.setLeading(12f);
		p.setSpacingAfter(anchoBajo);
		c = new PdfPCell();
		c.setPadding(0f);
		c.setPaddingLeft(5f);
		c.setPaddingRight(50f);
		c.setBorder(PdfPCell.NO_BORDER);
		c.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
		c.setVerticalAlignment(PdfPCell.ALIGN_BOTTOM);
		c.addElement(p);
		tabla.addCell(c);

		return tabla;
	}
	
	/**
	 * Muestra la cabecera del cuerpo de la segunda pagina
	 * de la orden de activacion
	 * @param bean
	 * @return
	 */
	private PdfPCell getCellCabeceraCuerpo(OrdenActivacionBean bean)
	{
		BundleMgr bundleMgr = BundleMgr.getInstance();
		
		Paragraph p = null;
		String texto = "";
		PdfPCell c = new PdfPCell();
		c.setPadding(2f);
		c.setBackgroundColor(OrdenActivacionPdfCts.COLOR_FONDO);
		c.setMinimumHeight(20f);

		// CABECERA
		texto = bundleMgr.resolve(OrdenActivacionPdfCts.BUNDLE_CTS_P2_0, OrdenActivacionPdfCts.BUNDLE_NAME) + "     " +
				bean.getCdgoReferenciaDoc();
		p = new Paragraph(texto, fontCabeceraBlanca);
		p.setLeading(12f);
		c.addElement(p);

		return c;
		
	}

	/**
	 * Muestra los textos de ordenante, fecha de entrada y fecha
	 * efectiva de suspension y la fecha efectiva de activacion
	 * de la segunda pagina de la orden de activacion
	 * @param bean
	 * @return
	 */
	private PdfPTable getCellOrdenante(OrdenActivacionBean bean)
	{
		BundleMgr bundleMgr = BundleMgr.getInstance();
		
		Paragraph p = null;
		String texto = "";
		CeldaDatoEvent ce = new CeldaDatoEvent(); 
		
		PdfPCell c = new PdfPCell();
		c.setPadding(0f);
		c.setBorder(PdfPCell.NO_BORDER);
		
		float [] dimensiones = {0.6f, 2.2f, 1.7f};
		PdfPTable tabla = new PdfPTable(dimensiones);
		tabla.setWidthPercentage(100f);
		tabla.getDefaultCell().setBorder(PdfPCell.NO_BORDER);

		// ORDENANTE
		texto = bundleMgr.resolve(OrdenActivacionPdfCts.BUNDLE_CTS_P2_1, OrdenActivacionPdfCts.BUNDLE_NAME);
		p = new Paragraph(texto, fontPuntoOrden);
		c = new PdfPCell();
		c.setPadding(0f);
		c.setPaddingLeft(2f);
		c.setMinimumHeight(32f);
		c.setBorder(PdfPCell.NO_BORDER);
		c.setVerticalAlignment(PdfPCell.ALIGN_BOTTOM);
		c.addElement(p);
		
		tabla.addCell(c);
		
		c = new PdfPCell();
		c.setPadding(0f);
		c.setPaddingLeft(2f);
		c.setColspan(2);
		texto = getTextoConstante(bean, OrdenActivacionPdfCts.C_010_ORDENANTE);
		p = new Paragraph(texto, fontDatoOrden);
		c.addElement(p);
		c.setBorder(PdfPCell.NO_BORDER);
		c.setVerticalAlignment(PdfPCell.ALIGN_BOTTOM);
		c.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
		tabla.addCell(c);
		
		PdfPCell cVacia = new PdfPCell();
		cVacia.setBorder(PdfPCell.NO_BORDER);
		cVacia.setFixedHeight(10f);
		tabla.addCell(cVacia);
		tabla.addCell(cVacia);
		tabla.addCell(cVacia);

		// FECHA DE ENTRADA SUSPENSION
		c = new PdfPCell();
		c.setPadding(0f);
		c.setPaddingLeft(2f);
		c.setColspan(2);
		c.setMinimumHeight(24f);
		c.setBorder(PdfPCell.NO_BORDER);
		texto = bundleMgr.resolve(OrdenActivacionPdfCts.BUNDLE_CTS_P2_2, OrdenActivacionPdfCts.BUNDLE_NAME);
		p = new Paragraph(texto, fontPuntoOrden);
		c.addElement(p);
		tabla.addCell(c);
		
		c = new PdfPCell();
		c.setPadding(0f);
		c.setPaddingLeft(2f);
		c.setBorder(PdfPCell.NO_BORDER);
		c.setCellEvent(ce);
		texto = getTextoOrdenSuspension(bean, OrdenActivacionPdfCts.V_FECHA_ENTRADA_SUSPENSION); //AQUI
		p = new Paragraph(texto, fontDatoOrden);
		p.setIndentationLeft(22f);
		c.addElement(p);
		tabla.addCell(c);

		// FECHA EFECTIVA SUSPENSION
		c = new PdfPCell();
		c.setPadding(0f);
		c.setPaddingLeft(2f);
		c.setColspan(2);
		c.setMinimumHeight(24f);
		c.setBorder(PdfPCell.NO_BORDER);
		texto = bundleMgr.resolve(OrdenActivacionPdfCts.BUNDLE_CTS_P2_3, OrdenActivacionPdfCts.BUNDLE_NAME);
		p = new Paragraph(texto, fontPuntoOrden);
		c.addElement(p);
		tabla.addCell(c);
		
		c = new PdfPCell();
		c.setPadding(0f);
		c.setPaddingLeft(2f);
		c.setBorder(PdfPCell.NO_BORDER);
		c.setCellEvent(ce);
		texto = getTextoOrdenSuspension(bean, OrdenActivacionPdfCts.V_FECHA_EFECTIVA_SUSPENSION); //AQUI
		p = new Paragraph(texto, fontDatoOrden);
		p.setIndentationLeft(22f);
		c.addElement(p);
		tabla.addCell(c);
		
		// FECHA EFECTIVA ACTIVACION
		c = new PdfPCell();
		c.setPadding(0f);
		c.setPaddingLeft(2f);
		c.setColspan(2);
		c.setMinimumHeight(24f);
		c.setBorder(PdfPCell.NO_BORDER);
		texto = bundleMgr.resolve(OrdenActivacionPdfCts.BUNDLE_CTS_P2_4, OrdenActivacionPdfCts.BUNDLE_NAME);        
		p = new Paragraph(texto, fontPuntoOrden);
		c.addElement(p);
		tabla.addCell(c);
		
		c = new PdfPCell();
		c.setPadding(0f);
		c.setPaddingLeft(2f);
		c.setBorder(PdfPCell.NO_BORDER);
		c.setCellEvent(ce);  
		texto = bean.getActivationDate(); //texto = getTextoVariable(bean, OrdenActivacionPdfCts.V_FECHA_EFECTIVA);
		p = new Paragraph(texto, fontDatoOrden);
		p.setIndentationLeft(22f);
		c.addElement(p);
		tabla.addCell(c);

		
		return tabla;
	}
	
	/**
	 * Muestra la seccion de los datos del agente de la segunda
	 * pagina de la orden de activacion
	 * @param bean
	 * @return
	 */
	private PdfPCell getCellAgente(OrdenActivacionBean bean)
	{
		BundleMgr bundleMgr = BundleMgr.getInstance();
		
		Paragraph p = null;
		String texto = "";
		PdfPCell c = new PdfPCell();
		c.setPadding(0f);
		c.setMinimumHeight(60f);
		c.setBorder(PdfPCell.NO_BORDER);

		// TITULO AGENTE
		texto = bundleMgr.resolve(OrdenActivacionPdfCts.BUNDLE_CTS_P2_5, OrdenActivacionPdfCts.BUNDLE_NAME);
		p = new Paragraph(texto, fontPuntoOrden);
		p.setIndentationLeft(2f);
		p.setSpacingAfter(18f);
		p.setSpacingBefore(2f);
		c.addElement(p);
		
		// TABLA AGENTE
		float[] dimensiones = {2f, 0.6f, 0.7f, 2f};
		PdfPTable tabla = new PdfPTable(dimensiones);
		tabla.setWidthPercentage(100f);
		
		// COLUMNA NOMBRE Y APELLIDOS
		texto = bundleMgr.resolve(OrdenActivacionPdfCts.BUNDLE_CTS_P2_5_1, OrdenActivacionPdfCts.BUNDLE_NAME);
		p = new Paragraph(texto, fontColumnaOrden);
		PdfPCell celda = new PdfPCell(p);
		celda.setBackgroundColor(OrdenActivacionPdfCts.COLOR_FONDO_TABLA);
		celda.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
		tabla.addCell(celda);
		
		// COLUMNA MATRICULA
		texto = bundleMgr.resolve(OrdenActivacionPdfCts.BUNDLE_CTS_P2_5_2, OrdenActivacionPdfCts.BUNDLE_NAME);
		p = new Paragraph(texto, fontColumnaOrden);
		celda = new PdfPCell(p);
		celda.setBackgroundColor(OrdenActivacionPdfCts.COLOR_FONDO_TABLA);
		celda.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
		tabla.addCell(celda);
		
		// COLUMNA DNI
		texto = bundleMgr.resolve(OrdenActivacionPdfCts.BUNDLE_CTS_P2_5_3, OrdenActivacionPdfCts.BUNDLE_NAME);
		p = new Paragraph(texto, fontColumnaOrden);
		celda = new PdfPCell(p);
		celda.setBackgroundColor(OrdenActivacionPdfCts.COLOR_FONDO_TABLA);
		celda.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
		tabla.addCell(celda);
		
		// COLUMNA DIRECCION GENERAL
		texto = bundleMgr.resolve(OrdenActivacionPdfCts.BUNDLE_CTS_P2_5_4, OrdenActivacionPdfCts.BUNDLE_NAME);
		p = new Paragraph(texto, fontColumnaOrden);
		celda = new PdfPCell(p);
		celda.setBackgroundColor(OrdenActivacionPdfCts.COLOR_FONDO_TABLA);
		celda.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
		tabla.addCell(celda);
		
		// COLUMNA NOMBRE Y APELLIDOS
		texto = bean.getNombreCompleto();
		p = new Paragraph(texto, fontDatoOrden);
		celda = new PdfPCell(p);
		celda.setMinimumHeight(38f);
		celda.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
		tabla.addCell(celda);
		
		// COLUMNA MATRICULA
		texto = bean.getMatricula();
		p = new Paragraph(texto, fontDatoOrden);
		celda = new PdfPCell(p);
		celda.setMinimumHeight(38f);
		celda.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
		tabla.addCell(celda);
		
		// COLUMNA DNI
		texto = bean.getNifPas();
		p = new Paragraph(texto, fontDatoOrden);
		celda = new PdfPCell(p);
		celda.setMinimumHeight(38f);
		celda.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
		tabla.addCell(celda);
		
		// COLUMNA DIRECCION GENERAL
		texto = bean.getAreaActividad();
		p = new Paragraph(texto, fontDatoOrden);
		celda = new PdfPCell(p);
		celda.setMinimumHeight(38f);
		celda.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
		tabla.addCell(celda);
		
		c.addElement(tabla);

		return c;
	}
	
	/**
	 * Muestra la seccion de la habilitacion de la segunda pagina
	 * de la orden de activacion
	 * @param bean
	 * @return
	 */
	private PdfPCell getCellHabilitacionActivar(OrdenActivacionBean bean)
	{
		BundleMgr bundleMgr = BundleMgr.getInstance();
		
		Paragraph p = null;
		String texto = "";
		PdfPCell c = new PdfPCell();
		c.setPadding(0f);
		c.setPaddingTop(5f);
		c.setMinimumHeight(60f);
		c.setBorder(PdfPCell.NO_BORDER);

		// TITULO
		texto = bundleMgr.resolve(OrdenActivacionPdfCts.BUNDLE_CTS_P2_6, OrdenActivacionPdfCts.BUNDLE_NAME);
		p = new Paragraph(texto, fontPuntoOrden);
		p.setIndentationLeft(2f);
		p.setSpacingAfter(12f);
		p.setSpacingBefore(2f);
		c.addElement(p);
		
		// TABLA 
		PdfPTable tabla = new PdfPTable(1);
		tabla.setWidthPercentage(100f);
		
		// COLUMNA
		getTextoOrdenSuspension(bean, OrdenSuspensionPdfCts.V_HABILITACION_A_SUSPENDER); //AQUI
		p = new Paragraph(texto, fontDatoOrden);
		p.setIndentationLeft(4f);
		p.setLeading(10f);
		PdfPCell celda = new PdfPCell();
		celda.setPaddingLeft(2f);
		celda.setMinimumHeight(20f);
		celda.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
		celda.addElement(p);
		tabla.addCell(celda);
		
		c.addElement(tabla);

		return c;
	}

	/**
	 * Muestra la seccion del motivo de la segunda pagina
	 * de la orden de activacion
	 * @param bean
	 * @return
	 */
	private PdfPCell getCellMotivo(OrdenActivacionBean bean)
	{
		BundleMgr bundleMgr = BundleMgr.getInstance();
		
		Paragraph p = null;
		String texto = "";
		PdfPCell c = new PdfPCell();
		c.setPadding(0f);
		c.setMinimumHeight(60f);
		c.setBorder(PdfPCell.NO_BORDER);

		// TITULO
		texto = bundleMgr.resolve(OrdenActivacionPdfCts.BUNDLE_CTS_P2_7, OrdenActivacionPdfCts.BUNDLE_NAME);
		p = new Paragraph(texto, fontPuntoOrden);
		p.setIndentationLeft(2f);
		p.setSpacingAfter(12f);
		p.setSpacingBefore(2f);
		c.addElement(p);
		
		// TABLA 
		PdfPTable tabla = new PdfPTable(1);
		tabla.setWidthPercentage(100f);
		
		// COLUMNA
		texto = bean.getActivationReason(); //texto = getTextoVariable(bean, OrdenActivacionPdfCts.V_MOTIVO_ACTIVACION);
		p = new Paragraph(texto, fontDatoOrden);
		p.setIndentationLeft(4f);
		p.setLeading(10f);
		p.setAlignment(Element.ALIGN_JUSTIFIED);
		PdfPCell celda = new PdfPCell();
		celda.setPadding(4f);
		celda.setPaddingRight(8f);
		celda.setMinimumHeight(67f);
		celda.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
		celda.addElement(p);
		tabla.addCell(celda);
		
		c.addElement(tabla);

		return c;
	}

	/**
	 * Muestra el texto de recibi de la segunda pagina
	 * de la orden de activacion
	 * @return
	 */
	private PdfPCell getCellRecibi()
	{
		BundleMgr bundleMgr = BundleMgr.getInstance();
		
		Paragraph p = null;
		String texto = "";
		PdfPCell c = new PdfPCell();
		c.setPadding(0f);
		c.setPaddingLeft(40f);
		c.setPaddingTop(10f);
		c.setMinimumHeight(22f);
		c.setBorder(PdfPCell.NO_BORDER);

		// TITULO
		texto = bundleMgr.resolve(OrdenActivacionPdfCts.BUNDLE_CTS_P2_8, OrdenActivacionPdfCts.BUNDLE_NAME);
		p = new Paragraph(texto, fontParrafo);
		c.addElement(p);

		return c;
	}

	
	////////////////////////////////////////////////////////////////////
	//                      UTILIDADES                                //
	////////////////////////////////////////////////////////////////////
	
	/**
	 * Devuelve la cadena asociada a una constante
	 * @param bean
	 * @param clave
	 * @return
	 */
	private String getTextoConstante(OrdenActivacionBean bean, String clave) 
	{
		String texto = "";
		if (bean.getHsDatoPlantDoc().containsKey(clave)) {
			texto = (String)bean.getHsDatoPlantDoc().get(clave);
		}
		return texto;
	}
	
	/**
	 * devuelve la cadena asociada a una variable
	 * @param bean
	 * @param clave
	 * @return
	 */
	private String getTextoVariable(OrdenActivacionBean bean, Integer clave)
	{
		String texto = "";
		if (bean.getHsDocOrdenActiDato().containsKey(clave)) {
			texto = (String)bean.getHsDocOrdenActiDato().get(clave);
		}
		return texto;
	}
	
	/**
	 * devuelve la cadena asociada a una variable
	 * @param bean
	 * @param clave
	 * @return
	 */
	private String getTextoOrdenSuspension(OrdenActivacionBean bean, Integer clave)
	{
		String texto = "";
		if (bean.getHsDocOrdenSuspDato().containsKey(clave)) {
			texto = (String)bean.getHsDocOrdenSuspDato().get(clave);
		}
		return texto;
	}	
	
	////////////////////////////////////////////////////////////////////
	//                  UTILIDADES GRAFICAS                           //
	////////////////////////////////////////////////////////////////////

	/**
	 * Muestra una linea horizontal
	 */
    private PdfPTable getLineaHorizontal()
    {
        Graphic horizontalLine = new Graphic();
        horizontalLine.setHorizontalLine(1f, 100f, new Color(0,0,0), Element.ALIGN_CENTER);
        PdfPCell c430 = new PdfPCell(new Phrase (" "));
        c430.setBorder(PdfPCell.NO_BORDER);
        c430.addElement(horizontalLine);
        c430.setPaddingLeft(0);
        c430.setPaddingRight(0);
        PdfPTable table = new PdfPTable(1);
        table.setWidthPercentage(100.0f);
        table.addCell(c430);
        
        return table;
    }
    
    /**
     * Clase interna para mostrar el recuadro en las fechas
     */
    private class CeldaDatoEvent implements PdfPCellEvent {
    	public void cellLayout(PdfPCell cell, Rectangle rect, PdfContentByte[] canvas) {
    		PdfContentByte cb = canvas[PdfPTable.LINECANVAS];

    	    cb.setLineWidth(1f);
    	    cb.rectangle(rect.left() , rect.bottom() + 4f, 100f, 20f);
    	    cb.stroke();  	    
    	}
    }
    
	
	protected void writeDocument(Object bean, ResourceBundle message)
			throws DocumentException {
		// TODO Apéndice de método generado automáticamente
		
	}
	
	@Override
	protected void writeDocument(Object bean, ResourceBundle message,
			String tipoHabi) throws DocumentException {
		// TODO Apéndice de método generado automáticamente
		
	}

	@Override
	protected void writeDocument(Object bean, ResourceBundle message, String tipoHabi,
			List<Tbasg260HabilifuncDto> listaFunciones) throws DocumentException {
		// TODO Auto-generated method stub
		
	}


}
