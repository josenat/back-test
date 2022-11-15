package renfe.com.dto;

import java.sql.Date;

public class GetActaformabyexpResultDTO {

	private Integer cdgoActaForm;
	private Integer cdgoExpedient;
	private Integer cdgoTit;
	private String cdgoCurso;
	private String descCurso;
	private String observa;
	private Integer cdgoCentroFor;
	private String usuAct;
	private Date fchaAct;
	private boolean activo;

	public Integer getCdgoActaForm() {
		return cdgoActaForm;
	}

	public void setCdgoActaForm(Integer cdgoActaForm) {
		this.cdgoActaForm = cdgoActaForm;
	}

	public Integer getCdgoExpedient() {
		return cdgoExpedient;
	}

	public void setCdgoExpedient(Integer cdgoExpedient) {
		this.cdgoExpedient = cdgoExpedient;
	}

	public Integer getCdgoTit() {
		return cdgoTit;
	}

	public void setCdgoTit(Integer cdgoTit) {
		this.cdgoTit = cdgoTit;
	}

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

	public Date getFchaAct() {
		return fchaAct;
	}

	public void setFchaAct(Date fchaAct) {
		this.fchaAct = fchaAct;
	}

	public boolean getActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

}
