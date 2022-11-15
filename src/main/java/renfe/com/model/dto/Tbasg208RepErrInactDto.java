package renfe.com.model.dto;

import java.sql.Date;

public class Tbasg208RepErrInactDto {

	private Integer cdgoError;
	private Integer cdgoReprocesado;
	private String desgMatricula;
	private String desgMedidabaja;
	private String desgUsuact;
	private Date fchaAct;
	private Date fchaBaja;

	public Integer getCdgoError() {
		return this.cdgoError;
	}

	public void setCdgoError(Integer cdgoError) {
		this.cdgoError = cdgoError;
	}

	public Integer getCdgoReprocesado() {
		return this.cdgoReprocesado;
	}

	public void setCdgoReprocesado(Integer cdgoReprocesado) {
		this.cdgoReprocesado = cdgoReprocesado;
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

	public String getDesgUsuact() {
		return this.desgUsuact;
	}

	public void setDesgUsuact(String desgUsuact) {
		this.desgUsuact = desgUsuact;
	}

	public Date getFchaAct() {
		return this.fchaAct;
	}

	public void setFchaAct(Date fchaAct) {
		this.fchaAct = fchaAct;
	}

	public Date getFchaBaja() {
		return this.fchaBaja;
	}

	public void setFchaBaja(Date fchaBaja) {
		this.fchaBaja = fchaBaja;
	}

}