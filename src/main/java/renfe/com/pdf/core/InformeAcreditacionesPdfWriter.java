
package renfe.com.pdf.core;

import java.awt.Color;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import com.lowagie.text.BadElementException;
import com.lowagie.text.Cell;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;

import renfe.com.dto.GetfindListAcreditaByCdgoPerDTO;
import renfe.com.model.dto.Tbasg260HabilifuncDto;
import renfe.com.pdf.beans.AcreditacionBean;
import renfe.com.pdf.datamanager.BundleMgr;
import renfe.com.util.InformeAcreditacionesPdfCts;


public class InformeAcreditacionesPdfWriter extends AsgPdfWriter {
    
	private URL cabecerapant1_1 = InformeAcreditacionesPdfWriter.class.getClassLoader().getResource(InformeAcreditacionesPdfCts.TOP_IMG);
	private URL Lanchares_firma = InformeAcreditacionesPdfWriter.class.getClassLoader().getResource(InformeAcreditacionesPdfCts.IMG_FIRMA_LANCHARES);
	private URL Firma_C_Gomez_red = InformeAcreditacionesPdfWriter.class.getClassLoader().getResource(InformeAcreditacionesPdfCts.IMG_FIRMA);
	private URL Firma_Reyes_Hdez = InformeAcreditacionesPdfWriter.class.getClassLoader().getResource(InformeAcreditacionesPdfCts.IMG_FIRMA_RM);
	private URL Firma_Pedro_Molina = InformeAcreditacionesPdfWriter.class.getClassLoader().getResource(InformeAcreditacionesPdfCts.IMG_FIRMA_VJ);	
    
    private Font fontDato = null;
    private Font fontTitulo = null;
    private Font fontParrafo = null;
      
    public InformeAcreditacionesPdfWriter() {
        
        super();       
        
        this.defaultFont =  new Font();
        this.defaultFont.setFamily(InformeAcreditacionesPdfCts.DEFAULT_FONT_FAMILY);        
        this.defaultFont.setSize(InformeAcreditacionesPdfCts.DEFAULT_FONT_SIZE);        
        
        this.defaultAlignment = InformeAcreditacionesPdfCts.DEFAULT_ALIGNMENT;
    }

    
    protected void writeDocument(Object object) throws DocumentException {
    	
    	AcreditacionBean bean = (AcreditacionBean) object;
        
        Paragraph paragraph = null;        
        String text = null;        
        Font font = null;   
     
        String sIdioma = "ES";  //  TODO
    	
    	//  Creamos el reource bundle con el idioma elegido
    	
    	String language = sIdioma.toLowerCase();
    	String country = sIdioma;
    	Locale currentLocale = new Locale(language, country);
    	
    	ResourceBundle bundle = ResourceBundle.getBundle("locale/InformeAcreditaciones",currentLocale);
        
        BundleMgr bundleMgr = BundleMgr.getInstance();
           
        // Construimos la pagina del informe
     
        // IMAGEN RENFE
        Image image = null;
        try {
            image = Image.getInstance(cabecerapant1_1); 
        } catch (BadElementException e) {            
            throw new DocumentException(e);
        } catch (MalformedURLException e) {
            throw new DocumentException(e);
        } catch (IOException e) {
            throw new DocumentException(e);
        }
        image.setAlignment(Element.ALIGN_LEFT);        
        document.add(image);
        
        // PARRAFO 1
        this.defaultFont.setSize(10);
        font = createFont(new int[]{Font.BOLD});
        font.setColor(140,0,75);  
        
        text = bundle.getString(InformeAcreditacionesPdfCts.BUNDLE_CTS_1);
       
        paragraph = new Paragraph(text, font);
        paragraph.setAlignment(Element.ALIGN_LEFT);        
        document.add(paragraph);        
    
        // LINEA 1
        font = createFont(new int[]{Font.BOLD});
        font.setSize(9);
        String nomape = bean.getNombre() + "  " + bean.getApellido1() + "  " + bean.getApellido2();
        Phrase phrase1 = new Phrase(bundle.getString(InformeAcreditacionesPdfCts.BUNDLE_CTS_4), font);
        font = this.defaultFont;
        font.setSize(9);
        Phrase phrase2 = new Phrase(nomape != null ? nomape: InformeAcreditacionesPdfCts.DATE_NOT_FILL, font);
        paragraph = new Paragraph();
        paragraph.add(phrase1);
        paragraph.add(phrase2);        
        paragraph.setSpacingBefore(12);
        document.add(paragraph);
                 
        // LINEA 2
        font = createFont(new int[]{Font.BOLD});
        font.setSize(9);
        Phrase phrase3 = new Phrase(bundle.getString(InformeAcreditacionesPdfCts.BUNDLE_CTS_6), font);
        font = this.defaultFont;
        font.setSize(9);
        Phrase phrase4 = new Phrase(bean.getNif() != null ? bean.getNif() : InformeAcreditacionesPdfCts.DATE_NOT_FILL, font);
        paragraph = new Paragraph();
        paragraph.add(phrase3);
        paragraph.add(phrase4);        
        document.add(paragraph);
        
        // LINEA 3
        font = createFont(new int[]{Font.BOLD});
        font.setSize(9);
        Phrase phrase5 = new Phrase(bundle.getString(InformeAcreditacionesPdfCts.BUNDLE_CTS_7), font);
        font = this.defaultFont;
        font.setSize(9);
        Phrase phrase6 = new Phrase(bean.getNacionalidad() != null ? bean.getNacionalidad() : InformeAcreditacionesPdfCts.DATE_NOT_FILL, font);
        paragraph = new Paragraph();
        paragraph.add(phrase5);
        paragraph.add(phrase6);
        document.add(paragraph); 
        
        
        // LINEA 4   Empresa
        font = createFont(new int[]{Font.BOLD});
        font.setSize(9);
        Phrase phrase9 = new Phrase(bundle.getString(InformeAcreditacionesPdfCts.BUNDLE_CTS_6_1), font);
        font = this.defaultFont;
        font.setSize(9);
        Phrase phrase10 = new Phrase(bean.getEmpresa() != null ? bean.getEmpresa() : InformeAcreditacionesPdfCts.DATE_NOT_FILL, font);
        
        paragraph = new Paragraph();
        paragraph.add(phrase9);
        paragraph.add(phrase10);        
        document.add(paragraph);   
        
        // LINEA 5
        font = createFont(new int[]{Font.BOLD});
        font.setSize(9);
        Phrase phrase7 = new Phrase(bundle.getString(InformeAcreditacionesPdfCts.BUNDLE_CTS_5_1), font);
        font = this.defaultFont;
        font.setSize(9);
        Phrase phrase8 = new Phrase(bean.getEntidad() != null ? bean.getEntidad() : InformeAcreditacionesPdfCts.DATE_NOT_FILL, font);
        
        paragraph = new Paragraph();
        paragraph.add(phrase7);
        paragraph.add(phrase8);        
        document.add(paragraph);   
        
        font.setSize(5);
        
        Phrase phrase0 = new Phrase(bundle.getString(InformeAcreditacionesPdfCts.BUNDLE_CTS_0), font);
        
        paragraph = new Paragraph();
        paragraph.add(phrase0);
        document.add(paragraph); 
               
     //  Creo la tabla con la lista de las acreditaciones
        
        text = bundle.getString(InformeAcreditacionesPdfCts.BUNDLE_CTS_3_0);
        
        fontTitulo = createFont(new int[]{Font.BOLD});
        fontTitulo.setFamily(InformeAcreditacionesPdfCts.DEFAULT_FONT_FAMILY);
        fontTitulo.setSize(10);
        
        Paragraph tituloListadoAcredita = new Paragraph(text, fontTitulo);
        tituloListadoAcredita.setAlignment(Element.ALIGN_CENTER);
        document.add(tituloListadoAcredita); 
     
        paragraph = new Paragraph();
        paragraph.add(phrase0);
        document.add(paragraph);   
        
        getCabeceraTabla(bundle);
	    getTablaAcreditaciones(bean.getAcreditaciones(),bundle);
	    
   
    }
    
    private void getCabeceraTabla(ResourceBundle bundle) throws DocumentException
    {
		String text = null;
	    float[] tamanoColumnas = {100f, 100f, 100f }; 
	    PdfPTable tabla = new PdfPTable(tamanoColumnas);
	    tabla.setSplitLate(true);
	    tabla.setWidthPercentage(100.0f);
	    
	    int altCelda = 26;
	        	
		fontParrafo = createFont(new int[]{Font.NORMAL}); 
	    fontParrafo.setFamily(InformeAcreditacionesPdfCts.DEFAULT_FONT_FAMILY);
	    fontParrafo.setSize(11);
	      
	    fontDato = createFont(new int[]{Font.NORMAL});
	    fontDato.setFamily(InformeAcreditacionesPdfCts.DEFAULT_FONT_FAMILY);
	    fontDato.setSize(10);
      

	  	text = bundle.getString(InformeAcreditacionesPdfCts.BUNDLE_CTS_4_1);
	  	PdfPCell celda = new PdfPCell(new Phrase(text, fontParrafo));
	  	celda.setBackgroundColor(new Color(238,210,238));
	  	celda.setHorizontalAlignment(Cell.ALIGN_CENTER);
	  	celda.setBorderWidth(1.5f);
	  	celda.setFixedHeight(altCelda);
	  	tabla.addCell(celda);
	  	
	  	text = bundle.getString(InformeAcreditacionesPdfCts.BUNDLE_CTS_4_2);
	  	celda = new PdfPCell(new Phrase(text, fontParrafo));
	  	celda.setBackgroundColor(new Color(238,210,238));
	  	celda.setHorizontalAlignment(Cell.ALIGN_CENTER);
	  	celda.setBorderWidth(1.5f);
	  	celda.setFixedHeight(altCelda);
	  	tabla.addCell(celda);
	  	
	  	text = bundle.getString(InformeAcreditacionesPdfCts.BUNDLE_CTS_4_3);
	  	celda = new PdfPCell(new Phrase(text, fontParrafo));
	  	celda.setBackgroundColor(new Color(238,210,238));
	  	celda.setHorizontalAlignment(Cell.ALIGN_CENTER);
	  	celda.setBorderWidth(1.5f);
	  	celda.setFixedHeight(altCelda);
	  	tabla.addCell(celda);
	  	
	   	document.add(tabla);
   	
    }
    
    
    private void getTablaAcreditaciones(List acreditaciones, ResourceBundle bundle) throws DocumentException
    {
     	float[] tamanoColumnas = {100f, 100f, 100f };
    	PdfPTable tabla = new PdfPTable(tamanoColumnas);
    	tabla.setSplitLate(true);
    	PdfPCell celda = new PdfPCell();
        int numPag = 0;
        
        int altCelda = 25;
 	
    	tabla.setWidthPercentage(100.0f);
     	
        fontParrafo = createFont(new int[]{Font.NORMAL}); 
        fontParrafo.setFamily(InformeAcreditacionesPdfCts.DEFAULT_FONT_FAMILY);
        fontParrafo.setSize(11);
        
        fontDato = createFont(new int[]{Font.NORMAL});
        fontDato.setFamily(InformeAcreditacionesPdfCts.DEFAULT_FONT_FAMILY);
        fontDato.setSize(10);
        
        numPag = document.getPageNumber();

     	
   	    int maximoFilas = 12;
    	int numeroMaximoFilas = 20;
    	int numeroFilas = 0;
    	if (acreditaciones != null && acreditaciones.size()>0) {
    		
    		//DescAcreditacion descAcredita = new DescAcreditacion();
    		GetfindListAcreditaByCdgoPerDTO descAcredita = new GetfindListAcreditaByCdgoPerDTO();
    		
    		SimpleDateFormat sdfr = new SimpleDateFormat("dd/MM/yyyy");
    		String linea = "";
    		int j = 0;
    		
	    	for (int i=0; i<acreditaciones.size(); i++) {
	    		
    	        if (i>12)
	        	{
	        		 j ++;
	        	}
    		
	    		descAcredita = (GetfindListAcreditaByCdgoPerDTO) acreditaciones.get(i);
	    			
	    		if (descAcredita.getDesgLinea() != null)
	    			linea = descAcredita.getDesgLinea(); 
	    		else if (descAcredita.getDesgPuerto()!= null)	
	    			linea = descAcredita.getDesgPuerto();
	    		else if (descAcredita.getDesgNomLargo() != null)
	    		    linea = descAcredita.getDesgNomLargo();
	    		else
	    			linea = "";
	    		
	    		celda = new PdfPCell(new Phrase((String)descAcredita.getDesgAcredita(), fontDato));
	        	celda.setHorizontalAlignment(Cell.ALIGN_CENTER);
	        	celda.setFixedHeight(altCelda);
	        	celda.setBorderWidth(1.5f);
	        	tabla.addCell(celda);
	        	celda = new PdfPCell(new Phrase((String)linea, fontDato));
	        	celda.setHorizontalAlignment(Cell.ALIGN_CENTER);
	        	celda.setFixedHeight(altCelda);
	        	celda.setBorderWidth(1.5f);
	        	tabla.addCell(celda);
	        	celda = new PdfPCell(new Phrase(sdfr.format(descAcredita.getFchaAct()), fontDato));
	        	celda.setHorizontalAlignment(Cell.ALIGN_CENTER);
	        	celda.setFixedHeight(altCelda);
	        	celda.setBorderWidth(1.5f);
	        	tabla.addCell(celda);
	        	numeroFilas++;
	          	
	        	if ((i%maximoFilas==0) && (i>0) &&  numPag == 0)
	        	{
	        		numPag ++;
	        		document.setPageCount(numPag);
	        		document.add(tabla);
	        		float[] tamColumn = {100f, 100f, 100f };
	        		tabla = new PdfPTable(tamColumn);
	        		tabla.setSplitLate(false);
	        		tabla.setWidthPercentage(100.0f);
	          		getCabeceraTabla(bundle);
	           	}
	        	
	            if ((j%numeroMaximoFilas==0) && (j>0) && (numPag > 0))
	        	{
	        		numPag ++;
	        		document.setPageCount(numPag);
	        		document.add(tabla);
	        		float[] tamColumn = {100f, 100f, 100f };
	        		tabla = new PdfPTable(tamColumn);
	        		tabla.setSplitLate(false);
	        		tabla.setWidthPercentage(100.0f);
	          		getCabeceraTabla(bundle);
	           	}
	            
	      
	        	
	       	}
	    	
	   	}
    	document.add(tabla);
    
    }
    
    private Paragraph getElementoVacio()
    {
    	Paragraph p = new Paragraph(" ", fontDato);
    	p.setLeading(5f);
        return p;
    }
    

      
	protected void writeDocument(Object bean, ResourceBundle message)
			throws DocumentException {
		
		
	}
	@Override
	protected void writeDocument(Object bean, ResourceBundle message,
			String tipoHabi) throws DocumentException {
	
		
	}


	@Override
	protected void writeDocument(Object bean, ResourceBundle message, String tipoHabi,
			List<Tbasg260HabilifuncDto> listaFunciones) throws DocumentException {
		// TODO Auto-generated method stub
		
	}

}
