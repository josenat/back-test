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
@Table(name = "TBASG163_GC_FILTRO_TRAMO")
public class Tbasg163GcFiltroTramo {

	@Id
	@Column(name = "CDGO_FILTRO_TRAMO")
	private Long cdgoFiltroTramo;

	@NotNull
	@Column(name = "CDGO_DESTINO")
	private String cdgoDestino;

	@NotNull
	@Column(name = "CDGO_LINEA")
	private String cdgoLinea;

	@NotNull
	@Column(name = "CDGO_ORIGEN")
	private String cdgoOrigen;

	@Column(name = "DESG_USUACT")
	private String desgUsuact;

	@Column(name = "FCHA_ACT")
	private Date fchaAct;

	@ManyToOne
	@JoinColumn(name = "CDGO_FILTRO", nullable = false, foreignKey = @ForeignKey(name = "CDGO$FIL"))
	private Tbasg162GcFiltro cdgoFiltro;

	public Long getCdgoFiltroTramo() {
		return this.cdgoFiltroTramo;
	}

	public void setCdgoFiltroTramo(Long cdgoFiltroTramo) {
		this.cdgoFiltroTramo = cdgoFiltroTramo;
	}

	public String getCdgoDestino() {
		return this.cdgoDestino;
	}

	public String getCdgoLinea() {
		return this.cdgoLinea;
	}

	public String getCdgoOrigen() {
		return this.cdgoOrigen;
	}

	public String getDesgUsuact() {
		return this.desgUsuact;
	}

	public Date getFchaAct() {
		return this.fchaAct;
	}

	public void setCdgoDestino(String cdgoDestino) {
		this.cdgoDestino = cdgoDestino;
	}

	public void setCdgoLinea(String cdgoLinea) {
		this.cdgoLinea = cdgoLinea;
	}

	public void setCdgoOrigen(String cdgoOrigen) {
		this.cdgoOrigen = cdgoOrigen;
	}

	public void setDesgUsuact(String desgUsuact) {
		this.desgUsuact = desgUsuact;
	}

	public void setFchaAct(Date fchaAct) {
		this.fchaAct = fchaAct;
	}

	public Tbasg162GcFiltro getCdgoFiltro() {
		return this.cdgoFiltro;
	}

	public void setCdgoFiltro(Tbasg162GcFiltro cdgoFiltro) {
		this.cdgoFiltro = cdgoFiltro;
	}

}