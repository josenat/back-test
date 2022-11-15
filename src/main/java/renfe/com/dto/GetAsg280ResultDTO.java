package renfe.com.dto;

import java.sql.Date;

public class GetAsg280ResultDTO {

	private String matricula;
	private String mrcaEstado;
	private String desgUsuact;
	private Date fechaAct;
	private String mrcaGrabado;
	private Date fechaGrabado;

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getMrcaEstado() {
		return mrcaEstado;
	}

	public void setMrcaEstado(String mrcaEstado) {
		this.mrcaEstado = mrcaEstado;
	}

	public String getDesgUsuact() {
		return desgUsuact;
	}

	public void setDesgUsuact(String desgUsuact) {
		this.desgUsuact = desgUsuact;
	}

	public Date getFechaAct() {
		return fechaAct;
	}

	public void setFechaAct(Date fechaAct) {
		this.fechaAct = fechaAct;
	}

	public String getMrcaGrabado() {
		return mrcaGrabado;
	}

	public void setMrcaGrabado(String mrcaGrabado) {
		this.mrcaGrabado = mrcaGrabado;
	}

	public Date getFechaGrabado() {
		return fechaGrabado;
	}

	public void setFechaGrabado(Date fechaGrabado) {
		this.fechaGrabado = fechaGrabado;
	}

}
