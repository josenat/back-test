package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TBASG126_ALCHABINF", schema = "PASG")
public class Tbasg126Alchabinf {

	@Id
	@Column(name = "CDGO_ALCHABINF")
	private Long cdgoAlchabinf;

	@Column(name = "DESG_USUACT")
	private String desgUsuact;

	@Column(name = "FCHA_FECACT")
	private Date fchaFecact;

	@Column(name = "MRCA_ACTIVO")
	private String mrcaActivo;

	/*@ManyToOne
	@JoinColumn(name = "CDGO_EXPEDIENT", nullable = false, foreignKey = @ForeignKey(name = "CDGO$EXP"))
	private Tbasg104Expedient cdgoExpedient;*/
	
	@Column(name = "CDGO_EXPEDIENT")
	private Integer cdgoExpedient;

	public Long getCdgoAlchabinf() {
		return this.cdgoAlchabinf;
	}

	public void setCdgoAlchabinf(Long cdgoAlchabinf) {
		this.cdgoAlchabinf = cdgoAlchabinf;
	}

	public String getDesgUsuact() {
		return this.desgUsuact;
	}

	public Date getFchaFecact() {
		return this.fchaFecact;
	}

	public String getMrcaActivo() {
		return this.mrcaActivo;
	}

	public void setDesgUsuact(String desgUsuact) {
		this.desgUsuact = desgUsuact;
	}

	public void setFchaFecact(Date fchaFecact) {
		this.fchaFecact = fchaFecact;
	}

	public void setMrcaActivo(String mrcaActivo) {
		this.mrcaActivo = mrcaActivo;
	}

	public Integer getCdgoExpedient() {
		return this.cdgoExpedient;
	}

	public void setCdgoExpedient(Integer cdgoExpedient) {
		this.cdgoExpedient = cdgoExpedient;
	}

}