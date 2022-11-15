package renfe.com.dto;

import java.util.List;

public class SetPersonaCertificadosIdiomasList {
	
	private Integer cdgoCategoría;
	private Integer cdgoCualificacion;
	private List<Integer> cdgoTipoHab;
	private List<Integer> cdgoAreAct;
	private Integer cdgoAreTerr;
	private Integer cdgoSociedad;
	private String cdgoCentCont;
	private String desgDni;
	private String desgMatricula;
	private String nombre;
	private String desgApell1;
	private String desgApell2;
	private String personal;
	private String empresa;
	private boolean noSemaforosRojos;
	private Integer tiempoLimiteRojo;
	private Integer mesDeControl;
	
	public Integer getCdgoCategoría() {
		return cdgoCategoría;
	}
	public void setCdgoCategoría(Integer cdgoCategoría) {
		this.cdgoCategoría = cdgoCategoría;
	}
	public Integer getCdgoCualificacion() {
		return cdgoCualificacion;
	}
	public void setCdgoCualificacion(Integer cdgoCualificacion) {
		this.cdgoCualificacion = cdgoCualificacion;
	}
	public List<Integer> getCdgoTipoHab() {
		return cdgoTipoHab;
	}
	public void setCdgoTipoHab(List<Integer> cdgoTipoHab) {
		this.cdgoTipoHab = cdgoTipoHab;
	}
	public List<Integer> getCdgoAreAct() {
		return cdgoAreAct;
	}
	public void setCdgoAreAct(List<Integer> cdgoAreAct) {
		this.cdgoAreAct = cdgoAreAct;
	}
	public Integer getCdgoAreTerr() {
		return cdgoAreTerr;
	}
	public void setCdgoAreTerr(Integer cdgoAreTerr) {
		this.cdgoAreTerr = cdgoAreTerr;
	}
	public Integer getCdgoSociedad() {
		return cdgoSociedad;
	}
	public void setCdgoSociedad(Integer cdgoSociedad) {
		this.cdgoSociedad = cdgoSociedad;
	}
	public String getCdgoCentCont() {
		return cdgoCentCont;
	}
	public void setCdgoCentCont(String cdgoCentCont) {
		this.cdgoCentCont = cdgoCentCont;
	}
	public String getDesgDni() {
		return desgDni;
	}
	public void setDesgDni(String desgDni) {
		this.desgDni = desgDni;
	}
	public String getDesgMatricula() {
		return desgMatricula;
	}
	public void setDesgMatricula(String desgMatricula) {
		this.desgMatricula = desgMatricula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String desgNombre) {
		this.nombre = desgNombre;
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
	public String getPersonal() {
		return personal;
	}
	public void setPersonal(String personal) {
		this.personal = personal;
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public boolean isNoSemaforosRojos() {
		return noSemaforosRojos;
	}
	public void setNoSemaforosRojos(boolean noSemaforosRojos) {
		this.noSemaforosRojos = noSemaforosRojos;
	}
	public Integer getTiempoLimiteRojo() {
		return tiempoLimiteRojo;
	}
	public void setTiempoLimiteRojo(Integer tiempoLimiteRojo) {
		this.tiempoLimiteRojo = tiempoLimiteRojo;
	}
	public Integer getMesDeControl() {
		return mesDeControl;
	}
	public void setMesDeControl(Integer mesDeControl) {
		this.mesDeControl = mesDeControl;
	}
	
}

