package renfe.com.dto;

import java.sql.Date;

public class GetEstacLineResultDTO {

	private String cdgoEstacion;
	private String cdgoLinea;
	private int cdgoOrden;
	private float cdgoPK;
	private String nomCorto;
	private String nomLargo;
	private String usuAct;
	private Date fchaAct;
	private String soporteDoc;
	private boolean activo;

	public String getCdgoEstacion() {
		return cdgoEstacion;
	}

	public void setCdgoEstacion(String cdgoEstacion) {
		this.cdgoEstacion = cdgoEstacion;
	}

	public String getCdgoLinea() {
		return cdgoLinea;
	}

	public void setCdgoLinea(String cdgoLinea) {
		this.cdgoLinea = cdgoLinea;
	}

	public int getCdgoOrden() {
		return cdgoOrden;
	}

	public void setCdgoOrden(int cdgoOrden) {
		this.cdgoOrden = cdgoOrden;
	}

	public float getCdgoPK() {
		return cdgoPK;
	}

	public void setCdgoPK(float cdgoPK) {
		this.cdgoPK = cdgoPK;
	}

	public String getNomCorto() {
		return nomCorto;
	}

	public void setNomCorto(String nomCorto) {
		this.nomCorto = nomCorto;
	}

	public String getNomLargo() {
		return nomLargo;
	}

	public void setNomLargo(String nomLargo) {
		this.nomLargo = nomLargo;
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

	public String getSoporteDoc() {
		return soporteDoc;
	}

	public void setSoporteDoc(String soporteDoc) {
		this.soporteDoc = soporteDoc;
	}

	public boolean getActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

}
