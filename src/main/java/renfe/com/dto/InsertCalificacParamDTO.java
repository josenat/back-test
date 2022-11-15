package renfe.com.dto;

public class InsertCalificacParamDTO {

	private String nombre;
	private String tipoCalif;
	private String usuAct;
	private boolean activo;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipoCalif() {
		return tipoCalif;
	}

	public void setTipoCalif(String tipoCalif) {
		this.tipoCalif = tipoCalif;
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
