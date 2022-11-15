package renfe.com.pdf.beans;

import java.sql.Date;
import java.util.List;

public class AcreditacionBean {
 
        
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String nif;
    private String nacionalidad;
    private String entidad;
    private String empresa;
    private List   acreditaciones;
    
    public AcreditacionBean() {
        super();
    }

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getEntidad() {
		return entidad;
	}

	public void setEntidad(String entidad) {
		this.entidad = entidad;
	}

	public List getAcreditaciones() {
		return acreditaciones;
	}

	public void setAcreditaciones(List acreditaciones) {
		this.acreditaciones = acreditaciones;
	}
    
    
    
    
    
}

