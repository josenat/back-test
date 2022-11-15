package renfe.com.dto;

import java.sql.Date;

public class UpdateActaincalParamMantenimientoDTO {

	private String tipoCurso;
	private Integer cdgoCalifi;
	private String cdgoIdInstru;
	private Date fchaCurso;
	private String usuAct;
	private Integer cdgoActaFormacion;
	private String tipoCursoWhere;

	public String getTipoCurso() {
		return tipoCurso;
	}

	public void setTipoCurso(String tipoCurso) {
		this.tipoCurso = tipoCurso;
	}

	public Integer getCdgoCalifi() {
		return cdgoCalifi;
	}

	public void setCdgoCalifi(Integer cdgoCalifi) {
		this.cdgoCalifi = cdgoCalifi;
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

	public Integer getCdgoActaFormacion() {
		return cdgoActaFormacion;
	}

	public void setCdgoActaFormacion(Integer cdgoActaFormacion) {
		this.cdgoActaFormacion = cdgoActaFormacion;
	}

	public String getTipoCursoWhere() {
		return tipoCursoWhere;
	}

	public void setTipoCursoWhere(String tipoCursoWhere) {
		this.tipoCursoWhere = tipoCursoWhere;
	}

}
