package renfe.com.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG149_FDCONFHAB")
public class Tbasg149Fdconfhab {

	@Id
	@Column(name = "CDGO_FIRMA")
	private Long cdgoFirma;

	@NotNull
	@Column(name = "CDGO_EXPEDIENT")
	private Integer cdgoExpedient;

	@NotNull
	@Column(name = "DESG_TEXTO")
	private String desgTexto;

	@NotNull
	@Column(name = "DESG_TXTENCRIPTADO")
	private String desgTxtencriptado;

	@NotNull
	@Column(name = "DESG_USUARIO")
	private String desgUsuario;

	@NotNull
	@Column(name = "FCHA_FIRMA")
	private String fchaFirma;

	public Long getCdgoFirma() {
		return this.cdgoFirma;
	}

	public void setCdgoFirma(Long cdgoFirma) {
		this.cdgoFirma = cdgoFirma;
	}

	public Integer getCdgoExpedient() {
		return this.cdgoExpedient;
	}

	public String getDesgTexto() {
		return this.desgTexto;
	}

	public String getDesgTxtencriptado() {
		return this.desgTxtencriptado;
	}

	public String getDesgUsuario() {
		return this.desgUsuario;
	}

	public String getFchaFirma() {
		return this.fchaFirma;
	}

	public void setCdgoExpedient(Integer cdgoExpedient) {
		this.cdgoExpedient = cdgoExpedient;
	}

	public void setDesgTexto(String desgTexto) {
		this.desgTexto = desgTexto;
	}

	public void setDesgTxtencriptado(String desgTxtencriptado) {
		this.desgTxtencriptado = desgTxtencriptado;
	}

	public void setDesgUsuario(String desgUsuario) {
		this.desgUsuario = desgUsuario;
	}

	public void setFchaFirma(String fchaFirma) {
		this.fchaFirma = fchaFirma;
	}

}