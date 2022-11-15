package renfe.com.model.dto;

import java.sql.Date;

public class Tbasg142RespAreaDto {

	private Integer cdgoAreact;
	private String desgCargo;
	private String desgResponsable;
	private String desgUsuact;
	private Date fchaAct;

	public Integer getCdgoAreact() {
		return this.cdgoAreact;
	}

	public void setCdgoAreact(Integer cdgoAreact) {
		this.cdgoAreact = cdgoAreact;
	}

	public String getDesgCargo() {
		return this.desgCargo;
	}

	public void setDesgCargo(String desgCargo) {
		this.desgCargo = desgCargo;
	}

	public String getDesgResponsable() {
		return this.desgResponsable;
	}

	public void setDesgResponsable(String desgResponsable) {
		this.desgResponsable = desgResponsable;
	}

	public String getDesgUsuact() {
		return this.desgUsuact;
	}

	public void setDesgUsuact(String desgUsuact) {
		this.desgUsuact = desgUsuact;
	}

	public Date getFchaAct() {
		return this.fchaAct;
	}

	public void setFchaAct(Date fchaAct) {
		this.fchaAct = fchaAct;
	}

}