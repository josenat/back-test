package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG014_PERREV")
public class Tbasg014Perrev {

	@Id
	@Column(name = "T014_IDPERREV")
	private Long t014Idperrev;

	@Column(name = "T014_BLACTIVO")
	private String t014Blactivo;

	@NotNull
	@Column(name = "T014_CODIGO")
	private String t014Codigo;

	@NotNull
	@Column(name = "T014_EDADINF")
	private Integer t014Edadinf;

	@NotNull
	@Column(name = "T014_EDADSUP")
	private Integer t014Edadsup;

	@Column(name = "T014_FECULTACT")
	private Date t014Fecultact;

	@NotNull
	@Column(name = "T014_NOMBRE")
	private String t014Nombre;

	@NotNull
	@Column(name = "T014_NUMANOS")
	private Integer t014Numanos;

	@NotNull
	@Column(name = "T014_NUMMESES")
	private Integer t014Nummeses;

	@Column(name = "T014_USUULTACT")
	private String t014Usuultact;

	public Long getT014Idperrev() {
		return this.t014Idperrev;
	}

	public void setT014Idperrev(Long t014Idperrev) {
		this.t014Idperrev = t014Idperrev;
	}

	public String getT014Blactivo() {
		return this.t014Blactivo;
	}

	public String getT014Codigo() {
		return this.t014Codigo;
	}

	public Integer getT014Edadinf() {
		return this.t014Edadinf;
	}

	public Integer getT014Edadsup() {
		return this.t014Edadsup;
	}

	public Date getT014Fecultact() {
		return this.t014Fecultact;
	}

	public String getT014Nombre() {
		return this.t014Nombre;
	}

	public Integer getT014Numanos() {
		return this.t014Numanos;
	}

	public Integer getT014Nummeses() {
		return this.t014Nummeses;
	}

	public String getT014Usuultact() {
		return this.t014Usuultact;
	}

	public void setT014Blactivo(String t014Blactivo) {
		this.t014Blactivo = t014Blactivo;
	}

	public void setT014Codigo(String t014Codigo) {
		this.t014Codigo = t014Codigo;
	}

	public void setT014Edadinf(Integer t014Edadinf) {
		this.t014Edadinf = t014Edadinf;
	}

	public void setT014Edadsup(Integer t014Edadsup) {
		this.t014Edadsup = t014Edadsup;
	}

	public void setT014Fecultact(Date t014Fecultact) {
		this.t014Fecultact = t014Fecultact;
	}

	public void setT014Nombre(String t014Nombre) {
		this.t014Nombre = t014Nombre;
	}

	public void setT014Numanos(Integer t014Numanos) {
		this.t014Numanos = t014Numanos;
	}

	public void setT014Nummeses(Integer t014Nummeses) {
		this.t014Nummeses = t014Nummeses;
	}

	public void setT014Usuultact(String t014Usuultact) {
		this.t014Usuultact = t014Usuultact;
	}

}