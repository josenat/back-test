package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG191_DOC_INFR_DESTINATARIO")
public class Tbasg191DocInfrDestinatario {

	@Id
	@Column(name = "CDGO_DESTINATARIO")
	private Long cdgoDestinatario;

	@NotNull
	@Column(name = "DESG_CARGO")
	private String desgCargo;

	@NotNull
	@Column(name = "DESG_DIRECCIONGNRL")
	private String desgDirecciongnrl;

	@NotNull
	@Column(name = "DESG_NOMBRE")
	private String desgNombre;

	@NotNull
	@Column(name = "DESG_NOMBREPILA")
	private String desgNombrepila;

	@Column(name = "DESG_USUACT")
	private String desgUsuact;

	@Column(name = "FCHA_ACT")
	private Date fchaAct;

	@Column(name = "MRCA_ACTIVO")
	private String mrcaActivo;

	public Long getCdgoDestinatario() {
		return this.cdgoDestinatario;
	}

	public void setCdgoDestinatario(Long cdgoDestinatario) {
		this.cdgoDestinatario = cdgoDestinatario;
	}

	public String getDesgCargo() {
		return this.desgCargo;
	}

	public String getDesgDirecciongnrl() {
		return this.desgDirecciongnrl;
	}

	public String getDesgNombre() {
		return this.desgNombre;
	}

	public String getDesgNombrepila() {
		return this.desgNombrepila;
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

	public void setDesgDirecciongnrl(String desgDirecciongnrl) {
		this.desgDirecciongnrl = desgDirecciongnrl;
	}

	public void setDesgNombre(String desgNombre) {
		this.desgNombre = desgNombre;
	}

	public void setDesgNombrepila(String desgNombrepila) {
		this.desgNombrepila = desgNombrepila;
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