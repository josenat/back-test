package renfe.com.model.dto;

import java.sql.Date;

public class Tbasg109PsicoambiDto {

	private Integer cdgoPsicamb;
	private Integer cdgoPsicambFom;
	private String desgNombre;
	private String desgUsuact;
	private Date fchaAct;
	private String mrcaActivo;

	public Integer getCdgoPsicamb() {
		return this.cdgoPsicamb;
	}

	public void setCdgoPsicamb(Integer cdgoPsicamb) {
		this.cdgoPsicamb = cdgoPsicamb;
	}

	public Integer getCdgoPsicambFom() {
		return this.cdgoPsicambFom;
	}

	public void setCdgoPsicambFom(Integer cdgoPsicambFom) {
		this.cdgoPsicambFom = cdgoPsicambFom;
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