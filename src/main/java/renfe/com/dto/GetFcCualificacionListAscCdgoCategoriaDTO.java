package renfe.com.dto;

import java.sql.Date;

public class GetFcCualificacionListAscCdgoCategoriaDTO {
	
	private Integer cdgoCategoria;
	private Integer cdgoCualificacion;
	private String desgDescripcion;
	private String desgNombre;
	private String desgUsuact;
	private Date fchaAct;
	private String mrcaActivo;
	private String desgNombreCategoria;
	
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
	public String getDesgDescripcion() {
		return desgDescripcion;
	}
	public void setDesgDescripcion(String desgDescripcion) {
		this.desgDescripcion = desgDescripcion;
	}
	public String getDesgNombre() {
		return desgNombre;
	}
	public void setDesgNombre(String desgNombre) {
		this.desgNombre = desgNombre;
	}
	public String getDesgUsuact() {
		return desgUsuact;
	}
	public void setDesgUsuact(String desgUsuact) {
		this.desgUsuact = desgUsuact;
	}
	public Date getFchaAct() {
		return fchaAct;
	}
	public void setFchaAct(Date fchaAct) {
		this.fchaAct = fchaAct;
	}
	public String getMrcaActivo() {
		return mrcaActivo;
	}
	public void setMrcaActivo(String mrcaActivo) {
		this.mrcaActivo = mrcaActivo;
	}
	public String getDesgNombreCategoria() {
		return desgNombreCategoria;
	}
	public void setDesgNombreCategoria(String desgNombreCategoria) {
		this.desgNombreCategoria = desgNombreCategoria;
	}

}
