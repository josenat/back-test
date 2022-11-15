package renfe.com.dto;

public class GetDestinatariosEmailResultDTO {

	private String direccEmail;
	private String nombre;
	private String nivelEnvio;
	private Integer areaAct;
	private boolean activo;

	public String getDireccEmail() {
		return direccEmail;
	}

	public void setDireccEmail(String direccEmail) {
		this.direccEmail = direccEmail;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNivelEnvio() {
		return nivelEnvio;
	}

	public void setNivelEnvio(String nivelEnvio) {
		this.nivelEnvio = nivelEnvio;
	}

	public Integer getAreaAct() {
		return areaAct;
	}

	public void setAreaAct(Integer areaAct) {
		this.areaAct = areaAct;
	}

	public boolean getActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

}
