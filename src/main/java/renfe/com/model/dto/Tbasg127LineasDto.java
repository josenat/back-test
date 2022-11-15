package renfe.com.model.dto;

import java.sql.Date;

public class Tbasg127LineasDto {

	private String cdgoLinea;
	private Integer cdgoNumestaciones;
	private String desgNombre;
	private String desgSoportedoc;
	private String desgUsuact;
	private Date fchaAct;
	private String mrcaActivo;

	public String getCdgoLinea() {
		return this.cdgoLinea;
	}

	public void setCdgoLinea(String cdgoLinea) {
		this.cdgoLinea = cdgoLinea;
	}

	public Integer getCdgoNumestaciones() {
		return this.cdgoNumestaciones;
	}

	public void setCdgoNumestaciones(Integer cdgoNumestaciones) {
		this.cdgoNumestaciones = cdgoNumestaciones;
	}

	public String getDesgNombre() {
		return this.desgNombre;
	}

	public void setDesgNombre(String desgNombre) {
		this.desgNombre = desgNombre;
	}

	public String getDesgSoportedoc() {
		return this.desgSoportedoc;
	}

	public void setDesgSoportedoc(String desgSoportedoc) {
		this.desgSoportedoc = desgSoportedoc;
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