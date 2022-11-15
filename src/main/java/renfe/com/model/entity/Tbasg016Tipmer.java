package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG016_TIPMER",schema = "PASG")
public class Tbasg016Tipmer {

	@Id
	@Column(name = "T016_IDTIPMER")
	private Long t016Idtipmer;

	@Column(name = "T016_BLACTIVO")
	private String t016Blactivo;

	@NotNull
	@Column(name = "T016_CODIGO")
	private String t016Codigo;

	@Column(name = "T016_FECULTACT")
	private Date t016Fecultact;

	@NotNull
	@Column(name = "T016_NOMBRE")
	private String t016Nombre;

	@Column(name = "T016_USUULTACT")
	private String t016Usuultact;

	public Long getT016Idtipmer() {
		return this.t016Idtipmer;
	}

	public void setT016Idtipmer(Long t016Idtipmer) {
		this.t016Idtipmer = t016Idtipmer;
	}

	public String getT016Blactivo() {
		return this.t016Blactivo;
	}

	public String getT016Codigo() {
		return this.t016Codigo;
	}

	public Date getT016Fecultact() {
		return this.t016Fecultact;
	}

	public String getT016Nombre() {
		return this.t016Nombre;
	}

	public String getT016Usuultact() {
		return this.t016Usuultact;
	}

	public void setT016Blactivo(String t016Blactivo) {
		this.t016Blactivo = t016Blactivo;
	}

	public void setT016Codigo(String t016Codigo) {
		this.t016Codigo = t016Codigo;
	}

	public void setT016Fecultact(Date t016Fecultact) {
		this.t016Fecultact = t016Fecultact;
	}

	public void setT016Nombre(String t016Nombre) {
		this.t016Nombre = t016Nombre;
	}

	public void setT016Usuultact(String t016Usuultact) {
		this.t016Usuultact = t016Usuultact;
	}

}