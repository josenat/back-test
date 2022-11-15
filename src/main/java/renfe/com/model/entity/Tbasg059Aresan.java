package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG059_ARESAN")
public class Tbasg059Aresan {

	@Id
	@Column(name = "T059_IDAREASANI")
	private Long t059Idareasani;

	@Column(name = "T059_BLACTIVO")
	private String t059Blactivo;

	@NotNull
	@Column(name = "T059_CODIGO")
	private String t059Codigo;

	@Column(name = "T059_FECULTACT")
	private Date t059Fecultact;

	@NotNull
	@Column(name = "T059_NOMBRE")
	private String t059Nombre;

	@Column(name = "T059_USUULTACT")
	private String t059Usuultact;

	public Long getT059Idareasani() {
		return this.t059Idareasani;
	}

	public void setT059Idareasani(Long t059Idareasani) {
		this.t059Idareasani = t059Idareasani;
	}

	public String getT059Blactivo() {
		return this.t059Blactivo;
	}

	public String getT059Codigo() {
		return this.t059Codigo;
	}

	public Date getT059Fecultact() {
		return this.t059Fecultact;
	}

	public String getT059Nombre() {
		return this.t059Nombre;
	}

	public String getT059Usuultact() {
		return this.t059Usuultact;
	}

	public void setT059Blactivo(String t059Blactivo) {
		this.t059Blactivo = t059Blactivo;
	}

	public void setT059Codigo(String t059Codigo) {
		this.t059Codigo = t059Codigo;
	}

	public void setT059Fecultact(Date t059Fecultact) {
		this.t059Fecultact = t059Fecultact;
	}

	public void setT059Nombre(String t059Nombre) {
		this.t059Nombre = t059Nombre;
	}

	public void setT059Usuultact(String t059Usuultact) {
		this.t059Usuultact = t059Usuultact;
	}

}