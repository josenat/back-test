package renfe.com.dto;

import java.sql.Date;

public class GetPersonaEmpresaResultDTO {

	private Integer cdgoPersona;
	private Integer cdgoEmpresa;
	private String usuAct;
	private Date fchaAct;
	private boolean activo;
	private String desgEmpresa;

	public Integer getCdgoPersona() {
		return cdgoPersona;
	}

	public void setCdgoPersona(Integer cdgoPersona) {
		this.cdgoPersona = cdgoPersona;
	}

	public Integer getCdgoEmpresa() {
		return cdgoEmpresa;
	}

	public void setCdgoEmpresa(Integer cdgoEmpresa) {
		this.cdgoEmpresa = cdgoEmpresa;
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

	public String getDesgEmpresa() {
		return desgEmpresa;
	}

	public void setDesgEmpresa(String desgEmpresa) {
		this.desgEmpresa = desgEmpresa;
	}

}
