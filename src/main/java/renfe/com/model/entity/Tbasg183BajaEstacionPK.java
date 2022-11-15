package renfe.com.model.entity;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@AttributeOverrides({ @AttributeOverride(name = "cdgoEstacion", column = @Column(name = "CDGO_ESTACION")),
		@AttributeOverride(name = "cdgoLinea", column = @Column(name = "CDGO_LINEA")) })
public class Tbasg183BajaEstacionPK implements Serializable {

	private static final long serialVersionUID = 1L;

	private String cdgoEstacion;
	private String cdgoLinea;

	public String getCdgoEstacion() {
		return this.cdgoEstacion;
	}

	public String getCdgoLinea() {
		return this.cdgoLinea;
	}

	public void setCdgoEstacion(String cdgoEstacion) {
		this.cdgoEstacion = cdgoEstacion;
	}

	public void setCdgoLinea(String cdgoLinea) {
		this.cdgoLinea = cdgoLinea;
	}

}