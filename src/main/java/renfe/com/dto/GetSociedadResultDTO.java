package renfe.com.dto;

import java.sql.Date;

public class GetSociedadResultDTO {

	private String cdgoSociedad;
	private String nombre;
	private String usuAct;
	private Date fchaAct;
	private boolean activo;

	public String getCdgoSociedad() {
		return cdgoSociedad;
	}

	public void setCdgoSociedad(String cdgoSociedad) {
		this.cdgoSociedad = cdgoSociedad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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
