package renfe.com.model.dto;

import java.sql.Date;

public class Tbasg263TipoEstadoDto {

	private String cdgoEstado;
	private String desgEstado;
	private String desgUsuact;
	private Date fchaAct;
	private String mrcaActivo;

	public String getCdgoEstado() {
		return this.cdgoEstado;
	}

	public void setCdgoEstado(String cdgoEstado) {
		this.cdgoEstado = cdgoEstado;
	}

	public String getDesgEstado() {
		return this.desgEstado;
	}

	public void setDesgEstado(String desgEstado) {
		this.desgEstado = desgEstado;
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

	public String getMrcaActivo() {
		return this.mrcaActivo;
	}

	public void setMrcaActivo(String mrcaActivo) {
		this.mrcaActivo = mrcaActivo;
	}

}