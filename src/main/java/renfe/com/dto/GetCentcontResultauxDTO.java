package renfe.com.dto;

import java.sql.Date;
import java.util.List;

public class GetCentcontResultauxDTO {

	private String cdgoCentCont;
	private int cdgoAreTer;
	private String nombre;
	private List<?> areTer;
	private String usuAct;
	private Date fchaAct;
	private boolean activo;
	private String buzonCorreo;

	public String getCdgoCentCont() {
		return cdgoCentCont;
	}

	public void setCdgoCentCont(String cdgoCentCont) {
		this.cdgoCentCont = cdgoCentCont;
	}

	public int getCdgoAreTer() {
		return cdgoAreTer;
	}

	public void setCdgoAreTer(int cdgoAreTer) {
		this.cdgoAreTer = cdgoAreTer;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<?> getAreTer() {
		return areTer;
	}

	public void setAreTer(List<?> areTer) {
		this.areTer = areTer;
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

	public String getBuzonCorreo() {
		return buzonCorreo;
	}

	public void setBuzonCorreo(String buzonCorreo) {
		this.buzonCorreo = buzonCorreo;
	}

}
