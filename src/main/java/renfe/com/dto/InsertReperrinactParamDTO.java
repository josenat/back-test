package renfe.com.dto;

import java.sql.Date;

public class InsertReperrinactParamDTO {

	private Integer cdgoError;
	private String matricula;
	private String medidaBaja;
	private Date fchaBaja;
	private String usuAct;

	public Integer getCdgoError() {
		return cdgoError;
	}

	public void setCdgoError(Integer cdgoError) {
		this.cdgoError = cdgoError;
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

	public String getUsuAct() {
		return usuAct;
	}

	public void setUsuAct(String usuAct) {
		this.usuAct = usuAct;
	}

}
