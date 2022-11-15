package renfe.com.dto;

import java.util.List;

public class SetMaxEstadoHabilitaList {
	
	private List<Integer> cdgoAreAct;
	private Integer cdgoAreTerr;
	private String cdgoCentroCont;
	private String dni;
	private String matricula;
	private String nombre;
	private String apell1;
	private String apell2;
	private List<Integer> cdgoTipohab;
	private Integer sociedad;
	private String personal;
	private Integer empresa;
	private String columOrden;
	private String cdgoOrden;
	private boolean noSemaforosRojos;
	private Integer tiempoLimiteRojo;
	private Integer mesDeControl;
	private String tipoListado;
	private List<Integer> cdgoExpedient;
	
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
	public String getCdgoCentroCont() {
		return cdgoCentroCont;
	}
	public void setCdgoCentroCont(String cdgoCentroCont) {
		this.cdgoCentroCont = cdgoCentroCont;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String desgNombre) {
		this.nombre = desgNombre;
	}
	public String getApell1() {
		return apell1;
	}
	public void setApell1(String apell1) {
		this.apell1 = apell1;
	}
	public String getApell2() {
		return apell2;
	}
	public void setApell2(String apell2) {
		this.apell2 = apell2;
	}
	public List<Integer> getCdgoTipohab() {
		return cdgoTipohab;
	}
	public void setCdgoTipohab(List<Integer> cdgoTipohab) {
		this.cdgoTipohab = cdgoTipohab;
	}
	public Integer getSociedad() {
		return sociedad;
	}
	public void setSociedad(Integer sociedad) {
		this.sociedad = sociedad;
	}
	public String getPersonal() {
		return personal;
	}
	public void setPersonal(String personal) {
		this.personal = personal;
	}
	public Integer getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Integer empresa) {
		this.empresa = empresa;
	}
	public String getColumOrden() {
		return columOrden;
	}
	public void setColumOrden(String columOrden) {
		this.columOrden = columOrden;
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
	public String getTipoListado() {
		return tipoListado;
	}
	public void setTipoListado(String tipoListado) {
		this.tipoListado = tipoListado;
	}
	public List<Integer> getCdgoExpedient() {
		return cdgoExpedient;
	}
	public void setCdgoExpedient(List<Integer> cdgoExpedient) {
		this.cdgoExpedient = cdgoExpedient;
	}
	
}

