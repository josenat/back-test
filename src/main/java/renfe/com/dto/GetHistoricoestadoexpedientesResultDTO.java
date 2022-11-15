package renfe.com.dto;

public class GetHistoricoestadoexpedientesResultDTO {

	private Object cdgoExpedient;
	private Object estado;
	private Object fecha;
	private Object usuario;

	public Object getCdgoExpedient() {
		return cdgoExpedient;
	}

	public void setCdgoExpedient(Object cdgoExpedient) {
		this.cdgoExpedient = cdgoExpedient;
	}

	public Object getEstado() {
		return estado;
	}

	public void setEstado(Object estado) {
		this.estado = estado;
	}

	public Object getFecha() {
		return fecha;
	}

	public void setFecha(Object fecha) {
		this.fecha = fecha;
	}

	public Object getUsuario() {
		return usuario;
	}

	public void setUsuario(Object usuario) {
		this.usuario = usuario;
	}

}
