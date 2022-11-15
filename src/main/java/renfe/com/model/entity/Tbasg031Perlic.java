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
@Table(name = "TBASG031_PERLIC")
public class Tbasg031Perlic {

	@Id
	@Column(name = "T031_IDPERLIC")
	private Long t031Idperlic;

	@Column(name = "T031_BLACTIVO")
	private String t031Blactivo;

	@Column(name = "T031_DEOBS")
	private String t031Deobs;

	@Column(name = "T031_FECULTACT")
	private Date t031Fecultact;

	@NotNull
	@Column(name = "T031_FHLIC")
	private Date t031Fhlic;

	@Column(name = "T031_FHSUSREV")
	private Date t031Fhsusrev;

	@NotNull
	@Column(name = "T031_IDCAL")
	private Integer t031Idcal;

	@NotNull
	@Column(name = "T031_IDPERSON")
	private Integer t031Idperson;

	@Column(name = "T031_USUULTACT")
	private String t031Usuultact;

	@ManyToOne
	@JoinColumn(name = "T031_IDLICENC", nullable = false, foreignKey = @ForeignKey(name = "FK3AS031"))
	private Tbasg020Licenc t031Idlicenc;

	@ManyToOne
	@JoinColumn(name = "T031_IDESTADO", nullable = false, foreignKey = @ForeignKey(name = "FK4AS031"))
	private Tbasg073Estado t031Idestado;

	@ManyToOne
	@JoinColumn(name = "T031_IDESTADO_REFP", nullable = false, foreignKey = @ForeignKey(name = "FK5AS031"))
	private Tbasg073Estado t031IdestadoRefp;

	@ManyToOne
	@JoinColumn(name = "T031_IDESTENV", nullable = false, foreignKey = @ForeignKey(name = "FK6AS031"))
	private Tbasg075Estenv t031Idestenv;

	public Long getT031Idperlic() {
		return this.t031Idperlic;
	}

	public void setT031Idperlic(Long t031Idperlic) {
		this.t031Idperlic = t031Idperlic;
	}

	public String getT031Blactivo() {
		return this.t031Blactivo;
	}

	public String getT031Deobs() {
		return this.t031Deobs;
	}

	public Date getT031Fecultact() {
		return this.t031Fecultact;
	}

	public Date getT031Fhlic() {
		return this.t031Fhlic;
	}

	public Date getT031Fhsusrev() {
		return this.t031Fhsusrev;
	}

	public Integer getT031Idcal() {
		return this.t031Idcal;
	}

	public Integer getT031Idperson() {
		return this.t031Idperson;
	}

	public String getT031Usuultact() {
		return this.t031Usuultact;
	}

	public void setT031Blactivo(String t031Blactivo) {
		this.t031Blactivo = t031Blactivo;
	}

	public void setT031Deobs(String t031Deobs) {
		this.t031Deobs = t031Deobs;
	}

	public void setT031Fecultact(Date t031Fecultact) {
		this.t031Fecultact = t031Fecultact;
	}

	public void setT031Fhlic(Date t031Fhlic) {
		this.t031Fhlic = t031Fhlic;
	}

	public void setT031Fhsusrev(Date t031Fhsusrev) {
		this.t031Fhsusrev = t031Fhsusrev;
	}

	public void setT031Idcal(Integer t031Idcal) {
		this.t031Idcal = t031Idcal;
	}

	public void setT031Idperson(Integer t031Idperson) {
		this.t031Idperson = t031Idperson;
	}

	public void setT031Usuultact(String t031Usuultact) {
		this.t031Usuultact = t031Usuultact;
	}

	public Tbasg020Licenc getT031Idlicenc() {
		return this.t031Idlicenc;
	}

	public Tbasg073Estado getT031Idestado() {
		return this.t031Idestado;
	}

	public Tbasg073Estado getT031IdestadoRefp() {
		return this.t031IdestadoRefp;
	}

	public Tbasg075Estenv getT031Idestenv() {
		return this.t031Idestenv;
	}

	public void setT031Idlicenc(Tbasg020Licenc t031Idlicenc) {
		this.t031Idlicenc = t031Idlicenc;
	}

	public void setT031Idestado(Tbasg073Estado t031Idestado) {
		this.t031Idestado = t031Idestado;
	}

	public void setT031IdestadoRefp(Tbasg073Estado t031IdestadoRefp) {
		this.t031IdestadoRefp = t031IdestadoRefp;
	}

	public void setT031Idestenv(Tbasg075Estenv t031Idestenv) {
		this.t031Idestenv = t031Idestenv;
	}

}