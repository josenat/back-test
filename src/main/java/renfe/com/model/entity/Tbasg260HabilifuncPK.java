package renfe.com.model.entity;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@AttributeOverrides({ @AttributeOverride(name = "cdgoIdioma", column = @Column(name = "CDGO_IDIOMA")),
		@AttributeOverride(name = "cdgoMensaje", column = @Column(name = "CDGO_MENSAJE")),
		@AttributeOverride(name = "tipoHabi", column = @Column(name = "TIPO_HABI")) })
public class Tbasg260HabilifuncPK implements Serializable {

	private static final long serialVersionUID = 1L;

	private String cdgoIdioma;
	private String cdgoMensaje;
	private Integer tipoHabi;

	public String getCdgoIdioma() {
		return this.cdgoIdioma;
	}

	public String getCdgoMensaje() {
		return this.cdgoMensaje;
	}

	public Integer getTipoHabi() {
		return this.tipoHabi;
	}

	public void setCdgoIdioma(String cdgoIdioma) {
		this.cdgoIdioma = cdgoIdioma;
	}

	public void setCdgoMensaje(String cdgoMensaje) {
		this.cdgoMensaje = cdgoMensaje;
	}

	public void setTipoHabi(Integer tipoHabi) {
		this.tipoHabi = tipoHabi;
	}

}