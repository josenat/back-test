package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG151_RID")
public class Tbasg151Rid {

	@Id
	@Column(name = "CDGO_EXPEDIENT")
	private Long cdgoExpedient;

	@Column(name = "DESG_USUACT")
	private String desgUsuact;

	@Column(name = "FCHA_ACT")
	private Date fchaAct;

	@NotNull
	@Column(name = "FCHA_RID")
	private Date fchaRid;

	public Long getCdgoExpedient() {
		return this.cdgoExpedient;
	}

	public void setCdgoExpedient(Long cdgoExpedient) {
		this.cdgoExpedient = cdgoExpedient;
	}

	public String getDesgUsuact() {
		return this.desgUsuact;
	}

	public Date getFchaAct() {
		return this.fchaAct;
	}

	public Date getFchaRid() {
		return this.fchaRid;
	}

	public void setDesgUsuact(String desgUsuact) {
		this.desgUsuact = desgUsuact;
	}

	public void setFchaAct(Date fchaAct) {
		this.fchaAct = fchaAct;
	}

	public void setFchaRid(Date fchaRid) {
		this.fchaRid = fchaRid;
	}

}