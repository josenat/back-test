package renfe.com.model.dto;

import java.sql.Date;

public class Tbasg256AlcovmDto {

	private Integer cdgoAlcovm;
	private String desgNombre;
	private String desgUsuact;
	private Date fchaAct;
	private String mrcaActivo;

	public Integer getCdgoAlcovm() {
		return this.cdgoAlcovm;
	}

	public void setCdgoAlcovm(Integer cdgoAlcovm) {
		this.cdgoAlcovm = cdgoAlcovm;
	}

	public String getDesgNombre() {
		return this.desgNombre;
	}

	public void setDesgNombre(String desgNombre) {
		this.desgNombre = desgNombre;
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