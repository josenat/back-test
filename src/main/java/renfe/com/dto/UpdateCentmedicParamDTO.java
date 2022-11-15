package renfe.com.dto;

import java.sql.Date;

public class UpdateCentmedicParamDTO {

	private Integer cdgoCentHgado;
	private String cdgoSap;
	private String cdgoRef;
	private String nombre;
	private String nifDirector;
	private String nomDirector;
	private String domCentro;
	private Integer telefono;
	private Date fchaHomologa;
	private Date fchaValidez;
	private String usuAct;
	private int cdgoCentMed;

	public Integer getCdgoCentHgado() {
		return cdgoCentHgado;
	}

	public void setCdgoCentHgado(Integer cdgoCentHgado) {
		this.cdgoCentHgado = cdgoCentHgado;
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

	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
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

	public String getUsuAct() {
		return usuAct;
	}

	public void setUsuAct(String usuAct) {
		this.usuAct = usuAct;
	}

	public int getCdgoCentMed() {
		return cdgoCentMed;
	}

	public void setCdgoCentMed(int cdgoCentMed) {
		this.cdgoCentMed = cdgoCentMed;
	}

}
