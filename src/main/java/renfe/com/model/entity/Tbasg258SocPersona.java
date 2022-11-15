package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG258_SOC_PERSONA", schema="PASG")
public class Tbasg258SocPersona {

	@Id
	@Column(name = "ID_SOCPERSONA")
	private Integer idSocpersona;

	@NotNull
	@Column(name = "CDGO_PERSONA")
	private Integer cdgoPersona;

	@NotNull
	@Column(name = "CDGO_SOCIEDAD")
	private String cdgoSociedad;

	@Column(name = "FCHA_ALTA")
	private Date fchaAlta;

	@Column(name = "FCHA_BAJA")
	private Date fchaBaja;

	public Integer getIdSocpersona() {
		return this.idSocpersona;
	}

	public void setIdSocpersona(Integer idSocpersona) {
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

	public Date getFchaBaja() {
		return this.fchaBaja;
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

	public void setFchaBaja(Date fchaBaja) {
		this.fchaBaja = fchaBaja;
	}

}