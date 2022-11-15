package renfe.com.dto;

import java.sql.Timestamp;
import java.sql.Date;

public class GetTarjetaResultDTO {

	private String cdgoNumSerie;
	private Integer cdgoPersona;
	private boolean mrcaListaNegra;
	private Timestamp fchaListaNegra;
	private Date fchaExpedicion;
	private Date fchaExpiracion;
	private String desgUsuAct;
	private Date fchaAct;
	private boolean activo;

	public String getCdgoNumSerie() {
		return cdgoNumSerie;
	}

	public void setCdgoNumSerie(String cdgoNumSerie) {
		this.cdgoNumSerie = cdgoNumSerie;
	}

	public Integer getCdgoPersona() {
		return cdgoPersona;
	}

	public void setCdgoPersona(Integer cdgoPersona) {
		this.cdgoPersona = cdgoPersona;
	}

	public boolean getMrcaListaNegra() {
		return mrcaListaNegra;
	}

	public void setMrcaListaNegra(boolean mrcaListaNegra) {
		this.mrcaListaNegra = mrcaListaNegra;
	}

	public Timestamp getFchaListaNegra() {
		return fchaListaNegra;
	}

	public void setFchaListaNegra(Timestamp fchaListaNegra) {
		this.fchaListaNegra = fchaListaNegra;
	}

	public Date getFchaExpedicion() {
		return fchaExpedicion;
	}

	public void setFchaExpedicion(Date fchaExpedicion) {
		this.fchaExpedicion = fchaExpedicion;
	}

	public Date getFchaExpiracion() {
		return fchaExpiracion;
	}

	public void setFchaExpiracion(Date fchaExpiracion) {
		this.fchaExpiracion = fchaExpiracion;
	}

	public String getDesgUsuAct() {
		return desgUsuAct;
	}

	public void setDesgUsuAct(String desgUsuAct) {
		this.desgUsuAct = desgUsuAct;
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
