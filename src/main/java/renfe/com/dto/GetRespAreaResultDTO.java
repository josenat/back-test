package renfe.com.dto;

import java.sql.Date;

public class GetRespAreaResultDTO {

	private Integer cdgoAreAct;
	private String responsable;
	private String cargo;
	private String usuAct;
	private Date fchaAct;

	public Integer getCdgoAreAct() {
		return cdgoAreAct;
	}

	public void setCdgoAreAct(Integer cdgoAreAct) {
		this.cdgoAreAct = cdgoAreAct;
	}

	public String getResponsable() {
		return responsable;
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
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

}
