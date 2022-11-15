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
@Table(name = "TBASG027_RECPER")
public class Tbasg027Recper {

	@Id
	@Column(name = "T027_IDRECPER")
	private Long t027Idrecper;

	@Column(name = "T027_BLACTIVO")
	private String t027Blactivo;

	@Column(name = "T027_DEOBS")
	private String t027Deobs;

	@Column(name = "T027_FECULTACT")
	private Date t027Fecultact;

	@Column(name = "T027_FHPROP")
	private Date t027Fhprop;

	@NotNull
	@Column(name = "T027_FHPROREC")
	private Date t027Fhprorec;

	@NotNull
	@Column(name = "T027_FHULTREC")
	private Date t027Fhultrec;

	@NotNull
	@Column(name = "T027_IDCAL")
	private Integer t027Idcal;

	@NotNull
	@Column(name = "T027_IDPERREC")
	private Integer t027Idperrec;

	@NotNull
	@Column(name = "T027_IDPERSON")
	private Integer t027Idperson;

	@NotNull
	@Column(name = "T027_IDREC")
	private Integer t027Idrec;

	@Column(name = "T027_USUULTACT")
	private String t027Usuultact;

	@ManyToOne
	@JoinColumn(name = "T027_IDMEDPLA", nullable = false, foreignKey = @ForeignKey(name = "FK5AS027"))
	private Tbasg022Medpla t027Idmedpla;

	@ManyToOne
	@JoinColumn(name = "T027_IDINSTRU", nullable = false, foreignKey = @ForeignKey(name = "FK6AS027"))
	private Tbasg058Instru t027Idinstru;

	@ManyToOne
	@JoinColumn(name = "T027_IDESTENV", nullable = false, foreignKey = @ForeignKey(name = "FK7AS027"))
	private Tbasg075Estenv t027Idestenv;

	public Long getT027Idrecper() {
		return this.t027Idrecper;
	}

	public void setT027Idrecper(Long t027Idrecper) {
		this.t027Idrecper = t027Idrecper;
	}

	public String getT027Blactivo() {
		return this.t027Blactivo;
	}

	public String getT027Deobs() {
		return this.t027Deobs;
	}

	public Date getT027Fecultact() {
		return this.t027Fecultact;
	}

	public Date getT027Fhprop() {
		return this.t027Fhprop;
	}

	public Date getT027Fhprorec() {
		return this.t027Fhprorec;
	}

	public Date getT027Fhultrec() {
		return this.t027Fhultrec;
	}

	public Integer getT027Idcal() {
		return this.t027Idcal;
	}

	public Integer getT027Idperrec() {
		return this.t027Idperrec;
	}

	public Integer getT027Idperson() {
		return this.t027Idperson;
	}

	public Integer getT027Idrec() {
		return this.t027Idrec;
	}

	public String getT027Usuultact() {
		return this.t027Usuultact;
	}

	public void setT027Blactivo(String t027Blactivo) {
		this.t027Blactivo = t027Blactivo;
	}

	public void setT027Deobs(String t027Deobs) {
		this.t027Deobs = t027Deobs;
	}

	public void setT027Fecultact(Date t027Fecultact) {
		this.t027Fecultact = t027Fecultact;
	}

	public void setT027Fhprop(Date t027Fhprop) {
		this.t027Fhprop = t027Fhprop;
	}

	public void setT027Fhprorec(Date t027Fhprorec) {
		this.t027Fhprorec = t027Fhprorec;
	}

	public void setT027Fhultrec(Date t027Fhultrec) {
		this.t027Fhultrec = t027Fhultrec;
	}

	public void setT027Idcal(Integer t027Idcal) {
		this.t027Idcal = t027Idcal;
	}

	public void setT027Idperrec(Integer t027Idperrec) {
		this.t027Idperrec = t027Idperrec;
	}

	public void setT027Idperson(Integer t027Idperson) {
		this.t027Idperson = t027Idperson;
	}

	public void setT027Idrec(Integer t027Idrec) {
		this.t027Idrec = t027Idrec;
	}

	public void setT027Usuultact(String t027Usuultact) {
		this.t027Usuultact = t027Usuultact;
	}

	public Tbasg022Medpla getT027Idmedpla() {
		return this.t027Idmedpla;
	}

	public Tbasg058Instru getT027Idinstru() {
		return this.t027Idinstru;
	}

	public Tbasg075Estenv getT027Idestenv() {
		return this.t027Idestenv;
	}

	public void setT027Idmedpla(Tbasg022Medpla t027Idmedpla) {
		this.t027Idmedpla = t027Idmedpla;
	}

	public void setT027Idinstru(Tbasg058Instru t027Idinstru) {
		this.t027Idinstru = t027Idinstru;
	}

	public void setT027Idestenv(Tbasg075Estenv t027Idestenv) {
		this.t027Idestenv = t027Idestenv;
	}

}