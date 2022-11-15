package renfe.com.model.dto;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;


public class Tbasg102TituloconDto {

    private Integer cdgoPersona;
    private Integer cdgoTit;
    private String desgSoloram;
    private String desgTiptit;
    private String desgUsuact;
    //@JsonFormat(pattern = "dd/MM/yyyy")
    private Date fchaAct;
    //@JsonFormat(pattern = "dd/MM/yyyy")
    private Date fchaOtorgado;
    //@JsonFormat(pattern = "dd/MM/yyyy")
    private Date fchaTipejerprof;
    private String mrcaActivo;

    private String fchaEstado;


    public Tbasg102TituloconDto() {
        this.cdgoPersona = 0;
        this.cdgoTit = 0;
        this.mrcaActivo = "S";
        this.desgUsuact = "";
    }

    public Integer getCdgoPersona() {
        return this.cdgoPersona;
    }

    public void setCdgoPersona(Integer cdgoPersona) {
        this.cdgoPersona = cdgoPersona;
    }

    public Integer getCdgoTit() {
        return this.cdgoTit;
    }

    public void setCdgoTit(Integer cdgoTit) {
        this.cdgoTit = cdgoTit;
    }

    public String getDesgSoloram() {
        return this.desgSoloram;
    }

    public void setDesgSoloram(String desgSoloram) {
        this.desgSoloram = desgSoloram;
    }

    public String getDesgTiptit() {
        return this.desgTiptit;
    }

    public void setDesgTiptit(String desgTiptit) {
        this.desgTiptit = desgTiptit;
    }

    public String getDesgUsuact() {
        return this.desgUsuact;
    }

    public void setDesgUsuact(String desgUsuact) {
        this.desgUsuact = desgUsuact;
    }

    public Date getFchaAct() {
        return this.fchaAct;
    }

    public void setFchaAct(Date fchaAct) {
        this.fchaAct = fchaAct;
    }

    public Date getFchaOtorgado() {
        return this.fchaOtorgado;
    }

    public void setFchaOtorgado(Date fchaOtorgado) {
        this.fchaOtorgado = fchaOtorgado;
    }

    public Date getFchaTipejerprof() {
        return this.fchaTipejerprof;
    }

    public void setFchaTipejerprof(Date fchaTipejerprof) {
        this.fchaTipejerprof = fchaTipejerprof;
    }

    public String getMrcaActivo() {
        return this.mrcaActivo;
    }

    public void setMrcaActivo(String mrcaActivo) {
        this.mrcaActivo = mrcaActivo;
    }

    public String getFchaEstado() {
        return fchaEstado;
    }

    public void setFchaEstado(String fchaEstado) {
        this.fchaEstado = fchaEstado;
    }    


}