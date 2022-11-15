package renfe.com.dto;

import java.sql.Date;

public class GetHstoCargosResultDTO {

	private String cdgoPersona;
	private Date fchaInicio;
	private Date fchaFin;
	private String cdgoCargo;
	private Date fchaAct;

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

	public String getCdgoCargo() {
		return cdgoCargo;
	}

	public void setCdgoCargo(String cdgoCargo) {
		this.cdgoCargo = cdgoCargo;
	}

	public Date getFchaAct() {
		return fchaAct;
	}

	public void setFchaAct(Date fchaAct) {
		this.fchaAct = fchaAct;
	}

}
