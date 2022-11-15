package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG176_DOC_ORDEN_ACTI_CLAVE")
public class Tbasg176DocOrdenActiClave {

	@Id
	@Column(name = "CDGO_CLAVE")
	private Long cdgoClave;

	@NotNull
	@Column(name = "DESG_DESCRIPCION")
	private String desgDescripcion;

	@Column(name = "DESG_USUACT")
	private String desgUsuact;

	@Column(name = "FCHA_ACT")
	private Date fchaAct;

	@Column(name = "MRCA_ACTIVO")
	private String mrcaActivo;

	public Long getCdgoClave() {
		return this.cdgoClave;
	}

	public void setCdgoClave(Long cdgoClave) {
		this.cdgoClave = cdgoClave;
	}

	public String getDesgDescripcion() {
		return this.desgDescripcion;
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

	public void setDesgDescripcion(String desgDescripcion) {
		this.desgDescripcion = desgDescripcion;
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