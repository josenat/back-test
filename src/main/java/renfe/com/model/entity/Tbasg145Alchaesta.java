package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TBASG145_ALCHAESTA")
public class Tbasg145Alchaesta {

	@EmbeddedId
	private Tbasg145AlchaestaPK tbasg145alchaestapk;

	@Column(name = "DESG_USUACT")
	private String desgUsuact;

	@Column(name = "FCHA_ACT")
	private Date fchaAct;

	@Column(name = "MRCA_ACTIVO")
	private String mrcaActivo;

	public Tbasg145AlchaestaPK getTbasg145alchaestapk() {
		return this.tbasg145alchaestapk;
	}

	public void setTbasg145alchaestapk(Tbasg145AlchaestaPK tbasg145alchaestapk) {
		this.tbasg145alchaestapk = tbasg145alchaestapk;
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