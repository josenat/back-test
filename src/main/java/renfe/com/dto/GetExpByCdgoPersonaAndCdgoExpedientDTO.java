package renfe.com.dto;

import java.sql.Date;

public class GetExpByCdgoPersonaAndCdgoExpedientDTO {
	
	private Integer cdgoExpedient;
	private Integer cdgoTipoHabi;
	private String descTipoHabi;
	private Integer cdgoAmbitos;
	private String descAmbitos;
	private Integer cdgoEntorno;
	private String descEntorno;
	private Integer cdgoSerie;
	private String descSerie;
	private Integer cdgoPersona;
	private String desgObserva;
	private Character mrcaActivo;
	private String descEmpresa;
	private Date fchaExpediente;
	
	public Integer getCdgoExpedient() {
		return cdgoExpedient;
	}
	public void setCdgoExpedient(Integer cdgoExpedient) {
		this.cdgoExpedient = cdgoExpedient;
	}
	public Integer getCdgoTipoHabi() {
		return cdgoTipoHabi;
	}
	public void setCdgoTipoHabi(Integer cdgoTipoHabi) {
		this.cdgoTipoHabi = cdgoTipoHabi;
	}
	public String getDescTipoHabi() {
		return descTipoHabi;
	}
	public void setDescTipoHabi(String descTipoHabi) {
		this.descTipoHabi = descTipoHabi;
	}
	public Integer getCdgoAmbitos() {
		return cdgoAmbitos;
	}
	public void setCdgoAmbitos(Integer cdgoAmbitos) {
		this.cdgoAmbitos = cdgoAmbitos;
	}
	public String getDescAmbitos() {
		return descAmbitos;
	}
	public void setDescAmbitos(String descAmbitos) {
		this.descAmbitos = descAmbitos;
	}
	public Integer getCdgoEntorno() {
		return cdgoEntorno;
	}
	public void setCdgoEntorno(Integer cdgoEntorno) {
		this.cdgoEntorno = cdgoEntorno;
	}
	public String getDescEntorno() {
		return descEntorno;
	}
	public void setDescEntorno(String descEntorno) {
		this.descEntorno = descEntorno;
	}
	public Integer getCdgoSerie() {
		return cdgoSerie;
	}
	public void setCdgoSerie(Integer cdgoSerie) {
		this.cdgoSerie = cdgoSerie;
	}
	public String getDescSerie() {
		return descSerie;
	}
	public void setDescSerie(String descSerie) {
		this.descSerie = descSerie;
	}
	public Integer getCdgoPersona() {
		return cdgoPersona;
	}
	public void setCdgoPersona(Integer cdgoPersona) {
		this.cdgoPersona = cdgoPersona;
	}
	public String getDesgObserva() {
		return desgObserva;
	}
	public void setDesgObserva(String desgObservaExt) {
		this.desgObserva = desgObservaExt;
	}
	public Character getMrcaActivo() {
		return mrcaActivo;
	}
	public void setMrcaActivo(Character mrcaActivo) {
		this.mrcaActivo = mrcaActivo;
	}
	public String getDescEmpresa() {
		return descEmpresa;
	}
	public void setDescEmpresa(String descEmpresa) {
		this.descEmpresa = descEmpresa;
	}
	public Date getFchaExpediente() {
		return fchaExpediente;
	}
	public void setFchaExpediente(Date fchaExpediente) {
		this.fchaExpediente = fchaExpediente;
	}
	
}
