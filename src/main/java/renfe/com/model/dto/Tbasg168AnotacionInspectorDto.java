package renfe.com.model.dto;

import java.sql.Date;

public class Tbasg168AnotacionInspectorDto {

	private Integer cdgoAnotacion;
	private Integer cdgoPersona;
	private String cdgoTipoanotacion;
	private String desgAnotacion;
	private String desgUsuario;
	private Date fchaAlta;

	public Integer getCdgoAnotacion() {
		return this.cdgoAnotacion;
	}

	public void setCdgoAnotacion(Integer cdgoAnotacion) {
		this.cdgoAnotacion = cdgoAnotacion;
	}

	public Integer getCdgoPersona() {
		return this.cdgoPersona;
	}

	public void setCdgoPersona(Integer cdgoPersona) {
		this.cdgoPersona = cdgoPersona;
	}

	public String getCdgoTipoanotacion() {
		return this.cdgoTipoanotacion;
	}

	public void setCdgoTipoanotacion(String cdgoTipoanotacion) {
		this.cdgoTipoanotacion = cdgoTipoanotacion;
	}

	public String getDesgAnotacion() {
		return this.desgAnotacion;
	}

	public void setDesgAnotacion(String desgAnotacion) {
		this.desgAnotacion = desgAnotacion;
	}

	public String getDesgUsuario() {
		return this.desgUsuario;
	}

	public void setDesgUsuario(String desgUsuario) {
		this.desgUsuario = desgUsuario;
	}

	public Date getFchaAlta() {
		return this.fchaAlta;
	}

	public void setFchaAlta(Date fchaAlta) {
		this.fchaAlta = fchaAlta;
	}

}