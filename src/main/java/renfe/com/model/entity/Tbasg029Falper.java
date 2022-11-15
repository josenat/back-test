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
@Table(name = "TBASG029_FALPER")
public class Tbasg029Falper {

	@Id
	@Column(name = "T029_IDFALTPER")
	private Long t029Idfaltper;

	@Column(name = "T029_BLACTIVO")
	private String t029Blactivo;

	@Column(name = "T029_DEOBS")
	private String t029Deobs;

	@Column(name = "T029_FECULTACT")
	private Date t029Fecultact;

	@NotNull
	@Column(name = "T029_FHFALTA")
	private Date t029Fhfalta;

	@NotNull
	@Column(name = "T029_IDPERSON")
	private Integer t029Idperson;

	@Column(name = "T029_USUULTACT")
	private String t029Usuultact;

	@ManyToOne
	@JoinColumn(name = "T029_IDMEDADO", nullable = false, foreignKey = @ForeignKey(name = "FK1AS029"))
	private Tbasg025Medado t029Idmedado;

	@ManyToOne
	@JoinColumn(name = "T029_IDFALT", nullable = false, foreignKey = @ForeignKey(name = "FK2AS029"))
	private Tbasg028Faltas t029Idfalt;

	@ManyToOne
	@JoinColumn(name = "T029_IDCONSID", nullable = false, foreignKey = @ForeignKey(name = "FK3AS029"))
	private Tbasg026Consid t029Idconsid;

	@ManyToOne
	@JoinColumn(name = "T029_IDSANCIO", nullable = false, foreignKey = @ForeignKey(name = "FK4AS029"))
	private Tbasg046Sancio t029Idsancio;

	@ManyToOne
	@JoinColumn(name = "T029_IDESTENV", nullable = false, foreignKey = @ForeignKey(name = "FK6AS029"))
	private Tbasg075Estenv t029Idestenv;

	public Long getT029Idfaltper() {
		return this.t029Idfaltper;
	}

	public void setT029Idfaltper(Long t029Idfaltper) {
		this.t029Idfaltper = t029Idfaltper;
	}

	public String getT029Blactivo() {
		return this.t029Blactivo;
	}

	public String getT029Deobs() {
		return this.t029Deobs;
	}

	public Date getT029Fecultact() {
		return this.t029Fecultact;
	}

	public Date getT029Fhfalta() {
		return this.t029Fhfalta;
	}

	public Integer getT029Idperson() {
		return this.t029Idperson;
	}

	public String getT029Usuultact() {
		return this.t029Usuultact;
	}

	public void setT029Blactivo(String t029Blactivo) {
		this.t029Blactivo = t029Blactivo;
	}

	public void setT029Deobs(String t029Deobs) {
		this.t029Deobs = t029Deobs;
	}

	public void setT029Fecultact(Date t029Fecultact) {
		this.t029Fecultact = t029Fecultact;
	}

	public void setT029Fhfalta(Date t029Fhfalta) {
		this.t029Fhfalta = t029Fhfalta;
	}

	public void setT029Idperson(Integer t029Idperson) {
		this.t029Idperson = t029Idperson;
	}

	public void setT029Usuultact(String t029Usuultact) {
		this.t029Usuultact = t029Usuultact;
	}

	public Tbasg025Medado getT029Idmedado() {
		return this.t029Idmedado;
	}

	public Tbasg028Faltas getT029Idfalt() {
		return this.t029Idfalt;
	}

	public Tbasg026Consid getT029Idconsid() {
		return this.t029Idconsid;
	}

	public Tbasg046Sancio getT029Idsancio() {
		return this.t029Idsancio;
	}

	public Tbasg075Estenv getT029Idestenv() {
		return this.t029Idestenv;
	}

	public void setT029Idmedado(Tbasg025Medado t029Idmedado) {
		this.t029Idmedado = t029Idmedado;
	}

	public void setT029Idfalt(Tbasg028Faltas t029Idfalt) {
		this.t029Idfalt = t029Idfalt;
	}

	public void setT029Idconsid(Tbasg026Consid t029Idconsid) {
		this.t029Idconsid = t029Idconsid;
	}

	public void setT029Idsancio(Tbasg046Sancio t029Idsancio) {
		this.t029Idsancio = t029Idsancio;
	}

	public void setT029Idestenv(Tbasg075Estenv t029Idestenv) {
		this.t029Idestenv = t029Idestenv;
	}

}