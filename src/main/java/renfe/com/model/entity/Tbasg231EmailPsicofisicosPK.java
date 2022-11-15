package renfe.com.model.entity;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@AttributeOverrides({ @AttributeOverride(name = "codResidencia", column = @Column(name = "COD_RESIDENCIA")),
		@AttributeOverride(name = "matricula", column = @Column(name = "MATRICULA")) })
public class Tbasg231EmailPsicofisicosPK implements Serializable {

	private static final long serialVersionUID = 1L;

	private String codResidencia;
	private String matricula;

	public String getCodResidencia() {
		return this.codResidencia;
	}

	public String getMatricula() {
		return this.matricula;
	}

	public void setCodResidencia(String codResidencia) {
		this.codResidencia = codResidencia;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

}