package renfe.com.dto;

public class GetFccualificacionResultviewDTO {

	private Object cdgoCualificacion;
	private Object cdgoCategoria;
	private Object nombre;
	private Object descripcion;
	private Object usuAct;
	private Object fchaAct;
	private Object activo;
	private String desgCategoria;

	public Object getCdgoCualificacion() {
		return cdgoCualificacion;
	}

	public void setCdgoCualificacion(Object cdgoCualificacion) {
		this.cdgoCualificacion = cdgoCualificacion;
	}

	public Object getCdgoCategoria() {
		return cdgoCategoria;
	}

	public void setCdgoCategoria(Object cdgoCategoria) {
		this.cdgoCategoria = cdgoCategoria;
	}

	public Object getNombre() {
		return nombre;
	}

	public void setNombre(Object nombre) {
		this.nombre = nombre;
	}

	public Object getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(Object descripcion) {
		this.descripcion = descripcion;
	}

	public Object getUsuAct() {
		return usuAct;
	}

	public void setUsuAct(Object usuAct) {
		this.usuAct = usuAct;
	}

	public Object getFchaAct() {
		return fchaAct;
	}

	public void setFchaAct(Object fchaAct) {
		this.fchaAct = fchaAct;
	}

	public Object getActivo() {
		return activo;
	}

	public void setActivo(Object activo) {
		this.activo = activo;
	}

	public String getDesgCategoria() {
		return desgCategoria;
	}

	public void setDesgCategoria(String desgCategoria) {
		this.desgCategoria = desgCategoria;
	}

}
