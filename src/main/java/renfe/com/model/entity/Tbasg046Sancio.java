package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG046_SANCIO")
public class Tbasg046Sancio {

	@Id
	@Column(name = "T046_IDSANCIO")
	private Long t046Idsancio;

	@Column(name = "T046_BLACTIVO")
	private String t046Blactivo;

	@NotNull
	@Column(name = "T046_CODIGO")
	private String t046Codigo;

	@Column(name = "T046_FECULTACT")
	private Date t046Fecultact;

	@NotNull
	@Column(name = "T046_NOMBRE")
	private String t046Nombre;

	@Column(name = "T046_USUULTACT")
	private String t046Usuultact;

	public Long getT046Idsancio() {
		return this.t046Idsancio;
	}

	public void setT046Idsancio(Long t046Idsancio) {
		this.t046Idsancio = t046Idsancio;
	}

	public String getT046Blactivo() {
		return this.t046Blactivo;
	}

	public String getT046Codigo() {
		return this.t046Codigo;
	}

	public Date getT046Fecultact() {
		return this.t046Fecultact;
	}

	public String getT046Nombre() {
		return this.t046Nombre;
	}

	public String getT046Usuultact() {
		return this.t046Usuultact;
	}

	public void setT046Blactivo(String t046Blactivo) {
		this.t046Blactivo = t046Blactivo;
	}

	public void setT046Codigo(String t046Codigo) {
		this.t046Codigo = t046Codigo;
	}

	public void setT046Fecultact(Date t046Fecultact) {
		this.t046Fecultact = t046Fecultact;
	}

	public void setT046Nombre(String t046Nombre) {
		this.t046Nombre = t046Nombre;
	}

	public void setT046Usuultact(String t046Usuultact) {
		this.t046Usuultact = t046Usuultact;
	}

}