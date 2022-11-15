package renfe.com.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG904_TMP_PERSONA")
public class Tbasg904TmpPersona {

	@Id
	@Column(name = "ID_SOCPERSONA")
	private Long idSocpersona;

	@NotNull
	@Column(name = "CDGO_PERSONA")
	private Integer cdgoPersona;

	@NotNull
	@Column(name = "DESG_MATRICULA")
	private Integer desgMatricula;

	public Long getIdSocpersona() {
		return this.idSocpersona;
	}

	public void setIdSocpersona(Long idSocpersona) {
		this.idSocpersona = idSocpersona;
	}

	public Integer getCdgoPersona() {
		return this.cdgoPersona;
	}

	public Integer getDesgMatricula() {
		return this.desgMatricula;
	}

	public void setCdgoPersona(Integer cdgoPersona) {
		this.cdgoPersona = cdgoPersona;
	}

	public void setDesgMatricula(Integer desgMatricula) {
		this.desgMatricula = desgMatricula;
	}

}