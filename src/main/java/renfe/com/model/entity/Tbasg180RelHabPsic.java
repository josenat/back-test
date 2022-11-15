package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TBASG180_REL_HAB_PSIC")
public class Tbasg180RelHabPsic {

	@EmbeddedId
	private Tbasg180RelHabPsicPK tbasg180relhabpsicpk;

	@Column(name = "DESG_USUACT")
	private String desgUsuact;

	@Column(name = "FCHA_ACT")
	private Date fchaAct;

	public Tbasg180RelHabPsicPK getTbasg180relhabpsicpk() {
		return this.tbasg180relhabpsicpk;
	}

	public void setTbasg180relhabpsicpk(Tbasg180RelHabPsicPK tbasg180relhabpsicpk) {
		this.tbasg180relhabpsicpk = tbasg180relhabpsicpk;
	}

	public String getDesgUsuact() {
		return this.desgUsuact;
	}

	public Date getFchaAct() {
		return this.fchaAct;
	}

	public void setDesgUsuact(String desgUsuact) {
		this.desgUsuact = desgUsuact;
	}

	public void setFchaAct(Date fchaAct) {
		this.fchaAct = fchaAct;
	}

}