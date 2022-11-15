package renfe.com.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG259_IDIOMA", schema = "PASG")
public class Tbasg259Idioma {

	@Id
	@Column(name = "CDGO_IDIOMA")
	private String cdgoIdioma;

	@NotNull
	@Column(name = "DESG_IDIOMA")
	private String desgIdioma;

	@Column(name = "MRCA_ACTIVO")
	private String mrcaActivo;

	public String getCdgoIdioma() {
		return this.cdgoIdioma;
	}

	public void setCdgoIdioma(String cdgoIdioma) {
		this.cdgoIdioma = cdgoIdioma;
	}

	public String getDesgIdioma() {
		return this.desgIdioma;
	}

	public String getMrcaActivo() {
		return this.mrcaActivo;
	}

	public void setDesgIdioma(String desgIdioma) {
		this.desgIdioma = desgIdioma;
	}

	public void setMrcaActivo(String mrcaActivo) {
		this.mrcaActivo = mrcaActivo;
	}

}