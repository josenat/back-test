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
@Table(name = "TBASG121_ACTAFORMA")
public class Tbasg121Actaforma {

	@Id
	@Column(name = "CDGO_ACTAFORM")
	private Integer cdgoActaform;

	@Column(name = "CDGO_ACREDITA")
	private Integer cdgoAcredita;

	@Column(name = "CDGO_CURSO")
	private String cdgoCurso;

	@Column(name = "DESG_DESCCURSO")
	private String desgDesccurso;

	@Column(name = "DESG_OBSERVA")
	private String desgObserva;

	@Column(name = "DESG_USUACT")
	private String desgUsuact;

	@Column(name = "FCHA_ACT")
	private Date fchaAct;

	@Column(name = "MRCA_ACTIVO")
	private String mrcaActivo;

	@Column(name = "CDGO_CENTROFOR")
	private Integer cdgoCentrofor;
	
	@Column(name = "CDGO_EXPEDIENT")
	private Integer cdgoExpedient;
	
	@Column(name = "CDGO_TIT")
	private Integer cdgoTit;

	public Integer getCdgoActaform() {
		return this.cdgoActaform;
	}

	public void setCdgoActaform(Integer cdgoActaform) {
		this.cdgoActaform = cdgoActaform;
	}

	public Integer getCdgoAcredita() {
		return this.cdgoAcredita;
	}

	public String getCdgoCurso() {
		return this.cdgoCurso;
	}

	public String getDesgDesccurso() {
		return this.desgDesccurso;
	}

	public String getDesgObserva() {
		return this.desgObserva;
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

	public void setCdgoAcredita(Integer cdgoAcredita) {
		this.cdgoAcredita = cdgoAcredita;
	}

	public void setCdgoCurso(String cdgoCurso) {
		this.cdgoCurso = cdgoCurso;
	}

	public void setDesgDesccurso(String desgDesccurso) {
		this.desgDesccurso = desgDesccurso;
	}

	public void setDesgObserva(String desgObserva) {
		this.desgObserva = desgObserva;
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

	public Integer getCdgoCentrofor() {
		return cdgoCentrofor;
	}

	public void setCdgoCentrofor(Integer cdgoCentrofor) {
		this.cdgoCentrofor = cdgoCentrofor;
	}

	public Integer getCdgoExpedient() {
		return cdgoExpedient;
	}

	public void setCdgoExpedient(Integer cdgoExpedient) {
		this.cdgoExpedient = cdgoExpedient;
	}

	public Integer getCdgoTit() {
		return cdgoTit;
	}

	public void setCdgoTit(Integer cdgoTit) {
		this.cdgoTit = cdgoTit;
	}

}