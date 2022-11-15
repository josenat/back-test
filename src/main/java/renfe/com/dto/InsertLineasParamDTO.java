package renfe.com.dto;

public class InsertLineasParamDTO {

	private String cdgoLinea;
	private String nombre;
	private Integer cdgoNumEstaciones;
	private String usuAct;
	private String soporteDoc;
	private boolean activo;

	public String getCdgoLinea() {
		return cdgoLinea;
	}

	public void setCdgoLinea(String cdgoLinea) {
		this.cdgoLinea = cdgoLinea;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCdgoNumEstaciones() {
		return cdgoNumEstaciones;
	}

	public void setCdgoNumEstaciones(Integer cdgoNumEstaciones) {
		this.cdgoNumEstaciones = cdgoNumEstaciones;
	}

	public String getUsuAct() {
		return usuAct;
	}

	public void setUsuAct(String usuAct) {
		this.usuAct = usuAct;
	}

	public String getSoporteDoc() {
		return soporteDoc;
	}

	public void setSoporteDoc(String soporteDoc) {
		this.soporteDoc = soporteDoc;
	}

	public boolean getActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

}
