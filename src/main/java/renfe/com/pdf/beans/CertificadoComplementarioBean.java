package renfe.com.pdf.beans;

import java.util.List;

public class CertificadoComplementarioBean {

    private String nifPas;
    private String numRef;
    private String apellidos;
    private String nombre;
    private String matricula;
    private String lugarNacimiento;
    private String fchaNacimiento;
    private String nacionalidad;
    private String direccionPostal;
    private String localidad;
    private String locPais;
    private String fchaExpedicion;
    private String fchaExpiracion;
    
	private List listConocimientos;
     
	private List listMaterial;
    private List listLineas;
    private List listTramos;
    private int CdgoAreaAct;
    private String corrVisual;
    private String protAudi;
    private String Fechaexpedient;

    private String restrinRam;
 
    private List listInformacionAdic;

    private boolean numEin;
    

    
    public CertificadoComplementarioBean(){
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
	/**
	 * @return Devuelve nacionalidad.
	 */
	public String getNacionalidad() {
		return nacionalidad;
	}
	/**
	 * @param nacionalidad El nacionalidad a establecer.
	 */
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	/**
	 * @return Devuelve numRef.
	 */
	public String getNumRef() {
		return numRef;
	}
	/**
	 * @param numRef El numRef a establecer.
	 */
	public void setNumRef(String numRef) {
		this.numRef = numRef;
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
	 * @return Devuelve matricula.
	 */
	public String getMatricula() {
		return matricula;
	}
	/**
	 * @param matricula El matricula a establecer.
	 */
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	/**
	 * @return Devuelve lugarNacimiento.
	 */
	public String getLugarNacimiento() {
		return lugarNacimiento;
	}
	/**
	 * @param lugarNacimiento El lugarNacimiento a establecer.
	 */
	public void setLugarNacimiento(String lugarNacimiento) {
		this.lugarNacimiento = lugarNacimiento;
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
	 * @return Devuelve direccionPostal.
	 */
	public String getDireccionPostal() {
		return direccionPostal;
	}
	/**
	 * @param direccionPostal El direccionPostal a establecer.
	 */
	public void setDireccionPostal(String direccionPostal) {
		this.direccionPostal = direccionPostal;
	}
	/**
	 * @return Devuelve localidad.
	 */
	public String getLocalidad() {
		return localidad;
	}
	/**
	 * @param localidad El localidad a establecer.
	 */
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	/**
	 * @return Devuelve locPais.
	 */
	public String getLocPais() {
		return locPais;
	}
	/**
	 * @param locPais El locPais a establecer.
	 */
	public void setLocPais(String locPais) {
		this.locPais = locPais;
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
	/**
	 * @return Devuelve listConocimientos.
	 */
	public List getListConocimientos() {
		return listConocimientos;
	}
	/**
	 * @param listConocimientos El listConocimientos a establecer.
	 */
	public void setListConocimientos(List listConocimientos) {
		this.listConocimientos = listConocimientos;
	}
	/**
	 * @return Devuelve listLineas.
	 */
	public List getListLineas() {
		return listLineas;
	}
	/**
	 * @param listLineas El listLineas a establecer.
	 */
	public void setListLineas(List listLineas) {
		this.listLineas = listLineas;
	}
	/**
	 * @return Devuelve listMaterial.
	 */
	public List getListMaterial() {
		return listMaterial;
	}
	/**
	 * @param listMateriales El listMaterial a establecer.
	 */
	public void setListMaterial(List listMaterial) {
		this.listMaterial = listMaterial;
	}
	/**
	 * @return Devuelve listTramos.
	 */
	public List getListTramos() {
		return listTramos;
	}
	/**
	 * @param listTramos El listTramos a establecer.
	 */
	public void setListTramos(List listTramos) {
		this.listTramos = listTramos;
	}
	/**
	 * @param nifPas El nifPas a establecer.
	 */
	public void setrestrinRam(String restrinRam) {
		this.restrinRam = restrinRam;
	}
	/**
	 * @return Devuelve nacionalidad.
	 */
	public String getrestrinRam() {
		return restrinRam;
	}	
	
	//PPM102758 - Modificaciones en el certificado complementario - INICIO
	public void setListInformacionAdic(List listInformacionAdic) {
		this.listInformacionAdic = listInformacionAdic;
	}


	public List getListInformacionAdic() {
		return listInformacionAdic;
	}
	//PPM102758 - Modificaciones en el certificado complementario - FIN
	
	/**
	 * @return Código de área de actividad
	 */
	public int getCdgoAreaAct() {
		return CdgoAreaAct;
	}
	/**
	 * @param Código de área de actividad a establecer.
	 */
	public void setCdgoAreaAct(int CdgoAreaAct) {
		this.CdgoAreaAct = CdgoAreaAct;
	}
	
	public String getCorrVisual() {
		return corrVisual;
	}


	public void setCorrVisual(String corrVisual) {
		this.corrVisual = corrVisual;
	}


	public String getProtAudi() {
		return protAudi;
	}


	public void setProtAudi(String protAudi) {
		this.protAudi = protAudi;
	}
	
	public String getFechaexpedient() {
		return Fechaexpedient;
	}


	public void setFechaexpedient(String fechaexpedient) {
		Fechaexpedient = fechaexpedient;
	}

	//INICIO PPM 167980 06/06/2019
	public boolean isNumEin() {
		return numEin;
	}

	public void setNumEin(boolean numEin) {
		this.numEin = numEin;
	}
	//FIN PPM 167980 06/06/2019
	
}

