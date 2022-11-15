package renfe.com.dto;

import java.sql.Date;

import javax.persistence.Column;

public class GetCertsPsicByPersListDTO {
	
	@Column(name="CDGO_PERSONA")
	private Integer cdgoPersona;
	
	@Column(name="MRCA_ACTIVO")
	private char mrcaActivo;
	
	@Column(name="FCHA_PROXREV")
	private Date fchaProxrev;
	
	@Column(name="CDGO_PSICAMB")
	private Integer cdgoPsicamb;
	
	@Column(name="DESG_NOMBRE")
	private String desgNombre;

	public Integer getCdgoPersona() {
		return cdgoPersona;
	}

	public void setCdgoPersona(Integer cdgoPersona) {
		this.cdgoPersona = cdgoPersona;
	}

	public char getMrcaActivo() {
		return mrcaActivo;
	}

	public void setMrcaActivo(char mrcaActivo) {
		this.mrcaActivo = mrcaActivo;
	}

	public Date getFchaProxrev() {
		return fchaProxrev;
	}

	public void setFchaProxrev(Date fchaProxrev) {
		this.fchaProxrev = fchaProxrev;
	}

	public Integer getCdgoPsicamb() {
		return cdgoPsicamb;
	}

	public void setCdgoPsicamb(Integer cdgoPsicamb) {
		this.cdgoPsicamb = cdgoPsicamb;
	}

	public String getDesgNombre() {
		return desgNombre;
	}

	public void setDesgNombre(String desgNombre) {
		this.desgNombre = desgNombre;
	}
}

