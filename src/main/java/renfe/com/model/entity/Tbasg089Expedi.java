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
@Table(name = "TBASG089_EXPEDI")
public class Tbasg089Expedi {

	@Id
	@Column(name = "T089_IDEXP")
	private Long t089Idexp;

	@Column(name = "T089_BLACTIVO")
	private String t089Blactivo;

	@NotNull
	@Column(name = "T089_CODIGO")
	private String t089Codigo;

	@Column(name = "T089_DEOBS")
	private String t089Deobs;

	@Column(name = "T089_FECULTACT")
	private Date t089Fecultact;

	@Column(name = "T089_FHEXP")
	private Date t089Fhexp;

	@NotNull
	@Column(name = "T089_IDPERSON")
	private Integer t089Idperson;

	@Column(name = "T089_USUULTACT")
	private String t089Usuultact;

	@ManyToOne
	@JoinColumn(name = "T089_IDHABILI", nullable = false, foreignKey = @ForeignKey(name = "FK2AS089"))
	private Tbasg017Habili t089Idhabili;

	@ManyToOne
	@JoinColumn(name = "T089_IDAGRUPA", nullable = false, foreignKey = @ForeignKey(name = "FK3AS019"))
	private Tbasg077Agrupa t089Idagrupa;

	@ManyToOne
	@JoinColumn(name = "T089_IDESTEXP", nullable = false, foreignKey = @ForeignKey(name = "FK4AS019"))
	private Tbasg088Estexp t089Idestexp;

	public Long getT089Idexp() {
		return this.t089Idexp;
	}

	public void setT089Idexp(Long t089Idexp) {
		this.t089Idexp = t089Idexp;
	}

	public String getT089Blactivo() {
		return this.t089Blactivo;
	}

	public String getT089Codigo() {
		return this.t089Codigo;
	}

	public String getT089Deobs() {
		return this.t089Deobs;
	}

	public Date getT089Fecultact() {
		return this.t089Fecultact;
	}

	public Date getT089Fhexp() {
		return this.t089Fhexp;
	}

	public Integer getT089Idperson() {
		return this.t089Idperson;
	}

	public String getT089Usuultact() {
		return this.t089Usuultact;
	}

	public void setT089Blactivo(String t089Blactivo) {
		this.t089Blactivo = t089Blactivo;
	}

	public void setT089Codigo(String t089Codigo) {
		this.t089Codigo = t089Codigo;
	}

	public void setT089Deobs(String t089Deobs) {
		this.t089Deobs = t089Deobs;
	}

	public void setT089Fecultact(Date t089Fecultact) {
		this.t089Fecultact = t089Fecultact;
	}

	public void setT089Fhexp(Date t089Fhexp) {
		this.t089Fhexp = t089Fhexp;
	}

	public void setT089Idperson(Integer t089Idperson) {
		this.t089Idperson = t089Idperson;
	}

	public void setT089Usuultact(String t089Usuultact) {
		this.t089Usuultact = t089Usuultact;
	}

	public Tbasg017Habili getT089Idhabili() {
		return this.t089Idhabili;
	}

	public Tbasg077Agrupa getT089Idagrupa() {
		return this.t089Idagrupa;
	}

	public Tbasg088Estexp getT089Idestexp() {
		return this.t089Idestexp;
	}

	public void setT089Idhabili(Tbasg017Habili t089Idhabili) {
		this.t089Idhabili = t089Idhabili;
	}

	public void setT089Idagrupa(Tbasg077Agrupa t089Idagrupa) {
		this.t089Idagrupa = t089Idagrupa;
	}

	public void setT089Idestexp(Tbasg088Estexp t089Idestexp) {
		this.t089Idestexp = t089Idestexp;
	}

}