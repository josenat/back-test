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
@Table(name = "TBASG267_EXPED_ACRED")
public class Tbasg267ExpedAcred {

	@Id
	@Column(name = "CDGO_ACREDITA")
	private Integer cdgoAcredita;

	@NotNull
	@Column(name = "CDGO_EMPRESA")
	private Integer cdgoEmpresa;

	@Column(name = "CDGO_ESTACION")
	private String cdgoEstacion;

	@NotNull
	@Column(name = "CDGO_PERSONA")
	private Integer cdgoPersona;

	@Column(name = "DESG_OBSERVA")
	private String desgObserva;

	@NotNull
	@Column(name = "DESG_USUACT")
	private String desgUsuact;

	@NotNull
	@Column(name = "FCHA_ACREDITA")
	private Date fchaAcredita;

	@NotNull
	@Column(name = "FCHA_ACT")
	private Date fchaAct;

	@Column(name = "FCHA_CADUC")
	private Date fchaCaduc;

	@NotNull
	@Column(name = "MRCA_ACTIVO")
	private String mrcaActivo;

	/*@ManyToOne
	@JoinColumn(name = "CDGO_LINEA", nullable = true, foreignKey = @ForeignKey(name = "CDGOLINEA_FK"))
	private Tbasg265AmbitoLinea cdgoLinea;*/
	
	@Column(name = "CDGO_LINEA")
	private String cdgoLinea;

	/*@ManyToOne
	@JoinColumn(name = "CDGO_PUERTO", nullable = true, foreignKey = @ForeignKey(name = "CDGOPUERTO_FK"))
	private Tbasg264AmbitoPuert cdgoPuerto;*/

	@Column(name = "CDGO_PUERTO")
	private String cdgoPuerto;
	
	/*@ManyToOne
	@JoinColumn(name = "CDGO_TIPOACREDITA", nullable = false, foreignKey = @ForeignKey(name = "CDGOTIPOACRE_FK"))
	private Tbasg262TipoAcredita cdgoTipoacredita;*/
	
	@Column(name = "CDGO_TIPOACREDITA")
	private String cdgoTipoacredita;

	public Integer getCdgoAcredita() {
		return this.cdgoAcredita;
	}

	public void setCdgoAcredita(Integer cdgoAcredita) {
		this.cdgoAcredita = cdgoAcredita;
	}

	public Integer getCdgoEmpresa() {
		return this.cdgoEmpresa;
	}

	public String getCdgoEstacion() {
		return this.cdgoEstacion;
	}

	public Integer getCdgoPersona() {
		return this.cdgoPersona;
	}

	public String getDesgObserva() {
		return this.desgObserva;
	}

	public String getDesgUsuact() {
		return this.desgUsuact;
	}

	public Date getFchaAcredita() {
		return this.fchaAcredita;
	}

	public Date getFchaAct() {
		return this.fchaAct;
	}

	public Date getFchaCaduc() {
		return this.fchaCaduc;
	}

	public String getMrcaActivo() {
		return this.mrcaActivo;
	}

	public void setCdgoEmpresa(Integer cdgoEmpresa) {
		this.cdgoEmpresa = cdgoEmpresa;
	}

	public void setCdgoEstacion(String cdgoEstacion) {
		this.cdgoEstacion = cdgoEstacion;
	}

	public void setCdgoPersona(Integer cdgoPersona) {
		this.cdgoPersona = cdgoPersona;
	}

	public void setDesgObserva(String desgObserva) {
		this.desgObserva = desgObserva;
	}

	public void setDesgUsuact(String desgUsuact) {
		this.desgUsuact = desgUsuact;
	}

	public void setFchaAcredita(Date fchaAcredita) {
		this.fchaAcredita = fchaAcredita;
	}

	public void setFchaAct(Date fchaAct) {
		this.fchaAct = fchaAct;
	}

	public void setFchaCaduc(Date fchaCaduc) {
		this.fchaCaduc = fchaCaduc;
	}

	public void setMrcaActivo(String mrcaActivo) {
		this.mrcaActivo = mrcaActivo;
	}

	public String getCdgoLinea() {
		return this.cdgoLinea;
	}

	public String getCdgoPuerto() {
		return this.cdgoPuerto;
	}

	public String getCdgoTipoacredita() {
		return this.cdgoTipoacredita;
	}

	public void setCdgoLinea(String cdgoLinea) {
		this.cdgoLinea = cdgoLinea;
	}

	public void setCdgoPuerto(String cdgoPuerto) {
		this.cdgoPuerto = cdgoPuerto;
	}

	public void setCdgoTipoacredita(String cdgoTipoacredita) {
		this.cdgoTipoacredita = cdgoTipoacredita;
	}

}