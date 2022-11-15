package renfe.com.pdf.datamanager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import renfe.com.model.dto.Tbasg102TituloconDto;
import renfe.com.util.ImprimirCts;
import renfe.com.util.Util;

public class MITitulo {

	private static final Logger log = LoggerFactory.getLogger(MITitulo.class);

	private boolean Accion = false;
	private Tbasg102TituloconDto objTituloCon = null;

	private String sPre = "    ";

	private String Linea_000 = "";
	private String Linea_001 = "";

	public MITitulo(Tbasg102TituloconDto objTituloCon) {
		this.objTituloCon = objTituloCon;
		this.MIT_Init();
	}

	public String GetLinea_000() {
		return (this.Linea_000);
	}

	public String GetLinea_001() {
		return (this.Linea_001);
	}

	public boolean GetEstatus() {
		return (this.Accion);
	}

	private void SetLinea_000(String Texto) {
		this.Linea_000 = Texto;
	}

	private void SetLinea_001(String Texto) {
		this.Linea_001 = Texto;
	}

	protected void AddLinea_000(String Texto) {
		this.Linea_000 = this.Linea_000 + Texto;
	}

	protected void AddLinea_001(String Texto) {
		this.Linea_001 = this.Linea_001 + Texto;
	}

	private void MIT_Init() {
		ImprimirCts objCte = new ImprimirCts();

		if (this.objTituloCon != null)
			Accion = true;

		this.SetLinea_001(this.sPre);

		if (this.Accion) {
			int iB = objCte.PERSONA_MAX_TITULO - objCte.TITULOCON_LT_LI_001.length();
			String Texto = objCte.TITULOCON_LT_LI_001 + (new Util().getPuntos(iB));

			this.SetLinea_000(objCte.TITULOCON_LT_LI_000);

			Texto = Texto + "Tipo " + this.objTituloCon.getDesgTiptit().trim() + ", ";
			// IGC Rmdy 43521, Relacionado con 5511
			// Texto = Texto + "Otorgado el " +
			// TextFormat.format(this.objTituloCon.getFchaOtorgado(),"-") +
			// ", ";
			// Texto = Texto + "y Valido desde " +
			// TextFormat.format(this.objTituloCon.getFchaAct(),"-");
			Texto = Texto + objCte.TITULOCON_LT_LI_002 + TextFormat.format(this.objTituloCon.getFchaOtorgado(), "-");
			// IGC Rmdy 43521, Relacionado con 5511

			this.AddLinea_001(Texto);

		}
	}
}
