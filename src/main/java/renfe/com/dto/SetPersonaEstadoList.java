package renfe.com.dto;

import java.util.List;

public class SetPersonaEstadoList {
	
	private List<String> cdgoTipoHab;
	private List<Integer> cdgoAreAct;
	private Integer cdgoAreTerr;
	private String cdgoCentCont;
	private String dni;
	private String desgMatricula;
	private String nombre;
	private String desgApell1;
	private String desgApell2;
	private String personal;
	private String empresa;
	private String columnOrden;
	private String cdgoOrden;
	private boolean noSemaforosRojos;
	private Integer tiempoLimiteRojo;
	private Integer mesDeControl;
	
	public List<String> getCdgoTipoHab() {
		
		return cdgoTipoHab;
	}
	public void setCdgoTipoHab(List<String> cdgoTipoHab) {
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
	public String getCdgoCentCont() {
		return cdgoCentCont;
	}
	public void setCdgoCentCont(String cdgoCentCont) {
		this.cdgoCentCont = cdgoCentCont;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
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
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	public String getColumnOrden() {
		return columnOrden;
	}
	public void setColumnOrden(String columnOrden) {
		this.columnOrden = columnOrden;
	}
	public String getCdgoOrden() {
		return cdgoOrden;
	}
	public void setCdgoOrden(String cdgoOrden) {
		this.cdgoOrden = cdgoOrden;
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

