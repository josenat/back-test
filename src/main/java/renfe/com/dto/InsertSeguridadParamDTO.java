package renfe.com.dto;

public class InsertSeguridadParamDTO {

	private String cdgoProceso;
	private String cdgoSubProceso;
	private String descProceso;
	private String descSubProceso;
	private String rol;
	private String nivel;
	private String usuario;
	private String descripRol;

	public String getCdgoProceso() {
		return cdgoProceso;
	}

	public void setCdgoProceso(String cdgoProceso) {
		this.cdgoProceso = cdgoProceso;
	}

	public String getCdgoSubProceso() {
		return cdgoSubProceso;
	}

	public void setCdgoSubProceso(String cdgoSubProceso) {
		this.cdgoSubProceso = cdgoSubProceso;
	}

	public String getDescProceso() {
		return descProceso;
	}

	public void setDescProceso(String descProceso) {
		this.descProceso = descProceso;
	}

	public String getDescSubProceso() {
		return descSubProceso;
	}

	public void setDescSubProceso(String descSubProceso) {
		this.descSubProceso = descSubProceso;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getDescripRol() {
		return descripRol;
	}

	public void setDescripRol(String descripRol) {
		this.descripRol = descripRol;
	}

}
