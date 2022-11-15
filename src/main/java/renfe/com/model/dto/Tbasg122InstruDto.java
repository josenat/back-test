package renfe.com.model.dto;

import java.sql.Date;

import renfe.com.model.entity.Tbasg100Persona;

public class Tbasg122InstruDto {

	private String cdgoNif;
	private String desgApell1;
	private String desgApell2;
	private String desgNombre;
	private String desgUsuact;
	private Date fchaAct;
	private String mrcaActivo;
	private String mrcaExaminador;
	private String mrcaInstructor;
	private Tbasg100Persona tbasg100Persona;
	
	

	public Tbasg122InstruDto() {
		// TODO Auto-generated constructor stub
	}

	public Tbasg122InstruDto(String cdgoNif, String desgApell1, String desgApell2, String desgNombre, String desgUsuact,
			Date fchaAct, String mrcaActivo, String mrcaExaminador, String mrcaInstructor,
			Tbasg100Persona tbasg100Persona) {
		super();
		this.cdgoNif = cdgoNif;
		this.desgApell1 = desgApell1;
		this.desgApell2 = desgApell2;
		this.desgNombre = desgNombre;
		this.desgUsuact = desgUsuact;
		this.fchaAct = fchaAct;
		this.mrcaActivo = mrcaActivo;
		this.mrcaExaminador = mrcaExaminador;
		this.mrcaInstructor = mrcaInstructor;
		this.tbasg100Persona = tbasg100Persona;
	}




	public Tbasg100Persona getTbasg100Persona() {
		return tbasg100Persona;
	}

	public void setTbasg100Persona(Tbasg100Persona tbasg100Persona) {
		this.tbasg100Persona = tbasg100Persona;
	}

	public String getCdgoNif() {
		return this.cdgoNif;
	}

	public void setCdgoNif(String cdgoNif) {
		this.cdgoNif = cdgoNif;
	}

	public String getDesgApell1() {
		return this.desgApell1;
	}

	public void setDesgApell1(String desgApell1) {
		this.desgApell1 = desgApell1;
	}

	public String getDesgApell2() {
		return this.desgApell2;
	}

	public void setDesgApell2(String desgApell2) {
		this.desgApell2 = desgApell2;
	}

	public String getDesgNombre() {
		return this.desgNombre;
	}

	public void setDesgNombre(String desgNombre) {
		this.desgNombre = desgNombre;
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

	public String getMrcaExaminador() {
		return this.mrcaExaminador;
	}

	public void setMrcaExaminador(String mrcaExaminador) {
		this.mrcaExaminador = mrcaExaminador;
	}

	public String getMrcaInstructor() {
		return this.mrcaInstructor;
	}

	public void setMrcaInstructor(String mrcaInstructor) {
		this.mrcaInstructor = mrcaInstructor;
	}

}