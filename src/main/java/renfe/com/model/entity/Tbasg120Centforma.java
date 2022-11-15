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
@Table(name = "TBASG120_CENTFORMA", schema = "PASG")
public class Tbasg120Centforma {

	@Id
	@Column(name = "CDGO_CENTROFOR")
	private Integer cdgoCentrofor;

	@Column(name = "CDGO_REF")
	private String cdgoRef;

	@Column(name = "CDGO_SAP")
	private String cdgoSap;

	@Column(name = "DESG_DOMCENTRO")
	private String desgDomcentro;

	@Column(name = "DESG_NIFDIRECTOR")
	private String desgNifdirector;

	@NotNull
	@Column(name = "DESG_NOMBRE")
	private String desgNombre;

	@Column(name = "DESG_NOMDIRECTOR")
	private String desgNomdirector;

	@Column(name = "DESG_PERSOCONTAC")
	private String desgPersocontac;

	@Column(name = "DESG_TELEFONO")
	private Integer desgTelefono;

	@Column(name = "DESG_USUACT")
	private String desgUsuact;

	@Column(name = "FCHA_ACT")
	private Date fchaAct;

	@NotNull
	@Column(name = "FCHA_HOMOLOGA")
	private Date fchaHomologa;

	@NotNull
	@Column(name = "FCHA_VALIDEZ")
	private Date fchaValidez;

	@Column(name = "MRCA_ACTIVO")
	private String mrcaActivo;
	
	@Column(name = "CDGO_CENTHGADO")
	private Integer cdgoCenthgado;

	/*@ManyToOne
	@JoinColumn(name = "CDGO_CENTHGADO", nullable = false, foreignKey = @ForeignKey(name = "CDGO$CEN"))
	private Tbasg143Centhgado cdgoCenthgado;*/

	public Integer getCdgoCentrofor() {
		return this.cdgoCentrofor;
	}

	public void setCdgoCentrofor(Integer cdgoCentrofor) {
		this.cdgoCentrofor = cdgoCentrofor;
	}

	public String getCdgoRef() {
		return this.cdgoRef;
	}

	public String getCdgoSap() {
		return this.cdgoSap;
	}

	public String getDesgDomcentro() {
		return this.desgDomcentro;
	}

	public String getDesgNifdirector() {
		return this.desgNifdirector;
	}

	public String getDesgNombre() {
		return this.desgNombre;
	}

	public String getDesgNomdirector() {
		return this.desgNomdirector;
	}

	public String getDesgPersocontac() {
		return this.desgPersocontac;
	}

	public Integer getDesgTelefono() {
		return this.desgTelefono;
	}

	public String getDesgUsuact() {
		return this.desgUsuact;
	}

	public Date getFchaAct() {
		return this.fchaAct;
	}

	public Date getFchaHomologa() {
		return this.fchaHomologa;
	}

	public Date getFchaValidez() {
		return this.fchaValidez;
	}

	public String getMrcaActivo() {
		return this.mrcaActivo;
	}

	public void setCdgoRef(String cdgoRef) {
		this.cdgoRef = cdgoRef;
	}

	public void setCdgoSap(String cdgoSap) {
		this.cdgoSap = cdgoSap;
	}

	public void setDesgDomcentro(String desgDomcentro) {
		this.desgDomcentro = desgDomcentro;
	}

	public void setDesgNifdirector(String desgNifdirector) {
		this.desgNifdirector = desgNifdirector;
	}

	public void setDesgNombre(String desgNombre) {
		this.desgNombre = desgNombre;
	}

	public void setDesgNomdirector(String desgNomdirector) {
		this.desgNomdirector = desgNomdirector;
	}

	public void setDesgPersocontac(String desgPersocontac) {
		this.desgPersocontac = desgPersocontac;
	}

	public void setDesgTelefono(Integer desgTelefono) {
		this.desgTelefono = desgTelefono;
	}

	public void setDesgUsuact(String desgUsuact) {
		this.desgUsuact = desgUsuact;
	}

	public void setFchaAct(Date fchaAct) {
		this.fchaAct = fchaAct;
	}

	public void setFchaHomologa(Date fchaHomologa) {
		this.fchaHomologa = fchaHomologa;
	}

	public void setFchaValidez(Date fchaValidez) {
		this.fchaValidez = fchaValidez;
	}

	public void setMrcaActivo(String mrcaActivo) {
		this.mrcaActivo = mrcaActivo;
	}

	public Integer getCdgoCenthgado() {
		return this.cdgoCenthgado;
	}

	public void setCdgoCenthgado(Integer cdgoCenthgado) {
		this.cdgoCenthgado = cdgoCenthgado;
	}

}