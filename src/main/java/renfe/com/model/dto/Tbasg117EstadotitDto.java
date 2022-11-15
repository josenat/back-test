package renfe.com.model.dto;

import java.sql.Date;

public class Tbasg117EstadotitDto {

	private Integer cdgoEstado;
	private Integer cdgoTit;
	private String desgUsuact;
	private Date fchaAct;
	private String fchaEstado;
	private String mrcaActivo;

	public Integer getCdgoEstado() {
		return this.cdgoEstado;
	}

	public void setCdgoEstado(Integer cdgoEstado) {
		this.cdgoEstado = cdgoEstado;
	}

	public Integer getCdgoTit() {
		return this.cdgoTit;
	}

	public void setCdgoTit(Integer cdgoTit) {
		this.cdgoTit = cdgoTit;
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