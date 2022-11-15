package renfe.com.model.entity;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@AttributeOverrides({ @AttributeOverride(name = "cdgoAreter", column = @Column(name = "CDGO_ARETER")),
		@AttributeOverride(name = "cdgoRemite", column = @Column(name = "CDGO_REMITE")) })
public class Tbasg196RelAreterRemitePK implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer cdgoAreter;
	private Integer cdgoRemite;

	public Integer getCdgoAreter() {
		return this.cdgoAreter;
	}

	public Integer getCdgoRemite() {
		return this.cdgoRemite;
	}

	public void setCdgoAreter(Integer cdgoAreter) {
		this.cdgoAreter = cdgoAreter;
	}

	public void setCdgoRemite(Integer cdgoRemite) {
		this.cdgoRemite = cdgoRemite;
	}

}