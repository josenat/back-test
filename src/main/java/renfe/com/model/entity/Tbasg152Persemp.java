package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TBASG152_PERSEMP", schema = "PASG")
public class Tbasg152Persemp {

    public Tbasg152Persemp(Tbasg152PersempPK tbasg152persemppk,String desgUsuact, Date fchaAct, String mrcaActivo) {
    	this.tbasg152persemppk = tbasg152persemppk;
    	this.desgUsuact = desgUsuact;
    	this.fchaAct = fchaAct;
    	this.mrcaActivo = mrcaActivo;
		
	}
	
	public Tbasg152Persemp() {
		
	}

	@EmbeddedId
	private Tbasg152PersempPK tbasg152persemppk;

	@Column(name = "DESG_USUACT")
	private String desgUsuact;

	@Column(name = "FCHA_ACT")
	private Date fchaAct;

	@Column(name = "MRCA_ACTIVO")
	private String mrcaActivo;

	public Tbasg152PersempPK getTbasg152persemppk() {
		return this.tbasg152persemppk;
	}

	public void setTbasg152persemppk(Tbasg152PersempPK tbasg152persemppk) {
		this.tbasg152persemppk = tbasg152persemppk;
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