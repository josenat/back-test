package renfe.com.dto;

import java.sql.Date;

public class GetTipooptarjetaResultDTO {

	private String cdgoOperacion;
	private String operacion;
	private String usuact;
	private Date fchaAct;
	private boolean activo;

	public String getCdgoOperacion() {
		return cdgoOperacion;
	}

	public void setCdgoOperacion(String cdgoOperacion) {
		this.cdgoOperacion = cdgoOperacion;
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
