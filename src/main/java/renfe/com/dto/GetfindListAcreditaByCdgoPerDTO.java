package renfe.com.dto;

import java.sql.Date;

public class GetfindListAcreditaByCdgoPerDTO {

	private Integer cdgoAcredita;
	private String desgAcredita;
	private String desgPuerto;
	private String desgLinea;
	private String desgNomLargo;
	private Date fchaAct;
	private String desgEstado;
	
	public Integer getCdgoAcredita() {
		return cdgoAcredita;
	}
	public void setCdgoAcredita(Integer cdgoAcredita) {
		this.cdgoAcredita = cdgoAcredita;
	}
	public String getDesgAcredita() {
		return desgAcredita;
	}
	public void setDesgAcredita(String desgAcredita) {
		this.desgAcredita = desgAcredita;
	}
	public String getDesgPuerto() {
		return desgPuerto;
	}
	public void setDesgPuerto(String desgPuerto) {
		this.desgPuerto = desgPuerto;
	}
	public String getDesgLinea() {
		return desgLinea;
	}
	public void setDesgLinea(String desgLinea) {
		this.desgLinea = desgLinea;
	}
	public String getDesgNomLargo() {
		return desgNomLargo;
	}
	public void setDesgNomLargo(String desgNomLargo) {
		this.desgNomLargo = desgNomLargo;
	}
	public Date getFchaAct() {
		return fchaAct;
	}
	public void setFchaAct(Date fchaAct) {
		this.fchaAct = fchaAct;
	}
	public String getDesgEstado() {
		return desgEstado;
	}
	public void setDesgEstado(String desgEstado) {
		this.desgEstado = desgEstado;
	}
	
}
