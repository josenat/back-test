package renfe.com.dto;

import java.sql.Date;

public class GetTipoinfraResultDTO {

	private int cdgoTipInfr;
	private String nombre;
	private String usuAct;
	private Date fchaAct;
	private boolean activo;

	public int getCdgoTipInfr() {
		return cdgoTipInfr;
	}

	public void setCdgoTipInfr(int cdgoTipInfr) {
		this.cdgoTipInfr = cdgoTipInfr;
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
