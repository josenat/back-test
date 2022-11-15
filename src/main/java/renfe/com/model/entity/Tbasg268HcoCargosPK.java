package renfe.com.model.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@AttributeOverrides({ @AttributeOverride(name = "cdgoPersona", column = @Column(name = "CDGO_PERSONA")),
		@AttributeOverride(name = "fchaInicio", column = @Column(name = "FCHA_INICIO")) })
public class Tbasg268HcoCargosPK implements Serializable {

	private static final long serialVersionUID = 1L;

	private String cdgoPersona;
	private Date fchaInicio;

	public String getCdgoPersona() {
		return this.cdgoPersona;
	}

	public Date getFchaInicio() {
		return this.fchaInicio;
	}

	public void setCdgoPersona(String cdgoPersona) {
		this.cdgoPersona = cdgoPersona;
	}

	public void setFchaInicio(Date fchaInicio) {
		this.fchaInicio = fchaInicio;
	}

}