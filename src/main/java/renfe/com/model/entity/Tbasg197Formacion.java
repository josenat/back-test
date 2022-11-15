package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG197_FORMACION", schema = "PASG")
public class Tbasg197Formacion {

	@Id
	@Column(name = "CDGO_SOLICITUD")
	private Integer cdgoSolicitud;

	@Column(name = "CDGO_ALCANCE")
	private String cdgoAlcance;

	@NotNull
	@Column(name = "CDGO_AREACT")
	private Integer cdgoAreact;

	@Column(name = "CDGO_SERIE")
	private String cdgoSerie;

	@Column(name = "CDGO_SUBSERIE")
	private String cdgoSubserie;

	@NotNull
	@Column(name = "CDGO_TIPOHAB")
	private Integer cdgoTipohab;

	@NotNull
	@Column(name = "DESG_APELL1")
	private String desgApell1;

	@Column(name = "DESG_APELL2")
	private String desgApell2;

	@NotNull
	@Column(name = "DESG_CIF")
	private String desgCif;

	@NotNull
	@Column(name = "DESG_DESCRIPCION")
	private String desgDescripcion;

	@NotNull
	@Column(name = "DESG_EMPRESA")
	private String desgEmpresa;

	@NotNull
	@Column(name = "DESG_NIFPAS")
	private String desgNifpas;

	@NotNull
	@Column(name = "DESG_NOMBRE")
	private String desgNombre;

	@NotNull
	@Column(name = "DESG_TIPOEXP")
	private String desgTipoexp;

	@Column(name = "DESG_USUACT")
	private String desgUsuact;

	@Column(name = "FCHA_ACT")
	private Date fchaAct;

	@Column(name = "CDGO_ESTADO")
	private Integer cdgoEstado;

	@Column(name = "CDGO_EXPEDIENT")
	private Integer cdgoExpedient;

	@Column(name = "CDGO_TIT")
	private Integer cdgoTit;

	public Integer getCdgoSolicitud() {
		return this.cdgoSolicitud;
	}

	public void setCdgoSolicitud(Integer cdgoSolicitud) {
		this.cdgoSolicitud = cdgoSolicitud;
	}

	public String getCdgoAlcance() {
		return this.cdgoAlcance;
	}

	public Integer getCdgoAreact() {
		return this.cdgoAreact;
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

	public String getDesgApell1() {
		return this.desgApell1;
	}

	public String getDesgApell2() {
		return this.desgApell2;
	}

	public String getDesgCif() {
		return this.desgCif;
	}

	public String getDesgDescripcion() {
		return this.desgDescripcion;
	}

	public String getDesgEmpresa() {
		return this.desgEmpresa;
	}

	public String getDesgNifpas() {
		return this.desgNifpas;
	}

	public String getDesgNombre() {
		return this.desgNombre;
	}

	public String getDesgTipoexp() {
		return this.desgTipoexp;
	}

	public String getDesgUsuact() {
		return this.desgUsuact;
	}

	public Date getFchaAct() {
		return this.fchaAct;
	}

	public void setCdgoAlcance(String cdgoAlcance) {
		this.cdgoAlcance = cdgoAlcance;
	}

	public void setCdgoAreact(Integer cdgoAreact) {
		this.cdgoAreact = cdgoAreact;
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

	public void setDesgApell1(String desgApell1) {
		this.desgApell1 = desgApell1;
	}

	public void setDesgApell2(String desgApell2) {
		this.desgApell2 = desgApell2;
	}

	public void setDesgCif(String desgCif) {
		this.desgCif = desgCif;
	}

	public void setDesgDescripcion(String desgDescripcion) {
		this.desgDescripcion = desgDescripcion;
	}

	public void setDesgEmpresa(String desgEmpresa) {
		this.desgEmpresa = desgEmpresa;
	}

	public void setDesgNifpas(String desgNifpas) {
		this.desgNifpas = desgNifpas;
	}

	public void setDesgNombre(String desgNombre) {
		this.desgNombre = desgNombre;
	}

	public void setDesgTipoexp(String desgTipoexp) {
		this.desgTipoexp = desgTipoexp;
	}

	public void setDesgUsuact(String desgUsuact) {
		this.desgUsuact = desgUsuact;
	}

	public void setFchaAct(Date fchaAct) {
		this.fchaAct = fchaAct;
	}

	public Integer getCdgoEstado() {
		return cdgoEstado;
	}

	public void setCdgoEstado(Integer cdgoEstado) {
		this.cdgoEstado = cdgoEstado;
	}

	public Integer getCdgoExpedient() {
		return cdgoExpedient;
	}

	public void setCdgoExpedient(Integer cdgoExpedient) {
		this.cdgoExpedient = cdgoExpedient;
	}

	public Integer getCdgoTit() {
		return cdgoTit;
	}

	public void setCdgoTit(Integer cdgoTit) {
		this.cdgoTit = cdgoTit;
	}
	
}