package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG088_ESTEXP")
public class Tbasg088Estexp {

	@Id
	@Column(name = "T088_IDESTEXP")
	private Long t088Idestexp;

	@Column(name = "T088_BLACTIVO")
	private String t088Blactivo;

	@NotNull
	@Column(name = "T088_CODIGO")
	private String t088Codigo;

	@Column(name = "T088_FECULTACT")
	private Date t088Fecultact;

	@NotNull
	@Column(name = "T088_NOMBRE")
	private String t088Nombre;

	@Column(name = "T088_USUULTACT")
	private String t088Usuultact;

	public Long getT088Idestexp() {
		return this.t088Idestexp;
	}

	public void setT088Idestexp(Long t088Idestexp) {
		this.t088Idestexp = t088Idestexp;
	}

	public String getT088Blactivo() {
		return this.t088Blactivo;
	}

	public String getT088Codigo() {
		return this.t088Codigo;
	}

	public Date getT088Fecultact() {
		return this.t088Fecultact;
	}

	public String getT088Nombre() {
		return this.t088Nombre;
	}

	public String getT088Usuultact() {
		return this.t088Usuultact;
	}

	public void setT088Blactivo(String t088Blactivo) {
		this.t088Blactivo = t088Blactivo;
	}

	public void setT088Codigo(String t088Codigo) {
		this.t088Codigo = t088Codigo;
	}

	public void setT088Fecultact(Date t088Fecultact) {
		this.t088Fecultact = t088Fecultact;
	}

	public void setT088Nombre(String t088Nombre) {
		this.t088Nombre = t088Nombre;
	}

	public void setT088Usuultact(String t088Usuultact) {
		this.t088Usuultact = t088Usuultact;
	}

}