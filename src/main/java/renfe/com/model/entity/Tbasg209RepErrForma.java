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
@Table(name = "TBASG209_REP_ERR_FORMA", schema = "PASG")
public class Tbasg209RepErrForma {

	@Id
	@Column(name = "CDGO_REPROCESADO")
	private Long cdgoReprocesado;

	@Column(name = "CDGO_ACTO")
	private String cdgoActo;

	@Column(name = "CDGO_PR_CALIFI")
	private Integer cdgoPrCalifi;

	@Column(name = "CDGO_SAPCENTFORM")
	private String cdgoSapcentform;

	@Column(name = "CDGO_SOLICITUD")
	private Integer cdgoSolicitud;

	@Column(name = "CDGO_TE_CALIFI")
	private Integer cdgoTeCalifi;

	@Column(name = "CDGO_TP_CALIFI")
	private Integer cdgoTpCalifi;

	@Column(name = "DESG_CIF")
	private String desgCif;

	@Column(name = "DESG_DESCACTO")
	private String desgDescacto;

	@Column(name = "DESG_OBSERVACIONES")
	private String desgObservaciones;

	@Column(name = "DESG_PR_APELLINSTR1")
	private String desgPrApellinstr1;

	@Column(name = "DESG_PR_APELLINSTR2")
	private String desgPrApellinstr2;

	@Column(name = "DESG_PR_NIFINSTR")
	private String desgPrNifinstr;

	@Column(name = "DESG_PR_NOMINSTR")
	private String desgPrNominstr;

	@Column(name = "DESG_RE_APELLINSTR1")
	private String desgReApellinstr1;

	@Column(name = "DESG_RE_APELLINSTR2")
	private String desgReApellinstr2;

	@Column(name = "DESG_RE_NIFINSTR")
	private String desgReNifinstr;

	@Column(name = "DESG_RE_NOMINSTR")
	private String desgReNominstr;

	@Column(name = "DESG_TE_APELLINSTR1")
	private String desgTeApellinstr1;

	@Column(name = "DESG_TE_APELLINSTR2")
	private String desgTeApellinstr2;

	@Column(name = "DESG_TE_NIFINSTR")
	private String desgTeNifinstr;

	@Column(name = "DESG_TE_NOMINSTR")
	private String desgTeNominstr;

	@Column(name = "DESG_TP_APELLINSTR1")
	private String desgTpApellinstr1;

	@Column(name = "DESG_TP_APELLINSTR2")
	private String desgTpApellinstr2;

	@Column(name = "DESG_TP_NIFINSTR")
	private String desgTpNifinstr;

	@Column(name = "DESG_TP_NOMINSTR")
	private String desgTpNominstr;

	@Column(name = "DESG_USUACT")
	private String desgUsuact;

	@Column(name = "FCHA_ACT")
	private Date fchaAct;

	@Column(name = "FCHA_PRACTICO")
	private Date fchaPractico;

	@Column(name = "FCHA_RECICLAJE")
	private Date fchaReciclaje;

	@Column(name = "FCHA_TEORICO")
	private Date fchaTeorico;

	@Column(name = "FCHA_TEORIPRAC")
	private Date fchaTeoriprac;

	/*@ManyToOne
	@JoinColumn(name = "CDGO_ERROR", nullable = true, foreignKey = @ForeignKey(name = "CDGO$ERR"))
	private Tbasg204ErrForma cdgoError;*/
	
	@Column(name = "CDGO_ERROR")
	private Integer cdgoError;

	public Long getCdgoReprocesado() {
		return this.cdgoReprocesado;
	}

	public void setCdgoReprocesado(Long cdgoReprocesado) {
		this.cdgoReprocesado = cdgoReprocesado;
	}

	public String getCdgoActo() {
		return this.cdgoActo;
	}

	public Integer getCdgoPrCalifi() {
		return this.cdgoPrCalifi;
	}

	public String getCdgoSapcentform() {
		return this.cdgoSapcentform;
	}

	public Integer getCdgoSolicitud() {
		return this.cdgoSolicitud;
	}

	public Integer getCdgoTeCalifi() {
		return this.cdgoTeCalifi;
	}

	public Integer getCdgoTpCalifi() {
		return this.cdgoTpCalifi;
	}

	public String getDesgCif() {
		return this.desgCif;
	}

	public String getDesgDescacto() {
		return this.desgDescacto;
	}

	public String getDesgObservaciones() {
		return this.desgObservaciones;
	}

	public String getDesgPrApellinstr1() {
		return this.desgPrApellinstr1;
	}

	public String getDesgPrApellinstr2() {
		return this.desgPrApellinstr2;
	}

	public String getDesgPrNifinstr() {
		return this.desgPrNifinstr;
	}

	public String getDesgPrNominstr() {
		return this.desgPrNominstr;
	}

	public String getDesgReApellinstr1() {
		return this.desgReApellinstr1;
	}

	public String getDesgReApellinstr2() {
		return this.desgReApellinstr2;
	}

	public String getDesgReNifinstr() {
		return this.desgReNifinstr;
	}

	public String getDesgReNominstr() {
		return this.desgReNominstr;
	}

	public String getDesgTeApellinstr1() {
		return this.desgTeApellinstr1;
	}

	public String getDesgTeApellinstr2() {
		return this.desgTeApellinstr2;
	}

	public String getDesgTeNifinstr() {
		return this.desgTeNifinstr;
	}

	public String getDesgTeNominstr() {
		return this.desgTeNominstr;
	}

	public String getDesgTpApellinstr1() {
		return this.desgTpApellinstr1;
	}

	public String getDesgTpApellinstr2() {
		return this.desgTpApellinstr2;
	}

	public String getDesgTpNifinstr() {
		return this.desgTpNifinstr;
	}

	public String getDesgTpNominstr() {
		return this.desgTpNominstr;
	}

	public String getDesgUsuact() {
		return this.desgUsuact;
	}

	public Date getFchaAct() {
		return this.fchaAct;
	}

	public Date getFchaPractico() {
		return this.fchaPractico;
	}

	public Date getFchaReciclaje() {
		return this.fchaReciclaje;
	}

	public Date getFchaTeorico() {
		return this.fchaTeorico;
	}

	public Date getFchaTeoriprac() {
		return this.fchaTeoriprac;
	}

	public void setCdgoActo(String cdgoActo) {
		this.cdgoActo = cdgoActo;
	}

	public void setCdgoPrCalifi(Integer cdgoPrCalifi) {
		this.cdgoPrCalifi = cdgoPrCalifi;
	}

	public void setCdgoSapcentform(String cdgoSapcentform) {
		this.cdgoSapcentform = cdgoSapcentform;
	}

	public void setCdgoSolicitud(Integer cdgoSolicitud) {
		this.cdgoSolicitud = cdgoSolicitud;
	}

	public void setCdgoTeCalifi(Integer cdgoTeCalifi) {
		this.cdgoTeCalifi = cdgoTeCalifi;
	}

	public void setCdgoTpCalifi(Integer cdgoTpCalifi) {
		this.cdgoTpCalifi = cdgoTpCalifi;
	}

	public void setDesgCif(String desgCif) {
		this.desgCif = desgCif;
	}

	public void setDesgDescacto(String desgDescacto) {
		this.desgDescacto = desgDescacto;
	}

	public void setDesgObservaciones(String desgObservaciones) {
		this.desgObservaciones = desgObservaciones;
	}

	public void setDesgPrApellinstr1(String desgPrApellinstr1) {
		this.desgPrApellinstr1 = desgPrApellinstr1;
	}

	public void setDesgPrApellinstr2(String desgPrApellinstr2) {
		this.desgPrApellinstr2 = desgPrApellinstr2;
	}

	public void setDesgPrNifinstr(String desgPrNifinstr) {
		this.desgPrNifinstr = desgPrNifinstr;
	}

	public void setDesgPrNominstr(String desgPrNominstr) {
		this.desgPrNominstr = desgPrNominstr;
	}

	public void setDesgReApellinstr1(String desgReApellinstr1) {
		this.desgReApellinstr1 = desgReApellinstr1;
	}

	public void setDesgReApellinstr2(String desgReApellinstr2) {
		this.desgReApellinstr2 = desgReApellinstr2;
	}

	public void setDesgReNifinstr(String desgReNifinstr) {
		this.desgReNifinstr = desgReNifinstr;
	}

	public void setDesgReNominstr(String desgReNominstr) {
		this.desgReNominstr = desgReNominstr;
	}

	public void setDesgTeApellinstr1(String desgTeApellinstr1) {
		this.desgTeApellinstr1 = desgTeApellinstr1;
	}

	public void setDesgTeApellinstr2(String desgTeApellinstr2) {
		this.desgTeApellinstr2 = desgTeApellinstr2;
	}

	public void setDesgTeNifinstr(String desgTeNifinstr) {
		this.desgTeNifinstr = desgTeNifinstr;
	}

	public void setDesgTeNominstr(String desgTeNominstr) {
		this.desgTeNominstr = desgTeNominstr;
	}

	public void setDesgTpApellinstr1(String desgTpApellinstr1) {
		this.desgTpApellinstr1 = desgTpApellinstr1;
	}

	public void setDesgTpApellinstr2(String desgTpApellinstr2) {
		this.desgTpApellinstr2 = desgTpApellinstr2;
	}

	public void setDesgTpNifinstr(String desgTpNifinstr) {
		this.desgTpNifinstr = desgTpNifinstr;
	}

	public void setDesgTpNominstr(String desgTpNominstr) {
		this.desgTpNominstr = desgTpNominstr;
	}

	public void setDesgUsuact(String desgUsuact) {
		this.desgUsuact = desgUsuact;
	}

	public void setFchaAct(Date fchaAct) {
		this.fchaAct = fchaAct;
	}

	public void setFchaPractico(Date fchaPractico) {
		this.fchaPractico = fchaPractico;
	}

	public void setFchaReciclaje(Date fchaReciclaje) {
		this.fchaReciclaje = fchaReciclaje;
	}

	public void setFchaTeorico(Date fchaTeorico) {
		this.fchaTeorico = fchaTeorico;
	}

	public void setFchaTeoriprac(Date fchaTeoriprac) {
		this.fchaTeoriprac = fchaTeoriprac;
	}

	public Integer getCdgoError() {
		return this.cdgoError;
	}

	public void setCdgoError(Integer cdgoError) {
		this.cdgoError = cdgoError;
	}

}