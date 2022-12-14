package renfe.com.model.dto;

import java.math.BigDecimal;
import java.sql.Date;

public class Tbasg128EstaclineDto {

	private String cdgoEstacion;
	private String cdgoLinea;
	private Integer cdgoOrden;
	private BigDecimal cdgoPk;
	private String desgNomcorto;
	private String desgNomlargo;
	private String desgSoportedoc;
	private String desgUsuact;
	private String fchaAct;
	private String mrcaActivo;

	public String getCdgoEstacion() {
		return this.cdgoEstacion;
	}

	public void setCdgoEstacion(String cdgoEstacion) {
		this.cdgoEstacion = cdgoEstacion;
	}

	public String getCdgoLinea() {
		return this.cdgoLinea;
	}

	public void setCdgoLinea(String cdgoLinea) {
		this.cdgoLinea = cdgoLinea;
	}

	public Integer getCdgoOrden() {
		return this.cdgoOrden;
	}

	public void setCdgoOrden(Integer cdgoOrden) {
		this.cdgoOrden = cdgoOrden;
	}

	public BigDecimal getCdgoPk() {
		return this.cdgoPk;
	}

	public void setCdgoPk(BigDecimal cdgoPk) {
		this.cdgoPk = cdgoPk;
	}

	public String getDesgNomcorto() {
		return this.desgNomcorto;
	}

	public void setDesgNomcorto(String desgNomcorto) {
		this.desgNomcorto = desgNomcorto;
	}

	public String getDesgNomlargo() {
		return this.desgNomlargo;
	}

	public void setDesgNomlargo(String desgNomlargo) {
		this.desgNomlargo = desgNomlargo;
	}

	public String getDesgSoportedoc() {
		return this.desgSoportedoc;
	}

	public void setDesgSoportedoc(String desgSoportedoc) {
		this.desgSoportedoc = desgSoportedoc;
	}

	public String getDesgUsuact() {
		return this.desgUsuact;
	}

	public void setDesgUsuact(String desgUsuact) {
		this.desgUsuact = desgUsuact;
	}

	public String getFchaAct() {
		return this.fchaAct;
	}

	public void setFchaAct(String fchaAct) {
		this.fchaAct = fchaAct;
	}

	public String getMrcaActivo() {
		return this.mrcaActivo;
	}

	public void setMrcaActivo(String mrcaActivo) {
		this.mrcaActivo = mrcaActivo;
	}

}