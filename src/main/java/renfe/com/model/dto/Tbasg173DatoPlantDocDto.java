package renfe.com.model.dto;

import java.sql.Date;

public class Tbasg173DatoPlantDocDto {

	private String cdgoClave;
	private Integer cdgoDocumento;
	private String desgUsuact;
	private String desgValor;
	private Date fchaAct;
	private String mrcaActivo;

	public String getCdgoClave() {
		return this.cdgoClave;
	}

	public void setCdgoClave(String cdgoClave) {
		this.cdgoClave = cdgoClave;
	}

	public Integer getCdgoDocumento() {
		return this.cdgoDocumento;
	}

	public void setCdgoDocumento(Integer cdgoDocumento) {
		this.cdgoDocumento = cdgoDocumento;
	}

	public String getDesgUsuact() {
		return this.desgUsuact;
	}

	public void setDesgUsuact(String desgUsuact) {
		this.desgUsuact = desgUsuact;
	}

	public String getDesgValor() {
		return this.desgValor;
	}

	public void setDesgValor(String desgValor) {
		this.desgValor = desgValor;
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