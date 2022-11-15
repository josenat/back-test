package renfe.com.dto;

import java.sql.Date;

public class InsertAcreditacionParamDTO {

	private int cdgoPersona;
	private int cdgoEmpresa;
	private String cdgoTipoAcre;
	private String cdgoPuerto;
	private String cdgoLinea;
	private String cdgoEstacLine;
	private String observa;
	private String usuAct;
	private Date fecCaduc;

	public int getCdgoPersona() {
		return cdgoPersona;
	}

	public void setCdgoPersona(int cdgoPersona) {
		this.cdgoPersona = cdgoPersona;
	}

	public int getCdgoEmpresa() {
		return cdgoEmpresa;
	}

	public void setCdgoEmpresa(int cdgoEmpresa) {
		this.cdgoEmpresa = cdgoEmpresa;
	}

	public String getCdgoTipoAcre() {
		return cdgoTipoAcre;
	}

	public void setCdgoTipoAcre(String cdgoTipoAcre) {
		this.cdgoTipoAcre = cdgoTipoAcre;
	}

	public String getCdgoPuerto() {
		return cdgoPuerto;
	}

	public void setCdgoPuerto(String cdgoPuerto) {
		this.cdgoPuerto = cdgoPuerto;
	}

	public String getCdgoLinea() {
		return cdgoLinea;
	}

	public void setCdgoLinea(String cdgoLinea) {
		this.cdgoLinea = cdgoLinea;
	}

	public String getCdgoEstacLine() {
		return cdgoEstacLine;
	}

	public void setCdgoEstacLine(String cdgoEstacLine) {
		this.cdgoEstacLine = cdgoEstacLine;
	}

	public String getObserva() {
		return observa;
	}

	public void setObserva(String observa) {
		this.observa = observa;
	}

	public String getUsuAct() {
		return usuAct;
	}

	public void setUsuAct(String usuAct) {
		this.usuAct = usuAct;
	}

	public Date getFecCaduc() {
		return fecCaduc;
	}

	public void setFecCaduc(Date fecCaduc) {
		this.fecCaduc = fecCaduc;
	}

}
