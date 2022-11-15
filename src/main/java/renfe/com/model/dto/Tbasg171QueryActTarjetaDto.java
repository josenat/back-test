package renfe.com.model.dto;

import java.sql.Date;

public class Tbasg171QueryActTarjetaDto {

	private Integer cdgoPersona;
	private String desgUsuact;
	private Date fchaAct;

	public Integer getCdgoPersona() {
		return this.cdgoPersona;
	}

	public void setCdgoPersona(Integer cdgoPersona) {
		this.cdgoPersona = cdgoPersona;
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