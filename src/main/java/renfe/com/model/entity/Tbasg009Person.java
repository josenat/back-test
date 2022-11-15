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
@Table(name = "TBASG009_PERSON")
public class Tbasg009Person {

	@Id
	@Column(name = "T009_IDPERSON")
	private Long t009Idperson;

	@NotNull
	@Column(name = "T009_APELL1")
	private String t009Apell1;

	@NotNull
	@Column(name = "T009_APELL2")
	private String t009Apell2;

	@Column(name = "T009_BLACTIVO")
	private String t009Blactivo;

	@NotNull
	@Column(name = "T009_CODPOST")
	private String t009Codpost;

	@Column(name = "T009_EMAIL")
	private String t009Email;

	@Column(name = "T009_ESCALERA")
	private String t009Escalera;

	@NotNull
	@Column(name = "T009_FECCONT")
	private Date t009Feccont;

	@NotNull
	@Column(name = "T009_FECNAC")
	private Date t009Fecnac;

	@Column(name = "T009_FECPREST")
	private Date t009Fecprest;

	@Column(name = "T009_FECULTACT")
	private Date t009Fecultact;

	@Column(name = "T009_FORMADOR")
	private String t009Formador;

	@Column(name = "T009_MATRICULA")
	private String t009Matricula;

	@NotNull
	@Column(name = "T009_MUNICIP")
	private String t009Municip;

	@NotNull
	@Column(name = "T009_NACION")
	private String t009Nacion;

	@Column(name = "T009_NIF")
	private String t009Nif;

	@NotNull
	@Column(name = "T009_NOMBRE")
	private String t009Nombre;

	@Column(name = "T009_NUMREG")
	private String t009Numreg;

	@Column(name = "T009_NUMVIA")
	private String t009Numvia;

	@Column(name = "T009_PASAPORTE")
	private String t009Pasaporte;

	@Column(name = "T009_PLANTA")
	private String t009Planta;

	@Column(name = "T009_PUERTA")
	private String t009Puerta;

	@Column(name = "T009_REQMIN")
	private String t009Reqmin;

	@Column(name = "T009_RESIDENCIA")
	private String t009Residencia;

	@Column(name = "T009_USUULTACT")
	private String t009Usuultact;

	@NotNull
	@Column(name = "T009_VIA")
	private String t009Via;

	@ManyToOne
	@JoinColumn(name = "T009_IDCARGO", nullable = false, foreignKey = @ForeignKey(name = "FK1AS009"))
	private Tbasg010Cargos t009Idcargo;

	@ManyToOne
	@JoinColumn(name = "T009_IDDEPEND", nullable = false, foreignKey = @ForeignKey(name = "FK2AS009"))
	private Tbasg008Depend t009Iddepend;

	@ManyToOne
	@JoinColumn(name = "T009_IDTIPVIA", nullable = false, foreignKey = @ForeignKey(name = "FK3AS009"))
	private Tbasg051Tipvia t009Idtipvia;

	@ManyToOne
	@JoinColumn(name = "T009_IDFUNCAR", nullable = false, foreignKey = @ForeignKey(name = "FK5AS009"))
	private Tbasg011Funcar t009Idfuncar;

	@ManyToOne
	@JoinColumn(name = "T009_IDPROVIN", nullable = false, foreignKey = @ForeignKey(name = "FK6AS009"))
	private Tbasg050Provin t009Idprovin;

	@ManyToOne
	@JoinColumn(name = "T009_IDESTENV", nullable = false, foreignKey = @ForeignKey(name = "FK7AS009"))
	private Tbasg075Estenv t009Idestenv;

	public Long getT009Idperson() {
		return this.t009Idperson;
	}

	public void setT009Idperson(Long t009Idperson) {
		this.t009Idperson = t009Idperson;
	}

	public String getT009Apell1() {
		return this.t009Apell1;
	}

	public String getT009Apell2() {
		return this.t009Apell2;
	}

	public String getT009Blactivo() {
		return this.t009Blactivo;
	}

	public String getT009Codpost() {
		return this.t009Codpost;
	}

	public String getT009Email() {
		return this.t009Email;
	}

	public String getT009Escalera() {
		return this.t009Escalera;
	}

	public Date getT009Feccont() {
		return this.t009Feccont;
	}

	public Date getT009Fecnac() {
		return this.t009Fecnac;
	}

	public Date getT009Fecprest() {
		return this.t009Fecprest;
	}

	public Date getT009Fecultact() {
		return this.t009Fecultact;
	}

	public String getT009Formador() {
		return this.t009Formador;
	}

	public String getT009Matricula() {
		return this.t009Matricula;
	}

	public String getT009Municip() {
		return this.t009Municip;
	}

	public String getT009Nacion() {
		return this.t009Nacion;
	}

	public String getT009Nif() {
		return this.t009Nif;
	}

	public String getT009Nombre() {
		return this.t009Nombre;
	}

	public String getT009Numreg() {
		return this.t009Numreg;
	}

	public String getT009Numvia() {
		return this.t009Numvia;
	}

	public String getT009Pasaporte() {
		return this.t009Pasaporte;
	}

	public String getT009Planta() {
		return this.t009Planta;
	}

	public String getT009Puerta() {
		return this.t009Puerta;
	}

	public String getT009Reqmin() {
		return this.t009Reqmin;
	}

	public String getT009Residencia() {
		return this.t009Residencia;
	}

	public String getT009Usuultact() {
		return this.t009Usuultact;
	}

	public String getT009Via() {
		return this.t009Via;
	}

	public void setT009Apell1(String t009Apell1) {
		this.t009Apell1 = t009Apell1;
	}

	public void setT009Apell2(String t009Apell2) {
		this.t009Apell2 = t009Apell2;
	}

	public void setT009Blactivo(String t009Blactivo) {
		this.t009Blactivo = t009Blactivo;
	}

	public void setT009Codpost(String t009Codpost) {
		this.t009Codpost = t009Codpost;
	}

	public void setT009Email(String t009Email) {
		this.t009Email = t009Email;
	}

	public void setT009Escalera(String t009Escalera) {
		this.t009Escalera = t009Escalera;
	}

	public void setT009Feccont(Date t009Feccont) {
		this.t009Feccont = t009Feccont;
	}

	public void setT009Fecnac(Date t009Fecnac) {
		this.t009Fecnac = t009Fecnac;
	}

	public void setT009Fecprest(Date t009Fecprest) {
		this.t009Fecprest = t009Fecprest;
	}

	public void setT009Fecultact(Date t009Fecultact) {
		this.t009Fecultact = t009Fecultact;
	}

	public void setT009Formador(String t009Formador) {
		this.t009Formador = t009Formador;
	}

	public void setT009Matricula(String t009Matricula) {
		this.t009Matricula = t009Matricula;
	}

	public void setT009Municip(String t009Municip) {
		this.t009Municip = t009Municip;
	}

	public void setT009Nacion(String t009Nacion) {
		this.t009Nacion = t009Nacion;
	}

	public void setT009Nif(String t009Nif) {
		this.t009Nif = t009Nif;
	}

	public void setT009Nombre(String t009Nombre) {
		this.t009Nombre = t009Nombre;
	}

	public void setT009Numreg(String t009Numreg) {
		this.t009Numreg = t009Numreg;
	}

	public void setT009Numvia(String t009Numvia) {
		this.t009Numvia = t009Numvia;
	}

	public void setT009Pasaporte(String t009Pasaporte) {
		this.t009Pasaporte = t009Pasaporte;
	}

	public void setT009Planta(String t009Planta) {
		this.t009Planta = t009Planta;
	}

	public void setT009Puerta(String t009Puerta) {
		this.t009Puerta = t009Puerta;
	}

	public void setT009Reqmin(String t009Reqmin) {
		this.t009Reqmin = t009Reqmin;
	}

	public void setT009Residencia(String t009Residencia) {
		this.t009Residencia = t009Residencia;
	}

	public void setT009Usuultact(String t009Usuultact) {
		this.t009Usuultact = t009Usuultact;
	}

	public void setT009Via(String t009Via) {
		this.t009Via = t009Via;
	}

	public Tbasg010Cargos getT009Idcargo() {
		return this.t009Idcargo;
	}

	public Tbasg008Depend getT009Iddepend() {
		return this.t009Iddepend;
	}

	public Tbasg051Tipvia getT009Idtipvia() {
		return this.t009Idtipvia;
	}

	public Tbasg011Funcar getT009Idfuncar() {
		return this.t009Idfuncar;
	}

	public Tbasg050Provin getT009Idprovin() {
		return this.t009Idprovin;
	}

	public Tbasg075Estenv getT009Idestenv() {
		return this.t009Idestenv;
	}

	public void setT009Idcargo(Tbasg010Cargos t009Idcargo) {
		this.t009Idcargo = t009Idcargo;
	}

	public void setT009Iddepend(Tbasg008Depend t009Iddepend) {
		this.t009Iddepend = t009Iddepend;
	}

	public void setT009Idtipvia(Tbasg051Tipvia t009Idtipvia) {
		this.t009Idtipvia = t009Idtipvia;
	}

	public void setT009Idfuncar(Tbasg011Funcar t009Idfuncar) {
		this.t009Idfuncar = t009Idfuncar;
	}

	public void setT009Idprovin(Tbasg050Provin t009Idprovin) {
		this.t009Idprovin = t009Idprovin;
	}

	public void setT009Idestenv(Tbasg075Estenv t009Idestenv) {
		this.t009Idestenv = t009Idestenv;
	}

}