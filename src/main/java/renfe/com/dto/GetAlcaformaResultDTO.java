package renfe.com.dto;

import java.sql.Date;

public class GetAlcaformaResultDTO {

	private Integer cdgoSolicitud;
	private String cdgoLinea;
	private String cdgoOrigen;
	private String cdgoDestino;
	private String linea;
	private String origen;
	private String destino;
	private Integer cdgoEstado;
	private String usuAct;
	private Date fchaAct;

	public Integer getCdgoSolicitud() {
		return cdgoSolicitud;
	}

	public void setCdgoSolicitud(Integer cdgoSolicitud) {
		this.cdgoSolicitud = cdgoSolicitud;
	}

	public String getCdgoLinea() {
		return cdgoLinea;
	}

	public void setCdgoLinea(String cdgoLinea) {
		this.cdgoLinea = cdgoLinea;
	}

	public String getCdgoOrigen() {
		return cdgoOrigen;
	}

	public void setCdgoOrigen(String cdgoOrigen) {
		this.cdgoOrigen = cdgoOrigen;
	}

	public String getCdgoDestino() {
		return cdgoDestino;
	}

	public void setCdgoDestino(String cdgoDestino) {
		this.cdgoDestino = cdgoDestino;
	}

	public String getLinea() {
		return linea;
	}

	public void setLinea(String linea) {
		this.linea = linea;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public Integer getCdgoEstado() {
		return cdgoEstado;
	}

	public void setCdgoEstado(Integer cdgoEstado) {
		this.cdgoEstado = cdgoEstado;
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
