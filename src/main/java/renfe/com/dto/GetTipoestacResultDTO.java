package renfe.com.dto;

import java.sql.Date;

public class GetTipoestacResultDTO {

	private String cdgoEstado;
	private String desgEstado;
	private String usuAct;
	private Date fchaAct;
	private boolean activo;

	public String getCdgoEstado() {
		return cdgoEstado;
	}

	public void setCdgoEstado(String cdgoEstado) {
		this.cdgoEstado = cdgoEstado;
	}

	public String getDesgEstado() {
		return desgEstado;
	}

	public void setDesgEstado(String desgEstado) {
		this.desgEstado = desgEstado;
	}

	public String getUsuAct() {
		return usuAct;
	}

	public void setUsuAct(String usuAct) {
		this.usuAct = usuAct;
	}

	public Date getFchaAct() {
		return fchaAct;
	}

	public void setFchaAct(Date fchaAct) {
		this.fchaAct = fchaAct;
	}

	public boolean getActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

}
