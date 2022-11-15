package renfe.com.dto;

import java.sql.Date;

public class UpdateRidParamDTO {

	private Date fchaRid;
	private String usuAct;
	private Integer cdgoExpedient;

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

	public Integer getCdgoExpedient() {
		return cdgoExpedient;
	}

	public void setCdgoExpedient(Integer cdgoExpedient) {
		this.cdgoExpedient = cdgoExpedient;
	}

}
