package renfe.com.dto;

import java.sql.Date;

public class GetSubSerieListAscCdgoSerieDTO {

	private String cdgoSerie;
	private String cdgoSubserie;
	private String desgUsuact;
	private Date fchaAct;
	private String mrcaActivo;
	private String desgNombreSerie;
	
	public String getCdgoSerie() {
		return cdgoSerie;
	}
	public void setCdgoSerie(String cdgoSerie) {
		this.cdgoSerie = cdgoSerie;
	}
	public String getCdgoSubserie() {
		return cdgoSubserie;
	}
	public void setCdgoSubserie(String cdgoSubserie) {
		this.cdgoSubserie = cdgoSubserie;
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
	public String getDesgNombreSerie() {
		return desgNombreSerie;
	}
	public void setDesgNombreSerie(String desgNombreSerie) {
		this.desgNombreSerie = desgNombreSerie;
	}
	
}
