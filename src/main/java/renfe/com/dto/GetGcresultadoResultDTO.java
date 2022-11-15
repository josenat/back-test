package renfe.com.dto;

import java.sql.Date;

public class GetGcresultadoResultDTO {

	private int cdgoConsulta;
	private String cdgoCategoria;
	private String cdgoConcepto;
	private int cdgoOrden;
	private String cdgoCritOrden;
	private String usuAct;
	private Date fchaAct;

	public int getCdgoConsulta() {
		return cdgoConsulta;
	}

	public void setCdgoConsulta(int cdgoConsulta) {
		this.cdgoConsulta = cdgoConsulta;
	}

	public String getCdgoCategoria() {
		return cdgoCategoria;
	}

	public void setCdgoCategoria(String cdgoCategoria) {
		this.cdgoCategoria = cdgoCategoria;
	}

	public String getCdgoConcepto() {
		return cdgoConcepto;
	}

	public void setCdgoConcepto(String cdgoConcepto) {
		this.cdgoConcepto = cdgoConcepto;
	}

	public int getCdgoOrden() {
		return cdgoOrden;
	}

	public void setCdgoOrden(int cdgoOrden) {
		this.cdgoOrden = cdgoOrden;
	}

	public String getCdgoCritOrden() {
		return cdgoCritOrden;
	}

	public void setCdgoCritOrden(String cdgoCritOrden) {
		this.cdgoCritOrden = cdgoCritOrden;
	}

	public String getUsuAct() {
		return usuAct;
	}

	public void setUsuAct(String usuAct) {
		this.usuAct = usuAct;
	}

	public Date getFchaAct() {
		return fchaAct;
	}

	public void setFchaAct(Date fchaAct) {
		this.fchaAct = fchaAct;
	}

}
