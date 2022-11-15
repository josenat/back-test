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
@Table(name = "TBASG007_ARETER")
public class Tbasg007Areter {

	@Id
	@Column(name = "T007_IDARETER")
	private Long t007Idareter;

	@Column(name = "T007_BLACTIVO")
	private String t007Blactivo;

	@NotNull
	@Column(name = "T007_CODIGO")
	private String t007Codigo;

	@Column(name = "T007_FECULTACT")
	private Date t007Fecultact;

	@NotNull
	@Column(name = "T007_NOMBRE")
	private String t007Nombre;

	@Column(name = "T007_USUULTACT")
	private String t007Usuultact;

	@ManyToOne
	@JoinColumn(name = "T007_IDAREACT", nullable = false, foreignKey = @ForeignKey(name = "FK1AS007"))
	private Tbasg006Areact t007Idareact;

	public Long getT007Idareter() {
		return this.t007Idareter;
	}

	public void setT007Idareter(Long t007Idareter) {
		this.t007Idareter = t007Idareter;
	}

	public String getT007Blactivo() {
		return this.t007Blactivo;
	}

	public String getT007Codigo() {
		return this.t007Codigo;
	}

	public Date getT007Fecultact() {
		return this.t007Fecultact;
	}

	public String getT007Nombre() {
		return this.t007Nombre;
	}

	public String getT007Usuultact() {
		return this.t007Usuultact;
	}

	public void setT007Blactivo(String t007Blactivo) {
		this.t007Blactivo = t007Blactivo;
	}

	public void setT007Codigo(String t007Codigo) {
		this.t007Codigo = t007Codigo;
	}

	public void setT007Fecultact(Date t007Fecultact) {
		this.t007Fecultact = t007Fecultact;
	}

	public void setT007Nombre(String t007Nombre) {
		this.t007Nombre = t007Nombre;
	}

	public void setT007Usuultact(String t007Usuultact) {
		this.t007Usuultact = t007Usuultact;
	}

	public Tbasg006Areact getT007Idareact() {
		return this.t007Idareact;
	}

	public void setT007Idareact(Tbasg006Areact t007Idareact) {
		this.t007Idareact = t007Idareact;
	}

}