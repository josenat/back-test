package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG901_TMP_EXPEDIENT")
public class Tbasg901TmpExpedient {

	@Id
	@Column(name = "CDGO_EXPEDIENT")
	private Long cdgoExpedient;

	@Column(name = "CDGO_ALCANCEAMBITO")
	private Integer cdgoAlcanceambito;

	@Column(name = "CDGO_ALCANCEOT")
	private Integer cdgoAlcanceot;

	@NotNull
	@Column(name = "CDGO_AMBITOS")
	private Integer cdgoAmbitos;

	@NotNull
	@Column(name = "CDGO_EMPRESA")
	private Integer cdgoEmpresa;

	@Column(name = "CDGO_ENTORNO")
	private Integer cdgoEntorno;

	@Column(name = "CDGO_ESPEC")
	private Integer cdgoEspec;

	@Column(name = "CDGO_LINEA")
	private String cdgoLinea;

	@NotNull
	@Column(name = "CDGO_PERSONA")
	private Integer cdgoPersona;

	@Column(name = "CDGO_SERIE")
	private String cdgoSerie;

	@Column(name = "CDGO_SUBSERIE")
	private String cdgoSubserie;

	@NotNull
	@Column(name = "CDGO_TIPOHAB")
	private Integer cdgoTipohab;

	@Column(name = "DESG_OBSERVA")
	private String desgObserva;

	@Column(name = "DESG_TIPOINFRAESTRUC")
	private String desgTipoinfraestruc;

	@Column(name = "DESG_USUACT")
	private String desgUsuact;

	@Column(name = "FCHA_ACT")
	private Date fchaAct;

	@Column(name = "FCHA_EXPEDIENTE")
	private Date fchaExpediente;

	@Column(name = "MRCA_ACTIVO")
	private String mrcaActivo;

	public Long getCdgoExpedient() {
		return this.cdgoExpedient;
	}

	public void setCdgoExpedient(Long cdgoExpedient) {
		this.cdgoExpedient = cdgoExpedient;
	}

	public Integer getCdgoAlcanceambito() {
		return this.cdgoAlcanceambito;
	}

	public Integer getCdgoAlcanceot() {
		return this.cdgoAlcanceot;
	}

	public Integer getCdgoAmbitos() {
		return this.cdgoAmbitos;
	}

	public Integer getCdgoEmpresa() {
		return this.cdgoEmpresa;
	}

	public Integer getCdgoEntorno() {
		return this.cdgoEntorno;
	}

	public Integer getCdgoEspec() {
		return this.cdgoEspec;
	}

	public String getCdgoLinea() {
		return this.cdgoLinea;
	}

	public Integer getCdgoPersona() {
		return this.cdgoPersona;
	}

	public String getCdgoSerie() {
		return this.cdgoSerie;
	}

	public String getCdgoSubserie() {
		return this.cdgoSubserie;
	}

	public Integer getCdgoTipohab() {
		return this.cdgoTipohab;
	}

	public String getDesgObserva() {
		return this.desgObserva;
	}

	public String getDesgTipoinfraestruc() {
		return this.desgTipoinfraestruc;
	}

	public String getDesgUsuact() {
		return this.desgUsuact;
	}

	public Date getFchaAct() {
		return this.fchaAct;
	}

	public Date getFchaExpediente() {
		return this.fchaExpediente;
	}

	public String getMrcaActivo() {
		return this.mrcaActivo;
	}

	public void setCdgoAlcanceambito(Integer cdgoAlcanceambito) {
		this.cdgoAlcanceambito = cdgoAlcanceambito;
	}

	public void setCdgoAlcanceot(Integer cdgoAlcanceot) {
		this.cdgoAlcanceot = cdgoAlcanceot;
	}

	public void setCdgoAmbitos(Integer cdgoAmbitos) {
		this.cdgoAmbitos = cdgoAmbitos;
	}

	public void setCdgoEmpresa(Integer cdgoEmpresa) {
		this.cdgoEmpresa = cdgoEmpresa;
	}

	public void setCdgoEntorno(Integer cdgoEntorno) {
		this.cdgoEntorno = cdgoEntorno;
	}

	public void setCdgoEspec(Integer cdgoEspec) {
		this.cdgoEspec = cdgoEspec;
	}

	public void setCdgoLinea(String cdgoLinea) {
		this.cdgoLinea = cdgoLinea;
	}

	public void setCdgoPersona(Integer cdgoPersona) {
		this.cdgoPersona = cdgoPersona;
	}

	public void setCdgoSerie(String cdgoSerie) {
		this.cdgoSerie = cdgoSerie;
	}

	public void setCdgoSubserie(String cdgoSubserie) {
		this.cdgoSubserie = cdgoSubserie;
	}

	public void setCdgoTipohab(Integer cdgoTipohab) {
		this.cdgoTipohab = cdgoTipohab;
	}

	public void setDesgObserva(String desgObserva) {
		this.desgObserva = desgObserva;
	}

	public void setDesgTipoinfraestruc(String desgTipoinfraestruc) {
		this.desgTipoinfraestruc = desgTipoinfraestruc;
	}

	public void setDesgUsuact(String desgUsuact) {
		this.desgUsuact = desgUsuact;
	}

	public void setFchaAct(Date fchaAct) {
		this.fchaAct = fchaAct;
	}

	public void setFchaExpediente(Date fchaExpediente) {
		this.fchaExpediente = fchaExpediente;
	}

	public void setMrcaActivo(String mrcaActivo) {
		this.mrcaActivo = mrcaActivo;
	}

}