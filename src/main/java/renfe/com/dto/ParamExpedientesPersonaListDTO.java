package renfe.com.dto;

import java.sql.Date;

public class ParamExpedientesPersonaListDTO {

	private Integer cdgoPersona;
	private Integer cdgoTipoHab;
	private Integer cdgoEmpresa;
	private Integer cdgoEstado;
	private Date    fchaDesde;
	private Date    fchaHasta;
	
	public Integer getCdgoPersona() {
		return cdgoPersona;
	}
	public void setCdgoPersona(Integer cdgoPersona) {
		this.cdgoPersona = cdgoPersona;
	}
	public Integer getCdgoTipoHab() {
		return cdgoTipoHab;
	}
	public void setCdgoTipoHab(Integer cdgoTipoHab) {
		this.cdgoTipoHab = cdgoTipoHab;
	}
	public Integer getCdgoEmpresa() {
		return cdgoEmpresa;
	}
	public void setCdgoEmpresa(Integer cdgoEmpresa) {
		this.cdgoEmpresa = cdgoEmpresa;
	}
	public Integer getCdgoEstado() {
		return cdgoEstado;
	}
	public void setCdgoEstado(Integer cdgoEstado) {
		this.cdgoEstado = cdgoEstado;
	}
	public Date getFchaDesde() {
		return fchaDesde;
	}
	public void setFchaDesde(Date fchaDesde) {
		this.fchaDesde = fchaDesde;
	}
	public Date getFchaHasta() {
		return fchaHasta;
	}
	public void setFchaHasta(Date fchaHasta) {
		this.fchaHasta = fchaHasta;
	}
	
}
