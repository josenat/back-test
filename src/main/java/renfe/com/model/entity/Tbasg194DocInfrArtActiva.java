package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG194_DOC_INFR_ART_ACTIVA")
public class Tbasg194DocInfrArtActiva {

	@Id
	@Column(name = "CDGO_ARTICULO")
	private Long cdgoArticulo;

	@NotNull
	@Column(name = "DESG_ARTICULO")
	private String desgArticulo;

	@Column(name = "DESG_TIPOPERSONAL")
	private String desgTipopersonal;

	@Column(name = "DESG_USUACT")
	private String desgUsuact;

	@Column(name = "FCHA_ACT")
	private Date fchaAct;

	@Column(name = "MRCA_ACTIVO")
	private String mrcaActivo;

	public Long getCdgoArticulo() {
		return this.cdgoArticulo;
	}

	public void setCdgoArticulo(Long cdgoArticulo) {
		this.cdgoArticulo = cdgoArticulo;
	}

	public String getDesgArticulo() {
		return this.desgArticulo;
	}

	public String getDesgTipopersonal() {
		return this.desgTipopersonal;
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

	public void setDesgArticulo(String desgArticulo) {
		this.desgArticulo = desgArticulo;
	}

	public void setDesgTipopersonal(String desgTipopersonal) {
		this.desgTipopersonal = desgTipopersonal;
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