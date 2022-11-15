package renfe.com.model.entity;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@AttributeOverrides({
		@AttributeOverride(name = "cdgoEntorno", column = @Column(name = "CDGO_ENTORNO")),
		@AttributeOverride(name = "cdgoLinea", column = @Column(name = "CDGO_LINEA")),
		@AttributeOverride(name = "cdgoOrigen", column = @Column(name = "CDGO_ORIGEN")),
		@AttributeOverride(name = "cdgoDestino", column = @Column(name = "CDGO_DESTINO"))
		})
public class Tbasg130EntorlinePK implements Serializable {

	private static final long serialVersionUID = 1L;

	private String cdgoDestino;
	private Integer cdgoEntorno;
	private String cdgoLinea;
	private String cdgoOrigen;

	public String getCdgoDestino() {
		return this.cdgoDestino;
	}

	public Integer getCdgoEntorno() {
		return this.cdgoEntorno;
	}

	public String getCdgoLinea() {
		return this.cdgoLinea;
	}

	public String getCdgoOrigen() {
		return this.cdgoOrigen;
	}

	public void setCdgoDestino(String cdgoDestino) {
		this.cdgoDestino = cdgoDestino;
	}

	public void setCdgoEntorno(Integer cdgoEntorno) {
		this.cdgoEntorno = cdgoEntorno;
	}

	public void setCdgoLinea(String cdgoLinea) {
		this.cdgoLinea = cdgoLinea;
	}

	public void setCdgoOrigen(String cdgoOrigen) {
		this.cdgoOrigen = cdgoOrigen;
	}

}