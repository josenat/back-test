package renfe.com.dto;

import java.sql.Timestamp;
import java.sql.Date;

public class GetEstahabinResultDTO {

	private Integer cdgoAlcHabInf;
	private Integer cdgoEstado;
	private Timestamp fchaEstado;
	private String usuAct;
	private Date fchaAct;
	private boolean activo;

	public Integer getCdgoAlcHabInf() {
		return cdgoAlcHabInf;
	}

	public void setCdgoAlcHabInf(Integer cdgoAlcHabInf) {
		this.cdgoAlcHabInf = cdgoAlcHabInf;
	}

	public Integer getCdgoEstado() {
		return cdgoEstado;
	}

	public void setCdgoEstado(Integer cdgoEstado) {
		this.cdgoEstado = cdgoEstado;
	}

	public Timestamp getFchaEstado() {
		return fchaEstado;
	}

	public void setFchaEstado(Timestamp fchaEstado) {
		this.fchaEstado = fchaEstado;
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
