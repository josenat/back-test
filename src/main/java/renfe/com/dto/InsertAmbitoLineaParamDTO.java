package renfe.com.dto;

public class InsertAmbitoLineaParamDTO {

	private String cdgoLinea;
	private String desgLinea;
	private String usuAct;
	private boolean activo;

	public String getCdgoLinea() {
		return cdgoLinea;
	}

	public void setCdgoLinea(String cdgoLinea) {
		this.cdgoLinea = cdgoLinea;
	}

	public String getDesgLinea() {
		return desgLinea;
	}

	public void setDesgLinea(String desgLinea) {
		this.desgLinea = desgLinea;
	}

	public String getUsuAct() {
		return usuAct;
	}

	public void setUsuAct(String usuAct) {
		this.usuAct = usuAct;
	}

	public boolean getActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

}
