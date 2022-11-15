package renfe.com.model.dto;

import java.sql.Date;

public class Tbasg187LotesFnmtDto {

	private Integer cdgoFin;
	private Integer cdgoInicio;
	private Integer cdgoLote;
	private String desgNombrefich;
	private Date fchaLote;
	private String mrcaErrores;
	private String mrcaGenerado;

	public Integer getCdgoFin() {
		return this.cdgoFin;
	}

	public void setCdgoFin(Integer cdgoFin) {
		this.cdgoFin = cdgoFin;
	}

	public Integer getCdgoInicio() {
		return this.cdgoInicio;
	}

	public void setCdgoInicio(Integer cdgoInicio) {
		this.cdgoInicio = cdgoInicio;
	}

	public Integer getCdgoLote() {
		return this.cdgoLote;
	}

	public void setCdgoLote(Integer cdgoLote) {
		this.cdgoLote = cdgoLote;
	}

	public String getDesgNombrefich() {
		return this.desgNombrefich;
	}

	public void setDesgNombrefich(String desgNombrefich) {
		this.desgNombrefich = desgNombrefich;
	}

	public Date getFchaLote() {
		return this.fchaLote;
	}

	public void setFchaLote(Date fchaLote) {
		this.fchaLote = fchaLote;
	}

	public String getMrcaErrores() {
		return this.mrcaErrores;
	}

	public void setMrcaErrores(String mrcaErrores) {
		this.mrcaErrores = mrcaErrores;
	}

	public String getMrcaGenerado() {
		return this.mrcaGenerado;
	}

	public void setMrcaGenerado(String mrcaGenerado) {
		this.mrcaGenerado = mrcaGenerado;
	}

}