package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG101_CERTPSIC", schema = "PASG")
public class Tbasg101Certpsic {

    @Id
    @Column(name = "CDGO_CERTPSIC")
    private Integer cdgoCertpsic;

    @Column(name = "CADUCADO_ILT")
    private String caducadoIlt;

    @Column(name = "CDGO_DEOBS")
    private String cdgoDeobs;

    @NotNull
    @Column(name = "CDGO_PERSONA")
    private Integer cdgoPersona;

    @Column(name = "DESG_USUACT")
    private String desgUsuact;

    @Column(name = "FCHA_ACT")
    private Date fchaAct;

    @Column(name = "FCHA_LIMTEMP")
    private Date fchaLimtemp;

    @NotNull
    @Column(name = "FCHA_PROXREV")
    private Date fchaProxrev;

    @Column(name = "FCHA_RECONOC")
    private Date fchaReconoc;

    @Column(name = "MRCA_ACTIVO")
    private String mrcaActivo;

    @Column(name = "MRCA_CORRVISUAL")
    private String mrcaCorrvisual;

    @Column(name = "MRCA_PROTAUD")
    private String mrcaProtaud;

	@Column(name = "CDGO_MOTIVO")
	private String cdgoMotivo;
	
	@Column(name = "CDGO_CALIFI")
	private String cdgoCalifi;
	
	@Column(name = "CDGO_CENMED")
	private String cdgoCenmed;
	
	@Column(name = "CDGO_PSICAMB")
	private Integer cdgoPsicamb;
	
	@Column(name = "CDGO_FACULT")
	private String cdgoFacult;

	public Tbasg101Certpsic() {
    }
	public Tbasg101Certpsic(Integer cdgoCertpsic, String caducadoIlt, String cdgoDeobs, Integer cdgoPersona, String desgUsuact, Date fchaAct,
			Date fchaLimtemp, Date fchaProxrev, Date fchaReconoc, String mrcaActivo, String mrcaCorrvisual, String mrcaProtaud,
			String cdgoCalifi,String cdgoCenmed, String cdgoFacult, String cdgoMotivo, String cdgoPsicamb) {		
		
		this.cdgoCertpsic = cdgoCertpsic;
	}
	

	public Integer getCdgoCertpsic() {
		return this.cdgoCertpsic;
	}

	public void setCdgoCertpsic(Integer cdgoCertpsic) {
		this.cdgoCertpsic = cdgoCertpsic;
	}

    public String getCaducadoIlt() {
        return this.caducadoIlt;
    }

    public String getCdgoDeobs() {
        return this.cdgoDeobs;
    }

    public Integer getCdgoPersona() {
        return this.cdgoPersona;
    }

    public String getDesgUsuact() {
        return this.desgUsuact;
    }

    public Date getFchaAct() {
        return this.fchaAct;
    }

    public Date getFchaLimtemp() {
        return this.fchaLimtemp;
    }

    public Date getFchaProxrev() {
        return this.fchaProxrev;
    }

    public Date getFchaReconoc() {
        return this.fchaReconoc;
    }

    public String getMrcaActivo() {
        return this.mrcaActivo;
    }

    public String getMrcaCorrvisual() {
        return this.mrcaCorrvisual;
    }

    public void setMrcaActivo(String mrcaActivo) {
        this.mrcaActivo = mrcaActivo;
    }
    public void setMrcaCorrvisual(String mrcaCorrvisual) {
        this.mrcaCorrvisual = mrcaCorrvisual;
    }
    public void setMrcaProtaud(String mrcaProtaud) {
        this.mrcaProtaud = mrcaProtaud;
    }
    public String getMrcaProtaud() {
        return this.mrcaProtaud;
    }

    public void setCaducadoIlt(String caducadoIlt) {
        this.caducadoIlt = caducadoIlt;
    }

    public void setCdgoDeobs(String cdgoDeobs) {
        this.cdgoDeobs = cdgoDeobs;
    }

    public void setCdgoPersona(Integer cdgoPersona) {
        this.cdgoPersona = cdgoPersona;
    }

    public void setDesgUsuact(String desgUsuact) {
        this.desgUsuact = desgUsuact;
    }

    public void setFchaAct(Date fchaAct) {
        this.fchaAct = fchaAct;
    }

    public void setFchaLimtemp(Date fchaLimtemp) {
        this.fchaLimtemp = fchaLimtemp;
    }

    public void setFchaProxrev(Date fchaProxrev) {
        this.fchaProxrev = fchaProxrev;
    }

    public void setFchaReconoc(Date fchaReconoc) {
        this.fchaReconoc = fchaReconoc;
    }

	public String getCdgoCalifi() {
		return this.cdgoCalifi;
	}

	public String getCdgoCenmed() {
		return this.cdgoCenmed;
	}

	public String getCdgoFacult() {
		return this.cdgoFacult;
	}

	public String getCdgoMotivo() {
		return this.cdgoMotivo;
	}

	public Integer getCdgoPsicamb() {
		return this.cdgoPsicamb;
	}

	public void setCdgoCalifi(String cdgoCalifi) {
		this.cdgoCalifi = cdgoCalifi;
	}

	public void setCdgoCenmed(String cdgoCenmed) {
		this.cdgoCenmed = cdgoCenmed;
	}

	public void setCdgoFacult(String cdgoFacult) {
		this.cdgoFacult = cdgoFacult;
	}

	public void setCdgoMotivo(String cdgoMotivo) {
		this.cdgoMotivo = cdgoMotivo;
	}

	public void setCdgoPsicamb(Integer cdgoPsicamb) {
		this.cdgoPsicamb = cdgoPsicamb;
	}

}