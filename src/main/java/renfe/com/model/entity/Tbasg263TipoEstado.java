package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG263_TIPO_ESTADO")
public class Tbasg263TipoEstado {

	@Id
	@Column(name = "CDGO_ESTADO")
	private String cdgoEstado;

	@NotNull
	@Column(name = "DESG_ESTADO")
	private String desgEstado;

	@NotNull
	@Column(name = "DESG_USUACT")
	private String desgUsuact;

	@NotNull
	@Column(name = "FCHA_ACT")
	private Date fchaAct;

	@NotNull
	@Column(name = "MRCA_ACTIVO")
	private String mrcaActivo;

	public String getCdgoEstado() {
		return this.cdgoEstado;
	}

	public void setCdgoEstado(String cdgoEstado) {
		this.cdgoEstado = cdgoEstado;
	}

	public String getDesgEstado() {
		return this.desgEstado;
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

	public void setDesgEstado(String desgEstado) {
		this.desgEstado = desgEstado;
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