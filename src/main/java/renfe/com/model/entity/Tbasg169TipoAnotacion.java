package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG169_TIPO_ANOTACION")
public class Tbasg169TipoAnotacion {

	@Id
	@Column(name = "CDGO_TIPOANOTACION")
	private Long cdgoTipoanotacion;

	@NotNull
	@Column(name = "DESG_OPERACION")
	private String desgOperacion;

	@Column(name = "DESG_USUACT")
	private String desgUsuact;

	@Column(name = "FCHA_ACT")
	private Date fchaAct;

	@Column(name = "MRCA_ACTIVO")
	private String mrcaActivo;

	public Long getCdgoTipoanotacion() {
		return this.cdgoTipoanotacion;
	}

	public void setCdgoTipoanotacion(Long cdgoTipoanotacion) {
		this.cdgoTipoanotacion = cdgoTipoanotacion;
	}

	public String getDesgOperacion() {
		return this.desgOperacion;
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

	public void setDesgOperacion(String desgOperacion) {
		this.desgOperacion = desgOperacion;
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