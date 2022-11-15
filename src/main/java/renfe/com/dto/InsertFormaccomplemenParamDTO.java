package renfe.com.dto;

import java.sql.Date;

public class InsertFormaccomplemenParamDTO {

	private Integer cdgoPersona;
	private Integer cdgoCategoria;
	private Integer cdgoCualificacion;
	private String desgUsuact;
	private boolean activo;	
	private String fechaExpedicion;
	private String observaciones;
	private String mrcaActivo;

	public Integer getCdgoPersona() {
		return cdgoPersona;
	}

	public void setCdgoPersona(Integer cdgoPersona) {
		this.cdgoPersona = cdgoPersona;
	}

	public Integer getCdgoCategoria() {
		return cdgoCategoria;
	}

	public void setCdgoCategoria(Integer cdgoCategoria) {
		this.cdgoCategoria = cdgoCategoria;
	}

	public Integer getCdgoCualificacion() {
		return cdgoCualificacion;
	}

	public void setCdgoCualificacion(Integer cdgoCualificacion) {
		this.cdgoCualificacion = cdgoCualificacion;
	}

	public String getDesgUsuact() {
		return desgUsuact;
	}

	public void setDesgUsuact(String desgUsuact) {
		this.desgUsuact = desgUsuact;
	}

	public boolean getActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public String getFechaExpedicion() {
		return fechaExpedicion;
	}

	public void setFechaExpedicion(String fechaExpedicion) {
		this.fechaExpedicion = fechaExpedicion;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public String getMrcaActivo() {
		return mrcaActivo;
	}

	public void setMrcaActivo(String mrcaActivo) {
		this.mrcaActivo = mrcaActivo;
	}

}
