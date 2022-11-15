package renfe.com.dto;

import java.sql.Date;

public class GetSubserieResultDTO {

	private String cdgoSubSerie;
	private String cdgoSerie;
	private String usuAct;
	private Date fchaAct;
	private boolean activo;

	public String getCdgoSubSerie() {
		return cdgoSubSerie;
	}

	public void setCdgoSubSerie(String cdgoSubSerie) {
		this.cdgoSubSerie = cdgoSubSerie;
	}

	public String getCdgoSerie() {
		return cdgoSerie;
	}

	public void setCdgoSerie(String cdgoSerie) {
		this.cdgoSerie = cdgoSerie;
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

	public boolean getActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

}
