package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG250_USUARIOWS")
public class Tbasg250Usuariows {

	@Id
	@Column(name = "CDGO_LOGIN")
	private Long cdgoLogin;

	@NotNull
	@Column(name = "DESG_PASSWORD")
	private String desgPassword;

	@Column(name = "DESG_USUACT")
	private String desgUsuact;

	@NotNull
	@Column(name = "DESG_USUARIO")
	private String desgUsuario;

	@Column(name = "FCHA_ACT")
	private Date fchaAct;

	public Long getCdgoLogin() {
		return this.cdgoLogin;
	}

	public void setCdgoLogin(Long cdgoLogin) {
		this.cdgoLogin = cdgoLogin;
	}

	public String getDesgPassword() {
		return this.desgPassword;
	}

	public String getDesgUsuact() {
		return this.desgUsuact;
	}

	public String getDesgUsuario() {
		return this.desgUsuario;
	}

	public Date getFchaAct() {
		return this.fchaAct;
	}

	public void setDesgPassword(String desgPassword) {
		this.desgPassword = desgPassword;
	}

	public void setDesgUsuact(String desgUsuact) {
		this.desgUsuact = desgUsuact;
	}

	public void setDesgUsuario(String desgUsuario) {
		this.desgUsuario = desgUsuario;
	}

	public void setFchaAct(Date fchaAct) {
		this.fchaAct = fchaAct;
	}

}