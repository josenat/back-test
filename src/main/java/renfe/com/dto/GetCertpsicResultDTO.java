package renfe.com.dto;

import java.sql.Date;

public class GetCertpsicResultDTO {

	private Integer cdgoCertPsic;
	private Integer cdgoPersona;
	private Date fchaProxRev;
	private Date fchaReconoc;
	private String observacion;
	private Date fchaLimTemp;
	private boolean corrVisual;
	private boolean protAud;
	private Integer cdgoCenMed;
	private Integer cdgoMotivo;
	private Integer cdgoPsicAmb;
	private Integer cdgoFacult;
	private Integer cdgoCalifi;
	private String usuAct;
	private Date fchaAct;
	private boolean activo;

	public Integer getCdgoCertPsic() {
		return cdgoCertPsic;
	}

	public void setCdgoCertPsic(Integer cdgoCertPsic) {
		this.cdgoCertPsic = cdgoCertPsic;
	}

	public Integer getCdgoPersona() {
		return cdgoPersona;
	}

	public void setCdgoPersona(Integer cdgoPersona) {
		this.cdgoPersona = cdgoPersona;
	}

	public Date getFchaProxRev() {
		return fchaProxRev;
	}

	public void setFchaProxRev(Date fchaProxRev) {
		this.fchaProxRev = fchaProxRev;
	}

	public Date getFchaReconoc() {
		return fchaReconoc;
	}

	public void setFchaReconoc(Date fchaReconoc) {
		this.fchaReconoc = fchaReconoc;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Date getFchaLimTemp() {
		return fchaLimTemp;
	}

	public void setFchaLimTemp(Date fchaLimTemp) {
		this.fchaLimTemp = fchaLimTemp;
	}

	public boolean getCorrVisual() {
		return corrVisual;
	}

	public void setCorrVisual(boolean corrVisual) {
		this.corrVisual = corrVisual;
	}

	public boolean getProtAud() {
		return protAud;
	}

	public void setProtAud(boolean protAud) {
		this.protAud = protAud;
	}

	public Integer getCdgoCenMed() {
		return cdgoCenMed;
	}

	public void setCdgoCenMed(Integer cdgoCenMed) {
		this.cdgoCenMed = cdgoCenMed;
	}

	public Integer getCdgoMotivo() {
		return cdgoMotivo;
	}

	public void setCdgoMotivo(Integer cdgoMotivo) {
		this.cdgoMotivo = cdgoMotivo;
	}

	public Integer getCdgoPsicAmb() {
		return cdgoPsicAmb;
	}

	public void setCdgoPsicAmb(Integer cdgoPsicAmb) {
		this.cdgoPsicAmb = cdgoPsicAmb;
	}

	public Integer getCdgoFacult() {
		return cdgoFacult;
	}

	public void setCdgoFacult(Integer cdgoFacult) {
		this.cdgoFacult = cdgoFacult;
	}

	public Integer getCdgoCalifi() {
		return cdgoCalifi;
	}

	public void setCdgoCalifi(Integer cdgoCalifi) {
		this.cdgoCalifi = cdgoCalifi;
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

	public boolean getActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

}
