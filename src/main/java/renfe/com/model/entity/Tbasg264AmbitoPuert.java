package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG264_AMBITO_PUERT", schema = "PASG")
public class Tbasg264AmbitoPuert {

	@Id
	@Column(name = "CDGO_PUERTO")
	private String cdgoPuerto;

	@NotNull
	@Column(name = "DESG_PUERTO")
	private String desgPuerto;

	@NotNull
	@Column(name = "DESG_USUACT")
	private String desgUsuact;

	@NotNull
	@Column(name = "FCHA_ACT")
	private Date fchaAct;

	@NotNull
	@Column(name = "MRCA_ACTIVO")
	private String mrcaActivo;

	public String getCdgoPuerto() {
		return this.cdgoPuerto;
	}

	public void setCdgoPuerto(String cdgoPuerto) {
		this.cdgoPuerto = cdgoPuerto;
	}

	public String getDesgPuerto() {
		return this.desgPuerto;
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

	public void setDesgPuerto(String desgPuerto) {
		this.desgPuerto = desgPuerto;
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