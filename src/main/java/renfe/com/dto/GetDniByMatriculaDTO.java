package renfe.com.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GetDniByMatriculaDTO {
	
	@Id
	@Column (name="DESG_NIFPAS")
	private String nifPas;

	public String getNifPas() {
		return nifPas;
	}

	public void setNifPas(String nifPas) {
		this.nifPas = nifPas;
	}
	
	
}
