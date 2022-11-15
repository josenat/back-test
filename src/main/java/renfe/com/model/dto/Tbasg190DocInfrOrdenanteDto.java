package renfe.com.model.dto;

import java.sql.Date;

public class Tbasg190DocInfrOrdenanteDto {

	private Integer cdgoOrdenante;
	private String desgCargo;
	private String desgDepartamento;
	private String desgFax;
	private String desgInicialesdept;
	private String desgNombre;
	private String desgTelefono;
	private String desgUsuact;
	private Date fchaAct;
	private String mrcaActivo;

	public Integer getCdgoOrdenante() {
		return this.cdgoOrdenante;
	}

	public void setCdgoOrdenante(Integer cdgoOrdenante) {
		this.cdgoOrdenante = cdgoOrdenante;
	}

	public String getDesgCargo() {
		return this.desgCargo;
	}

	public void setDesgCargo(String desgCargo) {
		this.desgCargo = desgCargo;
	}

	public String getDesgDepartamento() {
		return this.desgDepartamento;
	}

	public void setDesgDepartamento(String desgDepartamento) {
		this.desgDepartamento = desgDepartamento;
	}

	public String getDesgFax() {
		return this.desgFax;
	}

	public void setDesgFax(String desgFax) {
		this.desgFax = desgFax;
	}

	public String getDesgInicialesdept() {
		return this.desgInicialesdept;
	}

	public void setDesgInicialesdept(String desgInicialesdept) {
		this.desgInicialesdept = desgInicialesdept;
	}

	public String getDesgNombre() {
		return this.desgNombre;
	}

	public void setDesgNombre(String desgNombre) {
		this.desgNombre = desgNombre;
	}

	public String getDesgTelefono() {
		return this.desgTelefono;
	}

	public void setDesgTelefono(String desgTelefono) {
		this.desgTelefono = desgTelefono;
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

	public String getMrcaActivo() {
		return this.mrcaActivo;
	}

	public void setMrcaActivo(String mrcaActivo) {
		this.mrcaActivo = mrcaActivo;
	}

}