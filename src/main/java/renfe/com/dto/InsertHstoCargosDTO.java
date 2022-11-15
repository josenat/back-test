package renfe.com.dto;

import java.sql.Date;

public class InsertHstoCargosDTO {

	private String cdgoPersona;
	private Date fchaInicio;
	private Date fchaFin;
	private String usuAct;
	private String cdgoCargo;

	public String getCdgoPersona() {
		return cdgoPersona;
	}

	public void setCdgoPersona(String cdgoPersona) {
		this.cdgoPersona = cdgoPersona;
	}

	public Date getFchaInicio() {
		return fchaInicio;
	}

	public void setFchaInicio(Date fchaInicio) {
		this.fchaInicio = fchaInicio;
	}

	public Date getFchaFin() {
		return fchaFin;
	}

	public void setFchaFin(Date fchaFin) {
		this.fchaFin = fchaFin;
	}

	public String getUsuAct() {
		return usuAct;
	}

	public void setUsuAct(String usuAct) {
		this.usuAct = usuAct;
	}

	public String getCdgoCargo() {
		return cdgoCargo;
	}

	public void setCdgoCargo(String cdgoCargo) {
		this.cdgoCargo = cdgoCargo;
	}

}
