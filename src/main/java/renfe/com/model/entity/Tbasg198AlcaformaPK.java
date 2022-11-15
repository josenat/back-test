package renfe.com.model.entity;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@AttributeOverrides({ @AttributeOverride(name = "cdgoDestino", column = @Column(name = "CDGO_DESTINO")),
		@AttributeOverride(name = "cdgoLinea", column = @Column(name = "CDGO_LINEA")),
		@AttributeOverride(name = "cdgoOrigen", column = @Column(name = "CDGO_ORIGEN")),
		@AttributeOverride(name = "cdgoSolicitud", column = @Column(name = "CDGO_SOLICITUD")) })
public class Tbasg198AlcaformaPK implements Serializable {

	private static final long serialVersionUID = 1L;

	private String cdgoDestino;
	private String cdgoLinea;
	private String cdgoOrigen;
	private Integer cdgoSolicitud;

	public String getCdgoDestino() {
		return this.cdgoDestino;
	}

	public String getCdgoLinea() {
		return this.cdgoLinea;
	}

	public String getCdgoOrigen() {
		return this.cdgoOrigen;
	}

	public Integer getCdgoSolicitud() {
		return this.cdgoSolicitud;
	}

	public void setCdgoDestino(String cdgoDestino) {
		this.cdgoDestino = cdgoDestino;
	}

	public void setCdgoLinea(String cdgoLinea) {
		this.cdgoLinea = cdgoLinea;
	}

	public void setCdgoOrigen(String cdgoOrigen) {
		this.cdgoOrigen = cdgoOrigen;
	}

	public void setCdgoSolicitud(Integer cdgoSolicitud) {
		this.cdgoSolicitud = cdgoSolicitud;
	}

}