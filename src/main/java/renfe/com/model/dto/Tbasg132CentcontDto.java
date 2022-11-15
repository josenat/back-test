package renfe.com.model.dto;

import java.sql.Date;

public class Tbasg132CentcontDto {

	private Integer cdgoAreter;
	private String cdgoCentcont;
	private String desgBuzoncorreo;
	private String desgNombre;
	private String desgUsuact;
	private Date fchaAct;
	private String mrcaActivo;

	public Integer getCdgoAreter() {
		return this.cdgoAreter;
	}

	public void setCdgoAreter(Integer cdgoAreter) {
		this.cdgoAreter = cdgoAreter;
	}

	public String getCdgoCentcont() {
		return this.cdgoCentcont;
	}

	public void setCdgoCentcont(String cdgoCentcont) {
		this.cdgoCentcont = cdgoCentcont;
	}

	public String getDesgBuzoncorreo() {
		return this.desgBuzoncorreo;
	}

	public void setDesgBuzoncorreo(String desgBuzoncorreo) {
		this.desgBuzoncorreo = desgBuzoncorreo;
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