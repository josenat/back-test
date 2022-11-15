package renfe.com.dto;

import java.sql.Date;

public class GetAreTerListAscendenteDTO {

	private Integer cdgoAreact;
	private Integer cdgoAreter;
	private String desgNombre;
	private String desgUsuact;
	private Date fchaAct;
	private char mrcaActivo;
	private String nombreAreact;
	
	public Integer getCdgoAreact() {
		return cdgoAreact;
	}
	public void setCdgoAreact(Integer cdgoAreact) {
		this.cdgoAreact = cdgoAreact;
	}
	public Integer getCdgoAreter() {
		return cdgoAreter;
	}
	public void setCdgoAreter(Integer cdgoAreter) {
		this.cdgoAreter = cdgoAreter;
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
	public char getMrcaActivo() {
		return mrcaActivo;
	}
	public void setMrcaActivo(char mrcaActivo) {
		this.mrcaActivo = mrcaActivo;
	}
	public String getNombreAreact() {
		return nombreAreact;
	}
	public void setNombreAreact(String nombreAreact) {
		this.nombreAreact = nombreAreact;
	}
	
}
