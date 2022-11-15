package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG071_TIPREC")
public class Tbasg071Tiprec {

	@Id
	@Column(name = "T071_IDTIPREC")
	private Long t071Idtiprec;

	@Column(name = "T071_BLACTIVO")
	private String t071Blactivo;

	@NotNull
	@Column(name = "T071_CODIGO")
	private String t071Codigo;

	@Column(name = "T071_FECULTACT")
	private Date t071Fecultact;

	@NotNull
	@Column(name = "T071_NOMBRE")
	private String t071Nombre;

	@Column(name = "T071_USUULTACT")
	private String t071Usuultact;

	public Long getT071Idtiprec() {
		return this.t071Idtiprec;
	}

	public void setT071Idtiprec(Long t071Idtiprec) {
		this.t071Idtiprec = t071Idtiprec;
	}

	public String getT071Blactivo() {
		return this.t071Blactivo;
	}

	public String getT071Codigo() {
		return this.t071Codigo;
	}

	public Date getT071Fecultact() {
		return this.t071Fecultact;
	}

	public String getT071Nombre() {
		return this.t071Nombre;
	}

	public String getT071Usuultact() {
		return this.t071Usuultact;
	}

	public void setT071Blactivo(String t071Blactivo) {
		this.t071Blactivo = t071Blactivo;
	}

	public void setT071Codigo(String t071Codigo) {
		this.t071Codigo = t071Codigo;
	}

	public void setT071Fecultact(Date t071Fecultact) {
		this.t071Fecultact = t071Fecultact;
	}

	public void setT071Nombre(String t071Nombre) {
		this.t071Nombre = t071Nombre;
	}

	public void setT071Usuultact(String t071Usuultact) {
		this.t071Usuultact = t071Usuultact;
	}

}