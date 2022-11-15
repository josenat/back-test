package renfe.com.dto;

import java.sql.Date;

public class UpdateFormaccomplemenParamDTO {

	private Date fechaExpedicion;
	private Integer cdgoPersona;
	private Integer cdgoCategoria;
	private Integer cdgoCualificacion;

	public Date getFechaExpedicion() {
		return fechaExpedicion;
	}

	public void setFechaExpedicion(Date fechaExpedicion) {
		this.fechaExpedicion = fechaExpedicion;
	}

	public Integer getCdgoPersona() {
		return cdgoPersona;
	}

	public void setCdgoPersona(Integer cdgoPersona) {
		this.cdgoPersona = cdgoPersona;
	}

	public Integer getCdgoCategoria() {
		return cdgoCategoria;
	}

	public void setCdgoCategoria(Integer cdgoCategoria) {
		this.cdgoCategoria = cdgoCategoria;
	}

	public Integer getCdgoCualificacion() {
		return cdgoCualificacion;
	}

	public void setCdgoCualificacion(Integer cdgoCualificacion) {
		this.cdgoCualificacion = cdgoCualificacion;
	}

}
