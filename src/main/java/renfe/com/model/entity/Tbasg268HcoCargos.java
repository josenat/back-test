package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG268_HCO_CARGOS", schema = "PASG")
public class Tbasg268HcoCargos{

	@EmbeddedId
	private Tbasg268HcoCargosPK tbasg268HcoCargosPK;

	@NotNull
	@Column(name = "CDGO_CARGO")
	private String cdgoCargo;

	

	@Column(name = "FCHA_FIN")
	private Date fchaFin;
	
	@NotNull
	@Column(name = "DESG_USUACT")
	private String desgUsuact;
	
	@NotNull
	@Column(name = "FCHA_ACT")
	private Date fchaAct;
	


	public String getCdgoCargo() {
		return this.cdgoCargo;
	}

	public String getDesgUsuact() {
		return this.desgUsuact;
	}

	public Date getFchaAct() {
		return this.fchaAct;
	}

	public Date getFchaFin() {
		return this.fchaFin;
	}
	
	public Tbasg268HcoCargosPK getTbasg268HcoCargosPK() {
		return tbasg268HcoCargosPK;
	}

	public void setCdgoCargo(String cdgoCargo) {
		this.cdgoCargo = cdgoCargo;
	}

	public void setDesgUsuact(String desgUsuact) {
		this.desgUsuact = desgUsuact;
	}

	public void setFchaAct(Date fchaAct) {
		this.fchaAct = fchaAct;
	}

	public void setFchaFin(Date fchaFin) {
		this.fchaFin = fchaFin;
	}


	public void setTbasg268HcoCargosPK(Tbasg268HcoCargosPK tbasg268HcoCargosPK) {
		this.tbasg268HcoCargosPK = tbasg268HcoCargosPK;
	}

	

}