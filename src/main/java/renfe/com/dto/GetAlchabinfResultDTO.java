package renfe.com.dto;

import java.sql.Date;

public class GetAlchabinfResultDTO{

  
    private Integer cdgoAlcHabInf;
    private Integer cdgoExpedient;
    private String usuAct;
    private Date fchaAct;
    private boolean activo;

    public Integer getCdgoAlcHabInf(){
        return cdgoAlcHabInf;        
    }

    public void setCdgoAlcHabInf (Integer cdgoAlcHabInf){
        this.cdgoAlcHabInf = cdgoAlcHabInf;
    }
    
    public Integer getCdgoExpedient(){
        return cdgoExpedient;        
    }

    public void setCdgoExpedient (Integer cdgoExpedient){
        this.cdgoExpedient = cdgoExpedient;
    }
    
    public String getUsuAct(){
        return usuAct;        
    }

    public void setUsuAct (String usuAct){
        this.usuAct = usuAct;
    }
    
    public Date getFchaAct(){
        return fchaAct;        
    }

    public void setFchaAct (Date fchaAct){
        this.fchaAct = fchaAct;
    }
    
    public boolean getActivo(){
        return activo;        
    }

    public void setActivo (boolean activo){
        this.activo = activo;
    }
    
}
