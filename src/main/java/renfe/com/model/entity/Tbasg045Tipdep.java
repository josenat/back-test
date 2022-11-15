package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG045_TIPDEP")
public class Tbasg045Tipdep {

	@Id
	@Column(name = "T045_IDTIPDEP")
	private Long t045Idtipdep;

	@Column(name = "T045_BLACTIVO")
	private String t045Blactivo;

	@NotNull
	@Column(name = "T045_CODIGO")
	private String t045Codigo;

	@Column(name = "T045_FECULTACT")
	private Date t045Fecultact;

	@NotNull
	@Column(name = "T045_NOMBRE")
	private String t045Nombre;

	@Column(name = "T045_USUULTACT")
	private String t045Usuultact;

	public Long getT045Idtipdep() {
		return this.t045Idtipdep;
	}

	public void setT045Idtipdep(Long t045Idtipdep) {
		this.t045Idtipdep = t045Idtipdep;
	}

	public String getT045Blactivo() {
		return this.t045Blactivo;
	}

	public String getT045Codigo() {
		return this.t045Codigo;
	}

	public Date getT045Fecultact() {
		return this.t045Fecultact;
	}

	public String getT045Nombre() {
		return this.t045Nombre;
	}

	public String getT045Usuultact() {
		return this.t045Usuultact;
	}

	public void setT045Blactivo(String t045Blactivo) {
		this.t045Blactivo = t045Blactivo;
	}

	public void setT045Codigo(String t045Codigo) {
		this.t045Codigo = t045Codigo;
	}

	public void setT045Fecultact(Date t045Fecultact) {
		this.t045Fecultact = t045Fecultact;
	}

	public void setT045Nombre(String t045Nombre) {
		this.t045Nombre = t045Nombre;
	}

	public void setT045Usuultact(String t045Usuultact) {
		this.t045Usuultact = t045Usuultact;
	}

}