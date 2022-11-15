package renfe.com.dto;

public class GetMaxEntornosExpListCodigosDTO {
	
	private Integer cdgoExpedient;
	private String  cdgoLinea;
	private String  desgNombreLinea;
	private String  cdgoEstacionOrigen;
	private String  desgNomCortoOrigen;
	private String  cdgoEstacionDestino;
	private String  desgNomCortoDestino;
	private Integer cdgoEstado;
	private String desgNombreEstado;
	
	public Integer getCdgoExpedient() {
		return cdgoExpedient;
	}
	public void setCdgoExpedient(Integer cdgoExpedient) {
		this.cdgoExpedient = cdgoExpedient;
	}
	public String getCdgoLinea() {
		return cdgoLinea;
	}
	public void setCdgoLinea(String cdgoLinea) {
		this.cdgoLinea = cdgoLinea;
	}
	public String getDesgNombreLinea() {
		return desgNombreLinea;
	}
	public void setDesgNombreLinea(String desgNombreLinea) {
		this.desgNombreLinea = desgNombreLinea;
	}
	public String getCdgoEstacionOrigen() {
		return cdgoEstacionOrigen;
	}
	public void setCdgoEstacionOrigen(String cdgoEstacionOrigen) {
		this.cdgoEstacionOrigen = cdgoEstacionOrigen;
	}
	public String getDesgNomCortoOrigen() {
		return desgNomCortoOrigen;
	}
	public void setDesgNomCortoOrigen(String desgNomCortoOrigen) {
		this.desgNomCortoOrigen = desgNomCortoOrigen;
	}
	public String getCdgoEstacionDestino() {
		return cdgoEstacionDestino;
	}
	public void setCdgoEstacionDestino(String cdgoEstacionDestino) {
		this.cdgoEstacionDestino = cdgoEstacionDestino;
	}
	public String getDesgNomCortoDestino() {
		return desgNomCortoDestino;
	}
	public void setDesgNomCortoDestino(String desgNomCortoDestino) {
		this.desgNomCortoDestino = desgNomCortoDestino;
	}
	public Integer getCdgoEstado() {
		return cdgoEstado;
	}
	public void setCdgoEstado(Integer cdgoEstado) {
		this.cdgoEstado = cdgoEstado;
	}
	public String getDesgNombreEstado() {
		return desgNombreEstado;
	}
	public void setDesgNombreEstado(String desgNombreEstado) {
		this.desgNombreEstado = desgNombreEstado;
	}

}
