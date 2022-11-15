package renfe.com.dto;

public class InsertAmbitosParamDTO {

	private String nombre;
	private String cdgoGerencia;
	private int cdgoProvincia;
	private int cdgoTipoDep;
	private int cdgoTipohab;
	private String usuAct;
	private boolean activo;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCdgoGerencia() {
		return cdgoGerencia;
	}

	public void setCdgoGerencia(String cdgoGerencia) {
		this.cdgoGerencia = cdgoGerencia;
	}

	public int getCdgoProvincia() {
		return cdgoProvincia;
	}

	public void setCdgoProvincia(int cdgoProvincia) {
		this.cdgoProvincia = cdgoProvincia;
	}

	public int getCdgoTipoDep() {
		return cdgoTipoDep;
	}

	public void setCdgoTipoDep(int cdgoTipoDep) {
		this.cdgoTipoDep = cdgoTipoDep;
	}

	public int getCdgoTipohab() {
		return cdgoTipohab;
	}

	public void setCdgoTipohab(int cdgoTipohab) {
		this.cdgoTipohab = cdgoTipohab;
	}

	public String getUsuAct() {
		return usuAct;
	}

	public void setUsuAct(String usuAct) {
		this.usuAct = usuAct;
	}

	public boolean getActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

}
