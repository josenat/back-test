package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG064_SERIE")
public class Tbasg064Serie {

	@Id
	@Column(name = "T064_IDSERIE")
	private Long t064Idserie;

	@Column(name = "T064_BLACTIVO")
	private String t064Blactivo;

	@NotNull
	@Column(name = "T064_CODIGO")
	private String t064Codigo;

	@Column(name = "T064_CODSUBSERIE")
	private String t064Codsubserie;

	@Column(name = "T064_FECULTACT")
	private Date t064Fecultact;

	@NotNull
	@Column(name = "T064_NOMBRE")
	private String t064Nombre;

	@Column(name = "T064_USUULTACT")
	private String t064Usuultact;

	public Long getT064Idserie() {
		return this.t064Idserie;
	}

	public void setT064Idserie(Long t064Idserie) {
		this.t064Idserie = t064Idserie;
	}

	public String getT064Blactivo() {
		return this.t064Blactivo;
	}

	public String getT064Codigo() {
		return this.t064Codigo;
	}

	public String getT064Codsubserie() {
		return this.t064Codsubserie;
	}

	public Date getT064Fecultact() {
		return this.t064Fecultact;
	}

	public String getT064Nombre() {
		return this.t064Nombre;
	}

	public String getT064Usuultact() {
		return this.t064Usuultact;
	}

	public void setT064Blactivo(String t064Blactivo) {
		this.t064Blactivo = t064Blactivo;
	}

	public void setT064Codigo(String t064Codigo) {
		this.t064Codigo = t064Codigo;
	}

	public void setT064Codsubserie(String t064Codsubserie) {
		this.t064Codsubserie = t064Codsubserie;
	}

	public void setT064Fecultact(Date t064Fecultact) {
		this.t064Fecultact = t064Fecultact;
	}

	public void setT064Nombre(String t064Nombre) {
		this.t064Nombre = t064Nombre;
	}

	public void setT064Usuultact(String t064Usuultact) {
		this.t064Usuultact = t064Usuultact;
	}

}