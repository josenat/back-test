package renfe.com.pdf.beans;

import java.util.List;

public class CertificadoComplementarioAOTBean {

  private String nifPas;
  private String matricula;
  private String apellidos;
  private String nombre;
  private String fchaNacimiento;
  private String fchaExpedicion;
  private String fchaExpiracion;
  private List listInformacionAdic;
  private List listObservaciones;
  private String empresa;
  private String fchaFinPsicoFisico;
  private int CdgoAreaAct;
      
  public CertificadoComplementarioAOTBean(){
  	super();
  }
  
  
	/**
	 * @return Devuelve nifPas.
	 */
	public String getNifPas() {
		return nifPas;
	}
	/**
	 * @param nifPas El nifPas a establecer.
	 */
	public void setNifPas(String nifPas) {
		this.nifPas = nifPas;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}


	public String getMatricula() {
		return matricula;
	}


	/**
	 * @return Devuelve apellidos.
	 */
	public String getApellidos() {
		return apellidos;
	}
	/**
	 * @param apellidos El apellidos a establecer.
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	/**
	 * @return Devuelve nombre.
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre El nombre a establecer.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return Devuelve fchaNacimiento.
	 */
	public String getFchaNacimiento() {
		return fchaNacimiento;
	}
	/**
	 * @param fchaNacimiento El fchaNacimiento a establecer.
	 */
	public void setFchaNacimiento(String fchaNacimiento) {
		this.fchaNacimiento = fchaNacimiento;
	}
	/**
	 * @return Devuelve fchaExpedicion.
	 */
	public String getFchaExpedicion() {
		return fchaExpedicion;
	}
	/**
	 * @param fchaExpedicion El fchaExpedicion a establecer.
	 */
	public void setFchaExpedicion(String fchaExpedicion) {
		this.fchaExpedicion = fchaExpedicion;
	}
	/**
	 * @return Devuelve fchaExpiracion.
	 */
	public String getFchaExpiracion() {
		return fchaExpiracion;
	}
	/**
	 * @param fchaExpiracion El fchaExpiracion a establecer.
	 */
	public void setFchaExpiracion(String fchaExpiracion) {
		this.fchaExpiracion = fchaExpiracion;
	}
	
	public void setListInformacionAdic(List listInformacionAdic) {
		this.listInformacionAdic = listInformacionAdic;
	}

	public List getListInformacionAdic() {
		return listInformacionAdic;
	}
	//INICIO PPM 168672 23/05/2019 
	public List getListObservaciones() {
		return listObservaciones;
	}

	public void setListObservaciones(List listObservaciones) {
		this.listObservaciones = listObservaciones;
	}
	// FIN PPM 168672 23/05/2019 

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getEmpresa() {
		return empresa;
	}
	
	public void setFchaFinPsicoFisico(String fchaFinPsicoFisico) {
		this.fchaFinPsicoFisico = fchaFinPsicoFisico;
	}
	
	public String getFchaFinPsicoFisico() {
		return fchaFinPsicoFisico;
	}

	public void setCdgoAreaAct(int CdgoAreaAct) {
		this.CdgoAreaAct = CdgoAreaAct;
	}

	public int getCdgoAreaAct() {
		return CdgoAreaAct;
	}
	
}

