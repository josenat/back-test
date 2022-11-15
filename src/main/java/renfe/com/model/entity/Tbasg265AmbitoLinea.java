package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG265_AMBITO_LINEA", schema = "PASG")
public class Tbasg265AmbitoLinea {

	@Id
	@Column(name = "CDGO_LINEA")
	private String cdgoLinea;

	@NotNull
	@Column(name = "DESG_LINEA")
	private String desgLinea;

	@NotNull
	@Column(name = "DESG_USUACT")
	private String desgUsuact;

	@NotNull
	@Column(name = "FCHA_ACT")
	private Date fchaAct;

	@NotNull
	@Column(name = "MRCA_ACTIVO")
	private String mrcaActivo;

	public String getCdgoLinea() {
		return this.cdgoLinea;
	}

	public void setCdgoLinea(String cdgoLinea) {
		this.cdgoLinea = cdgoLinea;
	}

	public String getDesgLinea() {
		return this.desgLinea;
	}

	public String getDesgUsuact() {
		return this.desgUsuact;
	}

	public Date getFchaAct() {
		return this.fchaAct;
	}

	public String getMrcaActivo() {
		return this.mrcaActivo;
	}

	public void setDesgLinea(String desgLinea) {
		this.desgLinea = desgLinea;
	}

	public void setDesgUsuact(String desgUsuact) {
		this.desgUsuact = desgUsuact;
	}

	public void setFchaAct(Date fchaAct) {
		this.fchaAct = fchaAct;
	}

	public void setMrcaActivo(String mrcaActivo) {
		this.mrcaActivo = mrcaActivo;
	}

}