package renfe.com.dto;

public class UpdateAcreditacionParamMantenimientoDTO {

	private boolean activo;
	private int cdgoEmpresa;
	private String observa;
	private int cdgoAcreditacion;

	public boolean getActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public int getCdgoEmpresa() {
		return cdgoEmpresa;
	}

	public void setCdgoEmpresa(int cdgoEmpresa) {
		this.cdgoEmpresa = cdgoEmpresa;
	}

	public String getObserva() {
		return observa;
	}

	public void setObserva(String observa) {
		this.observa = observa;
	}

	public int getCdgoAcreditacion() {
		return cdgoAcreditacion;
	}

	public void setCdgoAcreditacion(int cdgoAcreditacion) {
		this.cdgoAcreditacion = cdgoAcreditacion;
	}

}
