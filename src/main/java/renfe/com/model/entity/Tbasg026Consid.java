package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG026_CONSID")
public class Tbasg026Consid {

	@Id
	@Column(name = "T026_IDCONSID")
	private Long t026Idconsid;

	@Column(name = "T026_BLACTIVO")
	private String t026Blactivo;

	@NotNull
	@Column(name = "T026_CODIGO")
	private String t026Codigo;

	@Column(name = "T026_FECULTACT")
	private Date t026Fecultact;

	@NotNull
	@Column(name = "T026_NOMBRE")
	private String t026Nombre;

	@Column(name = "T026_USUULTACT")
	private String t026Usuultact;

	public Long getT026Idconsid() {
		return this.t026Idconsid;
	}

	public void setT026Idconsid(Long t026Idconsid) {
		this.t026Idconsid = t026Idconsid;
	}

	public String getT026Blactivo() {
		return this.t026Blactivo;
	}

	public String getT026Codigo() {
		return this.t026Codigo;
	}

	public Date getT026Fecultact() {
		return this.t026Fecultact;
	}

	public String getT026Nombre() {
		return this.t026Nombre;
	}

	public String getT026Usuultact() {
		return this.t026Usuultact;
	}

	public void setT026Blactivo(String t026Blactivo) {
		this.t026Blactivo = t026Blactivo;
	}

	public void setT026Codigo(String t026Codigo) {
		this.t026Codigo = t026Codigo;
	}

	public void setT026Fecultact(Date t026Fecultact) {
		this.t026Fecultact = t026Fecultact;
	}

	public void setT026Nombre(String t026Nombre) {
		this.t026Nombre = t026Nombre;
	}

	public void setT026Usuultact(String t026Usuultact) {
		this.t026Usuultact = t026Usuultact;
	}

}