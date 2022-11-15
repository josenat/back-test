package renfe.com.model.dto;

import java.sql.Date;

public class Tbasg179FicheroRefDto {

	private Integer cdgoFichero;
	private String desgFichero;
	private Date fchaFichero;

	public Integer getCdgoFichero() {
		return this.cdgoFichero;
	}

	public void setCdgoFichero(Integer cdgoFichero) {
		this.cdgoFichero = cdgoFichero;
	}

	public String getDesgFichero() {
		return this.desgFichero;
	}

	public void setDesgFichero(String desgFichero) {
		this.desgFichero = desgFichero;
	}

	public Date getFchaFichero() {
		return this.fchaFichero;
	}

	public void setFchaFichero(Date fchaFichero) {
		this.fchaFichero = fchaFichero;
	}

}