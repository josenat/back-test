package renfe.com.dto;

import java.util.List;

public class UserDTO {

	private String cdgoUsuario;
	private String cdgoCencontable;
	private String cdgoEstado;
	private String cdgoMatricula;
	private String cdgoUne;
	private String desgCargo;
	private String desgMail;
	private String desgUsuario;
	private String cdgoNivel;
	private String cdgoRol;

	private List<UserOptionDTO> options;

	public String getCdgoUsuario() {
		return cdgoUsuario;
	}

	public void setCdgoUsuario(String cdgoUsuario) {
		this.cdgoUsuario = cdgoUsuario;
	}

	public String getCdgoCencontable() {
		return cdgoCencontable;
	}

	public void setCdgoCencontable(String cdgoCencontable) {
		this.cdgoCencontable = cdgoCencontable;
	}

	public String getCdgoEstado() {
		return cdgoEstado;
	}

	public void setCdgoEstado(String cdgoEstado) {
		this.cdgoEstado = cdgoEstado;
	}

	public String getCdgoMatricula() {
		return cdgoMatricula;
	}

	public void setCdgoMatricula(String cdgoMatricula) {
		this.cdgoMatricula = cdgoMatricula;
	}

	public String getCdgoUne() {
		return cdgoUne;
	}

	public void setCdgoUne(String cdgoUne) {
		this.cdgoUne = cdgoUne;
	}

	public String getDesgCargo() {
		return desgCargo;
	}

	public void setDesgCargo(String desgCargo) {
		this.desgCargo = desgCargo;
	}

	public String getDesgMail() {
		return desgMail;
	}

	public void setDesgMail(String desgMail) {
		this.desgMail = desgMail;
	}

	public String getDesgUsuario() {
		return desgUsuario;
	}

	public void setDesgUsuario(String desgUsuario) {
		this.desgUsuario = desgUsuario;
	}

	public String getCdgoNivel() {
		return cdgoNivel;
	}

	public void setCdgoNivel(String cdgoNivel) {
		this.cdgoNivel = cdgoNivel;
	}


	public String getCdgoRol() {
		return cdgoRol;
	}

	public void setCdgoRol(String cdgoRol) {
		this.cdgoRol = cdgoRol;
	}

	public List<UserOptionDTO> getOptions() {
		return options;
	}

	public void setOptions(List<UserOptionDTO> options) {
		this.options = options;
	}

}
