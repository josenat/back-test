package renfe.com.model.dto;

import java.sql.Date;

public class Tbasg200ErrFichDto {


	private Long cdgoError;
	private String desgProceso;
	private String desgFichero;
	private Date fchaError;
	private Integer cdgoLinea;
	private String desgError;
	private String desgValor;
	
	public Long getCdgoError() {
		return cdgoError;
	}
	public void setCdgoError(Long cdgoError) {
		this.cdgoError = cdgoError;
	}
	public String getDesgProceso() {
		return desgProceso;
	}
	public void setDesgProceso(String desgProceso) {
		this.desgProceso = desgProceso;
	}
	public String getDesgFichero() {
		return desgFichero;
	}
	public void setDesgFichero(String desgFichero) {
		this.desgFichero = desgFichero;
	}
	public Date getFchaError() {
		return fchaError;
	}
	public void setFchaError(Date fchaError) {
		this.fchaError = fchaError;
	}
	public Integer getCdgoLinea() {
		return cdgoLinea;
	}
	public void setCdgoLinea(Integer cdgoLinea) {
		this.cdgoLinea = cdgoLinea;
	}
	public String getDesgError() {
		return desgError;
	}
	public void setDesgError(String desgError) {
		this.desgError = desgError;
	}
	public String getDesgValor() {
		return desgValor;
	}
	public void setDesgValor(String desgValor) {
		this.desgValor = desgValor;
	}
	
	
}
