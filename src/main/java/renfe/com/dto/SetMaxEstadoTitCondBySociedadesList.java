package renfe.com.dto;

import java.util.List;

import javax.persistence.Column;

public class SetMaxEstadoTitCondBySociedadesList {
	
	private List<Integer> cdgoAreAct;	
	private List<Integer> cdgoAreTerr;
	private String cdgoCentroCont;
	private List<Integer> listAreTer;
	private List<Integer> listAreAct;
	private String dni;
	private String matricula;
	private String nombre;
	private String apell1;
	private String apell2;
	private List<String> estadoTitulos;
	private boolean noAptos;
	private String personal;
	private String columnOrden;
	private String cdgoOrden;
	private boolean noSemaforosRojos;
	private Integer tiempoLimiteRojo;
	private Integer mesDeControl;
	private String tipoListado;
	
	public List<Integer> getCdgoAreAct() {
		return cdgoAreAct;
	}
	public void setCdgoAreAct(List<Integer> cdgoAreAct) {
		this.cdgoAreAct = cdgoAreAct;
	}
	public List<Integer> getCdgoAreTerr() {
		return cdgoAreTerr;
	}
	public void setCdgoAreTerr(List<Integer> cdgoAreTerr) {
		this.cdgoAreTerr = cdgoAreTerr;
	}
	public String getCdgoCentroCont() {
		return cdgoCentroCont;
	}
	public void setCdgoCentroCont(String cdgoCentroCont) {
		this.cdgoCentroCont = cdgoCentroCont;
	}
	public List<Integer> getListAreTer() {
		return listAreTer;
	}
	public void setListAreTer(List<Integer> listAreTer) {
		this.listAreTer = listAreTer;
	}
	public List<Integer> getListAreAct() {
		return listAreAct;
	}
	public void setListAreAct(List<Integer> listAreAct) {
		this.listAreAct = listAreAct;
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
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	public List<String> getEstadoTitulos() {
		return estadoTitulos;
	}
	public void setEstadoTitulos(List<String> estadoTitulos) {
		this.estadoTitulos = estadoTitulos;
	}
	public boolean isNoAptos() {
		return noAptos;
	}
	public void setNoAptos(boolean noAptos) {
		this.noAptos = noAptos;
	}
	public String getPersonal() {
		return personal;
	}
	public void setPersonal(String personal) {
		this.personal = personal;
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
	public String getTipoListado() {
		return tipoListado;
	}
	public void setTipoListado(String tipoListado) {
		this.tipoListado = tipoListado;
	}
	
	
}

