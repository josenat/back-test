package renfe.com.model.dto;

import java.sql.Date;

public class Tbasg130EntorlineDto {

	private String cdgoDestino;
	private Integer cdgoEntorno;
	private String cdgoLinea;
	private String cdgoOrigen;
	private String desgUsuact;
	private Date fchaAct;
	private String mrcaActivo;

	public String getCdgoDestino() {
		return this.cdgoDestino;
	}

	public void setCdgoDestino(String cdgoDestino) {
		this.cdgoDestino = cdgoDestino;
	}

	public Integer getCdgoEntorno() {
		return this.cdgoEntorno;
	}

	public void setCdgoEntorno(Integer cdgoEntorno) {
		this.cdgoEntorno = cdgoEntorno;
	}

	public String getCdgoLinea() {
		return this.cdgoLinea;
	}

	public void setCdgoLinea(String cdgoLinea) {
		this.cdgoLinea = cdgoLinea;
	}

	public String getCdgoOrigen() {
		return this.cdgoOrigen;
	}

	public void setCdgoOrigen(String cdgoOrigen) {
		this.cdgoOrigen = cdgoOrigen;
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