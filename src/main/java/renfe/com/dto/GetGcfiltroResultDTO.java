package renfe.com.dto;

import java.sql.Date;

public class GetGcfiltroResultDTO {

	private int cdgoFiltro;
	private int cdgoConsulta;
	private String cdgoCategoria;
	private String cdgoConcepto;
	private int cdgoOrden;
	private String tipoConjuncion;
	private boolean negacion;
	private String operador;
	private String valor1;
	private String valor2;
	private String usuAct;
	private Date fchaAct;

	public int getCdgoFiltro() {
		return cdgoFiltro;
	}

	public void setCdgoFiltro(int cdgoFiltro) {
		this.cdgoFiltro = cdgoFiltro;
	}

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

	public String getTipoConjuncion() {
		return tipoConjuncion;
	}

	public void setTipoConjuncion(String tipoConjuncion) {
		this.tipoConjuncion = tipoConjuncion;
	}

	public boolean getNegacion() {
		return negacion;
	}

	public void setNegacion(boolean negacion) {
		this.negacion = negacion;
	}

	public String getOperador() {
		return operador;
	}

	public void setOperador(String operador) {
		this.operador = operador;
	}

	public String getValor1() {
		return valor1;
	}

	public void setValor1(String valor1) {
		this.valor1 = valor1;
	}

	public String getValor2() {
		return valor2;
	}

	public void setValor2(String valor2) {
		this.valor2 = valor2;
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
