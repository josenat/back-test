package renfe.com.dto;

import java.sql.Timestamp;
import java.sql.Date;

public class GetOpertarjetaResultDTO {

	private String cdgoNumSerie;
	private Timestamp fchaOperacion;
	private String cdgoOperacion;
	private String desgUsuario;
	private String usuAct;
	private Date fchaAct;
	private boolean activo;

	public String getCdgoNumSerie() {
		return cdgoNumSerie;
	}

	public void setCdgoNumSerie(String cdgoNumSerie) {
		this.cdgoNumSerie = cdgoNumSerie;
	}

	public Timestamp getFchaOperacion() {
		return fchaOperacion;
	}

	public void setFchaOperacion(Timestamp fchaOperacion) {
		this.fchaOperacion = fchaOperacion;
	}

	public String getCdgoOperacion() {
		return cdgoOperacion;
	}

	public void setCdgoOperacion(String cdgoOperacion) {
		this.cdgoOperacion = cdgoOperacion;
	}

	public String getDesgUsuario() {
		return desgUsuario;
	}

	public void setDesgUsuario(String desgUsuario) {
		this.desgUsuario = desgUsuario;
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
