package renfe.com.model.dto;

import java.sql.Date;

public class Tbasg198AlcaformaDto {

	private String cdgoDestino;
	private Integer cdgoEstado;
	private String cdgoLinea;
	private String cdgoOrigen;
	private Integer cdgoSolicitud;
	private String desgDestino;
	private String desgLinea;
	private String desgOrigen;
	private String desgUsuact;
	private Date fchaAct;

	public String getCdgoDestino() {
		return this.cdgoDestino;
	}

	public void setCdgoDestino(String cdgoDestino) {
		this.cdgoDestino = cdgoDestino;
	}

	public Integer getCdgoEstado() {
		return this.cdgoEstado;
	}

	public void setCdgoEstado(Integer cdgoEstado) {
		this.cdgoEstado = cdgoEstado;
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

	public Integer getCdgoSolicitud() {
		return this.cdgoSolicitud;
	}

	public void setCdgoSolicitud(Integer cdgoSolicitud) {
		this.cdgoSolicitud = cdgoSolicitud;
	}

	public String getDesgDestino() {
		return this.desgDestino;
	}

	public void setDesgDestino(String desgDestino) {
		this.desgDestino = desgDestino;
	}

	public String getDesgLinea() {
		return this.desgLinea;
	}

	public void setDesgLinea(String desgLinea) {
		this.desgLinea = desgLinea;
	}

	public String getDesgOrigen() {
		return this.desgOrigen;
	}

	public void setDesgOrigen(String desgOrigen) {
		this.desgOrigen = desgOrigen;
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

}