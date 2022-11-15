package renfe.com.model.dto;

import java.sql.Date;

public class Tbasg126AlchabinfDto {

	private Integer cdgoAlchabinf;
	private Integer cdgoExpedient;
	private String desgUsuact;
	private Date fchaFecact;
	private String mrcaActivo;

	public Integer getCdgoAlchabinf() {
		return this.cdgoAlchabinf;
	}

	public void setCdgoAlchabinf(Integer cdgoAlchabinf) {
		this.cdgoAlchabinf = cdgoAlchabinf;
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

	public Date getFchaFecact() {
		return this.fchaFecact;
	}

	public void setFchaFecact(Date fchaFecact) {
		this.fchaFecact = fchaFecact;
	}

	public String getMrcaActivo() {
		return this.mrcaActivo;
	}

	public void setMrcaActivo(String mrcaActivo) {
		this.mrcaActivo = mrcaActivo;
	}

}