package renfe.com.model.dto;

import java.sql.Date;

public class Tbasg153TarjetaDto {

	private String cdgoNumserie;
	private Integer cdgoPersona;
	private String cdgoRfid;
	private String desgUsuact;
	private Date fchaAct;
	private Date fchaExpedicion;
	private Date fchaExpiracion;
	private String fchaListanegra;
	private String mrcaActivo;
	private String mrcaListanegra;

	public String getCdgoNumserie() {
		return this.cdgoNumserie;
	}

	public void setCdgoNumserie(String cdgoNumserie) {
		this.cdgoNumserie = cdgoNumserie;
	}

	public Integer getCdgoPersona() {
		return this.cdgoPersona;
	}

	public void setCdgoPersona(Integer cdgoPersona) {
		this.cdgoPersona = cdgoPersona;
	}

	public String getCdgoRfid() {
		return this.cdgoRfid;
	}

	public void setCdgoRfid(String cdgoRfid) {
		this.cdgoRfid = cdgoRfid;
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

	public Date getFchaExpedicion() {
		return this.fchaExpedicion;
	}

	public void setFchaExpedicion(Date fchaExpedicion) {
		this.fchaExpedicion = fchaExpedicion;
	}

	public Date getFchaExpiracion() {
		return this.fchaExpiracion;
	}

	public void setFchaExpiracion(Date fchaExpiracion) {
		this.fchaExpiracion = fchaExpiracion;
	}

	public String getFchaListanegra() {
		return this.fchaListanegra;
	}

	public void setFchaListanegra(String fchaListanegra) {
		this.fchaListanegra = fchaListanegra;
	}

	public String getMrcaActivo() {
		return this.mrcaActivo;
	}

	public void setMrcaActivo(String mrcaActivo) {
		this.mrcaActivo = mrcaActivo;
	}

	public String getMrcaListanegra() {
		return this.mrcaListanegra;
	}

	public void setMrcaListanegra(String mrcaListanegra) {
		this.mrcaListanegra = mrcaListanegra;
	}

}