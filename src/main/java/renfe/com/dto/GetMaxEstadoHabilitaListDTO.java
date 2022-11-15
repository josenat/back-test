package renfe.com.dto;


import java.sql.Date;

import javax.persistence.Column;

public class GetMaxEstadoHabilitaListDTO {
	
	@Column(name="INDICE")
	private int indice;

	@Column(name="CDGO_EXPEDIENT")
	private int cdgoExpedient;
	
	@Column(name="FCHA_CURSOINC")
	private Date fchaCursoinc;
	
	@Column(name="DESG_NIFPAS")
	private String desgNifpas;
	
	@Column(name ="DESG_PERSONA")
	private String desgPersona;
	
	@Column(name ="DESG_APELL1")
	private String desgApell1;
	
	@Column(name ="DESG_APELL2")
	private String desgApell2;
	
	@Column(name="CDGO_PERSONA")
	private Integer cdgoPersona;
	
	@Column(name="DESG_MATRICULA")
	private String desgMatricula;
	
	@Column(name="CDGO_TIPOHAB")
	private Integer cdgoTipohab;
	
	@Column(name="DESG_TIPOHAB")
	private String desgTipohab;
	
	@Column(name="CDGO_ALCANCEOT")
	private Integer cdgoAlcanceot;
	
	@Column(name="CDGO_ESPEC")
	private Integer cdgoEspec;
	
	@Column(name="CDGO_ALCANCEAMBITO")
	private Integer cdgoAlcanceambito;
	
	@Column(name="CDGO_ENTORNO")
	private Integer cdgoEntorno;
	
	@Column(name="CDGO_LINEA")
	private String cdgoLinea;
	
	@Column(name="CDGO_SERIE")
	private String cdgoSerie;
	
	@Column(name="CDGO_SUBSERIE")
	private String cdgoSubserie;
	
	@Column(name="CDGO_AREACT")
	private Integer cdgoAreAct;
	
	@Column(name="CDGO_ARETERR")
	private Integer cdgoAreTerr;
	
	@Column(name="CDGO_CENTROCONT")
	private String cdgoCentroCont;
	
	@Column(name="DESG_AREACT")
	private String desgAreAct;
	
	@Column(name="DESG_ARETERR")
	private String desgAreTerr;
	
	@Column(name="DESG_CENTROCONT")
	private String desgCentroCont;
	
	@Column(name="DESG_EMPRESA")
	private String desgEmpresa;
	
	@Column(name="ESTADO_TITULOS")
	private String estadoTitulos;
	
	@Column(name="COLOR")
	private String color;
	
	@Column(name="CDGO_ALCANCE")
	private Integer cdgoAlcance;
	
	@Column(name="DESG_ALCANCE")
	private String desgAlcance;
	

	public int getIndice() {
		return indice;
	}

	public void setIndice(int indice) {
		this.indice = indice;
	}

	public int getCdgoExpedient() {
		return cdgoExpedient;
	}

	public void setCdgoExpedient(int cdgoExpedient) {
		this.cdgoExpedient = cdgoExpedient;
	}

	public Date getFchaCursoinc() {
		return fchaCursoinc;
	}

	public void setFchaCursoinc(Date fchaCursoinc) {
		this.fchaCursoinc = fchaCursoinc;
	}

	public String getDesgNifpas() {
		return desgNifpas;
	}

	public void setDesgNifpas(String desgNifpas) {
		this.desgNifpas = desgNifpas;
	}

	public String getDesgPersona() {
		return desgPersona;
	}

	public void setDesgPersona(String desgPersona) {
		this.desgPersona = desgPersona;
	}

	public String getDesgApell1() {
		return desgApell1;
	}

	public void setDesgApell1(String desgApell1) {
		this.desgApell1 = desgApell1;
	}

	public String getDesgApell2() {
		return desgApell2;
	}

	public void setDesgApell2(String desgApell2) {
		this.desgApell2 = desgApell2;
	}

	public Integer getCdgoPersona() {
		return cdgoPersona;
	}

	public void setCdgoPersona(Integer cdgoPersona) {
		this.cdgoPersona = cdgoPersona;
	}

	public String getDesgMatricula() {
		return desgMatricula;
	}

	public void setDesgMatricula(String desgMatricula) {
		this.desgMatricula = desgMatricula;
	}

	public Integer getCdgoTipohab() {
		return cdgoTipohab;
	}

	public void setCdgoTipohab(Integer cdgoTipohab) {
		this.cdgoTipohab = cdgoTipohab;
	}

	public String getDesgTipohab() {
		return desgTipohab;
	}

	public void setDesgTipohab(String desgTipohab) {
		this.desgTipohab = desgTipohab;
	}

	public Integer getCdgoAlcanceot() {
		return cdgoAlcanceot;
	}

	public void setCdgoAlcanceot(Integer cdgoAlcanceot) {
		this.cdgoAlcanceot = cdgoAlcanceot;
	}

	public Integer getCdgoEspec() {
		return cdgoEspec;
	}

	public void setCdgoEspec(Integer cdgoEspec) {
		this.cdgoEspec = cdgoEspec;
	}

	public Integer getCdgoAlcanceambito() {
		return cdgoAlcanceambito;
	}

	public void setCdgoAlcanceambito(Integer cdgoAlcanceambito) {
		this.cdgoAlcanceambito = cdgoAlcanceambito;
	}

	public Integer getCdgoEntorno() {
		return cdgoEntorno;
	}

	public void setCdgoEntorno(Integer cdgoEntorno) {
		this.cdgoEntorno = cdgoEntorno;
	}

	public String getCdgoLinea() {
		return cdgoLinea;
	}

	public void setCdgoLinea(String cdgoLinea) {
		this.cdgoLinea = cdgoLinea;
	}

	public String getCdgoSerie() {
		return cdgoSerie;
	}

	public void setCdgoSerie(String cdgoSerie) {
		this.cdgoSerie = cdgoSerie;
	}

	public String getCdgoSubserie() {
		return cdgoSubserie;
	}

	public void setCdgoSubserie(String cdgoSubserie) {
		this.cdgoSubserie = cdgoSubserie;
	}

	public Integer getCdgoAreAct() {
		return cdgoAreAct;
	}

	public void setCdgoAreAct(Integer cdgoAreAct) {
		this.cdgoAreAct = cdgoAreAct;
	}

	public Integer getCdgoAreTerr() {
		return cdgoAreTerr;
	}

	public void setCdgoAreTerr(Integer cdgoAreter) {
		this.cdgoAreTerr = cdgoAreter;
	}

	public String getCdgoCentroCont() {
		return cdgoCentroCont;
	}

	public void setCdgoCentroCont(String cdgoCentroCont) {
		this.cdgoCentroCont = cdgoCentroCont;
	}

	public String getDesgAreAct() {
		return desgAreAct;
	}

	public void setDesgAreAct(String desgAreAct) {
		this.desgAreAct = desgAreAct;
	}

	public String getDesgAreTerr() {
		return desgAreTerr;
	}

	public void setDesgAreTerr(String desgAreTerr) {
		this.desgAreTerr = desgAreTerr;
	}

	public String getDesgCentroCont() {
		return desgCentroCont;
	}

	public void setDesgCentroCont(String desgCentroCont) {
		this.desgCentroCont = desgCentroCont;
	}

	public String getDesgEmpresa() {
		return desgEmpresa;
	}

	public void setDesgEmpresa(String desgEmpresa) {
		this.desgEmpresa = desgEmpresa;
	}

	public String getEstadoTitulos() {
		return estadoTitulos;
	}

	public void setEstadoTitulos(String estadoTitulos) {
		this.estadoTitulos = estadoTitulos;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Integer getCdgoAlcance() {
		return cdgoAlcance;
	}

	public void setCdgoAlcance(Integer cdgoAlcance) {
		this.cdgoAlcance = cdgoAlcance;
	}

	public String getDesgAlcance() {
		return desgAlcance;
	}

	public void setDesgAlcance(String desgAlcance) {
		this.desgAlcance = desgAlcance;
	}
	
}

