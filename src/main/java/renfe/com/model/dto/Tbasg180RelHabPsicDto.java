package renfe.com.model.dto;

import java.sql.Date;

public class Tbasg180RelHabPsicDto {

	private Integer cdgoPsicamb;
	private Integer cdgoTipohab;
	private String desgUsuact;
	private Date fchaAct;

	public Integer getCdgoPsicamb() {
		return this.cdgoPsicamb;
	}

	public void setCdgoPsicamb(Integer cdgoPsicamb) {
		this.cdgoPsicamb = cdgoPsicamb;
	}

	public Integer getCdgoTipohab() {
		return this.cdgoTipohab;
	}

	public void setCdgoTipohab(Integer cdgoTipohab) {
		this.cdgoTipohab = cdgoTipohab;
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

}