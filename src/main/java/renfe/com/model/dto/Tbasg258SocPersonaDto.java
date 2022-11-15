package renfe.com.model.dto;

import java.sql.Date;

public class Tbasg258SocPersonaDto {

	private Integer cdgoPersona;
	private String cdgoSociedad;
	private Date fchaAlta;
	private Date fchaBaja;
	private Integer idSocpersona;

	public Integer getCdgoPersona() {
		return this.cdgoPersona;
	}

	public void setCdgoPersona(Integer cdgoPersona) {
		this.cdgoPersona = cdgoPersona;
	}

	public String getCdgoSociedad() {
		return this.cdgoSociedad;
	}

	public void setCdgoSociedad(String cdgoSociedad) {
		this.cdgoSociedad = cdgoSociedad;
	}

	public Date getFchaAlta() {
		return this.fchaAlta;
	}

	public void setFchaAlta(Date fchaAlta) {
		this.fchaAlta = fchaAlta;
	}

	public Date getFchaBaja() {
		return this.fchaBaja;
	}

	public void setFchaBaja(Date fchaBaja) {
		this.fchaBaja = fchaBaja;
	}

	public Integer getIdSocpersona() {
		return this.idSocpersona;
	}

	public void setIdSocpersona(Integer idSocpersona) {
		this.idSocpersona = idSocpersona;
	}

}