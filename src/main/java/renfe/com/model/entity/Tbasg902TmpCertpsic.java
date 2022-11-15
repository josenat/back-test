package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG902_TMP_CERTPSIC")
public class Tbasg902TmpCertpsic {

	@Id
	@Column(name = "CDGO_CERTPSIC")
	private Long cdgoCertpsic;

	@NotNull
	@Column(name = "CDGO_CALIFI")
	private Integer cdgoCalifi;

	@NotNull
	@Column(name = "CDGO_CENMED")
	private Integer cdgoCenmed;

	@Column(name = "CDGO_DEOBS")
	private String cdgoDeobs;

	@NotNull
	@Column(name = "CDGO_FACULT")
	private Integer cdgoFacult;

	@NotNull
	@Column(name = "CDGO_MOTIVO")
	private Integer cdgoMotivo;

	@NotNull
	@Column(name = "CDGO_PERSONA")
	private Integer cdgoPersona;

	@Column(name = "CDGO_PSICAMB")
	private Integer cdgoPsicamb;

	@Column(name = "DESG_USUACT")
	private String desgUsuact;

	@Column(name = "FCHA_ACT")
	private Date fchaAct;

	@Column(name = "FCHA_LIMTEMP")
	private Date fchaLimtemp;

	@NotNull
	@Column(name = "FCHA_PROXREV")
	private Date fchaProxrev;

	@Column(name = "FCHA_RECONOC")
	private Date fchaReconoc;

	@Column(name = "MRCA_ACTIVO")
	private String mrcaActivo;

	@Column(name = "MRCA_CORRVISUAL")
	private String mrcaCorrvisual;

	@Column(name = "MRCA_PROTAUD")
	private String mrcaProtaud;

	public Long getCdgoCertpsic() {
		return this.cdgoCertpsic;
	}

	public void setCdgoCertpsic(Long cdgoCertpsic) {
		this.cdgoCertpsic = cdgoCertpsic;
	}

	public Integer getCdgoCalifi() {
		return this.cdgoCalifi;
	}

	public Integer getCdgoCenmed() {
		return this.cdgoCenmed;
	}

	public String getCdgoDeobs() {
		return this.cdgoDeobs;
	}

	public Integer getCdgoFacult() {
		return this.cdgoFacult;
	}

	public Integer getCdgoMotivo() {
		return this.cdgoMotivo;
	}

	public Integer getCdgoPersona() {
		return this.cdgoPersona;
	}

	public Integer getCdgoPsicamb() {
		return this.cdgoPsicamb;
	}

	public String getDesgUsuact() {
		return this.desgUsuact;
	}

	public Date getFchaAct() {
		return this.fchaAct;
	}

	public Date getFchaLimtemp() {
		return this.fchaLimtemp;
	}

	public Date getFchaProxrev() {
		return this.fchaProxrev;
	}

	public Date getFchaReconoc() {
		return this.fchaReconoc;
	}

	public String getMrcaActivo() {
		return this.mrcaActivo;
	}

	public String getMrcaCorrvisual() {
		return this.mrcaCorrvisual;
	}

	public String getMrcaProtaud() {
		return this.mrcaProtaud;
	}

	public void setCdgoCalifi(Integer cdgoCalifi) {
		this.cdgoCalifi = cdgoCalifi;
	}

	public void setCdgoCenmed(Integer cdgoCenmed) {
		this.cdgoCenmed = cdgoCenmed;
	}

	public void setCdgoDeobs(String cdgoDeobs) {
		this.cdgoDeobs = cdgoDeobs;
	}

	public void setCdgoFacult(Integer cdgoFacult) {
		this.cdgoFacult = cdgoFacult;
	}

	public void setCdgoMotivo(Integer cdgoMotivo) {
		this.cdgoMotivo = cdgoMotivo;
	}

	public void setCdgoPersona(Integer cdgoPersona) {
		this.cdgoPersona = cdgoPersona;
	}

	public void setCdgoPsicamb(Integer cdgoPsicamb) {
		this.cdgoPsicamb = cdgoPsicamb;
	}

	public void setDesgUsuact(String desgUsuact) {
		this.desgUsuact = desgUsuact;
	}

	public void setFchaAct(Date fchaAct) {
		this.fchaAct = fchaAct;
	}

	public void setFchaLimtemp(Date fchaLimtemp) {
		this.fchaLimtemp = fchaLimtemp;
	}

	public void setFchaProxrev(Date fchaProxrev) {
		this.fchaProxrev = fchaProxrev;
	}

	public void setFchaReconoc(Date fchaReconoc) {
		this.fchaReconoc = fchaReconoc;
	}

	public void setMrcaActivo(String mrcaActivo) {
		this.mrcaActivo = mrcaActivo;
	}

	public void setMrcaCorrvisual(String mrcaCorrvisual) {
		this.mrcaCorrvisual = mrcaCorrvisual;
	}

	public void setMrcaProtaud(String mrcaProtaud) {
		this.mrcaProtaud = mrcaProtaud;
	}

}