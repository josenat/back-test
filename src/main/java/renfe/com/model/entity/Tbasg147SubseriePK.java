package renfe.com.model.entity;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@AttributeOverrides({ @AttributeOverride(name = "cdgoSerie", column = @Column(name = "CDGO_SERIE")),
		@AttributeOverride(name = "cdgoSubserie", column = @Column(name = "CDGO_SUBSERIE")) })
public class Tbasg147SubseriePK implements Serializable {

	private static final long serialVersionUID = 1L;

	private String cdgoSerie;
	private String cdgoSubserie;

	public String getCdgoSerie() {
		return this.cdgoSerie;
	}

	public String getCdgoSubserie() {
		return this.cdgoSubserie;
	}

	public void setCdgoSerie(String cdgoSerie) {
		this.cdgoSerie = cdgoSerie;
	}

	public void setCdgoSubserie(String cdgoSubserie) {
		this.cdgoSubserie = cdgoSubserie;
	}

}