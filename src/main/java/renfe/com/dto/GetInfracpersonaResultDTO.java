package renfe.com.dto;

import java.sql.Date;

public class GetInfracpersonaResultDTO {

	private int cdgoInfrper;
	private int cdgoPersona;
	private int cdgoTipInfr;
	private int cdgoSancion;
	private int cdgoGrado;
	private Date fchaFhinfr;
	private Date fchaDesde;
	private Date fchaHasta;
	private String usuAct;
	private Date fchaAct;
	private boolean activo;

	public int getCdgoInfrper() {
		return cdgoInfrper;
	}

	public void setCdgoInfrper(int cdgoInfrper) {
		this.cdgoInfrper = cdgoInfrper;
	}

	public int getCdgoPersona() {
		return cdgoPersona;
	}

	public void setCdgoPersona(int cdgoPersona) {
		this.cdgoPersona = cdgoPersona;
	}

	public int getCdgoTipInfr() {
		return cdgoTipInfr;
	}

	public void setCdgoTipInfr(int cdgoTipInfr) {
		this.cdgoTipInfr = cdgoTipInfr;
	}

	public int getCdgoSancion() {
		return cdgoSancion;
	}

	public void setCdgoSancion(int cdgoSancion) {
		this.cdgoSancion = cdgoSancion;
	}

	public int getCdgoGrado() {
		return cdgoGrado;
	}

	public void setCdgoGrado(int cdgoGrado) {
		this.cdgoGrado = cdgoGrado;
	}

	public Date getFchaFhinfr() {
		return fchaFhinfr;
	}

	public void setFchaFhinfr(Date fchaFhinfr) {
		this.fchaFhinfr = fchaFhinfr;
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
