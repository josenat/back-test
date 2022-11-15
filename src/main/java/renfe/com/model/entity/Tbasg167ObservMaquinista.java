package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG167_OBSERV_MAQUINISTA")
public class Tbasg167ObservMaquinista {

	@Id
	@Column(name = "CDGO_OBSERVACION")
	private Long cdgoObservacion;

	@Column(name = "CDGO_CENTCONT")
	private Integer cdgoCentcont;

	@Column(name = "DESG_EMAIL")
	private String desgEmail;

	@NotNull
	@Column(name = "DESG_MATRICULA")
	private String desgMatricula;

	@NotNull
	@Column(name = "DESG_OBSERVACION")
	private String desgObservacion;

	@NotNull
	@Column(name = "FCHA_ALTA")
	private Date fchaAlta;

	public Long getCdgoObservacion() {
		return this.cdgoObservacion;
	}

	public void setCdgoObservacion(Long cdgoObservacion) {
		this.cdgoObservacion = cdgoObservacion;
	}

	public Integer getCdgoCentcont() {
		return this.cdgoCentcont;
	}

	public String getDesgEmail() {
		return this.desgEmail;
	}

	public String getDesgMatricula() {
		return this.desgMatricula;
	}

	public String getDesgObservacion() {
		return this.desgObservacion;
	}

	public Date getFchaAlta() {
		return this.fchaAlta;
	}

	public void setCdgoCentcont(Integer cdgoCentcont) {
		this.cdgoCentcont = cdgoCentcont;
	}

	public void setDesgEmail(String desgEmail) {
		this.desgEmail = desgEmail;
	}

	public void setDesgMatricula(String desgMatricula) {
		this.desgMatricula = desgMatricula;
	}

	public void setDesgObservacion(String desgObservacion) {
		this.desgObservacion = desgObservacion;
	}

	public void setFchaAlta(Date fchaAlta) {
		this.fchaAlta = fchaAlta;
	}

}