package renfe.com.model.dto;

import java.sql.Date;

public class Tbasg138CursoseriDto {

	private Integer cdgoCursomat;
	private Integer cdgoCursoseri;
	private String cdgoSerie;
	private String cdgoSubserie;
	private String desgUsuact;
	private Date fchaAct;
	private String mrcaActivo;

	public Integer getCdgoCursomat() {
		return this.cdgoCursomat;
	}

	public void setCdgoCursomat(Integer cdgoCursomat) {
		this.cdgoCursomat = cdgoCursomat;
	}

	public Integer getCdgoCursoseri() {
		return this.cdgoCursoseri;
	}

	public void setCdgoCursoseri(Integer cdgoCursoseri) {
		this.cdgoCursoseri = cdgoCursoseri;
	}

	public String getCdgoSerie() {
		return this.cdgoSerie;
	}

	public void setCdgoSerie(String cdgoSerie) {
		this.cdgoSerie = cdgoSerie;
	}

	public String getCdgoSubserie() {
		return this.cdgoSubserie;
	}

	public void setCdgoSubserie(String cdgoSubserie) {
		this.cdgoSubserie = cdgoSubserie;
	}

	public String getDesgUsuact() {
		return this.desgUsuact;
	}

	public void setDesgUsuact(String desgUsuact) {
		this.desgUsuact = desgUsuact;
	}

	public Date getFchaAct() {
		return this.fchaAct;
	}

	public void setFchaAct(Date fchaAct) {
		this.fchaAct = fchaAct;
	}

	public String getMrcaActivo() {
		return this.mrcaActivo;
	}

	public void setMrcaActivo(String mrcaActivo) {
		this.mrcaActivo = mrcaActivo;
	}

}