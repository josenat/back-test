package renfe.com.dto;

import java.sql.Date;

import javax.persistence.Column;

public class GetEntorLineListAscendenteCDGO_ENTORNODTO {
	
	@Column(name="CDGO_ENTORNO")
	private Integer cdgoEntorno;
	
	@Column(name="CDGO_LINEA")
	private String cdgoLinea;
	
	@Column(name="CDGO_ORIGEN")
	private String cdgoOrigen;
	
	@Column(name="CDGO_DESTINO")
	private String cdgoDestino;
	
	@Column(name = "DESG_USUACT")
	private String desgUsuact;

	@Column(name = "FCHA_ACT")
	private Date fchaAct;

	@Column(name = "MRCA_ACTIVO")
	private char mrcaActivo;
	
	@Column(name="LINEA")
	private String linea;
	
	@Column(name="ORIGEN")
	private String origen;
	
	@Column(name="ENTORNO")
	private String entorno;
	
	@Column(name="DESTINO")
	private String destino;

	public Integer getCdgoEntorno() {
		return cdgoEntorno;
	}

	public void setCdgoEntorno(Integer cdgoEntorno) {
		this.cdgoEntorno = cdgoEntorno;
	}

	public String getCdgoLinea() {
		return cdgoLinea;
	}

	public void setCdgoLinea(String cdgoLinea) {
		this.cdgoLinea = cdgoLinea;
	}

	public String getCdgoOrigen() {
		return cdgoOrigen;
	}

	public void setCdgoOrigen(String cdgoOrigen) {
		this.cdgoOrigen = cdgoOrigen;
	}

	public String getCdgoDestino() {
		return cdgoDestino;
	}

	public void setCdgoDestino(String cdgoDestino) {
		this.cdgoDestino = cdgoDestino;
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

	public char getMrcaActivo() {
		return mrcaActivo;
	}

	public void setMrcaActivo(char mrcaActivo) {
		this.mrcaActivo = mrcaActivo;
	}

	public String getLinea() {
		return linea;
	}

	public void setLinea(String linea) {
		this.linea = linea;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getEntorno() {
		return entorno;
	}

	public void setEntorno(String entorno) {
		this.entorno = entorno;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}
}
