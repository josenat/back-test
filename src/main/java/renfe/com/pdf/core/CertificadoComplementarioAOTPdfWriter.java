//PPM102758 - Certificado Complementario AOT
package renfe.com.pdf.core;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import renfe.com.model.dto.Tbasg260HabilifuncDto;
import renfe.com.model.entity.Tbasg260Habilifunc;
import renfe.com.pdf.beans.CertificadoComplementarioAOTBean;
import renfe.com.util.CertificadoComplementarioAOTPdfCts;
import renfe.com.util.CertificadoComplementarioPdfCts;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;

import javax.annotation.Resource;

public class CertificadoComplementarioAOTPdfWriter extends AsgPdfWriter {

    private String imgPath_1 = null;
    private String imgPath_2 = null;
    private Font fontCabecera = null;
    private Font fontPunto = null;
    private Font fontParrafo = null;
    private Font fontDato = null;
    private Font fontDatoPeq = null;
    private Font fontTitulo = null;
    private ArrayList listAltoCol = new ArrayList();
    private ArrayList listNumRegPaginas = new ArrayList();
	private float proporcion = 1.00f;
	private float anchoPagina = 25.6f * proporcion; // cm
	private float altoPagina = 19.05f * proporcion; // cm
	private URL logo = CertificadoComplementarioAOTPdfWriter.class.getClassLoader().getResource(CertificadoComplementarioAOTPdfCts.logo);
	private URL sello = CertificadoComplementarioAOTPdfWriter.class.getClassLoader().getResource(CertificadoComplementarioAOTPdfCts.sello);
	private URL selloMerc = CertificadoComplementarioAOTPdfWriter.class.getClassLoader().getResource(CertificadoComplementarioAOTPdfCts.selloMerc);
	
	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(CertificadoComplementarioAOTPdfWriter.class);
    
    public CertificadoComplementarioAOTPdfWriter(String imgPath_1, String imgPath_2) {
    	
        super();
        
        this.imgPath_1 = imgPath_1;
        this.imgPath_2 = imgPath_2;
        
        this.defaultFont =  new Font();
        this.defaultFont.setFamily(CertificadoComplementarioAOTPdfCts.DEFAULT_FONT_FAMILY);        
        this.defaultFont.setSize(CertificadoComplementarioAOTPdfCts.DEFAULT_FONT_SIZE);        
        
        this.defaultAlignment = CertificadoComplementarioAOTPdfCts.DEFAULT_ALIGNMENT;
        
        fontCabecera = createFont(new int[]{Font.NORMAL}); 
        fontCabecera.setFamily(CertificadoComplementarioAOTPdfCts.DEFAULT_FONT_FAMILY);
        fontCabecera.setSize(6.5f);
        
        fontPunto = createFont(new int[]{Font.BOLD}); 
        fontPunto.setFamily(CertificadoComplementarioAOTPdfCts.DEFAULT_FONT_FAMILY);
        fontPunto.setSize(11);
    	
        fontParrafo = createFont(new int[]{Font.NORMAL}); 
        fontParrafo.setFamily(CertificadoComplementarioAOTPdfCts.DEFAULT_FONT_FAMILY);
        fontParrafo.setSize(11);
        
        fontDato = createFont(new int[]{Font.NORMAL});
        fontDato.setFamily(CertificadoComplementarioAOTPdfCts.DEFAULT_FONT_FAMILY);
        fontDato.setSize(10);

        fontDatoPeq = createFont(new int[]{Font.NORMAL});
        fontDatoPeq.setFamily(CertificadoComplementarioAOTPdfCts.DEFAULT_FONT_FAMILY);
        fontDatoPeq.setSize(7.5f);
        
        fontTitulo = createFont(new int[]{Font.BOLD});
        fontTitulo.setFamily(CertificadoComplementarioAOTPdfCts.DEFAULT_FONT_FAMILY);
        fontTitulo.setSize(16);
        
    }
    
    /**
     * Pasa los centimetros a puntos del pdf
     * @param centimetros
     * @return float
     */
    public float getPuntos(float centimetros) {
    	return (72f * centimetros)/ 2.54f;
    }

    protected void writeDocument(Object object,ResourceBundle bundleMgr,String sTipoHabi, List<Tbasg260HabilifuncDto> listaFunciones) throws DocumentException {
    	
    	CertificadoComplementarioAOTBean bean = (CertificadoComplementarioAOTBean) object;

      	// MARCO
	    PdfPTable marco = new PdfPTable(1);
	    marco.setWidthPercentage(100f);
	        
	    // PRIMERA PAGINA
	    PdfPTable tablePagina1 = new PdfPTable(2);
	    tablePagina1.setTotalWidth(new float[]{ getPuntos(anchoPagina/2), 
												getPuntos(anchoPagina/2)});
	    tablePagina1.setLockedWidth(true);
	    tablePagina1.setHorizontalAlignment(Element.ALIGN_CENTER);
	    tablePagina1.setWidthPercentage(100.0f);
	    tablePagina1.setSplitLate(false);
	    PdfPCell c1 = getCellIzquierda(bean,bundleMgr);
	    c1.setFixedHeight(getPuntos(altoPagina));
	    c1.setBorder(Rectangle.BOX);
        c1.setBorderWidth(2);
	    tablePagina1.addCell(c1);
	    PdfPCell c2 = getCellDerecha(bean,bundleMgr);
	    c2.setFixedHeight(getPuntos(altoPagina));
	    c2.setBorder(Rectangle.BOX);
        c2.setBorderWidth(2);
	    tablePagina1.addCell(c2);
	    
	    PdfPCell cellMarco = new PdfPCell(tablePagina1);
	    cellMarco.setBorder(Cell.NO_BORDER);
	    cellMarco.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
	    marco.addCell(cellMarco);
	    document.add(marco);
	    
	    
	 	// SEGUNDA PAGINA
        PdfPTable tablePagina2 = new PdfPTable(1);
        int numeroPaginaActual = 0;
        	
        document.newPage();
        	
    	// MARCO
    	marco = new PdfPTable(1);
    	marco.setWidthPercentage(100f);

    	tablePagina2 = new PdfPTable(1);
        tablePagina2.setTotalWidth(new float[]{ getPuntos(anchoPagina)});
        tablePagina2.setLockedWidth(true);
        tablePagina2.setHorizontalAlignment(Element.ALIGN_CENTER);
        tablePagina2.setWidthPercentage(100.0f);
		PdfPCell celdaInferior = getCellInferior(bean,bundleMgr,sTipoHabi, listaFunciones);
        celdaInferior.setBorder(Rectangle.BOX);
        celdaInferior.setBorderWidth(2);
        celdaInferior.setPaddingLeft(0);
        tablePagina2.setSplitLate(false);
        tablePagina2.addCell(celdaInferior);
        
        cellMarco = new PdfPCell(tablePagina2);
        cellMarco.setBorder(Cell.NO_BORDER);
        cellMarco.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        marco.addCell(cellMarco);
        document.add(marco);
        
    }
    
    private PdfPCell getCellIzquierda(CertificadoComplementarioAOTBean bean,ResourceBundle bundleMgr )
    {
    	String text = null;
    	
    	PdfPCell cell = new PdfPCell();
    	cell.setBorder(Cell.NO_BORDER);
    	cell.setPaddingLeft(5);
    	cell.setPaddingRight(5);
        cell.setPaddingTop(50);
        
    	PdfPTable tablaCeldaIzquierda = new PdfPTable(1);
    	tablaCeldaIzquierda.setTotalWidth(100.0f);
    	
    	PdfPCell celda = new PdfPCell();
    	
    	// DATOS
        celda.addElement(getTablaDatos(bean.getEmpresa(), bean.getFchaFinPsicoFisico(), bundleMgr));
        celda.setBorder(Cell.NO_BORDER);
        celda.setFixedHeight(80);
        tablaCeldaIzquierda.addCell(celda);
        
        celda = new PdfPCell(getElementoVacio());
        celda.setColspan(2);
        celda.setFixedHeight(40);
        celda.setBorder(Cell.NO_BORDER);
        tablaCeldaIzquierda.addCell(celda);
        
        // COMPETENCIAS LING��STICAS
        text = bundleMgr.getString(CertificadoComplementarioAOTPdfCts.BUNDLE_CTS_0_3_0);
        celda = new PdfPCell();
        Paragraph tituloCompetenciasLinguisticas = new Paragraph(text, fontPunto);
        tituloCompetenciasLinguisticas.setAlignment(Element.ALIGN_LEFT);
        celda.addElement(tituloCompetenciasLinguisticas);
        celda.setBorder(Cell.NO_BORDER);
        celda.setFixedHeight(40);
        tablaCeldaIzquierda.addCell(celda);
        
        // TABLA COMPETENCIAS LING��STICAS
        celda = new PdfPCell();
        celda.addElement(getTablaCompetenciasLinguisticas(bean.getListInformacionAdic(),bundleMgr));
        celda.setBorder(Cell.NO_BORDER);
        celda.setFixedHeight(120);
        tablaCeldaIzquierda.addCell(celda);
        
        celda = new PdfPCell(getElementoVacio());
        celda.setBorder(Cell.NO_BORDER);
        celda.setFixedHeight(60);
        tablaCeldaIzquierda.addCell(celda);
        
        // OBSERVACIONES
      //INICIO PPM 168672 23/05/2019 
        celda = new PdfPCell();
        celda.addElement(getTablaObservaciones(bean.getListObservaciones(),bundleMgr));
        celda.setFixedHeight(100);
        celda.setBorder(Cell.NO_BORDER);
        tablaCeldaIzquierda.addCell(celda);
    	
    	cell.addElement(tablaCeldaIzquierda);
    	// FIN PPM 168672 23/05/2019 
    	return cell;
    }
    
    private PdfPCell getCellDerecha(CertificadoComplementarioAOTBean bean, ResourceBundle bundleMgr) throws DocumentException
    {
       	String text = null;
    	
    	PdfPCell cell = new PdfPCell();
    	cell.setBorder(Cell.NO_BORDER);
    	cell.setPaddingLeft(5);
    	cell.setPaddingRight(5);
        cell.setPaddingTop(5);
        
        PdfPTable tablaCeldaDerecha = new PdfPTable(1);
        tablaCeldaDerecha.setTotalWidth(100.0f);
        
        // LOGO RENFE
        PdfPCell celda = new PdfPCell(getTablaLogo());
        celda.setBorder(Cell.NO_BORDER);
        celda.setPaddingTop(5);
        tablaCeldaDerecha.addCell(celda);
        
        celda = new PdfPCell(getElementoVacio());
        celda.setBorder(Cell.NO_BORDER);
        tablaCeldaDerecha.addCell(celda);
    	
        // CABECERA
        celda = new PdfPCell();
        celda.addElement(getTablaCabecera(bundleMgr));
        celda.setBorder(Cell.NO_BORDER);
        tablaCeldaDerecha.addCell(celda);
        
        celda = new PdfPCell(getElementoVacio());
        celda.setBorder(Cell.NO_BORDER);
        celda.setFixedHeight(40);
        tablaCeldaDerecha.addCell(celda);
        
        // DATOS PERSONALES
        celda = new PdfPCell(getTablaDatosPersonales(bean,bundleMgr));
        celda.setBorder(Cell.NO_BORDER);
        celda.setFixedHeight(140);
        tablaCeldaDerecha.addCell(celda);
        
        celda = new PdfPCell(getElementoVacio());
        celda.setBorder(Cell.NO_BORDER);
        celda.setFixedHeight(20);
        tablaCeldaDerecha.addCell(celda);
        
        // DATOS HABILITACI�N
        celda = new PdfPCell(getTablaDatosHabilitacion(bean.getFchaExpedicion(), bean.getFchaExpiracion(),bundleMgr));
        celda.setBorder(Cell.NO_BORDER);
        celda.setFixedHeight(60);
        tablaCeldaDerecha.addCell(celda);
        
        celda = new PdfPCell(getElementoVacio());
        celda.setBorder(Cell.NO_BORDER);
        celda.setFixedHeight(110);
        celda.setColspan(1);
        tablaCeldaDerecha.addCell(celda);
        
        // FIRMA
        celda = new PdfPCell(getTablaFirma(bundleMgr));
        celda.setBorder(Cell.NO_BORDER);
        tablaCeldaDerecha.addCell(celda);
        
        cell.addElement(tablaCeldaDerecha);
        
        return cell;
    }
    
    private PdfPCell getCellInferior(CertificadoComplementarioAOTBean bean,ResourceBundle bundleMgr, String sTipoHabi, List<Tbasg260HabilifuncDto> listaFunciones) throws DocumentException{
    	    	
    	String text = null;
    	
    	PdfPCell cell = new PdfPCell();
    	cell.setBorder(Cell.NO_BORDER);
    	cell.setPaddingLeft(-5);
    	cell.setPaddingRight(-5);
        cell.setPaddingTop(5);
        
    	PdfPTable tablaInferior = new PdfPTable(1);
    	tablaInferior.setTotalWidth(100.0f);
    	tablaInferior.setSplitLate(false);
    	
    	// TITULO TABLA Y LOGO
    	PdfPCell celda = new PdfPCell(getTituloLogo(bundleMgr));
        celda.setBorder(Cell.NO_BORDER);
        celda.setFixedHeight(40);
        tablaInferior.addCell(celda);
        
        celda = new PdfPCell(getElementoVacio());
        celda.setBorder(Cell.NO_BORDER);
        tablaInferior.addCell(celda);
        
        // TABLA FUNCIONES
        
        //  Recupero las funciones de base de datos
        
        /*List<Tbasg260Habilifunc> listaFunciones = new ArrayList<Tbasg260Habilifunc>();
        
        //  Tengo que recuperar el idioma y los tipos de habilitacion 
        
        String[] valores = sTipoHabi.split("\\$");
        int num = valores.length;
        logger.debug("valores {} ", valores.length);
        
        List<Integer> listHabilitaciones = new ArrayList();

        int[] intArray = new int[num];
        for(int x=0;x<num;x++) 
        {
        	intArray[x] = Integer.valueOf(valores[x]);
        	listHabilitaciones.add(intArray[x]);
        }
     
        String cdgoIdioma = bundleMgr.getLocale().getCountry();         
        logger.debug("cdgoIdioma {} ", cdgoIdioma);
        logger.debug("listHabilitaciones {} ", listHabilitaciones);
        
		try {
	          //listaFunciones = this.tbasg260HabilifuncRepository.getFuncionesAsocHabil(listHabilitaciones, cdgoIdioma);
	        
		} catch (Exception e) {
			logger.error("ERROR  {}",e);	
		}*/
        //List<Tbasg260Habilifunc> listaFunciones = new ArrayList<Tbasg260Habilifunc>();

		celda = new PdfPCell(getTablaFunciones(listaFunciones,bundleMgr));
        celda.setBorder(Cell.NO_BORDER);
        tablaInferior.addCell(celda);
        
        celda = new PdfPCell(getElementoVacio());
        celda.setBorder(Cell.NO_BORDER);
        celda.setFixedHeight(20);
        tablaInferior.addCell(celda);
                
        // FIRMA
        celda = new PdfPCell(getEspacioFirma(bundleMgr));
        celda.setBorder(Cell.NO_BORDER);
        celda.setFixedHeight(15);
        tablaInferior.addCell(celda);
        
        celda = new PdfPCell(getElementoVacio());
        celda.setBorder(Cell.NO_BORDER);
        celda.setFixedHeight(40);
        tablaInferior.addCell(celda);
        
        // CONDICIONES Y FECHA
        celda = new PdfPCell(getCondiciones(bean,bundleMgr));
        celda.setBorder(Cell.NO_BORDER);
        tablaInferior.addCell(celda);
    	
    	cell.addElement(tablaInferior);
    	
    	return cell;
    	
    }

	private PdfPTable getTablaDatos(String empresa, String fechaPsicoFisico,ResourceBundle bundleMgr)
    {

    	String text = null;
    	
        float[] tamanoColumnas = {40f,60f};
    	PdfPTable tabla = new PdfPTable(tamanoColumnas);
    	tabla.getDefaultCell().setBorder(Cell.NO_BORDER);
    	tabla.getDefaultCell().setFixedHeight(30);
    	tabla.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
    	tabla.setHorizontalAlignment(0);
    	tabla.setWidthPercentage(100.0f);
    	
    	text = bundleMgr.getString(CertificadoComplementarioAOTPdfCts.BUNDLE_CTS_0_1);
    	tabla.addCell(new Phrase(text, fontParrafo));

    	text = empresa;
    	tabla.addCell(new Phrase(text, fontPunto));
    	
    	text = bundleMgr.getString(CertificadoComplementarioAOTPdfCts.BUNDLE_CTS_0_2);
    	tabla.addCell(new Phrase(text, fontParrafo));

    	text = fechaPsicoFisico;
    	tabla.addCell(new Phrase(text,fontPunto));
    	
    	return tabla;
    }
    
    private PdfPTable getTablaCompetenciasLinguisticas(List lConocimientos, ResourceBundle bundleMgr)
    {
     	String text = null;
    	
        float[] tamanoColumnas = {50f, 50f};
    	PdfPTable tabla = new PdfPTable(tamanoColumnas);
    	tabla.setHorizontalAlignment(0);
    	tabla.setWidthPercentage(100.0f);

    	text = bundleMgr.getString(CertificadoComplementarioAOTPdfCts.BUNDLE_CTS_0_3_1);
    	PdfPCell celda = new PdfPCell(new Phrase(text, fontParrafo));
    	celda.setHorizontalAlignment(Cell.ALIGN_CENTER);
    	celda.setBorderWidth(1.5f);
    	celda.setFixedHeight(25);
    	tabla.addCell(celda);
    	
    	text = bundleMgr.getString(CertificadoComplementarioAOTPdfCts.BUNDLE_CTS_0_3_2);
    	celda = new PdfPCell(new Phrase(text, fontParrafo));
    	celda.setHorizontalAlignment(Cell.ALIGN_CENTER);
    	celda.setBorderWidth(1.5f);
    	celda.setFixedHeight(25);
    	tabla.addCell(celda);
    	
    	int numeroMinimoFilas = 3;
    	int numeroFilas = 0;
    	if (lConocimientos != null && lConocimientos.size()>0) {
    		HashMap hsConocimiento = null;
	    	for (int i=0; i<lConocimientos.size(); i++) {
	    		hsConocimiento = (HashMap)lConocimientos.get(i);
	    		celda = new PdfPCell(new Phrase((String)hsConocimiento.get("lengua"), fontDato));
	        	celda.setHorizontalAlignment(Cell.ALIGN_CENTER);
	        	celda.setFixedHeight(25);
	        	celda.setBorderWidth(1.5f);
	        	tabla.addCell(celda);
	        	celda = new PdfPCell(new Phrase((String)hsConocimiento.get("nivel"), fontDato));
	        	celda.setHorizontalAlignment(Cell.ALIGN_CENTER);
	        	celda.setFixedHeight(25);
	        	celda.setBorderWidth(1.5f);
	        	tabla.addCell(celda);
	        	numeroFilas++;
	    	}
    	}
    	// Rellenamos las siguientes filas
    	for (int i=numeroFilas;i<numeroMinimoFilas;i++) {
    		celda = new PdfPCell(getElementoVacio());
        	celda.setHorizontalAlignment(Cell.ALIGN_CENTER);
        	celda.setFixedHeight(25);
        	celda.setBorderWidth(1.5f);
        	tabla.addCell(celda);
        	celda = new PdfPCell(getElementoVacio());
        	celda.setHorizontalAlignment(Cell.ALIGN_CENTER);
        	celda.setFixedHeight(25);
        	celda.setBorderWidth(1.5f);
        	tabla.addCell(celda);	
    	}
    	
    	return tabla;
    }
//INICIO PPM 168672 23/05/2019 
    private PdfPTable getTablaObservaciones(List listObservacionesExt, ResourceBundle bundleMgr)
    {
    	String text = null;
    	
        float[] tamanoColumnas = {45f, 55f};
    	PdfPTable tabla = new PdfPTable(tamanoColumnas);
    	tabla.setHorizontalAlignment(0);
    	tabla.setWidthPercentage(100.0f);

    	text = bundleMgr.getString(CertificadoComplementarioAOTPdfCts.BUNDLE_CTS_0_4);
    	PdfPCell celda = new PdfPCell(new Phrase(text, fontParrafo));
    	celda.setBorder(Cell.NO_BORDER);
    	tabla.addCell(celda);
    	
    	
    	int numeroMinimoFilas = 3;
    	int numeroFilas = 0;
    	if (listObservacionesExt != null && listObservacionesExt.size()>0) {
    		HashMap hsObserva = null;
	    	for (int i=0; i<listObservacionesExt.size(); i++) {
	    		hsObserva = (HashMap)listObservacionesExt.get(i);
	    		celda = new PdfPCell(new Phrase((String)hsObserva.get("observacionExt"), fontParrafo));
	    		celda.setBorder(Rectangle.BOTTOM);
		    	//celda.setFixedHeight(15);
		    	tabla.addCell(celda);
	    		celda = new PdfPCell(getElementoVacio());
	        	celda.setBorder(Cell.NO_BORDER);
	        	//celda.setFixedHeight(15);
	        	tabla.addCell(celda);	    			
	        	numeroFilas++;
	    	}
    	}
    	
    	// Rellenamos las siguientes filas
    	for (int i = numeroFilas; i < numeroMinimoFilas; i++) {        	
        	celda = new PdfPCell(getElementoVacio());
        	celda.setBorder(Rectangle.BOTTOM);
        	//celda.setFixedHeight(15);
        	tabla.addCell(celda);
        	celda = new PdfPCell(getElementoVacio());
        	celda.setBorder(Cell.NO_BORDER);
        	//celda.setFixedHeight(15);
        	tabla.addCell(celda);
        	numeroFilas++;
    	}
    	
    	return tabla;
    }
    // FIN PPM 168672 23/05/2019
    private PdfPTable getTablaLogo() throws DocumentException
    {
    	//BundleMgr bundleMgr = BundleMgr.getInstance();
    	String text = null;
    	
    	float[] tamanoColumnas = {60f, 40f};
    	PdfPTable tabla = new PdfPTable(tamanoColumnas);
    	tabla.setHorizontalAlignment(0);
    	tabla.setWidthPercentage(100.0f);
    	
    	PdfPCell celda = new PdfPCell(getElementoVacio());
    	celda.setBorder(Cell.NO_BORDER);
    	celda.setColspan(1);
    	tabla.addCell(celda);
    	
    	// IMAGEN RENFE
        Image image = null;
        try {
            //image = Image.getInstance(this.imgPath_1 + CertificadoComplementarioAOTPdfCts.LOGO);
        	//byte[] imageByte = Base64.getDecoder().decode(CertificadoComplementarioAOTPdfCts.LOGO);		
			image = Image.getInstance(logo);
            image.scaleToFit(getPuntos(3.6f), getPuntos(1.7f));
        } catch (BadElementException e) {            
            throw new DocumentException(e);
        } catch (MalformedURLException e) {
            throw new DocumentException(e);
        } catch (IOException e) {
            throw new DocumentException(e);
        }
        PdfPCell c = null;
        if (image != null)
        	c = new PdfPCell(image);
        else
        	c = new PdfPCell();
    	c.setBorder(Cell.NO_BORDER);
        c.setFixedHeight(getPuntos(1.7f));
    	c.setVerticalAlignment(Element.ALIGN_MIDDLE);
        c.setHorizontalAlignment(Element.ALIGN_CENTER);
    	tabla.addCell(c);
    	
    	return tabla;
    
    }
    
    private PdfPTable getTablaCabecera(ResourceBundle bundleMgr) throws DocumentException
    {
    	String text = null;
    	
        float[] tamanoColumnas = {40f, 60f};
    	PdfPTable tabla = new PdfPTable(tamanoColumnas);
    	tabla.setHorizontalAlignment(0);
    	tabla.setWidthPercentage(100.0f);
    	tabla.getDefaultCell().setBorder(Cell.NO_BORDER);
    
    	// FOTO
        Image image = null;
        /*try {
            image = Image.getInstance(this.imgPath_2); 
            image.scaleToFit(getPuntos(2.85f), getPuntos(3.2f));
        } catch (BadElementException e) {            
        } catch (MalformedURLException e) {
        } catch (IOException e) {
        }*/
        PdfPCell celdaFoto = null;
        if (image != null)
        	celdaFoto = new PdfPCell(image);
        else
        	celdaFoto = new PdfPCell();
        
        celdaFoto.setBorder(Cell.NO_BORDER);
        celdaFoto.setVerticalAlignment(Element.ALIGN_MIDDLE);
        celdaFoto.setPaddingLeft(0);
        celdaFoto.setHorizontalAlignment(Element.ALIGN_LEFT);
    	
    	tabla.addCell(celdaFoto);
    	
    	
    	// TITULO
    	PdfPTable tablaTitulo = new PdfPTable(1);
    	tablaTitulo.setTotalWidth(100.0f);

    	text = bundleMgr.getString(CertificadoComplementarioAOTPdfCts.BUNDLE_CTS_1_0);
    	PdfPCell celda = new PdfPCell(new Phrase(text, fontTitulo));
    	celda.setHorizontalAlignment(Cell.ALIGN_RIGHT);
    	celda.setBorder(Cell.NO_BORDER);
    	celda.setBorderColor(Color.WHITE);
    	tablaTitulo.addCell(celda);
    	
    	celda = new PdfPCell(getElementoVacio());
    	celda.setBorder(Cell.NO_BORDER);
    	celda.setColspan(1);
    	tablaTitulo.addCell(celda);
    	
    	text = bundleMgr.getString(CertificadoComplementarioAOTPdfCts.BUNDLE_CTS_1_1);
    	celda = new PdfPCell(new Phrase(text, fontPunto));
    	celda.setHorizontalAlignment(Cell.ALIGN_RIGHT);
    	celda.setBorder(Cell.NO_BORDER);
    	celda.setBorderColor(Color.WHITE);
    	tablaTitulo.addCell(celda);
    
    	tabla.addCell(tablaTitulo);
  	
    	return tabla;
    }
    
    private PdfPTable getTablaDatosPersonales(CertificadoComplementarioAOTBean bean, ResourceBundle bundleMgr)
    {
       	String text = null;
    	
        float[] tamanoColumnas = {45f,55f};
    	PdfPTable tabla = new PdfPTable(tamanoColumnas);
    	tabla.getDefaultCell().setBorder(Cell.NO_BORDER);
    	tabla.getDefaultCell().setFixedHeight(30);
    	tabla.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
    	tabla.setHorizontalAlignment(0);
    	tabla.setWidthPercentage(100.0f);

    	text = bundleMgr.getString(CertificadoComplementarioAOTPdfCts.BUNDLE_CTS_1_2);
    	tabla.addCell(new Phrase(text, fontParrafo));
    	tabla.getDefaultCell().setColspan(1);
    	text = bean.getNifPas();
    	tabla.addCell(new Phrase(text, fontPunto));
    	tabla.getDefaultCell().setColspan(1);
    	
    	text = bundleMgr.getString(CertificadoComplementarioAOTPdfCts.BUNDLE_CTS_1_3);
    	tabla.addCell(new Phrase(text, fontParrafo));
    	text = bean.getApellidos();
    	tabla.addCell(new Phrase(text,fontPunto));
    	
    	text = bundleMgr.getString(CertificadoComplementarioAOTPdfCts.BUNDLE_CTS_1_4);
    	tabla.addCell(new Phrase(text, fontParrafo));
    	text = bean.getNombre();
    	tabla.addCell(new Phrase(text,fontPunto));
    	
    	text = bundleMgr.getString(CertificadoComplementarioAOTPdfCts.BUNDLE_CTS_1_5);
    	tabla.addCell(new Phrase(text, fontParrafo));
    	text = bean.getFchaNacimiento();
    	
    	tabla.addCell(new Phrase(text,fontPunto));
    	
    	return tabla;
    }
    
    private PdfPTable getTablaDatosHabilitacion(String fchaExpedicion, String fchaExpiracion, ResourceBundle bundleMgr)
    {
     	String text = null;
    	
        float[] tamanoColumnas = {45f,55f};
    	PdfPTable tabla = new PdfPTable(tamanoColumnas);
    	tabla.getDefaultCell().setBorder(Cell.NO_BORDER);
    	tabla.getDefaultCell().setFixedHeight(30);
    	tabla.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
    	tabla.setHorizontalAlignment(0);
    	tabla.setWidthPercentage(100.0f);
    	
    	text = bundleMgr.getString(CertificadoComplementarioAOTPdfCts.BUNDLE_CTS_1_6);
    	tabla.addCell(new Phrase(text, fontParrafo));
    	
    	text = fchaExpedicion;
    	tabla.addCell(new Phrase(text, fontPunto));
    	
    	text = bundleMgr.getString(CertificadoComplementarioAOTPdfCts.BUNDLE_CTS_1_7);
    	tabla.addCell(new Phrase(text, fontParrafo));
    	
    	text = fchaExpiracion;
    	tabla.addCell(new Phrase(text,fontPunto));
    	
    	return tabla;
    }
    
    private PdfPTable getTablaFirma(ResourceBundle bundleMgr)
    {
    	String text = null;
    	
    	float[] tamanoColumnas = {50f,50f};
    	PdfPTable tabla = new PdfPTable(tamanoColumnas);
    	tabla.setHorizontalAlignment(0);
    	tabla.setWidthPercentage(100.0f);
    	
    	PdfPCell celda = new PdfPCell(getElementoVacio());
    	celda.setBorder(Cell.NO_BORDER);
    	celda.setColspan(1);

    	text = bundleMgr.getString(CertificadoComplementarioAOTPdfCts.BUNDLE_CTS_1_8);
    	celda = new PdfPCell(new Phrase(text, fontParrafo));
    	    	
    	celda.setBorder(Rectangle.TOP);
    	celda.setVerticalAlignment(Cell.ALIGN_BOTTOM);
    	celda.setHorizontalAlignment(Cell.ALIGN_RIGHT);
    	
    	tabla.addCell(celda);
    	
    	return tabla;
    	
    }
   
	private PdfPTable getTituloLogo(ResourceBundle bundleMgr) throws DocumentException 
	{
		String text = null;
    	
    	float[] tamanoColumnas = {70f, 30f};
    	PdfPTable tabla = new PdfPTable(tamanoColumnas);
    	tabla.setHorizontalAlignment(0);
    	tabla.setWidthPercentage(100.0f);
    	
    	text = bundleMgr.getString(CertificadoComplementarioAOTPdfCts.BUNDLE_CTS_2_0);
    	PdfPCell celda = new PdfPCell(new Phrase(text, fontPunto));
    	celda.setBorder(Cell.NO_BORDER);
    	celda.setColspan(1);
    	celda.setVerticalAlignment(Cell.ALIGN_BOTTOM);
    	tabla.addCell(celda);
    	
    	// IMAGEN RENFE
        Image image = null;
        try {
            //image = Image.getInstance(this.imgPath_1 + CertificadoComplementarioAOTPdfCts.LOGO);
        	//Image imageByte = CertificadoComplementarioAOTPdfCts.logo;		
			image = Image.getInstance(logo);
            image.scaleToFit(getPuntos(3.6f), getPuntos(1.7f));
        } catch (Exception e) {
            throw new DocumentException(e);
        }
        PdfPCell c = null;
        if (image != null)
        	c = new PdfPCell(image);
        else
        	c = new PdfPCell();
    	c.setBorder(Cell.NO_BORDER);
        c.setFixedHeight(getPuntos(1.7f));
    	c.setVerticalAlignment(Element.ALIGN_TOP);
        c.setHorizontalAlignment(Element.ALIGN_RIGHT);
    	tabla.addCell(c);
    	
    	return tabla;
    
	}
    
	private PdfPTable getTablaFunciones(List listaFunciones,ResourceBundle bundleMgr) 
	{
	   	String text = null;
    	
        float[] tamanoColumnas = {5f, 95f};
    	PdfPTable tabla = new PdfPTable(tamanoColumnas);
    	tabla.setHorizontalAlignment(0);
    	tabla.setWidthPercentage(100.0f);
    	    	
       	PdfPCell celda = null;
    	   	
       	text = bundleMgr.getString(CertificadoComplementarioAOTPdfCts.BUNDLE_CTS_2_0_x);
    	String mensaje = null;
    		
    	for (int i = 0; i < listaFunciones.size(); i++){
    		celda = new PdfPCell(new Phrase(text, fontPunto));
    		celda.setBorder(Rectangle.BOX);
    		celda.setBorderWidth(1.5f);
    		celda.setHorizontalAlignment(Cell.ALIGN_CENTER);
    		celda.setVerticalAlignment(Cell.ALIGN_MIDDLE);
    		tabla.addCell(celda);
    		
    		Tbasg260HabilifuncDto hab = (Tbasg260HabilifuncDto) listaFunciones.get(i);
    	
    		celda = new PdfPCell(new Phrase(hab.getDescMensaje(), fontParrafo));
    		celda.setBorder(Rectangle.BOX);
    		celda.setBorderWidth(1.5f);
    		tabla.addCell(celda);
    	}
    	
    	return tabla;
    	
	}
	
	private PdfPTable getEspacioFirma(ResourceBundle bundleMgr) {
		
		String text = null;
    	
    	float[] tamanoColumnas = {70f,30f};
    	PdfPTable tabla = new PdfPTable(tamanoColumnas);
    	tabla.setHorizontalAlignment(0);
    	tabla.setWidthPercentage(100.0f);
    	
    	PdfPCell celda = new PdfPCell();
    	celda.setBorder(Cell.NO_BORDER);
    	tabla.addCell(celda);
    	
    	text = bundleMgr.getString(CertificadoComplementarioAOTPdfCts.BUNDLE_CTS_2_1);
    	celda = new PdfPCell(new Phrase(text, fontParrafo));
    	celda.setBorder(Rectangle.BOX);
    	celda.setFixedHeight(15);
    	celda.setHorizontalAlignment(Cell.ALIGN_CENTER);
    	tabla.addCell(celda);
    	
    	return tabla;
	}
	
	private PdfPTable getCondiciones(CertificadoComplementarioAOTBean bean, ResourceBundle bundleMgr) throws DocumentException {
		
		String text = null;
    	
    	float[] tamanoColumnas = {70f,30f};
    	PdfPTable tabla = new PdfPTable(tamanoColumnas);
    	tabla.setHorizontalAlignment(0);
    	tabla.setWidthPercentage(100.0f);
    	
    	//Primera parte condiciones
    	text = bundleMgr.getString(CertificadoComplementarioAOTPdfCts.BUNDLE_CTS_2_2_1);
    	PdfPCell celda = new PdfPCell(new Phrase(text, fontDatoPeq));
    	celda.setBorder(Cell.NO_BORDER);
    	celda.setFixedHeight(100);
    	celda.setVerticalAlignment(Cell.ALIGN_BOTTOM);
    	tabla.addCell(celda);
    	
    	// SELLO
        Image image = null;

        try {
        	if (bean.getCdgoAreaAct() == 4) {
              //image = Image.getInstance(this.imgPath_1 + CertificadoComplementarioAOTPdfCts.SELLOMERC);
        		//Image imageByte = CertificadoComplementarioAOTPdfCts.selloMerc;		
			    image = Image.getInstance(selloMerc);
        	}else {
        		//image = Image.getInstance(this.imgPath_1 + CertificadoComplementarioAOTPdfCts.SELLO);
        		//Image imageByte = CertificadoComplementarioAOTPdfCts.sello;
        		image = Image.getInstance(sello);
        		}	
		    
            image.scaleToFit(getPuntos(3.0f), getPuntos(3.0f));
            image.setAlignment(Element.ALIGN_CENTER);
        } catch (Exception e) {
            throw new DocumentException(e);
        }
    	PdfPCell celdaSello = null;
    	if (image != null) {
    		celdaSello = new PdfPCell();
    		Chunk cu = new Chunk(image, 0, 0, false);
    		celdaSello.addElement(cu);
    	}
    	else {
    		celdaSello = new PdfPCell();
    	}
    	celdaSello.setBorder(Cell.NO_BORDER);
    	celdaSello.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	celdaSello.setHorizontalAlignment(Element.ALIGN_RIGHT);
    	celdaSello.setFixedHeight(100);
    	
    	tabla.addCell(celdaSello);
    	
    	//Segunda parte condiciones
    	text = bundleMgr.getString(CertificadoComplementarioAOTPdfCts.BUNDLE_CTS_2_2_2);
    	celda = new PdfPCell(new Phrase(text, fontDatoPeq));
    	celda.setBorder(Cell.NO_BORDER);
    	tabla.addCell(celda);
    	
    	//Fecha
    	PdfPCell celdaTabla = new PdfPCell();
    	celdaTabla.setBorder(Cell.NO_BORDER);
    	
    	PdfPTable tabla2 = new PdfPTable(1);
    	tabla2.setHorizontalAlignment(0);
    	tabla2.setWidthPercentage(100.0f);
    	
    	text = bundleMgr.getString(CertificadoComplementarioAOTPdfCts.BUNDLE_CTS_2_3);
    	celda = new PdfPCell(new Phrase(text, fontParrafo));
    	celda.setBorder(Cell.NO_BORDER);
    	celda.setHorizontalAlignment(Cell.ALIGN_BOTTOM);
    	tabla2.addCell(celda);
    	
    	celda = new PdfPCell(getElementoVacio());
    	celda.setBorder(Cell.NO_BORDER);
    	tabla2.addCell(celda);
    	
    	Date fecha = new Date();
    	SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
    	text = df.format(fecha);
    	celda = new PdfPCell(new Phrase(text, fontPunto));
    	celda.setBorder(Rectangle.BOTTOM);
    	celda.setHorizontalAlignment(Cell.ALIGN_BOTTOM);
    	celda.setHorizontalAlignment(Cell.ALIGN_CENTER);
    	tabla2.addCell(celda);
    	
    	celdaTabla.addElement(tabla2);
    	
    	tabla.addCell(celdaTabla);
    	
    	return tabla;
	}
    
    private PdfPCell getCuadro(String texto)
    {
    	CheckEvent ce = new CheckEvent(); 
        PdfPCell celda = new PdfPCell();
        
        Paragraph p = new Paragraph (texto, fontDato);
        p.setLeading(7);
        p.setAlignment(Paragraph.ALIGN_CENTER);
        
        celda.addElement(p);
        celda.setBorder(Cell.NO_BORDER);
        celda.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        celda.setCellEvent(ce);
        celda.setFixedHeight(14);

        return celda;
    }
    
    private PdfPCell getGuion()
    {
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
    

    private PdfPTable getLineaTexto(String campo, String valor)
    {
    	return getLineaTexto(campo, valor, Element.ALIGN_LEFT, 0, 0, false);
    }
    private PdfPTable getLineaTexto(String campo, String valor, boolean doblelinea)
    {
    	return getLineaTexto(campo, valor, Element.ALIGN_LEFT, 0, 0, doblelinea);
    }
    private PdfPTable getLineaTexto(String campo, String valor, 
			int alineacionCampo, 
			int margenIzq,
			int margenDer,
			boolean doblelinea)
    {
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
    
    
    private PdfPCell getRecuadro(String texto)
    {
    	RecuadroEvent r = new RecuadroEvent();
        PdfPCell celda = new PdfPCell();
        Paragraph p = new Paragraph (texto, fontParrafo);
        p.setSpacingAfter(5);
        p.setAlignment(Paragraph.ALIGN_CENTER);
        celda.setBorder(Cell.NO_BORDER);
        celda.setCellEvent(r);
        celda.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        celda.addElement(p);
        return celda;
    }

    private PdfPTable getLineaHorizontal()
    {
        Graphic horizontalLine = new Graphic();
        horizontalLine.setHorizontalLine(0.5f, 100f, new Color(0,0,0), Element.ALIGN_CENTER);
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
    
    private Paragraph getElementoVacio()
    {
    	Paragraph p = new Paragraph(" ", fontDato);
    	p.setLeading(5f);
        return p;
    }
    
    private PdfPCell getCeldaColumna(String valor, DashedLineEvent border)
    {
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
    
    private PdfPCell getCeldaDato(String valor, DashedLineEvent border)
    {
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
		  public DashedLineEvent(int margenIzq, int margenDer)
		  {
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
    	    cb.rectangle(rect.left() + (rect.right() - rect.left())/2 - 15.5f , rect.bottom() + (rect.top() - rect.bottom())/2 - 7.5f, 31f, 15f);
    	    cb.stroke();  	    
    	  }
    }    

    private class CheckEvent implements PdfPCellEvent {
    	public void cellLayout(PdfPCell cell, Rectangle rect, PdfContentByte[] canvas) {
    		PdfContentByte cb = canvas[PdfPTable.LINECANVAS];

    	    cb.setLineWidth(0.5f);
    	    cb.rectangle(rect.left() + (rect.right() - rect.left())/2 - 5f , rect.bottom() + (rect.top() - rect.bottom())/2 - 5f, 10f, 10f);
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
    	    cb.rectangle(rect.left() + (rect.right() - rect.left())/2 - ancho/2, rect.bottom() + (rect.top() - rect.bottom())/2 - alto/2, ancho+1, alto+1);
    	    cb.stroke();  	    
    	}
    }
    
    private class ImgRenfeEvent implements PdfPCellEvent {
    	public void cellLayout(PdfPCell cell, Rectangle rect, PdfContentByte[] canvas) {
    		PdfContentByte cb = canvas[PdfPTable.LINECANVAS];
    		//cb.setColorStroke(CertificadoComplementarioPdfCts.COLOR_FONDO);
    		float ancho = getPuntos(3.6f);
    		float alto = getPuntos(1.7f);
    	    cb.setLineWidth(0.5f);
    	    cb.rectangle(rect.left() + (rect.right() - rect.left())/2 - ancho/2, rect.bottom() + (rect.top() - rect.bottom())/2 - alto/2, ancho+1, alto+1);
    	    cb.stroke();  	    
    	}
    }
    
	@Override
	protected void writeDocument(Object bean,ResourceBundle message)
			throws DocumentException {
		// TODO Ap�ndice de m�todo generado autom�ticamente
		
	}

	@Override
	protected void writeDocument(Object bean)
			throws DocumentException {
		// TODO Ap�ndice de m�todo generado autom�ticamente
		
	}

	@Override
	protected void writeDocument(Object bean, ResourceBundle message, String tipoHabi) throws DocumentException {
		// TODO Auto-generated method stub
		
	}
    

 }
