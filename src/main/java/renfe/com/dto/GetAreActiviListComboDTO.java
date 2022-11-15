package renfe.com.dto;

import java.sql.Date;

public class GetAreActiviListComboDTO {

	private Integer cdgoAreact;
	private String desgNombre;
	private String desgUsuact;
	private Date fchaAct;
	private String mrcaActivo;
	private String cdgoSociedad;
	private String descSociedad;
	
	public Integer getCdgoAreact() {
		return cdgoAreact;
	}
	public void setCdgoAreact(Integer cdgoAreact) {
		this.cdgoAreact = cdgoAreact;
	}
	public String getDesgNombre() {
		return desgNombre;
	}
	public void setDesgNombre(String desgNombre) {
		this.desgNombre = desgNombre;
	}
	public String getDesgUsuact() {
		return desgUsuact;
	}
	public void setDesgUsuact(String desgUsuact) {
		this.desgUsuact = desgUsuact;
	}
	public Date getFchaAct() {
		return fchaAct;
	}
	public void setFchaAct(Date fchaAct) {
		this.fchaAct = fchaAct;
	}
	public String getMrcaActivo() {
		return mrcaActivo;
	}
	public void setMrcaActivo(String mrcaActivo) {
		this.mrcaActivo = mrcaActivo;
	}
	public String getCdgoSociedad() {
		return cdgoSociedad;
	}
	public void setCdgoSociedad(String cdgoSociedad) {
		this.cdgoSociedad = cdgoSociedad;
	}
	public String getDescSociedad() {
		return descSociedad;
	}
	public void setDescSociedad(String descSociedad) {
		this.descSociedad = descSociedad;
	}

}
