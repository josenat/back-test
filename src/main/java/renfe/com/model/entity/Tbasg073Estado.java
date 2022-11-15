package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG073_ESTADO")
public class Tbasg073Estado {

	@Id
	@Column(name = "T073_IDESTADO")
	private Long t073Idestado;

	@Column(name = "T073_BLACTIVO")
	private String t073Blactivo;

	@NotNull
	@Column(name = "T073_CODIGO")
	private String t073Codigo;

	@Column(name = "T073_FECULTACT")
	private Date t073Fecultact;

	@NotNull
	@Column(name = "T073_NOMBRE")
	private String t073Nombre;

	@Column(name = "T073_USUULTACT")
	private String t073Usuultact;

	public Long getT073Idestado() {
		return this.t073Idestado;
	}

	public void setT073Idestado(Long t073Idestado) {
		this.t073Idestado = t073Idestado;
	}

	public String getT073Blactivo() {
		return this.t073Blactivo;
	}

	public String getT073Codigo() {
		return this.t073Codigo;
	}

	public Date getT073Fecultact() {
		return this.t073Fecultact;
	}

	public String getT073Nombre() {
		return this.t073Nombre;
	}

	public String getT073Usuultact() {
		return this.t073Usuultact;
	}

	public void setT073Blactivo(String t073Blactivo) {
		this.t073Blactivo = t073Blactivo;
	}

	public void setT073Codigo(String t073Codigo) {
		this.t073Codigo = t073Codigo;
	}

	public void setT073Fecultact(Date t073Fecultact) {
		this.t073Fecultact = t073Fecultact;
	}

	public void setT073Nombre(String t073Nombre) {
		this.t073Nombre = t073Nombre;
	}

	public void setT073Usuultact(String t073Usuultact) {
		this.t073Usuultact = t073Usuultact;
	}

}