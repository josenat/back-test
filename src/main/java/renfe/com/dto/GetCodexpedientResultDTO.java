package renfe.com.dto;

public class GetCodexpedientResultDTO {

	private Integer cdgoExpediente;
	private String tipoInfraestruc;
	private String cdgoLinea;

	public Integer getCdgoExpediente() {
		return cdgoExpediente;
	}

	public void setCdgoExpediente(Integer cdgoExpediente) {
		this.cdgoExpediente = cdgoExpediente;
	}

	public String getTipoInfraestruc() {
		return tipoInfraestruc;
	}

	public void setTipoInfraestruc(String tipoInfraestruc) {
		this.tipoInfraestruc = tipoInfraestruc;
	}

	public String getCdgoLinea() {
		return cdgoLinea;
	}

	public void setCdgoLinea(String cdgoLinea) {
		this.cdgoLinea = cdgoLinea;
	}

}
