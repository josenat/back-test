package renfe.com.model.dto;

import java.sql.Date;

public class Tbasg266EstadoAcreDto {

	private Integer cdgoAcredita;
	private String cdgoEstado;
	private String desgUsuact;
	private Date fchaAct;
	private String fchaEstado;
	private String mrcaActivo;

	public Integer getCdgoAcredita() {
		return this.cdgoAcredita;
	}

	public void setCdgoAcredita(Integer cdgoAcredita) {
		this.cdgoAcredita = cdgoAcredita;
	}

	public String getCdgoEstado() {
		return this.cdgoEstado;
	}

	public void setCdgoEstado(String cdgoEstado) {
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