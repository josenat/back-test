package renfe.com.dto;

import java.sql.Date;

public class GetErrinactResultDTO {

	private Integer cdgoError;
	private String error;
	private Date fchaError;
	private String fichero;
	private String matricula;
	private String medidaBaja;
	private Date fchaBaja;
	private boolean reprocesado;

	public Integer getCdgoError() {
		return cdgoError;
	}

	public void setCdgoError(Integer cdgoError) {
		this.cdgoError = cdgoError;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public Date getFchaError() {
		return fchaError;
	}

	public void setFchaError(Date fchaError) {
		this.fchaError = fchaError;
	}

	public String getFichero() {
		return fichero;
	}

	public void setFichero(String fichero) {
		this.fichero = fichero;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getMedidaBaja() {
		return medidaBaja;
	}

	public void setMedidaBaja(String medidaBaja) {
		this.medidaBaja = medidaBaja;
	}

	public Date getFchaBaja() {
		return fchaBaja;
	}

	public void setFchaBaja(Date fchaBaja) {
		this.fchaBaja = fchaBaja;
	}

	public boolean getReprocesado() {
		return reprocesado;
	}

	public void setReprocesado(boolean reprocesado) {
		this.reprocesado = reprocesado;
	}

}
