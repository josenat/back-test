package renfe.com.dto;

public class InsertAmbitoPuertoParamDTO {

	private String cdgoPuerto;
	private String desgPuerto;
	private String usuAct;
	private boolean activo;

	public String getCdgoPuerto() {
		return cdgoPuerto;
	}

	public void setCdgoPuerto(String cdgoPuerto) {
		this.cdgoPuerto = cdgoPuerto;
	}

	public String getDesgPuerto() {
		return desgPuerto;
	}

	public void setDesgPuerto(String desgPuerto) {
		this.desgPuerto = desgPuerto;
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
