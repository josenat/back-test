package renfe.com.model.dto;

import java.sql.Date;

public class Tbasg124AmbitosDto {

	private Integer cdgoAmbitos;
	private String cdgoGerencia;
	private Integer cdgoProvincia;
	private Integer cdgoTipodep;
	private Integer cdgoTipohab;
	private String desgNombre;
	private String desgUsuact;
	private Date fchaAct;
	private String mrcaActivo;

	public Integer getCdgoAmbitos() {
		return this.cdgoAmbitos;
	}

	public void setCdgoAmbitos(Integer cdgoAmbitos) {
		this.cdgoAmbitos = cdgoAmbitos;
	}

	public String getCdgoGerencia() {
		return this.cdgoGerencia;
	}

	public void setCdgoGerencia(String cdgoGerencia) {
		this.cdgoGerencia = cdgoGerencia;
	}

	public Integer getCdgoProvincia() {
		return this.cdgoProvincia;
	}

	public void setCdgoProvincia(Integer cdgoProvincia) {
		this.cdgoProvincia = cdgoProvincia;
	}

	public Integer getCdgoTipodep() {
		return this.cdgoTipodep;
	}

	public void setCdgoTipodep(Integer cdgoTipodep) {
		this.cdgoTipodep = cdgoTipodep;
	}

	public Integer getCdgoTipohab() {
		return this.cdgoTipohab;
	}

	public void setCdgoTipohab(Integer cdgoTipohab) {
		this.cdgoTipohab = cdgoTipohab;
	}

	public String getDesgNombre() {
		return this.desgNombre;
	}

	public void setDesgNombre(String desgNombre) {
		this.desgNombre = desgNombre;
	}

	public String getDesgUsuact() {
		return this.desgUsuact;
	}

	public void setDesgUsuact(String desgUsuact) {
		this.desgUsuact = desgUsuact;
	}

	public Date getFchaAct() {
		return this.fchaAct;
	}

	public void setFchaAct(Date fchaAct) {
		this.fchaAct = fchaAct;
	}

	public String getMrcaActivo() {
		return this.mrcaActivo;
	}

	public void setMrcaActivo(String mrcaActivo) {
		this.mrcaActivo = mrcaActivo;
	}

}