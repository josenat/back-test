package renfe.com.dto;

public class GetTramosExpInfrResultDTO {

	private Object cdgoAlcHabInf;
	private Object linea;
	private Object origen;
	private Object destino;
	private Object cdgoEstado;
	private Object fchaEstado;

	public Object getCdgoAlcHabInf() {
		return cdgoAlcHabInf;
	}

	public void setCdgoAlcHabInf(Object cdgoAlcHabInf) {
		this.cdgoAlcHabInf = cdgoAlcHabInf;
	}

	public Object getLinea() {
		return linea;
	}

	public void setLinea(Object linea) {
		this.linea = linea;
	}

	public Object getOrigen() {
		return origen;
	}

	public void setOrigen(Object origen) {
		this.origen = origen;
	}

	public Object getDestino() {
		return destino;
	}

	public void setDestino(Object destino) {
		this.destino = destino;
	}

	public Object getCdgoEstado() {
		return cdgoEstado;
	}

	public void setCdgoEstado(Object cdgoEstado) {
		this.cdgoEstado = cdgoEstado;
	}

	public Object getFchaEstado() {
		return fchaEstado;
	}

	public void setFchaEstado(Object fchaEstado) {
		this.fchaEstado = fchaEstado;
	}

}
