package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG052_NACION")
public class Tbasg052Nacion {

	@Id
	@Column(name = "T052_IDNACION")
	private Long t052Idnacion;

	@Column(name = "T052_BLACTIVO")
	private String t052Blactivo;

	@NotNull
	@Column(name = "T052_CODIGO")
	private String t052Codigo;

	@Column(name = "T052_FECULTACT")
	private Date t052Fecultact;

	@NotNull
	@Column(name = "T052_NOMBRE")
	private String t052Nombre;

	@Column(name = "T052_USUULTACT")
	private String t052Usuultact;

	public Long getT052Idnacion() {
		return this.t052Idnacion;
	}

	public void setT052Idnacion(Long t052Idnacion) {
		this.t052Idnacion = t052Idnacion;
	}

	public String getT052Blactivo() {
		return this.t052Blactivo;
	}

	public String getT052Codigo() {
		return this.t052Codigo;
	}

	public Date getT052Fecultact() {
		return this.t052Fecultact;
	}

	public String getT052Nombre() {
		return this.t052Nombre;
	}

	public String getT052Usuultact() {
		return this.t052Usuultact;
	}

	public void setT052Blactivo(String t052Blactivo) {
		this.t052Blactivo = t052Blactivo;
	}

	public void setT052Codigo(String t052Codigo) {
		this.t052Codigo = t052Codigo;
	}

	public void setT052Fecultact(Date t052Fecultact) {
		this.t052Fecultact = t052Fecultact;
	}

	public void setT052Nombre(String t052Nombre) {
		this.t052Nombre = t052Nombre;
	}

	public void setT052Usuultact(String t052Usuultact) {
		this.t052Usuultact = t052Usuultact;
	}

}