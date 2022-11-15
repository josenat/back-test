package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG086_ESTHAB")
public class Tbasg086Esthab {

	@Id
	@Column(name = "T086_IDESTHAB")
	private Long t086Idesthab;

	@Column(name = "T086_BLACTIVO")
	private String t086Blactivo;

	@NotNull
	@Column(name = "T086_CODIGO")
	private String t086Codigo;

	@Column(name = "T086_FECULTACT")
	private Date t086Fecultact;

	@NotNull
	@Column(name = "T086_NOMBRE")
	private String t086Nombre;

	@Column(name = "T086_USUULTACT")
	private String t086Usuultact;

	public Long getT086Idesthab() {
		return this.t086Idesthab;
	}

	public void setT086Idesthab(Long t086Idesthab) {
		this.t086Idesthab = t086Idesthab;
	}

	public String getT086Blactivo() {
		return this.t086Blactivo;
	}

	public String getT086Codigo() {
		return this.t086Codigo;
	}

	public Date getT086Fecultact() {
		return this.t086Fecultact;
	}

	public String getT086Nombre() {
		return this.t086Nombre;
	}

	public String getT086Usuultact() {
		return this.t086Usuultact;
	}

	public void setT086Blactivo(String t086Blactivo) {
		this.t086Blactivo = t086Blactivo;
	}

	public void setT086Codigo(String t086Codigo) {
		this.t086Codigo = t086Codigo;
	}

	public void setT086Fecultact(Date t086Fecultact) {
		this.t086Fecultact = t086Fecultact;
	}

	public void setT086Nombre(String t086Nombre) {
		this.t086Nombre = t086Nombre;
	}

	public void setT086Usuultact(String t086Usuultact) {
		this.t086Usuultact = t086Usuultact;
	}

}