package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG075_ESTENV")
public class Tbasg075Estenv {

	@Id
	@Column(name = "T075_IDESTENV")
	private Long t075Idestenv;

	@Column(name = "T075_BLACTIVO")
	private String t075Blactivo;

	@NotNull
	@Column(name = "T075_CODIGO")
	private String t075Codigo;

	@Column(name = "T075_FECULTACT")
	private Date t075Fecultact;

	@NotNull
	@Column(name = "T075_NOMBRE")
	private String t075Nombre;

	@Column(name = "T075_USUULTACT")
	private String t075Usuultact;

	public Long getT075Idestenv() {
		return this.t075Idestenv;
	}

	public void setT075Idestenv(Long t075Idestenv) {
		this.t075Idestenv = t075Idestenv;
	}

	public String getT075Blactivo() {
		return this.t075Blactivo;
	}

	public String getT075Codigo() {
		return this.t075Codigo;
	}

	public Date getT075Fecultact() {
		return this.t075Fecultact;
	}

	public String getT075Nombre() {
		return this.t075Nombre;
	}

	public String getT075Usuultact() {
		return this.t075Usuultact;
	}

	public void setT075Blactivo(String t075Blactivo) {
		this.t075Blactivo = t075Blactivo;
	}

	public void setT075Codigo(String t075Codigo) {
		this.t075Codigo = t075Codigo;
	}

	public void setT075Fecultact(Date t075Fecultact) {
		this.t075Fecultact = t075Fecultact;
	}

	public void setT075Nombre(String t075Nombre) {
		this.t075Nombre = t075Nombre;
	}

	public void setT075Usuultact(String t075Usuultact) {
		this.t075Usuultact = t075Usuultact;
	}

}