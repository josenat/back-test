package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG076_CURSOS")
public class Tbasg076Cursos {

	@Id
	@Column(name = "T076_IDCURSO")
	private Long t076Idcurso;

	@Column(name = "T076_BLACTIVO")
	private String t076Blactivo;

	@NotNull
	@Column(name = "T076_CODIGO")
	private String t076Codigo;

	@Column(name = "T076_FECULTACT")
	private Date t076Fecultact;

	@NotNull
	@Column(name = "T076_NOMBRE")
	private String t076Nombre;

	@Column(name = "T076_USUULTACT")
	private String t076Usuultact;

	public Long getT076Idcurso() {
		return this.t076Idcurso;
	}

	public void setT076Idcurso(Long t076Idcurso) {
		this.t076Idcurso = t076Idcurso;
	}

	public String getT076Blactivo() {
		return this.t076Blactivo;
	}

	public String getT076Codigo() {
		return this.t076Codigo;
	}

	public Date getT076Fecultact() {
		return this.t076Fecultact;
	}

	public String getT076Nombre() {
		return this.t076Nombre;
	}

	public String getT076Usuultact() {
		return this.t076Usuultact;
	}

	public void setT076Blactivo(String t076Blactivo) {
		this.t076Blactivo = t076Blactivo;
	}

	public void setT076Codigo(String t076Codigo) {
		this.t076Codigo = t076Codigo;
	}

	public void setT076Fecultact(Date t076Fecultact) {
		this.t076Fecultact = t076Fecultact;
	}

	public void setT076Nombre(String t076Nombre) {
		this.t076Nombre = t076Nombre;
	}

	public void setT076Usuultact(String t076Usuultact) {
		this.t076Usuultact = t076Usuultact;
	}

}