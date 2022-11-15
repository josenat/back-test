package renfe.com.model.dto;

import java.sql.Date;

public class Tbasg177DocOrdenActiDatoDto {

	private Integer cdgoClave;
	private Integer cdgoReferenciadoc;
	private String desgUsuact;
	private String desgValor;
	private Date fchaAct;
	private String mrcaActivo;

	public Integer getCdgoClave() {
		return this.cdgoClave;
	}

	public void setCdgoClave(Integer cdgoClave) {
		this.cdgoClave = cdgoClave;
	}

	public Integer getCdgoReferenciadoc() {
		return this.cdgoReferenciadoc;
	}

	public void setCdgoReferenciadoc(Integer cdgoReferenciadoc) {
		this.cdgoReferenciadoc = cdgoReferenciadoc;
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