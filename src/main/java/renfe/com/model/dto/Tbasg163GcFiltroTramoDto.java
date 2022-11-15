package renfe.com.model.dto;

import java.sql.Date;

public class Tbasg163GcFiltroTramoDto {

	private String cdgoDestino;
	private Integer cdgoFiltro;
	private Integer cdgoFiltroTramo;
	private String cdgoLinea;
	private String cdgoOrigen;
	private String desgUsuact;
	private Date fchaAct;

	public String getCdgoDestino() {
		return this.cdgoDestino;
	}

	public void setCdgoDestino(String cdgoDestino) {
		this.cdgoDestino = cdgoDestino;
	}

	public Integer getCdgoFiltro() {
		return this.cdgoFiltro;
	}

	public void setCdgoFiltro(Integer cdgoFiltro) {
		this.cdgoFiltro = cdgoFiltro;
	}

	public Integer getCdgoFiltroTramo() {
		return this.cdgoFiltroTramo;
	}

	public void setCdgoFiltroTramo(Integer cdgoFiltroTramo) {
		this.cdgoFiltroTramo = cdgoFiltroTramo;
	}

	public String getCdgoLinea() {
		return this.cdgoLinea;
	}

	public void setCdgoLinea(String cdgoLinea) {
		this.cdgoLinea = cdgoLinea;
	}

	public String getCdgoOrigen() {
		return this.cdgoOrigen;
	}

	public void setCdgoOrigen(String cdgoOrigen) {
		this.cdgoOrigen = cdgoOrigen;
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

}