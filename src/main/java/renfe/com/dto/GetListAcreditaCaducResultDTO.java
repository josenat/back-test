package renfe.com.dto;

import java.sql.Date;

public class GetListAcreditaCaducResultDTO {

	private String nombre;
	private String apell1;
	private String apell2;
	private String tipoDoc;
	private String nifpas;
	private Integer codAcre;
	private String descTipoAcre;
	private Integer codPersona;
	private Integer cdgoEmpresa;
	private Date fecAcredita;
	private Date fecCaduc;
	private String codLinea;
	private String codPuerto;
	private String codEstacion;
	private String email;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApell1() {
		return apell1;
	}

	public void setApell1(String apell1) {
		this.apell1 = apell1;
	}

	public String getApell2() {
		return apell2;
	}

	public void setApell2(String apell2) {
		this.apell2 = apell2;
	}

	public String getTipoDoc() {
		return tipoDoc;
	}

	public void setTipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
	}

	public String getNifpas() {
		return nifpas;
	}

	public void setNifpas(String nifpas) {
		this.nifpas = nifpas;
	}

	public Integer getCodAcre() {
		return codAcre;
	}

	public void setCodAcre(Integer codAcre) {
		this.codAcre = codAcre;
	}

	public String getDescTipoAcre() {
		return descTipoAcre;
	}

	public void setDescTipoAcre(String descTipoAcre) {
		this.descTipoAcre = descTipoAcre;
	}

	public Integer getCodPersona() {
		return codPersona;
	}

	public void setCodPersona(Integer codPersona) {
		this.codPersona = codPersona;
	}

	public Integer getCdgoEmpresa() {
		return cdgoEmpresa;
	}

	public void setCdgoEmpresa(Integer cdgoEmpresa) {
		this.cdgoEmpresa = cdgoEmpresa;
	}

	public Date getFecAcredita() {
		return fecAcredita;
	}

	public void setFecAcredita(Date fecAcredita) {
		this.fecAcredita = fecAcredita;
	}

	public Date getFecCaduc() {
		return fecCaduc;
	}

	public void setFecCaduc(Date fecCaduc) {
		this.fecCaduc = fecCaduc;
	}

	public String getCodLinea() {
		return codLinea;
	}

	public void setCodLinea(String codLinea) {
		this.codLinea = codLinea;
	}

	public String getCodPuerto() {
		return codPuerto;
	}

	public void setCodPuerto(String codPuerto) {
		this.codPuerto = codPuerto;
	}

	public String getCodEstacion() {
		return codEstacion;
	}

	public void setCodEstacion(String codEstacion) {
		this.codEstacion = codEstacion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
