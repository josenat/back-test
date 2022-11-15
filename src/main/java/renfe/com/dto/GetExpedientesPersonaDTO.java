package renfe.com.dto;

import java.sql.Date;

public class GetExpedientesPersonaDTO {

    private Integer cdgoExpediente;
    private Date fchaExpediente;
    private String empresa;
    private Integer cdgoTipoHab;
    private String tipoHabilita;
    private Integer cdgoAmbitos;
    private Integer cdgoAlcanceOt;
    private Integer cdgoAcanceAmbito;
    private Integer cdgoEntorno;
    private String cdgoLinea;
    private String cdgoSerie;
    private String cdgoSubSerie;
    private Integer cdgoEspec;
    private String estado;
    private Date fchaEstado;
    private String desgObserva;
    private String desgTipoInfraestruc;

    public Integer getCdgoExpediente() {
        return cdgoExpediente;
    }

    public void setCdgoExpediente(Integer cdgoExpediente) {
        this.cdgoExpediente = cdgoExpediente;
    }

    public Date getFchaExpediente() {
        return fchaExpediente;
    }

    public void setFchaExpediente(Date fchaExpediente) {
        this.fchaExpediente = fchaExpediente;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public Integer getCdgoTipoHab() {
        return cdgoTipoHab;
    }

    public void setCdgoTipoHab(Integer cdgoTipoHab) {
        this.cdgoTipoHab = cdgoTipoHab;
    }

    public String getTipoHabilita() {
        return tipoHabilita;
    }

    public void setTipoHabilita(String tipoHabilita) {
        this.tipoHabilita = tipoHabilita;
    }

    public Integer getCdgoAmbitos() {
        return cdgoAmbitos;
    }

    public void setCdgoAmbitos(Integer cdgoAmbitos) {
        this.cdgoAmbitos = cdgoAmbitos;
    }

    public Integer getCdgoAlcanceOt() {
        return cdgoAlcanceOt;
    }

    public void setCdgoAlcanceOt(Integer cdgoAlcanceOt) {
        this.cdgoAlcanceOt = cdgoAlcanceOt;
    }

    public Integer getCdgoAcanceAmbito() {
        return cdgoAcanceAmbito;
    }

    public void setCdgoAcanceAmbito(Integer cdgoAcanceAmbito) {
        this.cdgoAcanceAmbito = cdgoAcanceAmbito;
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

    public Integer getCdgoEspec() {
        return cdgoEspec;
    }

    public void setCdgoEspec(Integer cdgoEspec) {
        this.cdgoEspec = cdgoEspec;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFchaEstado() {
        return fchaEstado;
    }

    public void setFchaEstado(Date fchaEstado) {
        this.fchaEstado = fchaEstado;
    }

    public String getDesgObserva() {
        return desgObserva;
    }

    public void setDesgObserva(String desgObserva) {
        this.desgObserva = desgObserva;
    }

    public String getDesgTipoInfraestruc() {
        return desgTipoInfraestruc;
    }

    public void setDesgTipoInfraestruc(String desgTipoInfraestruc) {
        this.desgTipoInfraestruc = desgTipoInfraestruc;
    }
}
