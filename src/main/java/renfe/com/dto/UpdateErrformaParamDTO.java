package renfe.com.dto;

public class UpdateErrformaParamDTO {

	private boolean reprocesado;
	private Integer cdgoError;

	public boolean getReprocesado() {
		return reprocesado;
	}

	public void setReprocesado(boolean reprocesado) {
		this.reprocesado = reprocesado;
	}

	public Integer getCdgoError() {
		return cdgoError;
	}

	public void setCdgoError(Integer cdgoError) {
		this.cdgoError = cdgoError;
	}

}
