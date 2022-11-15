package renfe.com.dto;

import java.sql.Date;

public class GetCenthgadoResultDTO {

	private Integer cdgoCentHgado;
	private String cif;
	private String nombre;
	private String domSocial;
	private Integer cdgoNacion;
	private String usuAct;
	private Date fchaAct;
	private boolean activo;

	public Integer getCdgoCentHgado() {
		return cdgoCentHgado;
	}

	public void setCdgoCentHgado(Integer cdgoCentHgado) {
		this.cdgoCentHgado = cdgoCentHgado;
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

	public String getDomSocial() {
		return domSocial;
	}

	public void setDomSocial(String domSocial) {
		this.domSocial = domSocial;
	}

	public Integer getCdgoNacion() {
		return cdgoNacion;
	}

	public void setCdgoNacion(Integer cdgoNacion) {
		this.cdgoNacion = cdgoNacion;
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
