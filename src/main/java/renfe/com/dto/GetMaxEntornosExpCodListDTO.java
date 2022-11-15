package renfe.com.dto;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetMaxEntornosExpCodListDTO {
	
	private String cdgoLinea;
	private String codEstOrigen;
	private String pkOrigen;
	private String desgNomLargoOrigen;
	private String codEstacionDestino;
	private String pkDestino;
	private String desgNomLargoDestino;
	private Date fchaestado;
	private String fchaestadoString;
	private String cdgoSociotor;
	private Integer cdgoExpediente;
	
	public String getCdgoLinea() {
		return cdgoLinea;
	}
	public void setCdgoLinea(String cdgoLinea) {
		this.cdgoLinea = cdgoLinea;
	}
	public String getCodEstOrigen() {
		return codEstOrigen;
	}
	public void setCodEstOrigen(String codEstOrigen) {
		this.codEstOrigen = codEstOrigen;
	}
	public String getPkOrigen() {
		return pkOrigen;
	}
	public void setPkOrigen(String pkOrigen) {
		this.pkOrigen = pkOrigen;
	}
	public String getDesgNomLargoOrigen() {
		return desgNomLargoOrigen;
	}
	public void setDesgNomLargoOrigen(String desgNomLargoOrigen) {
		this.desgNomLargoOrigen = desgNomLargoOrigen;
	}
	public String getCodEstacionDestino() {
		return codEstacionDestino;
	}
	public void setCodEstacionDestino(String codEstacionDestino) {
		this.codEstacionDestino = codEstacionDestino;
	}
	public String getPkDestino() {
		return pkDestino;
	}
	public void setPkDestino(String pkDestino) {
		this.pkDestino = pkDestino;
	}
	public String getDesgNomLargoDestino() {
		return desgNomLargoDestino;
	}
	public void setDesgNomLargoDestino(String desgNomLargoDestino) {
		this.desgNomLargoDestino = desgNomLargoDestino;
	}
	public Date getFchaestado() {
		return fchaestado;
	}
	public void setFchaestado(Date fchaestado) {
		this.fchaestado = fchaestado;
	}
	public String getCdgoSociotor() {
		return cdgoSociotor;
	}
	public void setCdgoSociotor(String cdgoSociotor) {
		this.cdgoSociotor = cdgoSociotor;
	}
	public Integer getCdgoExpediente() {
		return cdgoExpediente;
	}
	public void setCdgoExpediente(Integer cdgoExpediente) {
		this.cdgoExpediente = cdgoExpediente;
	}
	public String getFchaestadoString() {
		return fchaestadoString;
	}
	public void setFchaestadoString(String fchaestadoString) {
		this.fchaestadoString = fchaestadoString;
	}
	
}
