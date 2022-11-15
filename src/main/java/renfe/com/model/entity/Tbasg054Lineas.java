package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG054_LINEAS")
public class Tbasg054Lineas {

	@Id
	@Column(name = "T054_IDLINEA")
	private Long t054Idlinea;

	@Column(name = "T054_BLACTIVO")
	private String t054Blactivo;

	@NotNull
	@Column(name = "T054_CODIGO")
	private String t054Codigo;

	@Column(name = "T054_FECULTACT")
	private Date t054Fecultact;

	@NotNull
	@Column(name = "T054_NOMBRE")
	private String t054Nombre;

	@Column(name = "T054_USUULTACT")
	private String t054Usuultact;

	public Long getT054Idlinea() {
		return this.t054Idlinea;
	}

	public void setT054Idlinea(Long t054Idlinea) {
		this.t054Idlinea = t054Idlinea;
	}

	public String getT054Blactivo() {
		return this.t054Blactivo;
	}

	public String getT054Codigo() {
		return this.t054Codigo;
	}

	public Date getT054Fecultact() {
		return this.t054Fecultact;
	}

	public String getT054Nombre() {
		return this.t054Nombre;
	}

	public String getT054Usuultact() {
		return this.t054Usuultact;
	}

	public void setT054Blactivo(String t054Blactivo) {
		this.t054Blactivo = t054Blactivo;
	}

	public void setT054Codigo(String t054Codigo) {
		this.t054Codigo = t054Codigo;
	}

	public void setT054Fecultact(Date t054Fecultact) {
		this.t054Fecultact = t054Fecultact;
	}

	public void setT054Nombre(String t054Nombre) {
		this.t054Nombre = t054Nombre;
	}

	public void setT054Usuultact(String t054Usuultact) {
		this.t054Usuultact = t054Usuultact;
	}

}