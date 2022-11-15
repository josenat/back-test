package renfe.com.model.dto;

import java.sql.Date;

public class Tbasg107TipoviaDto {

	private String cdgoSap;
	private Integer cdgoTipovia;
	private String desgNombre;
	private String desgUsuact;
	private Date fchaAct;
	private String mrcaActivo;

	public String getCdgoSap() {
		return this.cdgoSap;
	}

	public void setCdgoSap(String cdgoSap) {
		this.cdgoSap = cdgoSap;
	}

	public Integer getCdgoTipovia() {
		return this.cdgoTipovia;
	}

	public void setCdgoTipovia(Integer cdgoTipovia) {
		this.cdgoTipovia = cdgoTipovia;
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