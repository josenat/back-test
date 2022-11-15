package renfe.com.dto;

import java.sql.Date;

public class GetGcfiltrotramoResultDTO {

	private int cdgoFiltroTramo;
	private int cdgoFiltro;
	private String cdgoLinea;
	private String cdgoOrigen;
	private String cdgoDestino;
	private String usuAct;
	private Date fchaAct;

	public int getCdgoFiltroTramo() {
		return cdgoFiltroTramo;
	}

	public void setCdgoFiltroTramo(int cdgoFiltroTramo) {
		this.cdgoFiltroTramo = cdgoFiltroTramo;
	}

	public int getCdgoFiltro() {
		return cdgoFiltro;
	}

	public void setCdgoFiltro(int cdgoFiltro) {
		this.cdgoFiltro = cdgoFiltro;
	}

	public String getCdgoLinea() {
		return cdgoLinea;
	}

	public void setCdgoLinea(String cdgoLinea) {
		this.cdgoLinea = cdgoLinea;
	}

	public String getCdgoOrigen() {
		return cdgoOrigen;
	}

	public void setCdgoOrigen(String cdgoOrigen) {
		this.cdgoOrigen = cdgoOrigen;
	}

	public String getCdgoDestino() {
		return cdgoDestino;
	}

	public void setCdgoDestino(String cdgoDestino) {
		this.cdgoDestino = cdgoDestino;
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

}
