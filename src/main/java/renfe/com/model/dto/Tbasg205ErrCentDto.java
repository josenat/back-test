package renfe.com.model.dto;

import java.sql.Date;

public class Tbasg205ErrCentDto {

	private Integer cdgoAreter;
	private Integer cdgoCentcont;
	private Integer cdgoError;
	private String desgError;
	private String desgFichero;
	private String desgNombre;
	private String desgUsuact;
	private Date fchaAct;
	private Date fchaError;
	private String mrcaActivo;

	public Integer getCdgoAreter() {
		return this.cdgoAreter;
	}

	public void setCdgoAreter(Integer cdgoAreter) {
		this.cdgoAreter = cdgoAreter;
	}

	public Integer getCdgoCentcont() {
		return this.cdgoCentcont;
	}

	public void setCdgoCentcont(Integer cdgoCentcont) {
		this.cdgoCentcont = cdgoCentcont;
	}

	public Integer getCdgoError() {
		return this.cdgoError;
	}

	public void setCdgoError(Integer cdgoError) {
		this.cdgoError = cdgoError;
	}

	public String getDesgError() {
		return this.desgError;
	}

	public void setDesgError(String desgError) {
		this.desgError = desgError;
	}

	public String getDesgFichero() {
		return this.desgFichero;
	}

	public void setDesgFichero(String desgFichero) {
		this.desgFichero = desgFichero;
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

	public Date getFchaError() {
		return this.fchaError;
	}

	public void setFchaError(Date fchaError) {
		this.fchaError = fchaError;
	}

	public String getMrcaActivo() {
		return this.mrcaActivo;
	}

	public void setMrcaActivo(String mrcaActivo) {
		this.mrcaActivo = mrcaActivo;
	}

}