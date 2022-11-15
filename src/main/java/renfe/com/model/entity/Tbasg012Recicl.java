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
@Table(name = "TBASG012_RECICL")
public class Tbasg012Recicl {

	@Id
	@Column(name = "T012_IDREC")
	private Long t012Idrec;

	@Column(name = "T012_BLACTIVO")
	private String t012Blactivo;

	@NotNull
	@Column(name = "T012_CODIGO")
	private String t012Codigo;

	@Column(name = "T012_FECULTACT")
	private Date t012Fecultact;

	@NotNull
	@Column(name = "T012_NOMBRE")
	private String t012Nombre;

	@Column(name = "T012_USUULTACT")
	private String t012Usuultact;

	@ManyToOne
	@JoinColumn(name = "T012_IDTIPREC", nullable = false, foreignKey = @ForeignKey(name = "FK1AS012"))
	private Tbasg071Tiprec t012Idtiprec;

	public Long getT012Idrec() {
		return this.t012Idrec;
	}

	public void setT012Idrec(Long t012Idrec) {
		this.t012Idrec = t012Idrec;
	}

	public String getT012Blactivo() {
		return this.t012Blactivo;
	}

	public String getT012Codigo() {
		return this.t012Codigo;
	}

	public Date getT012Fecultact() {
		return this.t012Fecultact;
	}

	public String getT012Nombre() {
		return this.t012Nombre;
	}

	public String getT012Usuultact() {
		return this.t012Usuultact;
	}

	public void setT012Blactivo(String t012Blactivo) {
		this.t012Blactivo = t012Blactivo;
	}

	public void setT012Codigo(String t012Codigo) {
		this.t012Codigo = t012Codigo;
	}

	public void setT012Fecultact(Date t012Fecultact) {
		this.t012Fecultact = t012Fecultact;
	}

	public void setT012Nombre(String t012Nombre) {
		this.t012Nombre = t012Nombre;
	}

	public void setT012Usuultact(String t012Usuultact) {
		this.t012Usuultact = t012Usuultact;
	}

	public Tbasg071Tiprec getT012Idtiprec() {
		return this.t012Idtiprec;
	}

	public void setT012Idtiprec(Tbasg071Tiprec t012Idtiprec) {
		this.t012Idtiprec = t012Idtiprec;
	}

}