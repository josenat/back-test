package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG015_TIPLIC")
public class Tbasg015Tiplic {

	@Id
	@Column(name = "T015_IDTIPLIC")
	private Long t015Idtiplic;

	@Column(name = "T015_BLACTIVO")
	private String t015Blactivo;

	@NotNull
	@Column(name = "T015_CODIGO")
	private String t015Codigo;

	@Column(name = "T015_FECULTACT")
	private Date t015Fecultact;

	@NotNull
	@Column(name = "T015_NOMBRE")
	private String t015Nombre;

	@Column(name = "T015_USUULTACT")
	private String t015Usuultact;

	public Long getT015Idtiplic() {
		return this.t015Idtiplic;
	}

	public void setT015Idtiplic(Long t015Idtiplic) {
		this.t015Idtiplic = t015Idtiplic;
	}

	public String getT015Blactivo() {
		return this.t015Blactivo;
	}

	public String getT015Codigo() {
		return this.t015Codigo;
	}

	public Date getT015Fecultact() {
		return this.t015Fecultact;
	}

	public String getT015Nombre() {
		return this.t015Nombre;
	}

	public String getT015Usuultact() {
		return this.t015Usuultact;
	}

	public void setT015Blactivo(String t015Blactivo) {
		this.t015Blactivo = t015Blactivo;
	}

	public void setT015Codigo(String t015Codigo) {
		this.t015Codigo = t015Codigo;
	}

	public void setT015Fecultact(Date t015Fecultact) {
		this.t015Fecultact = t015Fecultact;
	}

	public void setT015Nombre(String t015Nombre) {
		this.t015Nombre = t015Nombre;
	}

	public void setT015Usuultact(String t015Usuultact) {
		this.t015Usuultact = t015Usuultact;
	}

}