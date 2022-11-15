package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBASG249_USUARIOWS_TARJETAS")
public class Tbasg249UsuariowsTarjetas {

	@Id
	@Column(name = "CDGO_USUARIO")
	private Long cdgoUsuario;

	@Column(name = "DESG_OBSERVACIONES")
	private String desgObservaciones;

	@Column(name = "DESG_USUACT")
	private String desgUsuact;

	@Column(name = "FCHA_ACT")
	private Date fchaAct;

	public Long getCdgoUsuario() {
		return this.cdgoUsuario;
	}

	public void setCdgoUsuario(Long cdgoUsuario) {
		this.cdgoUsuario = cdgoUsuario;
	}

	public String getDesgObservaciones() {
		return this.desgObservaciones;
	}

	public String getDesgUsuact() {
		return this.desgUsuact;
	}

	public Date getFchaAct() {
		return this.fchaAct;
	}

	public void setDesgObservaciones(String desgObservaciones) {
		this.desgObservaciones = desgObservaciones;
	}

	public void setDesgUsuact(String desgUsuact) {
		this.desgUsuact = desgUsuact;
	}

	public void setFchaAct(Date fchaAct) {
		this.fchaAct = fchaAct;
	}

}