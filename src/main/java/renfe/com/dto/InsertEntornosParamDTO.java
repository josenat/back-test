package renfe.com.dto;

public class InsertEntornosParamDTO {

	private String nomCorto;
	private String nomEntorno;
	private String usuAct;
	private boolean activo;

	public String getNomCorto() {
		return nomCorto;
	}

	public void setNomCorto(String nomCorto) {
		this.nomCorto = nomCorto;
	}

	public String getNomEntorno() {
		return nomEntorno;
	}

	public void setNomEntorno(String nomEntorno) {
		this.nomEntorno = nomEntorno;
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
