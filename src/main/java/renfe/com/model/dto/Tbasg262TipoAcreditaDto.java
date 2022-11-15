package renfe.com.model.dto;

import java.sql.Date;

public class Tbasg262TipoAcreditaDto {

	private String cdgoTipoacr;
	private String desgAcredita;
	private String desgGrupo;
	private String desgUsuact;
	private Date fchaAct;
	private String mrcaActivo;
	private Integer validezReciclaje;

	public String getCdgoTipoacr() {
		return this.cdgoTipoacr;
	}

	public void setCdgoTipoacr(String cdgoTipoacr) {
		this.cdgoTipoacr = cdgoTipoacr;
	}

	public String getDesgAcredita() {
		return this.desgAcredita;
	}

	public void setDesgAcredita(String desgAcredita) {
		this.desgAcredita = desgAcredita;
	}

	public String getDesgGrupo() {
		return this.desgGrupo;
	}

	public void setDesgGrupo(String desgGrupo) {
		this.desgGrupo = desgGrupo;
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

	public Integer getValidezReciclaje() {
		return validezReciclaje;
	}

	public void setValidezReciclaje(Integer validezReciclaje) {
		this.validezReciclaje = validezReciclaje;
	}
	
}