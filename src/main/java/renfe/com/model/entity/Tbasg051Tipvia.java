package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG051_TIPVIA")
public class Tbasg051Tipvia {

	@Id
	@Column(name = "T051_IDTIPVIA")
	private Long t051Idtipvia;

	@Column(name = "T051_BLACTIVO")
	private String t051Blactivo;

	@NotNull
	@Column(name = "T051_CODIGO")
	private String t051Codigo;

	@Column(name = "T051_FECULTACT")
	private Date t051Fecultact;

	@NotNull
	@Column(name = "T051_NOMBRE")
	private String t051Nombre;

	@Column(name = "T051_USUULTACT")
	private String t051Usuultact;

	public Long getT051Idtipvia() {
		return this.t051Idtipvia;
	}

	public void setT051Idtipvia(Long t051Idtipvia) {
		this.t051Idtipvia = t051Idtipvia;
	}

	public String getT051Blactivo() {
		return this.t051Blactivo;
	}

	public String getT051Codigo() {
		return this.t051Codigo;
	}

	public Date getT051Fecultact() {
		return this.t051Fecultact;
	}

	public String getT051Nombre() {
		return this.t051Nombre;
	}

	public String getT051Usuultact() {
		return this.t051Usuultact;
	}

	public void setT051Blactivo(String t051Blactivo) {
		this.t051Blactivo = t051Blactivo;
	}

	public void setT051Codigo(String t051Codigo) {
		this.t051Codigo = t051Codigo;
	}

	public void setT051Fecultact(Date t051Fecultact) {
		this.t051Fecultact = t051Fecultact;
	}

	public void setT051Nombre(String t051Nombre) {
		this.t051Nombre = t051Nombre;
	}

	public void setT051Usuultact(String t051Usuultact) {
		this.t051Usuultact = t051Usuultact;
	}

}