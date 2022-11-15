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
@Table(name = "TBASG060_CENSAN")
public class Tbasg060Censan {

	@Id
	@Column(name = "T060_IDCENTROSAN")
	private Long t060Idcentrosan;

	@Column(name = "T060_BLACTIVO")
	private String t060Blactivo;

	@NotNull
	@Column(name = "T060_CIFSAN")
	private String t060Cifsan;

	@NotNull
	@Column(name = "T060_CODIGO")
	private String t060Codigo;

	@NotNull
	@Column(name = "T060_DENEMP")
	private String t060Denemp;

	@NotNull
	@Column(name = "T060_DOMCEN")
	private String t060Domcen;

	@NotNull
	@Column(name = "T060_DOMSOC")
	private String t060Domsoc;

	@Column(name = "T060_FECULTACT")
	private Date t060Fecultact;

	@NotNull
	@Column(name = "T060_FHHOMOLOGA")
	private Date t060Fhhomologa;

	@NotNull
	@Column(name = "T060_FHVALIDEZ")
	private Date t060Fhvalidez;

	@NotNull
	@Column(name = "T060_NIFDIR")
	private String t060Nifdir;

	@NotNull
	@Column(name = "T060_NOMBRE")
	private String t060Nombre;

	@NotNull
	@Column(name = "T060_NOMDIR")
	private String t060Nomdir;

	@Column(name = "T060_USUULTACT")
	private String t060Usuultact;

	@ManyToOne
	@JoinColumn(name = "T060_IDAREASANI", nullable = false, foreignKey = @ForeignKey(name = "FK1AS060"))
	private Tbasg059Aresan t060Idareasani;

	@ManyToOne
	@JoinColumn(name = "T060_IDESTENV", nullable = false, foreignKey = @ForeignKey(name = "FK2AS060"))
	private Tbasg075Estenv t060Idestenv;

	public Long getT060Idcentrosan() {
		return this.t060Idcentrosan;
	}

	public void setT060Idcentrosan(Long t060Idcentrosan) {
		this.t060Idcentrosan = t060Idcentrosan;
	}

	public String getT060Blactivo() {
		return this.t060Blactivo;
	}

	public String getT060Cifsan() {
		return this.t060Cifsan;
	}

	public String getT060Codigo() {
		return this.t060Codigo;
	}

	public String getT060Denemp() {
		return this.t060Denemp;
	}

	public String getT060Domcen() {
		return this.t060Domcen;
	}

	public String getT060Domsoc() {
		return this.t060Domsoc;
	}

	public Date getT060Fecultact() {
		return this.t060Fecultact;
	}

	public Date getT060Fhhomologa() {
		return this.t060Fhhomologa;
	}

	public Date getT060Fhvalidez() {
		return this.t060Fhvalidez;
	}

	public String getT060Nifdir() {
		return this.t060Nifdir;
	}

	public String getT060Nombre() {
		return this.t060Nombre;
	}

	public String getT060Nomdir() {
		return this.t060Nomdir;
	}

	public String getT060Usuultact() {
		return this.t060Usuultact;
	}

	public void setT060Blactivo(String t060Blactivo) {
		this.t060Blactivo = t060Blactivo;
	}

	public void setT060Cifsan(String t060Cifsan) {
		this.t060Cifsan = t060Cifsan;
	}

	public void setT060Codigo(String t060Codigo) {
		this.t060Codigo = t060Codigo;
	}

	public void setT060Denemp(String t060Denemp) {
		this.t060Denemp = t060Denemp;
	}

	public void setT060Domcen(String t060Domcen) {
		this.t060Domcen = t060Domcen;
	}

	public void setT060Domsoc(String t060Domsoc) {
		this.t060Domsoc = t060Domsoc;
	}

	public void setT060Fecultact(Date t060Fecultact) {
		this.t060Fecultact = t060Fecultact;
	}

	public void setT060Fhhomologa(Date t060Fhhomologa) {
		this.t060Fhhomologa = t060Fhhomologa;
	}

	public void setT060Fhvalidez(Date t060Fhvalidez) {
		this.t060Fhvalidez = t060Fhvalidez;
	}

	public void setT060Nifdir(String t060Nifdir) {
		this.t060Nifdir = t060Nifdir;
	}

	public void setT060Nombre(String t060Nombre) {
		this.t060Nombre = t060Nombre;
	}

	public void setT060Nomdir(String t060Nomdir) {
		this.t060Nomdir = t060Nomdir;
	}

	public void setT060Usuultact(String t060Usuultact) {
		this.t060Usuultact = t060Usuultact;
	}

	public Tbasg059Aresan getT060Idareasani() {
		return this.t060Idareasani;
	}

	public Tbasg075Estenv getT060Idestenv() {
		return this.t060Idestenv;
	}

	public void setT060Idareasani(Tbasg059Aresan t060Idareasani) {
		this.t060Idareasani = t060Idareasani;
	}

	public void setT060Idestenv(Tbasg075Estenv t060Idestenv) {
		this.t060Idestenv = t060Idestenv;
	}

}