package renfe.com.model.dto;

import java.sql.Date;

public class Tbasg169TipoAnotacionDto {

	private String cdgoTipoanotacion;
	private String desgOperacion;
	private String desgUsuact;
	private Date fchaAct;
	private String mrcaActivo;

	public String getCdgoTipoanotacion() {
		return this.cdgoTipoanotacion;
	}

	public void setCdgoTipoanotacion(String cdgoTipoanotacion) {
		this.cdgoTipoanotacion = cdgoTipoanotacion;
	}

	public String getDesgOperacion() {
		return this.desgOperacion;
	}

	public void setDesgOperacion(String desgOperacion) {
		this.desgOperacion = desgOperacion;
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