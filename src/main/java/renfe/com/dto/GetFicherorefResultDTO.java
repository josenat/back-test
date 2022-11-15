package renfe.com.dto;

import java.sql.Date;

public class GetFicherorefResultDTO {

	private Integer cdgoFichero;
	private Date fchaFichero;
	private String desgFichero;

	public Integer getCdgoFichero() {
		return cdgoFichero;
	}

	public void setCdgoFichero(Integer cdgoFichero) {
		this.cdgoFichero = cdgoFichero;
	}

	public Date getFchaFichero() {
		return fchaFichero;
	}

	public void setFchaFichero(Date fchaFichero) {
		this.fchaFichero = fchaFichero;
	}

	public String getDesgFichero() {
		return desgFichero;
	}

	public void setDesgFichero(String desgFichero) {
		this.desgFichero = desgFichero;
	}

}
