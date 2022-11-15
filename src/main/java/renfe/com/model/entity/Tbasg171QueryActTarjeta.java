package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBASG171_QUERY_ACT_TARJETA")
public class Tbasg171QueryActTarjeta {

	@Id
	@Column(name = "CDGO_PERSONA")
	private Long cdgoPersona;

	@Column(name = "DESG_USUACT")
	private String desgUsuact;

	@Column(name = "FCHA_ACT")
	private Date fchaAct;

	public Long getCdgoPersona() {
		return this.cdgoPersona;
	}

	public void setCdgoPersona(Long cdgoPersona) {
		this.cdgoPersona = cdgoPersona;
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