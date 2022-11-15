package renfe.com.model.dto;

import java.sql.Date;

public class Tbasg115CalificacDto {

	private Integer cdgoCalifi;
	private String desgNombre;
	private String desgTipocalif;
	private String desgUsuact;
	private Date fchaAct;
	private String mrcaActivo;

	public Integer getCdgoCalifi() {
		return this.cdgoCalifi;
	}

	public void setCdgoCalifi(Integer cdgoCalifi) {
		this.cdgoCalifi = cdgoCalifi;
	}

	public String getDesgNombre() {
		return this.desgNombre;
	}

	public void setDesgNombre(String desgNombre) {
		this.desgNombre = desgNombre;
	}

	public String getDesgTipocalif() {
		return this.desgTipocalif;
	}

	public void setDesgTipocalif(String desgTipocalif) {
		this.desgTipocalif = desgTipocalif;
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