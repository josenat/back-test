package renfe.com.model.entity;



import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG141_ARETER", schema = "PASG")
public class Tbasg141Areter {

	@Id
	@Column(name = "CDGO_ARETER")
	private Integer cdgoAreter;

    @NotNull
    @Column(name = "CDGO_AREACT")
    private Integer cdgoAreact;

    @NotNull
    @Column(name = "DESG_NOMBRE")
    private String desgNombre;

    @Column(name = "DESG_USUACT")
    private String desgUsuact;

    @Column(name = "FCHA_ACT")
    private Date fchaAct;


    @Column(name = "MRCA_ACTIVO")
    private String mrcaActivo;


	public Integer getCdgoAreter() {
		return cdgoAreter;
	}

	public void setCdgoAreter(Integer cdgoAreter) {
		this.cdgoAreter = cdgoAreter;
	}


    public Integer getCdgoAreact() {
        return this.cdgoAreact;
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


    public void setCdgoAreact(Integer cdgoAreact) {
        this.cdgoAreact = cdgoAreact;
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