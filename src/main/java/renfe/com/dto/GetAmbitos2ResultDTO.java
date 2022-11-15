package renfe.com.dto;

import java.sql.Date;

public class GetAmbitos2ResultDTO {

	private int cdgoAmbitos;
	private int cdgoTipohab;
	private String nombre;
	private String cdgoGerencia;
	private int cdgoProvincia;
	private int cdgoTipoDep;
	private String usuAct;
	private Date fchaAct;
	private boolean activo;

	public int getCdgoAmbitos() {
		return cdgoAmbitos;
	}

	public void setCdgoAmbitos(int cdgoAmbitos) {
		this.cdgoAmbitos = cdgoAmbitos;
	}

	public int getCdgoTipohab() {
		return cdgoTipohab;
	}

	public void setCdgoTipohab(int cdgoTipohab) {
		this.cdgoTipohab = cdgoTipohab;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCdgoGerencia() {
		return cdgoGerencia;
	}

	public void setCdgoGerencia(String cdgoGerencia) {
		this.cdgoGerencia = cdgoGerencia;
	}

	public int getCdgoProvincia() {
		return cdgoProvincia;
	}

	public void setCdgoProvincia(int cdgoProvincia) {
		this.cdgoProvincia = cdgoProvincia;
	}

	public int getCdgoTipoDep() {
		return cdgoTipoDep;
	}

	public void setCdgoTipoDep(int cdgoTipoDep) {
		this.cdgoTipoDep = cdgoTipoDep;
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
