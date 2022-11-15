package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG062_PERMIS")
public class Tbasg062Permis {

	@Id
	@Column(name = "T062_IDPERMIS")
	private Long t062Idpermis;

	@Column(name = "T062_BLACTIVO")
	private String t062Blactivo;

	@NotNull
	@Column(name = "T062_CODIGO")
	private String t062Codigo;

	@Column(name = "T062_FECULTACT")
	private Date t062Fecultact;

	@NotNull
	@Column(name = "T062_NOMBRE")
	private String t062Nombre;

	@Column(name = "T062_USUULTACT")
	private String t062Usuultact;

	public Long getT062Idpermis() {
		return this.t062Idpermis;
	}

	public void setT062Idpermis(Long t062Idpermis) {
		this.t062Idpermis = t062Idpermis;
	}

	public String getT062Blactivo() {
		return this.t062Blactivo;
	}

	public String getT062Codigo() {
		return this.t062Codigo;
	}

	public Date getT062Fecultact() {
		return this.t062Fecultact;
	}

	public String getT062Nombre() {
		return this.t062Nombre;
	}

	public String getT062Usuultact() {
		return this.t062Usuultact;
	}

	public void setT062Blactivo(String t062Blactivo) {
		this.t062Blactivo = t062Blactivo;
	}

	public void setT062Codigo(String t062Codigo) {
		this.t062Codigo = t062Codigo;
	}

	public void setT062Fecultact(Date t062Fecultact) {
		this.t062Fecultact = t062Fecultact;
	}

	public void setT062Nombre(String t062Nombre) {
		this.t062Nombre = t062Nombre;
	}

	public void setT062Usuultact(String t062Usuultact) {
		this.t062Usuultact = t062Usuultact;
	}

}