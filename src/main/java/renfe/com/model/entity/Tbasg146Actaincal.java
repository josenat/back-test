package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TBASG146_ACTAINCAL", schema = "PASG")
public class Tbasg146Actaincal {

	@EmbeddedId
	private Tbasg146ActaincalPK tbasg146actaincalpk;

	@Column(name = "CDGO_IDEXA")
	private String cdgoIdexa;

	@Column(name = "DESG_USUACT")
	private String desgUsuact;

	@Column(name = "FCHA_ACT")
	private Date fchaAct;

	@Column(name = "FCHA_CURSO")
	private Date fchaCurso;

	@Column(name = "MRCA_ACTIVO")
	private String mrcaActivo;
	
	@Column(name = "CDGO_CALIFI")
	private Integer cdgoCalifi;
	
	@Column(name = "CDGO_IDINSTRU")
	private String cdgoIdinstru;


	public Tbasg146ActaincalPK getTbasg146actaincalpk() {
		return this.tbasg146actaincalpk;
	}

	public void setTbasg146actaincalpk(Tbasg146ActaincalPK tbasg146actaincalpk) {
		this.tbasg146actaincalpk = tbasg146actaincalpk;
	}

	public String getCdgoIdexa() {
		return this.cdgoIdexa;
	}

	public String getDesgUsuact() {
		return this.desgUsuact;
	}

	public Date getFchaAct() {
		return this.fchaAct;
	}

	public Date getFchaCurso() {
		return this.fchaCurso;
	}

	public String getMrcaActivo() {
		return this.mrcaActivo;
	}

	public void setCdgoIdexa(String cdgoIdexa) {
		this.cdgoIdexa = cdgoIdexa;
	}

	public void setDesgUsuact(String desgUsuact) {
		this.desgUsuact = desgUsuact;
	}

	public void setFchaAct(Date fchaAct) {
		this.fchaAct = fchaAct;
	}

	public void setFchaCurso(Date fchaCurso) {
		this.fchaCurso = fchaCurso;
	}

	public void setMrcaActivo(String mrcaActivo) {
		this.mrcaActivo = mrcaActivo;
	}

	public Integer getCdgoCalifi() {
		return cdgoCalifi;
	}

	public void setCdgoCalifi(Integer cdgoCalifi) {
		this.cdgoCalifi = cdgoCalifi;
	}

	public String getCdgoIdinstru() {
		return cdgoIdinstru;
	}

	public void setCdgoIdinstru(String cdgoIdinstru) {
		this.cdgoIdinstru = cdgoIdinstru;
	}
	
	

}