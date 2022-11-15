package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG025_MEDADO")
public class Tbasg025Medado {

	@Id
	@Column(name = "T025_IDMEDADO")
	private Long t025Idmedado;

	@Column(name = "T025_BLACTIVO")
	private String t025Blactivo;

	@NotNull
	@Column(name = "T025_CODIGO")
	private String t025Codigo;

	@Column(name = "T025_FECULTACT")
	private Date t025Fecultact;

	@NotNull
	@Column(name = "T025_NOMBRE")
	private String t025Nombre;

	@Column(name = "T025_USUULTACT")
	private String t025Usuultact;

	public Long getT025Idmedado() {
		return this.t025Idmedado;
	}

	public void setT025Idmedado(Long t025Idmedado) {
		this.t025Idmedado = t025Idmedado;
	}

	public String getT025Blactivo() {
		return this.t025Blactivo;
	}

	public String getT025Codigo() {
		return this.t025Codigo;
	}

	public Date getT025Fecultact() {
		return this.t025Fecultact;
	}

	public String getT025Nombre() {
		return this.t025Nombre;
	}

	public String getT025Usuultact() {
		return this.t025Usuultact;
	}

	public void setT025Blactivo(String t025Blactivo) {
		this.t025Blactivo = t025Blactivo;
	}

	public void setT025Codigo(String t025Codigo) {
		this.t025Codigo = t025Codigo;
	}

	public void setT025Fecultact(Date t025Fecultact) {
		this.t025Fecultact = t025Fecultact;
	}

	public void setT025Nombre(String t025Nombre) {
		this.t025Nombre = t025Nombre;
	}

	public void setT025Usuultact(String t025Usuultact) {
		this.t025Usuultact = t025Usuultact;
	}

}