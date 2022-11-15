package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG153_TARJETA", schema = "PASG")
public class Tbasg153Tarjeta {

	@Id
	@Column(name = "CDGO_NUMSERIE")
	private Long cdgoNumserie;

	@NotNull
	@Column(name = "CDGO_PERSONA")
	private Integer cdgoPersona;

	@Column(name = "CDGO_RFID")
	private String cdgoRfid;

	@Column(name = "DESG_USUACT")
	private String desgUsuact;

	@Column(name = "FCHA_ACT")
	private Date fchaAct;

	@Column(name = "FCHA_EXPEDICION")
	private Date fchaExpedicion;

	@Column(name = "FCHA_EXPIRACION")
	private Date fchaExpiracion;

	@Column(name = "FCHA_LISTANEGRA")
	private String fchaListanegra;

	@Column(name = "MRCA_ACTIVO")
	private String mrcaActivo;

	@NotNull
	@Column(name = "MRCA_LISTANEGRA")
	private String mrcaListanegra;

	public Long getCdgoNumserie() {
		return this.cdgoNumserie;
	}

	public void setCdgoNumserie(Long cdgoNumserie) {
		this.cdgoNumserie = cdgoNumserie;
	}

	public Integer getCdgoPersona() {
		return this.cdgoPersona;
	}

	public String getCdgoRfid() {
		return this.cdgoRfid;
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

	public Date getFchaExpiracion() {
		return this.fchaExpiracion;
	}

	public String getFchaListanegra() {
		return this.fchaListanegra;
	}

	public String getMrcaActivo() {
		return this.mrcaActivo;
	}

	public String getMrcaListanegra() {
		return this.mrcaListanegra;
	}

	public void setCdgoPersona(Integer cdgoPersona) {
		this.cdgoPersona = cdgoPersona;
	}

	public void setCdgoRfid(String cdgoRfid) {
		this.cdgoRfid = cdgoRfid;
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

	public void setFchaExpiracion(Date fchaExpiracion) {
		this.fchaExpiracion = fchaExpiracion;
	}

	public void setFchaListanegra(String fchaListanegra) {
		this.fchaListanegra = fchaListanegra;
	}

	public void setMrcaActivo(String mrcaActivo) {
		this.mrcaActivo = mrcaActivo;
	}

	public void setMrcaListanegra(String mrcaListanegra) {
		this.mrcaListanegra = mrcaListanegra;
	}

}