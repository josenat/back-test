package renfe.com.dto;

public class InsertEstadoAcreditacionParamDTO {

	private int cdgoAcreditacion;
	private String estado;
	private String usuAct;
	private boolean activo;

	public int getCdgoAcreditacion() {
		return cdgoAcreditacion;
	}

	public void setCdgoAcreditacion(int cdgoAcreditacion) {
		this.cdgoAcreditacion = cdgoAcreditacion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
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
