package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG057_AREFOR")
public class Tbasg057Arefor {

	@Id
	@Column(name = "T057_IDAREAFOR")
	private Long t057Idareafor;

	@Column(name = "T057_BLACTIVO")
	private String t057Blactivo;

	@NotNull
	@Column(name = "T057_CODIGO")
	private String t057Codigo;

	@Column(name = "T057_FECULTACT")
	private Date t057Fecultact;

	@NotNull
	@Column(name = "T057_NOMBRE")
	private String t057Nombre;

	@Column(name = "T057_USUULTACT")
	private String t057Usuultact;

	public Long getT057Idareafor() {
		return this.t057Idareafor;
	}

	public void setT057Idareafor(Long t057Idareafor) {
		this.t057Idareafor = t057Idareafor;
	}

	public String getT057Blactivo() {
		return this.t057Blactivo;
	}

	public String getT057Codigo() {
		return this.t057Codigo;
	}

	public Date getT057Fecultact() {
		return this.t057Fecultact;
	}

	public String getT057Nombre() {
		return this.t057Nombre;
	}

	public String getT057Usuultact() {
		return this.t057Usuultact;
	}

	public void setT057Blactivo(String t057Blactivo) {
		this.t057Blactivo = t057Blactivo;
	}

	public void setT057Codigo(String t057Codigo) {
		this.t057Codigo = t057Codigo;
	}

	public void setT057Fecultact(Date t057Fecultact) {
		this.t057Fecultact = t057Fecultact;
	}

	public void setT057Nombre(String t057Nombre) {
		this.t057Nombre = t057Nombre;
	}

	public void setT057Usuultact(String t057Usuultact) {
		this.t057Usuultact = t057Usuultact;
	}

}