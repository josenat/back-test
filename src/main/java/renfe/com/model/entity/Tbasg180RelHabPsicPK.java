package renfe.com.model.entity;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@AttributeOverrides({ @AttributeOverride(name = "cdgoPsicamb", column = @Column(name = "CDGO_PSICAMB")),
		@AttributeOverride(name = "cdgoTipohab", column = @Column(name = "CDGO_TIPOHAB")) })
public class Tbasg180RelHabPsicPK implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer cdgoPsicamb;
	private Integer cdgoTipohab;

	public Integer getCdgoPsicamb() {
		return this.cdgoPsicamb;
	}

	public Integer getCdgoTipohab() {
		return this.cdgoTipohab;
	}

	public void setCdgoPsicamb(Integer cdgoPsicamb) {
		this.cdgoPsicamb = cdgoPsicamb;
	}

	public void setCdgoTipohab(Integer cdgoTipohab) {
		this.cdgoTipohab = cdgoTipohab;
	}

}