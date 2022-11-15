package renfe.com.dto;

import java.sql.Timestamp;

public class GetMaxEstadoExpListDTO {
    private Integer cdgoExpedient;
    private Integer cdgoEstado;
    private Timestamp fchaEstado; 
    private Integer cdgoPersona;
    private String estado;          // S.DESG_NOMBRE AS ESTADO - Char
    private String tipoHabilita;    // TH.DESG_NOMBRE AS TIPO_HABILITA - Char
    private String desgPersona;     // P.DESG_NOMBRE AS DESG_PERSONA - Char
    private String desgApell1;      
    private String desgApell2;      
    private String desgMatricula;   
    private String desgNifPass;     
    private Integer cdgoTipoHab;    
    private Integer cdgoAlcanceOt;
    private Integer cdgoEspec;
    private Integer cdgoAlcanceAmbito;
    private String desgTipoInfraEstruc;
    private Integer cdgoEntorno;
    private String cdgoLinea;
    private String cdgoSerie;
    private String cdgoSubSerie;
    private String desgObserva;
    private String descSociedad;
    private String mrcaRevision;

    public Integer getCdgoExpedient() {
        return cdgoExpedient;
    }
    public void setCdgoExpedient(Integer cdgoExpedient) {
        this.cdgoExpedient = cdgoExpedient;
    }
    public Integer getCdgoEstado() {
        return cdgoEstado;
    }
    public void setCdgoEstado(Integer cdgoEstado) {
        this.cdgoEstado = cdgoEstado;
    }
    public Timestamp getFchaEstado() {
        return fchaEstado;
    }
    public void setFchaEstado(Timestamp fchaEstado) {
        this.fchaEstado = fchaEstado;
    }
    public Integer getCdgoPersona() {
        return cdgoPersona;
    }
    public void setCdgoPersona(Integer cdgoPersona) {
        this.cdgoPersona = cdgoPersona;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getTipoHabilita() {
        return tipoHabilita;
    }
    public void setTipoHabilita(String tipoHabilita) {
        this.tipoHabilita = tipoHabilita;
    }
    public String getDesgPersona() {
        return desgPersona;
    }
    public void setDesgPersona(String desgPersona) {
        this.desgPersona = desgPersona;
    }
    public String getDesgApell1() {
        return desgApell1;
    }
    public void setDesgApell1(String desgApell1) {
        this.desgApell1 = desgApell1;
    }
    public String getDesgApell2() {
        return desgApell2;
    }
    public void setDesgApell2(String desgApell2) {
        this.desgApell2 = desgApell2;
    }
    public String getDesgMatricula() {
        return desgMatricula;
    }
    public void setDesgMatricula(String desgMatricula) {
        this.desgMatricula = desgMatricula;
    }
    public String getDesgNifPass() {
        return desgNifPass;
    }
    public void setDesgNifPass(String desgNifPass) {
        this.desgNifPass = desgNifPass;
    }
    public Integer getCdgoTipoHab() {
        return cdgoTipoHab;
    }
    public void setCdgoTipoHab(Integer cdgoTipoHab) {
        this.cdgoTipoHab = cdgoTipoHab;
    }
    public Integer getCdgoAlcanceOt() {
        return cdgoAlcanceOt;
    }
    public void setCdgoAlcanceOt(Integer cdgoAlcanceOt) {
        this.cdgoAlcanceOt = cdgoAlcanceOt;
    }
    public Integer getCdgoEspec() {
        return cdgoEspec;
    }
    public void setCdgoEspec(Integer cdgoEspec) {
        this.cdgoEspec = cdgoEspec;
    }
    public Integer getCdgoAlcanceAmbito() {
        return cdgoAlcanceAmbito;
    }
    public void setCdgoAlcanceAmbito(Integer cdgoAlcanceAmbito) {
        this.cdgoAlcanceAmbito = cdgoAlcanceAmbito;
    }
    public String getDesgTipoInfraEstruc() {
        return desgTipoInfraEstruc;
    }
    public void setDesgTipoInfraEstruc(String desgTipoInfraEstruc) {
        this.desgTipoInfraEstruc = desgTipoInfraEstruc;
    }
    public Integer getCdgoEntorno() {
        return cdgoEntorno;
    }
    public void setCdgoEntorno(Integer cdgoEntorno) {
        this.cdgoEntorno = cdgoEntorno;
    }
    public String getCdgoLinea() {
        return cdgoLinea;
    }
    public void setCdgoLinea(String cdgoLinea) {
        this.cdgoLinea = cdgoLinea;
    }
    public String getCdgoSerie() {
        return cdgoSerie;
    }
    public void setCdgoSerie(String cdgoSerie) {
        this.cdgoSerie = cdgoSerie;
    }
    public String getCdgoSubSerie() {
        return cdgoSubSerie;
    }
    public void setCdgoSubSerie(String cdgoSubSerie) {
        this.cdgoSubSerie = cdgoSubSerie;
    }
    public String getDesgObserva() {
        return desgObserva;
    }
    public void setDesgObserva(String desgObserva) {
        this.desgObserva = desgObserva;
    }
    public String getDescSociedad() {
        return descSociedad;
    }
    public void setDescSociedad(String descSociedad) {
        this.descSociedad = descSociedad;
    }
    public String getMrcaRevision() {
        return mrcaRevision; 
    }
    public void setMrcaRevision(String mrcaRevision) {
        this.mrcaRevision = mrcaRevision;
    }
    
  
}
