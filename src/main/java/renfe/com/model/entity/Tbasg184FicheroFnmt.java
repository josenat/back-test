package renfe.com.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG184_FICHERO_FNMT")
public class Tbasg184FicheroFnmt {

	@Id
	@Column(name = "CDGO_REGISTRO")
	private Long cdgoRegistro;

	@NotNull
	@Column(name = "CARRIER_ANHO")
	private String carrierAnho;

	@NotNull
	@Column(name = "CARRIER_APELLIDOSMAQ")
	private String carrierApellidosmaq;

	@NotNull
	@Column(name = "CARRIER_CARGORESPONSABLE")
	private String carrierCargoresponsable;

	@NotNull
	@Column(name = "CARRIER_CDGOFIRMA")
	private String carrierCdgofirma;

	@NotNull
	@Column(name = "CARRIER_DIA")
	private String carrierDia;

	@NotNull
	@Column(name = "CARRIER_MES")
	private String carrierMes;

	@NotNull
	@Column(name = "CARRIER_RESPONSABLE")
	private String carrierResponsable;

	@NotNull
	@Column(name = "CDGO_ENTREGAPOSTAL")
	private String cdgoEntregapostal;

	@NotNull
	@Column(name = "DESTPOST_CDGOPOSTAL")
	private String destpostCdgopostal;

	@NotNull
	@Column(name = "DESTPOST_LINEA1")
	private String destpostLinea1;

	@NotNull
	@Column(name = "DESTPOST_LINEA2")
	private String destpostLinea2;

	@NotNull
	@Column(name = "DESTPOST_LINEA3")
	private String destpostLinea3;

	@NotNull
	@Column(name = "DESTPOST_LINEA4")
	private String destpostLinea4;

	@Column(name = "FICH_DATOSFIJOS")
	private byte[] fichDatosfijos;

	@Column(name = "FICH_DATOSVARIABLES")
	private byte[] fichDatosvariables;

	@Column(name = "FICH_IDIOMAS")
	private byte[] fichIdiomas;

	@Column(name = "FICH_INFRAESTRUCTURAS")
	private byte[] fichInfraestructuras;

	@Column(name = "FICH_LINEAS")
	private byte[] fichLineas;

	@Column(name = "FICH_MATERIALES")
	private byte[] fichMateriales;

	@NotNull
	@Column(name = "PERSO_APELL1")
	private String persoApell1;

	@Column(name = "PERSO_APELL2")
	private String persoApell2;

	@NotNull
	@Column(name = "PERSO_FCHAEXPEDICION")
	private String persoFchaexpedicion;

	@NotNull
	@Column(name = "PERSO_FCHAEXPIRACION")
	private String persoFchaexpiracion;

	@NotNull
	@Column(name = "PERSO_FCHANACIMIENTO")
	private String persoFchanacimiento;

	@NotNull
	@Column(name = "PERSO_FOTOGRAFIA")
	private String persoFotografia;

	@Column(name = "PERSO_IDIOMAS")
	private String persoIdiomas;

	@NotNull
	@Column(name = "PERSO_LICENCIA")
	private String persoLicencia;

	@NotNull
	@Column(name = "PERSO_LUGARNACIMIENTO")
	private String persoLugarnacimiento;

	@NotNull
	@Column(name = "PERSO_MATRICULA")
	private String persoMatricula;

	@NotNull
	@Column(name = "PERSO_NACIONALIDAD")
	private String persoNacionalidad;

	@NotNull
	@Column(name = "PERSO_NIFPAS")
	private String persoNifpas;

	@NotNull
	@Column(name = "PERSO_NOMBRE")
	private String persoNombre;

	@NotNull
	@Column(name = "REMITE_LINEA1")
	private String remiteLinea1;

	@NotNull
	@Column(name = "REMITE_LINEA2")
	private String remiteLinea2;

	@NotNull
	@Column(name = "REMITE_LINEA3")
	private String remiteLinea3;

	@NotNull
	@Column(name = "REMITE_LINEA4")
	private String remiteLinea4;

	@NotNull
	@Column(name = "ROW_ID")
	private String rowId;

	public Long getCdgoRegistro() {
		return this.cdgoRegistro;
	}

	public void setCdgoRegistro(Long cdgoRegistro) {
		this.cdgoRegistro = cdgoRegistro;
	}

	public String getCarrierAnho() {
		return this.carrierAnho;
	}

	public String getCarrierApellidosmaq() {
		return this.carrierApellidosmaq;
	}

	public String getCarrierCargoresponsable() {
		return this.carrierCargoresponsable;
	}

	public String getCarrierCdgofirma() {
		return this.carrierCdgofirma;
	}

	public String getCarrierDia() {
		return this.carrierDia;
	}

	public String getCarrierMes() {
		return this.carrierMes;
	}

	public String getCarrierResponsable() {
		return this.carrierResponsable;
	}

	public String getCdgoEntregapostal() {
		return this.cdgoEntregapostal;
	}

	public String getDestpostCdgopostal() {
		return this.destpostCdgopostal;
	}

	public String getDestpostLinea1() {
		return this.destpostLinea1;
	}

	public String getDestpostLinea2() {
		return this.destpostLinea2;
	}

	public String getDestpostLinea3() {
		return this.destpostLinea3;
	}

	public String getDestpostLinea4() {
		return this.destpostLinea4;
	}

	public byte[] getFichDatosfijos() {
		return this.fichDatosfijos;
	}

	public byte[] getFichDatosvariables() {
		return this.fichDatosvariables;
	}

	public byte[] getFichIdiomas() {
		return this.fichIdiomas;
	}

	public byte[] getFichInfraestructuras() {
		return this.fichInfraestructuras;
	}

	public byte[] getFichLineas() {
		return this.fichLineas;
	}

	public byte[] getFichMateriales() {
		return this.fichMateriales;
	}

	public String getPersoApell1() {
		return this.persoApell1;
	}

	public String getPersoApell2() {
		return this.persoApell2;
	}

	public String getPersoFchaexpedicion() {
		return this.persoFchaexpedicion;
	}

	public String getPersoFchaexpiracion() {
		return this.persoFchaexpiracion;
	}

	public String getPersoFchanacimiento() {
		return this.persoFchanacimiento;
	}

	public String getPersoFotografia() {
		return this.persoFotografia;
	}

	public String getPersoIdiomas() {
		return this.persoIdiomas;
	}

	public String getPersoLicencia() {
		return this.persoLicencia;
	}

	public String getPersoLugarnacimiento() {
		return this.persoLugarnacimiento;
	}

	public String getPersoMatricula() {
		return this.persoMatricula;
	}

	public String getPersoNacionalidad() {
		return this.persoNacionalidad;
	}

	public String getPersoNifpas() {
		return this.persoNifpas;
	}

	public String getPersoNombre() {
		return this.persoNombre;
	}

	public String getRemiteLinea1() {
		return this.remiteLinea1;
	}

	public String getRemiteLinea2() {
		return this.remiteLinea2;
	}

	public String getRemiteLinea3() {
		return this.remiteLinea3;
	}

	public String getRemiteLinea4() {
		return this.remiteLinea4;
	}

	public String getRowId() {
		return this.rowId;
	}

	public void setCarrierAnho(String carrierAnho) {
		this.carrierAnho = carrierAnho;
	}

	public void setCarrierApellidosmaq(String carrierApellidosmaq) {
		this.carrierApellidosmaq = carrierApellidosmaq;
	}

	public void setCarrierCargoresponsable(String carrierCargoresponsable) {
		this.carrierCargoresponsable = carrierCargoresponsable;
	}

	public void setCarrierCdgofirma(String carrierCdgofirma) {
		this.carrierCdgofirma = carrierCdgofirma;
	}

	public void setCarrierDia(String carrierDia) {
		this.carrierDia = carrierDia;
	}

	public void setCarrierMes(String carrierMes) {
		this.carrierMes = carrierMes;
	}

	public void setCarrierResponsable(String carrierResponsable) {
		this.carrierResponsable = carrierResponsable;
	}

	public void setCdgoEntregapostal(String cdgoEntregapostal) {
		this.cdgoEntregapostal = cdgoEntregapostal;
	}

	public void setDestpostCdgopostal(String destpostCdgopostal) {
		this.destpostCdgopostal = destpostCdgopostal;
	}

	public void setDestpostLinea1(String destpostLinea1) {
		this.destpostLinea1 = destpostLinea1;
	}

	public void setDestpostLinea2(String destpostLinea2) {
		this.destpostLinea2 = destpostLinea2;
	}

	public void setDestpostLinea3(String destpostLinea3) {
		this.destpostLinea3 = destpostLinea3;
	}

	public void setDestpostLinea4(String destpostLinea4) {
		this.destpostLinea4 = destpostLinea4;
	}

	public void setFichDatosfijos(byte[] fichDatosfijos) {
		this.fichDatosfijos = fichDatosfijos;
	}

	public void setFichDatosvariables(byte[] fichDatosvariables) {
		this.fichDatosvariables = fichDatosvariables;
	}

	public void setFichIdiomas(byte[] fichIdiomas) {
		this.fichIdiomas = fichIdiomas;
	}

	public void setFichInfraestructuras(byte[] fichInfraestructuras) {
		this.fichInfraestructuras = fichInfraestructuras;
	}

	public void setFichLineas(byte[] fichLineas) {
		this.fichLineas = fichLineas;
	}

	public void setFichMateriales(byte[] fichMateriales) {
		this.fichMateriales = fichMateriales;
	}

	public void setPersoApell1(String persoApell1) {
		this.persoApell1 = persoApell1;
	}

	public void setPersoApell2(String persoApell2) {
		this.persoApell2 = persoApell2;
	}

	public void setPersoFchaexpedicion(String persoFchaexpedicion) {
		this.persoFchaexpedicion = persoFchaexpedicion;
	}

	public void setPersoFchaexpiracion(String persoFchaexpiracion) {
		this.persoFchaexpiracion = persoFchaexpiracion;
	}

	public void setPersoFchanacimiento(String persoFchanacimiento) {
		this.persoFchanacimiento = persoFchanacimiento;
	}

	public void setPersoFotografia(String persoFotografia) {
		this.persoFotografia = persoFotografia;
	}

	public void setPersoIdiomas(String persoIdiomas) {
		this.persoIdiomas = persoIdiomas;
	}

	public void setPersoLicencia(String persoLicencia) {
		this.persoLicencia = persoLicencia;
	}

	public void setPersoLugarnacimiento(String persoLugarnacimiento) {
		this.persoLugarnacimiento = persoLugarnacimiento;
	}

	public void setPersoMatricula(String persoMatricula) {
		this.persoMatricula = persoMatricula;
	}

	public void setPersoNacionalidad(String persoNacionalidad) {
		this.persoNacionalidad = persoNacionalidad;
	}

	public void setPersoNifpas(String persoNifpas) {
		this.persoNifpas = persoNifpas;
	}

	public void setPersoNombre(String persoNombre) {
		this.persoNombre = persoNombre;
	}

	public void setRemiteLinea1(String remiteLinea1) {
		this.remiteLinea1 = remiteLinea1;
	}

	public void setRemiteLinea2(String remiteLinea2) {
		this.remiteLinea2 = remiteLinea2;
	}

	public void setRemiteLinea3(String remiteLinea3) {
		this.remiteLinea3 = remiteLinea3;
	}

	public void setRemiteLinea4(String remiteLinea4) {
		this.remiteLinea4 = remiteLinea4;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

}