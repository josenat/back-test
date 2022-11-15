package renfe.com.dto;

import java.sql.Date;
import java.sql.Timestamp;

public class GetEstadosMasExpDTO {
	private Integer cdgoExpedient;
	private Integer cdgoEstado;
	private String desgNombre;
	private Timestamp fchaEstado;
	private Character mrcaActivo;
	
	public Integer getCdgoExpedient() {
		return cdgoExpedient;
	}
	public void setCdgoExpedient(Integer cdgoExpedient) {
		this.cdgoExpedient = cdgoExpedient;
	}
	public Integer getCdgoEstado() {
		return cdgoEstado;
	}
	public void setCdgoEstado(Integer cdgoEstado) {
		this.cdgoEstado = cdgoEstado;
	}
	public String getDesgNombre() {
		return desgNombre;
	}
	public void setDesgNombre(String desgNombre) {
		this.desgNombre = desgNombre;
	}
	public Timestamp getFchaEstado() {
		return fchaEstado;
	}
	public void setFchaEstado(Timestamp fchaEstado) {
		this.fchaEstado = fchaEstado;
	}
	public Character getMrcaActivo() {
		return mrcaActivo;
	}
	public void setMrcaActivo(Character mrcaActivo) {
		this.mrcaActivo = mrcaActivo;
	}
	
	
}
