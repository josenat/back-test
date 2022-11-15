package renfe.com.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GetCdgoPersonaByNifAndMatriculaDTO {

	@Id
	@Column(name = "CDGO_PERSONA")
	private Integer cdgoPersona;

	public Integer getCdgoPersona() {
		return cdgoPersona;
	}

	public void setCdgoPersona(Integer cdgoPersona) {
		this.cdgoPersona = cdgoPersona;
	}
	
}
