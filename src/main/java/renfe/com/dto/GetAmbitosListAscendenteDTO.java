package renfe.com.dto;

import java.sql.Date;

public class GetAmbitosListAscendenteDTO {

	private Integer cdgoAmbitos;
	private String cdgoGerencia;
	private Integer cdgoProvincia;
	private Integer cdgoTipodep;
	private Integer cdgoTipohab;
	private String desgNombre;
	private String desgUsuact;
	private Date fchaAct;
	private String mrcaActivo;
	private String provincia;
	private String tipDeb;
	private String tipHab;
	
	public Integer getCdgoAmbitos() {
		return cdgoAmbitos;
	}
	public void setCdgoAmbitos(Integer cdgoAmbitos) {
		this.cdgoAmbitos = cdgoAmbitos;
	}
	public String getCdgoGerencia() {
		return cdgoGerencia;
	}
	public void setCdgoGerencia(String cdgoGerencia) {
		this.cdgoGerencia = cdgoGerencia;
	}
	public Integer getCdgoProvincia() {
		return cdgoProvincia;
	}
	public void setCdgoProvincia(Integer cdgoProvincia) {
		this.cdgoProvincia = cdgoProvincia;
	}
	public Integer getCdgoTipodep() {
		return cdgoTipodep;
	}
	public void setCdgoTipodep(Integer cdgoTipodep) {
		this.cdgoTipodep = cdgoTipodep;
	}
	public Integer getCdgoTipohab() {
		return cdgoTipohab;
	}
	public void setCdgoTipohab(Integer cdgoTipohab) {
		this.cdgoTipohab = cdgoTipohab;
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
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getTipDeb() {
		return tipDeb;
	}
	public void setTipDeb(String tipDeb) {
		this.tipDeb = tipDeb;
	}
	public String getTipHab() {
		return tipHab;
	}
	public void setTipHab(String tipHab) {
		this.tipHab = tipHab;
	}
}
