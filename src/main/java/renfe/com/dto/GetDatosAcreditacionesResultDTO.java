package renfe.com.dto;

import java.sql.Date;

public class GetDatosAcreditacionesResultDTO {

	private Integer cdgoAcreditacion;
	private String descTipoAcre;
	private String descPuerto;
	private String descLinea;
	private String descEstacLinea;
	private String descEmpresa;
	private Date fecAcre;
	private String codLinea;
	private String descEstado;
	private Date fchaCurso;
	private String cdgoCurso;

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

	public String getDescEmpresa() {
		return descEmpresa;
	}

	public void setDescEmpresa(String descEmpresa) {
		this.descEmpresa = descEmpresa;
	}

	public Date getFecAcre() {
		return fecAcre;
	}

	public void setFecAcre(Date fecAcre) {
		this.fecAcre = fecAcre;
	}

	public String getCodLinea() {
		return codLinea;
	}

	public void setCodLinea(String codLinea) {
		this.codLinea = codLinea;
	}

	public String getDescEstado() {
		return descEstado;
	}

	public void setDescEstado(String descEstado) {
		this.descEstado = descEstado;
	}

	public Date getFchaCurso() {
		return fchaCurso;
	}

	public void setFchaCurso(Date fchaCurso) {
		this.fchaCurso = fchaCurso;
	}

	public String getCdgoCurso() {
		return cdgoCurso;
	}

	public void setCdgoCurso(String cdgoCurso) {
		this.cdgoCurso = cdgoCurso;
	}

}
