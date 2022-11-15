package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG023_TIPREV")
public class Tbasg023Tiprev {

	@Id
	@Column(name = "T023_IDTIPREV")
	private Long t023Idtiprev;

	@Column(name = "T023_BLACTIVO")
	private String t023Blactivo;

	@NotNull
	@Column(name = "T023_CODIGO")
	private String t023Codigo;

	@Column(name = "T023_FECULTACT")
	private Date t023Fecultact;

	@NotNull
	@Column(name = "T023_NOMBRE")
	private String t023Nombre;

	@Column(name = "T023_USUULTACT")
	private String t023Usuultact;

	public Long getT023Idtiprev() {
		return this.t023Idtiprev;
	}

	public void setT023Idtiprev(Long t023Idtiprev) {
		this.t023Idtiprev = t023Idtiprev;
	}

	public String getT023Blactivo() {
		return this.t023Blactivo;
	}

	public String getT023Codigo() {
		return this.t023Codigo;
	}

	public Date getT023Fecultact() {
		return this.t023Fecultact;
	}

	public String getT023Nombre() {
		return this.t023Nombre;
	}

	public String getT023Usuultact() {
		return this.t023Usuultact;
	}

	public void setT023Blactivo(String t023Blactivo) {
		this.t023Blactivo = t023Blactivo;
	}

	public void setT023Codigo(String t023Codigo) {
		this.t023Codigo = t023Codigo;
	}

	public void setT023Fecultact(Date t023Fecultact) {
		this.t023Fecultact = t023Fecultact;
	}

	public void setT023Nombre(String t023Nombre) {
		this.t023Nombre = t023Nombre;
	}

	public void setT023Usuultact(String t023Usuultact) {
		this.t023Usuultact = t023Usuultact;
	}

}