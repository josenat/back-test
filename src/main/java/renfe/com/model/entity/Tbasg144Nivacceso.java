package renfe.com.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG144_NIVACCESO", schema = "PASG")
public class Tbasg144Nivacceso {

	@Id
	@Column(name = "CDGO_NIVEL")
	private Long cdgoNivel;

	@NotNull
	@Column(name = "CDGO_ARETER")
	private Integer cdgoAreter;

	public Long getCdgoNivel() {
		return this.cdgoNivel;
	}

	public void setCdgoNivel(Long cdgoNivel) {
		this.cdgoNivel = cdgoNivel;
	}

	public Integer getCdgoAreter() {
		return this.cdgoAreter;
	}

	public void setCdgoAreter(Integer cdgoAreter) {
		this.cdgoAreter = cdgoAreter;
	}

}