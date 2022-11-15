package renfe.com.dto;

import java.sql.Date;

public class GetCalificacResultDTO {

	private int cdgoCalifi;
	private String nombre;
	private String tipoCalif;
	private String usuAct;
	private Date fchaAct;
	private boolean activo;

	public int getCdgoCalifi() {
		return cdgoCalifi;
	}

	public void setCdgoCalifi(int cdgoCalifi) {
		this.cdgoCalifi = cdgoCalifi;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipoCalif() {
		return tipoCalif;
	}

	public void setTipoCalif(String tipoCalif) {
		this.tipoCalif = tipoCalif;
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
