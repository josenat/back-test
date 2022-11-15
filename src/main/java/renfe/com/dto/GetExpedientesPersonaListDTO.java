package renfe.com.dto;



import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GetExpedientesPersonaListDTO {
	
	@Id
	@Column (name="CDGO_PERSONA")
	private Integer cdgoPersona;
	
	@Column (name="DESG_NIFPAS")
	private String nifPas;
	
	@Column (name="DESG_MATRICULA")
	private String matricula;
    
	@Column (name="DESG_NOMBRE")
	private String nombre;
    
	@Column (name="DESG_APELL1")
	private String apellido1;
	
	@Column (name="DESG_APELL2")
	private String apellido2;
	
	@Column (name="CDGO_TIPOVIA")
	private Integer cdgoTipovia;
   
	@Column (name="DESG_VIA")
	private String via;
   
	@Column (name="DESG_NUMVIA")
	private String numVia;
	
	@Column (name="DESG_PLANTA")
	private String planta;
	
	@Column (name="DESG_PUERTA")
	private String puerta;
	
	@Column (name="DESG_ESCALERA")
	private String escalera;
	
	@Column (name="DESG_MUNICIPIO")
	private String municipio;
	
	@Column (name="CDGO_PROVINCIA")
	private Integer cdgoProvincia;
   
	@Column (name="CDGO_NACION")
	private Integer cdgoNacion;
    
	@Column (name="DESG_CODPOSTAL")
	private String codPostal;
	
	@Column (name="FCHA_NACIMIENTO")
	private Date fechNacimiento;
	
	@Column (name="CDGO_CARGO")
	private String cdgoCargo;
    
	@Column (name="CDGO_CENTCONT")
	private String cdgoCentcont;
	
	@Column (name="CDGO_AREACT")
	private Integer cdgoAreact;
	
	@Column (name="FCHA_CONTRATO")
	private Date fchaContrato;
	
	@Column (name="CDGO_ESTUDIO")
	private Integer cdgoEstudio;
	
	@Column (name="DESG_ESTUDIEQUIV")
	private String desgEstudiequiv;
	
	@Column (name="DESG_CERTCASTELL")
	private String desgCertcastell;
	
	@Column (name="MRCA_FORMADOR")
	private String mrcaFormador;

	@Column (name="DESG_USUACT")
	private String desgUsuact;
	
	@Column (name="FCHA_ACT")
	private Date fchaAct;
	
	@Column (name="MRCA_ACTIVO")
	private String mrcaActivo;
	
	@Column (name="FCHA_ANTIG_CARGO")
	private Date fchaAntigcargo;
	
	@Column (name="DESG_LUGARNACIMIENTO")
	private String desgLugarnacimiento;
	
	@Column (name="CDGO_TIPODOC")
	private Integer cdgoTipodoc;
	
	@Column (name="CDGO_ARETER")
	private Integer cdgoAreter;
	
	@Column (name="DESC_AREA_ACT")
	private String descAreaact;
	
	@Column (name="DESG_EIN")
	private String desgEin;
	
	@Column (name="DIAS_ILT")
	private Integer diasIlt;

	public Integer getCdgoPersona() {
		return cdgoPersona;
	}

	public void setCdgoPersona(Integer cdgoPersona) {
		this.cdgoPersona = cdgoPersona;
	}

	public String getNifPas() {
		return nifPas;
	}

	public void setNifPas(String nifPas) {
		this.nifPas = nifPas;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public Integer getCdgoTipovia() {
		return cdgoTipovia;
	}

	public void setCdgoTipovia(Integer cdgoTipovia) {
		this.cdgoTipovia = cdgoTipovia;
	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public String getNumVia() {
		return numVia;
	}

	public void setNumVia(String numVia) {
		this.numVia = numVia;
	}

	public String getPlanta() {
		return planta;
	}

	public void setPlanta(String planta) {
		this.planta = planta;
	}

	public String getPuerta() {
		return puerta;
	}

	public void setPuerta(String puerta) {
		this.puerta = puerta;
	}

	public String getEscalera() {
		return escalera;
	}

	public void setEscalera(String escalera) {
		this.escalera = escalera;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public Integer getCdgoProvincia() {
		return cdgoProvincia;
	}

	public void setCdgoProvincia(Integer cdgoProvincia) {
		this.cdgoProvincia = cdgoProvincia;
	}

	public Integer getCdgoNacion() {
		return cdgoNacion;
	}

	public void setCdgoNacion(Integer cdgoNacion) {
		this.cdgoNacion = cdgoNacion;
	}

	public String getCodPostal() {
		return codPostal;
	}

	public void setCodPostal(String codPostal) {
		this.codPostal = codPostal;
	}

	public Date getFechNacimiento() {
		return fechNacimiento;
	}

	public void setFechNacimiento(Date fechNacimiento) {
		this.fechNacimiento = fechNacimiento;
	}

	public String getCdgoCargo() {
		return cdgoCargo;
	}

	public void setCdgoCargo(String cdgoCargo) {
		this.cdgoCargo = cdgoCargo;
	}

	public String getCdgoCentcont() {
		return cdgoCentcont;
	}

	public void setCdgoCentcont(String cdgoCentcont) {
		this.cdgoCentcont = cdgoCentcont;
	}

	public Integer getCdgoAreact() {
		return cdgoAreact;
	}

	public void setCdgoAreact(Integer cdgoAreact) {
		this.cdgoAreact = cdgoAreact;
	}

	public Date getFchaContrato() {
		return fchaContrato;
	}

	public void setFchaContrato(Date fchaContrato) {
		this.fchaContrato = fchaContrato;
	}

	public Integer getCdgoEstudio() {
		return cdgoEstudio;
	}

	public void setCdgoEstudio(Integer cdgoEstudio) {
		this.cdgoEstudio = cdgoEstudio;
	}

	public String getDesgEstudiequiv() {
		return desgEstudiequiv;
	}

	public void setDesgEstudiequiv(String desgEstudiequiv) {
		this.desgEstudiequiv = desgEstudiequiv;
	}

	public String getDesgCertcastell() {
		return desgCertcastell;
	}

	public void setDesgCertcastell(String desgCertcastell) {
		this.desgCertcastell = desgCertcastell;
	}

	public String getMrcaFormador() {
		return mrcaFormador;
	}

	public void setMrcaFormador(String mrcaFormador) {
		this.mrcaFormador = mrcaFormador;
	}

	public String getDesgUsuact() {
		return desgUsuact;
	}

	public void setDesgUsuact(String desgUsuact) {
		this.desgUsuact = desgUsuact;
	}

	public Date getFchaAct() {
		return fchaAct;
	}

	public void setFchaAct(Date fchaAct) {
		this.fchaAct = fchaAct;
	}

	public String getMrcaActivo() {
		return mrcaActivo;
	}

	public void setMrcaActivo(String mrcaActivo) {
		this.mrcaActivo = mrcaActivo;
	}

	public Date getFchaAntigcargo() {
		return fchaAntigcargo;
	}

	public void setFchaAntigcargo(Date fchaAntigcargo) {
		this.fchaAntigcargo = fchaAntigcargo;
	}

	public String getDesgLugarnacimiento() {
		return desgLugarnacimiento;
	}

	public void setDesgLugarnacimiento(String desgLugarnacimiento) {
		this.desgLugarnacimiento = desgLugarnacimiento;
	}

	public Integer getCdgoTipodoc() {
		return cdgoTipodoc;
	}

	public void setCdgoTipodoc(Integer cdgoTipodoc) {
		this.cdgoTipodoc = cdgoTipodoc;
	}

	public Integer getCdgoAreter() {
		return cdgoAreter;
	}

	public void setCdgoAreter(Integer cdgoAreter) {
		this.cdgoAreter = cdgoAreter;
	}

	public String getDescAreaact() {
		return descAreaact;
	}

	public void setDescAreaact(String descAreaact) {
		this.descAreaact = descAreaact;
	}

	public String getDesgEin() {
		return desgEin;
	}

	public void setDesgEin(String desgEin) {
		this.desgEin = desgEin;
	}

	public Integer getDiasIlt() {
		return diasIlt;
	}

	public void setDiasIlt(Integer diasIlt) {
		this.diasIlt = diasIlt;
	}
	
	
	
}
