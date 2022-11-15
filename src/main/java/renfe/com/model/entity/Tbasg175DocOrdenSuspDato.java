package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG175_DOC_ORDEN_SUSP_DATO")
public class Tbasg175DocOrdenSuspDato {

	@EmbeddedId
	private Tbasg175DocOrdenSuspDatoPK tbasg175docordensuspdatopk;

	@Column(name = "DESG_USUACT")
	private String desgUsuact;

	@NotNull
	@Column(name = "DESG_VALOR")
	private String desgValor;

	@Column(name = "FCHA_ACT")
	private Date fchaAct;

	@Column(name = "MRCA_ACTIVO")
	private String mrcaActivo;

	public Tbasg175DocOrdenSuspDatoPK getTbasg175docordensuspdatopk() {
		return this.tbasg175docordensuspdatopk;
	}

	public void setTbasg175docordensuspdatopk(Tbasg175DocOrdenSuspDatoPK tbasg175docordensuspdatopk) {
		this.tbasg175docordensuspdatopk = tbasg175docordensuspdatopk;
	}

	public String getDesgUsuact() {
		return this.desgUsuact;
	}

	public String getDesgValor() {
		return this.desgValor;
	}

	public Date getFchaAct() {
		return this.fchaAct;
	}

	public String getMrcaActivo() {
		return this.mrcaActivo;
	}

	public void setDesgUsuact(String desgUsuact) {
		this.desgUsuact = desgUsuact;
	}

	public void setDesgValor(String desgValor) {
		this.desgValor = desgValor;
	}

	public void setFchaAct(Date fchaAct) {
		this.fchaAct = fchaAct;
	}

	public void setMrcaActivo(String mrcaActivo) {
		this.mrcaActivo = mrcaActivo;
	}

}