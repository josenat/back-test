package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG077_AGRUPA")
public class Tbasg077Agrupa {

	@Id
	@Column(name = "T077_IDAGRUPA")
	private Long t077Idagrupa;

	@Column(name = "T077_BLACTIVO")
	private String t077Blactivo;

	@NotNull
	@Column(name = "T077_CODIGO")
	private String t077Codigo;

	@Column(name = "T077_FECULTACT")
	private Date t077Fecultact;

	@NotNull
	@Column(name = "T077_NOMBRE")
	private String t077Nombre;

	@Column(name = "T077_USUULTACT")
	private String t077Usuultact;

	@ManyToOne
	@JoinColumn(name = "T077_IDAREACT", nullable = false, foreignKey = @ForeignKey(name = "FK1AS077"))
	private Tbasg006Areact t077Idareact;

	public Long getT077Idagrupa() {
		return this.t077Idagrupa;
	}

	public void setT077Idagrupa(Long t077Idagrupa) {
		this.t077Idagrupa = t077Idagrupa;
	}

	public String getT077Blactivo() {
		return this.t077Blactivo;
	}

	public String getT077Codigo() {
		return this.t077Codigo;
	}

	public Date getT077Fecultact() {
		return this.t077Fecultact;
	}

	public String getT077Nombre() {
		return this.t077Nombre;
	}

	public String getT077Usuultact() {
		return this.t077Usuultact;
	}

	public void setT077Blactivo(String t077Blactivo) {
		this.t077Blactivo = t077Blactivo;
	}

	public void setT077Codigo(String t077Codigo) {
		this.t077Codigo = t077Codigo;
	}

	public void setT077Fecultact(Date t077Fecultact) {
		this.t077Fecultact = t077Fecultact;
	}

	public void setT077Nombre(String t077Nombre) {
		this.t077Nombre = t077Nombre;
	}

	public void setT077Usuultact(String t077Usuultact) {
		this.t077Usuultact = t077Usuultact;
	}

	public Tbasg006Areact getT077Idareact() {
		return this.t077Idareact;
	}

	public void setT077Idareact(Tbasg006Areact t077Idareact) {
		this.t077Idareact = t077Idareact;
	}

}