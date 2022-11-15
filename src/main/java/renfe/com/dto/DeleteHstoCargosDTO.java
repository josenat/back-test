package renfe.com.dto;

import java.sql.Date;

public class DeleteHstoCargosDTO {

	private String cdgoPersona;
	private String cdgoCargo;
	private Date fchaInicio;

	public String getCdgoPersona() {
		return cdgoPersona;
	}

	public void setCdgoPersona(String cdgoPersona) {
		this.cdgoPersona = cdgoPersona;
	}

	public String getCdgoCargo() {
		return cdgoCargo;
	}

	public void setCdgoCargo(String cdgoCargo) {
		this.cdgoCargo = cdgoCargo;
	}

	public Date getFchaInicio() {
		return fchaInicio;
	}

	public void setFchaInicio(Date fchaInicio) {
		this.fchaInicio = fchaInicio;
	}

}
