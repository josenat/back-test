package renfe.com.model.dto;

import java.sql.Date;

public class Tbasg183BajaEstacionDto {

	private String cdgoEstacion;
	private String cdgoLinea;
	private String desgSoportedoc;
	private String desgUsuact;
	private Date fchaAct;

	public String getCdgoEstacion() {
		return this.cdgoEstacion;
	}

	public void setCdgoEstacion(String cdgoEstacion) {
		this.cdgoEstacion = cdgoEstacion;
	}

	public String getCdgoLinea() {
		return this.cdgoLinea;
	}

	public void setCdgoLinea(String cdgoLinea) {
		this.cdgoLinea = cdgoLinea;
	}

	public String getDesgSoportedoc() {
		return this.desgSoportedoc;
	}

	public void setDesgSoportedoc(String desgSoportedoc) {
		this.desgSoportedoc = desgSoportedoc;
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