package renfe.com.dto;

public class GetInfractionParametersDTO {

    private Integer cdgoInfrper;
    private Integer cdgoReferenciaDoc;
    private String nifPas;
    private String matricula;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private Integer cdgoAreAct;
    private Integer cdgoAreTerr;
    private String cdgoCentroCont;
    private Integer[] listAreAct;
    private Integer[] listAreTer;
    private Integer cdgoTipInfr;
    private Integer cdgoGrado;
    private Integer cdgoSancion;
    private String fchaDesdeInfra;
    private String fchaHastaInfra;
    private String fchaDesdeIniSanc;
    private String fchaHastaIniSanc;
    private String fchaDesdeFinSanc;
    private String fchaHastaFinSanc;
    private String cdgoPersona;
    private String sanctionStartDate;
    private String sanctionEndDate;    
    private String infractionDate;
    private String desgMedidasAdop;
    private String desgUsuAct;
    private Integer cdgoReferenciadoc;
    private String desgMedidasadop;    
    private String fchaAct;
    private String fchaDesde;
    private String fchaFhinfr;
    private String fchaHasta;
    private String mrcaActivo;    
    private Integer cdgoTipinfr;
    private String desgUsuact;

    public Integer getCdgoInfrper() {
        return cdgoInfrper;
    }
    public void setCdgoInfrper(Integer cdgoInfrper) {
        this.cdgoInfrper = cdgoInfrper;
    }    
    public Integer getCdgoReferenciaDoc() {
        return cdgoReferenciaDoc;
    }
    public void setCdgoReferenciaDoc(Integer cdgoReferenciaDoc) {
        this.cdgoReferenciaDoc = cdgoReferenciaDoc;
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
    public Integer getCdgoAreAct() {
        return cdgoAreAct;
    }
    public void setCdgoAreAct(Integer cdgoAreAct) {
        this.cdgoAreAct = cdgoAreAct;
    }
    public Integer getCdgoAreTerr() {
        return cdgoAreTerr;
    }
    public void setCdgoAreTerr(Integer cdgoAreTerr) {
        this.cdgoAreTerr = cdgoAreTerr;
    }
    public String getCdgoCentroCont() {
        return cdgoCentroCont;
    }
    public void setCdgoCentroCont(String cdgoCentroCont) {
        this.cdgoCentroCont = cdgoCentroCont;
    }
    public Integer[] getListAreAct() {
        return listAreAct;
    }
    public void setListAreAct(Integer[] listAreAct) {
        this.listAreAct = listAreAct;
    }
    public Integer[] getListAreTer() {
        return listAreTer;
    }
    public void setListAreTer(Integer[] listAreTer) {
        this.listAreTer = listAreTer;
    }
    public Integer getCdgoTipInfr() {
        return cdgoTipInfr;
    }
    public void setCdgoTipInfr(Integer cdgoTipInfr) {
        this.cdgoTipInfr = cdgoTipInfr;
    }
    public Integer getCdgoGrado() {
        return cdgoGrado;
    }
    public void setCdgoGrado(Integer cdgoGrado) {
        this.cdgoGrado = cdgoGrado;
    }
    public Integer getCdgoSancion() {
        return cdgoSancion;
    }
    public void setCdgoSancion(Integer cdgoSancion) {
        this.cdgoSancion = cdgoSancion;
    }
    public String getFchaDesdeInfra() {
        return fchaDesdeInfra;
    }
    public void setFchaDesdeInfra(String fchaDesdeInfra) {
        this.fchaDesdeInfra = fchaDesdeInfra;
    }
    public String getFchaHastaInfra() {
        return fchaHastaInfra;
    }
    public void setFchaHastaInfra(String fchaHastaInfra) {
        this.fchaHastaInfra = fchaHastaInfra;
    }
    public String getFchaDesdeIniSanc() {
        return fchaDesdeIniSanc;
    }
    public void setFchaDesdeIniSanc(String fchaDesdeIniSanc) {
        this.fchaDesdeIniSanc = fchaDesdeIniSanc;
    }
    public String getFchaHastaIniSanc() {
        return fchaHastaIniSanc;
    }
    public void setFchaHastaIniSanc(String fchaHastaIniSanc) {
        this.fchaHastaIniSanc = fchaHastaIniSanc;
    }
    public String getFchaDesdeFinSanc() {
        return fchaDesdeFinSanc;
    }
    public void setFchaDesdeFinSanc(String fchaDesdeFinSanc) {
        this.fchaDesdeFinSanc = fchaDesdeFinSanc;
    }
    public String getFchaHastaFinSanc() {
        return fchaHastaFinSanc;
    }
    public void setFchaHastaFinSanc(String fchaHastaFinSanc) {
        this.fchaHastaFinSanc = fchaHastaFinSanc;
    }
    public String getCdgoPersona() {
        return cdgoPersona;
    }
    public void setCdgoPersona(String cdgoPersona) {
        this.cdgoPersona = cdgoPersona;
    }    
    public String getSanctionStartDate() {
        return sanctionStartDate;
    }
    public void setSanctionStartDate(String sanctionStartDate) {
        this.sanctionStartDate = sanctionStartDate;
    }
    public String getSanctionEndDate() {
        return sanctionEndDate;
    }
    public void setSanctionEndDate(String sanctionEndDate) {
        this.sanctionEndDate = sanctionEndDate;
    }
    public String getInfractionDate() {
        return infractionDate;
    }
    public void setInfractionDate(String infractionDate) {
        this.infractionDate = infractionDate;
    }
    public String getDesgMedidasAdop() {
        return desgMedidasAdop;
    }
    public void setDesgMedidasAdop(String desgMedidasAdop) {
        this.desgMedidasAdop = desgMedidasAdop;
    }
    public String getDesgUsuAct() {
        return desgUsuAct;
    }
    public void setDesgUsuAct(String desgUsuAct) {
        this.desgUsuAct = desgUsuAct;
    }       
    public Integer getCdgoReferenciadoc() {
        return cdgoReferenciadoc;
    }
    public void setCdgoReferenciadoc(Integer cdgoReferenciadoc) {
        this.cdgoReferenciadoc = cdgoReferenciadoc;
    }
    public String getDesgMedidasadop() {
        return desgMedidasadop;
    }
    public void setDesgMedidasadop(String desgMedidasadop) {
        this.desgMedidasadop = desgMedidasadop;
    }
    public String getFchaAct() {
        return fchaAct;
    }
    public void setFchaAct(String fchaAct) {
        this.fchaAct = fchaAct;
    }
    public String getFchaDesde() {
        return fchaDesde;
    }
    public void setFchaDesde(String fchaDesde) {
        this.fchaDesde = fchaDesde;
    }
    public String getFchaFhinfr() {
        return fchaFhinfr;
    }
    public void setFchaFhinfr(String fchaFhinfr) {
        this.fchaFhinfr = fchaFhinfr;
    }
    public String getFchaHasta() {
        return fchaHasta;
    }
    public void setFchaHasta(String fchaHasta) {
        this.fchaHasta = fchaHasta;
    }
    public String getMrcaActivo() {
        return mrcaActivo;
    }
    public void setMrcaActivo(String mrcaActivo) {
        this.mrcaActivo = mrcaActivo;
    }   
    public Integer getCdgoTipinfr() {
        return cdgoTipinfr;
    }
    public void setCdgoTipinfr(Integer cdgoTipinfr) {
        this.cdgoTipinfr = cdgoTipinfr;
    } 
    public String getDesgUsuact() {
        return desgUsuact;
    }
    public void setDesgUsuact(String desgUsuact) {
        this.desgUsuact = desgUsuact;
    }       

}
