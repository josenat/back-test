package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG189_FICH_FNMT_RESULT")
public class Tbasg189FichFnmtResult {

	@Id
	@Column(name = "CDGO_REGISTRO")
	private Long cdgoRegistro;

	@NotNull
	@Column(name = "CDGO_ESTADO")
	private String cdgoEstado;

	@NotNull
	@Column(name = "CDGO_FNMT")
	private Integer cdgoFnmt;

	@NotNull
	@Column(name = "CDGO_NUMSERIE")
	private String cdgoNumserie;

	@NotNull
	@Column(name = "CDGO_RFID")
	private String cdgoRfid;

	@Column(name = "FCHA_CORREOS")
	private Date fchaCorreos;

	@NotNull
	@Column(name = "PERSO_APELL1")
	private String persoApell1;

	@Column(name = "PERSO_APELL2")
	private String persoApell2;

	@NotNull
	@Column(name = "PERSO_MATRICULA")
	private String persoMatricula;

	@NotNull
	@Column(name = "PERSO_NIFPAS")
	private String persoNifpas;

	@NotNull
	@Column(name = "PERSO_NOMBRE")
	private String persoNombre;

	public Long getCdgoRegistro() {
		return this.cdgoRegistro;
	}

	public void setCdgoRegistro(Long cdgoRegistro) {
		this.cdgoRegistro = cdgoRegistro;
	}

	public String getCdgoEstado() {
		return this.cdgoEstado;
	}

	public Integer getCdgoFnmt() {
		return this.cdgoFnmt;
	}

	public String getCdgoNumserie() {
		return this.cdgoNumserie;
	}

	public String getCdgoRfid() {
		return this.cdgoRfid;
	}

	public Date getFchaCorreos() {
		return this.fchaCorreos;
	}

	public String getPersoApell1() {
		return this.persoApell1;
	}

	public String getPersoApell2() {
		return this.persoApell2;
	}

	public String getPersoMatricula() {
		return this.persoMatricula;
	}

	public String getPersoNifpas() {
		return this.persoNifpas;
	}

	public String getPersoNombre() {
		return this.persoNombre;
	}

	public void setCdgoEstado(String cdgoEstado) {
		this.cdgoEstado = cdgoEstado;
	}

	public void setCdgoFnmt(Integer cdgoFnmt) {
		this.cdgoFnmt = cdgoFnmt;
	}

	public void setCdgoNumserie(String cdgoNumserie) {
		this.cdgoNumserie = cdgoNumserie;
	}

	public void setCdgoRfid(String cdgoRfid) {
		this.cdgoRfid = cdgoRfid;
	}

	public void setFchaCorreos(Date fchaCorreos) {
		this.fchaCorreos = fchaCorreos;
	}

	public void setPersoApell1(String persoApell1) {
		this.persoApell1 = persoApell1;
	}

	public void setPersoApell2(String persoApell2) {
		this.persoApell2 = persoApell2;
	}

	public void setPersoMatricula(String persoMatricula) {
		this.persoMatricula = persoMatricula;
	}

	public void setPersoNifpas(String persoNifpas) {
		this.persoNifpas = persoNifpas;
	}

	public void setPersoNombre(String persoNombre) {
		this.persoNombre = persoNombre;
	}

}