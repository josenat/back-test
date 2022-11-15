package renfe.com.pdf.print;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfWriter;

import renfe.com.pdf.core.ImpPdfWriterAux;
import renfe.com.pdf.data.GetTitulo;
import renfe.com.util.ImprimirCts;

public class ImpTitulo extends ImpPdfWriterAux {

	private ImprimirCts objCte = new ImprimirCts();

	private GetTitulo objTitulo = null;
	private String sFinal = "\r\n";

	public ImpTitulo(GetTitulo titulo, Document document, PdfWriter pdfWriter, Font defaultFont) {
		super(document, pdfWriter, defaultFont);
		this.objTitulo = titulo;
	}

	public Paragraph Parrafo001() {
		return (this.IT_Parrafo001());
	}

	private String GetLinea_Blanco() {
		return ("  ");
	}

	private Paragraph IT_Parrafo001() {
		Paragraph paragraph = new Paragraph();
		Font font = null;

		font = createFont(new int[] { Font.BOLD });
		font.setColor(140, 0, 75);
		font.setSize(this.objCte.FONT_SIZE_BASE);

		this.defaultFont.setSize(this.objCte.FONT_SIZE_BASE);

		// Entodo caso tenga o no titulo
		Phrase Linea000 = new Phrase(this.GetLinea_Blanco(), this.defaultFont);
		Linea000.add(this.sFinal);
		paragraph.add(Linea000);

		if (this.objTitulo.GetEstatus() == true) {
			// Parrafo (Datos Titulo de conduccion)
			Phrase Linea000A = new Phrase(this.objTitulo.GetLinea_000(), font);
			Phrase Linea001 = new Phrase(this.objTitulo.GetLinea_001(), this.defaultFont);

			Linea000A.add(this.sFinal);
			Linea001.add(this.sFinal);

			paragraph.add(Linea000A);
			paragraph.add(Linea001);
		}

		return (paragraph);

	}
}
