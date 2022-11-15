package renfe.com.model.dto;

import java.sql.Date;

public class Tbasg249UsuariowsTarjetasDto {

	private String cdgoUsuario;
	private String desgObservaciones;
	private String desgUsuact;
	private Date fchaAct;

	public String getCdgoUsuario() {
		return this.cdgoUsuario;
	}

	public void setCdgoUsuario(String cdgoUsuario) {
		this.cdgoUsuario = cdgoUsuario;
	}

	public String getDesgObservaciones() {
		return this.desgObservaciones;
	}

	public void setDesgObservaciones(String desgObservaciones) {
		this.desgObservaciones = desgObservaciones;
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