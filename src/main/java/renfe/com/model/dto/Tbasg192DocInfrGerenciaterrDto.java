package renfe.com.model.dto;

import java.sql.Date;

public class Tbasg192DocInfrGerenciaterrDto {

	private Integer cdgoGerencia;
	private String desgDireccion;
	private String desgNombre;
	private String desgResponsable;
	private String desgUsuact;
	private String desgZona;
	private Date fchaAct;
	private String mrcaActivo;

	public Integer getCdgoGerencia() {
		return this.cdgoGerencia;
	}

	public void setCdgoGerencia(Integer cdgoGerencia) {
		this.cdgoGerencia = cdgoGerencia;
	}

	public String getDesgDireccion() {
		return this.desgDireccion;
	}

	public void setDesgDireccion(String desgDireccion) {
		this.desgDireccion = desgDireccion;
	}

	public String getDesgNombre() {
		return this.desgNombre;
	}

	public void setDesgNombre(String desgNombre) {
		this.desgNombre = desgNombre;
	}

	public String getDesgResponsable() {
		return this.desgResponsable;
	}

	public void setDesgResponsable(String desgResponsable) {
		this.desgResponsable = desgResponsable;
	}

	public String getDesgUsuact() {
		return this.desgUsuact;
	}

	public void setDesgUsuact(String desgUsuact) {
		this.desgUsuact = desgUsuact;
	}

	public String getDesgZona() {
		return this.desgZona;
	}

	public void setDesgZona(String desgZona) {
		this.desgZona = desgZona;
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