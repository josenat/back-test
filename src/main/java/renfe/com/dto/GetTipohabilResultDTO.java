package renfe.com.dto;

import java.sql.Date;

public class GetTipohabilResultDTO {

	private int cdgoTipoHab;
	private String nombre;
	private String grupo;
	private String usuAct;
	private Date fchaAct;
	private boolean activo;

	public int getCdgoTipoHab() {
		return cdgoTipoHab;
	}

	public void setCdgoTipoHab(int cdgoTipoHab) {
		this.cdgoTipoHab = cdgoTipoHab;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
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
