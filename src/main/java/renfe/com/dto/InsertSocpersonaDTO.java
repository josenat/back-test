package renfe.com.dto;

import java.sql.Date;

public class InsertSocpersonaDTO {

	private Integer cdgoPersona;
	private String cdgoSociedad;
	private Date fchaAlta;
	private Date fchaBaja;

	public Integer getCdgoPersona() {
		return cdgoPersona;
	}

	public void setCdgoPersona(Integer cdgoPersona) {
		this.cdgoPersona = cdgoPersona;
	}

	public String getCdgoSociedad() {
		return cdgoSociedad;
	}

	public void setCdgoSociedad(String cdgoSociedad) {
		this.cdgoSociedad = cdgoSociedad;
	}

	public Date getFchaAlta() {
		return fchaAlta;
	}

	public void setFchaAlta(Date fchaAlta) {
		this.fchaAlta = fchaAlta;
	}

	public Date getFchaBaja() {
		return fchaBaja;
	}

	public void setFchaBaja(Date fchaBaja) {
		this.fchaBaja = fchaBaja;
	}

}
