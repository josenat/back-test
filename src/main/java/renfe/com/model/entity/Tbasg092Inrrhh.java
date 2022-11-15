package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG092_INRRHH")
public class Tbasg092Inrrhh {

	@Id
	@Column(name = "T092_IDINTERFAZ")
	private Long t092Idinterfaz;

	@NotNull
	@Column(name = "T092_APELL1")
	private String t092Apell1;

	@NotNull
	@Column(name = "T092_APELL2")
	private String t092Apell2;

	@NotNull
	@Column(name = "T092_AREACT")
	private String t092Areact;

	@NotNull
	@Column(name = "T092_ARETER")
	private String t092Areter;

	@Column(name = "T092_DEOBS")
	private String t092Deobs;

	@NotNull
	@Column(name = "T092_DEPENDENCIA")
	private String t092Dependencia;

	@Column(name = "T092_FECCARGA")
	private Date t092Feccarga;

	@Column(name = "T092_INDICADOR")
	private String t092Indicador;

	@Column(name = "T092_MATRICULA")
	private String t092Matricula;

	@Column(name = "T092_NIF")
	private String t092Nif;

	@NotNull
	@Column(name = "T092_NOMBRE")
	private String t092Nombre;

	@Column(name = "T092_USUCARGA")
	private String t092Usucarga;

	public Long getT092Idinterfaz() {
		return this.t092Idinterfaz;
	}

	public void setT092Idinterfaz(Long t092Idinterfaz) {
		this.t092Idinterfaz = t092Idinterfaz;
	}

	public String getT092Apell1() {
		return this.t092Apell1;
	}

	public String getT092Apell2() {
		return this.t092Apell2;
	}

	public String getT092Areact() {
		return this.t092Areact;
	}

	public String getT092Areter() {
		return this.t092Areter;
	}

	public String getT092Deobs() {
		return this.t092Deobs;
	}

	public String getT092Dependencia() {
		return this.t092Dependencia;
	}

	public Date getT092Feccarga() {
		return this.t092Feccarga;
	}

	public String getT092Indicador() {
		return this.t092Indicador;
	}

	public String getT092Matricula() {
		return this.t092Matricula;
	}

	public String getT092Nif() {
		return this.t092Nif;
	}

	public String getT092Nombre() {
		return this.t092Nombre;
	}

	public String getT092Usucarga() {
		return this.t092Usucarga;
	}

	public void setT092Apell1(String t092Apell1) {
		this.t092Apell1 = t092Apell1;
	}

	public void setT092Apell2(String t092Apell2) {
		this.t092Apell2 = t092Apell2;
	}

	public void setT092Areact(String t092Areact) {
		this.t092Areact = t092Areact;
	}

	public void setT092Areter(String t092Areter) {
		this.t092Areter = t092Areter;
	}

	public void setT092Deobs(String t092Deobs) {
		this.t092Deobs = t092Deobs;
	}

	public void setT092Dependencia(String t092Dependencia) {
		this.t092Dependencia = t092Dependencia;
	}

	public void setT092Feccarga(Date t092Feccarga) {
		this.t092Feccarga = t092Feccarga;
	}

	public void setT092Indicador(String t092Indicador) {
		this.t092Indicador = t092Indicador;
	}

	public void setT092Matricula(String t092Matricula) {
		this.t092Matricula = t092Matricula;
	}

	public void setT092Nif(String t092Nif) {
		this.t092Nif = t092Nif;
	}

	public void setT092Nombre(String t092Nombre) {
		this.t092Nombre = t092Nombre;
	}

	public void setT092Usucarga(String t092Usucarga) {
		this.t092Usucarga = t092Usucarga;
	}

}