package renfe.com.model.dto;

import java.sql.Date;

public class Tbasg194DocInfrArtActivaDto {

	private Integer cdgoArticulo;
	private String desgArticulo;
	private String desgTipopersonal;
	private String desgUsuact;
	private Date fchaAct;
	private String mrcaActivo;

	public Integer getCdgoArticulo() {
		return this.cdgoArticulo;
	}

	public void setCdgoArticulo(Integer cdgoArticulo) {
		this.cdgoArticulo = cdgoArticulo;
	}

	public String getDesgArticulo() {
		return this.desgArticulo;
	}

	public void setDesgArticulo(String desgArticulo) {
		this.desgArticulo = desgArticulo;
	}

	public String getDesgTipopersonal() {
		return this.desgTipopersonal;
	}

	public void setDesgTipopersonal(String desgTipopersonal) {
		this.desgTipopersonal = desgTipopersonal;
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