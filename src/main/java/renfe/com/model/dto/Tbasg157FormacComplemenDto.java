package renfe.com.model.dto;

import java.sql.Date;

public class Tbasg157FormacComplemenDto {

	private Integer cdgoCategoria;
	private Integer cdgoCualificacion;
	private Integer cdgoPersona;
	private String desgObservaciones;
	private String desgUsuact;
	private Date fchaAct;
	private Date fchaExpedicion;
	private String mrcaActivo;

	public Integer getCdgoCategoria() {
		return this.cdgoCategoria;
	}

	public void setCdgoCategoria(Integer cdgoCategoria) {
		this.cdgoCategoria = cdgoCategoria;
	}

	public Integer getCdgoCualificacion() {
		return this.cdgoCualificacion;
	}

	public void setCdgoCualificacion(Integer cdgoCualificacion) {
		this.cdgoCualificacion = cdgoCualificacion;
	}

	public Integer getCdgoPersona() {
		return this.cdgoPersona;
	}

	public void setCdgoPersona(Integer cdgoPersona) {
		this.cdgoPersona = cdgoPersona;
	}

	public String getDesgObservaciones() {
		return this.desgObservaciones;
	}

	public void setDesgObservaciones(String desgObservaciones) {
		this.desgObservaciones = desgObservaciones;
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

	public String getMrcaActivo() {
		return this.mrcaActivo;
	}

	public void setMrcaActivo(String mrcaActivo) {
		this.mrcaActivo = mrcaActivo;
	}

}