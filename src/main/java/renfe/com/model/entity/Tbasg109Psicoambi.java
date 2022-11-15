package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG109_PSICOAMBI", schema = "PASG")
public class Tbasg109Psicoambi {

    @Id
    @Column(name = "CDGO_PSICAMB")
    private Integer cdgoPsicamb;


    @NotNull
    @Column(name = "CDGO_PSICAMB_FOM")
    private Integer cdgoPsicambFom;

    @NotNull
    @Column(name = "DESG_NOMBRE")
    private String desgNombre;

    @Column(name = "DESG_USUACT")
    private String desgUsuact;

    @Column(name = "FCHA_ACT")
    private Date fchaAct;

    @Column(name = "MRCA_ACTIVO")
    private String mrcaActivo;


    public Integer getCdgoPsicamb() {
        return this.cdgoPsicamb;
    }

    
    public void setCdgoPsicamb(Integer cdgoPsicamb) {
        this.cdgoPsicamb = cdgoPsicamb;
    }

    public Integer getCdgoPsicambFom() {
        return this.cdgoPsicambFom;
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

    public void setCdgoPsicambFom(Integer cdgoPsicambFom) {
        this.cdgoPsicambFom = cdgoPsicambFom;
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

}