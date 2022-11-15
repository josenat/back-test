package renfe.com.dto;

import java.sql.Date;

public class UpdateActaincalParamDTO {

	private Integer cdgoCalif;
	private String cdgoIdInstru;
	private Date fchaCurso;
	private String usuAct;
	private boolean activo;
	private String codIdExa;
	private Integer cdgoActaForm;
	private String tipoCurso;

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

}
