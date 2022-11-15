package renfe.com.dto;

import java.sql.Date;

public class InsertEstadotitParamDTO {

	private Integer cdgoTit;
	private Integer cdgoEstado;
	private Date fchaEstado;
	private String usuAct;
	private boolean activo;

	public Integer getCdgoTit() {
		return cdgoTit;
	}

	public void setCdgoTit(Integer cdgoTit) {
		this.cdgoTit = cdgoTit;
	}

	public Integer getCdgoEstado() {
		return cdgoEstado;
	}

	public void setCdgoEstado(Integer cdgoEstado) {
		this.cdgoEstado = cdgoEstado;
	}

	public Date getFchaEstado() {
		return fchaEstado;
	}

	public void setFchaEstado(Date fchaEstado) {
		this.fchaEstado = fchaEstado;
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
