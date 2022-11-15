package renfe.com.pdf.beans;

public class CertificadoCompDossierPersonalBean {
	private String Linea_000 = "";
	private String Linea_001 = "";
	private String Linea_002 = "";
	private String Linea_003 = "";
	private String Linea_004 = "";

	public String getLinea_000() {
		return Linea_000;
	}

	public void setLinea_000(String linea_000) {
		Linea_000 = linea_000;
	}

	public String getLinea_001() {
		return Linea_001;
	}

	public void setLinea_001(String linea_001) {
		Linea_001 = linea_001;
	}

	public String getLinea_002() {
		return Linea_002;
	}

	public void setLinea_002(String linea_002) {
		Linea_002 = linea_002;
	}

	public String getLinea_003() {
		return Linea_003;
	}

	public void setLinea_003(String linea_003) {
		Linea_003 = linea_003;
	}

	public String getLinea_004() {
		return Linea_004;
	}

	public void setLinea_004(String linea_004) {
		Linea_004 = linea_004;
	}

	public void addLinea_000(String Texto) {
		this.Linea_000 = this.Linea_000 + Texto;
	}

	public void addLinea_001(String Texto) {
		this.Linea_001 = this.Linea_001 + Texto;
	}

	public void addLinea_002(String Texto) {
		this.Linea_002 = this.Linea_002 + Texto;
	}

	public void addLinea_003(String Texto) {
		this.Linea_003 = this.Linea_003 + Texto;
	}

	public void addLinea_004(String Texto) {
		this.Linea_004 = this.Linea_004 + Texto;
	}
}
