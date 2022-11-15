package renfe.com.pdf.print;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfWriter;

import renfe.com.pdf.core.ImpPdfWriterAux;
import renfe.com.pdf.data.GetExpedientes;
import renfe.com.util.ImprimirCts;

public class ImpExpedientes extends ImpPdfWriterAux {

	private ImprimirCts objCte = new ImprimirCts();

	private GetExpedientes objExpedientes = null;
	private String sFinal = "\r\n";

	public ImpExpedientes(GetExpedientes expedientes, Document document, PdfWriter pdfWriter, Font defaultFont) {
		super(document, pdfWriter, defaultFont);
		this.objExpedientes = expedientes;
	}

	public Paragraph Parrafo001(int Orden) {
		return (this.IE_Parrafo001(Orden));
	}

	private String GetLinea_Blanco() {
		return ("  ");
	}

	private Paragraph IE_Parrafo001(int Orden) {
		Paragraph paragraph = new Paragraph();
		Font font = null;

		font = createFont(new int[] { Font.BOLD });
		font.setColor(140, 0, 75);
		font.setSize(this.objCte.FONT_SIZE_BASE);

		this.defaultFont.setSize(this.objCte.FONT_SIZE_BASE);

		// Si no hay formacion no se pinta

		if (this.objExpedientes.GetEstatus() == true) {
			Phrase Linea000A = null;
			if (Orden == 0)
				Linea000A = new Phrase(this.objExpedientes.GetLinea_000(Orden), font);
			Phrase Linea000 = new Phrase(this.GetLinea_Blanco(), this.defaultFont);
			Phrase Linea001 = new Phrase(this.objExpedientes.GetLinea_001(Orden), font);
			Phrase Linea002 = new Phrase(this.objExpedientes.GetLinea_002(Orden), this.defaultFont);
			Phrase Linea003 = new Phrase(this.objExpedientes.GetLinea_003(Orden), this.defaultFont);
			Phrase Linea004 = new Phrase(this.objExpedientes.GetLinea_004(Orden), this.defaultFont);
			Phrase Linea005 = new Phrase(this.objExpedientes.GetLinea_005(Orden), this.defaultFont);
			Phrase Linea006 = new Phrase(this.objExpedientes.GetLinea_006(Orden), this.defaultFont);
			Phrase Linea007 = new Phrase(this.objExpedientes.GetLinea_007(Orden), this.defaultFont);
			Phrase Linea008 = new Phrase(this.objExpedientes.GetLinea_008(Orden), this.defaultFont);
			Phrase Linea009 = new Phrase(this.objExpedientes.GetLinea_009(Orden), this.defaultFont);
			Phrase Linea010 = new Phrase(this.objExpedientes.GetLinea_010(Orden), this.defaultFont);

			Linea000.add(this.sFinal);
			if (Orden == 0)
				Linea000A.add(this.sFinal);
			Linea001.add(this.sFinal);
			Linea002.add(this.sFinal);
			Linea003.add(this.sFinal);
			Linea004.add(this.sFinal);
			Linea005.add(this.sFinal);
			Linea006.add(this.sFinal);
			Linea007.add(this.sFinal);
			Linea008.add(this.sFinal);
			Linea009.add(this.sFinal);
			Linea010.add(this.sFinal);

			paragraph.add(Linea000);
			if (Orden == 0)
				paragraph.add(Linea000A);
			paragraph.add(Linea001);
			paragraph.add(Linea002);
			paragraph.add(Linea003);
			paragraph.add(Linea004);
			paragraph.add(Linea005);
			paragraph.add(Linea006);
			paragraph.add(Linea007);
			paragraph.add(Linea008);
			paragraph.add(Linea009);
			paragraph.add(Linea010);
		}

		return (paragraph);

	}
}
