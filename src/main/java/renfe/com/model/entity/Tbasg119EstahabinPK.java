package renfe.com.model.entity;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@AttributeOverrides({ @AttributeOverride(name = "cdgoAlchabinf", column = @Column(name = "CDGO_ALCHABINF")),
		@AttributeOverride(name = "cdgoEstado", column = @Column(name = "CDGO_ESTADO")),
		@AttributeOverride(name = "fchaEstado", column = @Column(name = "FCHA_ESTADO")) })
public class Tbasg119EstahabinPK implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer cdgoAlchabinf;
	private Integer cdgoEstado;
	private String fchaEstado;

	public Integer getCdgoAlchabinf() {
		return this.cdgoAlchabinf;
	}

	public Integer getCdgoEstado() {
		return this.cdgoEstado;
	}

	public String getFchaEstado() {
		return this.fchaEstado;
	}

	public void setCdgoAlchabinf(Integer cdgoAlchabinf) {
		this.cdgoAlchabinf = cdgoAlchabinf;
	}

	public void setCdgoEstado(Integer cdgoEstado) {
		this.cdgoEstado = cdgoEstado;
	}

	public void setFchaEstado(String fchaEstado) {
		this.fchaEstado = fchaEstado;
	}

}