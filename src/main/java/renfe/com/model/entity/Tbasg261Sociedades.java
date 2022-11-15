package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG261_SOCIEDADES", schema = "PASG")
public class Tbasg261Sociedades {

	@Id
	@Column(name = "CDGO_SOCIEDAD")
	private String cdgoSociedad;

	@NotNull
	@Column(name = "DESC_SOCIEDAD")
	private String descSociedad;

	@NotNull
	@Column(name = "DESG_USUACT")
	private String desgUsuact;

	@NotNull
	@Column(name = "FCHA_ACT")
	private Date fchaAct;

	@NotNull
	@Column(name = "MRCA_ACTIVO")
	private char mrcaActivo;

	public String getCdgoSociedad() {
		return this.cdgoSociedad;
	}

	public void setCdgoSociedad(String object) {
		this.cdgoSociedad = object;
	}

	public String getDescSociedad() {
		return this.descSociedad;
	}

	public String getDesgUsuact() {
		return this.desgUsuact;
	}

	public Date getFchaAct() {
		return this.fchaAct;
	}

	public char getMrcaActivo() {
		return this.mrcaActivo;
	}

	public void setDescSociedad(String descSociedad) {
		this.descSociedad = descSociedad;
	}

	public void setDesgUsuact(String desgUsuact) {
		this.desgUsuact = desgUsuact;
	}

	public void setFchaAct(Date fchaAct) {
		this.fchaAct = fchaAct;
	}

	public void setMrcaActivo(char object) {
		this.mrcaActivo = object;
	}

}