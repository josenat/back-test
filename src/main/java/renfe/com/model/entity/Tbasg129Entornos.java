package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG129_ENTORNOS", schema = "PASG")
public class Tbasg129Entornos {

	@Id
	@Column(name = "CDGO_ENTORNO")
	private Integer cdgoEntorno;

	@Column(name = "CDGO_AREACT")
	private Integer cdgoAreact;

	@NotNull
	@Column(name = "DESG_NOMCORTO")
	private String desgNomcorto;

	@NotNull
	@Column(name = "DESG_NOMENTORNO")
	private String desgNomentorno;

	@Column(name = "DESG_USUACT")
	private String desgUsuact;

	@Column(name = "FCHA_ACT")
	private Date fchaAct;

	@Column(name = "MRCA_ACTIVO")
	private char mrcaActivo;

	public Integer getCdgoEntorno() {
		return this.cdgoEntorno;
	}

	public void setCdgoEntorno(Integer cdgoEntorno) {
		this.cdgoEntorno = cdgoEntorno;
	}

	public Integer getCdgoAreact() {
		return this.cdgoAreact;
	}

	public String getDesgNomcorto() {
		return this.desgNomcorto;
	}

	public String getDesgNomentorno() {
		return this.desgNomentorno;
	}

	public String getDesgUsuact() {
		return this.desgUsuact;
	}

	public Date getFchaAct() {
		return this.fchaAct;
	}

	public char getMrcaActivo() {
		return this.mrcaActivo;
	}

	public void setCdgoAreact(Integer cdgoAreact) {
		this.cdgoAreact = cdgoAreact;
	}

	public void setDesgNomcorto(String desgNomcorto) {
		this.desgNomcorto = desgNomcorto;
	}

	public void setDesgNomentorno(String desgNomentorno) {
		this.desgNomentorno = desgNomentorno;
	}

	public void setDesgUsuact(String desgUsuact) {
		this.desgUsuact = desgUsuact;
	}

	public void setFchaAct(Date fchaAct) {
		this.fchaAct = fchaAct;
	}

	public void setMrcaActivo(char mrcaActivo) {
		this.mrcaActivo = mrcaActivo;
	}
}
