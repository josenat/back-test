package renfe.com.dto;

public class InsertFdConfHabParamDTO {

	private Integer cdgoExpedient;
	private String texto;
	private String txtEncriptado;
	private String usuario;

	public Integer getCdgoExpedient() {
		return cdgoExpedient;
	}

	public void setCdgoExpedient(Integer cdgoExpedient) {
		this.cdgoExpedient = cdgoExpedient;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getTxtEncriptado() {
		return txtEncriptado;
	}

	public void setTxtEncriptado(String txtEncriptado) {
		this.txtEncriptado = txtEncriptado;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}
