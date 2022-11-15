package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG198_ALCAFORMA", schema = "PASG")
public class Tbasg198Alcaforma {

	@EmbeddedId
	private Tbasg198AlcaformaPK tbasg198alcaformapk;

	@NotNull
	@Column(name = "DESG_DESTINO")
	private String desgDestino;

	@NotNull
	@Column(name = "DESG_LINEA")
	private String desgLinea;

	@NotNull
	@Column(name = "DESG_ORIGEN")
	private String desgOrigen;

	@Column(name = "DESG_USUACT")
	private String desgUsuact;

	@Column(name = "FCHA_ACT")
	private Date fchaAct;

	@ManyToOne
	@JoinColumn(name = "CDGO_ESTADO", nullable = false, foreignKey = @ForeignKey(name = "CDGO$EST"))
	private Tbasg116Estados cdgoEstado;

	public Tbasg198AlcaformaPK getTbasg198alcaformapk() {
		return this.tbasg198alcaformapk;
	}

	public void setTbasg198alcaformapk(Tbasg198AlcaformaPK tbasg198alcaformapk) {
		this.tbasg198alcaformapk = tbasg198alcaformapk;
	}

	public String getDesgDestino() {
		return this.desgDestino;
	}

	public String getDesgLinea() {
		return this.desgLinea;
	}

	public String getDesgOrigen() {
		return this.desgOrigen;
	}

	public String getDesgUsuact() {
		return this.desgUsuact;
	}

	public Date getFchaAct() {
		return this.fchaAct;
	}

	public void setDesgDestino(String desgDestino) {
		this.desgDestino = desgDestino;
	}

	public void setDesgLinea(String desgLinea) {
		this.desgLinea = desgLinea;
	}

	public void setDesgOrigen(String desgOrigen) {
		this.desgOrigen = desgOrigen;
	}

	public void setDesgUsuact(String desgUsuact) {
		this.desgUsuact = desgUsuact;
	}

	public void setFchaAct(Date fchaAct) {
		this.fchaAct = fchaAct;
	}

	public Tbasg116Estados getCdgoEstado() {
		return this.cdgoEstado;
	}

	public void setCdgoEstado(Tbasg116Estados cdgoEstado) {
		this.cdgoEstado = cdgoEstado;
	}

}