package renfe.com.dto;

import java.sql.Date;

public class GetGcconceptoResultDTO {

	private String cdgoConcepto;
	private String cdgoCategoria;
	private String nombre;
	private Integer cdgoOrden;
	private String tipoFiltro;
	private Integer cdgoDatosLong;
	private String usuAct;
	private Date fchaAct;
	private boolean activo;
	private String muestraConcepto;

	public String getCdgoConcepto() {
		return cdgoConcepto;
	}

	public void setCdgoConcepto(String cdgoConcepto) {
		this.cdgoConcepto = cdgoConcepto;
	}

	public String getCdgoCategoria() {
		return cdgoCategoria;
	}

	public void setCdgoCategoria(String cdgoCategoria) {
		this.cdgoCategoria = cdgoCategoria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCdgoOrden() {
		return cdgoOrden;
	}

	public void setCdgoOrden(Integer cdgoOrden) {
		this.cdgoOrden = cdgoOrden;
	}

	public String getTipoFiltro() {
		return tipoFiltro;
	}

	public void setTipoFiltro(String tipoFiltro) {
		this.tipoFiltro = tipoFiltro;
	}

	public Integer getCdgoDatosLong() {
		return cdgoDatosLong;
	}

	public void setCdgoDatosLong(Integer cdgoDatosLong) {
		this.cdgoDatosLong = cdgoDatosLong;
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

	public boolean getActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public String getMuestraConcepto() {
		return muestraConcepto;
	}

	public void setMuestraConcepto(String muestraConcepto) {
		this.muestraConcepto = muestraConcepto;
	}

}
