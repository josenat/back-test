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
@Table(name = "TBASG058_INSTRU")
public class Tbasg058Instru {

	@Id
	@Column(name = "T058_IDINSTRU")
	private Long t058Idinstru;

	@NotNull
	@Column(name = "T058_APELL1")
	private String t058Apell1;

	@NotNull
	@Column(name = "T058_APELL2")
	private String t058Apell2;

	@Column(name = "T058_BLACTIVO")
	private String t058Blactivo;

	@Column(name = "T058_FECULTACT")
	private Date t058Fecultact;

	@NotNull
	@Column(name = "T058_NIF")
	private String t058Nif;

	@NotNull
	@Column(name = "T058_NOMBRE")
	private String t058Nombre;

	@Column(name = "T058_USUULTACT")
	private String t058Usuultact;

	@ManyToOne
	@JoinColumn(name = "T058_IDCENTROFOR", nullable = false, foreignKey = @ForeignKey(name = "FK1AS058"))
	private Tbasg056Cenfor t058Idcentrofor;

	@ManyToOne
	@JoinColumn(name = "T058_IDESTENV", nullable = false, foreignKey = @ForeignKey(name = "FK2AS058"))
	private Tbasg075Estenv t058Idestenv;

	public Long getT058Idinstru() {
		return this.t058Idinstru;
	}

	public void setT058Idinstru(Long t058Idinstru) {
		this.t058Idinstru = t058Idinstru;
	}

	public String getT058Apell1() {
		return this.t058Apell1;
	}

	public String getT058Apell2() {
		return this.t058Apell2;
	}

	public String getT058Blactivo() {
		return this.t058Blactivo;
	}

	public Date getT058Fecultact() {
		return this.t058Fecultact;
	}

	public String getT058Nif() {
		return this.t058Nif;
	}

	public String getT058Nombre() {
		return this.t058Nombre;
	}

	public String getT058Usuultact() {
		return this.t058Usuultact;
	}

	public void setT058Apell1(String t058Apell1) {
		this.t058Apell1 = t058Apell1;
	}

	public void setT058Apell2(String t058Apell2) {
		this.t058Apell2 = t058Apell2;
	}

	public void setT058Blactivo(String t058Blactivo) {
		this.t058Blactivo = t058Blactivo;
	}

	public void setT058Fecultact(Date t058Fecultact) {
		this.t058Fecultact = t058Fecultact;
	}

	public void setT058Nif(String t058Nif) {
		this.t058Nif = t058Nif;
	}

	public void setT058Nombre(String t058Nombre) {
		this.t058Nombre = t058Nombre;
	}

	public void setT058Usuultact(String t058Usuultact) {
		this.t058Usuultact = t058Usuultact;
	}

	public Tbasg056Cenfor getT058Idcentrofor() {
		return this.t058Idcentrofor;
	}

	public Tbasg075Estenv getT058Idestenv() {
		return this.t058Idestenv;
	}

	public void setT058Idcentrofor(Tbasg056Cenfor t058Idcentrofor) {
		this.t058Idcentrofor = t058Idcentrofor;
	}

	public void setT058Idestenv(Tbasg075Estenv t058Idestenv) {
		this.t058Idestenv = t058Idestenv;
	}

}