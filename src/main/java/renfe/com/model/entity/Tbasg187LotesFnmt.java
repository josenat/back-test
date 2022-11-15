package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG187_LOTES_FNMT")
public class Tbasg187LotesFnmt {

	@Id
	@Column(name = "CDGO_LOTE")
	private Long cdgoLote;

	@NotNull
	@Column(name = "CDGO_FIN")
	private Integer cdgoFin;

	@NotNull
	@Column(name = "CDGO_INICIO")
	private Integer cdgoInicio;

	@Column(name = "DESG_NOMBREFICH")
	private String desgNombrefich;

	@NotNull
	@Column(name = "FCHA_LOTE")
	private Date fchaLote;

	@Column(name = "MRCA_ERRORES")
	private String mrcaErrores;

	@Column(name = "MRCA_GENERADO")
	private String mrcaGenerado;

	public Long getCdgoLote() {
		return this.cdgoLote;
	}

	public void setCdgoLote(Long cdgoLote) {
		this.cdgoLote = cdgoLote;
	}

	public Integer getCdgoFin() {
		return this.cdgoFin;
	}

	public Integer getCdgoInicio() {
		return this.cdgoInicio;
	}

	public String getDesgNombrefich() {
		return this.desgNombrefich;
	}

	public Date getFchaLote() {
		return this.fchaLote;
	}

	public String getMrcaErrores() {
		return this.mrcaErrores;
	}

	public String getMrcaGenerado() {
		return this.mrcaGenerado;
	}

	public void setCdgoFin(Integer cdgoFin) {
		this.cdgoFin = cdgoFin;
	}

	public void setCdgoInicio(Integer cdgoInicio) {
		this.cdgoInicio = cdgoInicio;
	}

	public void setDesgNombrefich(String desgNombrefich) {
		this.desgNombrefich = desgNombrefich;
	}

	public void setFchaLote(Date fchaLote) {
		this.fchaLote = fchaLote;
	}

	public void setMrcaErrores(String mrcaErrores) {
		this.mrcaErrores = mrcaErrores;
	}

	public void setMrcaGenerado(String mrcaGenerado) {
		this.mrcaGenerado = mrcaGenerado;
	}

}