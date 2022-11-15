package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG080_AMBMAN")
public class Tbasg080Ambman {

	@Id
	@Column(name = "T080_IDAMBMAN")
	private Long t080Idambman;

	@Column(name = "T080_BLACTIVO")
	private String t080Blactivo;

	@NotNull
	@Column(name = "T080_CODIGO")
	private String t080Codigo;

	@Column(name = "T080_FECULTACT")
	private Date t080Fecultact;

	@NotNull
	@Column(name = "T080_NOMBRE")
	private String t080Nombre;

	@Column(name = "T080_USUULTACT")
	private String t080Usuultact;

	public Long getT080Idambman() {
		return this.t080Idambman;
	}

	public void setT080Idambman(Long t080Idambman) {
		this.t080Idambman = t080Idambman;
	}

	public String getT080Blactivo() {
		return this.t080Blactivo;
	}

	public String getT080Codigo() {
		return this.t080Codigo;
	}

	public Date getT080Fecultact() {
		return this.t080Fecultact;
	}

	public String getT080Nombre() {
		return this.t080Nombre;
	}

	public String getT080Usuultact() {
		return this.t080Usuultact;
	}

	public void setT080Blactivo(String t080Blactivo) {
		this.t080Blactivo = t080Blactivo;
	}

	public void setT080Codigo(String t080Codigo) {
		this.t080Codigo = t080Codigo;
	}

	public void setT080Fecultact(Date t080Fecultact) {
		this.t080Fecultact = t080Fecultact;
	}

	public void setT080Nombre(String t080Nombre) {
		this.t080Nombre = t080Nombre;
	}

	public void setT080Usuultact(String t080Usuultact) {
		this.t080Usuultact = t080Usuultact;
	}

}