package renfe.com.dto;

public class GetExpeTipoValidezReciclajeDTO {

	private Integer cdgoExpedient;
	private Integer cdgoTipoHab;
	private Integer validezReciclaje;
	
	public Integer getCdgoExpedient() {
		return cdgoExpedient;
	}
	public void setCdgoExpedient(Integer cdgoExpedient) {
		this.cdgoExpedient = cdgoExpedient;
	}
	public Integer getCdgoTipoHab() {
		return cdgoTipoHab;
	}
	public void setCdgoTipoHab(Integer cdgoTipoHab) {
		this.cdgoTipoHab = cdgoTipoHab;
	}
	public Integer getValidezReciclaje() {
		return validezReciclaje;
	}
	public void setValidezReciclaje(Integer validezReciclaje) {
		this.validezReciclaje = validezReciclaje;
	}
	
	
}
