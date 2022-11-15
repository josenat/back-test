package renfe.com.dto;

import java.sql.Date;

public class UpdateInfracpersonaParamDTO {

	private Date fchaFhinfr;
	private String medidasDop;
	private Date fchaHasta;
	private Date fchaDesde;
	private int cdgoTipInfr;
	private int cdgoSancion;
	private int cdgoGrado;
	private String usuAct;
	private int cdgoInfrper;

	public Date getFchaFhinfr() {
		return fchaFhinfr;
	}

	public void setFchaFhinfr(Date fchaFhinfr) {
		this.fchaFhinfr = fchaFhinfr;
	}

	public String getMedidasDop() {
		return medidasDop;
	}

	public void setMedidasDop(String medidasDop) {
		this.medidasDop = medidasDop;
	}

	public Date getFchaHasta() {
		return fchaHasta;
	}

	public void setFchaHasta(Date fchaHasta) {
		this.fchaHasta = fchaHasta;
	}

	public Date getFchaDesde() {
		return fchaDesde;
	}

	public void setFchaDesde(Date fchaDesde) {
		this.fchaDesde = fchaDesde;
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

	public String getUsuAct() {
		return usuAct;
	}

	public void setUsuAct(String usuAct) {
		this.usuAct = usuAct;
	}

	public int getCdgoInfrper() {
		return cdgoInfrper;
	}

	public void setCdgoInfrper(int cdgoInfrper) {
		this.cdgoInfrper = cdgoInfrper;
	}

}
