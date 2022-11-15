package renfe.com.model.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG260_HABILIFUNC", schema = "PASG")
public class Tbasg260Habilifunc {

	@EmbeddedId
	private Tbasg260HabilifuncPK tbasg260habilifuncpk;

	@NotNull
	@Column(name = "DESC_MENSAJE")
	private String descMensaje;

	public Tbasg260HabilifuncPK getTbasg260habilifuncpk() {
		return this.tbasg260habilifuncpk;
	}

	public void setTbasg260habilifuncpk(Tbasg260HabilifuncPK tbasg260habilifuncpk) {
		this.tbasg260habilifuncpk = tbasg260habilifuncpk;
	}

	public String getDescMensaje() {
		return this.descMensaje;
	}

	public void setDescMensaje(String descMensaje) {
		this.descMensaje = descMensaje;
	}

}