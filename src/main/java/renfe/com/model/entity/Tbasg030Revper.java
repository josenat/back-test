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
@Table(name = "TBASG030_REVPER")
public class Tbasg030Revper {

	@Id
	@Column(name = "T030_IDREV")
	private Long t030Idrev;

	@Column(name = "T030_BLACTIVO")
	private String t030Blactivo;

	@Column(name = "T030_DEOBS")
	private String t030Deobs;

	@Column(name = "T030_FECULTACT")
	private Date t030Fecultact;

	@Column(name = "T030_FHPROP")
	private Date t030Fhprop;

	@NotNull
	@Column(name = "T030_FHPROREV")
	private Date t030Fhprorev;

	@NotNull
	@Column(name = "T030_FHULTREV")
	private Date t030Fhultrev;

	@NotNull
	@Column(name = "T030_IDCAL")
	private Integer t030Idcal;

	@NotNull
	@Column(name = "T030_IDPERSON")
	private Integer t030Idperson;

	@Column(name = "T030_USUULTACT")
	private String t030Usuultact;

	@ManyToOne
	@JoinColumn(name = "T030_IDMEDPLA", nullable = false, foreignKey = @ForeignKey(name = "FK1AS030"))
	private Tbasg022Medpla t030Idmedpla;

	@ManyToOne
	@JoinColumn(name = "T030_IDTIPREV", nullable = false, foreignKey = @ForeignKey(name = "FK2AS030"))
	private Tbasg023Tiprev t030Idtiprev;

	@ManyToOne
	@JoinColumn(name = "T030_IDPERREV", nullable = false, foreignKey = @ForeignKey(name = "FK5AS030"))
	private Tbasg014Perrev t030Idperrev;

	@ManyToOne
	@JoinColumn(name = "T030_IDSANITARIO", nullable = false, foreignKey = @ForeignKey(name = "FK6AS030"))
	private Tbasg061Persan t030Idsanitario;

	@ManyToOne
	@JoinColumn(name = "T030_IDESTENV", nullable = false, foreignKey = @ForeignKey(name = "FK7AS030"))
	private Tbasg075Estenv t030Idestenv;

	public Long getT030Idrev() {
		return this.t030Idrev;
	}

	public void setT030Idrev(Long t030Idrev) {
		this.t030Idrev = t030Idrev;
	}

	public String getT030Blactivo() {
		return this.t030Blactivo;
	}

	public String getT030Deobs() {
		return this.t030Deobs;
	}

	public Date getT030Fecultact() {
		return this.t030Fecultact;
	}

	public Date getT030Fhprop() {
		return this.t030Fhprop;
	}

	public Date getT030Fhprorev() {
		return this.t030Fhprorev;
	}

	public Date getT030Fhultrev() {
		return this.t030Fhultrev;
	}

	public Integer getT030Idcal() {
		return this.t030Idcal;
	}

	public Integer getT030Idperson() {
		return this.t030Idperson;
	}

	public String getT030Usuultact() {
		return this.t030Usuultact;
	}

	public void setT030Blactivo(String t030Blactivo) {
		this.t030Blactivo = t030Blactivo;
	}

	public void setT030Deobs(String t030Deobs) {
		this.t030Deobs = t030Deobs;
	}

	public void setT030Fecultact(Date t030Fecultact) {
		this.t030Fecultact = t030Fecultact;
	}

	public void setT030Fhprop(Date t030Fhprop) {
		this.t030Fhprop = t030Fhprop;
	}

	public void setT030Fhprorev(Date t030Fhprorev) {
		this.t030Fhprorev = t030Fhprorev;
	}

	public void setT030Fhultrev(Date t030Fhultrev) {
		this.t030Fhultrev = t030Fhultrev;
	}

	public void setT030Idcal(Integer t030Idcal) {
		this.t030Idcal = t030Idcal;
	}

	public void setT030Idperson(Integer t030Idperson) {
		this.t030Idperson = t030Idperson;
	}

	public void setT030Usuultact(String t030Usuultact) {
		this.t030Usuultact = t030Usuultact;
	}

	public Tbasg022Medpla getT030Idmedpla() {
		return this.t030Idmedpla;
	}

	public Tbasg023Tiprev getT030Idtiprev() {
		return this.t030Idtiprev;
	}

	public Tbasg014Perrev getT030Idperrev() {
		return this.t030Idperrev;
	}

	public Tbasg061Persan getT030Idsanitario() {
		return this.t030Idsanitario;
	}

	public Tbasg075Estenv getT030Idestenv() {
		return this.t030Idestenv;
	}

	public void setT030Idmedpla(Tbasg022Medpla t030Idmedpla) {
		this.t030Idmedpla = t030Idmedpla;
	}

	public void setT030Idtiprev(Tbasg023Tiprev t030Idtiprev) {
		this.t030Idtiprev = t030Idtiprev;
	}

	public void setT030Idperrev(Tbasg014Perrev t030Idperrev) {
		this.t030Idperrev = t030Idperrev;
	}

	public void setT030Idsanitario(Tbasg061Persan t030Idsanitario) {
		this.t030Idsanitario = t030Idsanitario;
	}

	public void setT030Idestenv(Tbasg075Estenv t030Idestenv) {
		this.t030Idestenv = t030Idestenv;
	}

}