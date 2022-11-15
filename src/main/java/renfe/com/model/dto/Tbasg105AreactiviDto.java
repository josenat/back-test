package renfe.com.model.dto;

import java.sql.Date;

public class Tbasg105AreactiviDto {

	private Integer cdgoAreact;
	private String cdgoSociedad;
	private String desgNombre;
	private String desgUsuact;
	private Date fchaAct;
	private String mrcaActivo;

	public Integer getCdgoAreact() {
		return this.cdgoAreact;
	}

	public void setCdgoAreact(Integer cdgoAreact) {
		this.cdgoAreact = cdgoAreact;
	}

	public String getCdgoSociedad() {
		return this.cdgoSociedad;
	}

	public void setCdgoSociedad(String cdgoSociedad) {
		this.cdgoSociedad = cdgoSociedad;
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