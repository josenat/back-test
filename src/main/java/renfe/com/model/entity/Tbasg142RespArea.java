package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG142_RESP_AREA", schema = "PASG")
public class Tbasg142RespArea {

	@Id
	@Column(name = "CDGO_AREACT")
	private Long cdgoAreact;

	@NotNull
	@Column(name = "DESG_CARGO")
	private String desgCargo;

	@NotNull
	@Column(name = "DESG_RESPONSABLE")
	private String desgResponsable;

	@Column(name = "DESG_USUACT")
	private String desgUsuact;

	@Column(name = "FCHA_ACT")
	private Date fchaAct;

	public Long getCdgoAreact() {
		return this.cdgoAreact;
	}

	public void setCdgoAreact(Long cdgoAreact) {
		this.cdgoAreact = cdgoAreact;
	}

	public String getDesgCargo() {
		return this.desgCargo;
	}

	public String getDesgResponsable() {
		return this.desgResponsable;
	}

	public String getDesgUsuact() {
		return this.desgUsuact;
	}

	public Date getFchaAct() {
		return this.fchaAct;
	}

	public void setDesgCargo(String desgCargo) {
		this.desgCargo = desgCargo;
	}

	public void setDesgResponsable(String desgResponsable) {
		this.desgResponsable = desgResponsable;
	}

	public void setDesgUsuact(String desgUsuact) {
		this.desgUsuact = desgUsuact;
	}

	public void setFchaAct(Date fchaAct) {
		this.fchaAct = fchaAct;
	}

}