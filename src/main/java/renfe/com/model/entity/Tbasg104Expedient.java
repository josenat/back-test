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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "TBASG104_EXPEDIENT", schema = "PASG")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tbasg104Expedient {

	@Id
	@Column(name = "CDGO_EXPEDIENT")
	private Long cdgoExpedient;

	@Column(name = "CDGO_ALCANAUXCAB")
	private Integer cdgoAlcanauxcab;

	@Column(name = "CDGO_ALCANCEAMBITO")
	private Integer cdgoAlcanceambito;
	
	/*@ManyToOne
	@JoinColumn(name = "CDGO_PERSONA", nullable = true, foreignKey = @ForeignKey(name = "CDGO_PERSONA"))
	private Tbasg100Persona cdgoPersona;*/

	@Column(name = "CDGO_PERSONA")
	private Integer cdgoPersona;
	
	@Column(name = "DESG_AVISO")
	private String desgAviso;

	@Column(name = "DESG_OBSERVA")
	private String desgObserva;

	@Column(name = "DESG_OBSERVA_EXT")
	private String desgObservaExt;

	@Column(name = "DESG_TIPOINFRAESTRUC")
	private String desgTipoinfraestruc;

	@Column(name = "DESG_USUACT")
	private String desgUsuact;

	@Column(name = "FCHA_ACT")
	private Date fchaAct;

	@Column(name = "FCHA_EXPEDIENTE")
	private Date fchaExpediente;

	@Column(name = "MRCA_ACTIVO")
	private String mrcaActivo;

	/*@ManyToOne
	@JoinColumn(name = "CDGO_ALCANCEOT", nullable = true, foreignKey = @ForeignKey(name = "CDGO$ALC"))
	private Tbasg131Alcanceot cdgoAlcanceot;*/
	
	@Column(name = "CDGO_ALCANCEOT")
	private Integer cdgoAlcanceot;

	/*@ManyToOne
	@JoinColumn(name = "CDGO_AMBITOS", nullable = false, foreignKey = @ForeignKey(name = "CDGO$AMB"))
	private Tbasg124Ambitos cdgoAmbitos;*/

	@Column(name = "CDGO_AMBITOS")
	private Integer cdgoAmbitos;
	
	/*@ManyToOne
	@JoinColumn(name = "CDGO_EMPRESA", nullable = false, foreignKey = @ForeignKey(name = "CDGO$EMP"))
	private Tbasg125Empresa cdgoEmpresa;*/
	
	@Column(name = "CDGO_EMPRESA")
	private Integer cdgoEmpresa;

	/*@ManyToOne
	@JoinColumn(name = "CDGO_ENTORNO", nullable = true, foreignKey = @ForeignKey(name = "CDGO$ENT"))
	private Tbasg129Entornos cdgoEntorno;*/

	@Column(name = "CDGO_ENTORNO")
	private Integer cdgoEntorno;
	
	/*@ManyToOne
	@JoinColumn(name = "CDGO_ESPEC", nullable = true, foreignKey = @ForeignKey(name = "CDGO$ESP"))
	private Tbasg137Especiali cdgoEspec;*/
	
	@Column(name = "CDGO_ESPEC")
	private Integer cdgoEspec;

	/*@ManyToOne
	@JoinColumn(name = "CDGO_LINEA", nullable = true, foreignKey = @ForeignKey(name = "CDGO$LIN"))
	private Tbasg127Lineas cdgoLinea;*/
	
	@Column(name = "CDGO_LINEA")
	private String cdgoLinea;

	/*@ManyToOne
	@JoinColumn(name = "CDGO_SERIE", nullable = true, foreignKey = @ForeignKey(name = "CDGO_SERIE"))
	@JoinColumn(name = "CDGO_SUBSERIE", nullable = true, foreignKey = @ForeignKey(name = "CDGO_SUBSERIE"))
	private Tbasg147Subserie cdgoSerie;*/
	
	@Column(name = "CDGO_SERIE")
	private String cdgoSerie;
	
	@Column(name = "CDGO_SUBSERIE")
	private String cdgoSubSerie;
	
	/*@ManyToOne
	@JoinColumn(name = "CDGO_TIPOHAB", nullable = false, foreignKey = @ForeignKey(name = "CDGO_TIPOHAB"))
	private Tbasg123Tipohabil cdgoTipohab;*/
	
	@Column(name = "CDGO_TIPOHAB")
	private Integer cdgoTipohab;

	/*@ManyToOne
	@JoinColumn(name = "CDGO_SOCIOTOR", nullable = false, foreignKey = @ForeignKey(name = "CDGO_SOCIEDAD"))
	private Tbasg261Sociedades cdgoSociotor;*/
	
	@Column(name = "CDGO_SOCIOTOR")
	private String cdgoSociotor;

	public Long getCdgoExpedient() {
		return this.cdgoExpedient;
	}

	public void setCdgoExpedient(Long cdgoExpedient) {
		this.cdgoExpedient = cdgoExpedient;
	}

	public Integer getCdgoAlcanauxcab() {
		return this.cdgoAlcanauxcab;
	}

	public Integer getCdgoAlcanceambito() {
		return this.cdgoAlcanceambito;
	}

	public Integer getCdgoPersona() {
		return this.cdgoPersona;
	}

	public String getDesgAviso() {
		return this.desgAviso;
	}

	public String getDesgObserva() {
		return this.desgObserva;
	}

	public String getDesgObservaExt() {
		return this.desgObservaExt;
	}

	public String getDesgTipoinfraestruc() {
		return this.desgTipoinfraestruc;
	}

	public String getDesgUsuact() {
		return this.desgUsuact;
	}

	public Date getFchaAct() {
		return this.fchaAct;
	}

	public Date getFchaExpediente() {
		return this.fchaExpediente;
	}

	public String getMrcaActivo() {
		return this.mrcaActivo;
	}

	public void setCdgoAlcanauxcab(Integer cdgoAlcanauxcab) {
		this.cdgoAlcanauxcab = cdgoAlcanauxcab;
	}

	public void setCdgoAlcanceambito(Integer cdgoAlcanceambito) {
		this.cdgoAlcanceambito = cdgoAlcanceambito;
	}

	public void setCdgoPersona(Integer cdgoPersona) {
		this.cdgoPersona = cdgoPersona;
	}

	public void setDesgAviso(String desgAviso) {
		this.desgAviso = desgAviso;
	}

	public void setDesgObserva(String desgObserva) {
		this.desgObserva = desgObserva;
	}

	public void setDesgObservaExt(String desgObservaExt) {
		this.desgObservaExt = desgObservaExt;
	}

	public void setDesgTipoinfraestruc(String desgTipoinfraestruc) {
		this.desgTipoinfraestruc = desgTipoinfraestruc;
	}

	public void setDesgUsuact(String desgUsuact) {
		this.desgUsuact = desgUsuact;
	}

	public void setFchaAct(Date fchaAct) {
		this.fchaAct = fchaAct;
	}

	public void setFchaExpediente(Date fchaExpediente) {
		this.fchaExpediente = fchaExpediente;
	}

	public void setMrcaActivo(String mrcaActivo) {
		this.mrcaActivo = mrcaActivo;
	}

	public Integer getCdgoAlcanceot() {
		return this.cdgoAlcanceot;
	}

	public Integer getCdgoAmbitos() {
		return this.cdgoAmbitos;
	}

	public Integer getCdgoEmpresa() {
		return this.cdgoEmpresa;
	}

	public Integer getCdgoEntorno() {
		return this.cdgoEntorno;
	}

	public Integer getCdgoEspec() {
		return this.cdgoEspec;
	}

	public String getCdgoLinea() {
		return this.cdgoLinea;
	}

	/*public String getCdgoSerie() {
		return this.cdgoSerie.getTbasg147subseriepk().getCdgoSerie();
	}
	
	public Object getCdgoSubserie() {
		return this.cdgoSerie.getTbasg147subseriepk().getCdgoSubserie();
	}*/

	public Integer getCdgoTipohab() {
		return this.cdgoTipohab;
	}

	public String getCdgoSociotor() {
		return this.cdgoSociotor;
	}

	public void setCdgoAlcanceot(Integer cdgoAlcanceot) {
		this.cdgoAlcanceot = cdgoAlcanceot;
	}

	public void setCdgoAmbitos(Integer cdgoAmbitos) {
		this.cdgoAmbitos = cdgoAmbitos;
	}

	public void setCdgoEmpresa(Integer cdgoEmpresa) {
		this.cdgoEmpresa = cdgoEmpresa;
	}

	public void setCdgoEntorno(Integer cdgoEntorno) {
		this.cdgoEntorno = cdgoEntorno;
	}

	public void setCdgoEspec(Integer cdgoEspec) {
		this.cdgoEspec = cdgoEspec;
	}

	public void setCdgoLinea(String cdgoLinea) {
		this.cdgoLinea = cdgoLinea;
	}

	/*public void setCdgoSerie(String cdgoSerie) {
		this.cdgoSerie.getTbasg147subseriepk().setCdgoSerie(cdgoSerie);
	}
	
	public void setCdgoSubserie(String cdgoSubSerie) {
		this.cdgoSerie.getTbasg147subseriepk().setCdgoSubserie(cdgoSubSerie);
	}*/

	public void setCdgoTipohab(Integer cdgoTipohab) {
		this.cdgoTipohab = cdgoTipohab;
	}

	public void setCdgoSociotor(String cdgoSociotor) {
		this.cdgoSociotor = cdgoSociotor;
	}

	public String getCdgoSerie() {
		return cdgoSerie;
	}

	public void setCdgoSerie(String cdgoSerie) {
		this.cdgoSerie = cdgoSerie;
	}

	public String getCdgoSubSerie() {
		return cdgoSubSerie;
	}

	public void setCdgoSubSerie(String cdgoSubSerie) {
		this.cdgoSubSerie = cdgoSubSerie;
	}


}