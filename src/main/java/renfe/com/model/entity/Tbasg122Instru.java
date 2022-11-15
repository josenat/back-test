package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG122_INSTRU", schema = "PASG")
public class Tbasg122Instru {


    public Tbasg122Instru(String desgApell1) {
        this.desgApell1 = desgApell1;
    }

    public Tbasg122Instru() {
    }

    @Id
    @Column(name = "CDGO_NIF")
    private String cdgoNif;

    @NotNull
    @Column(name = "DESG_APELL1")
    private String desgApell1;

    @Column(name = "DESG_APELL2")
    private String desgApell2;

    @NotNull
    @Column(name = "DESG_NOMBRE")
    private String desgNombre;

    @Column(name = "DESG_USUACT")
    private String desgUsuact;

    @Column(name = "FCHA_ACT")
    private Date fchaAct;

    @Column(name = "MRCA_ACTIVO")
    private String mrcaActivo;

    @Column(name = "MRCA_EXAMINADOR")
    private String mrcaExaminador;

    @Column(name = "MRCA_INSTRUCTOR")
    private String mrcaInstructor;
	/*
	@OneToOne(mappedBy="tbasg122Instru")
	private Tbasg100Persona tbasg100Persona;
	*/

    public String getCdgoNif() {
        return this.cdgoNif;
    }

    public void setCdgoNif(String cdgoNif) {
        this.cdgoNif = cdgoNif;
    }

    public String getDesgApell1() {
        return this.desgApell1;
    }

    public String getDesgApell2() {
        return this.desgApell2;
    }

    public String getDesgNombre() {
        return this.desgNombre;
    }

    public String getDesgUsuact() {
        return this.desgUsuact;
    }

    public Date getFchaAct() {
        return this.fchaAct;
    }

    public String getMrcaActivo() {
        return this.mrcaActivo;
    }

    public String getMrcaExaminador() {
        return this.mrcaExaminador;
    }

    public String getMrcaInstructor() {
        return this.mrcaInstructor;
    }

    public void setDesgApell1(String desgApell1) {
        this.desgApell1 = desgApell1;
    }

    public void setDesgApell2(String desgApell2) {
        this.desgApell2 = desgApell2;
    }

    public void setDesgNombre(String desgNombre) {
        this.desgNombre = desgNombre;
    }

    public void setDesgUsuact(String desgUsuact) {
        this.desgUsuact = desgUsuact;
    }

    public void setFchaAct(Date fchaAct) {
        this.fchaAct = fchaAct;
    }

    public void setMrcaActivo(String mrcaActivo) {
        this.mrcaActivo = mrcaActivo;
    }

    public void setMrcaExaminador(String mrcaExaminador) {
        this.mrcaExaminador = mrcaExaminador;
    }

    public void setMrcaInstructor(String mrcaInstructor) {
        this.mrcaInstructor = mrcaInstructor;
    }

}