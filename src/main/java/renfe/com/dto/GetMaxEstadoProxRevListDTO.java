package renfe.com.dto;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;

public class GetMaxEstadoProxRevListDTO {
	
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
	
	@Column(name="MRCA_ACTIVO")
	private String mrcaActivo;
	
	@Column(name="FCHA_PROXREV")
	private Date fchaProxrev;
	
	@Column(name="CDGO_PSICAMB")
	private Integer cdgoPsicamb;
	
	@Column(name="DESG_NOMBRE")
	private String desgNombre;
	
	@Column(name="CDGO_AREACT")
	private Integer cdgoAreAct;
	
	@Column(name="CDGO_ARETER")
	private Integer cdgoAreTer;
	
	@Column(name="CDGO_CENTCONT")
	private String cdgoCentCont;
	
	@Column(name="DESG_AREACT")
	private String desgAreAct;
	
	@Column(name="DESG_ARETER")
	private String desgAreTer;
	
	@Column(name="DESG_CENTCONT")
	private String desgCentCont;
	
	@Column(name="DESG_EMPRESA")
	private String desgEmpresa;

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

	public String getMrcaActivo() {
		return mrcaActivo;
	}

	public void setMrcaActivo(String mrcaActivo) {
		this.mrcaActivo = mrcaActivo;
	}

	public Date getFchaProxrev() {
		return fchaProxrev;
	}

	public void setFchaProxrev(Date fchaProxrev) {
		this.fchaProxrev = fchaProxrev;
	}

	public Integer getCdgoPsicamb() {
		return cdgoPsicamb;
	}

	public void setCdgoPsicamb(Integer cdgoPsicamb) {
		this.cdgoPsicamb = cdgoPsicamb;
	}

	public String getDesgNombre() {
		return desgNombre;
	}

	public void setDesgNombre(String desgNombre) {
		this.desgNombre = desgNombre;
	}

	public Integer getCdgoAreAct() {
		return cdgoAreAct;
	}

	public void setCdgoAreAct(Integer cdgoAreAct) {
		this.cdgoAreAct = cdgoAreAct;
	}

	public Integer getCdgoAreTer() {
		return cdgoAreTer;
	}

	public void setCdgoAreTer(Integer cdgoAreTer) {
		this.cdgoAreTer = cdgoAreTer;
	}

	public String getCdgoCentCont() {
		return cdgoCentCont;
	}

	public void setCdgoCentCont(String cdgoCentCont) {
		this.cdgoCentCont = cdgoCentCont;
	}

	public String getDesgAreAct() {
		return desgAreAct;
	}

	public void setDesgAreAct(String desgAreAct) {
		this.desgAreAct = desgAreAct;
	}

	public String getDesgAreTer() {
		return desgAreTer;
	}

	public void setDesgAreTer(String desgAreTer) {
		this.desgAreTer = desgAreTer;
	}

	public String getDesgCentCont() {
		return desgCentCont;
	}

	public void setDesgCentCont(String desgCentCont) {
		this.desgCentCont = desgCentCont;
	}

	public String getDesgEmpresa() {
		return desgEmpresa;
	}

	public void setDesgEmpresa(String desgEmpresa) {
		this.desgEmpresa = desgEmpresa;
	}
	
	

}
