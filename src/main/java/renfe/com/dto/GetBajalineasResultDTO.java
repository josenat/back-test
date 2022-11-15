package renfe.com.dto;

import java.sql.Date;

public class GetBajalineasResultDTO {

	private String cdgoLinea;
	private String soporteDoc;
	private String usuAct;
	private Date fchaAct;

	public String getCdgoLinea() {
		return cdgoLinea;
	}

	public void setCdgoLinea(String cdgoLinea) {
		this.cdgoLinea = cdgoLinea;
	}

	public String getSoporteDoc() {
		return soporteDoc;
	}

	public void setSoporteDoc(String soporteDoc) {
		this.soporteDoc = soporteDoc;
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

}
