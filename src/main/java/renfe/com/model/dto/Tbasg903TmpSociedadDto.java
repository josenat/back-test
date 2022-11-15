package renfe.com.model.dto;

import java.sql.Date;

public class Tbasg903TmpSociedadDto {

	private Integer cdgoPersona;
	private String cdgoSociedad;
	private Date fchaAlta;
	private Integer idSocpersona;
	private String mrcActivo;

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

	public Integer getIdSocpersona() {
		return this.idSocpersona;
	}

	public void setIdSocpersona(Integer idSocpersona) {
		this.idSocpersona = idSocpersona;
	}

	public String getMrcActivo() {
		return this.mrcActivo;
	}

	public void setMrcActivo(String mrcActivo) {
		this.mrcActivo = mrcActivo;
	}

}