package renfe.com.model.entity;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@AttributeOverrides({ @AttributeOverride(name = "cdgoCategoria", column = @Column(name = "CDGO_CATEGORIA")),
		@AttributeOverride(name = "cdgoConcepto", column = @Column(name = "CDGO_CONCEPTO")),
		@AttributeOverride(name = "cdgoConsulta", column = @Column(name = "CDGO_CONSULTA")) })
public class Tbasg161GcResultadoPK implements Serializable {

	private static final long serialVersionUID = 1L;

	private String cdgoCategoria;
	private String cdgoConcepto;
	private Integer cdgoConsulta;

	public String getCdgoCategoria() {
		return this.cdgoCategoria;
	}

	public String getCdgoConcepto() {
		return this.cdgoConcepto;
	}

	public Integer getCdgoConsulta() {
		return this.cdgoConsulta;
	}

	public void setCdgoCategoria(String cdgoCategoria) {
		this.cdgoCategoria = cdgoCategoria;
	}

	public void setCdgoConcepto(String cdgoConcepto) {
		this.cdgoConcepto = cdgoConcepto;
	}

	public void setCdgoConsulta(Integer cdgoConsulta) {
		this.cdgoConsulta = cdgoConsulta;
	}

}