package renfe.com.model.dto;

import java.sql.Date;

public class Tbasg265AmbitoLineaDto {

	private String cdgoLinea;
	private String desgLinea;
	private String desgUsuact;
	private Date fchaAct;
	private String mrcaActivo;

	public String getCdgoLinea() {
		return this.cdgoLinea;
	}

	public void setCdgoLinea(String cdgoLinea) {
		this.cdgoLinea = cdgoLinea;
	}

	public String getDesgLinea() {
		return this.desgLinea;
	}

	public void setDesgLinea(String desgLinea) {
		this.desgLinea = desgLinea;
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