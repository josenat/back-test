package renfe.com.model.dto;

import java.sql.Date;

public class Tbasg167ObservMaquinistaDto {

	private Integer cdgoCentcont;
	private Integer cdgoObservacion;
	private String desgEmail;
	private String desgMatricula;
	private String desgObservacion;
	private Date fchaAlta;

	public Integer getCdgoCentcont() {
		return this.cdgoCentcont;
	}

	public void setCdgoCentcont(Integer cdgoCentcont) {
		this.cdgoCentcont = cdgoCentcont;
	}

	public Integer getCdgoObservacion() {
		return this.cdgoObservacion;
	}

	public void setCdgoObservacion(Integer cdgoObservacion) {
		this.cdgoObservacion = cdgoObservacion;
	}

	public String getDesgEmail() {
		return this.desgEmail;
	}

	public void setDesgEmail(String desgEmail) {
		this.desgEmail = desgEmail;
	}

	public String getDesgMatricula() {
		return this.desgMatricula;
	}

	public void setDesgMatricula(String desgMatricula) {
		this.desgMatricula = desgMatricula;
	}

	public String getDesgObservacion() {
		return this.desgObservacion;
	}

	public void setDesgObservacion(String desgObservacion) {
		this.desgObservacion = desgObservacion;
	}

	public Date getFchaAlta() {
		return this.fchaAlta;
	}

	public void setFchaAlta(Date fchaAlta) {
		this.fchaAlta = fchaAlta;
	}

}