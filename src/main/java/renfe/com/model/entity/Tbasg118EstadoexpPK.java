package renfe.com.model.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@AttributeOverrides({ @AttributeOverride(name = "cdgoEstado", column = @Column(name = "CDGO_ESTADO")),
		@AttributeOverride(name = "cdgoExpedient", column = @Column(name = "CDGO_EXPEDIENT")),
		@AttributeOverride(name = "fchaEstado", column = @Column(name = "FCHA_ESTADO")) })
public class Tbasg118EstadoexpPK implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer cdgoEstado;
	private Integer cdgoExpedient;
	private Date fchaEstado;

	public Integer getCdgoEstado() {
		return this.cdgoEstado;
	}

	public Integer getCdgoExpedient() {
		return this.cdgoExpedient;
	}

	public Date getFchaEstado() {
		return this.fchaEstado;
	}

	public void setCdgoEstado(Integer cdgoEstado) {
		this.cdgoEstado = cdgoEstado;
	}

	public void setCdgoExpedient(Integer cdgoExpedient) {
		this.cdgoExpedient = cdgoExpedient;
	}

	public void setFchaEstado(Date fchaEstado) {
		this.fchaEstado = fchaEstado;
	}

}