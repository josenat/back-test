package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG002_PERFIL")
public class Tbasg002Perfil {

	@Id
	@Column(name = "T002_IDPERFIL")
	private Long t002Idperfil;

	@Column(name = "T002_BLACTIVO")
	private String t002Blactivo;

	@NotNull
	@Column(name = "T002_CODIGO")
	private String t002Codigo;

	@Column(name = "T002_FECULTACT")
	private Date t002Fecultact;

	@NotNull
	@Column(name = "T002_NOMBRE")
	private String t002Nombre;

	@Column(name = "T002_USUULTACT")
	private String t002Usuultact;

	public Long getT002Idperfil() {
		return this.t002Idperfil;
	}

	public void setT002Idperfil(Long t002Idperfil) {
		this.t002Idperfil = t002Idperfil;
	}

	public String getT002Blactivo() {
		return this.t002Blactivo;
	}

	public String getT002Codigo() {
		return this.t002Codigo;
	}

	public Date getT002Fecultact() {
		return this.t002Fecultact;
	}

	public String getT002Nombre() {
		return this.t002Nombre;
	}

	public String getT002Usuultact() {
		return this.t002Usuultact;
	}

	public void setT002Blactivo(String t002Blactivo) {
		this.t002Blactivo = t002Blactivo;
	}

	public void setT002Codigo(String t002Codigo) {
		this.t002Codigo = t002Codigo;
	}

	public void setT002Fecultact(Date t002Fecultact) {
		this.t002Fecultact = t002Fecultact;
	}

	public void setT002Nombre(String t002Nombre) {
		this.t002Nombre = t002Nombre;
	}

	public void setT002Usuultact(String t002Usuultact) {
		this.t002Usuultact = t002Usuultact;
	}

}