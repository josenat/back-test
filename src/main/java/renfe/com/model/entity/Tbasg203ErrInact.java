package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG203_ERR_INACT", schema = "PASG")
public class Tbasg203ErrInact {

	@Id
	@Column(name = "CDGO_ERROR")
	private Long cdgoError;

	@NotNull
	@Column(name = "DESG_ERROR")
	private String desgError;

	@NotNull
	@Column(name = "DESG_FICHERO")
	private String desgFichero;

	@Column(name = "DESG_MATRICULA")
	private String desgMatricula;

	@Column(name = "DESG_MEDIDABAJA")
	private String desgMedidabaja;

	@Column(name = "FCHA_BAJA")
	private Date fchaBaja;

	@NotNull
	@Column(name = "FCHA_ERROR")
	private Date fchaError;

	@NotNull
	@Column(name = "MRCA_REPROCESADO")
	private String mrcaReprocesado;

	public Long getCdgoError() {
		return this.cdgoError;
	}

	public void setCdgoError(Long cdgoError) {
		this.cdgoError = cdgoError;
	}

	public String getDesgError() {
		return this.desgError;
	}

	public String getDesgFichero() {
		return this.desgFichero;
	}

	public String getDesgMatricula() {
		return this.desgMatricula;
	}

	public String getDesgMedidabaja() {
		return this.desgMedidabaja;
	}

	public Date getFchaBaja() {
		return this.fchaBaja;
	}

	public Date getFchaError() {
		return this.fchaError;
	}

	public String getMrcaReprocesado() {
		return this.mrcaReprocesado;
	}

	public void setDesgError(String desgError) {
		this.desgError = desgError;
	}

	public void setDesgFichero(String desgFichero) {
		this.desgFichero = desgFichero;
	}

	public void setDesgMatricula(String desgMatricula) {
		this.desgMatricula = desgMatricula;
	}

	public void setDesgMedidabaja(String desgMedidabaja) {
		this.desgMedidabaja = desgMedidabaja;
	}

	public void setFchaBaja(Date fchaBaja) {
		this.fchaBaja = fchaBaja;
	}

	public void setFchaError(Date fchaError) {
		this.fchaError = fchaError;
	}

	public void setMrcaReprocesado(String mrcaReprocesado) {
		this.mrcaReprocesado = mrcaReprocesado;
	}

}