package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBASG164_ACT_TARJETA")
public class Tbasg164ActTarjeta {

	@Id
	@Column(name = "CDGO_NUMSERIE")
	private Long cdgoNumserie;

	@Column(name = "DESG_USUACT")
	private String desgUsuact;

	@Column(name = "FCHA_ACT")
	private Date fchaAct;

	public Long getCdgoNumserie() {
		return this.cdgoNumserie;
	}

	public void setCdgoNumserie(Long cdgoNumserie) {
		this.cdgoNumserie = cdgoNumserie;
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