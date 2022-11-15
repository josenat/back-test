package renfe.com.model.entity;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG100_PERSONA", schema = "PASG")
public class Tbasg100Persona {

    public Tbasg100Persona(Integer cdgoPersona) {
        this.cdgoPersona = cdgoPersona;

    }


    public Tbasg100Persona(Integer cdgoPersona, Date fechaActu) {
        this.cdgoPersona = cdgoPersona;
        this.fchaAct = fechaActu;
    }




    @Id
    @Column(name = "CDGO_PERSONA")
    private Integer cdgoPersona;



    // @NotNull
    @Column(name = "CDGO_AREACT")
    private Integer cdgoAreact;

    /*
     * public Tbasg100Persona(Long cdgoPersona, String desgApell1) {
     * this.cdgoPersona = cdgoPersona;
     * 
     * this.tbasg122Instru = new Tbasg122Instru();
     * tbasg122Instru.setDesgApell1(desgApell1);
     * 
     * }
     */
    public Tbasg100Persona() {
    }

    @Column(name = "CDGO_ARETER")
    private Integer cdgoAreter;


    @Column(name = "CDGO_CARGO")
    private String cdgoCargo;


    @Column(name = "CDGO_CENTCONT")
    private String cdgoCentcont;



    @Column(name = "CDGO_CENTCONT_DESUSO")
    private Integer cdgoCentcontDesuso;


    @Column(name = "CDGO_ESTUDIO")
    private Integer cdgoEstudio;


    @NotNull
    @Column(name = "CDGO_NACION")
    private Integer cdgoNacion;



    @Column(name = "CDGO_PROVINCIA")
    private Integer cdgoProvincia;



    @NotNull
    @Column(name = "CDGO_TIPODOC")
    private Integer cdgoTipodoc;



    @Column(name = "CDGO_TIPOVIA")
    private Integer cdgoTipovia;

    @Column(name = "DESC_AREA_ACT")
    private String descAreaAct;


    @NotNull
    @Column(name = "DESG_APELL1")
    private String desgApell1;



    @Column(name = "DESG_APELL2")
    private String desgApell2;



    @Column(name = "DESG_CERTCASTELL")
    private String desgCertcastell;



    @Column(name = "DESG_CODPOSTAL")
    private String desgCodpostal;



    @Column(name = "DESG_EIN")
    private String desgEin;


    @Column(name = "DESG_ESCALERA")
    private String desgEscalera;



    @Column(name = "DESG_ESTUDIEQUIV")
    private String desgEstudiequiv;



    @Column(name = "DESG_LUGARNACIMIENTO")
    private String desgLugarnacimiento;



    @Column(name = "DESG_MATRICULA")
    private String desgMatricula;



    @Column(name = "DESG_MUNICIPIO")
    private String desgMunicipio;
    /*
     * @NotNull
     * 
     * @Column(name = "DESG_NIFPAS", insertable = false, updatable = false)
     * private String desgNifpas;
     */



    @NotNull
    @Column(name = "DESG_NIFPAS")
    private String desgNifpas;


    @NotNull

    @Column(name = "DESG_NOMBRE")
    private String desgNombre;


    @Column(name = "DESG_NUMVIA")
    private String desgNumvia;

    
    @Column(name = "DESG_PLANTA")
    private String desgPlanta;



    @Column(name = "DESG_PUERTA")
    private String desgPuerta;


    @Column(name = "DESG_USUACT")
    private String desgUsuact;


    @Column(name = "DESG_VIA")
    private String desgVia;

    
    @Column(name = "DIAS_ILT")
    private Integer diasIlt;

    
    @Column(name = "FCHA_ACT")
    private Date fchaAct;

    @Column(name = "FCHA_ANTIG_CARGO")
    private Date fchaAntigCargo;

    @NotNull
    @Column(name = "FCHA_CONTRATO")
    private Date fchaContrato;


    @NotNull
    @Column(name = "FCHA_NACIMIENTO")
    private Date fchaNacimiento;

    @Column(name = "MRCA_ACTIVO")
    private String mrcaActivo;


    @Column(name = "MRCA_EXAMINADOR")
    private String mrcaExaminador;



    @Column(name = "MRCA_FORMADOR")
    private String mrcaFormador;


    public Integer getCdgoPersona() {
        return this.cdgoPersona;
    }


    public void setCdgoPersona(Integer cdgoPersona) {
        this.cdgoPersona = cdgoPersona;

    }


    public Integer getCdgoAreact() {
        return this.cdgoAreact;
    }

    public Integer getCdgoAreter() {
        return this.cdgoAreter;

    }


    public String getCdgoCargo() {
        return this.cdgoCargo;

    }

    
    public String getCdgoCentcont() {
        return this.cdgoCentcont;
    }


    public Integer getCdgoCentcontDesuso() {
        return this.cdgoCentcontDesuso;
    }

    public Integer getCdgoEstudio() {
        return this.cdgoEstudio;
    }


    public Integer getCdgoNacion() {
        return this.cdgoNacion;
    }


    public Integer getCdgoProvincia() {
        return this.cdgoProvincia;
    }


    public Integer getCdgoTipodoc() {
        return this.cdgoTipodoc;
    }


    public Integer getCdgoTipovia() {
        return this.cdgoTipovia;

    }

    
    public String getDescAreaAct() {
        return this.descAreaAct;

    }


    public String getDesgApell1() {
        return this.desgApell1;

    }

    public String getDesgApell2() {
        return this.desgApell2;
    }

    public String getDesgCertcastell() {
        return this.desgCertcastell;
    }

    public String getDesgCodpostal() {
        return this.desgCodpostal;
    }

    public String getDesgEin() {
        return this.desgEin;
    }

    public String getDesgEscalera() {
        return this.desgEscalera;
    }

    public String getDesgEstudiequiv() {
        return this.desgEstudiequiv;
    }

    public String getDesgLugarnacimiento() {
        return this.desgLugarnacimiento;
    }

    public String getDesgMatricula() {
        return this.desgMatricula;
    }

    public String getDesgMunicipio() {
        return this.desgMunicipio;
    }

    public String getDesgNifpas() {
        return this.desgNifpas;
    }

    public String getDesgNombre() {
        return this.desgNombre;
    }

    public String getDesgNumvia() {
        return this.desgNumvia;
    }

    public String getDesgPlanta() {
        return this.desgPlanta;
    }

    public String getDesgPuerta() {
        return this.desgPuerta;
    }

    public String getDesgUsuact() {
        return this.desgUsuact;
    }

    public String getDesgVia() {
        return this.desgVia;
    }

    public Integer getDiasIlt() {
        return this.diasIlt;
    }

    public Date getFchaAct() {
        return this.fchaAct;
    }

    public Date getFchaAntigCargo() {
        return this.fchaAntigCargo;
    }

    public Date getFchaContrato() {
        return this.fchaContrato;
    }

    public Date getFchaNacimiento() {
        return this.fchaNacimiento;
    }

    public String getMrcaActivo() {
        return this.mrcaActivo;
    }

    public String getMrcaExaminador() {
        return this.mrcaExaminador;
    }

    public String getMrcaFormador() {
        return this.mrcaFormador;
    }

    public void setCdgoAreact(Integer cdgoAreact) {
        this.cdgoAreact = cdgoAreact;
    }

    public void setCdgoAreter(Integer cdgoAreter) {
        this.cdgoAreter = cdgoAreter;
    }

    public void setCdgoCargo(String cdgoCargo) {
        this.cdgoCargo = cdgoCargo;
    }

    public void setCdgoCentcont(String cdgoCentcont) {
        this.cdgoCentcont = cdgoCentcont;
    }

    public void setCdgoCentcontDesuso(Integer cdgoCentcontDesuso) {
        this.cdgoCentcontDesuso = cdgoCentcontDesuso;
    }

    public void setCdgoEstudio(Integer cdgoEstudio) {
        this.cdgoEstudio = cdgoEstudio;
    }

    public void setCdgoNacion(Integer cdgoNacion) {
        this.cdgoNacion = cdgoNacion;
    }

    public void setCdgoProvincia(Integer cdgoProvincia) {
        this.cdgoProvincia = cdgoProvincia;
    }

    public void setCdgoTipodoc(Integer cdgoTipodoc) {
        this.cdgoTipodoc = cdgoTipodoc;
    }

    public void setCdgoTipovia(Integer cdgoTipovia) {
        this.cdgoTipovia = cdgoTipovia;
    }

    public void setDescAreaAct(String descAreaAct) {
        this.descAreaAct = descAreaAct;
    }

    public void setDesgApell1(String desgApell1) {
        this.desgApell1 = desgApell1;
    }

    public void setDesgApell2(String desgApell2) {
        this.desgApell2 = desgApell2;
    }

    public void setDesgCertcastell(String desgCertcastell) {
        this.desgCertcastell = desgCertcastell;
    }

    public void setDesgCodpostal(String desgCodpostal) {
        this.desgCodpostal = desgCodpostal;
    }

    public void setDesgEin(String desgEin) {
        this.desgEin = desgEin;
    }

    public void setDesgEscalera(String desgEscalera) {
        this.desgEscalera = desgEscalera;
    }

    public void setDesgEstudiequiv(String desgEstudiequiv) {
        this.desgEstudiequiv = desgEstudiequiv;
    }

    public void setDesgLugarnacimiento(String desgLugarnacimiento) {
        this.desgLugarnacimiento = desgLugarnacimiento;
    }

    public void setDesgMatricula(String desgMatricula) {
        this.desgMatricula = desgMatricula;
    }

    public void setDesgMunicipio(String desgMunicipio) {
        this.desgMunicipio = desgMunicipio;
    }

    public void setDesgNifpas(String desgNifpas) {
        this.desgNifpas = desgNifpas;
    }

    public void setDesgNombre(String desgNombre) {
        this.desgNombre = desgNombre;
    }

    public void setDesgNumvia(String desgNumvia) {
        this.desgNumvia = desgNumvia;
    }

    public void setDesgPlanta(String desgPlanta) {
        this.desgPlanta = desgPlanta;
    }

    public void setDesgPuerta(String desgPuerta) {
        this.desgPuerta = desgPuerta;
    }

    public void setDesgUsuact(String desgUsuact) {
        this.desgUsuact = desgUsuact;
    }

    public void setDesgVia(String desgVia) {
        this.desgVia = desgVia;
    }

    public void setDiasIlt(Integer diasIlt) {
        this.diasIlt = diasIlt;
    }

    public void setFchaAct(Date fchaAct) {
        this.fchaAct = fchaAct;
    }

    public void setFchaAntigCargo(Date fchaAntigCargo) {
        this.fchaAntigCargo = fchaAntigCargo;
    }

    public void setFchaContrato(Date fchaContrato) {
        this.fchaContrato = fchaContrato;
    }

    public void setFchaNacimiento(Date fchaNacimiento) {
        this.fchaNacimiento = fchaNacimiento;
    }

    public void setMrcaActivo(String mrcaActivo) {
        this.mrcaActivo = mrcaActivo;
    }

    public void setMrcaExaminador(String mrcaExaminador) {
        this.mrcaExaminador = mrcaExaminador;
    }

    public void setMrcaFormador(String mrcaFormador) {
        this.mrcaFormador = mrcaFormador;
    }

}
