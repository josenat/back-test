package renfe.com.model.entity;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TBASG118_ESTADOEXP" , schema = "PASG")
public class Tbasg118Estadoexp {

	@EmbeddedId
	private Tbasg118EstadoexpPK tbasg118estadoexppk;

	@Column(name = "DESG_USUACT")
	private String desgUsuact;

	@Column(name = "FCHA_ACT")
	private Date fchaAct;

	@Column(name = "MRCA_ACTIVO")
	private String mrcaActivo;

	public Tbasg118EstadoexpPK getTbasg118estadoexppk() {
		return this.tbasg118estadoexppk;
	}

	public void setTbasg118estadoexppk(Tbasg118EstadoexpPK tbasg118estadoexppk) {
		this.tbasg118estadoexppk = tbasg118estadoexppk;
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