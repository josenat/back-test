package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG022_MEDPLA")
public class Tbasg022Medpla {

	@Id
	@Column(name = "T022_IDMEDPLA")
	private Long t022Idmedpla;

	@Column(name = "T022_BLACTIVO")
	private String t022Blactivo;

	@NotNull
	@Column(name = "T022_CODIGO")
	private String t022Codigo;

	@Column(name = "T022_FECULTACT")
	private Date t022Fecultact;

	@NotNull
	@Column(name = "T022_NOMBRE")
	private String t022Nombre;

	@Column(name = "T022_USUULTACT")
	private String t022Usuultact;

	public Long getT022Idmedpla() {
		return this.t022Idmedpla;
	}

	public void setT022Idmedpla(Long t022Idmedpla) {
		this.t022Idmedpla = t022Idmedpla;
	}

	public String getT022Blactivo() {
		return this.t022Blactivo;
	}

	public String getT022Codigo() {
		return this.t022Codigo;
	}

	public Date getT022Fecultact() {
		return this.t022Fecultact;
	}

	public String getT022Nombre() {
		return this.t022Nombre;
	}

	public String getT022Usuultact() {
		return this.t022Usuultact;
	}

	public void setT022Blactivo(String t022Blactivo) {
		this.t022Blactivo = t022Blactivo;
	}

	public void setT022Codigo(String t022Codigo) {
		this.t022Codigo = t022Codigo;
	}

	public void setT022Fecultact(Date t022Fecultact) {
		this.t022Fecultact = t022Fecultact;
	}

	public void setT022Nombre(String t022Nombre) {
		this.t022Nombre = t022Nombre;
	}

	public void setT022Usuultact(String t022Usuultact) {
		this.t022Usuultact = t022Usuultact;
	}

}