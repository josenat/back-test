package renfe.com.pdf.core;

import java.util.List;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.HeaderFooter;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfWriter;

import renfe.com.model.dto.Tbasg260HabilifuncDto;
import renfe.com.pdf.data.GetExpedientes;
import renfe.com.pdf.data.GetFormacion;
import renfe.com.pdf.data.GetFormacionComplementaria;
import renfe.com.pdf.data.GetPersona;
import renfe.com.pdf.data.GetPsicofisico;
import renfe.com.pdf.data.GetTitulo;
import renfe.com.pdf.print.ImpExpedientes;
import renfe.com.pdf.print.ImpFormacion;
import renfe.com.pdf.print.ImpFormacionComplementaria;
import renfe.com.pdf.print.ImpPersona;
import renfe.com.pdf.print.ImpPsicofisico;
import renfe.com.pdf.print.ImpTitulo;
import renfe.com.service.Tbasg100PersonaService;
import renfe.com.util.ImprimirCts;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author IGC RNF09-00005511
 *
 *         TODO Para cambiar la plantilla de este comentario generado, vaya a
 *         Ventana - Preferencias - Java - Estilo de código - Plantillas de
 *         código
 */

@Service
@Configurable
public class DossierPersonalPdfWriter extends AsgPdfWriter {

	private static final Logger log = LoggerFactory.getLogger(DossierPersonalPdfWriter.class);

	private String imgPath = null;
	private ImprimirCts objCte = new ImprimirCts();

	private int pgCt = 0;
	private int lcCt = 0;

	private String sFinal = "\r\n";
	@Autowired
	private GetPersona objPersona;
	@Autowired
	GetPsicofisico psicofisicos;
	@Autowired
	GetExpedientes expedientes;
	@Autowired
	GetFormacion formacion;
	@Autowired
	GetFormacionComplementaria formacComplement;
	@Autowired
	GetTitulo titulo;
	private ImpPersona impPersona = null;
//
//	public DossierPersonalPdfWriter(String imgPath, Integer codPersona) {
//		super();
//		this.I_Init(imgPath, codPersona);
//	}
	

	public String GetLinea_Blanco() {
		return ("  ");
	}

	public void I_Init(String imgPath, Integer codPersona) {
		this.imgPath = imgPath;

		this.defaultFont = new Font();
		this.defaultFont.setFamily(this.objCte.DEFAULT_FONT_FAMILY);
		this.defaultFont.setSize(this.objCte.DEFAULT_FONT_SIZE);

		this.defaultAlignment = this.objCte.DEFAULT_ALIGNMENT;
		this.objPersona.GP_Init(codPersona);
		this.impPersona = new ImpPersona(this.objPersona, this.document, this.pdfWriter, this.defaultFont);

		this.pgCt = 1;
	}

	protected void writeDocument(Object object) throws DocumentException {
		// Pagina 001
		// Minimo
		this.I_Titulo();
		this.I_Base();
		this.I_Psicofisico();
		// Minimo
		this.I_TituloConduccion();
		this.I_Formacion();
		this.I_Expedientes();

		this.I_FormacComplement();
	}

	private void I_Titulo() throws DocumentException {
		// Titulo
		document.add(impPersona.Titulo(this.pgCt));
		this.pgCt = this.pgCt + 1;
	}

	private void I_Base() throws DocumentException {
		// Datos Personales
		document.add(impPersona.Parrafo001());
		document.add(impPersona.Parrafo002());
		document.add(impPersona.Parrafo003());

		this.lcCt = 14;
	}

	private void I_Psicofisico() throws DocumentException {
		int iOrden = 0;
		//GetPsicofisico psicofisicos = new GetPsicofisico(this.objPersona.getCdgoPersona());
		this.psicofisicos.setCdgoPersona(this.objPersona.getCdgoPersona());
		this.psicofisicos.GT_Init();
		ImpPsicofisico impPsicofisicos = new ImpPsicofisico(this.psicofisicos, this.document, this.pdfWriter,
				this.defaultFont);

		if (this.psicofisicos.GetEstatus() == true) {
			iOrden = this.psicofisicos.GetNumPsicofisicos();

			if (iOrden == 0) {
				document.add(impPsicofisicos.Parrafo001N());
				this.lcCt = this.lcCt + 3; // No hay Psicofisico
			} else if (iOrden == 1) {
				document.add(impPsicofisicos.Parrafo001());
				this.lcCt = this.lcCt + 6;
			} else {

				this.lcCt = this.lcCt + 1;

				for (int i = 0; i < iOrden; i++) {
					if (i == 0)
						this.I_ParrafoVacio(6, "");
					else
						this.I_ParrafoVacio(6, this.psicofisicos.GetLinea_000(i));
					document.add(impPsicofisicos.Parrafo001(i));
					this.lcCt = this.lcCt + 6;
				}
			}
		}
	}

	private void I_TituloConduccion() throws DocumentException {
		this.titulo.setCdgoPersona(this.objPersona.getCdgoPersona());
		this.titulo.GT_Init();
		ImpTitulo impTitulo = new ImpTitulo(this.titulo, this.document, this.pdfWriter, this.defaultFont);

		// Titulo de Conduccion
		if (this.titulo.GetEstatus() == true) {
			document.add(impTitulo.Parrafo001());
			this.lcCt = this.lcCt + 3;
		}

	}

	private void I_Formacion() throws DocumentException {
		int iOrden = 0;
		
		this.formacion.setCdgoPersona(this.objPersona.getCdgoPersona());
		this.formacion.GF_Init();
		
		ImpFormacion impFormacion = new ImpFormacion(this.formacion, this.document, this.pdfWriter, this.defaultFont);

		if (this.formacion.GetEstatus() == true) {

			iOrden = this.formacion.GetCursos();
			this.lcCt = this.lcCt + 1;

			for (int i = 0; i < iOrden; i++) {
				this.I_ParrafoVacio(5, this.formacion.GetLinea_000(i));
				document.add(impFormacion.Parrafo001(i));
				this.lcCt = this.lcCt + 5;
			}
		}
	}

	private void I_Expedientes() throws DocumentException {
		int iOrden = 0;
		
		this.expedientes.setCdgoPersona(this.objPersona.getCdgoPersona());
		this.expedientes.GF_Init();
		ImpExpedientes impExpedientes = new ImpExpedientes(this.expedientes, this.document, this.pdfWriter,
				this.defaultFont);

		if (this.expedientes.GetEstatus() == true) {

			iOrden = this.expedientes.GetNumExpedientes();
			this.lcCt = this.lcCt + 1;

			for (int i = 0; i < iOrden; i++) {
				if (i == 0)
					this.I_ParrafoVacio(6, "");
				else
					this.I_ParrafoVacio(6, this.expedientes.GetLinea_000(i));
				document.add(impExpedientes.Parrafo001(i));
				this.lcCt = this.lcCt + 6;
			}
		}
	}

	
	private void I_FormacComplement() throws DocumentException {
		int iOrden = 0;
		this.formacComplement.setCdgoPersona(this.objPersona.getCdgoPersona());
		this.formacComplement.GT_Init();
		ImpFormacionComplementaria impFormacComplement = new ImpFormacionComplementaria(this.formacComplement, this.document,
				this.pdfWriter, this.defaultFont);

		if (this.formacComplement.GetEstatus() == true) {
			iOrden = this.formacComplement.GetNumFormacComplement();

			if (iOrden == 0) {
				document.add(impFormacComplement.Parrafo001N());
				this.lcCt = this.lcCt + 1; // No hay Formación Complementaria
			} else if (iOrden == 1) {
				document.add(impFormacComplement.Parrafo001());
				this.lcCt = this.lcCt + 5;
			} else {

				this.lcCt = this.lcCt + 1;

				for (int i = 0; i < iOrden; i++) {
					if (i == 0)
						this.I_ParrafoVacio(5, "");
					else
						this.I_ParrafoVacio(5, this.formacComplement.GetLinea_000(i));
					document.add(impFormacComplement.Parrafo001(i));
					this.lcCt = this.lcCt + 5;
				}
			}
		}

	}

	private void I_ParrafoVacio(int lineas, String Linea) throws DocumentException {
		Paragraph paragraph = null;
		Font font = null;
		Phrase LineaST = null;

		if ((this.lcCt + lineas) <= this.objCte.MAX_LINEAS_PAG)
			return;

		font = createFont(new int[] { Font.BOLD });
		font.setColor(140, 0, 75);
		font.setSize(this.objCte.FONT_SIZE_BASE);

		paragraph = new Paragraph();
		Phrase Linea001 = new Phrase("\r\n", this.defaultFont);

		for (int i = this.lcCt; i <= this.objCte.MAX_LINEAS_PAG; i++)
			paragraph.add(Linea001);

		document.add(paragraph);
		this.I_Titulo();
		paragraph = new Paragraph();

		if (!Linea.equals(""))
			LineaST = new Phrase((Linea + "..."), font);
		else
			LineaST = new Phrase((Linea + "   "), font);
		paragraph.add(LineaST);

		document.add(paragraph);

		this.lcCt = 4;
	}

	protected void writeDocument(Object bean, ResourceBundle message) throws DocumentException {
		// TODO Apéndice de método generado automáticamente

	}

	@Override
	protected void writeDocument(Object bean, ResourceBundle message, String tipoHabi) throws DocumentException {
		// TODO Apéndice de método generado automáticamente

	}

	@Override
	protected void writeDocument(Object bean, ResourceBundle message, String tipoHabi,
			List<Tbasg260HabilifuncDto> listaFunciones) throws DocumentException {
		// TODO Auto-generated method stub
		
	}
}
