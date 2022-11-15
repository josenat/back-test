package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TBASG138_CURSOSERI")
public class Tbasg138Cursoseri {

	@Id
	@Column(name = "CDGO_CURSOSERI")
	private Long cdgoCursoseri;

	@Column(name = "DESG_USUACT")
	private String desgUsuact;

	@Column(name = "FCHA_ACT")
	private Date fchaAct;

	@Column(name = "MRCA_ACTIVO")
	private String mrcaActivo;

	@ManyToOne
	@JoinColumn(name = "CDGO_CURSOMAT", nullable = false, foreignKey = @ForeignKey(name = "CDGO$CUR"))
	private Tbasg139Cursomate cdgoCursomat;
	
	@ManyToOne
	@JoinColumn(name = "CDGO_SERIE", nullable = true, foreignKey = @ForeignKey(name = "CDGO$SUB"))
	@JoinColumn(name = "CDGO_SUBSERIE", nullable = true, foreignKey = @ForeignKey(name = "CDGO$SUB"))
	private Tbasg147Subserie cdgoSubserie;

	public Long getCdgoCursoseri() {
		return this.cdgoCursoseri;
	}

	public void setCdgoCursoseri(Long cdgoCursoseri) {
		this.cdgoCursoseri = cdgoCursoseri;
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

	public Tbasg139Cursomate getCdgoCursomat() {
		return this.cdgoCursomat;
	}

	public String getCdgoSerie() {
		return this.cdgoSubserie.getTbasg147subseriepk().getCdgoSerie();
	}
	
	public String getCdgoSubserie() {
		return this.cdgoSubserie.getTbasg147subseriepk().getCdgoSubserie();
	}

	public void setCdgoCursomat(Tbasg139Cursomate cdgoCursomat) {
		this.cdgoCursomat = cdgoCursomat;
	}

	public void setCdgoSerie(String cdgoSerie) {
		this.cdgoSubserie.getTbasg147subseriepk().setCdgoSerie(cdgoSerie);
	}
	
	public void setCdgoSubserie(String cdgoSubserie) {
		this.cdgoSubserie.getTbasg147subseriepk().setCdgoSubserie(cdgoSubserie);
	}

}