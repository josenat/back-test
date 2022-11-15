package renfe.com.pdf.core;

import java.net.URL;

import java.awt.Color;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;

import com.lowagie.text.BadElementException;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;

import renfe.com.dto.GetFindPersonaAltasBajasDTO;
import renfe.com.model.dto.Tbasg260HabilifuncDto;
import renfe.com.model.entity.Tbasg100Persona;
import renfe.com.pdf.beans.InformeAltaBajaBean;
import renfe.com.util.InformesAltaBajaPdfCts;


public class InformeAltaBajaPdfWriter extends AsgPdfWriter{
	//private String imgPath = null;
	
	private URL aes = InformeAltaBajaPdfWriter.class.getClassLoader().getResource(InformesAltaBajaPdfCts.IMG_AGENCIA);
	private URL ministerioFomento = InformeAltaBajaPdfWriter.class.getClassLoader().getResource(InformesAltaBajaPdfCts.TOP_IMG);


	public InformeAltaBajaPdfWriter() 
	{
        super();
      
        this.defaultFont =  new Font();
        this.defaultFont.setFamily(InformesAltaBajaPdfCts.DEFAULT_FONT_FAMILY);        
        this.defaultFont.setSize(InformesAltaBajaPdfCts.DEFAULT_FONT_SIZE);        
        
        this.defaultAlignment = InformesAltaBajaPdfCts.DEFAULT_ALIGNMENT;
	}
	
	protected void writeDocument(Object object) throws DocumentException 
	{
	   	InformeAltaBajaBean bean = (InformeAltaBajaBean) object;
	   	// Variables
		Element element = null;
		Paragraph paragraph = null;
		String text = null;
		Font fontTitulo = null;
		Font fontParrafo = null;
		Font fontTextAgencia = null;
		//Font fontAnexo = null;
		PdfPCell celda = null;
		Paragraph parrafo = null;
		String nifEmpresa = "";
		
		// Fuentes
		fontTitulo = createFont(new int[]{Font.BOLD}); 
        fontTitulo.setFamily(InformesAltaBajaPdfCts.DEFAULT_FONT_FAMILY);
        fontTitulo.setSize(InformesAltaBajaPdfCts.DEFAULT_FONT_SIZE);
        
        fontParrafo = createFont(new int[] {Font.NORMAL}); 
        fontParrafo.setFamily(InformesAltaBajaPdfCts.DEFAULT_FONT_FAMILY);
        fontParrafo.setSize(InformesAltaBajaPdfCts.DEFAULT_FONT_SIZE);
        
        Color colorMorado = new Color(40,23,106,255);
        fontTextAgencia = createFont(new int[] {Font.NORMAL});
        fontTextAgencia.setColor(colorMorado);

        
        // Agregamos el logo de AES
        Image image = null;
        try {
            image = Image.getInstance(aes); 
        } catch (BadElementException e) {            
            throw new DocumentException(e);
        } catch (MalformedURLException e) {
            throw new DocumentException(e);
        } catch (IOException e) {
            throw new DocumentException(e);
        }
        image.setAlignment(Element.ALIGN_LEFT);

		// Creamos una tabla para la cabecera
		PdfPTable tablaCabecera = new PdfPTable(2);
		tablaCabecera.getDefaultCell().setBorder(0);
		tablaCabecera.setWidthPercentage(90f);
		float[] anchurasC = {70,30};
		tablaCabecera.setWidths(anchurasC);
        
		
		// Agregamos la imagen de la cabecera y el tirulo
		text = InformesAltaBajaPdfCts.CABECERA_INFORME;
		Paragraph textAgencia = new Paragraph(text, fontTextAgencia);
		
		PdfPTable tituloCabecera = new PdfPTable(2);
		tituloCabecera.getDefaultCell().setBorder(0);
		tituloCabecera.setWidthPercentage(90f);
		float[] anchurasCa = {50,50};
		tituloCabecera.setWidths(anchurasCa);
		tituloCabecera.addCell(image);
		tituloCabecera.addCell(textAgencia);
		
		tablaCabecera.addCell(tituloCabecera);
		
		// Título de la cabecera
		Paragraph cabecera = new Paragraph("", fontParrafo);
		cabecera.setAlignment(Element.ALIGN_CENTER);
		celda = new PdfPCell();
		celda.setBorder(0);
		celda.setColspan(1);
		celda.addElement(cabecera);

           		
		tablaCabecera.addCell(celda);
		
		// Título principal del informe
		if (bean.isRefMercancias())
		{
		    text = InformesAltaBajaPdfCts.TITULO_INFORME_MERCANCIAS + bean.getfDesde();
		    if (!bean.getfHasta().equals(""))
		      text = text + InformesAltaBajaPdfCts.TITULO_INFORME2 + bean.getfHasta();
		    else
		    {
				  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
				  Date fechaActual = new Date(Calendar.getInstance().getTime().getTime());  
				  String fechaConFormato = sdf.format(fechaActual);  
			      text = text + InformesAltaBajaPdfCts.TITULO_INFORME2 + fechaConFormato;
			}
		}
		else
		{
			text = InformesAltaBajaPdfCts.TITULO_INFORMEV + bean.getfDesde();
			if (!bean.getfHasta().equals(""))
			      text = text + InformesAltaBajaPdfCts.TITULO_INFORME2 + bean.getfHasta();
			else
			{
				  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
				  Date fechaActual = new Date(Calendar.getInstance().getTime().getTime());  
				  String fechaConFormato = sdf.format(fechaActual);  
			      text = text + InformesAltaBajaPdfCts.TITULO_INFORME2 + fechaConFormato;
			}
			
			int contSoc = 0;
			
			if (bean.isMercancias())
				contSoc ++;
			if (bean.isAlquiler())
				contSoc ++;
			if (bean.isFabric())
				contSoc ++;
			if (bean.isOperadora())
				contSoc ++;
			if( bean.isViajeros())
				contSoc ++;

			if (contSoc > 1)
			  text = text + " PARA LAS SOCIEDADES ";
			if (contSoc == 1)
			  text = text + " PARA LA SOCIEDAD ";	
				
			if (bean.isMercancias())
			{
				text = text + " RENFE MERCANCÍAS";
			    if (bean.isAlquiler() || bean.isFabric() || bean.isOperadora() || bean.isViajeros())
			    	text = text + ",";	
			}
			if (bean.isAlquiler())
			{
				text = text + " RENFE ALQ.MAT.FERROV.";
			    if (bean.isFabric() || bean.isOperadora() || bean.isViajeros())
		    	    text = text + ",";	
			}
			if (bean.isFabric())
			{
				text = text + " RENFE FABRICAC. Y MANT.";
		        if (bean.isOperadora() || bean.isViajeros())
	    	        text = text + ",";	
			}
			if (bean.isOperadora())
			{
				text = text + " RENFE EPE";
		        if (bean.isViajeros())
	    	        text = text + ",";	
			}
			if(bean.isViajeros())
				text = text + " RENFE VIAJEROS";
		}
			//text = InformesAltaBajaPdfCts.TITULO_INFORME_MERCANCIAS + bean.getfDesde() + InformesAltaBajaPdfCts.TITULO_INFORME2 + bean.getfHasta();
		Paragraph tituloPpal = new Paragraph(text, fontTitulo);
		tituloPpal.setAlignment(Element.ALIGN_CENTER);
		celda = new PdfPCell();
		celda.setBorder(0);
		celda.setColspan(3);
		celda.addElement(tituloPpal);
		tablaCabecera.addCell(celda);
		
		// Espacios entre líneas
		parrafo = new Paragraph("", fontParrafo);
		celda = new PdfPCell();
		celda.setColspan(3);
		celda.setBorder(0);
		celda.setHorizontalAlignment(Element.ALIGN_LEFT);
		celda.addElement(parrafo);
		tablaCabecera.addCell(celda);
		tablaCabecera.addCell(celda);
		tablaCabecera.addCell(celda);
		
		// NIF de la empresa
		
		if (bean.getPersonas() != null && !bean.getPersonas().isEmpty()) {
			GetFindPersonaAltasBajasDTO personaEmpresa = (GetFindPersonaAltasBajasDTO) bean.getPersonas().get(0);
			nifEmpresa = personaEmpresa.getNifEmpresa();
		}
		if (bean.isRefMercancias())
			nifEmpresa = "A86868114";
		
		if (bean.isRefViajeros())
			nifEmpresa ="A86868189";
		
		text = InformesAltaBajaPdfCts.NIF_EMPRESA + "  " + nifEmpresa;
		parrafo = new Paragraph(text, fontParrafo);
		parrafo.setAlignment(Element.ALIGN_LEFT);
		celda = new PdfPCell();
		celda.setBorder(0);
		celda.setColspan(2);
		celda.addElement(parrafo);
		tablaCabecera.addCell(celda);
		
		document.add(tablaCabecera);
		
		// Tabla con los datos de las personas
		PdfPTable tabla = new PdfPTable(6);
		tabla.getDefaultCell().setBorder(0);
		tabla.setWidthPercentage(90f);
		float[] anchuras = {16,17,17,17,17,16};
		tabla.setWidths(anchuras);
		
		parrafo = new Paragraph("", fontParrafo);
		celda = new PdfPCell();
		celda.setColspan(2);
		celda.setBorder(0);
		celda.setHorizontalAlignment(Element.ALIGN_LEFT);
		celda.addElement(parrafo);
		tabla.addCell(celda);
		
		// Espacios entre líneas
		parrafo = new Paragraph("", fontParrafo);
		celda = new PdfPCell();
		celda.setColspan(6);
		celda.setBorder(0);
		celda.setHorizontalAlignment(Element.ALIGN_LEFT);
		celda.addElement(parrafo);
		tabla.addCell(celda);
		tabla.addCell(celda);
		
		// Cabecera del listado de personas
		// Tipo de documento
		text = InformesAltaBajaPdfCts.TIPO_DOCUMENTO;
		parrafo = new Paragraph(text, fontParrafo);
		parrafo.setAlignment(Element.ALIGN_CENTER);
		celda = new PdfPCell();
		celda.setBorder(0);
		celda.setBorderWidthBottom(0.5f);
		celda.setColspan(1);
		celda.addElement(parrafo);
		tabla.addCell(celda);
		
		// Nº documento conductor
		text = InformesAltaBajaPdfCts.DOCUMENTO_CONDUCTOR;
		parrafo = new Paragraph(text, fontParrafo);
		parrafo.setAlignment(Element.ALIGN_CENTER);
		celda = new PdfPCell();
		celda.addElement(parrafo);
		celda.setBorder(0);
		celda.setBorderWidthBottom(0.5f);
		tabla.addCell(celda);

		// Título persona
		text = InformesAltaBajaPdfCts.TITULO_PERSONA;
		parrafo = new Paragraph(text, fontParrafo);
		parrafo.setAlignment(Element.ALIGN_CENTER);
		celda = new PdfPCell();
		celda.setBorder(0);
		celda.setBorderWidthBottom(0.5f);
		celda.addElement(parrafo);
		tabla.addCell(celda);
		
		// Alta/Baja
		text = InformesAltaBajaPdfCts.ALTA_BAJA;
		parrafo = new Paragraph(text, fontParrafo);
		parrafo.setAlignment(Element.ALIGN_CENTER);
		celda = new PdfPCell();
		celda.setBorder(0);
		celda.setBorderWidthBottom(0.5f);
		celda.addElement(parrafo);
		tabla.addCell(celda);	
		
		// Fecha
		text = InformesAltaBajaPdfCts.FECHA;
		parrafo = new Paragraph(text, fontParrafo);
		parrafo.setAlignment(Element.ALIGN_CENTER);
		celda = new PdfPCell();
		celda.setBorder(0);
		celda.setBorderWidthBottom(0.5f);
		celda.addElement(parrafo);
		tabla.addCell(celda);
		
		// Sociedad
		text = InformesAltaBajaPdfCts.SOCIEDAD;
		parrafo = new Paragraph(text, fontParrafo);
		parrafo.setAlignment(Element.ALIGN_CENTER);
		celda = new PdfPCell();
		celda.setBorder(0);
		celda.setBorderWidthBottom(0.5f);
		celda.addElement(parrafo);
		tabla.addCell(celda);
	
		
		// Recorremos el listado de personas y pintamos los valores de cada
		// columna
		String tipoDoc = null;
		String nif = null;
		String titulo = null;
		String activo = null;
		Date fecha = null;
		String cdgoSociedad = null;
		String sociedad = null;
		
		SimpleDateFormat formato = new SimpleDateFormat(InformesAltaBajaPdfCts.FORMATO_FECHA);
		String strFecha = null;
		if (bean.getPersonas() != null && !bean.getPersonas().isEmpty()) {
			java.util.List listaPersonas = bean.getPersonas();
			for (int i = 0; i < listaPersonas.size(); i++) {
				GetFindPersonaAltasBajasDTO persona = (GetFindPersonaAltasBajasDTO) listaPersonas.get(i);
				
				tipoDoc = (persona.getDescTipodoc() != null ? persona.getDescTipodoc().trim() : "");
				nif = (persona.getDesgNifpas() != null ? persona.getDesgNifpas().trim() : "");
				titulo = (persona.getTitulo() != null ? persona.getTitulo().trim() : "");
				activo = persona.getActivo();
				fecha = persona.getFecha();
				cdgoSociedad = persona.getCdgoSociedad();
				
				// Formatemos la fecha
				strFecha = formato.format(fecha);
				
				// Primera columna - Tipo de documento
				text = tipoDoc;
				parrafo = new Paragraph(text, fontParrafo);
				parrafo.setAlignment(Element.ALIGN_CENTER);
				celda = new PdfPCell();
				celda.setBorder(0);
				celda.addElement(parrafo);
				tabla.addCell(celda);

				// Segunda columna - Nº documento conductor
				text = nif;
				parrafo = new Paragraph(text, fontParrafo);
				parrafo.setAlignment(Element.ALIGN_CENTER);
				celda = new PdfPCell();
				celda.setBorder(0);
				celda.addElement(parrafo);
				tabla.addCell(celda);
				
				// Tercera columna - Título
				text = titulo;
				parrafo = new Paragraph(text, fontParrafo);
				parrafo.setAlignment(Element.ALIGN_CENTER);
				celda = new PdfPCell();
				celda.setBorder(0);
				celda.addElement(parrafo);
				tabla.addCell(celda);
				
				// Cuarta columna - alta/baja
				text = activo;
				parrafo = new Paragraph(text, fontParrafo);
				parrafo.setAlignment(Element.ALIGN_CENTER);
				celda = new PdfPCell();
				celda.setBorder(0);
				celda.addElement(parrafo);
				tabla.addCell(celda);
				
				// Quinta columna - fecha
				text = strFecha;
				parrafo = new Paragraph(text, fontParrafo);
				parrafo.setAlignment(Element.ALIGN_CENTER);
				celda = new PdfPCell();
				celda.setBorder(0);
				celda.addElement(parrafo);
				tabla.addCell(celda);
		 
				if (cdgoSociedad.equals("1000"))
					sociedad = "Renfe Operadora";
				if (cdgoSociedad.equals("1400"))
			    	sociedad = "Renfe Viajeros";
				if (cdgoSociedad.equals("1500"))
			    	sociedad = "Renfe Mercancías";
				if (cdgoSociedad.equals("1600"))
			    	sociedad = "Renfe Fabricac y Mant.";
				if (cdgoSociedad.equals("1700"))
			    	sociedad = "Renfe Alq.Mat.Ferrov.";
				
				// Sexta columna - Sociedad
				text = sociedad;
				parrafo = new Paragraph(text, fontParrafo);
				parrafo.setAlignment(Element.ALIGN_CENTER);
				celda = new PdfPCell();
				celda.setBorder(0);
				celda.addElement(parrafo);
				tabla.addCell(celda);
			} // for
		} // if

		tabla.setSpacingAfter(40f);
		
		// Añadimos la tabla al documento
		document.add(tabla);
		
		PdfPTable tablaPie = new PdfPTable(1);
		tablaPie.setWidthPercentage(60f);
		

		// Fecha
		Calendar fechaActual = Calendar.getInstance();
		String dia = Integer.toString(fechaActual.get(Calendar.DATE));
		int mes = fechaActual.get(Calendar.MONTH);
		String annio = Integer.toString(fechaActual.get(Calendar.YEAR));
		
		// Obtenemos el mes del que se trata
		String descMes = obtenerMes(mes);
		
		text = InformesAltaBajaPdfCts.FECHA_ACTUAL_DIA + " " + dia + " "
				+ InformesAltaBajaPdfCts.FECHA_ACTUAL_DE + " " + descMes + " "
				+ InformesAltaBajaPdfCts.FECHA_ACTUAL_DE + " " + annio;
		parrafo = new Paragraph(text, fontParrafo);
		parrafo.setAlignment(Element.ALIGN_RIGHT);
		celda = new PdfPCell();
		celda.setBorder(0);
		celda.addElement(parrafo);
		tablaPie.addCell(celda);
	
		// Añadimos el pie
		document.add(tablaPie);

	}
	
	/**
	 * Obtiene la descripción del mes del entero que se le pasa como parámetro
	 * 
	 * @param mes 
	 * @return descripción del mes
	 */
	private String obtenerMes(int mes) {
		String result = null;
		switch (mes) {
			case 0: {
				result = InformesAltaBajaPdfCts.MES_ENERO;
				break;
			}
			case 1: {
				result = InformesAltaBajaPdfCts.MES_FEBRERO;
				break;
			}
			case 2: {
				result = InformesAltaBajaPdfCts.MES_MARZO;
				break;
			}
			case 3: {
				result = InformesAltaBajaPdfCts.MES_ABRIL;
				break;
			}
			case 4: {
				result = InformesAltaBajaPdfCts.MES_MAYO;
				break;
			}
			case 5: {
				result = InformesAltaBajaPdfCts.MES_JUNIO;
				break;
			}
			case 6: {
				result = InformesAltaBajaPdfCts.MES_JULIO;
				break;
			}
			case 7: {
				result = InformesAltaBajaPdfCts.MES_AGOSTO;
				break;
			}
			case 8: {
				result = InformesAltaBajaPdfCts.MES_SEPTIEMBRE;
				break;
			}
			case 9: {
				result = InformesAltaBajaPdfCts.MES_OCTUBRE;
				break;
			}
			case 10: {
				result = InformesAltaBajaPdfCts.MES_NOVIEMBRE;
				break;
			}
			case 11: {
				result = InformesAltaBajaPdfCts.MES_DICIEMBRE;
				break;
			}
		}
		return result;
	}
    /**
     * Pasa los centimetros a puntos del pdf
     * @param centimetros
     * @return float
     */
    public float getPuntos(float centimetros) {
    	return (72f * centimetros)/ 2.54f;
    }    
    
    
	protected void writeDocument(Object bean, ResourceBundle message)
			throws DocumentException {
		// TODO Apéndice de método generado automáticamente
		
	}
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
