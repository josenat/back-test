package renfe.com.dto;

import java.sql.Date;

public class GetActaincalResultDTO {

	private Integer cdgoActaForm;
	private String tipoCurso;
	private Integer cdgoCalif;
	private String cdgoIdInstru;
	private Date fchaCurso;
	private String usuAct;
	private Date fchaAct;
	private boolean activo;
	private String codIdExa;

	public Integer getCdgoActaForm() {
		return cdgoActaForm;
	}

	public void setCdgoActaForm(Integer cdgoActaForm) {
		this.cdgoActaForm = cdgoActaForm;
	}

	public String getTipoCurso() {
		return tipoCurso;
	}

	public void setTipoCurso(String tipoCurso) {
		this.tipoCurso = tipoCurso;
	}

	public Integer getCdgoCalif() {
		return cdgoCalif;
	}

	public void setCdgoCalif(Integer cdgoCalif) {
		this.cdgoCalif = cdgoCalif;
	}

	public String getCdgoIdInstru() {
		return cdgoIdInstru;
	}

	public void setCdgoIdInstru(String cdgoIdInstru) {
		this.cdgoIdInstru = cdgoIdInstru;
	}

	public Date getFchaCurso() {
		return fchaCurso;
	}

	public void setFchaCurso(Date fchaCurso) {
		this.fchaCurso = fchaCurso;
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

	public String getCodIdExa() {
		return codIdExa;
	}

	public void setCodIdExa(String codIdExa) {
		this.codIdExa = codIdExa;
	}

}
