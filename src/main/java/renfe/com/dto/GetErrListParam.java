package renfe.com.dto;

import java.sql.Date;

public class GetErrListParam {

	private String reprocesado;
	private String fchaDesdeError;
	private String fchaHastaError;
	
	private String desgProceso;
	
	public String getReprocesado() {
		return reprocesado;
	}
	public void setReprocesado(String reprocesado) {
		this.reprocesado = reprocesado;
	}
	public String getFchaDesdeError() {
		return fchaDesdeError;
	}
	public void setFchaDesdeError(String fchaDesdeError) {
		this.fchaDesdeError = fchaDesdeError;
	}
	public String getFchaHastaError() {
		return fchaHastaError;
	}
	public void setFchaHastaError(String fchaHastaError) {
		this.fchaHastaError = fchaHastaError;
	}
	public String getDesgProceso() {
		return desgProceso;
	}
	public void setDesgProceso(String desgProceso) {
		this.desgProceso = desgProceso;
	}
	
}
