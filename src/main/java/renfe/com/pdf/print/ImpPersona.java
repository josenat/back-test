package renfe.com.pdf.print;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfWriter;

import renfe.com.pdf.core.ImpPdfWriterAux;
import renfe.com.pdf.data.GetPersona;
import renfe.com.util.ImprimirCts;

public class ImpPersona extends ImpPdfWriterAux {

	private ImprimirCts objCte = new ImprimirCts();

	private GetPersona objPersona = null;
	private String sFinal = "\r\n";

	public ImpPersona(GetPersona persona, Document document, PdfWriter pdfWriter, Font defaultFont) {
		super(document, pdfWriter, defaultFont);
		this.objPersona = persona;
	}

	public Paragraph Titulo(int Pag) {
		return (this.IP_Titulo(Pag));
	}

	public Paragraph Parrafo001() {
		return (this.IP_Parrafo001());
	}

	public Paragraph Parrafo002() {
		return (this.IP_Parrafo002());
	}

	public Paragraph Parrafo003() {
		return (this.IP_Parrafo003());
	}

	private String GetLinea_Blanco() {
		return ("  ");
	}

	private Paragraph IP_Titulo(int Pag) {
		Paragraph paragraph = new Paragraph();
		Font font = null;

		font = createFont(new int[] { Font.BOLD });
		font.setColor(140, 0, 75);
		font.setSize(this.objCte.FONT_SIZE_TITULO);

		// Titulo
		Phrase Linea000 = new Phrase(this.objPersona.GetLinea_000(), font);
		Phrase LineaB = new Phrase(this.GetLinea_Blanco(), font);

		Linea000.add((" - [" + Pag + "]"));
		Linea000.add(this.sFinal);
		LineaB.add(this.sFinal);

		paragraph.add(Linea000);
		paragraph.add(LineaB);
		paragraph.setAlignment(Element.ALIGN_CENTER);
		return (paragraph);

	}

	private Paragraph IP_Parrafo001() {
		Paragraph paragraph = new Paragraph();
		Font font = null;

		font = createFont(new int[] { Font.BOLD });
		font.setColor(140, 0, 75);
		font.setSize(this.objCte.FONT_SIZE_BASE);

		this.defaultFont.setSize(this.objCte.FONT_SIZE_BASE);

		// Parrafo Primero (Datos Personales) - Nombre -
		Phrase Linea_Blanco = new Phrase(this.GetLinea_Blanco(), this.defaultFont);
		Phrase Linea000 = new Phrase(this.objPersona.GetLinea_000B(), font);
		Phrase Linea001 = new Phrase(this.objPersona.GetLinea_001(), this.defaultFont);
		Phrase Linea001B = new Phrase(this.objPersona.GetLinea_001B(), this.defaultFont);
		Phrase Linea001C = new Phrase(this.objPersona.GetLinea_001C(), this.defaultFont);
		Phrase Linea002 = new Phrase(this.objPersona.GetLinea_002(), this.defaultFont);

		Linea_Blanco.add(this.sFinal);
		Linea000.add(this.sFinal);
		Linea001.add(this.sFinal);
		Linea001B.add(this.sFinal);
		Linea001C.add(this.sFinal);
		Linea002.add(this.sFinal);

		paragraph.add(Linea_Blanco);
		paragraph.add(Linea000);
		paragraph.add(Linea001);
		paragraph.add(Linea001B);
		paragraph.add(Linea001C);
		paragraph.add(Linea002);
		return (paragraph);

	}

	private Paragraph IP_Parrafo002() {
		Paragraph paragraph = new Paragraph();

		this.defaultFont.setSize(this.objCte.FONT_SIZE_BASE);

		// Parrafo Segundo (Datos Personales) - Direccion -
		Phrase Linea003 = new Phrase(this.objPersona.GetLinea_003(), this.defaultFont);
		Phrase Linea003B = new Phrase(this.objPersona.GetLinea_003B(), this.defaultFont);
		Phrase Linea003C = new Phrase(this.objPersona.GetLinea_003C(), this.defaultFont);

		Linea003.add(this.sFinal);
		Linea003B.add(this.sFinal);

		paragraph.add(Linea003);
		paragraph.add(Linea003B);
		paragraph.add(Linea003C);
		return (paragraph);

	}

	private Paragraph IP_Parrafo003() {
		Paragraph paragraph = new Paragraph();

		Font font = null;

		font = createFont(new int[] { Font.BOLD });
		font.setColor(140, 0, 75);
		font.setSize(this.objCte.FONT_SIZE_BASE);

		this.defaultFont.setSize(this.objCte.FONT_SIZE_BASE);
		// Parrafo Tercero (Datos Personales) - Datos laborables -
		Phrase Linea_Blanco = new Phrase(this.GetLinea_Blanco(), this.defaultFont);
		Phrase Linea000 = new Phrase(this.objPersona.GetLinea_000C(), font);
		Phrase Linea004 = new Phrase(this.objPersona.GetLinea_004(), this.defaultFont);
		Phrase Linea005 = new Phrase(this.objPersona.GetLinea_005(), this.defaultFont);
		Phrase Linea006 = new Phrase(this.objPersona.GetLinea_006(), this.defaultFont);

		Linea_Blanco.add(this.sFinal);
		Linea000.add(this.sFinal);
		Linea004.add(this.sFinal);
		Linea005.add(this.sFinal);
		Linea006.add(this.sFinal);

		paragraph.add(Linea_Blanco);
		paragraph.add(Linea000);
		paragraph.add(Linea004);
		paragraph.add(Linea005);
		paragraph.add(Linea006);
		return (paragraph);
	}
}
