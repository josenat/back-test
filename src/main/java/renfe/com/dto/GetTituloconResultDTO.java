package renfe.com.dto;

import java.sql.Date;

public class GetTituloconResultDTO {

	private int cdgoTit;
	private int cdgoPersona;
	private Date fchaOtorgado;
	private String tipTit;
	private String usuAct;
	private Date fchaAct;
	private String desgSoloRAM;
	private boolean activo;
	private Date fchaTipEjerProf;

	public int getCdgoTit() {
		return cdgoTit;
	}

	public void setCdgoTit(int cdgoTit) {
		this.cdgoTit = cdgoTit;
	}

	public int getCdgoPersona() {
		return cdgoPersona;
	}

	public void setCdgoPersona(int cdgoPersona) {
		this.cdgoPersona = cdgoPersona;
	}

	public Date getFchaOtorgado() {
		return fchaOtorgado;
	}

	public void setFchaOtorgado(Date fchaOtorgado) {
		this.fchaOtorgado = fchaOtorgado;
	}

	public String getTipTit() {
		return tipTit;
	}

	public void setTipTit(String tipTit) {
		this.tipTit = tipTit;
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

	public String getDesgSoloRAM() {
		return desgSoloRAM;
	}

	public void setDesgSoloRAM(String desgSoloRAM) {
		this.desgSoloRAM = desgSoloRAM;
	}

	public boolean getActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public Date getFchaTipEjerProf() {
		return fchaTipEjerProf;
	}

	public void setFchaTipEjerProf(Date fchaTipEjerProf) {
		this.fchaTipEjerProf = fchaTipEjerProf;
	}

}
