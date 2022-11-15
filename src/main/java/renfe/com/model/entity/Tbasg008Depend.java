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
@Table(name = "TBASG008_DEPEND")
public class Tbasg008Depend {

	@Id
	@Column(name = "T008_IDDEPEND")
	private Long t008Iddepend;

	@Column(name = "T008_BLACTIVO")
	private String t008Blactivo;

	@NotNull
	@Column(name = "T008_CODIGO")
	private String t008Codigo;

	@Column(name = "T008_FECULTACT")
	private Date t008Fecultact;

	@NotNull
	@Column(name = "T008_NOMBRE")
	private String t008Nombre;

	@Column(name = "T008_USUULTACT")
	private String t008Usuultact;

	@ManyToOne
	@JoinColumn(name = "T008_IDARETER", nullable = false, foreignKey = @ForeignKey(name = "FK1AS008"))
	private Tbasg007Areter t008Idareter;

	public Long getT008Iddepend() {
		return this.t008Iddepend;
	}

	public void setT008Iddepend(Long t008Iddepend) {
		this.t008Iddepend = t008Iddepend;
	}

	public String getT008Blactivo() {
		return this.t008Blactivo;
	}

	public String getT008Codigo() {
		return this.t008Codigo;
	}

	public Date getT008Fecultact() {
		return this.t008Fecultact;
	}

	public String getT008Nombre() {
		return this.t008Nombre;
	}

	public String getT008Usuultact() {
		return this.t008Usuultact;
	}

	public void setT008Blactivo(String t008Blactivo) {
		this.t008Blactivo = t008Blactivo;
	}

	public void setT008Codigo(String t008Codigo) {
		this.t008Codigo = t008Codigo;
	}

	public void setT008Fecultact(Date t008Fecultact) {
		this.t008Fecultact = t008Fecultact;
	}

	public void setT008Nombre(String t008Nombre) {
		this.t008Nombre = t008Nombre;
	}

	public void setT008Usuultact(String t008Usuultact) {
		this.t008Usuultact = t008Usuultact;
	}

	public Tbasg007Areter getT008Idareter() {
		return this.t008Idareter;
	}

	public void setT008Idareter(Tbasg007Areter t008Idareter) {
		this.t008Idareter = t008Idareter;
	}

}