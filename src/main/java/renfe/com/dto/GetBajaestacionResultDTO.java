package renfe.com.dto;

import java.sql.Date;

public class GetBajaestacionResultDTO {

	private String cdgoEstacion;
	private String cdgoLinea;
	private String usuAct;
	private Date fchaAct;
	private String soporteDoc;

	public String getCdgoEstacion() {
		return cdgoEstacion;
	}

	public void setCdgoEstacion(String cdgoEstacion) {
		this.cdgoEstacion = cdgoEstacion;
	}

	public String getCdgoLinea() {
		return cdgoLinea;
	}

	public void setCdgoLinea(String cdgoLinea) {
		this.cdgoLinea = cdgoLinea;
	}

	public String getUsuAct() {
		return usuAct;
	}

	public void setUsuAct(String usuAct) {
		this.usuAct = usuAct;
	}

	public Date getFchaAct() {
		return fchaAct;
	}

	public void setFchaAct(Date fchaAct) {
		this.fchaAct = fchaAct;
	}

	public String getSoporteDoc() {
		return soporteDoc;
	}

	public void setSoporteDoc(String soporteDoc) {
		this.soporteDoc = soporteDoc;
	}

}
