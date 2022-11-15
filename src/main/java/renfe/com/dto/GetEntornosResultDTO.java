package renfe.com.dto;

import java.sql.Date;

public class GetEntornosResultDTO {

	private int cdgoEntorno;
	private String nomCorto;
	private String nomEntorno;
	private String usuAct;
	private Date fchaAct;
	private boolean activo;

	public int getCdgoEntorno() {
		return cdgoEntorno;
	}

	public void setCdgoEntorno(int cdgoEntorno) {
		this.cdgoEntorno = cdgoEntorno;
	}

	public String getNomCorto() {
		return nomCorto;
	}

	public void setNomCorto(String nomCorto) {
		this.nomCorto = nomCorto;
	}

	public String getNomEntorno() {
		return nomEntorno;
	}

	public void setNomEntorno(String nomEntorno) {
		this.nomEntorno = nomEntorno;
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
