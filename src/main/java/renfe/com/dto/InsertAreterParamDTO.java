package renfe.com.dto;

public class InsertAreterParamDTO {

	private int cdgoAreTer;
	private int cdgoAreAct;
	private String nombre;
	private String usuAct;
	private boolean activo;

	public int getCdgoAreTer() {
		return cdgoAreTer;
	}

	public void setCdgoAreTer(int cdgoAreTer) {
		this.cdgoAreTer = cdgoAreTer;
	}

	public int getCdgoAreAct() {
		return cdgoAreAct;
	}

	public void setCdgoAreAct(int cdgoAreAct) {
		this.cdgoAreAct = cdgoAreAct;
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

}
