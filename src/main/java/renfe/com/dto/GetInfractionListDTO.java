package renfe.com.dto;

import java.sql.Date;

public class GetInfractionListDTO {
    private Integer cdgoInfrper;       // I.CDGO_INFRPER - PASG.TBASG103_INFRACPER I
    private Integer cdgoPersona;       // I.CDGO_PERSONA
    private Date    fchaFhinfr;        // I.FCHA_FHINFR
    private String  desgMedidasadop;   // I.DESG_MEDIDASADOP
    private Date    fchaHasta;         // I.FCHA_HASTA
    private Date    fchaDesde;         // I.FCHA_DESDE
    private Integer cdgoTipinfr;       // I.CDGO_TIPINFR
    private Integer cdgoSancion;       // I.CDGO_SANCION
    private Integer cdgoGrado;         // I.CDGO_GRADO
    private String  desgUsuact;        // I.DESG_USUACT
    private Date    fchaAct;           // I.FCHA_ACT
    private String  mrcaActivo;        // I.MRCA_ACTIVO
    private Integer cdgoReferenciadoc; // I.CDGO_REFERENCIADOC         
    private String  tipoInfra;         // T.DESG_NOMBRE  - PASG.TBASG112_TIPOINFRA T
    private String  grado;             // G.DESG_NOMBRE  - PASG.TBASG114_GRADOINCI G
    private String  sancion;           // S.DESG_NOMBRE  - PASG.TBASG113_SANCION   S
    private String  areActividad;      // A.DESG_NOMBRE  - PASG.TBASG105_AREACTIVI A   
	private String  nifpas;            // P.DESG_NIFPAS  - PASG.TBASG100_PERSONA   P
    private String  nombre;            // P.DESG_NOMBRE
    private String  apellido1;         // P.DESG_APELL1
    private String  apellido2;         // P.DESG_APELL2
	private String  matricula;         // P.DESG_MATRICULA

    public Integer getCdgoInfrper() {
        return cdgoInfrper;
    }
    public void setCdgoInfrper(Integer cdgoInfrper) {
        this.cdgoInfrper = cdgoInfrper;
    }
    public Integer getCdgoPersona() {
        return cdgoPersona;
    }
    public void setCdgoPersona(Integer cdgoPersona) {
        this.cdgoPersona = cdgoPersona;
    }
    public Date getFchaFhinfr() {
        return fchaFhinfr;
    }
    public void setFchaFhinfr(Date fchaFhinfr) {
        this.fchaFhinfr = fchaFhinfr;
    }
    public String getDesgMedidasadop() {
        return desgMedidasadop;
    }
    public void setDesgMedidasadop(String desgMedidasadop) {
        this.desgMedidasadop = desgMedidasadop;
    }
    public Date getFchaHasta() {
        return fchaHasta;
    }
    public void setFchaHasta(Date fchaHasta) {
        this.fchaHasta = fchaHasta;
    }
    public Date getFchaDesde() {
        return fchaDesde;
    }
    public void setFchaDesde(Date fchaDesde) {
        this.fchaDesde = fchaDesde;
    }
    public Integer getCdgoTipinfr() {
        return cdgoTipinfr;
    }
    public void setCdgoTipinfr(Integer cdgoTipinfr) {
        this.cdgoTipinfr = cdgoTipinfr;
    }
    public Integer getCdgoSancion() {
        return cdgoSancion;
    }
    public void setCdgoSancion(Integer cdgoSancion) {
        this.cdgoSancion = cdgoSancion;
    }
    public Integer getCdgoGrado() {
        return cdgoGrado;
    }
    public void setCdgoGrado(Integer cdgoGrado) {
        this.cdgoGrado = cdgoGrado;
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
    public Integer getCdgoReferenciadoc() {
        return cdgoReferenciadoc;
    }
    public void setCdgoReferenciadoc(Integer cdgoReferenciadoc) {
        this.cdgoReferenciadoc = cdgoReferenciadoc;
    }
    public String getTipoInfra() {
        return tipoInfra;
    }
    public void setTipoInfra(String tipoInfra) {
        this.tipoInfra = tipoInfra;
    }
    public String getGrado() {
        return grado;
    }
    public void setGrado(String grado) {
        this.grado = grado;
    }
    public String getSancion() {
        return sancion;
    }
    public void setSancion(String sancion) {
        this.sancion = sancion;
    }
    public String getAreActividad() {
        return areActividad;
    }
    public void setAreActividad(String areActividad) {
        this.areActividad = areActividad;
    }
    public String getNifpas() {
        return nifpas;
    }
    public void setNifpas(String nifpas) {
        this.nifpas = nifpas;
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
    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

}
