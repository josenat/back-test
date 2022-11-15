package renfe.com.model.dto;

import java.sql.Date;

public class Tbasg141AreterDto {

	private Integer cdgoAreact;
	private Integer cdgoAreter;
	private String desgNombre;
	private String desgUsuact;
	private Date fchaAct;
	private char mrcaActivo;

	public Integer getCdgoAreact() {
		return this.cdgoAreact;
	}

	public void setCdgoAreact(Integer cdgoAreact) {
		this.cdgoAreact = cdgoAreact;
	}

	public Integer getCdgoAreter() {
		return this.cdgoAreter;
	}

	public void setCdgoAreter(Integer cdgoAreter) {
		this.cdgoAreter = cdgoAreter;
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

	public char getMrcaActivo() {
		return this.mrcaActivo;
	}

	public void setMrcaActivo(char mrcaActivo) {
		this.mrcaActivo = mrcaActivo;
	}

}