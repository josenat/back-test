package renfe.com.dto;

public class GetExpeAcreTipoValidezReciclajeDTO {

	private Integer cdgoAcredita;
	private String cdgoTipoAcr;
	private Integer validezReciclaje;
	
	public Integer getCdgoAcredita() {
		return cdgoAcredita;
	}
	public void setCdgoAcredita(Integer cdgoAcredita) {
		this.cdgoAcredita = cdgoAcredita;
	}
	public String getCdgoTipoAcr() {
		return cdgoTipoAcr;
	}
	public void setCdgoTipoAcr(String cdgoTipoAcr) {
		this.cdgoTipoAcr = cdgoTipoAcr;
	}
	public Integer getValidezReciclaje() {
		return validezReciclaje;
	}
	public void setValidezReciclaje(Integer validezReciclaje) {
		this.validezReciclaje = validezReciclaje;
	}
	
}
