package renfe.com.dto;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Id;

public class GetMaxEstadoTitCondListAllDTO {
	
	@Column(name="FCHA_CURSOINC")
	private Date fchaCursoInc;
	
	@Column(name="FCHA_OTORGADO")
	private Date fchaOtorgado;
	
	@Column(name="CODIGO")
	private Integer codigo;
	
	@Column(name="DESG_TITULO")
	private String desgTitulo;
	
	@Column(name="DESG_PERSONA")
	private String desgPersona;
	
	@Id
	@Column(name="CDGO_PERSONA")
	private Integer cdgoPersona;
	
	@Column(name="DESG_APELL1")
	private String desgApell1;
	
	@Column(name="DESG_APELL2")
	private String desgApell2;
	
	@Column(name="DESG_MATRICULA")
	private String desgMatricula;
	
	@Column(name="DESG_NIFPAS")
	private String desgNifpas;
	
	@Column(name="ESTADO_TITULOS")
	private String estadoTitulos;
	
	@Column(name="FCHA_OTORGADOINC")
	private Date fchaOtorgadoInc;
	
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
	
	@Column(name="FCHA_CONJUNTA")
	private Date fchaConjunta;
	
	@Column(name="COLOR")
	private String color;

	public Date getFchaCursoInc() {
		return fchaCursoInc;
	}

	public void setFchaCursoInc(Date fchaCursoInc) {
		this.fchaCursoInc = fchaCursoInc;
	}

	public Date getFchaOtorgado() {
		return fchaOtorgado;
	}

	public void setFchaOtorgado(Date fchaOtorgado) {
		this.fchaOtorgado = fchaOtorgado;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDesgTitulo() {
		return desgTitulo;
	}

	public void setDesgTitulo(String desgTitulo) {
		this.desgTitulo = desgTitulo;
	}

	public String getDesgPersona() {
		return desgPersona;
	}

	public void setDesgPersona(String desgPersona) {
		this.desgPersona = desgPersona;
	}

	public Integer getCdgoPersona() {
		return cdgoPersona;
	}

	public void setCdgoPersona(Integer cdgoPersona) {
		this.cdgoPersona = cdgoPersona;
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

	public String getDesgMatricula() {
		return desgMatricula;
	}

	public void setDesgMatricula(String desgMatricula) {
		this.desgMatricula = desgMatricula;
	}

	public String getDesgNifpas() {
		return desgNifpas;
	}

	public void setDesgNifpas(String desgNifpas) {
		this.desgNifpas = desgNifpas;
	}

	public String getEstadoTitulos() {
		return estadoTitulos;
	}

	public void setEstadoTitulos(String estadoTitulos) {
		this.estadoTitulos = estadoTitulos;
	}

	public Date getFchaOtorgadoInc() {
		return fchaOtorgadoInc;
	}

	public void setFchaOtorgadoInc(Date fchaOtorgadoInc) {
		this.fchaOtorgadoInc = fchaOtorgadoInc;
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

	public void setCdgoAreTerr(Integer cdgoAreTerr) {
		this.cdgoAreTerr = cdgoAreTerr;
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

	public Date getFchaConjunta() {
		return fchaConjunta;
	}

	public void setFchaConjunta(Date fchaConjunta) {
		this.fchaConjunta = fchaConjunta;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
}

