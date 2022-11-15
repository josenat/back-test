package renfe.com.dto;

public class InsertCentcontParamDTO {

	private String cdgoCentCont;
	private int cdgoAreTer;
	private String nombre;
	private String usuAct;
	private boolean activo;
	private String buzonCorreo;

	public String getCdgoCentCont() {
		return cdgoCentCont;
	}

	public void setCdgoCentCont(String cdgoCentCont) {
		this.cdgoCentCont = cdgoCentCont;
	}

	public int getCdgoAreTer() {
		return cdgoAreTer;
	}

	public void setCdgoAreTer(int cdgoAreTer) {
		this.cdgoAreTer = cdgoAreTer;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public String getBuzonCorreo() {
		return buzonCorreo;
	}

	public void setBuzonCorreo(String buzonCorreo) {
		this.buzonCorreo = buzonCorreo;
	}

}
