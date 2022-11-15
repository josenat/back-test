package renfe.com.model.entity;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@AttributeOverrides({ @AttributeOverride(name = "cdgoEstado", column = @Column(name = "CDGO_ESTADO")),
		@AttributeOverride(name = "cdgoTit", column = @Column(name = "CDGO_TIT")),
		@AttributeOverride(name = "fchaEstado", column = @Column(name = "FCHA_ESTADO")) })
public class Tbasg117EstadotitPK implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer cdgoEstado;
	private Integer cdgoTit;
	private String fchaEstado;

	public Integer getCdgoEstado() {
		return this.cdgoEstado;
	}

	public Integer getCdgoTit() {
		return this.cdgoTit;
	}

	public String getFchaEstado() {
		return this.fchaEstado;
	}

	public void setCdgoEstado(Integer cdgoEstado) {
		this.cdgoEstado = cdgoEstado;
	}

	public void setCdgoTit(Integer cdgoTit) {
		this.cdgoTit = cdgoTit;
	}

	public void setFchaEstado(String fchaEstado) {
		this.fchaEstado = fchaEstado;
	}

}