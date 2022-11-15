package renfe.com.model.dto;

import java.sql.Date;

public class Tbasg155FcCategoriaDto {

	private Integer cdgoCategoria;
	private String desgDescripcion;
	private String desgUsuact;
	private String fchaAct;
	private String mrcaActivo;

	public Integer getCdgoCategoria() {
		return this.cdgoCategoria;
	}

	public void setCdgoCategoria(Integer cdgoCategoria) {
		this.cdgoCategoria = cdgoCategoria;
	}

	public String getDesgDescripcion() {
		return this.desgDescripcion;
	}

	public void setDesgDescripcion(String desgDescripcion) {
		this.desgDescripcion = desgDescripcion;
	}

	public String getDesgUsuact() {
		return this.desgUsuact;
	}

	public void setDesgUsuact(String desgUsuact) {
		this.desgUsuact = desgUsuact;
	}

	public String getFchaAct() {
		return this.fchaAct;
	}

	public void setFchaAct(String fchaAct) {
		this.fchaAct = fchaAct;
	}

	public String getMrcaActivo() {
		return this.mrcaActivo;
	}

	public void setMrcaActivo(String mrcaActivo) {
		this.mrcaActivo = mrcaActivo;
	}

}