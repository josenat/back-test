package renfe.com.pdf.core;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.HeaderFooter;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfWriter;
public class ImpPdfWriterAux {

	private static final Logger log = LoggerFactory.getLogger(ImpPdfWriterAux.class);

    protected Font defaultFont;
    protected int defaultAlignment;              
    protected Document document;
    protected HeaderFooter headerFooter;
    protected PdfWriter pdfWriter;
   
    protected ImpPdfWriterAux(Document document, PdfWriter pdfWriter, Font defaultFont) {       
        super();
        this.document = document;
        this.pdfWriter = pdfWriter;
        this.defaultFont = defaultFont;
    }
                
    protected Paragraph createParagraph() {
        
        return createParagraph("");
    }  
    
    protected Paragraph createParagraph(String text) {
        
        return createParagraph(text, null);
    } 
    
    protected Paragraph createParagraph(String text, Font font) {
        
        Paragraph paragraph = null;        
        if(font == null) {
            paragraph = new Paragraph(text, this.defaultFont);
        } else {
            paragraph = new Paragraph(text, font);
        }                        
        paragraph.setAlignment(this.defaultAlignment);        
        return paragraph;
    }      

    protected Paragraph createParagraph(String[] values) {
        
        Paragraph paragraph = createParagraph();
        addPhrases(paragraph, values);
        return paragraph;
    }
    
    protected Paragraph createParagraph(String[] values, Font font) {
        
        Paragraph paragraph = createParagraph("", font);
        addPhrases(paragraph, values);
        return paragraph;
    }            
    
    private void addPhrases(Paragraph paragraph, String[] values) {

        if(values != null){
            
            for(int i = 0; i < values.length; i++){
                
                Phrase phrase = new Phrase(values[i]);
                paragraph.add(phrase);
            }
        }        
    }
    
    protected Font createFont(int[] style) {
        
        Font font = new Font();       
        try {
            
            font.setSize(this.defaultFont.getCalculatedSize());
            font.setFamily(this.defaultFont.getFamilyname());            
            if(style != null) {
                
                for(int i = 0; i < style.length; i++) {
                    
                    font.setStyle(style[i]);
                }
            }
        } catch (Exception e){
            return this.defaultFont;
        }
        return font;
     }
    
    protected Font createFont(String family, float size, int[] style) {
       
        Font font = new Font();
        try {
            
            font.setSize(size);
            font.setFamily(family);               
            if(style != null) {
                
                for(int i = 0; i < style.length; i++) {
                    
                    font.setStyle(style[i]);
                }
            }
        } catch (Exception e){
            return this.defaultFont;
        }
        return font;
    }   
    
    protected void setFooter(Object bean) {}
    
}
