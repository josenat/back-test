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
@Table(name = "TBASG206_REP_ERR_SALUD", schema = "PASG")
public class Tbasg206RepErrSalud {

	@Id
	@Column(name = "CDGO_REPROCESADO")
	private Long cdgoReprocesado;

	@Column(name = "DESG_AMBITOVALCERT")
	private String desgAmbitovalcert;

	@Column(name = "DESG_APELL1")
	private String desgApell1;

	@Column(name = "DESG_APELL1FACULT")
	private String desgApell1Facult;

	@Column(name = "DESG_APELL2")
	private String desgApell2;

	@Column(name = "DESG_APELL2FACULT")
	private String desgApell2Facult;

	@Column(name = "DESG_CALIFIC")
	private String desgCalific;

	@Column(name = "DESG_CENTROMED")
	private String desgCentromed;

	@Column(name = "DESG_MATRICULA")
	private String desgMatricula;

	@Column(name = "DESG_MOTIVOREV")
	private String desgMotivorev;

	@Column(name = "DESG_NIFPAS")
	private String desgNifpas;

	@Column(name = "DESG_NOMBRE")
	private String desgNombre;

	@Column(name = "DESG_NOMBREFACULT")
	private String desgNombrefacult;

	@Column(name = "DESG_NUMCOLEGIADO")
	private String desgNumcolegiado;

	@Column(name = "DESG_USUACT")
	private String desgUsuact;

	@Column(name = "FCHA_ACT")
	private Date fchaAct;

	@Column(name = "FCHA_PROXREV")
	private Date fchaProxrev;

	@Column(name = "FCHA_RECONOC")
	private Date fchaReconoc;

	@Column(name = "FCHA_VALIDEZCERT")
	private Date fchaValidezcert;

	@Column(name = "MRCA_CORRECVISU")
	private String mrcaCorrecvisu;

	@Column(name = "MRCA_PROTEAUDI")
	private String mrcaProteaudi;

	/*@ManyToOne
	@JoinColumn(name = "CDGO_ERROR", nullable = true, foreignKey = @ForeignKey(name = "CDGO$ERR"))
	private Tbasg201ErrSalud cdgoError;*/
	
	@Column(name = "CDGO_ERROR")
	private Integer cdgoError;

	public Long getCdgoReprocesado() {
		return this.cdgoReprocesado;
	}

	public void setCdgoReprocesado(Long cdgoReprocesado) {
		this.cdgoReprocesado = cdgoReprocesado;
	}

	public String getDesgAmbitovalcert() {
		return this.desgAmbitovalcert;
	}

	public String getDesgApell1() {
		return this.desgApell1;
	}

	public String getDesgApell1Facult() {
		return this.desgApell1Facult;
	}

	public String getDesgApell2() {
		return this.desgApell2;
	}

	public String getDesgApell2Facult() {
		return this.desgApell2Facult;
	}

	public String getDesgCalific() {
		return this.desgCalific;
	}

	public String getDesgCentromed() {
		return this.desgCentromed;
	}

	public String getDesgMatricula() {
		return this.desgMatricula;
	}

	public String getDesgMotivorev() {
		return this.desgMotivorev;
	}

	public String getDesgNifpas() {
		return this.desgNifpas;
	}

	public String getDesgNombre() {
		return this.desgNombre;
	}

	public String getDesgNombrefacult() {
		return this.desgNombrefacult;
	}

	public String getDesgNumcolegiado() {
		return this.desgNumcolegiado;
	}

	public String getDesgUsuact() {
		return this.desgUsuact;
	}

	public Date getFchaAct() {
		return this.fchaAct;
	}

	public Date getFchaProxrev() {
		return this.fchaProxrev;
	}

	public Date getFchaReconoc() {
		return this.fchaReconoc;
	}

	public Date getFchaValidezcert() {
		return this.fchaValidezcert;
	}

	public String getMrcaCorrecvisu() {
		return this.mrcaCorrecvisu;
	}

	public String getMrcaProteaudi() {
		return this.mrcaProteaudi;
	}

	public void setDesgAmbitovalcert(String desgAmbitovalcert) {
		this.desgAmbitovalcert = desgAmbitovalcert;
	}

	public void setDesgApell1(String desgApell1) {
		this.desgApell1 = desgApell1;
	}

	public void setDesgApell1Facult(String desgApell1Facult) {
		this.desgApell1Facult = desgApell1Facult;
	}

	public void setDesgApell2(String desgApell2) {
		this.desgApell2 = desgApell2;
	}

	public void setDesgApell2Facult(String desgApell2Facult) {
		this.desgApell2Facult = desgApell2Facult;
	}

	public void setDesgCalific(String desgCalific) {
		this.desgCalific = desgCalific;
	}

	public void setDesgCentromed(String desgCentromed) {
		this.desgCentromed = desgCentromed;
	}

	public void setDesgMatricula(String desgMatricula) {
		this.desgMatricula = desgMatricula;
	}

	public void setDesgMotivorev(String desgMotivorev) {
		this.desgMotivorev = desgMotivorev;
	}

	public void setDesgNifpas(String desgNifpas) {
		this.desgNifpas = desgNifpas;
	}

	public void setDesgNombre(String desgNombre) {
		this.desgNombre = desgNombre;
	}

	public void setDesgNombrefacult(String desgNombrefacult) {
		this.desgNombrefacult = desgNombrefacult;
	}

	public void setDesgNumcolegiado(String desgNumcolegiado) {
		this.desgNumcolegiado = desgNumcolegiado;
	}

	public void setDesgUsuact(String desgUsuact) {
		this.desgUsuact = desgUsuact;
	}

	public void setFchaAct(Date fchaAct) {
		this.fchaAct = fchaAct;
	}

	public void setFchaProxrev(Date fchaProxrev) {
		this.fchaProxrev = fchaProxrev;
	}

	public void setFchaReconoc(Date fchaReconoc) {
		this.fchaReconoc = fchaReconoc;
	}

	public void setFchaValidezcert(Date fchaValidezcert) {
		this.fchaValidezcert = fchaValidezcert;
	}

	public void setMrcaCorrecvisu(String mrcaCorrecvisu) {
		this.mrcaCorrecvisu = mrcaCorrecvisu;
	}

	public void setMrcaProteaudi(String mrcaProteaudi) {
		this.mrcaProteaudi = mrcaProteaudi;
	}

	public Integer getCdgoError() {
		return cdgoError;
	}

	public void setCdgoError(Integer cdgoError) {
		this.cdgoError = cdgoError;
	}

}