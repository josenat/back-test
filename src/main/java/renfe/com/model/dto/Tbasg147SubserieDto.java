package renfe.com.model.dto;

import java.sql.Date;

public class Tbasg147SubserieDto {

	private String cdgoSerie;
	private String cdgoSubserie;
	private String desgUsuact;
	private Date fchaAct;
	private String mrcaActivo;

	public String getCdgoSerie() {
		return this.cdgoSerie;
	}

	public void setCdgoSerie(String cdgoSerie) {
		this.cdgoSerie = cdgoSerie;
	}

	public String getCdgoSubserie() {
		return this.cdgoSubserie;
	}

	public void setCdgoSubserie(String cdgoSubserie) {
		this.cdgoSubserie = cdgoSubserie;
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