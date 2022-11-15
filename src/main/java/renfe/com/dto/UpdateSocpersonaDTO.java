package renfe.com.dto;

import java.sql.Date;

public class UpdateSocpersonaDTO {

	private String cdgoSociedad;
	private Date fchaAlta;
	private Date fchaBaja;
	private Integer id;

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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
