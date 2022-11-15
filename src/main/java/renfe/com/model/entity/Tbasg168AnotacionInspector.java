package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG168_ANOTACION_INSPECTOR")
public class Tbasg168AnotacionInspector {

	@Id
	@Column(name = "CDGO_ANOTACION")
	private Long cdgoAnotacion;

	@NotNull
	@Column(name = "CDGO_PERSONA")
	private Integer cdgoPersona;

	@NotNull
	@Column(name = "DESG_ANOTACION")
	private String desgAnotacion;

	@NotNull
	@Column(name = "DESG_USUARIO")
	private String desgUsuario;

	@NotNull
	@Column(name = "FCHA_ALTA")
	private Date fchaAlta;

	@ManyToOne
	@JoinColumn(name = "CDGO_TIPOANOTACION", nullable = false, foreignKey = @ForeignKey(name = "CDGO$TIP"))
	private Tbasg169TipoAnotacion cdgoTipoanotacion;

	public Long getCdgoAnotacion() {
		return this.cdgoAnotacion;
	}

	public void setCdgoAnotacion(Long cdgoAnotacion) {
		this.cdgoAnotacion = cdgoAnotacion;
	}

	public Integer getCdgoPersona() {
		return this.cdgoPersona;
	}

	public String getDesgAnotacion() {
		return this.desgAnotacion;
	}

	public String getDesgUsuario() {
		return this.desgUsuario;
	}

	public Date getFchaAlta() {
		return this.fchaAlta;
	}

	public void setCdgoPersona(Integer cdgoPersona) {
		this.cdgoPersona = cdgoPersona;
	}

	public void setDesgAnotacion(String desgAnotacion) {
		this.desgAnotacion = desgAnotacion;
	}

	public void setDesgUsuario(String desgUsuario) {
		this.desgUsuario = desgUsuario;
	}

	public void setFchaAlta(Date fchaAlta) {
		this.fchaAlta = fchaAlta;
	}

	public Tbasg169TipoAnotacion getCdgoTipoanotacion() {
		return this.cdgoTipoanotacion;
	}

	public void setCdgoTipoanotacion(Tbasg169TipoAnotacion cdgoTipoanotacion) {
		this.cdgoTipoanotacion = cdgoTipoanotacion;
	}

}