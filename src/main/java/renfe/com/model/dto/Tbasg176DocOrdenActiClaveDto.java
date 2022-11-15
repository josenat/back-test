package renfe.com.model.dto;

import java.sql.Date;

public class Tbasg176DocOrdenActiClaveDto {

	private Integer cdgoClave;
	private String desgDescripcion;
	private String desgUsuact;
	private Date fchaAct;
	private String mrcaActivo;

	public Integer getCdgoClave() {
		return this.cdgoClave;
	}

	public void setCdgoClave(Integer cdgoClave) {
		this.cdgoClave = cdgoClave;
	}

	public String getDesgDescripcion() {
		return this.desgDescripcion;
	}

	public void setDesgDescripcion(String desgDescripcion) {
		this.desgDescripcion = desgDescripcion;
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