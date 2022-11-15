package renfe.com.model.dto;

import java.sql.Date;

public class Tbasg118EstadoexpDto {

	private Integer cdgoEstado;
	private Integer cdgoExpedient;
	private String desgUsuact;
	private Date fchaAct;
	private Date fchaEstado;
	private String mrcaActivo;

	public Integer getCdgoEstado() {
		return this.cdgoEstado;
	}

	public void setCdgoEstado(Integer cdgoEstado) {
		this.cdgoEstado = cdgoEstado;
	}

	public Integer getCdgoExpedient() {
		return this.cdgoExpedient;
	}

	public void setCdgoExpedient(Integer cdgoExpedient) {
		this.cdgoExpedient = cdgoExpedient;
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

	public Date getFchaEstado() {
		return this.fchaEstado;
	}

	public void setFchaEstado(Date fchaEstado) {
		this.fchaEstado = fchaEstado;
	}

	public String getMrcaActivo() {
		return this.mrcaActivo;
	}

	public void setMrcaActivo(String mrcaActivo) {
		this.mrcaActivo = mrcaActivo;
	}

}