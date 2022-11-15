package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG280_MARCA_GMM")
public class Tbasg280MarcaGmm {

	@EmbeddedId
	private Tbasg280MarcaGmmPK tbasg280marcagmmpk;

	@NotNull
	@Column(name = "DESG_USUACT")
	private String desgUsuact;

	@Column(name = "FCHA_GRABADO_GMM")
	private Date fchaGrabadoGmm;

	@NotNull
	@Column(name = "MRCA_ESTADO")
	private String mrcaEstado;

	@NotNull
	@Column(name = "MRCA_GRABADO_GMM")
	private String mrcaGrabadoGmm;

	public Tbasg280MarcaGmmPK getTbasg280marcagmmpk() {
		return this.tbasg280marcagmmpk;
	}

	public void setTbasg280marcagmmpk(Tbasg280MarcaGmmPK tbasg280marcagmmpk) {
		this.tbasg280marcagmmpk = tbasg280marcagmmpk;
	}

	public String getDesgUsuact() {
		return this.desgUsuact;
	}

	public Date getFchaGrabadoGmm() {
		return this.fchaGrabadoGmm;
	}

	public String getMrcaEstado() {
		return this.mrcaEstado;
	}

	public String getMrcaGrabadoGmm() {
		return this.mrcaGrabadoGmm;
	}

	public void setDesgUsuact(String desgUsuact) {
		this.desgUsuact = desgUsuact;
	}

	public void setFchaGrabadoGmm(Date fchaGrabadoGmm) {
		this.fchaGrabadoGmm = fchaGrabadoGmm;
	}

	public void setMrcaEstado(String mrcaEstado) {
		this.mrcaEstado = mrcaEstado;
	}

	public void setMrcaGrabadoGmm(String mrcaGrabadoGmm) {
		this.mrcaGrabadoGmm = mrcaGrabadoGmm;
	}

}