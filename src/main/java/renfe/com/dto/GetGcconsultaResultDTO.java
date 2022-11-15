package renfe.com.dto;

import java.sql.Date;

public class GetGcconsultaResultDTO {

	private int cdgoConsulta;
	private String nombre;
	private String usuario;
	private boolean contar;
	private String expLogica;
	private String usuAct;
	private Date fchaAct;
	private boolean activo;

	public int getCdgoConsulta() {
		return cdgoConsulta;
	}

	public void setCdgoConsulta(int cdgoConsulta) {
		this.cdgoConsulta = cdgoConsulta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public boolean getContar() {
		return contar;
	}

	public void setContar(boolean contar) {
		this.contar = contar;
	}

	public String getExpLogica() {
		return expLogica;
	}

	public void setExpLogica(String expLogica) {
		this.expLogica = expLogica;
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
