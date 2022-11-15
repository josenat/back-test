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
@Table(name = "TBASG032_PERHAB")
public class Tbasg032Perhab {

	@Id
	@Column(name = "T032_IDPERHAB")
	private Long t032Idperhab;

	@Column(name = "T032_BLACTIVO")
	private String t032Blactivo;

	@Column(name = "T032_DEOBS")
	private String t032Deobs;

	@Column(name = "T032_FECULTACT")
	private Date t032Fecultact;

	@NotNull
	@Column(name = "T032_FHHAB")
	private Date t032Fhhab;

	@Column(name = "T032_FHPRIMREC")
	private Date t032Fhprimrec;

	@NotNull
	@Column(name = "T032_FHPROXREC")
	private Date t032Fhproxrec;

	@Column(name = "T032_FHSUSREV")
	private Date t032Fhsusrev;

	@NotNull
	@Column(name = "T032_IDCAL")
	private Integer t032Idcal;

	@NotNull
	@Column(name = "T032_IDHABILI")
	private Integer t032Idhabili;

	@NotNull
	@Column(name = "T032_IDPERSON")
	private Integer t032Idperson;

	@Column(name = "T032_USUULTACT")
	private String t032Usuultact;

	@ManyToOne
	@JoinColumn(name = "T032_IDESTHAB", nullable = false, foreignKey = @ForeignKey(name = "FK10A032"))
	private Tbasg086Esthab t032Idesthab;

	@ManyToOne
	@JoinColumn(name = "T032_IDEST1", nullable = false, foreignKey = @ForeignKey(name = "FK4AS032"))
	private Tbasg053Estaci t032Idest1;

	@ManyToOne
	@JoinColumn(name = "T032_IDEST2", nullable = false, foreignKey = @ForeignKey(name = "FK5AS032"))
	private Tbasg053Estaci t032Idest2;

	@ManyToOne
	@JoinColumn(name = "T032_IDINSTRU", nullable = false, foreignKey = @ForeignKey(name = "FK6AS032"))
	private Tbasg058Instru t032Idinstru;

	@ManyToOne
	@JoinColumn(name = "T032_IDESTADO", nullable = false, foreignKey = @ForeignKey(name = "FK7AS032"))
	private Tbasg073Estado t032Idestado;

	@ManyToOne
	@JoinColumn(name = "T032_IDESTENV", nullable = false, foreignKey = @ForeignKey(name = "FK8AS032"))
	private Tbasg075Estenv t032Idestenv;

	@ManyToOne
	@JoinColumn(name = "T032_IDAGRUPA", nullable = false, foreignKey = @ForeignKey(name = "FK9AS032"))
	private Tbasg077Agrupa t032Idagrupa;

	public Long getT032Idperhab() {
		return this.t032Idperhab;
	}

	public void setT032Idperhab(Long t032Idperhab) {
		this.t032Idperhab = t032Idperhab;
	}

	public String getT032Blactivo() {
		return this.t032Blactivo;
	}

	public String getT032Deobs() {
		return this.t032Deobs;
	}

	public Date getT032Fecultact() {
		return this.t032Fecultact;
	}

	public Date getT032Fhhab() {
		return this.t032Fhhab;
	}

	public Date getT032Fhprimrec() {
		return this.t032Fhprimrec;
	}

	public Date getT032Fhproxrec() {
		return this.t032Fhproxrec;
	}

	public Date getT032Fhsusrev() {
		return this.t032Fhsusrev;
	}

	public Integer getT032Idcal() {
		return this.t032Idcal;
	}

	public Integer getT032Idhabili() {
		return this.t032Idhabili;
	}

	public Integer getT032Idperson() {
		return this.t032Idperson;
	}

	public String getT032Usuultact() {
		return this.t032Usuultact;
	}

	public void setT032Blactivo(String t032Blactivo) {
		this.t032Blactivo = t032Blactivo;
	}

	public void setT032Deobs(String t032Deobs) {
		this.t032Deobs = t032Deobs;
	}

	public void setT032Fecultact(Date t032Fecultact) {
		this.t032Fecultact = t032Fecultact;
	}

	public void setT032Fhhab(Date t032Fhhab) {
		this.t032Fhhab = t032Fhhab;
	}

	public void setT032Fhprimrec(Date t032Fhprimrec) {
		this.t032Fhprimrec = t032Fhprimrec;
	}

	public void setT032Fhproxrec(Date t032Fhproxrec) {
		this.t032Fhproxrec = t032Fhproxrec;
	}

	public void setT032Fhsusrev(Date t032Fhsusrev) {
		this.t032Fhsusrev = t032Fhsusrev;
	}

	public void setT032Idcal(Integer t032Idcal) {
		this.t032Idcal = t032Idcal;
	}

	public void setT032Idhabili(Integer t032Idhabili) {
		this.t032Idhabili = t032Idhabili;
	}

	public void setT032Idperson(Integer t032Idperson) {
		this.t032Idperson = t032Idperson;
	}

	public void setT032Usuultact(String t032Usuultact) {
		this.t032Usuultact = t032Usuultact;
	}

	public Tbasg086Esthab getT032Idesthab() {
		return this.t032Idesthab;
	}

	public Tbasg053Estaci getT032Idest1() {
		return this.t032Idest1;
	}

	public Tbasg053Estaci getT032Idest2() {
		return this.t032Idest2;
	}

	public Tbasg058Instru getT032Idinstru() {
		return this.t032Idinstru;
	}

	public Tbasg073Estado getT032Idestado() {
		return this.t032Idestado;
	}

	public Tbasg075Estenv getT032Idestenv() {
		return this.t032Idestenv;
	}

	public Tbasg077Agrupa getT032Idagrupa() {
		return this.t032Idagrupa;
	}

	public void setT032Idesthab(Tbasg086Esthab t032Idesthab) {
		this.t032Idesthab = t032Idesthab;
	}

	public void setT032Idest1(Tbasg053Estaci t032Idest1) {
		this.t032Idest1 = t032Idest1;
	}

	public void setT032Idest2(Tbasg053Estaci t032Idest2) {
		this.t032Idest2 = t032Idest2;
	}

	public void setT032Idinstru(Tbasg058Instru t032Idinstru) {
		this.t032Idinstru = t032Idinstru;
	}

	public void setT032Idestado(Tbasg073Estado t032Idestado) {
		this.t032Idestado = t032Idestado;
	}

	public void setT032Idestenv(Tbasg075Estenv t032Idestenv) {
		this.t032Idestenv = t032Idestenv;
	}

	public void setT032Idagrupa(Tbasg077Agrupa t032Idagrupa) {
		this.t032Idagrupa = t032Idagrupa;
	}

}