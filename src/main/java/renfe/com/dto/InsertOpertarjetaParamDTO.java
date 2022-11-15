package renfe.com.dto;

public class InsertOpertarjetaParamDTO {

	private String cdgoNumSerie;
	private String cdgoOperacion;
	private String desgUsuario;
	private String usuAct;
	private boolean activo;

	public String getCdgoNumSerie() {
		return cdgoNumSerie;
	}

	public void setCdgoNumSerie(String cdgoNumSerie) {
		this.cdgoNumSerie = cdgoNumSerie;
	}

	public String getCdgoOperacion() {
		return cdgoOperacion;
	}

	public void setCdgoOperacion(String cdgoOperacion) {
		this.cdgoOperacion = cdgoOperacion;
	}

	public String getDesgUsuario() {
		return desgUsuario;
	}

	public void setDesgUsuario(String desgUsuario) {
		this.desgUsuario = desgUsuario;
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
