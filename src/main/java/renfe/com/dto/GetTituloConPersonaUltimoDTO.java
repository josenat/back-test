package renfe.com.dto;

import java.sql.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG102_TITULOCON", schema = "PASG")
public class GetTituloConPersonaUltimoDTO {
	
	public GetTituloConPersonaUltimoDTO(Long cdgoTit, Integer cdgoPersona, Date fchaOtorgado, String desgTiptit, String desgUsuact,
			Date fchaAct, String mrcaActivo, String desgSoloram, Date fchaTipejerprof, Integer cdgoEstado) {
				
		this.cdgoTit = cdgoTit;
		this.cdgoPersona = cdgoPersona;
		this.fchaOtorgado = fchaOtorgado;
		this.desgTiptit = desgTiptit;
		this.desgUsuact = desgUsuact;
		this.fchaAct = fchaAct;
		this.mrcaActivo = mrcaActivo;
		this.desgSoloram = desgSoloram;
		this.fchaTipejerprof = fchaTipejerprof;		
		this.cdgoEstado = cdgoEstado;
		}

	public GetTituloConPersonaUltimoDTO() {		
	}

    @Id
    @Column(name = "CDGO_TIT")
    private Long cdgoTit;

    @NotNull
    @Column(name = "CDGO_PERSONA", nullable = false)
    private Integer cdgoPersona;

    @NotNull
    @Column(name = "DESG_SOLORAM", nullable = false)
    private String desgSoloram;

    @Column(name = "DESG_TIPTIT")
    private String desgTiptit;

    @Column(name = "DESG_USUACT")
    private String desgUsuact;

    @Column(name = "FCHA_ACT")
    private Date fchaAct;

    @Column(name = "FCHA_OTORGADO")
    private Date fchaOtorgado;

    @Column(name = "FCHA_TIPEJERPROF")
    private Date fchaTipejerprof;

    @Column(name = "MRCA_ACTIVO")
    private String mrcaActivo;
    
    @Column(name = "CDGO_ESTADO")
    private Integer cdgoEstado;

    public Long getCdgoTit() {
        return this.cdgoTit;
    }

    public void setCdgoTit(Long cdgoTit) {
        this.cdgoTit = cdgoTit;
    }

    public Integer getCdgoPersona() {
        return this.cdgoPersona;
    }

    public String getDesgSoloram() {
        return this.desgSoloram;
    }

    public String getDesgTiptit() {
        return this.desgTiptit;
    }

    public String getDesgUsuact() {
        return this.desgUsuact;
    }

    public Date getFchaAct() {
        return this.fchaAct;
    }

    public Date getFchaOtorgado() {
        return this.fchaOtorgado;
    }

    public Date getFchaTipejerprof() {
        return this.fchaTipejerprof;
    }

    public String getMrcaActivo() {
        return this.mrcaActivo;
    }

    public void setCdgoPersona(Integer cdgoPersona) {
        this.cdgoPersona = cdgoPersona;
    }

    public void setDesgSoloram(String desgSoloram) {
        this.desgSoloram = desgSoloram;
    }

    public void setDesgTiptit(String desgTiptit) {
        this.desgTiptit = desgTiptit;
    }

    public void setDesgUsuact(String desgUsuact) {
        this.desgUsuact = desgUsuact;
    }

    public void setFchaAct(Date fchaAct) {
        this.fchaAct = fchaAct;
    }

    public void setFchaOtorgado(Date fchaOtorgado) {
        this.fchaOtorgado = fchaOtorgado;
    }

    public void setFchaTipejerprof(Date fchaTipejerprof) {
        this.fchaTipejerprof = fchaTipejerprof;
    }

    public void setMrcaActivo(String mrcaActivo) {
        this.mrcaActivo = mrcaActivo;
    }

	public Integer getCdgoEstado() {
		return cdgoEstado;
	}

	public void setCdgoEstado(Integer cdgoEstado) {
		this.cdgoEstado = cdgoEstado;
	}

}
