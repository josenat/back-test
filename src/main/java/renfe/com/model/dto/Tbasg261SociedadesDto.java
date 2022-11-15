package renfe.com.model.dto;

import java.sql.Date;

public class Tbasg261SociedadesDto {

	private String cdgoSociedad;
	private String descSociedad;
	private String desgUsuact;
	private Date fchaAct;
	private String mrcaActivo;

	public String getCdgoSociedad() {
		return this.cdgoSociedad;
	}

	public void setCdgoSociedad(String cdgoSociedad) {
		this.cdgoSociedad = cdgoSociedad;
	}

	public String getDescSociedad() {
		return this.descSociedad;
	}

	public void setDescSociedad(String descSociedad) {
		this.descSociedad = descSociedad;
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