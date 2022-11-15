package renfe.com.model.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TBASG195_REL_AREACT_REMITE")
public class Tbasg195RelAreactRemite {

	@EmbeddedId
	private Tbasg195RelAreactRemitePK tbasg195relareactremitepk;

	public Tbasg195RelAreactRemitePK getTbasg195relareactremitepk() {
		return this.tbasg195relareactremitepk;
	}

	public void setTbasg195relareactremitepk(Tbasg195RelAreactRemitePK tbasg195relareactremitepk) {
		this.tbasg195relareactremitepk = tbasg195relareactremitepk;
	}

}