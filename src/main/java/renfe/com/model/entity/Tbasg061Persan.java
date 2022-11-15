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
@Table(name = "TBASG061_PERSAN")
public class Tbasg061Persan {

	@Id
	@Column(name = "T061_IDSANITARIO")
	private Long t061Idsanitario;

	@NotNull
	@Column(name = "T061_APELL1")
	private String t061Apell1;

	@NotNull
	@Column(name = "T061_APELL2")
	private String t061Apell2;

	@Column(name = "T061_BLACTIVO")
	private String t061Blactivo;

	@Column(name = "T061_FECULTACT")
	private Date t061Fecultact;

	@NotNull
	@Column(name = "T061_NIF")
	private String t061Nif;

	@NotNull
	@Column(name = "T061_NOMBRE")
	private String t061Nombre;

	@Column(name = "T061_USUULTACT")
	private String t061Usuultact;

	@ManyToOne
	@JoinColumn(name = "T061_IDCENTROSAN", nullable = false, foreignKey = @ForeignKey(name = "FK1AS061"))
	private Tbasg060Censan t061Idcentrosan;

	@ManyToOne
	@JoinColumn(name = "T061_IDESTENV", nullable = false, foreignKey = @ForeignKey(name = "FK2AS061"))
	private Tbasg075Estenv t061Idestenv;

	public Long getT061Idsanitario() {
		return this.t061Idsanitario;
	}

	public void setT061Idsanitario(Long t061Idsanitario) {
		this.t061Idsanitario = t061Idsanitario;
	}

	public String getT061Apell1() {
		return this.t061Apell1;
	}

	public String getT061Apell2() {
		return this.t061Apell2;
	}

	public String getT061Blactivo() {
		return this.t061Blactivo;
	}

	public Date getT061Fecultact() {
		return this.t061Fecultact;
	}

	public String getT061Nif() {
		return this.t061Nif;
	}

	public String getT061Nombre() {
		return this.t061Nombre;
	}

	public String getT061Usuultact() {
		return this.t061Usuultact;
	}

	public void setT061Apell1(String t061Apell1) {
		this.t061Apell1 = t061Apell1;
	}

	public void setT061Apell2(String t061Apell2) {
		this.t061Apell2 = t061Apell2;
	}

	public void setT061Blactivo(String t061Blactivo) {
		this.t061Blactivo = t061Blactivo;
	}

	public void setT061Fecultact(Date t061Fecultact) {
		this.t061Fecultact = t061Fecultact;
	}

	public void setT061Nif(String t061Nif) {
		this.t061Nif = t061Nif;
	}

	public void setT061Nombre(String t061Nombre) {
		this.t061Nombre = t061Nombre;
	}

	public void setT061Usuultact(String t061Usuultact) {
		this.t061Usuultact = t061Usuultact;
	}

	public Tbasg060Censan getT061Idcentrosan() {
		return this.t061Idcentrosan;
	}

	public Tbasg075Estenv getT061Idestenv() {
		return this.t061Idestenv;
	}

	public void setT061Idcentrosan(Tbasg060Censan t061Idcentrosan) {
		this.t061Idcentrosan = t061Idcentrosan;
	}

	public void setT061Idestenv(Tbasg075Estenv t061Idestenv) {
		this.t061Idestenv = t061Idestenv;
	}

}