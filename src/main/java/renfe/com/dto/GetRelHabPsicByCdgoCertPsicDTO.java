package renfe.com.dto;

public class GetRelHabPsicByCdgoCertPsicDTO {
	
	private Integer cdgoCertPsic;
	private Integer cdgoPsicAmb;
	private Integer cdgoTipoHab;
	private String desgNombre;
	
	public Integer getCdgoCertPsic() {
		return cdgoCertPsic;
	}
	public void setCdgoCertPsic(Integer cdgoCertPsic) {
		this.cdgoCertPsic = cdgoCertPsic;
	}
	public Integer getCdgoPsicAmb() {
		return cdgoPsicAmb;
	}
	public void setCdgoPsicAmb(Integer cdgoPsicAmb) {
		this.cdgoPsicAmb = cdgoPsicAmb;
	}
	public Integer getCdgoTipoHab() {
		return cdgoTipoHab;
	}
	public void setCdgoTipoHab(Integer cdgoTipoHab) {
		this.cdgoTipoHab = cdgoTipoHab;
	}
	public String getDesgNombre() {
		return desgNombre;
	}
	public void setDesgNombre(String desgNombre) {
		this.desgNombre = desgNombre;
	}
	
	
}
