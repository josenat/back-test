package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG201_ERR_SALUD", schema = "PASG")
public class Tbasg201ErrSalud {

	@Id
	@Column(name = "CDGO_ERROR")
	private Long cdgoError;

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

	@NotNull
	@Column(name = "DESG_ERROR")
	private String desgError;

	@NotNull
	@Column(name = "DESG_FICHERO")
	private String desgFichero;

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

	@NotNull
	@Column(name = "FCHA_ERROR")
	private Date fchaError;

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

	@NotNull
	@Column(name = "MRCA_REPROCESADO")
	private String mrcaReprocesado;

	public Long getCdgoError() {
		return this.cdgoError;
	}

	public void setCdgoError(Long cdgoError) {
		this.cdgoError = cdgoError;
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

	public String getDesgError() {
		return this.desgError;
	}

	public String getDesgFichero() {
		return this.desgFichero;
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

	public Date getFchaError() {
		return this.fchaError;
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

	public String getMrcaReprocesado() {
		return this.mrcaReprocesado;
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

	public void setDesgError(String desgError) {
		this.desgError = desgError;
	}

	public void setDesgFichero(String desgFichero) {
		this.desgFichero = desgFichero;
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

	public void setFchaError(Date fchaError) {
		this.fchaError = fchaError;
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

	public void setMrcaReprocesado(String mrcaReprocesado) {
		this.mrcaReprocesado = mrcaReprocesado;
	}

}