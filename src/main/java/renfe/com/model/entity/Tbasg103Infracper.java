package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG103_INFRACPER")
public class Tbasg103Infracper {

	@Id
	@Column(name = "CDGO_INFRPER")
	private Long cdgoInfrper;

	@NotNull
	@Column(name = "CDGO_PERSONA")
	private Integer cdgoPersona;

	@Column(name = "CDGO_REFERENCIADOC")
	private Integer cdgoReferenciadoc;

	@Column(name = "DESG_MEDIDASADOP")
	private String desgMedidasadop;

	@Column(name = "DESG_USUACT")
	private String desgUsuact;

	@Column(name = "FCHA_ACT")
	private Date fchaAct;

	@Column(name = "FCHA_DESDE")
	private Date fchaDesde;

	@NotNull
	@Column(name = "FCHA_FHINFR")
	private Date fchaFhinfr;

	@Column(name = "FCHA_HASTA")
	private Date fchaHasta;

	@Column(name = "MRCA_ACTIVO")
	private String mrcaActivo;

	@ManyToOne
	@JoinColumn(name = "CDGO_GRADO", nullable = false, foreignKey = @ForeignKey(name = "CDGO$GRA"))
	private Tbasg114Gradoinci cdgoGrado;

	@ManyToOne
	@JoinColumn(name = "CDGO_SANCION", nullable = false, foreignKey = @ForeignKey(name = "CDGO$SAN"))
	private Tbasg113Sancion cdgoSancion;

	@ManyToOne
	@JoinColumn(name = "CDGO_TIPINFR", nullable = false, foreignKey = @ForeignKey(name = "CDGO$TIP"))
	private Tbasg112Tipoinfra cdgoTipinfr;

	public Long getCdgoInfrper() {
		return this.cdgoInfrper;
	}

	public void setCdgoInfrper(Long cdgoInfrper) {
		this.cdgoInfrper = cdgoInfrper;
	}

	public Integer getCdgoPersona() {
		return this.cdgoPersona;
	}

	public Integer getCdgoReferenciadoc() {
		return this.cdgoReferenciadoc;
	}

	public String getDesgMedidasadop() {
		return this.desgMedidasadop;
	}

	public String getDesgUsuact() {
		return this.desgUsuact;
	}

	public Date getFchaAct() {
		return this.fchaAct;
	}

	public Date getFchaDesde() {
		return this.fchaDesde;
	}

	public Date getFchaFhinfr() {
		return this.fchaFhinfr;
	}

	public Date getFchaHasta() {
		return this.fchaHasta;
	}

	public String getMrcaActivo() {
		return this.mrcaActivo;
	}

	public void setCdgoPersona(Integer cdgoPersona) {
		this.cdgoPersona = cdgoPersona;
	}

	public void setCdgoReferenciadoc(Integer cdgoReferenciadoc) {
		this.cdgoReferenciadoc = cdgoReferenciadoc;
	}

	public void setDesgMedidasadop(String desgMedidasadop) {
		this.desgMedidasadop = desgMedidasadop;
	}

	public void setDesgUsuact(String desgUsuact) {
		this.desgUsuact = desgUsuact;
	}

	public void setFchaAct(Date fchaAct) {
		this.fchaAct = fchaAct;
	}

	public void setFchaDesde(Date fchaDesde) {
		this.fchaDesde = fchaDesde;
	}

	public void setFchaFhinfr(Date fchaFhinfr) {
		this.fchaFhinfr = fchaFhinfr;
	}

	public void setFchaHasta(Date fchaHasta) {
		this.fchaHasta = fchaHasta;
	}

	public void setMrcaActivo(String mrcaActivo) {
		this.mrcaActivo = mrcaActivo;
	}

	public Tbasg114Gradoinci getCdgoGrado() {
		return this.cdgoGrado;
	}

	public Tbasg113Sancion getCdgoSancion() {
		return this.cdgoSancion;
	}

	public Tbasg112Tipoinfra getCdgoTipinfr() {
		return this.cdgoTipinfr;
	}

	public void setCdgoGrado(Tbasg114Gradoinci cdgoGrado) {
		this.cdgoGrado = cdgoGrado;
	}

	public void setCdgoSancion(Tbasg113Sancion cdgoSancion) {
		this.cdgoSancion = cdgoSancion;
	}

	public void setCdgoTipinfr(Tbasg112Tipoinfra cdgoTipinfr) {
		this.cdgoTipinfr = cdgoTipinfr;
	}

}