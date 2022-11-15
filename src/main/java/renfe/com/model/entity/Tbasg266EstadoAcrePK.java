package renfe.com.model.entity;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@AttributeOverrides({ @AttributeOverride(name = "cdgoAcredita", column = @Column(name = "CDGO_ACREDITA")),
		@AttributeOverride(name = "cdgoEstado", column = @Column(name = "CDGO_ESTADO")),
		@AttributeOverride(name = "fchaEstado", column = @Column(name = "FCHA_ESTADO")) })
public class Tbasg266EstadoAcrePK implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer cdgoAcredita;
	private String cdgoEstado;
	private String fchaEstado;

	public Integer getCdgoAcredita() {
		return this.cdgoAcredita;
	}

	public String getCdgoEstado() {
		return this.cdgoEstado;
	}

	public String getFchaEstado() {
		return this.fchaEstado;
	}

	public void setCdgoAcredita(Integer cdgoAcredita) {
		this.cdgoAcredita = cdgoAcredita;
	}

	public void setCdgoEstado(String cdgoEstado) {
		this.cdgoEstado = cdgoEstado;
	}

	public void setFchaEstado(String fchaEstado) {
		this.fchaEstado = fchaEstado;
	}

}