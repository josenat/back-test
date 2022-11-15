package renfe.com.model.dto;

import java.sql.Date;

public class Tbasg156FcCualificacionDto {

	private Integer cdgoCategoria;
	private Integer cdgoCualificacion;
	private String desgDescripcion;
	private String desgNombre;
	private String desgUsuact;
	private Date fchaAct;
	private String mrcaActivo;

	public Integer getCdgoCategoria() {
		return this.cdgoCategoria;
	}

	public void setCdgoCategoria(Integer cdgoCategoria) {
		this.cdgoCategoria = cdgoCategoria;
	}

	public Integer getCdgoCualificacion() {
		return this.cdgoCualificacion;
	}

	public void setCdgoCualificacion(Integer cdgoCualificacion) {
		this.cdgoCualificacion = cdgoCualificacion;
	}

	public String getDesgDescripcion() {
		return this.desgDescripcion;
	}

	public void setDesgDescripcion(String desgDescripcion) {
		this.desgDescripcion = desgDescripcion;
	}

	public String getDesgNombre() {
		return this.desgNombre;
	}

	public void setDesgNombre(String desgNombre) {
		this.desgNombre = desgNombre;
	}

	public String getDesgUsuact() {
		return this.desgUsuact;
	}

	public void setDesgUsuact(String desgUsuact) {
		this.desgUsuact = desgUsuact;
	}

	public Date getFchaAct() {
		return this.fchaAct;
	}

	public void setFchaAct(Date fchaAct) {
		this.fchaAct = fchaAct;
	}

	public String getMrcaActivo() {
		return this.mrcaActivo;
	}

	public void setMrcaActivo(String mrcaActivo) {
		this.mrcaActivo = mrcaActivo;
	}

}