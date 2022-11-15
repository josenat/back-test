package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG107_TIPOVIA", schema = "PASG")
public class Tbasg107Tipovia {

	@Id
	@Column(name = "CDGO_TIPOVIA")
	private Long cdgoTipovia;

	@NotNull
	@Column(name = "CDGO_SAP")
	private String cdgoSap;

	@NotNull
	@Column(name = "DESG_NOMBRE")
	private String desgNombre;

	@Column(name = "DESG_USUACT")
	private String desgUsuact;

	@Column(name = "FCHA_ACT")
	private Date fchaAct;

	@Column(name = "MRCA_ACTIVO")
	private String mrcaActivo;

	public Long getCdgoTipovia() {
		return this.cdgoTipovia;
	}

	public void setCdgoTipovia(Long cdgoTipovia) {
		this.cdgoTipovia = cdgoTipovia;
	}

	public String getCdgoSap() {
		return this.cdgoSap;
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

	public void setCdgoSap(String cdgoSap) {
		this.cdgoSap = cdgoSap;
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