package renfe.com.dto;

import java.sql.Date;

public class GetListAcreditacionesResultDTO {

	private Integer cdgoAcreditacion;
	private String descTipoAcre;
	private String descPuerto;
	private String descLinea;
	private String descEstacLinea;
	private Date fecAcre;
	private String descEstado;

	public Integer getCdgoAcreditacion() {
		return cdgoAcreditacion;
	}

	public void setCdgoAcreditacion(Integer cdgoAcreditacion) {
		this.cdgoAcreditacion = cdgoAcreditacion;
	}

	public String getDescTipoAcre() {
		return descTipoAcre;
	}

	public void setDescTipoAcre(String descTipoAcre) {
		this.descTipoAcre = descTipoAcre;
	}

	public String getDescPuerto() {
		return descPuerto;
	}

	public void setDescPuerto(String descPuerto) {
		this.descPuerto = descPuerto;
	}

	public String getDescLinea() {
		return descLinea;
	}

	public void setDescLinea(String descLinea) {
		this.descLinea = descLinea;
	}

	public String getDescEstacLinea() {
		return descEstacLinea;
	}

	public void setDescEstacLinea(String descEstacLinea) {
		this.descEstacLinea = descEstacLinea;
	}

	public Date getFecAcre() {
		return fecAcre;
	}

	public void setFecAcre(Date fecAcre) {
		this.fecAcre = fecAcre;
	}

	public String getDescEstado() {
		return descEstado;
	}

	public void setDescEstado(String descEstado) {
		this.descEstado = descEstado;
	}

}
