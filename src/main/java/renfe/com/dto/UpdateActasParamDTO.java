package renfe.com.dto;

public class UpdateActasParamDTO {

	private String cdgoCurso;
	private String descCurso;
	private String observa;
	private Integer cdgoCentroFor;
	private String usuAct;
	private boolean activo;
	private Integer cdgoActaForm;

	public String getCdgoCurso() {
		return cdgoCurso;
	}

	public void setCdgoCurso(String cdgoCurso) {
		this.cdgoCurso = cdgoCurso;
	}

	public String getDescCurso() {
		return descCurso;
	}

	public void setDescCurso(String descCurso) {
		this.descCurso = descCurso;
	}

	public String getObserva() {
		return observa;
	}

	public void setObserva(String observa) {
		this.observa = observa;
	}

	public Integer getCdgoCentroFor() {
		return cdgoCentroFor;
	}

	public void setCdgoCentroFor(Integer cdgoCentroFor) {
		this.cdgoCentroFor = cdgoCentroFor;
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

	public Integer getCdgoActaForm() {
		return cdgoActaForm;
	}

	public void setCdgoActaForm(Integer cdgoActaForm) {
		this.cdgoActaForm = cdgoActaForm;
	}

}
