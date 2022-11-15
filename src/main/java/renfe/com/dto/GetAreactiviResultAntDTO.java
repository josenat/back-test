package renfe.com.dto;

import java.sql.Date;

public class GetAreactiviResultAntDTO {

	private int cdgoAreAct;
	private String nombre;
	private String usuAct;
	private Date fchaAct;
	private boolean activo;
	private String cdgoSociedad;

	public int getCdgoAreAct() {
		return cdgoAreAct;
	}

	public void setCdgoAreAct(int cdgoAreAct) {
		this.cdgoAreAct = cdgoAreAct;
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

	public String getCdgoSociedad() {
		return cdgoSociedad;
	}

	public void setCdgoSociedad(String cdgoSociedad) {
		this.cdgoSociedad = cdgoSociedad;
	}

}
