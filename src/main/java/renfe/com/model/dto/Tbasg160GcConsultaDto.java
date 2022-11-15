package renfe.com.model.dto;

import java.sql.Date;

public class Tbasg160GcConsultaDto {

	private Integer cdgoConsulta;
	private String desgExplogica;
	private String desgNombre;
	private String desgUsuact;
	private String desgUsuario;
	private Date fchaAct;
	private String mrcaActivo;
	private String mrcaContar;

	public Integer getCdgoConsulta() {
		return this.cdgoConsulta;
	}

	public void setCdgoConsulta(Integer cdgoConsulta) {
		this.cdgoConsulta = cdgoConsulta;
	}

	public String getDesgExplogica() {
		return this.desgExplogica;
	}

	public void setDesgExplogica(String desgExplogica) {
		this.desgExplogica = desgExplogica;
	}

	public String getDesgNombre() {
		return this.desgNombre;
	}

	public void setDesgNombre(String desgNombre) {
		this.desgNombre = desgNombre;
	}

	public String getDesgUsuact() {
		return this.desgUsuact;
	}

	public void setDesgUsuact(String desgUsuact) {
		this.desgUsuact = desgUsuact;
	}

	public String getDesgUsuario() {
		return this.desgUsuario;
	}

	public void setDesgUsuario(String desgUsuario) {
		this.desgUsuario = desgUsuario;
	}

	public Date getFchaAct() {
		return this.fchaAct;
	}

	public void setFchaAct(Date fchaAct) {
		this.fchaAct = fchaAct;
	}

	public String getMrcaActivo() {
		return this.mrcaActivo;
	}

	public void setMrcaActivo(String mrcaActivo) {
		this.mrcaActivo = mrcaActivo;
	}

	public String getMrcaContar() {
		return this.mrcaContar;
	}

	public void setMrcaContar(String mrcaContar) {
		this.mrcaContar = mrcaContar;
	}

}