package renfe.com.model.entity;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@AttributeOverrides({ @AttributeOverride(name = "cdgoCategoria", column = @Column(name = "CDGO_CATEGORIA")),
		@AttributeOverride(name = "cdgoCualificacion", column = @Column(name = "CDGO_CUALIFICACION")),
		@AttributeOverride(name = "cdgoPersona", column = @Column(name = "CDGO_PERSONA")),
		@AttributeOverride(name = "timeStamp", column = @Column(name = "TIME_STAMP")) })
public class Tbasg270HcoFcompPK implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer cdgoCategoria;
	private Integer cdgoCualificacion;
	private Integer cdgoPersona;
	private String timeStamp;

	public Integer getCdgoCategoria() {
		return this.cdgoCategoria;
	}

	public Integer getCdgoCualificacion() {
		return this.cdgoCualificacion;
	}

	public Integer getCdgoPersona() {
		return this.cdgoPersona;
	}

	public String getTimeStamp() {
		return this.timeStamp;
	}

	public void setCdgoCategoria(Integer cdgoCategoria) {
		this.cdgoCategoria = cdgoCategoria;
	}

	public void setCdgoCualificacion(Integer cdgoCualificacion) {
		this.cdgoCualificacion = cdgoCualificacion;
	}

	public void setCdgoPersona(Integer cdgoPersona) {
		this.cdgoPersona = cdgoPersona;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

}