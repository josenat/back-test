package renfe.com.dto;

import java.sql.Date;

public class GetRespAreaListAscendenteDTO {

	private Integer cdgoAreact;
	private String desgCargo;
	private String desgResponsable;
	private String desgUsuact;
	private Date fchaAct;
	private String desgNombre;
	
	public Integer getCdgoAreact() {
		return cdgoAreact;
	}
	public void setCdgoAreact(Integer cdgoAreact) {
		this.cdgoAreact = cdgoAreact;
	}
	public String getDesgCargo() {
		return desgCargo;
	}
	public void setDesgCargo(String desgCargo) {
		this.desgCargo = desgCargo;
	}
	public String getDesgResponsable() {
		return desgResponsable;
	}
	public void setDesgResponsable(String desgResponsable) {
		this.desgResponsable = desgResponsable;
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
	public String getDesgNombre() {
		return desgNombre;
	}
	public void setDesgNombre(String desgNombre) {
		this.desgNombre = desgNombre;
	}
		
}
