package renfe.com.dto;

import java.sql.Date;

public class InsertActaincalParamDTO {

	private Integer cdgoActaForm;
	private String tipoCurso;
	private Integer cdgoCalif;
	private String cdgoIdInstru;
	private String fchaCurso;
	private String usuAct;
	private String activo;
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

	public String getFchaCurso() {
		return fchaCurso;
	}

	public void setFchaCurso(String fchaCurso) {
		this.fchaCurso = fchaCurso;
	}

	public String getUsuAct() {
		return usuAct;
	}

	public void setUsuAct(String usuAct) {
		this.usuAct = usuAct;
	}

	public String getActivo() {
		return activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public String getCodIdExa() {
		return codIdExa;
	}

	public void setCodIdExa(String codIdExa) {
		this.codIdExa = codIdExa;
	}

}
