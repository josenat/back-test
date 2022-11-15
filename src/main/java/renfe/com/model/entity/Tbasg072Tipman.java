package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG072_TIPMAN")
public class Tbasg072Tipman {

	@Id
	@Column(name = "T072_IDTIPMAN")
	private Long t072Idtipman;

	@Column(name = "T072_BLACTIVO")
	private String t072Blactivo;

	@NotNull
	@Column(name = "T072_CODIGO")
	private String t072Codigo;

	@Column(name = "T072_FECULTACT")
	private Date t072Fecultact;

	@NotNull
	@Column(name = "T072_NOMBRE")
	private String t072Nombre;

	@Column(name = "T072_USUULTACT")
	private String t072Usuultact;

	public Long getT072Idtipman() {
		return this.t072Idtipman;
	}

	public void setT072Idtipman(Long t072Idtipman) {
		this.t072Idtipman = t072Idtipman;
	}

	public String getT072Blactivo() {
		return this.t072Blactivo;
	}

	public String getT072Codigo() {
		return this.t072Codigo;
	}

	public Date getT072Fecultact() {
		return this.t072Fecultact;
	}

	public String getT072Nombre() {
		return this.t072Nombre;
	}

	public String getT072Usuultact() {
		return this.t072Usuultact;
	}

	public void setT072Blactivo(String t072Blactivo) {
		this.t072Blactivo = t072Blactivo;
	}

	public void setT072Codigo(String t072Codigo) {
		this.t072Codigo = t072Codigo;
	}

	public void setT072Fecultact(Date t072Fecultact) {
		this.t072Fecultact = t072Fecultact;
	}

	public void setT072Nombre(String t072Nombre) {
		this.t072Nombre = t072Nombre;
	}

	public void setT072Usuultact(String t072Usuultact) {
		this.t072Usuultact = t072Usuultact;
	}

}