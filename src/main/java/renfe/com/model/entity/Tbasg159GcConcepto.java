package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG159_GC_CONCEPTO")
public class Tbasg159GcConcepto {

	@EmbeddedId
	private Tbasg159GcConceptoPK tbasg159gcconceptopk;

	@Column(name = "CDGO_DATOSLONG")
	private Integer cdgoDatoslong;

	@NotNull
	@Column(name = "CDGO_ORDEN")
	private Integer cdgoOrden;

	@NotNull
	@Column(name = "DESG_NOMBRE")
	private String desgNombre;

	@NotNull
	@Column(name = "DESG_TIPOFILTRO")
	private String desgTipofiltro;

	@Column(name = "DESG_USUACT")
	private String desgUsuact;

	@Column(name = "FCHA_ACT")
	private Date fchaAct;

	@Column(name = "MRCA_ACTIVO")
	private String mrcaActivo;

	@NotNull
	@Column(name = "MUESTRA_CONCEPTO")
	private String muestraConcepto;

	public Tbasg159GcConceptoPK getTbasg159gcconceptopk() {
		return this.tbasg159gcconceptopk;
	}

	public void setTbasg159gcconceptopk(Tbasg159GcConceptoPK tbasg159gcconceptopk) {
		this.tbasg159gcconceptopk = tbasg159gcconceptopk;
	}

	public Integer getCdgoDatoslong() {
		return this.cdgoDatoslong;
	}

	public Integer getCdgoOrden() {
		return this.cdgoOrden;
	}

	public String getDesgNombre() {
		return this.desgNombre;
	}

	public String getDesgTipofiltro() {
		return this.desgTipofiltro;
	}

	public String getDesgUsuact() {
		return this.desgUsuact;
	}

	public Date getFchaAct() {
		return this.fchaAct;
	}

	public String getMrcaActivo() {
		return this.mrcaActivo;
	}

	public String getMuestraConcepto() {
		return this.muestraConcepto;
	}

	public void setCdgoDatoslong(Integer cdgoDatoslong) {
		this.cdgoDatoslong = cdgoDatoslong;
	}

	public void setCdgoOrden(Integer cdgoOrden) {
		this.cdgoOrden = cdgoOrden;
	}

	public void setDesgNombre(String desgNombre) {
		this.desgNombre = desgNombre;
	}

	public void setDesgTipofiltro(String desgTipofiltro) {
		this.desgTipofiltro = desgTipofiltro;
	}

	public void setDesgUsuact(String desgUsuact) {
		this.desgUsuact = desgUsuact;
	}

	public void setFchaAct(Date fchaAct) {
		this.fchaAct = fchaAct;
	}

	public void setMrcaActivo(String mrcaActivo) {
		this.mrcaActivo = mrcaActivo;
	}

	public void setMuestraConcepto(String muestraConcepto) {
		this.muestraConcepto = muestraConcepto;
	}

}