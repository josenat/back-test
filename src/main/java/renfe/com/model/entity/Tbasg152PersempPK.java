package renfe.com.model.entity;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@AttributeOverrides({ @AttributeOverride(name = "cdgoEmpresa", column = @Column(name = "CDGO_EMPRESA")),
		@AttributeOverride(name = "cdgoPersona", column = @Column(name = "CDGO_PERSONA")) })
public class Tbasg152PersempPK implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer cdgoEmpresa;
	private Integer cdgoPersona;

	public Integer getCdgoEmpresa() {
		return this.cdgoEmpresa;
	}

	public Integer getCdgoPersona() {
		return this.cdgoPersona;
	}

	public void setCdgoEmpresa(Integer cdgoEmpresa) {
		this.cdgoEmpresa = cdgoEmpresa;
	}

	public void setCdgoPersona(Integer cdgoPersona) {
		this.cdgoPersona = cdgoPersona;
	}

}