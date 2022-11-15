package renfe.com.dto;

import java.sql.Date;

public class GetFindPersonaAltasBajasDTO {
	private String desgNifpas;
	private String  descTipodoc;
	private String activo;
	private Date fecha;
	private String titulo;
	private String nifEmpresa;
	private String cdgoSociedad;
	public String getDesgNifpas() {
		return desgNifpas;
	}
	public void setDesgNifpas(String desgNifpas) {
		this.desgNifpas = desgNifpas;
	}
	public String getDescTipodoc() {
		return descTipodoc;
	}
	public void setDescTipodoc(String descTipodoc) {
		this.descTipodoc = descTipodoc;
	}
	public String getActivo() {
		return activo;
	}
	public void setActivo(String activo) {
		this.activo = activo;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
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
