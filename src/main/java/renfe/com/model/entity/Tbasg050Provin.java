package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG050_PROVIN")
public class Tbasg050Provin {

	@Id
	@Column(name = "T050_IDPROVIN")
	private Long t050Idprovin;

	@Column(name = "T050_BLACTIVO")
	private String t050Blactivo;

	@NotNull
	@Column(name = "T050_CODIGO")
	private String t050Codigo;

	@Column(name = "T050_FECULTACT")
	private Date t050Fecultact;

	@NotNull
	@Column(name = "T050_NOMBRE")
	private String t050Nombre;

	@Column(name = "T050_USUULTACT")
	private String t050Usuultact;

	public Long getT050Idprovin() {
		return this.t050Idprovin;
	}

	public void setT050Idprovin(Long t050Idprovin) {
		this.t050Idprovin = t050Idprovin;
	}

	public String getT050Blactivo() {
		return this.t050Blactivo;
	}

	public String getT050Codigo() {
		return this.t050Codigo;
	}

	public Date getT050Fecultact() {
		return this.t050Fecultact;
	}

	public String getT050Nombre() {
		return this.t050Nombre;
	}

	public String getT050Usuultact() {
		return this.t050Usuultact;
	}

	public void setT050Blactivo(String t050Blactivo) {
		this.t050Blactivo = t050Blactivo;
	}

	public void setT050Codigo(String t050Codigo) {
		this.t050Codigo = t050Codigo;
	}

	public void setT050Fecultact(Date t050Fecultact) {
		this.t050Fecultact = t050Fecultact;
	}

	public void setT050Nombre(String t050Nombre) {
		this.t050Nombre = t050Nombre;
	}

	public void setT050Usuultact(String t050Usuultact) {
		this.t050Usuultact = t050Usuultact;
	}

}