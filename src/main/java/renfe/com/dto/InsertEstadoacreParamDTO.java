package renfe.com.dto;

public class InsertEstadoacreParamDTO {

	private int cdgoAcredita;
	private String cdgoEstado;
	private String usuAct;
	private boolean activo;

	public int getCdgoAcredita() {
		return cdgoAcredita;
	}

	public void setCdgoAcredita(int cdgoAcredita) {
		this.cdgoAcredita = cdgoAcredita;
	}

	public String getCdgoEstado() {
		return cdgoEstado;
	}

	public void setCdgoEstado(String cdgoEstado) {
		this.cdgoEstado = cdgoEstado;
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
