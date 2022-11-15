package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TBASG157_FORMAC_COMPLEMEN")
public class Tbasg157FormacComplemen {

	@EmbeddedId
	private Tbasg157FormacComplemenPK tbasg157formaccomplemenpk;

	@Column(name = "DESG_OBSERVACIONES")
	private String desgObservaciones;

	@Column(name = "DESG_USUACT")
	private String desgUsuact;

	@Column(name = "FCHA_ACT")
	private Date fchaAct;

	@Column(name = "FCHA_EXPEDICION")
	private Date fchaExpedicion;

	@Column(name = "MRCA_ACTIVO")
	private String mrcaActivo;

	public Tbasg157FormacComplemenPK getTbasg157formaccomplemenpk() {
		return this.tbasg157formaccomplemenpk;
	}

	public void setTbasg157formaccomplemenpk(Tbasg157FormacComplemenPK tbasg157formaccomplemenpk) {
		this.tbasg157formaccomplemenpk = tbasg157formaccomplemenpk;
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

	public String getMrcaActivo() {
		return this.mrcaActivo;
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

	public void setMrcaActivo(String mrcaActivo) {
		this.mrcaActivo = mrcaActivo;
	}

}