package renfe.com.dto;

import java.sql.Date;

public class GetEmpresaResultDTO {

	private int cdgoEmpresa;
	private String cif;
	private String nombre;
	private Integer cdgoNacion;
	private int cdgoTipoVia;
	private String via;
	private String numVia;
	private String planta;
	private String puerta;
	private String escalera;
	private String codPost;
	private String municipio;
	private int cdgoProvincia;
	private String persContact;
	private Integer telefono;
	private Integer fax;
	private String email;
	private String usuAct;
	private Date fchaAct;
	private boolean activo;

	public int getCdgoEmpresa() {
		return cdgoEmpresa;
	}

	public void setCdgoEmpresa(int cdgoEmpresa) {
		this.cdgoEmpresa = cdgoEmpresa;
	}

	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCdgoNacion() {
		return cdgoNacion;
	}

	public void setCdgoNacion(Integer cdgoNacion) {
		this.cdgoNacion = cdgoNacion;
	}

	public int getCdgoTipoVia() {
		return cdgoTipoVia;
	}

	public void setCdgoTipoVia(int cdgoTipoVia) {
		this.cdgoTipoVia = cdgoTipoVia;
	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public String getNumVia() {
		return numVia;
	}

	public void setNumVia(String numVia) {
		this.numVia = numVia;
	}

	public String getPlanta() {
		return planta;
	}

	public void setPlanta(String planta) {
		this.planta = planta;
	}

	public String getPuerta() {
		return puerta;
	}

	public void setPuerta(String puerta) {
		this.puerta = puerta;
	}

	public String getEscalera() {
		return escalera;
	}

	public void setEscalera(String escalera) {
		this.escalera = escalera;
	}

	public String getCodPost() {
		return codPost;
	}

	public void setCodPost(String codPost) {
		this.codPost = codPost;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public int getCdgoProvincia() {
		return cdgoProvincia;
	}

	public void setCdgoProvincia(int cdgoProvincia) {
		this.cdgoProvincia = cdgoProvincia;
	}

	public String getPersContact() {
		return persContact;
	}

	public void setPersContact(String persContact) {
		this.persContact = persContact;
	}

	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	public Integer getFax() {
		return fax;
	}

	public void setFax(Integer fax) {
		this.fax = fax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsuAct() {
		return usuAct;
	}

	public void setUsuAct(String usuAct) {
		this.usuAct = usuAct;
	}

	public Date getFchaAct() {
		return fchaAct;
	}

	public void setFchaAct(Date fchaAct) {
		this.fchaAct = fchaAct;
	}

	public boolean getActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

}
