package renfe.com.model.dto;

import java.sql.Date;

public class Tbasg280MarcaGmmDto {

	private String desgMatricula;
	private String desgUsuact;
	private Date fchaAct;
	private Date fchaGrabadoGmm;
	private String mrcaEstado;
	private String mrcaGrabadoGmm;

	public String getDesgMatricula() {
		return this.desgMatricula;
	}

	public void setDesgMatricula(String desgMatricula) {
		this.desgMatricula = desgMatricula;
	}

	public String getDesgUsuact() {
		return this.desgUsuact;
	}

	public void setDesgUsuact(String desgUsuact) {
		this.desgUsuact = desgUsuact;
	}

	public Date getFchaAct() {
		return this.fchaAct;
	}

	public void setFchaAct(Date fchaAct) {
		this.fchaAct = fchaAct;
	}

	public Date getFchaGrabadoGmm() {
		return this.fchaGrabadoGmm;
	}

	public void setFchaGrabadoGmm(Date fchaGrabadoGmm) {
		this.fchaGrabadoGmm = fchaGrabadoGmm;
	}

	public String getMrcaEstado() {
		return this.mrcaEstado;
	}

	public void setMrcaEstado(String mrcaEstado) {
		this.mrcaEstado = mrcaEstado;
	}

	public String getMrcaGrabadoGmm() {
		return this.mrcaGrabadoGmm;
	}

	public void setMrcaGrabadoGmm(String mrcaGrabadoGmm) {
		this.mrcaGrabadoGmm = mrcaGrabadoGmm;
	}

}