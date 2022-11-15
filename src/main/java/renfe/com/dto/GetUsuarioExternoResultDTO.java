package renfe.com.dto;

import java.sql.Date;

public class GetUsuarioExternoResultDTO {

	private Integer cdgoUE;
	private String cdgoUsuExterno;
	private int cdgoEmpresa;
	private boolean activo;
	private Date fechaAct;
	private String desgUsuact;

	public Integer getCdgoUE() {
		return cdgoUE;
	}

	public void setCdgoUE(Integer cdgoUE) {
		this.cdgoUE = cdgoUE;
	}

	public String getCdgoUsuExterno() {
		return cdgoUsuExterno;
	}

	public void setCdgoUsuExterno(String cdgoUsuExterno) {
		this.cdgoUsuExterno = cdgoUsuExterno;
	}

	public int getCdgoEmpresa() {
		return cdgoEmpresa;
	}

	public void setCdgoEmpresa(int cdgoEmpresa) {
		this.cdgoEmpresa = cdgoEmpresa;
	}

	public boolean getActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public Date getFechaAct() {
		return fechaAct;
	}

	public void setFechaAct(Date fechaAct) {
		this.fechaAct = fechaAct;
	}

	public String getDesgUsuact() {
		return desgUsuact;
	}

	public void setDesgUsuact(String desgUsuact) {
		this.desgUsuact = desgUsuact;
	}

}
