package renfe.com.dto;

public class InsertUsuarioExternoParamDTO {

	private String cdgoUsuExterno;
	private int cdgoEmpresa;
	private boolean activo;
	private String desgUsuact;

	public String getCdgoUsuExterno() {
		return cdgoUsuExterno;
	}

	public void setCdgoUsuExterno(String cdgoUsuExterno) {
		this.cdgoUsuExterno = cdgoUsuExterno;
	}

	public int getCdgoEmpresa() {
		return cdgoEmpresa;
	}

	public void setCdgoEmpresa(int cdgoEmpresa) {
		this.cdgoEmpresa = cdgoEmpresa;
	}

	public boolean getActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public String getDesgUsuact() {
		return desgUsuact;
	}

	public void setDesgUsuact(String desgUsuact) {
		this.desgUsuact = desgUsuact;
	}

}
