package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBASG147_SUBSERIE", schema = "PASG")
public class Tbasg147Subserie {

	@EmbeddedId
	private Tbasg147SubseriePK tbasg147subseriepk;

	@Column(name = "DESG_USUACT")
	private String desgUsuact;

	@Column(name = "FCHA_ACT")
	private Date fchaAct;

	@Column(name = "MRCA_ACTIVO")
	private String mrcaActivo;

	public Tbasg147SubseriePK getTbasg147subseriepk() {
		return this.tbasg147subseriepk;
	}

	public void setTbasg147subseriepk(Tbasg147SubseriePK tbasg147subseriepk) {
		this.tbasg147subseriepk = tbasg147subseriepk;
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