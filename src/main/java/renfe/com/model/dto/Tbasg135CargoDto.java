package renfe.com.model.dto;

import java.sql.Date;

public class Tbasg135CargoDto {

	private String cdgoCargo;
	private String desgNombre;
	private String desgUsuact;
	private Date fchaAct;
	private String mrcaActivo;

	public String getCdgoCargo() {
		return this.cdgoCargo;
	}

	public void setCdgoCargo(String cdgoCargo) {
		this.cdgoCargo = cdgoCargo;
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

}