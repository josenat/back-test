package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG160_GC_CONSULTA")
public class Tbasg160GcConsulta {

	@Id
	@Column(name = "CDGO_CONSULTA")
	private Long cdgoConsulta;

	@Column(name = "DESG_EXPLOGICA")
	private String desgExplogica;

	@NotNull
	@Column(name = "DESG_NOMBRE")
	private String desgNombre;

	@Column(name = "DESG_USUACT")
	private String desgUsuact;

	@NotNull
	@Column(name = "DESG_USUARIO")
	private String desgUsuario;

	@Column(name = "FCHA_ACT")
	private Date fchaAct;

	@Column(name = "MRCA_ACTIVO")
	private String mrcaActivo;

	@NotNull
	@Column(name = "MRCA_CONTAR")
	private String mrcaContar;

	public Long getCdgoConsulta() {
		return this.cdgoConsulta;
	}

	public void setCdgoConsulta(Long cdgoConsulta) {
		this.cdgoConsulta = cdgoConsulta;
	}

	public String getDesgExplogica() {
		return this.desgExplogica;
	}

	public String getDesgNombre() {
		return this.desgNombre;
	}

	public String getDesgUsuact() {
		return this.desgUsuact;
	}

	public String getDesgUsuario() {
		return this.desgUsuario;
	}

	public Date getFchaAct() {
		return this.fchaAct;
	}

	public String getMrcaActivo() {
		return this.mrcaActivo;
	}

	public String getMrcaContar() {
		return this.mrcaContar;
	}

	public void setDesgExplogica(String desgExplogica) {
		this.desgExplogica = desgExplogica;
	}

	public void setDesgNombre(String desgNombre) {
		this.desgNombre = desgNombre;
	}

	public void setDesgUsuact(String desgUsuact) {
		this.desgUsuact = desgUsuact;
	}

	public void setDesgUsuario(String desgUsuario) {
		this.desgUsuario = desgUsuario;
	}

	public void setFchaAct(Date fchaAct) {
		this.fchaAct = fchaAct;
	}

	public void setMrcaActivo(String mrcaActivo) {
		this.mrcaActivo = mrcaActivo;
	}

	public void setMrcaContar(String mrcaContar) {
		this.mrcaContar = mrcaContar;
	}

}