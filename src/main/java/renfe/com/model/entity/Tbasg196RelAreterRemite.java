package renfe.com.model.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TBASG196_REL_ARETER_REMITE")
public class Tbasg196RelAreterRemite {

	@EmbeddedId
	private Tbasg196RelAreterRemitePK tbasg196relareterremitepk;

	public Tbasg196RelAreterRemitePK getTbasg196relareterremitepk() {
		return this.tbasg196relareterremitepk;
	}

	public void setTbasg196relareterremitepk(Tbasg196RelAreterRemitePK tbasg196relareterremitepk) {
		this.tbasg196relareterremitepk = tbasg196relareterremitepk;
	}

}