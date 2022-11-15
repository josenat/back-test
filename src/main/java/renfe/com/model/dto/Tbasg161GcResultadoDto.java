package renfe.com.model.dto;

import java.sql.Date;

public class Tbasg161GcResultadoDto {

	private String cdgoCategoria;
	private String cdgoConcepto;
	private Integer cdgoConsulta;
	private String cdgoCritorden;
	private Integer cdgoOrden;
	private String desgUsuact;
	private Date fchaAct;

	public String getCdgoCategoria() {
		return this.cdgoCategoria;
	}

	public void setCdgoCategoria(String cdgoCategoria) {
		this.cdgoCategoria = cdgoCategoria;
	}

	public String getCdgoConcepto() {
		return this.cdgoConcepto;
	}

	public void setCdgoConcepto(String cdgoConcepto) {
		this.cdgoConcepto = cdgoConcepto;
	}

	public Integer getCdgoConsulta() {
		return this.cdgoConsulta;
	}

	public void setCdgoConsulta(Integer cdgoConsulta) {
		this.cdgoConsulta = cdgoConsulta;
	}

	public String getCdgoCritorden() {
		return this.cdgoCritorden;
	}

	public void setCdgoCritorden(String cdgoCritorden) {
		this.cdgoCritorden = cdgoCritorden;
	}

	public Integer getCdgoOrden() {
		return this.cdgoOrden;
	}

	public void setCdgoOrden(Integer cdgoOrden) {
		this.cdgoOrden = cdgoOrden;
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