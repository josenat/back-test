package renfe.com.model.dto;

import java.sql.Date;

public class Tbasg264AmbitoPuertDto {

	private String cdgoPuerto;
	private String desgPuerto;
	private String desgUsuact;
	private Date fchaAct;
	private String mrcaActivo;

	public String getCdgoPuerto() {
		return this.cdgoPuerto;
	}

	public void setCdgoPuerto(String cdgoPuerto) {
		this.cdgoPuerto = cdgoPuerto;
	}

	public String getDesgPuerto() {
		return this.desgPuerto;
	}

	public void setDesgPuerto(String desgPuerto) {
		this.desgPuerto = desgPuerto;
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