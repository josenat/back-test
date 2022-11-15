package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG190_DOC_INFR_ORDENANTE")
public class Tbasg190DocInfrOrdenante {

	@Id
	@Column(name = "CDGO_ORDENANTE")
	private Long cdgoOrdenante;

	@NotNull
	@Column(name = "DESG_CARGO")
	private String desgCargo;

	@NotNull
	@Column(name = "DESG_DEPARTAMENTO")
	private String desgDepartamento;

	@Column(name = "DESG_FAX")
	private String desgFax;

	@Column(name = "DESG_INICIALESDEPT")
	private String desgInicialesdept;

	@NotNull
	@Column(name = "DESG_NOMBRE")
	private String desgNombre;

	@Column(name = "DESG_TELEFONO")
	private String desgTelefono;

	@Column(name = "DESG_USUACT")
	private String desgUsuact;

	@Column(name = "FCHA_ACT")
	private Date fchaAct;

	@Column(name = "MRCA_ACTIVO")
	private String mrcaActivo;

	public Long getCdgoOrdenante() {
		return this.cdgoOrdenante;
	}

	public void setCdgoOrdenante(Long cdgoOrdenante) {
		this.cdgoOrdenante = cdgoOrdenante;
	}

	public String getDesgCargo() {
		return this.desgCargo;
	}

	public String getDesgDepartamento() {
		return this.desgDepartamento;
	}

	public String getDesgFax() {
		return this.desgFax;
	}

	public String getDesgInicialesdept() {
		return this.desgInicialesdept;
	}

	public String getDesgNombre() {
		return this.desgNombre;
	}

	public String getDesgTelefono() {
		return this.desgTelefono;
	}

	public String getDesgUsuact() {
		return this.desgUsuact;
	}

	public Date getFchaAct() {
		return this.fchaAct;
	}

	public String getMrcaActivo() {
		return this.mrcaActivo;
	}

	public void setDesgCargo(String desgCargo) {
		this.desgCargo = desgCargo;
	}

	public void setDesgDepartamento(String desgDepartamento) {
		this.desgDepartamento = desgDepartamento;
	}

	public void setDesgFax(String desgFax) {
		this.desgFax = desgFax;
	}

	public void setDesgInicialesdept(String desgInicialesdept) {
		this.desgInicialesdept = desgInicialesdept;
	}

	public void setDesgNombre(String desgNombre) {
		this.desgNombre = desgNombre;
	}

	public void setDesgTelefono(String desgTelefono) {
		this.desgTelefono = desgTelefono;
	}

	public void setDesgUsuact(String desgUsuact) {
		this.desgUsuact = desgUsuact;
	}

	public void setFchaAct(Date fchaAct) {
		this.fchaAct = fchaAct;
	}

	public void setMrcaActivo(String mrcaActivo) {
		this.mrcaActivo = mrcaActivo;
	}

}