package renfe.com.dto;

public class InsertAreactiviParamDTO {

	private int cdgoAreAct;
	private String nombre;
	private String usuAct;
	private boolean activo;
	private String cdgoSociedad;

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

	public String getCdgoSociedad() {
		return cdgoSociedad;
	}

	public void setCdgoSociedad(String cdgoSociedad) {
		this.cdgoSociedad = cdgoSociedad;
	}

}
