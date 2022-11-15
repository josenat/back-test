package renfe.com.model.dto;

import java.sql.Date;

public class Tbasg119EstahabinDto {

	private Integer cdgoAlchabinf;
	private Integer cdgoEstado;
	private String desgUsuact;
	private Date fchaAct;
	private String fchaEstado;
	private String mrcaActivo;

	public Integer getCdgoAlchabinf() {
		return this.cdgoAlchabinf;
	}

	public void setCdgoAlchabinf(Integer cdgoAlchabinf) {
		this.cdgoAlchabinf = cdgoAlchabinf;
	}

	public Integer getCdgoEstado() {
		return this.cdgoEstado;
	}

	public void setCdgoEstado(Integer cdgoEstado) {
		this.cdgoEstado = cdgoEstado;
	}

	public String getDesgUsuact() {
		return this.desgUsuact;
	}

	public void setDesgUsuact(String desgUsuact) {
		this.desgUsuact = desgUsuact;
	}

	public Date getFchaAct() {
		return this.fchaAct;
	}

	public void setFchaAct(Date fchaAct) {
		this.fchaAct = fchaAct;
	}

	public String getFchaEstado() {
		return this.fchaEstado;
	}

	public void setFchaEstado(String fchaEstado) {
		this.fchaEstado = fchaEstado;
	}

	public String getMrcaActivo() {
		return this.mrcaActivo;
	}

	public void setMrcaActivo(String mrcaActivo) {
		this.mrcaActivo = mrcaActivo;
	}

}