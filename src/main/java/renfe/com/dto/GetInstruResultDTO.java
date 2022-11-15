package renfe.com.dto;

import java.sql.Date;

public class GetInstruResultDTO {

	private String cdgoNif;
	private String nombre;
	private String apell1;
	private String apell2;
	private String usuAct;
	private Date fchaAct;
	private boolean activo;
	private Object examinador;

	public String getCdgoNif() {
		return cdgoNif;
	}

	public void setCdgoNif(String cdgoNif) {
		this.cdgoNif = cdgoNif;
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

	public String getUsuAct() {
		return usuAct;
	}

	public void setUsuAct(String usuAct) {
		this.usuAct = usuAct;
	}

	public Date getFchaAct() {
		return fchaAct;
	}

	public void setFchaAct(Date fchaAct) {
		this.fchaAct = fchaAct;
	}

	public boolean getActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public Object getExaminador() {
		return examinador;
	}

	public void setExaminador(Object examinador) {
		this.examinador = examinador;
	}

}
