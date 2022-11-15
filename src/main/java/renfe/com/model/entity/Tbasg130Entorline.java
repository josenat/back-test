package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TBASG130_ENTORLINE")
public class Tbasg130Entorline {

	@EmbeddedId
	private Tbasg130EntorlinePK tbasg130entorlinepk;

	@Column(name = "DESG_USUACT")
	private String desgUsuact;

	@Column(name = "FCHA_ACT")
	private Date fchaAct;

	@Column(name = "MRCA_ACTIVO")
	private char mrcaActivo;

	public Tbasg130EntorlinePK getTbasg130entorlinepk() {
		return this.tbasg130entorlinepk;
	}

	public void setTbasg130entorlinepk(Tbasg130EntorlinePK tbasg130entorlinepk) {
		this.tbasg130entorlinepk = tbasg130entorlinepk;
	}

	public String getDesgUsuact() {
		return this.desgUsuact;
	}

	public Date getFchaAct() {
		return this.fchaAct;
	}

	public char getMrcaActivo() {
		return this.mrcaActivo;
	}

	public void setDesgUsuact(String desgUsuact) {
		this.desgUsuact = desgUsuact;
	}

	public void setFchaAct(Date fchaAct) {
		this.fchaAct = fchaAct;
	}

	public void setMrcaActivo(char mrcaActivo) {
		this.mrcaActivo = mrcaActivo;
	}

}