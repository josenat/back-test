package renfe.com.model.dto;

import java.sql.Date;

public class Tbasg164ActTarjetaDto {

	private String cdgoNumserie;
	private String desgUsuact;
	private Date fchaAct;

	public String getCdgoNumserie() {
		return this.cdgoNumserie;
	}

	public void setCdgoNumserie(String cdgoNumserie) {
		this.cdgoNumserie = cdgoNumserie;
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

}