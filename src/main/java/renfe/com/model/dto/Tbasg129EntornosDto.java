package renfe.com.model.dto;

import java.sql.Date;

public class Tbasg129EntornosDto {

	private Integer cdgoAreact;
	private Integer cdgoEntorno;
	private String desgNomcorto;
	private String desgNomentorno;
	private String desgUsuact;
	private Date fchaAct;
	private String mrcaActivo;

	public Integer getCdgoAreact() {
		return this.cdgoAreact;
	}

	public void setCdgoAreact(Integer cdgoAreact) {
		this.cdgoAreact = cdgoAreact;
	}

	public Integer getCdgoEntorno() {
		return this.cdgoEntorno;
	}

	public void setCdgoEntorno(Integer cdgoEntorno) {
		this.cdgoEntorno = cdgoEntorno;
	}

	public String getDesgNomcorto() {
		return this.desgNomcorto;
	}

	public void setDesgNomcorto(String desgNomcorto) {
		this.desgNomcorto = desgNomcorto;
	}

	public String getDesgNomentorno() {
		return this.desgNomentorno;
	}

	public void setDesgNomentorno(String desgNomentorno) {
		this.desgNomentorno = desgNomentorno;
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