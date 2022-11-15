package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG903_TMP_SOCIEDAD")
public class Tbasg903TmpSociedad {

	@Id
	@Column(name = "ID_SOCPERSONA")
	private Long idSocpersona;

	@NotNull
	@Column(name = "CDGO_PERSONA")
	private Integer cdgoPersona;

	@NotNull
	@Column(name = "CDGO_SOCIEDAD")
	private String cdgoSociedad;

	@Column(name = "FCHA_ALTA")
	private Date fchaAlta;

	@Column(name = "MRC_ACTIVO")
	private String mrcActivo;

	public Long getIdSocpersona() {
		return this.idSocpersona;
	}

	public void setIdSocpersona(Long idSocpersona) {
		this.idSocpersona = idSocpersona;
	}

	public Integer getCdgoPersona() {
		return this.cdgoPersona;
	}

	public String getCdgoSociedad() {
		return this.cdgoSociedad;
	}

	public Date getFchaAlta() {
		return this.fchaAlta;
	}

	public String getMrcActivo() {
		return this.mrcActivo;
	}

	public void setCdgoPersona(Integer cdgoPersona) {
		this.cdgoPersona = cdgoPersona;
	}

	public void setCdgoSociedad(String cdgoSociedad) {
		this.cdgoSociedad = cdgoSociedad;
	}

	public void setFchaAlta(Date fchaAlta) {
		this.fchaAlta = fchaAlta;
	}

	public void setMrcActivo(String mrcActivo) {
		this.mrcActivo = mrcActivo;
	}

}