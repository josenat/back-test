package renfe.com.dto;

public class UpdateGcconsultaParamDTO {

	private String nombre;
	private boolean contar;
	private String expLogica;
	private String usuAct;
	private int cdgoConsulta;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean getContar() {
		return contar;
	}

	public void setContar(boolean contar) {
		this.contar = contar;
	}

	public String getExpLogica() {
		return expLogica;
	}

	public void setExpLogica(String expLogica) {
		this.expLogica = expLogica;
	}

	public String getUsuAct() {
		return usuAct;
	}

	public void setUsuAct(String usuAct) {
		this.usuAct = usuAct;
	}

	public int getCdgoConsulta() {
		return cdgoConsulta;
	}

	public void setCdgoConsulta(int cdgoConsulta) {
		this.cdgoConsulta = cdgoConsulta;
	}

}
