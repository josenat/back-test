package renfe.com.dto;

public class UpdateCentHgadoParamDTO {

	private String nombre;
	private String domSocial;
	private Integer cdgoNacion;
	private String usuAct;
	private String cif;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDomSocial() {
		return domSocial;
	}

	public void setDomSocial(String domSocial) {
		this.domSocial = domSocial;
	}

	public Integer getCdgoNacion() {
		return cdgoNacion;
	}

	public void setCdgoNacion(Integer cdgoNacion) {
		this.cdgoNacion = cdgoNacion;
	}

	public String getUsuAct() {
		return usuAct;
	}

	public void setUsuAct(String usuAct) {
		this.usuAct = usuAct;
	}

	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

}
