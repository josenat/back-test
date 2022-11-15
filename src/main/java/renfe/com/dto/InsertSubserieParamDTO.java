package renfe.com.dto;

public class InsertSubserieParamDTO {

	private String cdgoSubSerie;
	private String cdgoSerie;
	private String usuAct;
	private boolean activo;

	public String getCdgoSubSerie() {
		return cdgoSubSerie;
	}

	public void setCdgoSubSerie(String cdgoSubSerie) {
		this.cdgoSubSerie = cdgoSubSerie;
	}

	public String getCdgoSerie() {
		return cdgoSerie;
	}

	public void setCdgoSerie(String cdgoSerie) {
		this.cdgoSerie = cdgoSerie;
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
