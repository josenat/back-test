
package renfe.com.pdf.core;

import java.awt.Color;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.DateFormat;
import java.sql.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import org.apache.commons.collections.CollectionUtils;

import com.lowagie.text.BadElementException;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Graphic;
import com.lowagie.text.HeaderFooter;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;

import renfe.com.dto.GetMaxEntornosExpCodListDTO;
import renfe.com.model.dto.Tbasg260HabilifuncDto;
import renfe.com.model.entity.Tbasg104Expedient;
import renfe.com.pdf.beans.HabilitacionEstadoBean;
import renfe.com.pdf.datamanager.BundleMgr;
import renfe.com.util.HabilitacionEstadoPdfCts;

import java.util.Base64;
import java.util.Calendar;

import com.fasterxml.jackson.databind.ObjectMapper;

public class HabilitacionEstadoPdfWriter extends AsgPdfWriter {
    

    public HabilitacionEstadoPdfWriter(String imgPath) {
        
        super();       
        
        this.defaultFont =  new Font();
        this.defaultFont.setFamily(HabilitacionEstadoPdfCts.DEFAULT_FONT_FAMILY);        
        this.defaultFont.setSize(HabilitacionEstadoPdfCts.DEFAULT_FONT_SIZE);        
        
        this.defaultAlignment = HabilitacionEstadoPdfCts.DEFAULT_ALIGNMENT;
    }

    protected void writeDocument(Object object) throws DocumentException {
        
        HabilitacionEstadoBean bean = (HabilitacionEstadoBean) object;
        
        Paragraph paragraph = null;        
        String text = null;        
        Font font = null;        
        
        BundleMgr bundleMgr = BundleMgr.getInstance();
         
        // IMAGEN RENFE
        Image image = null;
        try {
        	byte[] imageByte = Base64.getDecoder().decode(HabilitacionEstadoPdfCts.TOP_IMG);
        	image = Image.getInstance(imageByte);
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
        text = bundleMgr.resolve(HabilitacionEstadoPdfCts.BUNDLE_CTS_1, HabilitacionEstadoPdfCts.BUNDLE_NAME);
        
        paragraph = new Paragraph(text, font);
        paragraph.setAlignment(Element.ALIGN_CENTER);        
        document.add(paragraph);        
        
        // PARRAFO 3            
        Phrase phrase31 = new Phrase(bundleMgr.resolve(HabilitacionEstadoPdfCts.BUNDLE_CTS_3_1, HabilitacionEstadoPdfCts.BUNDLE_NAME), this.defaultFont);
        font = createFont(new int[]{Font.BOLD});        
        Phrase phrase32 = new Phrase(bundleMgr.resolve(HabilitacionEstadoPdfCts.BUNDLE_CTS_3_2, HabilitacionEstadoPdfCts.BUNDLE_NAME), this.defaultFont);
        Phrase phrase33 = new Phrase(bundleMgr.resolve(HabilitacionEstadoPdfCts.BUNDLE_CTS_3_3, HabilitacionEstadoPdfCts.BUNDLE_NAME), this.defaultFont);
        paragraph = new Paragraph();
        paragraph.add(phrase31);
        paragraph.add(phrase32);
        paragraph.add(phrase33);        
        paragraph.setAlignment(Element.ALIGN_LEFT);
        paragraph.setSpacingBefore(18);               
        document.add(paragraph);
           
        // PARRAFO 4
        font = createFont(new int[]{Font.BOLD});
        font.setSize(9);
        Phrase phrase41 = new Phrase(bundleMgr.resolve(HabilitacionEstadoPdfCts.BUNDLE_CTS_4, HabilitacionEstadoPdfCts.BUNDLE_NAME), font);
        font = this.defaultFont;
        font.setSize(9);
        Phrase phrase42 = new Phrase(bean.getNomTrabajador() != null ? bean.getNomTrabajador(): HabilitacionEstadoPdfCts.DATE_NOT_FILL, font);
        paragraph = new Paragraph();
        paragraph.add(phrase41);
        paragraph.add(phrase42);        
        paragraph.setSpacingBefore(12);
        document.add(paragraph);
        
        // PARRAFO 5
        font = createFont(new int[]{Font.BOLD});
        font.setSize(9);
        Phrase phrase51 = new Phrase(bundleMgr.resolve(HabilitacionEstadoPdfCts.BUNDLE_CTS_5_1, HabilitacionEstadoPdfCts.BUNDLE_NAME), font);
        font = this.defaultFont;
        font.setSize(9);
        Phrase phrase52 = new Phrase(bundleMgr.resolve(HabilitacionEstadoPdfCts.BUNDLE_CTS_5_2, HabilitacionEstadoPdfCts.BUNDLE_NAME), font);
        paragraph = new Paragraph();
        paragraph.add(phrase51);
        paragraph.add(phrase52);        
        document.add(paragraph);        
                
        // PARRAFO 6
        font = createFont(new int[]{Font.BOLD});
        font.setSize(9);
        Phrase phrase61 = new Phrase(bundleMgr.resolve(HabilitacionEstadoPdfCts.BUNDLE_CTS_6, HabilitacionEstadoPdfCts.BUNDLE_NAME), font);
        font = this.defaultFont;
        font.setSize(9);
        Phrase phrase62 = new Phrase(bean.getNifPas() != null ? bean.getNifPas() : HabilitacionEstadoPdfCts.DATE_NOT_FILL, font);
        paragraph = new Paragraph();
        paragraph.add(phrase61);
        paragraph.add(phrase62);        
        document.add(paragraph);
        
        // PARRAFO 7
        font = createFont(new int[]{Font.BOLD});
        font.setSize(9);
        Phrase phrase71 = new Phrase(bundleMgr.resolve(HabilitacionEstadoPdfCts.BUNDLE_CTS_7, HabilitacionEstadoPdfCts.BUNDLE_NAME), font);
        font = this.defaultFont;
        font.setSize(9);
        Phrase phrase72 = new Phrase(bean.getNacionalidad() != null ? bean.getNacionalidad() : HabilitacionEstadoPdfCts.DATE_NOT_FILL, font);
        paragraph = new Paragraph();
        paragraph.add(phrase71);
        paragraph.add(phrase72);
        document.add(paragraph);        

        //PARRAFO 16
        font = createFont(new int[]{Font.BOLD});
        text = bundleMgr.resolve(HabilitacionEstadoPdfCts.BUNDLE_CTS_16_1, HabilitacionEstadoPdfCts.BUNDLE_NAME);
        paragraph = new Paragraph(text, font);
        paragraph.setAlignment(Element.ALIGN_LEFT);
        paragraph.setSpacingBefore(15);
        paragraph.setSpacingAfter(5);
        if ("S".equals(bean.getrestrinRam()))
          document.add(paragraph);           
        
        // PARRAFO 9
        font = createFont(new int[]{Font.BOLD});
        font.setSize(9);
        if (bean.getListFechaValidez() == null ||
        	(bean.getListFechaValidez() != null &&
        	 bean.getListFechaValidez().size() == 1)) {
	        Phrase phrase91 = new Phrase(bundleMgr.resolve(HabilitacionEstadoPdfCts.BUNDLE_CTS_9, HabilitacionEstadoPdfCts.BUNDLE_NAME), font);               
	        
	        if(CollectionUtils.isNotEmpty(bean.getListFechaValidez())) {
	        	HashMap mapFechaValidez = (HashMap) bean.getListFechaValidez().get(0);
	        	if (mapFechaValidez.containsKey("fchaValidez") &&
	        		!((String)mapFechaValidez.get("fchaValidez")).equals("")) {
	        		text = (String)mapFechaValidez.get("fchaValidez");
	        	} else {
	        		text = HabilitacionEstadoPdfCts.DATE_NOT_FILL;
	        	}
	        } else {
	            text = HabilitacionEstadoPdfCts.DATE_NOT_FILL;
	        }
	        text +="\t";
	        font = this.defaultFont;
	        font.setSize(9);
	        Phrase phrase92 = new Phrase(text, font);
	        
	        paragraph = new Paragraph();
	        paragraph.add(phrase91);
	        paragraph.add(phrase92);      
	        paragraph.setAlignment(Element.ALIGN_RIGHT);
	        document.add(paragraph);
        } else {
        	Phrase phrase91 = new Phrase(bundleMgr.resolve(HabilitacionEstadoPdfCts.BUNDLE_CTS_9_1, HabilitacionEstadoPdfCts.BUNDLE_NAME), font);
	        paragraph = new Paragraph();
	        paragraph.add(phrase91);
	        paragraph.setAlignment(Element.ALIGN_CENTER);
	        paragraph.setSpacingAfter(5);
	        document.add(paragraph);
	        
	        PdfPTable tabla = null;
	        tabla = getCabeceraTablaTiposHab();
        	
	        getTiposHabTable(tabla, bean.getListFechaValidez());
	        
            if ( null != tabla)
                document.add(tabla);
        }
        if (bean.getListCodSociedades()!=null)
        {
        	 for(int s = 0; s < bean.getListCodSociedades().size() ; s++)
         	{ 
             	String codSoci =  (String) bean.getListCodSociedades().get(s);

                 // PARRAFO 8
                 font = createFont(new int[]{Font.BOLD});
                 font.setSize(9);
                 Phrase phrase81 = new Phrase(bundleMgr.resolve(HabilitacionEstadoPdfCts.BUNDLE_CTS_8_1, HabilitacionEstadoPdfCts.BUNDLE_NAME), font);
                 font = this.defaultFont;
                 font.setSize(9);
                 Phrase phrase82 = null;
                 if (codSoci.equals("1000"))
                   phrase82 = new Phrase(bundleMgr.resolve(HabilitacionEstadoPdfCts.BUNDLE_CTS_8_2, HabilitacionEstadoPdfCts.BUNDLE_NAME), font);
                 else if (codSoci.equals("1400"))
                   phrase82 = new Phrase(bundleMgr.resolve(HabilitacionEstadoPdfCts.BUNDLE_CTS_8_4, HabilitacionEstadoPdfCts.BUNDLE_NAME), font);
                 else if (codSoci.equals("1500"))
                     phrase82 = new Phrase(bundleMgr.resolve(HabilitacionEstadoPdfCts.BUNDLE_CTS_8_3, HabilitacionEstadoPdfCts.BUNDLE_NAME), font);
                 else if (codSoci.equals("1600"))
                     phrase82 = new Phrase(bundleMgr.resolve(HabilitacionEstadoPdfCts.BUNDLE_CTS_8_5, HabilitacionEstadoPdfCts.BUNDLE_NAME), font);            
                 else
                   phrase82 = new Phrase(bundleMgr.resolve(HabilitacionEstadoPdfCts.BUNDLE_CTS_8_6, HabilitacionEstadoPdfCts.BUNDLE_NAME), font);	
                 
                 paragraph = new Paragraph();
                 paragraph.add(phrase81);
                 paragraph.add(phrase82);
         	
                 document.add(paragraph);
             	
     	        HashSet hsTipoHabil = bean.getHsTiposHabil();
     	        if ( null != hsTipoHabil && !hsTipoHabil.isEmpty()){
     	            if ( hsTipoHabil.contains(Integer.valueOf(HabilitacionEstadoBean.TIPO_ALC_INFRAESTRUCTURA_ENTORNO))
     	                    || hsTipoHabil.contains(Integer.valueOf(HabilitacionEstadoBean.TIPO_ALC_INFRAESTRUCTURA_TRAMOS)))
     	            {
     	                // LINEA        
     	                

     	                PdfPTable tabla = null;
     	                int contSoc = 0;
     	                List lAlcance = bean.getListAlcance();
     	               
     	                for (int i=0; i<lAlcance.size(); i++){

     	                	Map mapAlcance = (Map)lAlcance.get(i);
     	                	ObjectMapper mapper = new ObjectMapper(); 
     	                	Tbasg104Expedient objExpediente = mapper.convertValue(mapAlcance.get("expediente"), Tbasg104Expedient.class);
     	                	
     	                    String dsgSociedad = (String) mapAlcance.get("dsgSociedad");
     	                    Integer tipoAlcance = (Integer) mapAlcance.get("tipoAlcance");
     	                    if (objExpediente.getCdgoSociotor().equals(codSoci) 
     	                    		&& Integer.valueOf(HabilitacionEstadoBean.TIPO_ALC_INFRAESTRUCTURA_TRAMOS).equals(tipoAlcance))
     	                    {                
     		                    	contSoc ++;
     		                    	
     		                    	if ( contSoc == 1)
     		                    	{
     		                    		document.add(getLineaHorizontal());
     		                    		
     		                    		// PARRAFO 10
     			    	                font = createFont(new int[]{Font.BOLD});
     			    	                text = bundleMgr.resolve(HabilitacionEstadoPdfCts.BUNDLE_CTS_10, HabilitacionEstadoPdfCts.BUNDLE_NAME);
     			    	                paragraph = new Paragraph(text, font);
     			    	                paragraph.setAlignment(Element.ALIGN_CENTER);
     			    	                paragraph.setSpacingAfter(5);
     			    	                document.add(paragraph);
     			                    	
     			    	                
     			    	                if (hsTipoHabil.contains(Integer.valueOf(HabilitacionEstadoBean.TIPO_ALC_INFRAESTRUCTURA_TRAMOS))){
     			    	                    tabla = getCabeceraTabla();
     			    	                }
     		                    	}
	
     		                        List lAlcanceTramos = (List)mapAlcance.get("alcance");
     		                        
     		                        getTramosAlcanceTable(tabla, lAlcanceTramos, dsgSociedad, codSoci, Integer.valueOf(String.valueOf(objExpediente.getCdgoExpedient())));                        
     		                    
     	                    }
     	                    

     	                }
     	                if ( null != tabla)
     	                    document.add(tabla);
     	            }
     	            if ( hsTipoHabil.contains(Integer.valueOf(HabilitacionEstadoBean.TIPO_ALC_INFRAESTRUCTURA_LINEA)))
     	            {                
     	                // LINEA        
     	                document.add(getLineaHorizontal());
     	                
     	                //  PARRAFO 10_7
     	                text = bundleMgr.resolve(HabilitacionEstadoPdfCts.BUNDLE_CTS_10_7, HabilitacionEstadoPdfCts.BUNDLE_NAME);
     	                font = createFont(new int[]{Font.BOLD});
     	                paragraph = new Paragraph(text, font);
     	                paragraph.setAlignment(Element.ALIGN_CENTER);
     	                paragraph.setSpacingBefore(15);
     	                paragraph.setSpacingAfter(5);
     	                document.add(paragraph);
     	                
     	                PdfPTable tablaGenerica = getCabeceraTablaResto();
     	                List lAlcance = bean.getListAlcance();
     	                for (int i=0; i<lAlcance.size(); i++){
	
     	                	Map mapAlcance = (Map)lAlcance.get(i);
     	                	ObjectMapper mapper = new ObjectMapper(); 
     	                	Tbasg104Expedient objExpediente = mapper.convertValue(mapAlcance.get("expediente"), Tbasg104Expedient.class);
     	                	
     	                    String dsgSociedad = (String) mapAlcance.get("dsgSociedad");
     	                    Integer tipoAlcance = (Integer) mapAlcance.get("tipoAlcance");
     	                    if (objExpediente.getCdgoSociotor().equals(codSoci)
     	                    		&& Integer.valueOf(HabilitacionEstadoBean.TIPO_ALC_INFRAESTRUCTURA_LINEA).equals(tipoAlcance))
     	                    {
     		                        List lAlcanceTramos = (List)mapAlcance.get("alcance");
     		                        getContenidoTable(tablaGenerica, lAlcanceTramos, dsgSociedad);
     	                    }

     	                }
     	                document.add(tablaGenerica);
     	            }
     	            
     	            if ( hsTipoHabil.contains(Integer.valueOf(HabilitacionEstadoBean.TIPO_ALC_AUXCAB_ALCANCE_AMP_ENTORNO))
     	                    || hsTipoHabil.contains(Integer.valueOf(HabilitacionEstadoBean.TIPO_ALC_AUXCAB_ALCANCE_AMP_TRAMOS)))
     	            {
     	                // LINEA        
     	                document.add(getLineaHorizontal());
     	                
     	                // PARRAFO 10
     	                font = createFont(new int[]{Font.BOLD});
     	                text = bundleMgr.resolve(HabilitacionEstadoPdfCts.BUNDLE_CTS_10_8, HabilitacionEstadoPdfCts.BUNDLE_NAME);
     	                paragraph = new Paragraph(text, font);
     	                paragraph.setAlignment(Element.ALIGN_CENTER);
     	                paragraph.setSpacingAfter(5);
     	                document.add(paragraph);
     	                
     	                PdfPTable tabla = null;
     	                if (hsTipoHabil.contains(Integer.valueOf(HabilitacionEstadoBean.TIPO_ALC_AUXCAB_ALCANCE_AMP_TRAMOS))){
     	                    tabla = getCabeceraTablaConFechaFinValidez();
     	                }
     	                List lAlcance = bean.getListAlcance();
     	                for (int i=0; i<lAlcance.size(); i++){

     	                   Map mapAlcance = (Map)lAlcance.get(i);
     	                   ObjectMapper mapper = new ObjectMapper(); 
     	                   Tbasg104Expedient objExpediente = mapper.convertValue(mapAlcance.get("expediente"), Tbasg104Expedient.class);
     	                    
     	                    String dsgSociedad = mapAlcance.get("dsgSociedad").toString();
     	                    Integer tipoAlcance = (Integer) mapAlcance.get("tipoAlcance");
     	                    // INICIO EVOLUTIVO 191049 
     	                    String fechaFinValidez = (String) mapAlcance.get("fechaFinValidez"); 
     	                    String fechaIniValidez = (String) mapAlcance.get("fechaIniValidez"); 
     	                    if (codSoci.equals(objExpediente.getCdgoSociotor())
     	                    		&& Integer.valueOf(HabilitacionEstadoBean.TIPO_ALC_AUXCAB_ALCANCE_AMP_TRAMOS).equals(tipoAlcance))
     	                    {                  
     		                        List lAlcanceTramos = (List)mapAlcance.get("alcance");
     		                        getTramosAlcanceTableConFechaFinValidez(tabla, lAlcanceTramos, dsgSociedad, codSoci, Integer.valueOf(String.valueOf(objExpediente.getCdgoExpedient())), fechaFinValidez, fechaIniValidez);                        
     	                    }
     	                }
     	                if ( null != tabla)
     	                    document.add(tabla);
     	            }
     	            if ( hsTipoHabil.contains(Integer.valueOf(HabilitacionEstadoBean.TIPO_ALC_AUXCAB_ALCANCE_AMP_LINEA)))
     	            {                
     	                // LINEA        
     	                document.add(getLineaHorizontal());
     	                
     	                //  PARRAFO 10_10
     	                text = bundleMgr.resolve(HabilitacionEstadoPdfCts.BUNDLE_CTS_10_10, HabilitacionEstadoPdfCts.BUNDLE_NAME);
     	                font = createFont(new int[]{Font.BOLD});
     	                paragraph = new Paragraph(text, font);
     	                paragraph.setAlignment(Element.ALIGN_CENTER);
     	                paragraph.setSpacingBefore(15);
     	                paragraph.setSpacingAfter(5);
     	                document.add(paragraph);
     	                
     	                PdfPTable tablaGenerica = getCabeceraTablaRestoConFechaFinValidez();
     	                List lAlcance = bean.getListAlcance();
     	                for (int i=0; i<lAlcance.size(); i++){

     	                	Map mapAlcance = (Map)lAlcance.get(i);
     	                	ObjectMapper mapper = new ObjectMapper(); 
     	                	Tbasg104Expedient objExpediente = mapper.convertValue(mapAlcance.get("expediente"), Tbasg104Expedient.class);
     	                	
     	                    Integer tipoAlcance = (Integer) mapAlcance.get("tipoAlcance");
     	                    String dsgSociedad = (String) mapAlcance.get("dsgSociedad");
     	                    
     	                    String fechaFinValidez = (String) mapAlcance.get("fechaFinValidez"); 
     	                    String fechaIniValidez = (String) mapAlcance.get("fechaIniValidez"); 

     	                    if (objExpediente.getCdgoSociotor().equals(codSoci) 
     	                    		&& Integer.valueOf(HabilitacionEstadoBean.TIPO_ALC_AUXCAB_ALCANCE_AMP_LINEA).equals(tipoAlcance))
     	                    {
     		                        List lAlcanceTramos = (List)mapAlcance.get("alcance");
     		                        getContenidoTablecConFechaFinValidez(tablaGenerica, lAlcanceTramos, dsgSociedad, fechaFinValidez, fechaIniValidez);
     	                    }

     	                }
     	                document.add(tablaGenerica);
     	            }
     	
     	            if ( hsTipoHabil.contains(Integer.valueOf(HabilitacionEstadoBean.TIPO_ALC_AOT_MANIOBRAS_AYUDACAB_ENTORNO))
     	                    || hsTipoHabil.contains(Integer.valueOf(HabilitacionEstadoBean.TIPO_ALC_AOT_MANIOBRAS_AYUDACAB_TRAMOS)))
     	            {
     	                // LINEA        
     	                document.add(getLineaHorizontal());
     	                
     	                // PARRAFO 10
     	                font = createFont(new int[]{Font.BOLD});
     	                text = bundleMgr.resolve(HabilitacionEstadoPdfCts.BUNDLE_CTS_10_9, HabilitacionEstadoPdfCts.BUNDLE_NAME);
     	                paragraph = new Paragraph(text, font);
     	                paragraph.setAlignment(Element.ALIGN_CENTER);
     	                paragraph.setSpacingAfter(5);
     	                document.add(paragraph);
     	                
     	                PdfPTable tabla = null;
     	                if (hsTipoHabil.contains(Integer.valueOf(HabilitacionEstadoBean.TIPO_ALC_AOT_MANIOBRAS_AYUDACAB_TRAMOS))){
     	                    tabla = getCabeceraTablaConFechaFinValidez();
     	                }
     	                List lAlcance = bean.getListAlcance();
     	                for (int i=0; i<lAlcance.size(); i++){
     	                    Map mapAlcance = (Map)lAlcance.get(i);
     	                    ObjectMapper mapper = new ObjectMapper(); 
     	                    Tbasg104Expedient objExpediente = mapper.convertValue(mapAlcance.get("expediente"), Tbasg104Expedient.class);

     	                    String dsgSociedad = (String) mapAlcance.get("dsgSociedad");
     	                    Integer tipoAlcance = (Integer) mapAlcance.get("tipoAlcance");

     	                    String fechaFinValidez = (String) mapAlcance.get("fechaFinValidez"); 
     	                    String fechaIniValidez = (String) mapAlcance.get("fechaIniValidez"); 
  
     	                    if (objExpediente.getCdgoSociotor().equals(codSoci)
     	                    		&& Integer.valueOf(HabilitacionEstadoBean.TIPO_ALC_AOT_MANIOBRAS_AYUDACAB_TRAMOS).equals(tipoAlcance))
     	                    {                  
     		                        List lAlcanceTramos = (List)mapAlcance.get("alcance");
     		                       getTramosAlcanceTableConFechaFinValidez(tabla, lAlcanceTramos, dsgSociedad, codSoci, Integer.valueOf(String.valueOf(objExpediente.getCdgoExpedient())), fechaFinValidez, fechaIniValidez);                        
     	                    }
     	                    
     	                }
     	                if ( null != tabla)
     	                    document.add(tabla);
     	            }
     	            if (hsTipoHabil.contains(Integer.valueOf(HabilitacionEstadoBean.TIPO_ALC_AOT_MANIOBRAS_AYUDACAB_LINEA)))
     	            {                
     	                // LINEA        
     	                document.add(getLineaHorizontal());
     	                
     	                //  PARRAFO 10_11
     	                text = bundleMgr.resolve(HabilitacionEstadoPdfCts.BUNDLE_CTS_10_11, HabilitacionEstadoPdfCts.BUNDLE_NAME);
     	                font = createFont(new int[]{Font.BOLD});
     	                paragraph = new Paragraph(text, font);
     	                paragraph.setAlignment(Element.ALIGN_CENTER);
     	                paragraph.setSpacingBefore(15);
     	                paragraph.setSpacingAfter(5);
     	                document.add(paragraph);
     	                
     	                PdfPTable tablaGenerica = getCabeceraTablaRestoConFechaFinValidez();
     	                List lAlcance = bean.getListAlcance();
     	                for (int i=0; i<lAlcance.size(); i++){
	
     	                	Map mapAlcance = (Map)lAlcance.get(i);
     	                	ObjectMapper mapper = new ObjectMapper(); 
     	                	Tbasg104Expedient objExpediente = mapper.convertValue(mapAlcance.get("expediente"), Tbasg104Expedient.class);
     	                	
     	                    String dsgSociedad = (String) mapAlcance.get("dsgSociedad");                    
     	                    Integer tipoAlcance = (Integer) mapAlcance.get("tipoAlcance");
 
     	                    String fechaFinValidez = (String) mapAlcance.get("fechaFinValidez"); 
     	                    String fechaIniValidez = (String) mapAlcance.get("fechaIniValidez"); 
     
     	                    if (objExpediente.getCdgoSociotor().equals(codSoci) 
     	                    		&& Integer.valueOf(HabilitacionEstadoBean.TIPO_ALC_AOT_MANIOBRAS_AYUDACAB_LINEA).equals(tipoAlcance))
     	                    {
     		                        List lAlcanceTramos = (List)mapAlcance.get("alcance");
     		                        getContenidoTablecConFechaFinValidez(tablaGenerica, lAlcanceTramos, dsgSociedad, fechaFinValidez, fechaIniValidez);
                   	
     	                    }

     	                }
     	                document.add(tablaGenerica);
     	            }            
     	            if ( hsTipoHabil.contains(Integer.valueOf(HabilitacionEstadoBean.TIPO_ALC_MATERIAL)))
     	            {

     	                PdfPTable tablaSerie = getCabeceraTablaSerie();
     	                int contSoc = 0;
     	                List lAlcance = bean.getListAlcance();
     	                for (int i=0; i<lAlcance.size(); i++){
	
     	                	Map mapAlcance = (Map)lAlcance.get(i);
     	                	ObjectMapper mapper = new ObjectMapper(); 
     	                	Tbasg104Expedient objExpediente = mapper.convertValue(mapAlcance.get("expediente"), Tbasg104Expedient.class);
     	                	
     	                    Integer tipoAlcance = (Integer) mapAlcance.get("tipoAlcance");
     	                    String dsgSociedad = mapAlcance.get("dsgSociedad").toString();
     	                    if (objExpediente.getCdgoSociotor().equals(codSoci)
     	                    		&& Integer.valueOf(HabilitacionEstadoBean.TIPO_ALC_MATERIAL).equals(tipoAlcance))
     	                    {
     		                    	contSoc ++;
     		                    	
     		                    	if ( contSoc == 1)
     		                    	{
     		                    		// LINEA        
     			    	                document.add(getLineaHorizontal());
     			    	                
     			    	                // PARRAFO 11
     			    	                font = createFont(new int[]{Font.BOLD});
     			    	                text = bundleMgr.resolve(HabilitacionEstadoPdfCts.BUNDLE_CTS_11, HabilitacionEstadoPdfCts.BUNDLE_NAME);
     			    	                paragraph = new Paragraph(text, font);
     			    	                paragraph.setAlignment(Element.ALIGN_CENTER);
     			    	                paragraph.setSpacingBefore(15);
     			    	                paragraph.setSpacingAfter(5);
     			    	                document.add(paragraph);
     		                    	}
     		                    	
     		                        List lAlcanceTramos = (List)mapAlcance.get("alcance");
     		                        getSerieTable(tablaSerie, lAlcanceTramos, dsgSociedad);	                    	
     	                    }

     	                }
     	                document.add(tablaSerie);
     	            }
     	            if ( hsTipoHabil.contains(Integer.valueOf(HabilitacionEstadoBean.TIPO_ALC_AUX_OPERACIONES)))
     	            {
     	                // LINEA        
     	                document.add(getLineaHorizontal());
     	                
     	                // PARRAFO 12
     	                font = createFont(new int[]{Font.BOLD});
     	                text = bundleMgr.resolve(HabilitacionEstadoPdfCts.BUNDLE_CTS_12, HabilitacionEstadoPdfCts.BUNDLE_NAME);
     	                paragraph = new Paragraph(text, font);
     	                paragraph.setAlignment(Element.ALIGN_CENTER);
     	                paragraph.setSpacingBefore(15);
     	                paragraph.setSpacingAfter(5);
     	                document.add(paragraph);
     	                
     	                PdfPTable tablaGenerica = getCabeceraTablaValidez();
     	                List lAlcance = bean.getListAlcance();
     	                for (int i=0; i<lAlcance.size(); i++){

     	                	Map mapAlcance = (Map)lAlcance.get(i);
     	                	ObjectMapper mapper = new ObjectMapper(); 
     	                	Tbasg104Expedient objExpediente = mapper.convertValue(mapAlcance.get("expediente"), Tbasg104Expedient.class);
     	                   
     	                    String dsgSociedad = (String) mapAlcance.get("dsgSociedad");                    

     	                    Integer tipoAlcance = (Integer) mapAlcance.get("tipoAlcance");
     	                    if (objExpediente.getCdgoSociotor().equals(codSoci)
     	                    		&& Integer.valueOf(HabilitacionEstadoBean.TIPO_ALC_AUX_OPERACIONES).equals(tipoAlcance))
     	                    {
     		                        List lAlcanceTramos = (List)mapAlcance.get("alcance");
     		                        getContenidoTableValidez(tablaGenerica, lAlcanceTramos, dsgSociedad);	                    	
     	                    }

     	                }
     	                document.add(tablaGenerica);
     	            }
     	            if ( hsTipoHabil.contains(Integer.valueOf(HabilitacionEstadoBean.TIPO_ALC_CARGADOR)))
     	            {
     	                // LINEA        
     	                document.add(getLineaHorizontal());
     	                
     	                //  PARRAFO 13
     	                font = createFont(new int[]{Font.BOLD});
     	                text = bundleMgr.resolve(HabilitacionEstadoPdfCts.BUNDLE_CTS_13, HabilitacionEstadoPdfCts.BUNDLE_NAME);
     	                paragraph = new Paragraph(text, font);
     	                paragraph.setAlignment(Element.ALIGN_CENTER);
     	                paragraph.setSpacingBefore(15);
     	                paragraph.setSpacingAfter(5);
     	                document.add(paragraph);
     	                
     	                PdfPTable tablaGenerica = getCabeceraTablaValidez();
     	                List lAlcance = bean.getListAlcance();
     	                for (int i=0; i<lAlcance.size(); i++){

     	                	Map mapAlcance = (Map)lAlcance.get(i);
     	                	ObjectMapper mapper = new ObjectMapper(); 
     	                	Tbasg104Expedient objExpediente = mapper.convertValue(mapAlcance.get("expediente"), Tbasg104Expedient.class);
     	                	
     	                    String dsgSociedad = (String) mapAlcance.get("dsgSociedad"); 
     	                    Integer tipoAlcance = (Integer) mapAlcance.get("tipoAlcance");
     	                    if (objExpediente.getCdgoSociotor().equals(codSoci)
     	                    		&& Integer.valueOf(HabilitacionEstadoBean.TIPO_ALC_CARGADOR).equals(tipoAlcance))
     	                    {
     		                        List lAlcanceTramos = (List)mapAlcance.get("alcance");
     		                        getContenidoTableValidez(tablaGenerica, lAlcanceTramos, dsgSociedad);	                    	
     	                    }
     	                }
     	                document.add(tablaGenerica);
     	            }
     	            if ( hsTipoHabil.contains(Integer.valueOf(HabilitacionEstadoBean.TIPO_RESPNSABLE_OP_CARGA)))
     	            {
     	                // LINEA        
     	                document.add(getLineaHorizontal());
     	                
     	                //  PARRAFO 13
     	                font = createFont(new int[]{Font.BOLD});
     	                text = bundleMgr.resolve(HabilitacionEstadoPdfCts.BUNDLE_CTS_15, HabilitacionEstadoPdfCts.BUNDLE_NAME);
     	                paragraph = new Paragraph(text, font);
     	                paragraph.setAlignment(Element.ALIGN_CENTER);
     	                paragraph.setSpacingBefore(15);
     	                paragraph.setSpacingAfter(5);
     	                document.add(paragraph);
     	                
     	                PdfPTable tablaGenerica = getCabeceraTablaValidez();
     	                List lAlcance = bean.getListAlcance();
     	                for (int i=0; i<lAlcance.size(); i++){

     	                	Map mapAlcance = (Map)lAlcance.get(i);
     	                	ObjectMapper mapper = new ObjectMapper(); 
     	                	Tbasg104Expedient objExpediente = mapper.convertValue(mapAlcance.get("expediente"), Tbasg104Expedient.class);
     	                	
     	                    Integer tipoAlcance = (Integer) mapAlcance.get("tipoAlcance");
     	                    String dsgSociedad = (String) mapAlcance.get("dsgSociedad"); 
     	                    if (objExpediente.getCdgoSociotor().equals(codSoci)
     	                    		&& Integer.valueOf(HabilitacionEstadoBean.TIPO_RESPNSABLE_OP_CARGA).equals(tipoAlcance))
     	                    {
     		                        List lAlcanceTramos = (List)mapAlcance.get("alcance");
     		                        getContenidoTableValidez(tablaGenerica, lAlcanceTramos, dsgSociedad);
                    	
     	                    }

     	                }
     	                document.add(tablaGenerica);
     	            }     
     	            if (hsTipoHabil.contains(Integer.valueOf(HabilitacionEstadoBean.TIPO_ALC_AUXILIAR_CABINA)))
     	            {
     	            	 //  LINEA        
     	                document.add(getLineaHorizontal());
     	                
     	                //  PARRAFO 14
     	                font = createFont(new int[]{Font.BOLD});
     	                text = bundleMgr.resolve(HabilitacionEstadoPdfCts.BUNDLE_CTS_10_12, HabilitacionEstadoPdfCts.BUNDLE_NAME);
     	                paragraph = new Paragraph(text, font);
     	                paragraph.setAlignment(Element.ALIGN_CENTER);
     	                paragraph.setSpacingBefore(15);
     	                paragraph.setSpacingAfter(5);
     	                document.add(paragraph);
     	                
     	                PdfPTable tablaGenerica = getCabeceraTablaValidez();
     	                List lAlcance = bean.getListAlcance();
     	                for (int i=0; i<lAlcance.size(); i++){

     	                	Map mapAlcance = (Map)lAlcance.get(i);
     	                	ObjectMapper mapper = new ObjectMapper(); 
     	                	Tbasg104Expedient objExpediente = mapper.convertValue(mapAlcance.get("expediente"), Tbasg104Expedient.class);
     	                	
     	                    Integer tipoAlcance = (Integer) mapAlcance.get("tipoAlcance");
     	                    String dsgSociedad = (String) mapAlcance.get("dsgSociedad"); 
     	                    if (objExpediente.getCdgoSociotor().equals(codSoci) &&  Integer.valueOf(HabilitacionEstadoBean.TIPO_ALC_AUXILIAR_CABINA).equals(tipoAlcance))
     	                    {
     		                        List lAlcanceTramos = (List)mapAlcance.get("alcance");
     		                        getContenidoTableValidez(tablaGenerica, lAlcanceTramos, dsgSociedad);    	                    	
     	                    }	

     	                }
     	                document.add(tablaGenerica);
     	            }            	
     	            
     	            if ( hsTipoHabil.contains(Integer.valueOf(HabilitacionEstadoBean.TIPO_ALC_OPERADOR_VEHIC_MANIOBRAS)))
     	            {
     	                //  LINEA        
     	                document.add(getLineaHorizontal());
     	                
     	                //  PARRAFO 14
     	                font = createFont(new int[]{Font.BOLD});
     	                text = bundleMgr.resolve(HabilitacionEstadoPdfCts.BUNDLE_CTS_14, HabilitacionEstadoPdfCts.BUNDLE_NAME);
     	                paragraph = new Paragraph(text, font);
     	                paragraph.setAlignment(Element.ALIGN_CENTER);
     	                paragraph.setSpacingBefore(15);
     	                paragraph.setSpacingAfter(5);
     	                document.add(paragraph);
     	                
     	                PdfPTable tablaGenerica = getCabeceraTablaValidez();
     	                List lAlcance = bean.getListAlcance();
     	                for (int i=0; i<lAlcance.size(); i++){

     	                	Map mapAlcance = (Map)lAlcance.get(i);
     	                	ObjectMapper mapper = new ObjectMapper(); 
     	                	Tbasg104Expedient objExpediente = mapper.convertValue(mapAlcance.get("expediente"), Tbasg104Expedient.class);
     	                   
     	                    Integer tipoAlcance = (Integer) mapAlcance.get("tipoAlcance");
     	                   
     	                    String dsgSociedad = (String) mapAlcance.get("dsgSociedad");
     	                    if (objExpediente.getCdgoSociotor().equals(codSoci)
     	                		   && Integer.valueOf(HabilitacionEstadoBean.TIPO_ALC_OPERADOR_VEHIC_MANIOBRAS).equals(tipoAlcance))
     	                    {
     		                        List lAlcanceTramos = (List)mapAlcance.get("alcance");
     		                        getContenidoTableValidez(tablaGenerica, lAlcanceTramos, dsgSociedad);     		                        	
     	                    }
     	                }
     	                document.add(tablaGenerica);
     	            }
     	        }

         	}
       }
        // FECHA DE HOY
        DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, new Locale("es", "ES"));
        String sFechaHoy = df.format(new Date(Calendar.getInstance().getTime().getTime()));
        font = createFont(new int[]{Font.BOLD});
        paragraph = new Paragraph(sFechaHoy, font);
        paragraph.setAlignment(Element.ALIGN_LEFT);
        paragraph.setSpacingBefore(10);
        document.add(paragraph);
 
        // FIRMA DOCUMENTO POR RESPONSABLES SOCIEDADES RENFE
        if (bean.getListCodSociedades()!=null){
        	String codSociedad = "";
        	String codSociedadAnterior = "";
        
        	
        	
        	for(int i = 0; i < bean.getListCodSociedades().size() ; i++)
        	{ 
        		codSociedad = (String)bean.getListCodSociedades().get(i);
        		
        		if(!codSociedad.equals(codSociedadAnterior))
        		{
        			// IMAGEN FIRMA RESPONSABLES RENFE
        			Image imageFirma = null;
        			try {
        				if(codSociedad.equals(HabilitacionEstadoPdfCts.CDGO_OPERADORA)){ //EPE 
        					PdfPTable table = new PdfPTable(1);
        					paragraph = createParagraph("Habilitaciones de EPE firmadas por:");
        					paragraph.setAlignment(Element.ALIGN_CENTER);
            				paragraph.setSpacingBefore(10);
            				document.add(paragraph);
            				byte[] imageByte = Base64.getDecoder().decode(HabilitacionEstadoPdfCts.IMG_FIRMA_RM);
            				imageFirma = Image.getInstance(imageByte);
        					imageFirma.setAlignment(Element.ALIGN_CENTER);
        					PdfPCell cell = new PdfPCell(imageFirma);
                			cell.setBorder(0);
                			cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                			cell.setPadding(10);
                			table.addCell(cell);
                			document.add(table);
                			
                		
        				}
        				else if(codSociedad.equals(HabilitacionEstadoPdfCts.CDGO_VIAJEROS)){ // Viajeros
        					PdfPTable table = new PdfPTable(1);
        					paragraph = createParagraph("Habilitaciones de RENFE VIAJEROS firmadas por:");
        					paragraph.setAlignment(Element.ALIGN_CENTER);
            				paragraph.setSpacingBefore(10);
            				document.add(paragraph);
            				byte[] imageByte = Base64.getDecoder().decode(HabilitacionEstadoPdfCts.IMG_FIRMA_VJ);
            				imageFirma = Image.getInstance(imageByte);
        					imageFirma.setAlignment(Element.ALIGN_CENTER);
        					PdfPCell cell1 = new PdfPCell(imageFirma);
                			cell1.setBorder(0);
                			cell1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                			cell1.setPadding(10);
                			table.addCell(cell1);
                			document.add(table);
        				}
        				else if(codSociedad.equals(HabilitacionEstadoPdfCts.CDGO_MERCANCIAS)){ // Mercanc�as
        					PdfPTable table = new PdfPTable(1);
        					paragraph = createParagraph("Habilitaciones de RENFE MERCANCIAS firmadas por:");
        					paragraph.setAlignment(Element.ALIGN_CENTER);
            				paragraph.setSpacingBefore(10);
            				document.add(paragraph);
            				byte[] imageByte = Base64.getDecoder().decode(HabilitacionEstadoPdfCts.IMG_FIRMA);
            				imageFirma = Image.getInstance(imageByte);
        					imageFirma.setAlignment(Element.ALIGN_CENTER);
        					PdfPCell cell2 = new PdfPCell(imageFirma);
                			cell2.setBorder(0);
                			cell2.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                			cell2.setPadding(10);
                			table.addCell(cell2);
                			document.add(table);
        				}
        	
        			} catch (BadElementException e) {            
        				throw new DocumentException(e);
        			} catch (MalformedURLException e) {
        				throw new DocumentException(e);
        			} catch (IOException e) {
        				throw new DocumentException(e);
        			}
                  
        			// PARRAFO 15
        			if(codSociedad.equals(HabilitacionEstadoPdfCts.CDGO_OPERADORA)) //EPE
        			{
        				paragraph = createParagraph(new String[]{
        						bundleMgr.resolve(HabilitacionEstadoPdfCts.BUNDLE_CTS_15_1, HabilitacionEstadoPdfCts.BUNDLE_NAME),
            					bundleMgr.resolve(HabilitacionEstadoPdfCts.BUNDLE_CTS_15_2, HabilitacionEstadoPdfCts.BUNDLE_NAME)
        					
        				}); 
        				paragraph.setAlignment(Element.ALIGN_CENTER);
        				paragraph.setSpacingBefore(10);
        				document.add(paragraph);
        			}
        			else if(codSociedad.equals(HabilitacionEstadoPdfCts.CDGO_VIAJEROS)){ // Viajeros
        				paragraph = createParagraph(new String[]{
        					bundleMgr.resolve(HabilitacionEstadoPdfCts.BUNDLE_CTS_15_5, HabilitacionEstadoPdfCts.BUNDLE_NAME),
        					bundleMgr.resolve(HabilitacionEstadoPdfCts.BUNDLE_CTS_15_6, HabilitacionEstadoPdfCts.BUNDLE_NAME)
        				}); 
        				paragraph.setAlignment(Element.ALIGN_CENTER);
        				paragraph.setSpacingBefore(10);
        				document.add(paragraph);
        			}
        			else if(codSociedad.equals(HabilitacionEstadoPdfCts.CDGO_MERCANCIAS)){ // Mercanc�as
        				paragraph = createParagraph(new String[]{
        						bundleMgr.resolve(HabilitacionEstadoPdfCts.BUNDLE_CTS_15_3, HabilitacionEstadoPdfCts.BUNDLE_NAME),
            					bundleMgr.resolve(HabilitacionEstadoPdfCts.BUNDLE_CTS_15_4, HabilitacionEstadoPdfCts.BUNDLE_NAME)
        				});  
        				paragraph.setAlignment(Element.ALIGN_CENTER);
        				paragraph.setSpacingBefore(10);
        				document.add(paragraph);
        			}
        			codSociedadAnterior = codSociedad;
        		}
        	}
        }
        
    }
    
    private PdfPTable getCabeceraTabla() throws DocumentException
    {

        PdfPTable table = new PdfPTable(7);  
    	
        //Datos de porcentaje a la tabla (tamaño ancho).
        table.setWidthPercentage(100);
        //Datos del ancho de cada columna.
        table.setWidths(new float[] {30, 30, 33, 30, 33, 36, 30});
        Font font = createFont(new int[]{Font.BOLD}); 
        font.setSize(9);
        BundleMgr bundleMgr = BundleMgr.getInstance();
        PdfPCell cell = null;
        String text = null;
        
        text = bundleMgr.resolve(HabilitacionEstadoPdfCts.BUNDLE_CTS_10_1, HabilitacionEstadoPdfCts.BUNDLE_NAME);
        cell = new PdfPCell(new Phrase(text, font));
        cell.setBackgroundColor(new Color(205,150,205));
        cell.setPadding(10);
        table.addCell(cell);
        
        text = bundleMgr.resolve(HabilitacionEstadoPdfCts.BUNDLE_CTS_10_2, HabilitacionEstadoPdfCts.BUNDLE_NAME);
        cell = new PdfPCell(new Phrase(text, font));
        cell.setBackgroundColor(new Color(205,150,205));
        cell.setPadding(10);
        table.addCell(cell);
        
        text = bundleMgr.resolve(HabilitacionEstadoPdfCts.BUNDLE_CTS_10_3, HabilitacionEstadoPdfCts.BUNDLE_NAME);
        cell = new PdfPCell(new Phrase(text, font));
        cell.setBackgroundColor(new Color(205,150,205));
        cell.setPadding(10);
        table.addCell(cell);
        
        text = bundleMgr.resolve(HabilitacionEstadoPdfCts.BUNDLE_CTS_10_4, HabilitacionEstadoPdfCts.BUNDLE_NAME);
        cell = new PdfPCell(new Phrase(text, font));
        cell.setBackgroundColor(new Color(205,150,205));
        cell.setPadding(10);
        table.addCell(cell);
        
        text = bundleMgr.resolve(HabilitacionEstadoPdfCts.BUNDLE_CTS_10_5, HabilitacionEstadoPdfCts.BUNDLE_NAME);
        cell = new PdfPCell(new Phrase(text, font));
        cell.setBackgroundColor(new Color(205,150,205));
        cell.setPadding(10);
        table.addCell(cell);
        
        text = bundleMgr.resolve(HabilitacionEstadoPdfCts.BUNDLE_CTS_10_6, HabilitacionEstadoPdfCts.BUNDLE_NAME);
        cell = new PdfPCell(new Phrase(text, font));
        cell.setBackgroundColor(new Color(205,150,205));
        cell.setPadding(10);
        table.addCell(cell);
              
        text = bundleMgr.resolve(HabilitacionEstadoPdfCts.BUNDLE_CTS_10_61, HabilitacionEstadoPdfCts.BUNDLE_NAME);
        cell = new PdfPCell(new Phrase(text, font));
        cell.setBackgroundColor(new Color(205,150,205));
        cell.setPadding(10);
        table.addCell(cell);
        
        return table;
    }
    
    // INICIO EVOLUTIVO 191049
    private PdfPTable getCabeceraTablaConFechaFinValidez() throws DocumentException
    {
        PdfPTable table = new PdfPTable(8);
        
        //Datos de porcentaje a la tabla (tamaño ancho).
        table.setWidthPercentage(100);
        //Datos del ancho de cada columna.
        table.setWidths(new float[] {30, 30, 33, 30, 33, 36, 30, 32});
        
        Font font = createFont(new int[]{Font.BOLD}); 
        font.setSize(9);
        BundleMgr bundleMgr = BundleMgr.getInstance();
        PdfPCell cell = null;
        String text = null;
        
        text = bundleMgr.resolve(HabilitacionEstadoPdfCts.BUNDLE_CTS_10_1, HabilitacionEstadoPdfCts.BUNDLE_NAME);
        cell = new PdfPCell(new Phrase(text, font));
        cell.setBackgroundColor(new Color(205,150,205));
        cell.setPadding(10);
        table.addCell(cell);
        
        text = bundleMgr.resolve(HabilitacionEstadoPdfCts.BUNDLE_CTS_10_2, HabilitacionEstadoPdfCts.BUNDLE_NAME);
        cell = new PdfPCell(new Phrase(text, font));
        cell.setBackgroundColor(new Color(205,150,205));
        cell.setPadding(10);
        table.addCell(cell);
        
        text = bundleMgr.resolve(HabilitacionEstadoPdfCts.BUNDLE_CTS_10_3, HabilitacionEstadoPdfCts.BUNDLE_NAME);
        cell = new PdfPCell(new Phrase(text, font));
        cell.setBackgroundColor(new Color(205,150,205));
        cell.setPadding(10);
        table.addCell(cell);
        
        text = bundleMgr.resolve(HabilitacionEstadoPdfCts.BUNDLE_CTS_10_4, HabilitacionEstadoPdfCts.BUNDLE_NAME);
        cell = new PdfPCell(new Phrase(text, font));
        cell.setBackgroundColor(new Color(205,150,205));
        cell.setPadding(10);
        table.addCell(cell);
        
        text = bundleMgr.resolve(HabilitacionEstadoPdfCts.BUNDLE_CTS_10_5, HabilitacionEstadoPdfCts.BUNDLE_NAME);
        cell = new PdfPCell(new Phrase(text, font));
        cell.setBackgroundColor(new Color(205,150,205));
        cell.setPadding(10);
        table.addCell(cell);
        
        text = bundleMgr.resolve(HabilitacionEstadoPdfCts.BUNDLE_CTS_10_6, HabilitacionEstadoPdfCts.BUNDLE_NAME);
        cell = new PdfPCell(new Phrase(text, font));
        cell.setBackgroundColor(new Color(205,150,205));
        cell.setPadding(10);
        table.addCell(cell);
        
        text = bundleMgr.resolve(HabilitacionEstadoPdfCts.BUNDLE_CTS_10_62, HabilitacionEstadoPdfCts.BUNDLE_NAME);
        cell = new PdfPCell(new Phrase(text, font));
        cell.setBackgroundColor(new Color(205,150,205));
        cell.setPadding(10);
        table.addCell(cell);
        
        text = bundleMgr.resolve(HabilitacionEstadoPdfCts.BUNDLE_CTS_10_61, HabilitacionEstadoPdfCts.BUNDLE_NAME);
        cell = new PdfPCell(new Phrase(text, font));
        cell.setBackgroundColor(new Color(205,150,205));
        cell.setPadding(10);
        table.addCell(cell);
        
        return table;
    }
    // FIN EVOLUTIVO 191049
    
    private PdfPTable getCabeceraTablaSerie()
    {
        PdfPTable table = new PdfPTable(4);
        
        Font font = createFont(new int[]{Font.BOLD}); 
        font.setSize(9);
        BundleMgr bundleMgr = BundleMgr.getInstance();
        PdfPCell cell = null;
        String text = null;
        
        text = bundleMgr.resolve(HabilitacionEstadoPdfCts.BUNDLE_CTS_11_1, HabilitacionEstadoPdfCts.BUNDLE_NAME);
        cell = new PdfPCell(new Phrase(text, font));
        cell.setBackgroundColor(new Color(205,150,205));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setPadding(10);
        table.addCell(cell);
        
        text = bundleMgr.resolve(HabilitacionEstadoPdfCts.BUNDLE_CTS_11_2, HabilitacionEstadoPdfCts.BUNDLE_NAME);
        cell = new PdfPCell(new Phrase(text, font));
        cell.setBackgroundColor(new Color(205,150,205));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setPadding(10);
        table.addCell(cell);
        
        text = bundleMgr.resolve(HabilitacionEstadoPdfCts.BUNDLE_CTS_11_3, HabilitacionEstadoPdfCts.BUNDLE_NAME);
        cell = new PdfPCell(new Phrase(text, font));
        cell.setBackgroundColor(new Color(205,150,205));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setPadding(10);
        table.addCell(cell);
        
        text = bundleMgr.resolve(HabilitacionEstadoPdfCts.BUNDLE_CTS_10_61, HabilitacionEstadoPdfCts.BUNDLE_NAME);
        cell = new PdfPCell(new Phrase(text, font));
        cell.setBackgroundColor(new Color(205,150,205));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setPadding(10);
        table.addCell(cell);
        
        return table;
    }
    
    private PdfPTable getCabeceraTablaResto()
    {
        PdfPTable table = new PdfPTable(3);
        
        Font font = createFont(new int[]{Font.BOLD}); 
        font.setSize(9);
        BundleMgr bundleMgr = BundleMgr.getInstance();
        PdfPCell cell = null;
        String text = null;
        
        text = bundleMgr.resolve(HabilitacionEstadoPdfCts.BUNDLE_CTS_TABLA_1, HabilitacionEstadoPdfCts.BUNDLE_NAME);
        cell = new PdfPCell(new Phrase(text, font));
        cell.setBackgroundColor(new Color(205,150,205));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setPadding(10);
        table.addCell(cell);
        
        text = bundleMgr.resolve(HabilitacionEstadoPdfCts.BUNDLE_CTS_TABLA_2, HabilitacionEstadoPdfCts.BUNDLE_NAME);
        cell = new PdfPCell(new Phrase(text, font));
        cell.setBackgroundColor(new Color(205,150,205));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setPadding(10);
        table.addCell(cell);
        
        text = bundleMgr.resolve(HabilitacionEstadoPdfCts.BUNDLE_CTS_10_61, HabilitacionEstadoPdfCts.BUNDLE_NAME);
        cell = new PdfPCell(new Phrase(text, font));
        cell.setBackgroundColor(new Color(205,150,205));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setPadding(10);
        table.addCell(cell);
        
        return table;
    }
    
    // INICIO EVOLUTIVO 191049
    private PdfPTable getCabeceraTablaRestoConFechaFinValidez()
    {
        PdfPTable table = new PdfPTable(4);
        
        Font font = createFont(new int[]{Font.BOLD}); 
        font.setSize(9);
        BundleMgr bundleMgr = BundleMgr.getInstance();
        PdfPCell cell = null;
        String text = null;
        
        text = bundleMgr.resolve(HabilitacionEstadoPdfCts.BUNDLE_CTS_TABLA_1, HabilitacionEstadoPdfCts.BUNDLE_NAME);
        cell = new PdfPCell(new Phrase(text, font));
        cell.setBackgroundColor(new Color(205,150,205));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setPadding(10);
        table.addCell(cell);
        
        text = bundleMgr.resolve(HabilitacionEstadoPdfCts.BUNDLE_CTS_TABLA_2, HabilitacionEstadoPdfCts.BUNDLE_NAME);
        cell = new PdfPCell(new Phrase(text, font));
        cell.setBackgroundColor(new Color(205,150,205));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setPadding(10);
        table.addCell(cell);
        
        text = bundleMgr.resolve(HabilitacionEstadoPdfCts.BUNDLE_CTS_10_62, HabilitacionEstadoPdfCts.BUNDLE_NAME);
        cell = new PdfPCell(new Phrase(text, font));
        cell.setBackgroundColor(new Color(205,150,205));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setPadding(10);
        table.addCell(cell);
        
        text = bundleMgr.resolve(HabilitacionEstadoPdfCts.BUNDLE_CTS_10_61, HabilitacionEstadoPdfCts.BUNDLE_NAME);
        cell = new PdfPCell(new Phrase(text, font));
        cell.setBackgroundColor(new Color(205,150,205));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setPadding(10);
        table.addCell(cell);
        
        return table;
    }
 	// FIN EVOLUTIVO 191049
    
    private PdfPTable getCabeceraTablaValidez()
    {
        PdfPTable table = new PdfPTable(6);
        
        Font font = createFont(new int[]{Font.BOLD}); 
        font.setSize(9);
        BundleMgr bundleMgr = BundleMgr.getInstance();
        PdfPCell cell = null;
        String text = null;
        
        text = bundleMgr.resolve(HabilitacionEstadoPdfCts.BUNDLE_CTS_TABLA_1, HabilitacionEstadoPdfCts.BUNDLE_NAME);
        cell = new PdfPCell(new Phrase(text, font));
        cell.setBackgroundColor(new Color(205,150,205));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setPadding(10);
        cell.setColspan(2);
        table.addCell(cell);
        
        text = bundleMgr.resolve(HabilitacionEstadoPdfCts.BUNDLE_CTS_TABLA_2, HabilitacionEstadoPdfCts.BUNDLE_NAME);
        cell = new PdfPCell(new Phrase(text, font));
        cell.setBackgroundColor(new Color(205,150,205));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setPadding(10);
        cell.setColspan(2);
        table.addCell(cell);
        
        text = bundleMgr.resolve(HabilitacionEstadoPdfCts.BUNDLE_CTS_10_61, HabilitacionEstadoPdfCts.BUNDLE_NAME);
        cell = new PdfPCell(new Phrase(text, font));
        cell.setBackgroundColor(new Color(205,150,205));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setPadding(10);
        cell.setColspan(2);
        table.addCell(cell);
        
        cell = new PdfPCell(new Phrase("", font));
        cell.setBackgroundColor(new Color(205,150,205));        
        cell.setPadding(10);
        cell.setColspan(2);
        table.addCell(cell);
        
        text = bundleMgr.resolve(HabilitacionEstadoPdfCts.BUNDLE_CTS_TABLA_3, HabilitacionEstadoPdfCts.BUNDLE_NAME);
        PdfPCell cell21 = new PdfPCell(new Phrase(text, font));
        cell21.setBackgroundColor(new Color(205,150,205));
        cell21.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell21.setPadding(10);
        table.addCell(cell21);
        
        text = bundleMgr.resolve(HabilitacionEstadoPdfCts.BUNDLE_CTS_TABLA_4, HabilitacionEstadoPdfCts.BUNDLE_NAME);
        PdfPCell cell22 = new PdfPCell(new Phrase(text, font));
        cell22.setBackgroundColor(new Color(205,150,205));
        cell22.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell22.setPadding(10);
        table.addCell(cell22);
        
        cell = new PdfPCell(new Phrase("", font));
        cell.setBackgroundColor(new Color(205,150,205));        
        cell.setPadding(10);
        cell.setColspan(2);
        table.addCell(cell);
        
        return table;
    }
    
    private PdfPTable getCabeceraTablaTiposHab() 
    {
    	float[] dimensiones = new float[]{300.0f, 100.0f};
        PdfPTable table = new PdfPTable(dimensiones);
        table.setTotalWidth(400f);
        table.setLockedWidth(true);        
        
        Font font = createFont(new int[]{Font.BOLD}); 
        font.setSize(9);
        BundleMgr bundleMgr = BundleMgr.getInstance();
        PdfPCell cell = null;
        String text = null;
        
        text = bundleMgr.resolve(HabilitacionEstadoPdfCts.BUNDLE_CTS_9_2, HabilitacionEstadoPdfCts.BUNDLE_NAME);
        cell = new PdfPCell(new Phrase(text, font));
        cell.setBackgroundColor(new Color(205,150,205));
        cell.setPadding(10);
        table.addCell(cell);
        
        text = bundleMgr.resolve(HabilitacionEstadoPdfCts.BUNDLE_CTS_9_3, HabilitacionEstadoPdfCts.BUNDLE_NAME);
        cell = new PdfPCell(new Phrase(text, font));
        cell.setBackgroundColor(new Color(205,150,205));
        cell.setPadding(10);
        table.addCell(cell);
        
        return table;
    }
    
    private void getTramosAlcanceTable (PdfPTable table, List tramos, String dsgSociedad, String codSoci, int cdgoExped)
    {
        Phrase phrase = null;
        PdfPCell cell = null;
        
        for(int i = 0; i < tramos.size(); i++)
       {
           HashMap mapAux = (HashMap) tramos.get(i);
           
           String codSociedadTramo = (String) mapAux.get("cdgoSociotor");
           Integer cdgoExpedTramo = (Integer) mapAux.get("cdgoExpediente");
           
           if (codSociedadTramo.equals(codSoci) && cdgoExped == cdgoExpedTramo)
           {
        	   phrase = new Phrase(mapAux.get("cdgoLinea").toString(), this.defaultFont);
               cell = new PdfPCell(phrase);
               cell.setBackgroundColor(new Color(238,210,238));
               cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
               cell.setHorizontalAlignment(Element.ALIGN_CENTER);
               cell.setPadding(6);
               table.addCell(cell);
               
               phrase = new Phrase(mapAux.get("codEstOrigen").toString(), this.defaultFont);
               cell = new PdfPCell(phrase);
               cell.setBackgroundColor(new Color(238,210,238));
               cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
               cell.setHorizontalAlignment(Element.ALIGN_CENTER);
               cell.setPadding(6);
               table.addCell(cell);
               
               phrase = new Phrase(mapAux.get("desgNomLargoOrigen").toString(), this.defaultFont);
               cell = new PdfPCell(phrase);
               cell.setBackgroundColor(new Color(238,210,238));
               cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
               cell.setHorizontalAlignment(Element.ALIGN_CENTER);
               cell.setPadding(6);
               table.addCell(cell);    
               
               phrase = new Phrase(mapAux.get("codEstacionDestino").toString(), this.defaultFont);
               cell = new PdfPCell(phrase);
               cell.setBackgroundColor(new Color(238,210,238));
               cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
               cell.setHorizontalAlignment(Element.ALIGN_CENTER);
               cell.setPadding(6);
               table.addCell(cell);
               
               phrase = new Phrase(mapAux.get("desgNomLargoDestino").toString(), this.defaultFont);
               cell = new PdfPCell(phrase);
               cell.setBackgroundColor(new Color(238,210,238));
               cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
               cell.setHorizontalAlignment(Element.ALIGN_CENTER);
               cell.setPadding(6);
               table.addCell(cell);
               
               // Fecha otorgamiento por l�nea
        
               phrase = new Phrase(mapAux.get("fchaestadoString").toString(), this.defaultFont);           
               
               cell = new PdfPCell(phrase);
               cell.setBackgroundColor(new Color(238,210,238));
               cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
               cell.setHorizontalAlignment(Element.ALIGN_CENTER);
               cell.setPadding(6);
               table.addCell(cell);   
               
               phrase = new Phrase(dsgSociedad, this.defaultFont);                     
               cell = new PdfPCell(phrase);
               cell.setBackgroundColor(new Color(238,210,238));
               cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
               cell.setHorizontalAlignment(Element.ALIGN_CENTER);
               cell.setPadding(6);
               table.addCell(cell);  
           }

       }
    }
    
    private void getTramosAlcanceTableConFechaFinValidez (PdfPTable table, List tramos, String dsgSociedad, String codSoci, int cdgoExped, String fechaFinValidez, String fechaIniValidez)
    {
        Phrase phrase = null;
        PdfPCell cell = null;
        
        for(int i = 0; i < tramos.size(); i++)
       {
        	ObjectMapper mapper = new ObjectMapper();
        	GetMaxEntornosExpCodListDTO mapAux = mapper.convertValue(tramos.get(i), GetMaxEntornosExpCodListDTO.class);
 
           String codSociedadTramo = mapAux.getCdgoSociotor();
           Integer cdgoExpedTramo = mapAux.getCdgoExpediente();
           
           if (codSociedadTramo.equals(codSoci) && cdgoExped == cdgoExpedTramo)
           {
        	   phrase = new Phrase(mapAux.getCdgoLinea(), this.defaultFont);
               cell = new PdfPCell(phrase);
               cell.setBackgroundColor(new Color(238,210,238));
               cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
               cell.setHorizontalAlignment(Element.ALIGN_CENTER);
               cell.setPadding(6);
               table.addCell(cell);
               
               phrase = new Phrase(mapAux.getCodEstOrigen(), this.defaultFont);
               cell = new PdfPCell(phrase);
               cell.setBackgroundColor(new Color(238,210,238));
               cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
               cell.setHorizontalAlignment(Element.ALIGN_CENTER);
               cell.setPadding(6);
               table.addCell(cell);
               
               phrase = new Phrase(mapAux.getDesgNomLargoOrigen(), this.defaultFont);
               cell = new PdfPCell(phrase);
               cell.setBackgroundColor(new Color(238,210,238));
               cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
               cell.setHorizontalAlignment(Element.ALIGN_CENTER);
               cell.setPadding(6);
               table.addCell(cell);    
               
               phrase = new Phrase(mapAux.getCodEstacionDestino(), this.defaultFont);
               cell = new PdfPCell(phrase);
               cell.setBackgroundColor(new Color(238,210,238));
               cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
               cell.setHorizontalAlignment(Element.ALIGN_CENTER);
               cell.setPadding(6);
               table.addCell(cell);
               
               phrase = new Phrase(mapAux.getDesgNomLargoDestino(), this.defaultFont);
               cell = new PdfPCell(phrase);
               cell.setBackgroundColor(new Color(238,210,238));
               cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
               cell.setHorizontalAlignment(Element.ALIGN_CENTER);
               cell.setPadding(6);
               table.addCell(cell);
               
               // Fecha otorgamiento por l�nea
          
               phrase = new Phrase(fechaIniValidez, this.defaultFont);           
               
               cell = new PdfPCell(phrase);
               cell.setBackgroundColor(new Color(238,210,238));
               cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
               cell.setHorizontalAlignment(Element.ALIGN_CENTER);
               cell.setPadding(6);
               table.addCell(cell);   
               
               phrase = new Phrase(fechaFinValidez, this.defaultFont);
               cell = new PdfPCell(phrase);
               cell.setBackgroundColor(new Color(238,210,238));
               cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
               cell.setHorizontalAlignment(Element.ALIGN_CENTER);
               cell.setPadding(6);
               table.addCell(cell);
               
               phrase = new Phrase(dsgSociedad, this.defaultFont);                     
               cell = new PdfPCell(phrase);
               cell.setBackgroundColor(new Color(238,210,238));
               cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
               cell.setHorizontalAlignment(Element.ALIGN_CENTER);
               cell.setPadding(6);
               table.addCell(cell);  
           }

       }
    }
    
    private void getSerieTable (PdfPTable table, List listSerie, String dsgSociedad)
    {
        Phrase phrase = null;
        PdfPCell cell = null;
        for(int i = 0; i < listSerie.size(); i++)
       {
           HashMap mapAux = (HashMap) listSerie.get(i);
           
           phrase = new Phrase(mapAux.get("serie").toString(), this.defaultFont);
           cell = new PdfPCell(phrase);
           cell.setBackgroundColor(new Color(238,210,238));
           cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
           cell.setHorizontalAlignment(Element.ALIGN_CENTER);
           cell.setPadding(6);
           table.addCell(cell);
           
           if ( mapAux.containsKey("subSerie") )
               phrase = new Phrase(mapAux.get("subSerie").toString(), this.defaultFont);
           else
               phrase = new Phrase("", this.defaultFont);
           
           cell = new PdfPCell(phrase);
           cell.setBackgroundColor(new Color(238,210,238));
           cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
           cell.setHorizontalAlignment(Element.ALIGN_CENTER);
           cell.setPadding(6);
           table.addCell(cell);
           
           phrase = new Phrase(mapAux.get("fchaEstado").toString(), this.defaultFont);
           cell = new PdfPCell(phrase);
           cell.setBackgroundColor(new Color(238,210,238));
           cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
           cell.setHorizontalAlignment(Element.ALIGN_CENTER);
           cell.setPadding(6);
           table.addCell(cell);
           
           phrase = new Phrase(dsgSociedad, this.defaultFont);             
           cell = new PdfPCell(phrase);
           cell.setBackgroundColor(new Color(238,210,238));
           cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
           cell.setHorizontalAlignment(Element.ALIGN_CENTER);
           cell.setPadding(6);
           table.addCell(cell); 
       }
    }
    
    private void getContenidoTable (PdfPTable table, List listSerie, String dsgSociedad)
    {
        Phrase phrase = null;
        PdfPCell cell = null;
        
        for(int i = 0; i < listSerie.size(); i++)
       {
           HashMap mapAux = (HashMap) listSerie.get(i);
           
           phrase = new Phrase(mapAux.get("descripcion").toString(), this.defaultFont);
           cell = new PdfPCell(phrase);
           cell.setBackgroundColor(new Color(238,210,238));
           cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
           cell.setHorizontalAlignment(Element.ALIGN_CENTER);
           cell.setPadding(6);
           table.addCell(cell);
           
           phrase = new Phrase(mapAux.get("fchaEstado").toString(), this.defaultFont);
           cell = new PdfPCell(phrase);
           cell.setBackgroundColor(new Color(238,210,238));
           cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
           cell.setHorizontalAlignment(Element.ALIGN_CENTER);
           cell.setPadding(6);
           table.addCell(cell);
           
           phrase = new Phrase(dsgSociedad, this.defaultFont);           
           cell = new PdfPCell(phrase);
           cell.setBackgroundColor(new Color(238,210,238));
           cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
           cell.setHorizontalAlignment(Element.ALIGN_CENTER);
           cell.setPadding(6);
           table.addCell(cell); 
       }
    }
    
    private void getContenidoTablecConFechaFinValidez (PdfPTable table, List listSerie, String dsgSociedad, String fechaFinValidez, String fechaIniValidez )
    {
        Phrase phrase = null;
        PdfPCell cell = null;
        
        for(int i = 0; i < listSerie.size(); i++)
       {
           HashMap mapAux = (HashMap) listSerie.get(i);
           
           phrase = new Phrase(mapAux.get("descripcion").toString(), this.defaultFont);
           cell = new PdfPCell(phrase);
           cell.setBackgroundColor(new Color(238,210,238));
           cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
           cell.setHorizontalAlignment(Element.ALIGN_CENTER);
           cell.setPadding(6);
           table.addCell(cell);
           
           phrase = new Phrase(fechaIniValidez, this.defaultFont);
           cell = new PdfPCell(phrase);
           cell.setBackgroundColor(new Color(238,210,238));
           cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
           cell.setHorizontalAlignment(Element.ALIGN_CENTER);
           cell.setPadding(6);
           table.addCell(cell);
           
           phrase = new Phrase(fechaFinValidez, this.defaultFont);
           cell = new PdfPCell(phrase);
           cell.setBackgroundColor(new Color(238,210,238));
           cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
           cell.setHorizontalAlignment(Element.ALIGN_CENTER);
           cell.setPadding(6);
           table.addCell(cell);
           
           phrase = new Phrase(dsgSociedad, this.defaultFont);           
           cell = new PdfPCell(phrase);
           cell.setBackgroundColor(new Color(238,210,238));
           cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
           cell.setHorizontalAlignment(Element.ALIGN_CENTER);
           cell.setPadding(6);
           table.addCell(cell); 
       }
    }
    
    private void getContenidoTableValidez (PdfPTable table, List listSerie, String dsgSociedad)
    {
        Phrase phrase = null;
        PdfPCell cell = null;
        
        for(int i = 0; i < listSerie.size(); i++)
       {
           HashMap mapAux = (HashMap) listSerie.get(i);
           
           phrase = new Phrase(mapAux.get("descripcion").toString(), this.defaultFont);
           cell = new PdfPCell(phrase);
           cell.setBackgroundColor(new Color(238,210,238));
           cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
           cell.setHorizontalAlignment(Element.ALIGN_CENTER);
           cell.setPadding(6);
           cell.setColspan(2);
           table.addCell(cell);

           if ( mapAux.containsKey("fchaIniValidez") )
           {
               phrase = new Phrase(mapAux.get("fchaIniValidez").toString(), this.defaultFont);
           }
           else
           {
               phrase = new Phrase("", this.defaultFont);
           }
           cell = new PdfPCell(phrase);
           cell.setBackgroundColor(new Color(238,210,238));
           cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
           cell.setHorizontalAlignment(Element.ALIGN_CENTER);
           cell.setPadding(6);
           table.addCell(cell);
           
           if ( mapAux.containsKey("fchaFinValidez") )
           {
               phrase = new Phrase(mapAux.get("fchaFinValidez").toString(), this.defaultFont);
           }
           else
           {
               phrase = new Phrase("", this.defaultFont);
           }
           
           cell = new PdfPCell(phrase);
           cell.setBackgroundColor(new Color(238,210,238));
           cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
           cell.setHorizontalAlignment(Element.ALIGN_CENTER);
           cell.setPadding(6);
           table.addCell(cell);
           
           phrase = new Phrase(dsgSociedad, this.defaultFont);           
           cell = new PdfPCell(phrase);
           cell.setBackgroundColor(new Color(238,210,238));
           cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
           cell.setHorizontalAlignment(Element.ALIGN_CENTER);
           cell.setPadding(6);
           cell.setColspan(2);
           table.addCell(cell); 
       }
    }
    
    private void getTiposHabTable (PdfPTable table, List lTiposHab)
    {
        Phrase phrase = null;
        PdfPCell cell = null;
        String text = "";      
        
        for(int i = 0; i < lTiposHab.size(); i++)
       {
           HashMap mapFechaValidez = (HashMap) lTiposHab.get(i);
           
           // Tipo habilitacion
           if (mapFechaValidez.containsKey("tipoHab")) {
           		text = (String)mapFechaValidez.get("tipoHab");
           } else {
           		text = "";
           }           
           phrase = new Phrase(text, this.defaultFont);
           cell = new PdfPCell(phrase);
           cell.setBackgroundColor(new Color(238,210,238));
           cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
           cell.setHorizontalAlignment(Element.ALIGN_CENTER);
           cell.setPadding(6);
           table.addCell(cell);
           
           // Fecha validez
           if (mapFechaValidez.containsKey("fchaValidez") &&
           		!((String)mapFechaValidez.get("fchaValidez")).equals("")) {
           		text = (String)mapFechaValidez.get("fchaValidez");
           } else {
           		text = HabilitacionEstadoPdfCts.DATE_NOT_FILL;
           }
           phrase = new Phrase(text, this.defaultFont);
           cell = new PdfPCell(phrase);
           cell.setBackgroundColor(new Color(238,210,238));
           cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
           cell.setHorizontalAlignment(Element.ALIGN_CENTER);
           cell.setPadding(6);
           table.addCell(cell);
       }
    }
    
    private PdfPTable getLineaHorizontal()
    {
        Graphic horizontalLine = new Graphic();
        horizontalLine.setHorizontalLine(1f, 100f, new Color(140,0,75), Element.ALIGN_RIGHT);
        PdfPCell c430 = new PdfPCell(new Phrase (" "));
        c430.setColspan(5);
        c430.setBorder(PdfPCell.NO_BORDER);
        c430.addElement(horizontalLine);
        PdfPTable table = new PdfPTable(1);
        table.addCell(c430);
        table.setSpacingBefore(10);
        
        return table;
    }
    
    protected void setFooter(Object bean) {

        Font fontFooter = createFont(new int[]{});
        BundleMgr bundleMgr = BundleMgr.getInstance();
        HabilitacionEstadoBean beanHabEstado = (HabilitacionEstadoBean) bean;
        
        fontFooter.setSize(6);
        Phrase phraseFooter = new Phrase(bundleMgr.resolve(HabilitacionEstadoPdfCts.BUNDLE_CTS_FOOTER_1, HabilitacionEstadoPdfCts.BUNDLE_NAME), fontFooter);
        phraseFooter.add(new Phrase(bundleMgr.resolve(HabilitacionEstadoPdfCts.BUNDLE_CTS_FOOTER_2, HabilitacionEstadoPdfCts.BUNDLE_NAME), fontFooter));
        fontFooter = createFont(new int[]{Font.BOLD});
        fontFooter.setSize(7);
        phraseFooter.add(new Phrase(bundleMgr.resolve(HabilitacionEstadoPdfCts.BUNDLE_CTS_FOOTER_3, HabilitacionEstadoPdfCts.BUNDLE_NAME), fontFooter));
        fontFooter = this.defaultFont;
        fontFooter.setSize(7);
        
        String text = bundleMgr.resolve(HabilitacionEstadoPdfCts.BUNDLE_CTS_FOOTER_4, HabilitacionEstadoPdfCts.BUNDLE_NAME);
        if ( null != beanHabEstado.getNifPas())
            text += beanHabEstado.getNifPas();
        
        phraseFooter.add(new Phrase(text, fontFooter));
        
        phraseFooter.add(new Phrase(bundleMgr.resolve(HabilitacionEstadoPdfCts.BUNDLE_CTS_FOOTER_5, HabilitacionEstadoPdfCts.BUNDLE_NAME), fontFooter));
        
        //Calcular n� de pagina
 
        HeaderFooter footer = new HeaderFooter(phraseFooter, true);
        //footer.setAlignment()
        this.headerFooter = footer;
    }
    
	protected void writeDocument(Object bean, ResourceBundle message)
			throws DocumentException {
		
	}

	@Override
	protected void writeDocument(Object bean, ResourceBundle message, String tipoHabi,
			List<Tbasg260HabilifuncDto> listaFunciones) throws DocumentException {
		
	}

    @Override
    protected void writeDocument(Object bean, ResourceBundle message, String tipoHabi) throws DocumentException {
    }
}
