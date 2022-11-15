package renfe.com.pdf.core;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.HeaderFooter;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfWriter;

import renfe.com.model.dto.Tbasg260HabilifuncDto;

public abstract class AsgPdfWriter {

	protected Font defaultFont;
	protected int defaultAlignment;
	protected Document document;
	protected HeaderFooter headerFooter;

	protected PdfWriter pdfWriter;

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(AsgPdfWriter.class);

	protected AsgPdfWriter() {
		super();
	}

	protected abstract void writeDocument(Object bean, ResourceBundle message, String tipoHabi,
			List<Tbasg260HabilifuncDto> listaFunciones) throws DocumentException;

	protected abstract void writeDocument(Object bean, ResourceBundle message) throws DocumentException;

	protected abstract void writeDocument(Object bean) throws DocumentException;

	public void createPDF(Object bean, OutputStream outputStream) throws InternalErrorException {

		this.document = new Document();
		try {
//        	IGC RNF09-00005511
//        	PdfWriter pdfWriter = PdfWriter.getInstance(this.document, outputStream);            
			this.pdfWriter = PdfWriter.getInstance(this.document, outputStream);
			document.open();
			writeDocument(bean);
			document.close();
		} catch (DocumentException e) {
			throw new InternalErrorException(e);
		}
	}

	public void createPDFCertifComplementario(Object bean, OutputStream outputStream, boolean landscape, boolean footer,
			ResourceBundle message, Object tbasg104ExpedientDto) throws InternalErrorException {
		if (landscape)
			this.document = new Document(PageSize.A4.rotate(), 50, 40, 20, 30);
		else
			this.document = new Document(PageSize.A4, 36, 36, 36, 36);
		try {
			PdfWriter pdfWriter = PdfWriter.getInstance(this.document, outputStream);

			if (footer) {
				setFooter(bean);
				document.setFooter(this.headerFooter);
			}
			document.open();
			writeDocument(tbasg104ExpedientDto, message);
			document.close();
		} catch (DocumentException e) {
			logger.error("ERROR DocumentException {}", e);
		}
	}

	public byte[] createPDFCertifComplementarioWs(Object bean, boolean landscape, boolean footer,
			ResourceBundle message) throws InternalErrorException {
		byte[] resultado = null;
		if (landscape)
			this.document = new Document(PageSize.A4.rotate(), 50, 40, 20, 30);
		else
			this.document = new Document(PageSize.A4, 36, 36, 36, 36);
		try {

			if (footer) {
				setFooter(bean);
				document.setFooter(this.headerFooter);
			}
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			PdfWriter.getInstance(document, byteArrayOutputStream);
			document.open();
			writeDocument(bean, message);
			document.close();
			resultado = byteArrayOutputStream.toByteArray();
		} catch (DocumentException e) {
			throw new InternalErrorException(e);
		}
		return resultado;
	}

	public void createPDF(Object bean, OutputStream outputStream, boolean landscape, boolean footer,
			Object getFindPersonaAltasDTO) throws InternalErrorException {

		if (landscape)
			this.document = new Document(PageSize.A4, 50, 40, 20, 30);
		else
			this.document = new Document(PageSize.A4, 36, 36, 36, 36);
		try {
			PdfWriter pdfWriter = PdfWriter.getInstance(this.document, outputStream);

			if (footer) {
				setFooter(getFindPersonaAltasDTO);
				document.setFooter(this.headerFooter);
			}
			document.open();
			writeDocument(getFindPersonaAltasDTO);
			document.close();
		} catch (DocumentException e) {
			throw new InternalErrorException(e);
		}
	}

	public void createPDFAOT(Object bean, OutputStream outputStream, boolean landscape, boolean footer,
			ResourceBundle message, String tipoHabi, Object tbasg104ExpedientDto,
			List<Tbasg260HabilifuncDto> listaFunciones) throws InternalErrorException {

		if (landscape)
			this.document = new Document(PageSize.A4.rotate(), 50, 40, 20, 30);
		else
			this.document = new Document(PageSize.A4, 36, 36, 36, 36);
		try {
			PdfWriter pdfWriter = PdfWriter.getInstance(this.document, outputStream);

			if (footer) {
				setFooter(bean);
				document.setFooter(this.headerFooter);
			}
			document.open();
			writeDocument(tbasg104ExpedientDto, message, tipoHabi, listaFunciones);
			document.close();
		} catch (DocumentException e) {
			throw new InternalErrorException(e);
		}
	}

	protected Paragraph createParagraph() {

		return createParagraph("");
	}

	protected Paragraph createParagraph(String text) {

		return createParagraph(text, null);
	}

	protected Paragraph createParagraph(String text, Font font) {

		Paragraph paragraph = null;
		if (font == null) {
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

		if (values != null) {

			for (int i = 0; i < values.length; i++) {

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
			if (style != null) {

				for (int i = 0; i < style.length; i++) {

					font.setStyle(style[i]);
				}
			}
		} catch (Exception e) {
			return this.defaultFont;
		}
		return font;
	}

	protected Font createFont(String family, float size, int[] style) {

		Font font = new Font();
		try {

			font.setSize(size);
			font.setFamily(family);
			if (style != null) {

				for (int i = 0; i < style.length; i++) {

					font.setStyle(style[i]);
				}
			}
		} catch (Exception e) {
			return this.defaultFont;
		}
		return font;
	}

	protected void setFooter(Object bean) {
	}

	protected abstract void writeDocument(Object bean, ResourceBundle message, String tipoHabi)
			throws DocumentException;

	public void createPDF(Object bean, OutputStream outputStream, boolean landscape, boolean footer)
			throws InternalErrorException {

		if (landscape)
			this.document = new Document(PageSize.A4.rotate(), 50, 40, 20, 30);
		else
			this.document = new Document(PageSize.A4, 36, 36, 36, 36);
		try {
			PdfWriter pdfWriter = PdfWriter.getInstance(this.document, outputStream);

			if (footer) {
				setFooter(bean);
				document.setFooter(this.headerFooter);
			}
			document.open();
			writeDocument(bean);
			document.close();
		} catch (DocumentException e) {
			throw new InternalErrorException(e);
		}
	}

	public void createPDFAOT(Object bean, OutputStream outputStream, boolean landscape, boolean footer,
			ResourceBundle message, String tipoHabi) throws InternalErrorException {

		if (landscape)
			this.document = new Document(PageSize.A4.rotate(), 50, 40, 20, 30);
		else
			this.document = new Document(PageSize.A4, 36, 36, 36, 36);
		try {
			PdfWriter pdfWriter = PdfWriter.getInstance(this.document, outputStream);

			if (footer) {
				setFooter(bean);
				document.setFooter(this.headerFooter);
			}
			document.open();
			writeDocument(bean, message, tipoHabi);
			document.close();
		} catch (DocumentException e) {
			throw new InternalErrorException(e);
		}

	}

}
