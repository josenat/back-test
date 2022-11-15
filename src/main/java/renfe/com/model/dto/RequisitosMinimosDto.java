package renfe.com.model.dto;

public class RequisitosMinimosDto {
	private Integer cdgoPersona;
	private Integer cdgoEstudio;
	private Integer cdgoNacion;
	private String desgEstudiequiv;	
	private String desgCertcastell;
	private String desgUsuact;

	public Integer getCdgoPersona() {
		return cdgoPersona;
	}
	public void setCdgoPersona(Integer cdgoPersona) {
		this.cdgoPersona = cdgoPersona;
	}
	public Integer getCdgoEstudio() {
		return cdgoEstudio;
	}
	public void setCdgoEstudio(Integer cdgoEstudio) {
		this.cdgoEstudio = cdgoEstudio;
	}
	public Integer getCdgoNacion() {
		return cdgoNacion;
	}
	public void setCdgoNacion(Integer cdgoNacion) {
		this.cdgoNacion = cdgoNacion;
	}
	public String getDesgEstudiequiv() {
		return desgEstudiequiv;
	}
	public void setDesgEstudiequiv(String desgEstudiequiv) {
		this.desgEstudiequiv = desgEstudiequiv;
	}
	public String getDesgCertcastell() {
		return desgCertcastell;
	}
	public void setDesgCertcastell(String desgCertcastell) {
		this.desgCertcastell = desgCertcastell;
	}
	public String getDesgUsuact() {
		return desgUsuact;
	}
	public void setDesgUsuact(String desgUsuact) {
		this.desgUsuact = desgUsuact;
	}
	
}