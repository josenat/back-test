package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TBASG119_ESTAHABIN")
public class Tbasg119Estahabin {

	@EmbeddedId
	private Tbasg119EstahabinPK tbasg119estahabinpk;

	@Column(name = "DESG_USUACT")
	private String desgUsuact;

	@Column(name = "FCHA_ACT")
	private Date fchaAct;

	@Column(name = "MRCA_ACTIVO")
	private String mrcaActivo;

	public Tbasg119EstahabinPK getTbasg119estahabinpk() {
		return this.tbasg119estahabinpk;
	}

	public void setTbasg119estahabinpk(Tbasg119EstahabinPK tbasg119estahabinpk) {
		this.tbasg119estahabinpk = tbasg119estahabinpk;
	}

	public String getDesgUsuact() {
		return this.desgUsuact;
	}

	public Date getFchaAct() {
		return this.fchaAct;
	}

	public String getMrcaActivo() {
		return this.mrcaActivo;
	}

	public void setDesgUsuact(String desgUsuact) {
		this.desgUsuact = desgUsuact;
	}

	public void setFchaAct(Date fchaAct) {
		this.fchaAct = fchaAct;
	}

	public void setMrcaActivo(String mrcaActivo) {
		this.mrcaActivo = mrcaActivo;
	}

}