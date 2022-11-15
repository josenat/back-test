package renfe.com.dto;

import java.sql.Date;

public class GetDatosAcreditacionesDTO {
	
	private Integer cdgoAcredita;
	private String desgAcredita;
	private String desgPuerto;
	private String desgLinea;
	private String desgNomlargo;
	private String desgNombre;
	private Date fchaAct;
	private String cdgoEstacion;
	private String desgEstado;
	private String desgDesccurso;
	private Date fchaCurso;
	private Date fchaEstadoAcre;
	private String mrcaActivo;
	private String desgObserva;
	private Integer cdgoEmpresa;
	private Date fchaCaduc;
	private Date fchaCaducPsico;
	private String calificacion;
	
	public Integer getCdgoAcredita() {
		return cdgoAcredita;
	}
	public void setCdgoAcredita(Integer object) {
		this.cdgoAcredita = object;
	}
	public String getDesgAcredita() {
		return desgAcredita;
	}
	public void setDesgAcredita(String desgAcredita) {
		this.desgAcredita = desgAcredita;
	}
	public String getDesgPuerto() {
		return desgPuerto;
	}
	public void setDesgPuerto(String desgPuerto) {
		this.desgPuerto = desgPuerto;
	}
	public String getDesgLinea() {
		return desgLinea;
	}
	public void setDesgLinea(String desgLinea) {
		this.desgLinea = desgLinea;
	}
	public String getDesgNomlargo() {
		return desgNomlargo;
	}
	public void setDesgNomlargo(String desgNomlargo) {
		this.desgNomlargo = desgNomlargo;
	}
	public String getDesgNombre() {
		return desgNombre;
	}
	public void setDesgNombre(String desgNombre) {
		this.desgNombre = desgNombre;
	}
	public Date getFchaAct() {
		return fchaAct;
	}
	public void setFchaAct(Date fchaAct) {
		this.fchaAct = fchaAct;
	}
	public String getCdgoEstacion() {
		return cdgoEstacion;
	}
	public void setCdgoEstacion(String cdgoEstacion) {
		this.cdgoEstacion = cdgoEstacion;
	}
	public String getDesgEstado() {
		return desgEstado;
	}
	public void setDesgEstado(String desgEstado) {
		this.desgEstado = desgEstado;
	}
	public String getDesgDesccurso() {
		return desgDesccurso;
	}
	public void setDesgDesccurso(String desgDesccurso) {
		this.desgDesccurso = desgDesccurso;
	}
	public Date getFchaCurso() {
		return fchaCurso;
	}
	public void setFchaCurso(Date fchaCurso) {
		this.fchaCurso = fchaCurso;
	}
	public Date getFchaEstadoAcre() {
		return fchaEstadoAcre;
	}
	public void setFchaEstadoAcre(Date fchaEstadoAcre) {
		this.fchaEstadoAcre = fchaEstadoAcre;
	}	
	public String getMrcaActivo() {
		return mrcaActivo;
	}
	public void setMrcaActivo(String mrcaActivo) {
		this.mrcaActivo = mrcaActivo;
	}	
	public String getDesgObserva() {
		return desgObserva;
	}
	public void setDesgObserva(String desgObserva) {
		this.desgObserva = desgObserva;
	}
	public Integer getCdgoEmpresa() {
		return cdgoEmpresa;
	}
	public void setCdgoEmpresa(Integer cdgoEmpresa) {
		this.cdgoEmpresa = cdgoEmpresa;
	}
	public Date getFchaCaduc() {
		return fchaCaduc;
	}
	public void setFchaCaduc(Date fchaCaduc) {
		this.fchaCaduc = fchaCaduc;
	}
	
	public Date getFchaCaducPsico() {
		return fchaCaducPsico;
	}
	
	public void setFchaCaducPsico(Date fchaCaducPsico) {
		this.fchaCaducPsico = fchaCaducPsico;
	}
	
	public String getCalificacion() {
		return calificacion;
	}
	
	public void setCalificacion(String calificacion) {
		this.calificacion = calificacion;
	}	
	
}
