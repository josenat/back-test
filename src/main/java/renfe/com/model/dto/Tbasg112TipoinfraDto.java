package renfe.com.model.dto;

import java.sql.Date;

public class Tbasg112TipoinfraDto {

	private Integer cdgoTipinfr;
	private String desgNombre;
	private String desgUsuact;
	private Date fchaAct;
	private String mrcaActivo;

	public Integer getCdgoTipinfr() {
		return this.cdgoTipinfr;
	}

	public void setCdgoTipinfr(Integer cdgoTipinfr) {
		this.cdgoTipinfr = cdgoTipinfr;
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