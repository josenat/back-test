package renfe.com.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG230_DESTINATARIOS_EMAIL", schema = "PASG")
public class Tbasg230DestinatariosEmail {

	@Id
	@Column(name = "DESG_DIRECCION_EMAIL")
	private String desgDireccionEmail;

	@Column(name = "CDGO_AREA_ACTIVIDAD")
	private Integer cdgoAreaActividad;

	@NotNull
	@Column(name = "DESG_NIVEL_DE_ENVIO")
	private String desgNivelDeEnvio;

	@NotNull
	@Column(name = "DESG_NOMBRE")
	private String desgNombre;

	@NotNull
	@Column(name = "MRCA_ACTIVO")
	private String mrcaActivo;

	public String getDesgDireccionEmail() {
		return this.desgDireccionEmail;
	}

	public void setDesgDireccionEmail(String desgDireccionEmail) {
		this.desgDireccionEmail = desgDireccionEmail;
	}

	public Integer getCdgoAreaActividad() {
		return this.cdgoAreaActividad;
	}

	public String getDesgNivelDeEnvio() {
		return this.desgNivelDeEnvio;
	}

	public String getDesgNombre() {
		return this.desgNombre;
	}

	public String getMrcaActivo() {
		return this.mrcaActivo;
	}

	public void setCdgoAreaActividad(Integer cdgoAreaActividad) {
		this.cdgoAreaActividad = cdgoAreaActividad;
	}

	public void setDesgNivelDeEnvio(String desgNivelDeEnvio) {
		this.desgNivelDeEnvio = desgNivelDeEnvio;
	}

	public void setDesgNombre(String desgNombre) {
		this.desgNombre = desgNombre;
	}

	public void setMrcaActivo(String mrcaActivo) {
		this.mrcaActivo = mrcaActivo;
	}

}