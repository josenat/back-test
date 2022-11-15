package renfe.com.dto;

import java.sql.Date;

public class GetPersonaInformealtabajaDTO {

	private String tituloPersona;
	private String descTipoDoc;
	private String marcaActivo;
	private Date fechaAltaBaja;
	private String nifPas;
	private String nifEmpresa;
	private String cdgoSociedad;

	public String getTituloPersona() {
		return tituloPersona;
	}

	public void setTituloPersona(String tituloPersona) {
		this.tituloPersona = tituloPersona;
	}

	public String getDescTipoDoc() {
		return descTipoDoc;
	}

	public void setDescTipoDoc(String descTipoDoc) {
		this.descTipoDoc = descTipoDoc;
	}

	public String getMarcaActivo() {
		return marcaActivo;
	}

	public void setMarcaActivo(String marcaActivo) {
		this.marcaActivo = marcaActivo;
	}

	public Date getFechaAltaBaja() {
		return fechaAltaBaja;
	}

	public void setFechaAltaBaja(Date fechaAltaBaja) {
		this.fechaAltaBaja = fechaAltaBaja;
	}

	public String getNifPas() {
		return nifPas;
	}

	public void setNifPas(String nifPas) {
		this.nifPas = nifPas;
	}

	public String getNifEmpresa() {
		return nifEmpresa;
	}

	public void setNifEmpresa(String nifEmpresa) {
		this.nifEmpresa = nifEmpresa;
	}

	public String getCdgoSociedad() {
		return cdgoSociedad;
	}

	public void setCdgoSociedad(String cdgoSociedad) {
		this.cdgoSociedad = cdgoSociedad;
	}

}
