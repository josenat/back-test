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
@Table(name = "TBASG056_CENFOR")
public class Tbasg056Cenfor {

	@Id
	@Column(name = "T056_IDCENTROFOR")
	private Long t056Idcentrofor;

	@Column(name = "T056_BLACTIVO")
	private String t056Blactivo;

	@NotNull
	@Column(name = "T056_CIFFOR")
	private String t056Ciffor;

	@NotNull
	@Column(name = "T056_CODIGO")
	private String t056Codigo;

	@NotNull
	@Column(name = "T056_DENEMP")
	private String t056Denemp;

	@NotNull
	@Column(name = "T056_DOMCEN")
	private String t056Domcen;

	@NotNull
	@Column(name = "T056_DOMSOC")
	private String t056Domsoc;

	@Column(name = "T056_FECULTACT")
	private Date t056Fecultact;

	@NotNull
	@Column(name = "T056_FHHOMOLOGA")
	private Date t056Fhhomologa;

	@NotNull
	@Column(name = "T056_FHVALIDEZ")
	private Date t056Fhvalidez;

	@NotNull
	@Column(name = "T056_NIFDIR")
	private String t056Nifdir;

	@NotNull
	@Column(name = "T056_NOMBRE")
	private String t056Nombre;

	@NotNull
	@Column(name = "T056_NOMDIR")
	private String t056Nomdir;

	@Column(name = "T056_USUULTACT")
	private String t056Usuultact;

	@ManyToOne
	@JoinColumn(name = "T056_IDAREAFOR", nullable = false, foreignKey = @ForeignKey(name = "FK1AS056"))
	private Tbasg057Arefor t056Idareafor;

	@ManyToOne
	@JoinColumn(name = "T056_IDESTENV", nullable = false, foreignKey = @ForeignKey(name = "FK2AS056"))
	private Tbasg075Estenv t056Idestenv;

	public Long getT056Idcentrofor() {
		return this.t056Idcentrofor;
	}

	public void setT056Idcentrofor(Long t056Idcentrofor) {
		this.t056Idcentrofor = t056Idcentrofor;
	}

	public String getT056Blactivo() {
		return this.t056Blactivo;
	}

	public String getT056Ciffor() {
		return this.t056Ciffor;
	}

	public String getT056Codigo() {
		return this.t056Codigo;
	}

	public String getT056Denemp() {
		return this.t056Denemp;
	}

	public String getT056Domcen() {
		return this.t056Domcen;
	}

	public String getT056Domsoc() {
		return this.t056Domsoc;
	}

	public Date getT056Fecultact() {
		return this.t056Fecultact;
	}

	public Date getT056Fhhomologa() {
		return this.t056Fhhomologa;
	}

	public Date getT056Fhvalidez() {
		return this.t056Fhvalidez;
	}

	public String getT056Nifdir() {
		return this.t056Nifdir;
	}

	public String getT056Nombre() {
		return this.t056Nombre;
	}

	public String getT056Nomdir() {
		return this.t056Nomdir;
	}

	public String getT056Usuultact() {
		return this.t056Usuultact;
	}

	public void setT056Blactivo(String t056Blactivo) {
		this.t056Blactivo = t056Blactivo;
	}

	public void setT056Ciffor(String t056Ciffor) {
		this.t056Ciffor = t056Ciffor;
	}

	public void setT056Codigo(String t056Codigo) {
		this.t056Codigo = t056Codigo;
	}

	public void setT056Denemp(String t056Denemp) {
		this.t056Denemp = t056Denemp;
	}

	public void setT056Domcen(String t056Domcen) {
		this.t056Domcen = t056Domcen;
	}

	public void setT056Domsoc(String t056Domsoc) {
		this.t056Domsoc = t056Domsoc;
	}

	public void setT056Fecultact(Date t056Fecultact) {
		this.t056Fecultact = t056Fecultact;
	}

	public void setT056Fhhomologa(Date t056Fhhomologa) {
		this.t056Fhhomologa = t056Fhhomologa;
	}

	public void setT056Fhvalidez(Date t056Fhvalidez) {
		this.t056Fhvalidez = t056Fhvalidez;
	}

	public void setT056Nifdir(String t056Nifdir) {
		this.t056Nifdir = t056Nifdir;
	}

	public void setT056Nombre(String t056Nombre) {
		this.t056Nombre = t056Nombre;
	}

	public void setT056Nomdir(String t056Nomdir) {
		this.t056Nomdir = t056Nomdir;
	}

	public void setT056Usuultact(String t056Usuultact) {
		this.t056Usuultact = t056Usuultact;
	}

	public Tbasg057Arefor getT056Idareafor() {
		return this.t056Idareafor;
	}

	public Tbasg075Estenv getT056Idestenv() {
		return this.t056Idestenv;
	}

	public void setT056Idareafor(Tbasg057Arefor t056Idareafor) {
		this.t056Idareafor = t056Idareafor;
	}

	public void setT056Idestenv(Tbasg075Estenv t056Idestenv) {
		this.t056Idestenv = t056Idestenv;
	}

}