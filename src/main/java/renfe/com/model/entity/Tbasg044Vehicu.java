package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG044_VEHICU")
public class Tbasg044Vehicu {

	@Id
	@Column(name = "T044_IDVEH")
	private Long t044Idveh;

	@Column(name = "T044_BLACTIVO")
	private String t044Blactivo;

	@NotNull
	@Column(name = "T044_CODIGO")
	private String t044Codigo;

	@Column(name = "T044_FECULTACT")
	private Date t044Fecultact;

	@NotNull
	@Column(name = "T044_NOMBRE")
	private String t044Nombre;

	@Column(name = "T044_USUULTACT")
	private String t044Usuultact;

	public Long getT044Idveh() {
		return this.t044Idveh;
	}

	public void setT044Idveh(Long t044Idveh) {
		this.t044Idveh = t044Idveh;
	}

	public String getT044Blactivo() {
		return this.t044Blactivo;
	}

	public String getT044Codigo() {
		return this.t044Codigo;
	}

	public Date getT044Fecultact() {
		return this.t044Fecultact;
	}

	public String getT044Nombre() {
		return this.t044Nombre;
	}

	public String getT044Usuultact() {
		return this.t044Usuultact;
	}

	public void setT044Blactivo(String t044Blactivo) {
		this.t044Blactivo = t044Blactivo;
	}

	public void setT044Codigo(String t044Codigo) {
		this.t044Codigo = t044Codigo;
	}

	public void setT044Fecultact(Date t044Fecultact) {
		this.t044Fecultact = t044Fecultact;
	}

	public void setT044Nombre(String t044Nombre) {
		this.t044Nombre = t044Nombre;
	}

	public void setT044Usuultact(String t044Usuultact) {
		this.t044Usuultact = t044Usuultact;
	}

}