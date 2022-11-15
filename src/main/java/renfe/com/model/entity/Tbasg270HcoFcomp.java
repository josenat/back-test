package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TBASG270_HCO_FCOMP")
public class Tbasg270HcoFcomp {

	@EmbeddedId
	private Tbasg270HcoFcompPK tbasg270hcofcomppk;

	@Column(name = "DESG_OBSERVACIONES")
	private String desgObservaciones;

	@Column(name = "DESG_USUACT")
	private String desgUsuact;

	@Column(name = "FCHA_ACT")
	private Date fchaAct;

	@Column(name = "FCHA_EXPEDICION")
	private Date fchaExpedicion;

	public Tbasg270HcoFcompPK getTbasg270hcofcomppk() {
		return this.tbasg270hcofcomppk;
	}

	public void setTbasg270hcofcomppk(Tbasg270HcoFcompPK tbasg270hcofcomppk) {
		this.tbasg270hcofcomppk = tbasg270hcofcomppk;
	}

	public String getDesgObservaciones() {
		return this.desgObservaciones;
	}

	public String getDesgUsuact() {
		return this.desgUsuact;
	}

	public Date getFchaAct() {
		return this.fchaAct;
	}

	public Date getFchaExpedicion() {
		return this.fchaExpedicion;
	}

	public void setDesgObservaciones(String desgObservaciones) {
		this.desgObservaciones = desgObservaciones;
	}

	public void setDesgUsuact(String desgUsuact) {
		this.desgUsuact = desgUsuact;
	}

	public void setFchaAct(Date fchaAct) {
		this.fchaAct = fchaAct;
	}

	public void setFchaExpedicion(Date fchaExpedicion) {
		this.fchaExpedicion = fchaExpedicion;
	}

}