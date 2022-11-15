package renfe.com.model.dto;

import java.sql.Date;

public class Tbasg165TipoOpTarjetaDto {

	private String cdgoOperacion;
	private String desgOperacion;
	private String desgUsuact;
	private Date fchaAct;
	private String mrcaActivo;

	public String getCdgoOperacion() {
		return this.cdgoOperacion;
	}

	public void setCdgoOperacion(String cdgoOperacion) {
		this.cdgoOperacion = cdgoOperacion;
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