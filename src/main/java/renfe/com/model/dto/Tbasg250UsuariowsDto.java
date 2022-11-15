package renfe.com.model.dto;

import java.sql.Date;

public class Tbasg250UsuariowsDto {

	private String cdgoLogin;
	private String desgPassword;
	private String desgUsuact;
	private String desgUsuario;
	private Date fchaAct;

	public String getCdgoLogin() {
		return this.cdgoLogin;
	}

	public void setCdgoLogin(String cdgoLogin) {
		this.cdgoLogin = cdgoLogin;
	}

	public String getDesgPassword() {
		return this.desgPassword;
	}

	public void setDesgPassword(String desgPassword) {
		this.desgPassword = desgPassword;
	}

	public String getDesgUsuact() {
		return this.desgUsuact;
	}

	public void setDesgUsuact(String desgUsuact) {
		this.desgUsuact = desgUsuact;
	}

	public String getDesgUsuario() {
		return this.desgUsuario;
	}

	public void setDesgUsuario(String desgUsuario) {
		this.desgUsuario = desgUsuario;
	}

	public Date getFchaAct() {
		return this.fchaAct;
	}

	public void setFchaAct(Date fchaAct) {
		this.fchaAct = fchaAct;
	}

}