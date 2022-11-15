package renfe.com.dto;

public class InsertEntorlineParamDTO {

	private int cdgoEntorno;
	private String cdgoLinea;
	private String cdgoOrigen;
	private String cdgoDestino;
	private String usuAct;
	private boolean activo;

	public int getCdgoEntorno() {
		return cdgoEntorno;
	}

	public void setCdgoEntorno(int cdgoEntorno) {
		this.cdgoEntorno = cdgoEntorno;
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

	public boolean getActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

}
