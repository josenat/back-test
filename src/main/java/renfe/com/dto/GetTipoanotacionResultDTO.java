package renfe.com.dto;

import java.sql.Date;

public class GetTipoanotacionResultDTO {

	private String cdgoTipoAnotacion;
	private String operacion;
	private String usuact;
	private Date fchaAct;
	private boolean activo;

	public String getCdgoTipoAnotacion() {
		return cdgoTipoAnotacion;
	}

	public void setCdgoTipoAnotacion(String cdgoTipoAnotacion) {
		this.cdgoTipoAnotacion = cdgoTipoAnotacion;
	}

	public String getOperacion() {
		return operacion;
	}

	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}

	public String getUsuact() {
		return usuact;
	}

	public void setUsuact(String usuact) {
		this.usuact = usuact;
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
