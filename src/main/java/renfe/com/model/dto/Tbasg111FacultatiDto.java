package renfe.com.model.dto;

import java.sql.Date;

public class Tbasg111FacultatiDto {

	private Integer cdgoCenmed;
	private Integer cdgoFacult;
	private String desgApell1;
	private String desgApell2;
	private String desgNombre;
	private String desgNumcolegiado;
	private String desgUsuact;
	private Date fchaAct;
	private String mrcaActivo;

	public Integer getCdgoCenmed() {
		return this.cdgoCenmed;
	}

	public void setCdgoCenmed(Integer cdgoCenmed) {
		this.cdgoCenmed = cdgoCenmed;
	}

	public Integer getCdgoFacult() {
		return this.cdgoFacult;
	}

	public void setCdgoFacult(Integer cdgoFacult) {
		this.cdgoFacult = cdgoFacult;
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

	public String getDesgNumcolegiado() {
		return this.desgNumcolegiado;
	}

	public void setDesgNumcolegiado(String desgNumcolegiado) {
		this.desgNumcolegiado = desgNumcolegiado;
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