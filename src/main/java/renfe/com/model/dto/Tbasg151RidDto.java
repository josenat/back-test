package renfe.com.model.dto;

import java.sql.Date;

public class Tbasg151RidDto {

	private Integer cdgoExpedient;
	private String desgUsuact;
	private Date fchaAct;
	private Date fchaRid;

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

	public Date getFchaAct() {
		return this.fchaAct;
	}

	public void setFchaAct(Date fchaAct) {
		this.fchaAct = fchaAct;
	}

	public Date getFchaRid() {
		return this.fchaRid;
	}

	public void setFchaRid(Date fchaRid) {
		this.fchaRid = fchaRid;
	}

}