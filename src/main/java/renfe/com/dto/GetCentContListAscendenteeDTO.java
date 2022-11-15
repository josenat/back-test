package renfe.com.dto;

import java.sql.Date;

public class GetCentContListAscendenteeDTO {

	private Integer cdgoAreter;
	private String cdgoCentcont;
	private String desgBuzoncorreo;
	private String desgNombre;
	private String desgUsuact;
	private Date fchaAct;
	private String mrcaActivo;
	private String AreaTerritorial;
	
	public Integer getCdgoAreter() {
		return cdgoAreter;
	}
	public void setCdgoAreter(Integer cdgoAreter) {
		this.cdgoAreter = cdgoAreter;
	}
	public String getCdgoCentcont() {
		return cdgoCentcont;
	}
	public void setCdgoCentcont(String cdgoCentcont) {
		this.cdgoCentcont = cdgoCentcont;
	}
	public String getDesgBuzoncorreo() {
		return desgBuzoncorreo;
	}
	public void setDesgBuzoncorreo(String desgBuzoncorreo) {
		this.desgBuzoncorreo = desgBuzoncorreo;
	}
	public String getDesgNombre() {
		return desgNombre;
	}
	public void setDesgNombre(String desgNombre) {
		this.desgNombre = desgNombre;
	}
	public String getDesgUsuact() {
		return desgUsuact;
	}
	public void setDesgUsuact(String desgUsuact) {
		this.desgUsuact = desgUsuact;
	}
	public Date getFchaAct() {
		return fchaAct;
	}
	public void setFchaAct(Date fchaAct) {
		this.fchaAct = fchaAct;
	}
	public String getMrcaActivo() {
		return mrcaActivo;
	}
	public void setMrcaActivo(String mrcaActivo) {
		this.mrcaActivo = mrcaActivo;
	}
	public String getAreaTerritorial() {
		return AreaTerritorial;
	}
	public void setAreaTerritorial(String areaTerritorial) {
		AreaTerritorial = areaTerritorial;
	}
	
}
