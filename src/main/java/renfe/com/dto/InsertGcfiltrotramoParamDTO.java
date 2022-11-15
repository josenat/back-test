package renfe.com.dto;

public class InsertGcfiltrotramoParamDTO {

	private int cdgoFiltro;
	private String cdgoLinea;
	private String cdgoOrigen;
	private String cdgoDestino;
	private String usuAct;

	public int getCdgoFiltro() {
		return cdgoFiltro;
	}

	public void setCdgoFiltro(int cdgoFiltro) {
		this.cdgoFiltro = cdgoFiltro;
	}

	public String getCdgoLinea() {
		return cdgoLinea;
	}

	public void setCdgoLinea(String cdgoLinea) {
		this.cdgoLinea = cdgoLinea;
	}

	public String getCdgoOrigen() {
		return cdgoOrigen;
	}

	public void setCdgoOrigen(String cdgoOrigen) {
		this.cdgoOrigen = cdgoOrigen;
	}

	public String getCdgoDestino() {
		return cdgoDestino;
	}

	public void setCdgoDestino(String cdgoDestino) {
		this.cdgoDestino = cdgoDestino;
	}

	public String getUsuAct() {
		return usuAct;
	}

	public void setUsuAct(String usuAct) {
		this.usuAct = usuAct;
	}

}
