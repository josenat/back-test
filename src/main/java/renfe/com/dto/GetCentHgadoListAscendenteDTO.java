package renfe.com.dto;

import java.sql.Date;

public class GetCentHgadoListAscendenteDTO {

	private Integer cdgoCenthgado;
	private Integer cdgoNacion;
	private String desgCif;
	private String desgDomsocial;
	private String desgNombre;
	private String desgUsuact;
	private Date fchaAct;
	private String mrcaActivo;
	private String pais;
	
	public Integer getCdgoCenthgado() {
		return cdgoCenthgado;
	}
	public void setCdgoCenthgado(Integer cdgoCenthgado) {
		this.cdgoCenthgado = cdgoCenthgado;
	}
	public Integer getCdgoNacion() {
		return cdgoNacion;
	}
	public void setCdgoNacion(Integer cdgoNacion) {
		this.cdgoNacion = cdgoNacion;
	}
	public String getDesgCif() {
		return desgCif;
	}
	public void setDesgCif(String desgCif) {
		this.desgCif = desgCif;
	}
	public String getDesgDomsocial() {
		return desgDomsocial;
	}
	public void setDesgDomsocial(String desgDomsocial) {
		this.desgDomsocial = desgDomsocial;
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
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	
}
