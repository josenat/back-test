package renfe.com.dto;

public class InsertGcconsultaParamDTO {

	private String nombre;
	private String usuario;
	private boolean contar;
	private String expLogica;
	private String usuAct;
	private boolean activo;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public boolean getContar() {
		return contar;
	}

	public void setContar(boolean contar) {
		this.contar = contar;
	}

	public String getExpLogica() {
		return expLogica;
	}

	public void setExpLogica(String expLogica) {
		this.expLogica = expLogica;
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
