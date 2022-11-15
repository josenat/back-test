package renfe.com.dto;

import java.sql.Date;

public class GetInfracpersonaResultviewDTO {

	private int cdgoInfrper;
	private int cdgoPersona;
	private int cdgoTipInfr;
	private int cdgoSancion;
	private int cdgoGrado;
	private String tipoInfra;
	private Date fchaFhinfr;
	private String grado;
	private String sancion;
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

	public String getTipoInfra() {
		return tipoInfra;
	}

	public void setTipoInfra(String tipoInfra) {
		this.tipoInfra = tipoInfra;
	}

	public Date getFchaFhinfr() {
		return fchaFhinfr;
	}

	public void setFchaFhinfr(Date fchaFhinfr) {
		this.fchaFhinfr = fchaFhinfr;
	}

	public String getGrado() {
		return grado;
	}

	public void setGrado(String grado) {
		this.grado = grado;
	}

	public String getSancion() {
		return sancion;
	}

	public void setSancion(String sancion) {
		this.sancion = sancion;
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
