package renfe.com.dto;

import java.sql.Date;

public class GetTituloConListAuxDTO {

    private Integer cdgoTit;
    private Integer cdgoPersona;
    private Date fchaOtorgado;
    private String desgTiptit;
    private String estado;
    private Integer cdgoEstado;
    private Date fchaEstado;
    private String desgNifPas;
    private String desgMatricula;
    private String desgPersona;
    private String desgApell1;
    private String desgApell2;
    private Date fchaCursoInc;

    public Integer getCdgoTit() {
        return cdgoTit;
    }

    public void setCdgoTit(Integer cdgoTit) {
        this.cdgoTit = cdgoTit;
    }

    public Integer getCdgoPersona() {
        return cdgoPersona;
    }

    public void setCdgoPersona(Integer cdgoPersona) {
        this.cdgoPersona = cdgoPersona;
    }

    public Date getFchaOtorgado() {
        return fchaOtorgado;
    }

    public void setFchaOtorgado(Date fchaOtorgado) {
        this.fchaOtorgado = fchaOtorgado;
    }

    public String getDesgTiptit() {
        return desgTiptit;
    }

    public void setDesgTiptit(String desgTiptit) {
        this.desgTiptit = desgTiptit;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getCdgoEstado() {
        return cdgoEstado;
    }

    public void setCdgoEstado(Integer cdgoEstado) {
        this.cdgoEstado = cdgoEstado;
    }

    public Date getFchaEstado() {
        return fchaEstado;
    }

    public void setFchaEstado(Date fchaEstado) {
        this.fchaEstado = fchaEstado;
    }

    public String getDesgNifPas() {
        return desgNifPas;
    }

    public void setDesgNifPas(String desgNifPas) {
        this.desgNifPas = desgNifPas;
    }

    public String getDesgMatricula() {
        return desgMatricula;
    }

    public void setDesgMatricula(String desgMatricula) {
        this.desgMatricula = desgMatricula;
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

    public Date getFchaCursoInc() {
        return fchaCursoInc;
    }

    public void setFchaCursoInc(Date fchaCursoInc) {
        this.fchaCursoInc = fchaCursoInc;
    }
}
