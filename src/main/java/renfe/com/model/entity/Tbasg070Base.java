package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG070_BASE")
public class Tbasg070Base {

	@Id
	@Column(name = "T070_IDBASE")
	private Long t070Idbase;

	@Column(name = "T070_BLACTIVO")
	private String t070Blactivo;

	@NotNull
	@Column(name = "T070_CODIGO")
	private String t070Codigo;

	@Column(name = "T070_FECULTACT")
	private Date t070Fecultact;

	@NotNull
	@Column(name = "T070_NOMBRE")
	private String t070Nombre;

	@Column(name = "T070_USUULTACT")
	private String t070Usuultact;

	public Long getT070Idbase() {
		return this.t070Idbase;
	}

	public void setT070Idbase(Long t070Idbase) {
		this.t070Idbase = t070Idbase;
	}

	public String getT070Blactivo() {
		return this.t070Blactivo;
	}

	public String getT070Codigo() {
		return this.t070Codigo;
	}

	public Date getT070Fecultact() {
		return this.t070Fecultact;
	}

	public String getT070Nombre() {
		return this.t070Nombre;
	}

	public String getT070Usuultact() {
		return this.t070Usuultact;
	}

	public void setT070Blactivo(String t070Blactivo) {
		this.t070Blactivo = t070Blactivo;
	}

	public void setT070Codigo(String t070Codigo) {
		this.t070Codigo = t070Codigo;
	}

	public void setT070Fecultact(Date t070Fecultact) {
		this.t070Fecultact = t070Fecultact;
	}

	public void setT070Nombre(String t070Nombre) {
		this.t070Nombre = t070Nombre;
	}

	public void setT070Usuultact(String t070Usuultact) {
		this.t070Usuultact = t070Usuultact;
	}

}