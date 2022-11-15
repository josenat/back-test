package renfe.com.dto;

import java.sql.Date;
import java.util.List;

public class GetAreterResultauxdescripcionDTO {

	private int cdgoAreTer;
	private int cdgoAreAct;
	private String nombre;
	private List<?> areActivi;
	private String usuAct;
	private Date fchaAct;
	private boolean activo;

	public int getCdgoAreTer() {
		return cdgoAreTer;
	}

	public void setCdgoAreTer(int cdgoAreTer) {
		this.cdgoAreTer = cdgoAreTer;
	}

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

	public List<?> getAreActivi() {
		return areActivi;
	}

	public void setAreActivi(List<?> areActivi) {
		this.areActivi = areActivi;
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
