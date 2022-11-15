package renfe.com.pdf.print;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfWriter;

import renfe.com.pdf.core.ImpPdfWriterAux;
import renfe.com.pdf.data.GetFormacionComplementaria;
import renfe.com.util.ImprimirCts;

public class ImpFormacionComplementaria extends ImpPdfWriterAux {

	private ImprimirCts objCte = new ImprimirCts();

	private GetFormacionComplementaria objFormacComplement = null;
	private String sFinal = "\r\n";

	public ImpFormacionComplementaria(GetFormacionComplementaria formacComplement, Document document,
			PdfWriter pdfWriter, Font defaultFont) {
		super(document, pdfWriter, defaultFont);
		this.objFormacComplement = formacComplement;
	}

	public Paragraph Parrafo001() {
		return (this.IPS_Parrafo001());
	}

	public Paragraph Parrafo001(int Orden) {
		return (this.IPS_Parrafo001(Orden));
	}

	public Paragraph Parrafo001N() {
		return (this.IPS_Parrafo001N());
	}

	private String GetLinea_Blanco() {
		return ("  ");
	}

	private Paragraph IPS_Parrafo001N() {
		Paragraph paragraph = new Paragraph();
		Font font = null;

		font = createFont(new int[] { Font.BOLD });
		font.setColor(140, 0, 75);
		font.setSize(this.objCte.FONT_SIZE_BASE);

		this.defaultFont.setSize(this.objCte.FONT_SIZE_BASE);

		Phrase LineaB = new Phrase(this.GetLinea_Blanco(), this.defaultFont);
		Phrase Linea000 = new Phrase(this.objFormacComplement.GetLinea_000(), font);
		Phrase Linea001 = new Phrase(this.objFormacComplement.GetLinea_001(), this.defaultFont);

		LineaB.add(this.sFinal);
		Linea000.add(this.sFinal);
		Linea001.add(this.sFinal);

		paragraph.add(LineaB);
		paragraph.add(Linea000);
		paragraph.add(Linea001);

		return (paragraph);
	}

	private Paragraph IPS_Parrafo001() {
		Paragraph paragraph = new Paragraph();
		Font font = null;

		font = createFont(new int[] { Font.BOLD });
		font.setColor(140, 0, 75);
		font.setSize(this.objCte.FONT_SIZE_BASE);

		this.defaultFont.setSize(this.objCte.FONT_SIZE_BASE);

		int Orden = 0;

		Phrase LineaB = new Phrase(this.GetLinea_Blanco(), this.defaultFont);
		Phrase Linea000 = new Phrase(this.objFormacComplement.GetLinea_000(Orden), font);
		Phrase Linea001 = new Phrase(this.objFormacComplement.GetLinea_001(Orden), this.defaultFont);
		Phrase Linea002 = new Phrase(this.objFormacComplement.GetLinea_002(Orden), this.defaultFont);
		Phrase Linea003 = new Phrase(this.objFormacComplement.GetLinea_003(Orden), this.defaultFont);
		Phrase Linea004 = new Phrase(this.objFormacComplement.GetLinea_004(Orden), this.defaultFont);

		LineaB.add(this.sFinal);
		Linea000.add(this.sFinal);
		Linea001.add(this.sFinal);
		Linea002.add(this.sFinal);
		Linea003.add(this.sFinal);
		Linea004.add(this.sFinal);

		paragraph.add(LineaB);
		paragraph.add(Linea000);
		paragraph.add(Linea001);
		paragraph.add(Linea002);
		paragraph.add(Linea003);
		paragraph.add(Linea004);

		return (paragraph);

	}

	private Paragraph IPS_Parrafo001(int Orden) {
		Paragraph paragraph = new Paragraph();
		Font font = null;

		font = createFont(new int[] { Font.BOLD });
		font.setColor(140, 0, 75);
		font.setSize(this.objCte.FONT_SIZE_BASE);

		this.defaultFont.setSize(this.objCte.FONT_SIZE_BASE);

		Phrase LineaB = new Phrase(this.GetLinea_Blanco(), this.defaultFont);
		Phrase Linea000 = null;
		if (Orden == 0) {
			Linea000 = new Phrase(this.objFormacComplement.GetLinea_000(Orden), font);
		}
		Phrase Linea001 = new Phrase(this.objFormacComplement.GetLinea_001(Orden), font);
		Phrase Linea002 = new Phrase(this.objFormacComplement.GetLinea_002(Orden), this.defaultFont);
		Phrase Linea003 = new Phrase(this.objFormacComplement.GetLinea_003(Orden), this.defaultFont);
		Phrase Linea004 = new Phrase(this.objFormacComplement.GetLinea_004(Orden), this.defaultFont);

		LineaB.add(this.sFinal);
		if (Orden == 0) {
			Linea000.add(this.sFinal);
		}
		Linea001.add(this.sFinal);
		Linea002.add(this.sFinal);
		Linea003.add(this.sFinal);
		Linea004.add(this.sFinal);

		paragraph.add(LineaB);
		if (Orden == 0) {
			paragraph.add(Linea000);
		}

		paragraph.add(Linea001);
		paragraph.add(Linea002);
		paragraph.add(Linea003);
		paragraph.add(Linea004);

		return (paragraph);

	}

}
