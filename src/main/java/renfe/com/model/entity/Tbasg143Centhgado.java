package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG143_CENTHGADO", schema = "PASG")
public class Tbasg143Centhgado {

    @Id
    @Column(name = "CDGO_CENTHGADO")
    private Long cdgoCenthgado;

    @NotNull
    @Column(name = "DESG_CIF")
    private String desgCif;

    @Column(name = "DESG_DOMSOCIAL")
    private String desgDomsocial;

    @NotNull
    @Column(name = "DESG_NOMBRE")
    private String desgNombre;

    @Column(name = "DESG_USUACT")
    private String desgUsuact;

    @Column(name = "FCHA_ACT")
    private Date fchaAct;

    @Column(name = "MRCA_ACTIVO")
    private String mrcaActivo;

    /*@ManyToOne
    @JoinColumn(name = "CDGO_NACION", nullable = false, foreignKey = @ForeignKey(name = "CDGO$NAC"))
    private Tbasg134Nacion cdgoNacion;*/
    
    @Column(name = "CDGO_NACION")
    private Integer cdgoNacion;

    public Long getCdgoCenthgado() {
        return this.cdgoCenthgado;
    }

    public void setCdgoCenthgado(Long cdgoCenthgado) {
        this.cdgoCenthgado = cdgoCenthgado;
    }

    public String getDesgCif() {
        return this.desgCif;
    }

    public String getDesgDomsocial() {
        return this.desgDomsocial;
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

    public void setDesgCif(String desgCif) {
        this.desgCif = desgCif;
    }

    public void setDesgDomsocial(String desgDomsocial) {
        this.desgDomsocial = desgDomsocial;
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

    public Integer getCdgoNacion() {
        return this.cdgoNacion;
    }

    public void setCdgoNacion(Integer cdgoNacion) {
        this.cdgoNacion = cdgoNacion;
    }

}