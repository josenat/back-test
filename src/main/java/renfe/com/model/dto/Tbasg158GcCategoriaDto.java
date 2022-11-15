package renfe.com.model.dto;

import java.sql.Date;

public class Tbasg158GcCategoriaDto {

	private String cdgoCategoria;
	private Integer cdgoOrden;
	private String desgNombre;
	private String desgUsuact;
	private Date fchaAct;
	private String mrcaActivo;

	public String getCdgoCategoria() {
		return this.cdgoCategoria;
	}

	public void setCdgoCategoria(String cdgoCategoria) {
		this.cdgoCategoria = cdgoCategoria;
	}

	public Integer getCdgoOrden() {
		return this.cdgoOrden;
	}

	public void setCdgoOrden(Integer cdgoOrden) {
		this.cdgoOrden = cdgoOrden;
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