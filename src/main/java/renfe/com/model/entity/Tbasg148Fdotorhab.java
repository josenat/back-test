package renfe.com.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG148_FDOTORHAB")
public class Tbasg148Fdotorhab {

	@Id
	@Column(name = "CDGO_FIRMA")
	private Long cdgoFirma;

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

	@ManyToOne
	@JoinColumn(name = "CDGO_EXPEDIENT", nullable = false, foreignKey = @ForeignKey(name = "CDGO$EXP"))
	private Tbasg104Expedient cdgoExpedient;

	public Long getCdgoFirma() {
		return this.cdgoFirma;
	}

	public void setCdgoFirma(Long cdgoFirma) {
		this.cdgoFirma = cdgoFirma;
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

	public Tbasg104Expedient getCdgoExpedient() {
		return this.cdgoExpedient;
	}

	public void setCdgoExpedient(Tbasg104Expedient cdgoExpedient) {
		this.cdgoExpedient = cdgoExpedient;
	}

}