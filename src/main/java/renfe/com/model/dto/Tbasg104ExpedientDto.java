package renfe.com.model.dto;

import java.sql.Date;
import java.util.List;

import javax.persistence.Transient;

public class Tbasg104ExpedientDto {

	private Integer cdgoAlcanauxcab;
	private Integer cdgoAlcanceambito;
	private Integer cdgoAlcanceot;
	private Integer cdgoAmbitos;
	private Integer cdgoEmpresa;
	private Integer cdgoEntorno;
	private Integer cdgoEspec;
	private Integer cdgoExpedient;
	private String cdgoLinea;
	//private Tbasg100PersonaDto cdgoPersona;
	private Integer cdgoPersona;
	private String cdgoSerie;
	private String cdgoSociotor;
	private String cdgoSubserie;
	private Integer cdgoTipohab;
	private String desgAviso;
	private String desgObserva;
	private String desgObservaExt;
	private String desgTipoinfraestruc;
	private String desgUsuact;
	private Date fchaAct;
	private Date fchaExpediente;
	private String mrcaActivo;
	private String alcance;
	
	@Transient
	private List suspensiones;
	
	@Transient	
	private List reactivaciones;


	public Integer getCdgoAlcanauxcab() {
		return this.cdgoAlcanauxcab;
	}

	public void setCdgoAlcanauxcab(Integer cdgoAlcanauxcab) {
		this.cdgoAlcanauxcab = cdgoAlcanauxcab;
	}

	public Integer getCdgoAlcanceambito() {
		return this.cdgoAlcanceambito;
	}

	public void setCdgoAlcanceambito(Integer cdgoAlcanceambito) {
		this.cdgoAlcanceambito = cdgoAlcanceambito;
	}

	public Integer getCdgoAlcanceot() {
		return this.cdgoAlcanceot;
	}

	public void setCdgoAlcanceot(Integer cdgoAlcanceot) {
		this.cdgoAlcanceot = cdgoAlcanceot;
	}

	public Integer getCdgoAmbitos() {
		return this.cdgoAmbitos;
	}

	public void setCdgoAmbitos(Integer cdgoAmbitos) {
		this.cdgoAmbitos = cdgoAmbitos;
	}

	public Integer getCdgoEmpresa() {
		return this.cdgoEmpresa;
	}

	public void setCdgoEmpresa(Integer cdgoEmpresa) {
		this.cdgoEmpresa = cdgoEmpresa;
	}

	public Integer getCdgoEntorno() {
		return this.cdgoEntorno;
	}

	public void setCdgoEntorno(Integer cdgoEntorno) {
		this.cdgoEntorno = cdgoEntorno;
	}

	public Integer getCdgoEspec() {
		return this.cdgoEspec;
	}

	public void setCdgoEspec(Integer cdgoEspec) {
		this.cdgoEspec = cdgoEspec;
	}

	public Integer getCdgoExpedient() {
		return this.cdgoExpedient;
	}

	public void setCdgoExpedient(Integer cdgoExpedient) {
		this.cdgoExpedient = cdgoExpedient;
	}

	public String getCdgoLinea() {
		return this.cdgoLinea;
	}

	public void setCdgoLinea(String cdgoLinea) {
		this.cdgoLinea = cdgoLinea;
	}

	public Integer getCdgoPersona() {
		return this.cdgoPersona;
	}

	public void setCdgoPersona(Integer cdgoPersona) {
		this.cdgoPersona = cdgoPersona;
	}

	public String getCdgoSerie() {
		return this.cdgoSerie;
	}

	public void setCdgoSerie(String cdgoSerie) {
		this.cdgoSerie = cdgoSerie;
	}

	public String getCdgoSociotor() {
		return this.cdgoSociotor;
	}

	public void setCdgoSociotor(String cdgoSociotor) {
		this.cdgoSociotor = cdgoSociotor;
	}

	public String getCdgoSubserie() {
		return this.cdgoSubserie;
	}

	public void setCdgoSubserie(String cdgoSubserie) {
		this.cdgoSubserie = cdgoSubserie;
	}

	public Integer getCdgoTipohab() {
		return this.cdgoTipohab;
	}

	public void setCdgoTipohab(Integer cdgoTipohab) {
		this.cdgoTipohab = cdgoTipohab;
	}

	public String getDesgAviso() {
		return this.desgAviso;
	}

	public void setDesgAviso(String desgAviso) {
		this.desgAviso = desgAviso;
	}

	public String getDesgObserva() {
		return this.desgObserva;
	}

	public void setDesgObserva(String desgObserva) {
		this.desgObserva = desgObserva;
	}

	public String getDesgObservaExt() {
		return this.desgObservaExt;
	}

	public void setDesgObservaExt(String desgObservaExt) {
		this.desgObservaExt = desgObservaExt;
	}

	public String getDesgTipoinfraestruc() {
		return this.desgTipoinfraestruc;
	}

	public void setDesgTipoinfraestruc(String desgTipoinfraestruc) {
		this.desgTipoinfraestruc = desgTipoinfraestruc;
	}

	public String getDesgUsuact() {
		return this.desgUsuact;
	}

	public void setDesgUsuact(String desgUsuact) {
		this.desgUsuact = desgUsuact;
	}

	public Date getFchaAct() {
		return this.fchaAct;
	}

	public void setFchaAct(Date fchaAct) {
		this.fchaAct = fchaAct;
	}

	public Date getFchaExpediente() {
		return this.fchaExpediente;
	}

	public void setFchaExpediente(Date fchaExpediente) {
		this.fchaExpediente = fchaExpediente;
	}

	public String getMrcaActivo() {
		return this.mrcaActivo;
	}

	public void setMrcaActivo(String mrcaActivo) {
		this.mrcaActivo = mrcaActivo;
	}
	public List getSuspensiones() {
		return suspensiones;
	}

	public void setSuspensiones(List suspensiones) {
		this.suspensiones = suspensiones;
	}

	public List getReactivaciones() {
		return reactivaciones;
	}

	public void setReactivaciones(List reactivaciones) {
		this.reactivaciones = reactivaciones;
	}

	public String getAlcance() {
		return this.alcance;
	}

	public void setAlcance(String alcance) {
		this.alcance = alcance;
	}

}