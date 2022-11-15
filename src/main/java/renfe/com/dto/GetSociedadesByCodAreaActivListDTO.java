package renfe.com.dto;

import java.sql.Date;

public class GetSociedadesByCodAreaActivListDTO {
    private String cdgoSociedad;
    private String descSociedad;
    private String descUsuact;
    private Date   fchaAct;
    private String mrcaActivo;

    public String getCdgoSociedad() {
        return cdgoSociedad;
    }
    public void setCdgoSociedad(String cdgoSociedad) {
        this.cdgoSociedad = cdgoSociedad;
    }
    public String getDescSociedad() {
        return descSociedad;
    }
    public void setDescSociedad(String descSociedad) {
        this.descSociedad = descSociedad;
    }
    public String getDescUsuact() {
        return descUsuact;
    }
    public void setDescUsuact(String descUsuact) {
        this.descUsuact = descUsuact;
    }
    public Date getFchaAct() {
        return fchaAct;
    }
    public void setFchaAct(Date fchaAct) {
        this.fchaAct = fchaAct;
    }
    public String getMrcaActivo() {
        return mrcaActivo;
    }
    public void setMrcaActivo(String mrcaActivo) {
        this.mrcaActivo = mrcaActivo;
    }
}
