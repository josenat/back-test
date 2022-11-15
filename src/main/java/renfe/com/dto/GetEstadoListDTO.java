package renfe.com.dto;

import javax.persistence.Column;

public class GetEstadoListDTO {
	
	@Column(name="CDGO_EXPEDIENT")
	private Integer cdgoExpedient;
	
	@Column(name="CDGO_ESTADO")
	private Integer cdgoEstado;
	
	@Column(name="DESG_NOMBRE")
	private String desgNombre;

	public Integer getCdgoExpedient() {
		return cdgoExpedient;
	}

	public void setCdgoExpedient(Integer cdgoExpedient) {
		this.cdgoExpedient = cdgoExpedient;
	}

	public Integer getCdgoEstado() {
		return cdgoEstado;
	}

	public void setCdgoEstado(Integer cdgoEstado) {
		this.cdgoEstado = cdgoEstado;
	}

	public String getDesgNombre() {
		return desgNombre;
	}

	public void setDesgNombre(String desgNombre) {
		this.desgNombre = desgNombre;
	}
	
}

