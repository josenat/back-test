package renfe.com.dto;

import java.sql.Date;

public class GetRidResultDTO {

	private Integer cdgoExpedient;
	private Date fchaRid;
	private String usuAct;
	private Date fchaAct;

	public Integer getCdgoExpedient() {
		return cdgoExpedient;
	}

	public void setCdgoExpedient(Integer cdgoExpedient) {
		this.cdgoExpedient = cdgoExpedient;
	}

	public Date getFchaRid() {
		return fchaRid;
	}

	public void setFchaRid(Date fchaRid) {
		this.fchaRid = fchaRid;
	}

	public String getUsuAct() {
		return usuAct;
	}

	public void setUsuAct(String usuAct) {
		this.usuAct = usuAct;
	}

	public Date getFchaAct() {
		return fchaAct;
	}

	public void setFchaAct(Date fchaAct) {
		this.fchaAct = fchaAct;
	}

}
