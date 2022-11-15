package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG110_PSICOMOTI", schema = "PASG")
public class Tbasg110Psicomoti {

    @Id
    @Column(name = "CDGO_MOTIVO")
    private Integer cdgoMotivo;


    @NotNull
    @Column(name = "DESG_NOMBRE")
    private String desgNombre;

    @Column(name = "DESG_USUACT")
    private String desgUsuact;

    @Column(name = "FCHA_ACT")
    private Date fchaAct;

    @Column(name = "MRCA_ACTIVO")
    private String mrcaActivo;


    public Integer getCdgoMotivo() {

        return this.cdgoMotivo;
    }


    public void setCdgoMotivo(Integer cdgoMotivo) {

        this.cdgoMotivo = cdgoMotivo;
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