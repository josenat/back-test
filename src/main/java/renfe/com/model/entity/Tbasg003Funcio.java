package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG003_FUNCIO")
public class Tbasg003Funcio {

	@Id
	@Column(name = "T003_IDFUNCIO")
	private Long t003Idfuncio;

	@Column(name = "T003_BLACTIVO")
	private String t003Blactivo;

	@NotNull
	@Column(name = "T003_CODIGO")
	private String t003Codigo;

	@Column(name = "T003_FECULTACT")
	private Date t003Fecultact;

	@NotNull
	@Column(name = "T003_NOMBRE")
	private String t003Nombre;

	@Column(name = "T003_USUULTACT")
	private String t003Usuultact;

	public Long getT003Idfuncio() {
		return this.t003Idfuncio;
	}

	public void setT003Idfuncio(Long t003Idfuncio) {
		this.t003Idfuncio = t003Idfuncio;
	}

	public String getT003Blactivo() {
		return this.t003Blactivo;
	}

	public String getT003Codigo() {
		return this.t003Codigo;
	}

	public Date getT003Fecultact() {
		return this.t003Fecultact;
	}

	public String getT003Nombre() {
		return this.t003Nombre;
	}

	public String getT003Usuultact() {
		return this.t003Usuultact;
	}

	public void setT003Blactivo(String t003Blactivo) {
		this.t003Blactivo = t003Blactivo;
	}

	public void setT003Codigo(String t003Codigo) {
		this.t003Codigo = t003Codigo;
	}

	public void setT003Fecultact(Date t003Fecultact) {
		this.t003Fecultact = t003Fecultact;
	}

	public void setT003Nombre(String t003Nombre) {
		this.t003Nombre = t003Nombre;
	}

	public void setT003Usuultact(String t003Usuultact) {
		this.t003Usuultact = t003Usuultact;
	}

}