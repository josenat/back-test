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
@Table(name = "TBASG162_GC_FILTRO")
public class Tbasg162GcFiltro {

	@Id
	@Column(name = "CDGO_FILTRO")
	private Long cdgoFiltro;

	@NotNull
	@Column(name = "CDGO_ORDEN")
	private Integer cdgoOrden;

	@Column(name = "DESG_OPERADOR")
	private String desgOperador;

	@Column(name = "DESG_TIPOCONJUNCION")
	private String desgTipoconjuncion;

	@Column(name = "DESG_USUACT")
	private String desgUsuact;

	@Column(name = "DESG_VALOR1")
	private String desgValor1;

	@Column(name = "DESG_VALOR2")
	private String desgValor2;

	@Column(name = "FCHA_ACT")
	private Date fchaAct;

	@NotNull
	@Column(name = "MRCA_NEGACION")
	private String mrcaNegacion;

	@ManyToOne
	@JoinColumn(name = "CDGO_CATEGORIA", nullable = false, foreignKey = @ForeignKey(name = "CDGO$CAT"), insertable=false, updatable=false)
	private Tbasg158GcCategoria cdgoCategoria;

	@ManyToOne
	@JoinColumn(name = "CDGO_CATEGORIA", nullable = false, foreignKey = @ForeignKey(name = "CDGO$CON"))
	@JoinColumn(name = "CDGO_CONCEPTO", nullable = false, foreignKey = @ForeignKey(name = "CDGO$CON"))
	private Tbasg159GcConcepto cdgoConcepto;

	@ManyToOne
	@JoinColumn(name = "CDGO_CONSULTA", nullable = false, foreignKey = @ForeignKey(name = "CDGO1GAX"))
	private Tbasg160GcConsulta cdgoConsulta;

	public Long getCdgoFiltro() {
		return this.cdgoFiltro;
	}

	public void setCdgoFiltro(Long cdgoFiltro) {
		this.cdgoFiltro = cdgoFiltro;
	}

	public Integer getCdgoOrden() {
		return this.cdgoOrden;
	}

	public String getDesgOperador() {
		return this.desgOperador;
	}

	public String getDesgTipoconjuncion() {
		return this.desgTipoconjuncion;
	}

	public String getDesgUsuact() {
		return this.desgUsuact;
	}

	public String getDesgValor1() {
		return this.desgValor1;
	}

	public String getDesgValor2() {
		return this.desgValor2;
	}

	public Date getFchaAct() {
		return this.fchaAct;
	}

	public String getMrcaNegacion() {
		return this.mrcaNegacion;
	}

	public void setCdgoOrden(Integer cdgoOrden) {
		this.cdgoOrden = cdgoOrden;
	}

	public void setDesgOperador(String desgOperador) {
		this.desgOperador = desgOperador;
	}

	public void setDesgTipoconjuncion(String desgTipoconjuncion) {
		this.desgTipoconjuncion = desgTipoconjuncion;
	}

	public void setDesgUsuact(String desgUsuact) {
		this.desgUsuact = desgUsuact;
	}

	public void setDesgValor1(String desgValor1) {
		this.desgValor1 = desgValor1;
	}

	public void setDesgValor2(String desgValor2) {
		this.desgValor2 = desgValor2;
	}

	public void setFchaAct(Date fchaAct) {
		this.fchaAct = fchaAct;
	}

	public void setMrcaNegacion(String mrcaNegacion) {
		this.mrcaNegacion = mrcaNegacion;
	}

	public Tbasg158GcCategoria getCdgoCategoria() {
		return this.cdgoCategoria;
	}

	public String getCdgoConcepto() {
		return this.cdgoConcepto.getTbasg159gcconceptopk().getCdgoConcepto();
	}
	
	public String getCdgoConceptoCategoria() {
		return this.cdgoConcepto.getTbasg159gcconceptopk().getCdgoCategoria();
	}

	public Tbasg160GcConsulta getCdgoConsulta() {
		return this.cdgoConsulta;
	}

	public void setCdgoCategoria(Tbasg158GcCategoria cdgoCategoria) {
		this.cdgoCategoria = cdgoCategoria;
	}

	public void setCdgoConcepto(String cdgoConcepto) {
		this.cdgoConcepto.getTbasg159gcconceptopk().setCdgoConcepto(cdgoConcepto);
	}
	
	public void setCdgoConceptoCategoria(String cdgoConceptoCategoria) {
		this.cdgoConcepto.getTbasg159gcconceptopk().setCdgoCategoria(desgOperador);
	}

	public void setCdgoConsulta(Tbasg160GcConsulta cdgoConsulta) {
		this.cdgoConsulta = cdgoConsulta;
	}

}