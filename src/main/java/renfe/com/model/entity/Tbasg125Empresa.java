package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG125_EMPRESA", schema = "PASG")
public class Tbasg125Empresa {

	@Id
	@Column(name = "CDGO_EMPRESA")
	private Integer cdgoEmpresa;

	@NotNull
	@Column(name = "CDGO_PROVINCIA")
	private Integer cdgoProvincia;

	@NotNull
	@Column(name = "DESG_CIF")
	private String desgCif;

	@NotNull
	@Column(name = "DESG_CODPOST")
	private String desgCodpost;

	@Column(name = "DESG_EMAIL")
	private String desgEmail;

	@Column(name = "DESG_ESCALERA")
	private String desgEscalera;

	@Column(name = "DESG_FAX")
	private Integer desgFax;

	@Column(name = "DESG_MUNICIPIO")
	private String desgMunicipio;

	@NotNull
	@Column(name = "DESG_NOMBRE")
	private String desgNombre;

	@NotNull
	@Column(name = "DESG_NUMVIA")
	private String desgNumvia;

	@Column(name = "DESG_PERSCONTAC")
	private String desgPerscontac;

	@Column(name = "DESG_PLANTA")
	private String desgPlanta;

	@Column(name = "DESG_PUERTA")
	private String desgPuerta;

	@Column(name = "DESG_TELEFONO")
	private Integer desgTelefono;

	@Column(name = "DESG_USUACT")
	private String desgUsuact;

	@NotNull
	@Column(name = "DESG_VIA")
	private String desgVia;

	@Column(name = "FCHA_ACT")
	private Date fchaAct;

	@Column(name = "MRCA_ACTIVO")
	private char mrcaActivo;
	
	@Column(name = "CDGO_NACION")
	private Integer cdgoNacion;
	
	@Column(name = "CDGO_TIPOVIA")
	private Integer cdgoTipovia;

	public Integer getCdgoEmpresa() {
		return this.cdgoEmpresa;
	}


	public void setCdgoEmpresa(Integer cdgoEmpresa) {
		this.cdgoEmpresa = cdgoEmpresa;
	}

	public Integer getCdgoProvincia() {
		return cdgoProvincia;
	}

	public void setCdgoProvincia(Integer cdgoProvincia) {
		this.cdgoProvincia = cdgoProvincia;
	}

	public String getDesgCif() {
		return desgCif;
	}

	public void setDesgCif(String desgCif) {
		this.desgCif = desgCif;
	}

	public String getDesgCodpost() {
		return desgCodpost;
	}

	public void setDesgCodpost(String desgCodpost) {
		this.desgCodpost = desgCodpost;
	}

	public String getDesgEmail() {
		return desgEmail;
	}

	public void setDesgEmail(String desgEmail) {
		this.desgEmail = desgEmail;
	}

	public String getDesgEscalera() {
		return desgEscalera;
	}

	public void setDesgEscalera(String desgEscalera) {
		this.desgEscalera = desgEscalera;
	}

	public Integer getDesgFax() {
		return desgFax;
	}

	public void setDesgFax(Integer desgFax) {
		this.desgFax = desgFax;
	}

	public String getDesgMunicipio() {
		return desgMunicipio;
	}

	public void setDesgMunicipio(String desgMunicipio) {
		this.desgMunicipio = desgMunicipio;
	}

	public String getDesgNombre() {
		return desgNombre;
	}

	public void setDesgNombre(String desgNombre) {
		this.desgNombre = desgNombre;
	}

	public String getDesgNumvia() {
		return desgNumvia;
	}

	public void setDesgNumvia(String desgNumvia) {
		this.desgNumvia = desgNumvia;
	}

	public String getDesgPerscontac() {
		return desgPerscontac;
	}

	public void setDesgPerscontac(String desgPerscontac) {
		this.desgPerscontac = desgPerscontac;
	}

	public String getDesgPlanta() {
		return desgPlanta;
	}

	public void setDesgPlanta(String desgPlanta) {
		this.desgPlanta = desgPlanta;
	}

	public String getDesgPuerta() {
		return desgPuerta;
	}

	public void setDesgPuerta(String desgPuerta) {
		this.desgPuerta = desgPuerta;
	}

	public Integer getDesgTelefono() {
		return desgTelefono;
	}

	public void setDesgTelefono(Integer desgTelefono) {
		this.desgTelefono = desgTelefono;
	}

	public String getDesgUsuact() {
		return desgUsuact;
	}

	public void setDesgUsuact(String desgUsuact) {
		this.desgUsuact = desgUsuact;
	}

	public String getDesgVia() {
		return desgVia;
	}

	public void setDesgVia(String desgVia) {
		this.desgVia = desgVia;
	}

	public Date getFchaAct() {
		return fchaAct;
	}

	public void setFchaAct(Date fchaAct) {
		this.fchaAct = fchaAct;
	}

	public char getMrcaActivo() {
		return mrcaActivo;
	}

	public void setMrcaActivo(char mrcaActivo) {
		this.mrcaActivo = mrcaActivo;
	}

	public Integer getCdgoNacion() {
		return cdgoNacion;
	}

	public void setCdgoNacion(Integer cdgoNacion) {
		this.cdgoNacion = cdgoNacion;
	}

	public Integer getCdgoTipovia() {
		return cdgoTipovia;
	}

	public void setCdgoTipovia(Integer cdgoTipovia) {
		this.cdgoTipovia = cdgoTipovia;
	}

}