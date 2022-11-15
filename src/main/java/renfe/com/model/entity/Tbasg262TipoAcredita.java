package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG262_TIPO_ACREDITA", schema="PASG")
public class Tbasg262TipoAcredita {

	@Id
	@Column(name = "CDGO_TIPOACR")
	private String cdgoTipoacr;

	@NotNull
	@Column(name = "DESG_ACREDITA")
	private String desgAcredita;

	@NotNull
	@Column(name = "DESG_GRUPO")
	private String desgGrupo;

	@NotNull
	@Column(name = "DESG_USUACT")
	private String desgUsuact;

	@NotNull
	@Column(name = "FCHA_ACT")
	private Date fchaAct;

	@NotNull
	@Column(name = "MRCA_ACTIVO")
	private String mrcaActivo;
	
	@NotNull
	@Column(name = "VALIDEZ_RECICLAJE")
	private Integer validezReciclaje;

	public String getCdgoTipoacr() {
		return this.cdgoTipoacr;
	}

	public void setCdgoTipoacr(String cdgoTipoacr) {
		this.cdgoTipoacr = cdgoTipoacr;
	}

	public String getDesgAcredita() {
		return this.desgAcredita;
	}

	public String getDesgGrupo() {
		return this.desgGrupo;
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

	public void setDesgAcredita(String desgAcredita) {
		this.desgAcredita = desgAcredita;
	}

	public void setDesgGrupo(String desgGrupo) {
		this.desgGrupo = desgGrupo;
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

	public Integer getValidezReciclaje() {
		return validezReciclaje;
	}

	public void setValidezReciclaje(Integer validezReciclaje) {
		this.validezReciclaje = validezReciclaje;
	}

}