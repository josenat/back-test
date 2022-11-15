package renfe.com.dto;

import java.sql.Date;

public class InsertTituloParamDTO {

	private Integer cdgoPersona;
	private Date fchaOtorgado;
	private String tipTit;
	private String usuAct;
	private boolean activo;
	private String desgSoloRAM;
	private Date fchaTipEjerProf;

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

	public boolean getActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public String getDesgSoloRAM() {
		return desgSoloRAM;
	}

	public void setDesgSoloRAM(String desgSoloRAM) {
		this.desgSoloRAM = desgSoloRAM;
	}

	public Date getFchaTipEjerProf() {
		return fchaTipEjerProf;
	}

	public void setFchaTipEjerProf(Date fchaTipEjerProf) {
		this.fchaTipEjerProf = fchaTipEjerProf;
	}

}
