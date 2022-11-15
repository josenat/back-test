package renfe.com.model.dto;

import java.sql.Date;

public class Tbasg154OpTarjetaDto {

	private String cdgoNumserie;
	private String cdgoOperacion;
	private Integer cdgoPersona;
	private String desgUsuact;
	private String desgUsuario;
	private Date fchaAct;
	private String fchaOperacion;
	private String mrcaActivo;

	public String getCdgoNumserie() {
		return this.cdgoNumserie;
	}

	public void setCdgoNumserie(String cdgoNumserie) {
		this.cdgoNumserie = cdgoNumserie;
	}

	public String getCdgoOperacion() {
		return this.cdgoOperacion;
	}

	public void setCdgoOperacion(String cdgoOperacion) {
		this.cdgoOperacion = cdgoOperacion;
	}

	public Integer getCdgoPersona() {
		return this.cdgoPersona;
	}

	public void setCdgoPersona(Integer cdgoPersona) {
		this.cdgoPersona = cdgoPersona;
	}

	public String getDesgUsuact() {
		return this.desgUsuact;
	}

	public void setDesgUsuact(String desgUsuact) {
		this.desgUsuact = desgUsuact;
	}

	public String getDesgUsuario() {
		return this.desgUsuario;
	}

	public void setDesgUsuario(String desgUsuario) {
		this.desgUsuario = desgUsuario;
	}

	public Date getFchaAct() {
		return this.fchaAct;
	}

	public void setFchaAct(Date fchaAct) {
		this.fchaAct = fchaAct;
	}

	public String getFchaOperacion() {
		return this.fchaOperacion;
	}

	public void setFchaOperacion(String fchaOperacion) {
		this.fchaOperacion = fchaOperacion;
	}

	public String getMrcaActivo() {
		return this.mrcaActivo;
	}

	public void setMrcaActivo(String mrcaActivo) {
		this.mrcaActivo = mrcaActivo;
	}

}