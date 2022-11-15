package renfe.com.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG269_SEGUR")
public class Tbasg269Segur {

	@Id
	@Column(name = "CDGO_SEGURIDAD")
	private Long cdgoSeguridad;

	@Column(name = "ACCION")
	private String accion;

	@Column(name = "CDGO_PROCESO")
	private String cdgoProceso;

	@Column(name = "CDGO_SUB_PROCESO")
	private String cdgoSubProceso;

	@Column(name = "DESCRIP_ROL")
	private String descripRol;

	@Column(name = "DESG_PROCESO")
	private String desgProceso;

	@Column(name = "DESG_SUBPROCESO")
	private String desgSubproceso;

	@Column(name = "FCHA_ACCESO")
	private String fchaAcceso;

	@Column(name = "NIVEL")
	private String nivel;

	@Column(name = "ROL")
	private String rol;

	@NotNull
	@Column(name = "USUARIO")
	private String usuario;

	public Long getCdgoSeguridad() {
		return this.cdgoSeguridad;
	}

	public void setCdgoSeguridad(Long cdgoSeguridad) {
		this.cdgoSeguridad = cdgoSeguridad;
	}

	public String getAccion() {
		return this.accion;
	}

	public String getCdgoProceso() {
		return this.cdgoProceso;
	}

	public String getCdgoSubProceso() {
		return this.cdgoSubProceso;
	}

	public String getDescripRol() {
		return this.descripRol;
	}

	public String getDesgProceso() {
		return this.desgProceso;
	}

	public String getDesgSubproceso() {
		return this.desgSubproceso;
	}

	public String getFchaAcceso() {
		return this.fchaAcceso;
	}

	public String getNivel() {
		return this.nivel;
	}

	public String getRol() {
		return this.rol;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	public void setCdgoProceso(String cdgoProceso) {
		this.cdgoProceso = cdgoProceso;
	}

	public void setCdgoSubProceso(String cdgoSubProceso) {
		this.cdgoSubProceso = cdgoSubProceso;
	}

	public void setDescripRol(String descripRol) {
		this.descripRol = descripRol;
	}

	public void setDesgProceso(String desgProceso) {
		this.desgProceso = desgProceso;
	}

	public void setDesgSubproceso(String desgSubproceso) {
		this.desgSubproceso = desgSubproceso;
	}

	public void setFchaAcceso(String fchaAcceso) {
		this.fchaAcceso = fchaAcceso;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}