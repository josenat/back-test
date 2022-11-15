package renfe.com.dto;

import java.sql.Date;

import javax.persistence.Column;

public class GetPersonaCertificadosIdiomasListDTO {
	
	@Column(name="DESG_NIFPAS")
	private String desgNifpas;
	
	@Column(name="DESG_PERSONA")
	private String desgPersona;
	
	@Column(name="DESG_APELL1")
	private String desgApell1;
	
	@Column(name="DESG_APELL2")
	private String desgApell2;
	
	@Column(name="CDGO_PERSONA")
	private Integer cdgoPersona;
	
	@Column(name="DESG_MATRICULA")
	private String desgMatricula;
	
	@Column(name="CDGO_AREACT")
	private Integer cdgoAreAct;
	
	@Column(name="CDGO_ARETER")
	private Integer cdgoAreTerr;
	
	@Column(name="CDGO_CENTROCONT")
	private String cdgoCentroCont;
	
	@Column(name="DESG_AREACT")
	private String desgAreAct;
	
	@Column(name="DESG_ARETER")
	private String desgAreTerr;
	
	@Column(name="DESG_CENTROCONT")
	private String desgCentroCont;
	
	@Column(name="DESG_EMPRESA")
	private String desgEmpresa;
	
	@Column(name="CDGO_CATEGORIA")
	private Integer cdgoCategoria;
	
	@Column(name="CDGO_CUALIFICACION")
	private Integer cdgoCualificacion;
	
	@Column(name="DESG_DESCRIPCION")
	private String desgDescripcion;
	
	@Column(name="DESG_NOMBRE")
	private String desgNombre;
	
	@Column(name="FCHA_EXPEDICION")
	private Date fchaExpedicion;
	
	@Column(name="COLOR")
	private String color;

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

	public String getDesgEmpresa() {
		return desgEmpresa;
	}

	public void setDesgEmpresa(String desgEmpresa) {
		this.desgEmpresa = desgEmpresa;
	}

	public Integer getCdgoCategoria() {
		return cdgoCategoria;
	}

	public void setCdgoCategoria(Integer cdgoCategoria) {
		this.cdgoCategoria = cdgoCategoria;
	}

	public Integer getCdgoCualificacion() {
		return cdgoCualificacion;
	}

	public void setCdgoCualificacion(Integer cdgoCualificacion) {
		this.cdgoCualificacion = cdgoCualificacion;
	}

	public String getDesgDescripcion() {
		return desgDescripcion;
	}

	public void setDesgDescripcion(String desgDescripcion) {
		this.desgDescripcion = desgDescripcion;
	}

	public String getDesgNombre() {
		return desgNombre;
	}

	public void setDesgNombre(String desgNombre) {
		this.desgNombre = desgNombre;
	}

	public Date getFchaExpedicion() {
		return fchaExpedicion;
	}

	public void setFchaExpedicion(Date fchaExpedicion) {
		this.fchaExpedicion = fchaExpedicion;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}

