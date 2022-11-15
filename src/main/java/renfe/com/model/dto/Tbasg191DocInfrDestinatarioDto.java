package renfe.com.model.dto;

import java.sql.Date;

public class Tbasg191DocInfrDestinatarioDto {

	private Integer cdgoDestinatario;
	private String desgCargo;
	private String desgDirecciongnrl;
	private String desgNombre;
	private String desgNombrepila;
	private String desgUsuact;
	private Date fchaAct;
	private String mrcaActivo;

	public Integer getCdgoDestinatario() {
		return this.cdgoDestinatario;
	}

	public void setCdgoDestinatario(Integer cdgoDestinatario) {
		this.cdgoDestinatario = cdgoDestinatario;
	}

	public String getDesgCargo() {
		return this.desgCargo;
	}

	public void setDesgCargo(String desgCargo) {
		this.desgCargo = desgCargo;
	}

	public String getDesgDirecciongnrl() {
		return this.desgDirecciongnrl;
	}

	public void setDesgDirecciongnrl(String desgDirecciongnrl) {
		this.desgDirecciongnrl = desgDirecciongnrl;
	}

	public String getDesgNombre() {
		return this.desgNombre;
	}

	public void setDesgNombre(String desgNombre) {
		this.desgNombre = desgNombre;
	}

	public String getDesgNombrepila() {
		return this.desgNombrepila;
	}

	public void setDesgNombrepila(String desgNombrepila) {
		this.desgNombrepila = desgNombrepila;
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