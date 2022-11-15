package renfe.com.dto;

public class InsertEstahabinParamDTO {

	private Integer cdgoAlcHabInf;
	private Integer cdgoEstado;
	private String usuAct;
	private boolean activo;

	public Integer getCdgoAlcHabInf() {
		return cdgoAlcHabInf;
	}

	public void setCdgoAlcHabInf(Integer cdgoAlcHabInf) {
		this.cdgoAlcHabInf = cdgoAlcHabInf;
	}

	public Integer getCdgoEstado() {
		return cdgoEstado;
	}

	public void setCdgoEstado(Integer cdgoEstado) {
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
