package renfe.com.dto;

public class InsertProvinciaParamDTO {

	private int cdgoProvincia;
	private String nombre;
	private String usuAct;
	private boolean activo;

	public int getCdgoProvincia() {
		return cdgoProvincia;
	}

	public void setCdgoProvincia(int cdgoProvincia) {
		this.cdgoProvincia = cdgoProvincia;
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
