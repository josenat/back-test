package renfe.com.dto;

public class GetPersempParametersDTO {
   
	private Integer cdgoEmpresa;
	private Integer cdgoPersona;
    private String desgUsuact;
    private String fchaAct;
    private String mrcaActivo;

	public Integer getCdgoEmpresa() {
		return this.cdgoEmpresa;
	}    
	public void setCdgoEmpresa(Integer cdgoEmpresa) {
		this.cdgoEmpresa = cdgoEmpresa;
	}

	public Integer getCdgoPersona() {
		return this.cdgoPersona;
	}

	public void setCdgoPersona(Integer cdgoPersona) {
		this.cdgoPersona = cdgoPersona;
	}	

	public String getDesgUsuact() {
		return this.desgUsuact;
	}

	public void setDesgUsuact(String desgUsuact) {
		this.desgUsuact = desgUsuact;
	}  
    
	public String getFchaAct() {
		return this.fchaAct;
	}

	public void setFchaAct(String fchaAct) {
		this.fchaAct = fchaAct;
	}    

	public String getMrcaActivo() {
		return this.mrcaActivo;
	}

	public void setMrcaActivo(String mrcaActivo) {
		this.mrcaActivo = mrcaActivo;
	}    
}
