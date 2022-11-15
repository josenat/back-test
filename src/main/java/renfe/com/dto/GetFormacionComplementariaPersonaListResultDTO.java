package renfe.com.dto;

import java.sql.Date;

public class GetFormacionComplementariaPersonaListResultDTO {

	//private Object cdgoPersona;
	//private Object cdgoCategoria;
	private Integer cdgoPersona;
	private Integer cdgoCategoria;
	private String categoria;
	private String cualificacion;
	//private Object cdgoCualificacion;
	private Integer cdgoCualificacion;
	private String desgCualificacion;
	//private Object activo;
	private String activo;
	//private Object fechaExpedicion;
	private Date fechaExpedicion;
	private String observaciones;

	private String desgUsuact;

	
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
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getCualificacion() {
		return cualificacion;
	}
	public void setCualificacion(String cualificacion) {
		this.cualificacion = cualificacion;
	}
	public Integer getCdgoCualificacion() {
		return cdgoCualificacion;
	}
	public void setCdgoCualificacion(Integer cdgoCualificacion) {
		this.cdgoCualificacion = cdgoCualificacion;
	}
	public String getDesgCualificacion() {
		return desgCualificacion;
	}
	public void setDesgCualificacion(String desgCualificacion) {
		this.desgCualificacion = desgCualificacion;
	}
	public String getActivo() {
		return activo;
	}
	public void setActivo(String activo) {
		this.activo = activo;
	}
	public Date getFechaExpedicion() {
		return fechaExpedicion;
	}
	public void setFechaExpedicion(Date fechaExpedicion) {
		this.fechaExpedicion = fechaExpedicion;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public String getDesgUsuact() {
		return desgUsuact;
	}
	public void setDesgUsuact(String desgUsuact) {
		this.desgUsuact = desgUsuact;
	}	

}
