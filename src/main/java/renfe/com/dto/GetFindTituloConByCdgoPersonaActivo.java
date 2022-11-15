package renfe.com.dto;

import java.sql.Date;

public class GetFindTituloConByCdgoPersonaActivo {

	private Integer cdgoTit;
	private Integer cdgoPersona;
	private Date fchaOtorgado;
	private Integer cdgoEstado;
	
	public Integer getCdgoTit() {
		return cdgoTit;
	}
	public void setCdgoTit(Integer cdgoTit) {
		this.cdgoTit = cdgoTit;
	}
	public Integer getCdgoPersona() {
		return cdgoPersona;
	}
	public void setCdgoPersona(Integer cdgoPersona) {
		this.cdgoPersona = cdgoPersona;
	}
	public Date getFchaOtorgado() {
		return fchaOtorgado;
	}
	public void setFchaOtorgado(Date fchaOtorgado) {
		this.fchaOtorgado = fchaOtorgado;
	}
	public Integer getCdgoEstado() {
		return cdgoEstado;
	}
	public void setCdgoEstado(Integer cdgoEstado) {
		this.cdgoEstado = cdgoEstado;
	}
		
}
