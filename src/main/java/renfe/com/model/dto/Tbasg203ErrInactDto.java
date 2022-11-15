package renfe.com.model.dto;

import java.sql.Date;

public class Tbasg203ErrInactDto {

	private Integer cdgoError;
	private String desgError;
	private String desgFichero;
	private String desgMatricula;
	private String desgMedidabaja;
	private Date fchaBaja;
	private Date fchaError;
	private String mrcaReprocesado;

	public Integer getCdgoError() {
		return this.cdgoError;
	}

	public void setCdgoError(Integer cdgoError) {
		this.cdgoError = cdgoError;
	}

	public String getDesgError() {
		return this.desgError;
	}

	public void setDesgError(String desgError) {
		this.desgError = desgError;
	}

	public String getDesgFichero() {
		return this.desgFichero;
	}

	public void setDesgFichero(String desgFichero) {
		this.desgFichero = desgFichero;
	}

	public String getDesgMatricula() {
		return this.desgMatricula;
	}

	public void setDesgMatricula(String desgMatricula) {
		this.desgMatricula = desgMatricula;
	}

	public String getDesgMedidabaja() {
		return this.desgMedidabaja;
	}

	public void setDesgMedidabaja(String desgMedidabaja) {
		this.desgMedidabaja = desgMedidabaja;
	}

	public Date getFchaBaja() {
		return this.fchaBaja;
	}

	public void setFchaBaja(Date fchaBaja) {
		this.fchaBaja = fchaBaja;
	}

	public Date getFchaError() {
		return this.fchaError;
	}

	public void setFchaError(Date fchaError) {
		this.fchaError = fchaError;
	}

	public String getMrcaReprocesado() {
		return this.mrcaReprocesado;
	}

	public void setMrcaReprocesado(String mrcaReprocesado) {
		this.mrcaReprocesado = mrcaReprocesado;
	}

}