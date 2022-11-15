package renfe.com.model.entity;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@AttributeOverrides({ @AttributeOverride(name = "cdgoPersona", column = @Column(name = "CDGO_PERSONA")),
		@AttributeOverride(name = "fchaOperacion", column = @Column(name = "FCHA_OPERACION")) })
public class Tbasg154OpTarjetaPK implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer cdgoPersona;
	private String fchaOperacion;

	public Integer getCdgoPersona() {
		return this.cdgoPersona;
	}

	public String getFchaOperacion() {
		return this.fchaOperacion;
	}

	public void setCdgoPersona(Integer cdgoPersona) {
		this.cdgoPersona = cdgoPersona;
	}

	public void setFchaOperacion(String fchaOperacion) {
		this.fchaOperacion = fchaOperacion;
	}

}