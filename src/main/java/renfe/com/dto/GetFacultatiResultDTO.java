package renfe.com.dto;

import java.sql.Date;

public class GetFacultatiResultDTO {

	private int cdgoFacult;
	private String numColegiado;
	private String nombre;
	private String apell1;
	private String apell2;
	private Integer cdgoCenMed;
	private String usuAct;
	private Date fchaAct;
	private boolean activo;

	public int getCdgoFacult() {
		return cdgoFacult;
	}

	public void setCdgoFacult(int cdgoFacult) {
		this.cdgoFacult = cdgoFacult;
	}

	public String getNumColegiado() {
		return numColegiado;
	}

	public void setNumColegiado(String numColegiado) {
		this.numColegiado = numColegiado;
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

	public Integer getCdgoCenMed() {
		return cdgoCenMed;
	}

	public void setCdgoCenMed(Integer cdgoCenMed) {
		this.cdgoCenMed = cdgoCenMed;
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

}
