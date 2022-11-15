package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG161_GC_RESULTADO")
public class Tbasg161GcResultado {

	@EmbeddedId
	private Tbasg161GcResultadoPK tbasg161gcresultadopk;

	@Column(name = "CDGO_CRITORDEN")
	private String cdgoCritorden;

	@NotNull
	@Column(name = "CDGO_ORDEN")
	private Integer cdgoOrden;

	@Column(name = "DESG_USUACT")
	private String desgUsuact;

	@Column(name = "FCHA_ACT")
	private Date fchaAct;

	public Tbasg161GcResultadoPK getTbasg161gcresultadopk() {
		return this.tbasg161gcresultadopk;
	}

	public void setTbasg161gcresultadopk(Tbasg161GcResultadoPK tbasg161gcresultadopk) {
		this.tbasg161gcresultadopk = tbasg161gcresultadopk;
	}

	public String getCdgoCritorden() {
		return this.cdgoCritorden;
	}

	public Integer getCdgoOrden() {
		return this.cdgoOrden;
	}

	public String getDesgUsuact() {
		return this.desgUsuact;
	}

	public Date getFchaAct() {
		return this.fchaAct;
	}

	public void setCdgoCritorden(String cdgoCritorden) {
		this.cdgoCritorden = cdgoCritorden;
	}

	public void setCdgoOrden(Integer cdgoOrden) {
		this.cdgoOrden = cdgoOrden;
	}

	public void setDesgUsuact(String desgUsuact) {
		this.desgUsuact = desgUsuact;
	}

	public void setFchaAct(Date fchaAct) {
		this.fchaAct = fchaAct;
	}

}