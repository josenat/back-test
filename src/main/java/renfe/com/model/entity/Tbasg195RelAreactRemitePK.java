package renfe.com.model.entity;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@AttributeOverrides({ @AttributeOverride(name = "cdgoAreact", column = @Column(name = "CDGO_AREACT")),
		@AttributeOverride(name = "cdgoRemite", column = @Column(name = "CDGO_REMITE")) })
public class Tbasg195RelAreactRemitePK implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer cdgoAreact;
	private Integer cdgoRemite;

	public Integer getCdgoAreact() {
		return this.cdgoAreact;
	}

	public Integer getCdgoRemite() {
		return this.cdgoRemite;
	}

	public void setCdgoAreact(Integer cdgoAreact) {
		this.cdgoAreact = cdgoAreact;
	}

	public void setCdgoRemite(Integer cdgoRemite) {
		this.cdgoRemite = cdgoRemite;
	}

}