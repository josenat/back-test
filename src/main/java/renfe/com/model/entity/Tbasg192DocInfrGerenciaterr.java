package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG192_DOC_INFR_GERENCIATERR")
public class Tbasg192DocInfrGerenciaterr {

	@Id
	@Column(name = "CDGO_GERENCIA")
	private Long cdgoGerencia;

	@NotNull
	@Column(name = "DESG_DIRECCION")
	private String desgDireccion;

	@NotNull
	@Column(name = "DESG_NOMBRE")
	private String desgNombre;

	@NotNull
	@Column(name = "DESG_RESPONSABLE")
	private String desgResponsable;

	@Column(name = "DESG_USUACT")
	private String desgUsuact;

	@NotNull
	@Column(name = "DESG_ZONA")
	private String desgZona;

	@Column(name = "FCHA_ACT")
	private Date fchaAct;

	@Column(name = "MRCA_ACTIVO")
	private String mrcaActivo;

	public Long getCdgoGerencia() {
		return this.cdgoGerencia;
	}

	public void setCdgoGerencia(Long cdgoGerencia) {
		this.cdgoGerencia = cdgoGerencia;
	}

	public String getDesgDireccion() {
		return this.desgDireccion;
	}

	public String getDesgNombre() {
		return this.desgNombre;
	}

	public String getDesgResponsable() {
		return this.desgResponsable;
	}

	public String getDesgUsuact() {
		return this.desgUsuact;
	}

	public String getDesgZona() {
		return this.desgZona;
	}

	public Date getFchaAct() {
		return this.fchaAct;
	}

	public String getMrcaActivo() {
		return this.mrcaActivo;
	}

	public void setDesgDireccion(String desgDireccion) {
		this.desgDireccion = desgDireccion;
	}

	public void setDesgNombre(String desgNombre) {
		this.desgNombre = desgNombre;
	}

	public void setDesgResponsable(String desgResponsable) {
		this.desgResponsable = desgResponsable;
	}

	public void setDesgUsuact(String desgUsuact) {
		this.desgUsuact = desgUsuact;
	}

	public void setDesgZona(String desgZona) {
		this.desgZona = desgZona;
	}

	public void setFchaAct(Date fchaAct) {
		this.fchaAct = fchaAct;
	}

	public void setMrcaActivo(String mrcaActivo) {
		this.mrcaActivo = mrcaActivo;
	}

}