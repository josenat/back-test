package renfe.com.dto;

public class GetDocinfrdestinatarioResultDTO {

	private Object cdgoDestinatario;
	private Object nombre;
	private Object nombrePila;
	private Object cargo;
	private Object direccionGnrl;
	private Object usuAct;
	private Object fchaAct;
	private Object activo;

	public Object getCdgoDestinatario() {
		return cdgoDestinatario;
	}

	public void setCdgoDestinatario(Object cdgoDestinatario) {
		this.cdgoDestinatario = cdgoDestinatario;
	}

	public Object getNombre() {
		return nombre;
	}

	public void setNombre(Object nombre) {
		this.nombre = nombre;
	}

	public Object getNombrePila() {
		return nombrePila;
	}

	public void setNombrePila(Object nombrePila) {
		this.nombrePila = nombrePila;
	}

	public Object getCargo() {
		return cargo;
	}

	public void setCargo(Object cargo) {
		this.cargo = cargo;
	}

	public Object getDireccionGnrl() {
		return direccionGnrl;
	}

	public void setDireccionGnrl(Object direccionGnrl) {
		this.direccionGnrl = direccionGnrl;
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

}
