package renfe.com.dto;

public class UpdateEstadoAcreditacionParamMantenimientoDTO {

	private String cdgoEstado;
	private boolean activo;
	private String usuAct;
	private int cdgoAcredita;

	public String getCdgoEstado() {
		return cdgoEstado;
	}

	public void setCdgoEstado(String cdgoEstado) {
		this.cdgoEstado = cdgoEstado;
	}

	public boolean getActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public String getUsuAct() {
		return usuAct;
	}

	public void setUsuAct(String usuAct) {
		this.usuAct = usuAct;
	}

	public int getCdgoAcredita() {
		return cdgoAcredita;
	}

	public void setCdgoAcredita(int cdgoAcredita) {
		this.cdgoAcredita = cdgoAcredita;
	}

}
