package renfe.com.model.entity;



import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TBASG208_REP_ERR_INACT", schema = "PASG")
public class Tbasg208RepErrInact {

	@Id
	@Column(name = "CDGO_REPROCESADO")
	private Long cdgoReprocesado;

	@Column(name = "DESG_MATRICULA")
	private String desgMatricula;

	@Column(name = "DESG_MEDIDABAJA")
	private String desgMedidabaja;

	@Column(name = "DESG_USUACT")
	private String desgUsuact;

	@Column(name = "FCHA_ACT")
	private Date fchaAct;

	@Column(name = "FCHA_BAJA")
	private Date fchaBaja;

	/*@ManyToOne
	@JoinColumn(name = "CDGO_ERROR", nullable = true, foreignKey = @ForeignKey(name = "CDGO$ERR"))
	private Tbasg203ErrInact cdgoError;*/
	
	@Column(name = "CDGO_ERROR")
	private Integer cdgoError;

	public Long getCdgoReprocesado() {
		return this.cdgoReprocesado;
	}

	public void setCdgoReprocesado(Long cdgoReprocesado) {
		this.cdgoReprocesado = cdgoReprocesado;
	}

	public String getDesgMatricula() {
		return this.desgMatricula;
	}

	public String getDesgMedidabaja() {
		return this.desgMedidabaja;
	}

	public String getDesgUsuact() {
		return this.desgUsuact;
	}

	public Date getFchaAct() {
		return this.fchaAct;
	}

	public Date getFchaBaja() {
		return this.fchaBaja;
	}

	public void setDesgMatricula(String desgMatricula) {
		this.desgMatricula = desgMatricula;
	}

	public void setDesgMedidabaja(String desgMedidabaja) {
		this.desgMedidabaja = desgMedidabaja;
	}

	public void setDesgUsuact(String desgUsuact) {
		this.desgUsuact = desgUsuact;
	}

	public void setFchaAct(Date fchaAct) {
		this.fchaAct = fchaAct;
	}

	public void setFchaBaja(Date fchaBaja) {
		this.fchaBaja = fchaBaja;
	}

	public Integer getCdgoError() {
		return this.cdgoError;
	}

	public void setCdgoError(Integer cdgoError) {
		this.cdgoError = cdgoError;
	}

}