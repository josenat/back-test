package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG135_CARGO", schema = "PASG")
public class Tbasg135Cargo {

	@Id
	@Column(name = "CDGO_CARGO")
	private String cdgoCargo;

	@NotNull
	@Column(name = "DESG_NOMBRE")
	private String desgNombre;

	@Column(name = "DESG_USUACT")
	private String desgUsuact;

	@Column(name = "FCHA_ACT")
	private Date fchaAct;

	@Column(name = "MRCA_ACTIVO")
	private String mrcaActivo;

	public String getCdgoCargo() {
		return this.cdgoCargo;
	}

	public void setCdgoCargo(String cdgoCargo) {
		this.cdgoCargo = cdgoCargo;
	}

	public String getDesgNombre() {
		return this.desgNombre;
	}

	public String getDesgUsuact() {
		return this.desgUsuact;
	}

	public Date getFchaAct() {
		return this.fchaAct;
	}

	public String getMrcaActivo() {
		return this.mrcaActivo;
	}

	public void setDesgNombre(String desgNombre) {
		this.desgNombre = desgNombre;
	}

	public void setDesgUsuact(String desgUsuact) {
		this.desgUsuact = desgUsuact;
	}

	public void setFchaAct(Date fchaAct) {
		this.fchaAct = fchaAct;
	}

	public void setMrcaActivo(String mrcaActivo) {
		this.mrcaActivo = mrcaActivo;
	}

}