package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG105_AREACTIVI", schema = "PASG")

public class Tbasg105Areactivi {

	@Id
	@Column(name = "CDGO_AREACT")
	private Integer cdgoAreact;

	@NotNull
	@Column(name = "DESG_NOMBRE")
	private String desgNombre;
	
	@Column(name = "DESG_USUACT")
	private String desgUsuact;
	
	@Column(name = "FCHA_ACT")
	private Date fchaAct;
	
	@Column(name = "MRCA_ACTIVO")
	private String mrcaActivo;
	
	@Column(name = "CDGO_SOCIEDAD")
	private String cdgoSociedad;

	public Integer getCdgoAreact() {
		return cdgoAreact;
	}

	public void setCdgoAreact(Integer cdgoAreact) {
		this.cdgoAreact = cdgoAreact;
	}

	public String getDesgNombre() {
		return desgNombre;
	}

	public void setDesgNombre(String desgNombre) {
		this.desgNombre = desgNombre;
	}

	public String getDesgUsuact() {
		return desgUsuact;
	}

	public void setDesgUsuact(String desgUsuact) {
		this.desgUsuact = desgUsuact;
	}

	public Date getFchaAct() {
		return fchaAct;
	}

	public void setFchaAct(Date fchaAct) {
		this.fchaAct = fchaAct;
	}


	public String getMrcaActivo() {
		return mrcaActivo;
	}

	public void setMrcaActivo(String mrcaActivo) {

		this.mrcaActivo = mrcaActivo;
	}

	public String getCdgoSociedad() {
		return cdgoSociedad;
	}

	public void setCdgoSociedad(String cdgoSociedad) {
		this.cdgoSociedad = cdgoSociedad;

	}

}