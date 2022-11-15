package renfe.com.model.dto;

import java.sql.Date;
import javax.persistence.Entity;


public class ActasPersonaDto {
	Integer cdgoActaForm;
	Integer codigo;
	Integer cdgoExpedient;
	String cdgoCurso;
	String desgDesccurso;
	String desgObserva;
	Integer cdgoCentroFor;
	String desgTipoCurso;
	Integer cdgoCalifi;
	String cdgoIndinstr;
	Date fchaCurso;
	Integer titulo;
	String cdgoIdexa;

	public Integer getCdgoActaForm() {
		return cdgoActaForm;
	}

	public void setCdgoActaForm(Integer cdgoActaForm) {
		this.cdgoActaForm = cdgoActaForm;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getCdgoExpedient() {
		return cdgoExpedient;
	}

	public void setCdgoExpedient(Integer cdgoExpedient) {
		this.cdgoExpedient = cdgoExpedient;
	}

	public String getCdgoCurso() {
		return cdgoCurso;
	}

	public void setCdgoCurso(String cdgoCurso) {
		this.cdgoCurso = cdgoCurso;
	}

	public String getDesgDesccurso() {
		return desgDesccurso;
	}

	public void setDesgDesccurso(String desgDesccurso) {
		this.desgDesccurso = desgDesccurso;
	}

	public String getDesgObserva() {
		return desgObserva;
	}

	public void setDesgObserva(String desgObserva) {
		this.desgObserva = desgObserva;
	}

	public Integer getCdgoCentroFor() {
		return cdgoCentroFor;
	}

	public void setCdgoCentroFor(Integer cdgoCentroFor) {
		this.cdgoCentroFor = cdgoCentroFor;
	}

	public String getDesgTipoCurso() {
		return desgTipoCurso;
	}

	public void setDesgTipoCurso(String desgTipoCurso) {
		this.desgTipoCurso = desgTipoCurso;
	}

	public Integer getCdgoCalifi() {
		return cdgoCalifi;
	}

	public void setCdgoCalifi(Integer cdgoCalifi) {
		this.cdgoCalifi = cdgoCalifi;
	}

	public String getCdgoIndinstr() {
		return cdgoIndinstr;
	}

	public void setCdgoIndinstr(String cdgoIndinstr) {
		this.cdgoIndinstr = cdgoIndinstr;
	}

	public Date getFchaCurso() {
		return fchaCurso;
	}

	public void setFchaCurso(Date fchaCurso) {
		this.fchaCurso = fchaCurso;
	}

	public Integer getTitulo() {
		return titulo;
	}

	public void setTitulo(Integer titulo) {
		this.titulo = titulo;
	}

	public String getCdgoIdexa() {
		return cdgoIdexa;
	}

	public void setCdgoIdexa(String cdgoIdexa) {
		this.cdgoIdexa = cdgoIdexa;
	}

}
