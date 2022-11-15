package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG066_CURPER")
public class Tbasg066Curper {

	@Id
	@Column(name = "T066_IDCURPER")
	private Long t066Idcurper;

	@Column(name = "T066_BLACTIVO")
	private String t066Blactivo;

	@Column(name = "T066_DEOBS")
	private String t066Deobs;

	@Column(name = "T066_FECULTACT")
	private Date t066Fecultact;

	@Column(name = "T066_FHCUR")
	private Date t066Fhcur;

	@NotNull
	@Column(name = "T066_IDCURSOS")
	private Integer t066Idcursos;

	@Column(name = "T066_USUULTACT")
	private String t066Usuultact;

	@ManyToOne
	@JoinColumn(name = "T066_IDCAL", nullable = false, foreignKey = @ForeignKey(name = "FK1AS066"))
	private Tbasg021Califi t066Idcal;

	@ManyToOne
	@JoinColumn(name = "T066_IDPERSON", nullable = false, foreignKey = @ForeignKey(name = "FK2AS066"))
	private Tbasg009Person t066Idperson;

	@ManyToOne
	@JoinColumn(name = "T066_IDESTENV", nullable = false, foreignKey = @ForeignKey(name = "FK4AS066"))
	private Tbasg075Estenv t066Idestenv;

	@ManyToOne
	@JoinColumn(name = "T066_IDINSTRU", nullable = false, foreignKey = @ForeignKey(name = "FK5AS066"))
	private Tbasg058Instru t066Idinstru;

	public Long getT066Idcurper() {
		return this.t066Idcurper;
	}

	public void setT066Idcurper(Long t066Idcurper) {
		this.t066Idcurper = t066Idcurper;
	}

	public String getT066Blactivo() {
		return this.t066Blactivo;
	}

	public String getT066Deobs() {
		return this.t066Deobs;
	}

	public Date getT066Fecultact() {
		return this.t066Fecultact;
	}

	public Date getT066Fhcur() {
		return this.t066Fhcur;
	}

	public Integer getT066Idcursos() {
		return this.t066Idcursos;
	}

	public String getT066Usuultact() {
		return this.t066Usuultact;
	}

	public void setT066Blactivo(String t066Blactivo) {
		this.t066Blactivo = t066Blactivo;
	}

	public void setT066Deobs(String t066Deobs) {
		this.t066Deobs = t066Deobs;
	}

	public void setT066Fecultact(Date t066Fecultact) {
		this.t066Fecultact = t066Fecultact;
	}

	public void setT066Fhcur(Date t066Fhcur) {
		this.t066Fhcur = t066Fhcur;
	}

	public void setT066Idcursos(Integer t066Idcursos) {
		this.t066Idcursos = t066Idcursos;
	}

	public void setT066Usuultact(String t066Usuultact) {
		this.t066Usuultact = t066Usuultact;
	}

	public Tbasg021Califi getT066Idcal() {
		return this.t066Idcal;
	}

	public Tbasg009Person getT066Idperson() {
		return this.t066Idperson;
	}

	public Tbasg075Estenv getT066Idestenv() {
		return this.t066Idestenv;
	}

	public Tbasg058Instru getT066Idinstru() {
		return this.t066Idinstru;
	}

	public void setT066Idcal(Tbasg021Califi t066Idcal) {
		this.t066Idcal = t066Idcal;
	}

	public void setT066Idperson(Tbasg009Person t066Idperson) {
		this.t066Idperson = t066Idperson;
	}

	public void setT066Idestenv(Tbasg075Estenv t066Idestenv) {
		this.t066Idestenv = t066Idestenv;
	}

	public void setT066Idinstru(Tbasg058Instru t066Idinstru) {
		this.t066Idinstru = t066Idinstru;
	}

}