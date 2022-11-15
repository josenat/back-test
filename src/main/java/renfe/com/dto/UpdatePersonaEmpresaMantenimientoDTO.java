package renfe.com.dto;

public class UpdatePersonaEmpresaMantenimientoDTO {

	private Integer cdgoEmpresa;
	private String usuAct;
	private Integer cdgoPersona;
	private Integer cdgoEmpresaAnt;

	public Integer getCdgoEmpresa() {
		return cdgoEmpresa;
	}

	public void setCdgoEmpresa(Integer cdgoEmpresa) {
		this.cdgoEmpresa = cdgoEmpresa;
	}

	public String getUsuAct() {
		return usuAct;
	}

	public void setUsuAct(String usuAct) {
		this.usuAct = usuAct;
	}

	public Integer getCdgoPersona() {
		return cdgoPersona;
	}

	public void setCdgoPersona(Integer cdgoPersona) {
		this.cdgoPersona = cdgoPersona;
	}

	public Integer getCdgoEmpresaAnt() {
		return cdgoEmpresaAnt;
	}

	public void setCdgoEmpresaAnt(Integer cdgoEmpresaAnt) {
		this.cdgoEmpresaAnt = cdgoEmpresaAnt;
	}

}
