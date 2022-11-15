package renfe.com.dto;

import java.sql.Date;

public class GetCentformaviewResultDTO {

	private int cdgoCentroFor;
	private String centHgado;
	private String cif;
	private String domSocial;
	private String cdgoSap;
	private String cdgoRef;
	private String nombre;
	private String nifDirector;
	private String nomDirector;
	private String domCentro;
	private Date fchaHomologa;
	private Date fchaValidez;
	private Integer telefono;
	private String persoContac;
	private String usuAct;
	private Date fchaAct;
	private boolean activo;

	public int getCdgoCentroFor() {
		return cdgoCentroFor;
	}

	public void setCdgoCentroFor(int cdgoCentroFor) {
		this.cdgoCentroFor = cdgoCentroFor;
	}

	public String getCentHgado() {
		return centHgado;
	}

	public void setCentHgado(String centHgado) {
		this.centHgado = centHgado;
	}

	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public String getDomSocial() {
		return domSocial;
	}

	public void setDomSocial(String domSocial) {
		this.domSocial = domSocial;
	}

	public String getCdgoSap() {
		return cdgoSap;
	}

	public void setCdgoSap(String cdgoSap) {
		this.cdgoSap = cdgoSap;
	}

	public String getCdgoRef() {
		return cdgoRef;
	}

	public void setCdgoRef(String cdgoRef) {
		this.cdgoRef = cdgoRef;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNifDirector() {
		return nifDirector;
	}

	public void setNifDirector(String nifDirector) {
		this.nifDirector = nifDirector;
	}

	public String getNomDirector() {
		return nomDirector;
	}

	public void setNomDirector(String nomDirector) {
		this.nomDirector = nomDirector;
	}

	public String getDomCentro() {
		return domCentro;
	}

	public void setDomCentro(String domCentro) {
		this.domCentro = domCentro;
	}

	public Date getFchaHomologa() {
		return fchaHomologa;
	}

	public void setFchaHomologa(Date fchaHomologa) {
		this.fchaHomologa = fchaHomologa;
	}

	public Date getFchaValidez() {
		return fchaValidez;
	}

	public void setFchaValidez(Date fchaValidez) {
		this.fchaValidez = fchaValidez;
	}

	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	public String getPersoContac() {
		return persoContac;
	}

	public void setPersoContac(String persoContac) {
		this.persoContac = persoContac;
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
