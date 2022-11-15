package renfe.com.dto;

import java.sql.Date;

public class GetFccategoriaResultDTO {

	private Integer cdgoCategoria;
	private String descripcion;
	private String usuAct;
	private Date fchaAct;
	private boolean activo;

	public Integer getCdgoCategoria() {
		return cdgoCategoria;
	}

	public void setCdgoCategoria(Integer cdgoCategoria) {
		this.cdgoCategoria = cdgoCategoria;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getUsuAct() {
		return usuAct;
	}

	public void setUsuAct(String usuAct) {
		this.usuAct = usuAct;
	}

	public Date getFchaAct() {
		return fchaAct;
	}

	public void setFchaAct(Date fchaAct) {
		this.fchaAct = fchaAct;
	}

	public boolean getActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

}
