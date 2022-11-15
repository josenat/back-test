package renfe.com.dto;

import java.sql.Date;

public class GetTramosOrderByCodLineaDTO {

	private String cdgoLinea;
	private String cdgoEstacionOrigen;
	private String cdgoPkOrigen;
	private String desgNomLargoOrigen;
	private String cdgoEstacionDestino;
	private String cdgoPkDestino;
	private String desgNomLargoDestino;
	private Date fchaEstado;
	
	public String getCdgoLinea() {
		return cdgoLinea;
	}
	public void setCdgoLinea(String cdgoLinea) {
		this.cdgoLinea = cdgoLinea;
	}
	public String getCdgoEstacionOrigen() {
		return cdgoEstacionOrigen;
	}
	public void setCdgoEstacionOrigen(String cdgoEstacionOrigen) {
		this.cdgoEstacionOrigen = cdgoEstacionOrigen;
	}
	public String getCdgoPkOrigen() {
		return cdgoPkOrigen;
	}
	public void setCdgoPkOrigen(String cdgoPkOrigen) {
		this.cdgoPkOrigen = cdgoPkOrigen;
	}
	public String getDesgNomLargoOrigen() {
		return desgNomLargoOrigen;
	}
	public void setDesgNomLargoOrigen(String desgNomLargoOrigen) {
		this.desgNomLargoOrigen = desgNomLargoOrigen;
	}
	public String getCdgoEstacionDestino() {
		return cdgoEstacionDestino;
	}
	public void setCdgoEstacionDestino(String cdgoEstacionDestino) {
		this.cdgoEstacionDestino = cdgoEstacionDestino;
	}
	public String getCdgoPkDestino() {
		return cdgoPkDestino;
	}
	public void setCdgoPkDestino(String cdgoPkDestino) {
		this.cdgoPkDestino = cdgoPkDestino;
	}
	public String getDesgNomLargoDestino() {
		return desgNomLargoDestino;
	}
	public void setDesgNomLargoDestino(String desgNomLargoDestino) {
		this.desgNomLargoDestino = desgNomLargoDestino;
	}
	public Date getFchaEstado() {
		return fchaEstado;
	}
	public void setFchaEstado(Date fchaEstado) {
		this.fchaEstado = fchaEstado;
	}
	
}
