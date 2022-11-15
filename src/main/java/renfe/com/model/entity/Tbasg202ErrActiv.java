package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG202_ERR_ACTIV")
public class Tbasg202ErrActiv {

	@Id
	@Column(name = "CDGO_ERROR")
	private Long cdgoError;

	@Column(name = "CDGO_CATEGORIA")
	private String cdgoCategoria;

	@Column(name = "CDGO_CTROCOSTE")
	private String cdgoCtrocoste;

	@Column(name = "CDGO_DIVISION")
	private String cdgoDivision;

	@Column(name = "CDGO_PAISDIR")
	private String cdgoPaisdir;

	@Column(name = "CDGO_PAISNAC")
	private String cdgoPaisnac;

	@Column(name = "CDGO_POSTAL")
	private String cdgoPostal;

	@Column(name = "CDGO_PROVINCIA")
	private Integer cdgoProvincia;

	@Column(name = "CDGO_RESIDENCIA")
	private String cdgoResidencia;

	@Column(name = "CDGO_TIPOID")
	private Integer cdgoTipoid;

	@Column(name = "CDGO_TIPOVIA")
	private String cdgoTipovia;

	@Column(name = "DESG_APELLIDO1")
	private String desgApellido1;

	@Column(name = "DESG_APELLIDO2")
	private String desgApellido2;

	@Column(name = "DESG_AUXILIAR")
	private String desgAuxiliar;

	@Column(name = "DESG_CATEGORIA")
	private String desgCategoria;

	@Column(name = "DESG_DIVISION")
	private String desgDivision;

	@NotNull
	@Column(name = "DESG_ERROR")
	private String desgError;

	@NotNull
	@Column(name = "DESG_FICHERO")
	private String desgFichero;

	@Column(name = "DESG_ID")
	private String desgId;

	@Column(name = "DESG_MATRICULA")
	private String desgMatricula;

	@Column(name = "DESG_MUNICIPIO")
	private String desgMunicipio;

	@Column(name = "DESG_NACIONALIDAD")
	private String desgNacionalidad;

	@Column(name = "DESG_NOMBRE")
	private String desgNombre;

	@Column(name = "DESG_NOMBREVIA")
	private String desgNombrevia;

	@Column(name = "DESG_NUMERO")
	private String desgNumero;

	@Column(name = "DESG_PLANTA")
	private String desgPlanta;

	@Column(name = "DESG_PROVINCIA")
	private String desgProvincia;

	@Column(name = "DESG_PUERTA")
	private String desgPuerta;

	@Column(name = "DESG_RESIDENCIA")
	private String desgResidencia;

	@Column(name = "DESG_UNIDADPRESUP")
	private String desgUnidadpresup;

	@Column(name = "FCHA_ANTIG_CARGO")
	private Date fchaAntigCargo;

	@NotNull
	@Column(name = "FCHA_ERROR")
	private Date fchaError;

	@Column(name = "FCHA_INGRESO")
	private Date fchaIngreso;

	@Column(name = "FCHA_NAC")
	private Date fchaNac;

	@NotNull
	@Column(name = "MRCA_REPROCESADO")
	private String mrcaReprocesado;

	public Long getCdgoError() {
		return this.cdgoError;
	}

	public void setCdgoError(Long cdgoError) {
		this.cdgoError = cdgoError;
	}

	public String getCdgoCategoria() {
		return this.cdgoCategoria;
	}

	public String getCdgoCtrocoste() {
		return this.cdgoCtrocoste;
	}

	public String getCdgoDivision() {
		return this.cdgoDivision;
	}

	public String getCdgoPaisdir() {
		return this.cdgoPaisdir;
	}

	public String getCdgoPaisnac() {
		return this.cdgoPaisnac;
	}

	public String getCdgoPostal() {
		return this.cdgoPostal;
	}

	public Integer getCdgoProvincia() {
		return this.cdgoProvincia;
	}

	public String getCdgoResidencia() {
		return this.cdgoResidencia;
	}

	public Integer getCdgoTipoid() {
		return this.cdgoTipoid;
	}

	public String getCdgoTipovia() {
		return this.cdgoTipovia;
	}

	public String getDesgApellido1() {
		return this.desgApellido1;
	}

	public String getDesgApellido2() {
		return this.desgApellido2;
	}

	public String getDesgAuxiliar() {
		return this.desgAuxiliar;
	}

	public String getDesgCategoria() {
		return this.desgCategoria;
	}

	public String getDesgDivision() {
		return this.desgDivision;
	}

	public String getDesgError() {
		return this.desgError;
	}

	public String getDesgFichero() {
		return this.desgFichero;
	}

	public String getDesgId() {
		return this.desgId;
	}

	public String getDesgMatricula() {
		return this.desgMatricula;
	}

	public String getDesgMunicipio() {
		return this.desgMunicipio;
	}

	public String getDesgNacionalidad() {
		return this.desgNacionalidad;
	}

	public String getDesgNombre() {
		return this.desgNombre;
	}

	public String getDesgNombrevia() {
		return this.desgNombrevia;
	}

	public String getDesgNumero() {
		return this.desgNumero;
	}

	public String getDesgPlanta() {
		return this.desgPlanta;
	}

	public String getDesgProvincia() {
		return this.desgProvincia;
	}

	public String getDesgPuerta() {
		return this.desgPuerta;
	}

	public String getDesgResidencia() {
		return this.desgResidencia;
	}

	public String getDesgUnidadpresup() {
		return this.desgUnidadpresup;
	}

	public Date getFchaAntigCargo() {
		return this.fchaAntigCargo;
	}

	public Date getFchaError() {
		return this.fchaError;
	}

	public Date getFchaIngreso() {
		return this.fchaIngreso;
	}

	public Date getFchaNac() {
		return this.fchaNac;
	}

	public String getMrcaReprocesado() {
		return this.mrcaReprocesado;
	}

	public void setCdgoCategoria(String cdgoCategoria) {
		this.cdgoCategoria = cdgoCategoria;
	}

	public void setCdgoCtrocoste(String cdgoCtrocoste) {
		this.cdgoCtrocoste = cdgoCtrocoste;
	}

	public void setCdgoDivision(String cdgoDivision) {
		this.cdgoDivision = cdgoDivision;
	}

	public void setCdgoPaisdir(String cdgoPaisdir) {
		this.cdgoPaisdir = cdgoPaisdir;
	}

	public void setCdgoPaisnac(String cdgoPaisnac) {
		this.cdgoPaisnac = cdgoPaisnac;
	}

	public void setCdgoPostal(String cdgoPostal) {
		this.cdgoPostal = cdgoPostal;
	}

	public void setCdgoProvincia(Integer cdgoProvincia) {
		this.cdgoProvincia = cdgoProvincia;
	}

	public void setCdgoResidencia(String cdgoResidencia) {
		this.cdgoResidencia = cdgoResidencia;
	}

	public void setCdgoTipoid(Integer cdgoTipoid) {
		this.cdgoTipoid = cdgoTipoid;
	}

	public void setCdgoTipovia(String cdgoTipovia) {
		this.cdgoTipovia = cdgoTipovia;
	}

	public void setDesgApellido1(String desgApellido1) {
		this.desgApellido1 = desgApellido1;
	}

	public void setDesgApellido2(String desgApellido2) {
		this.desgApellido2 = desgApellido2;
	}

	public void setDesgAuxiliar(String desgAuxiliar) {
		this.desgAuxiliar = desgAuxiliar;
	}

	public void setDesgCategoria(String desgCategoria) {
		this.desgCategoria = desgCategoria;
	}

	public void setDesgDivision(String desgDivision) {
		this.desgDivision = desgDivision;
	}

	public void setDesgError(String desgError) {
		this.desgError = desgError;
	}

	public void setDesgFichero(String desgFichero) {
		this.desgFichero = desgFichero;
	}

	public void setDesgId(String desgId) {
		this.desgId = desgId;
	}

	public void setDesgMatricula(String desgMatricula) {
		this.desgMatricula = desgMatricula;
	}

	public void setDesgMunicipio(String desgMunicipio) {
		this.desgMunicipio = desgMunicipio;
	}

	public void setDesgNacionalidad(String desgNacionalidad) {
		this.desgNacionalidad = desgNacionalidad;
	}

	public void setDesgNombre(String desgNombre) {
		this.desgNombre = desgNombre;
	}

	public void setDesgNombrevia(String desgNombrevia) {
		this.desgNombrevia = desgNombrevia;
	}

	public void setDesgNumero(String desgNumero) {
		this.desgNumero = desgNumero;
	}

	public void setDesgPlanta(String desgPlanta) {
		this.desgPlanta = desgPlanta;
	}

	public void setDesgProvincia(String desgProvincia) {
		this.desgProvincia = desgProvincia;
	}

	public void setDesgPuerta(String desgPuerta) {
		this.desgPuerta = desgPuerta;
	}

	public void setDesgResidencia(String desgResidencia) {
		this.desgResidencia = desgResidencia;
	}

	public void setDesgUnidadpresup(String desgUnidadpresup) {
		this.desgUnidadpresup = desgUnidadpresup;
	}

	public void setFchaAntigCargo(Date fchaAntigCargo) {
		this.fchaAntigCargo = fchaAntigCargo;
	}

	public void setFchaError(Date fchaError) {
		this.fchaError = fchaError;
	}

	public void setFchaIngreso(Date fchaIngreso) {
		this.fchaIngreso = fchaIngreso;
	}

	public void setFchaNac(Date fchaNac) {
		this.fchaNac = fchaNac;
	}

	public void setMrcaReprocesado(String mrcaReprocesado) {
		this.mrcaReprocesado = mrcaReprocesado;
	}

}