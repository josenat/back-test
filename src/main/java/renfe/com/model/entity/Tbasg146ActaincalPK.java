package renfe.com.model.entity;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@AttributeOverrides({ @AttributeOverride(name = "cdgoActaform", column = @Column(name = "CDGO_ACTAFORM")),
		@AttributeOverride(name = "desgTipocurso", column = @Column(name = "DESG_TIPOCURSO")) })
public class Tbasg146ActaincalPK implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer cdgoActaform;
	private String desgTipocurso;

	public Integer getCdgoActaform() {
		return this.cdgoActaform;
	}

	public String getDesgTipocurso() {
		return this.desgTipocurso;
	}

	public void setCdgoActaform(Integer cdgoActaform) {
		this.cdgoActaform = cdgoActaform;
	}

	public void setDesgTipocurso(String desgTipocurso) {
		this.desgTipocurso = desgTipocurso;
	}

}