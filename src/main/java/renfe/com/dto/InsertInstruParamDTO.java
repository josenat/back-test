package renfe.com.dto;

public class InsertInstruParamDTO {

	private String cdgoNif;
	private String nombre;
	private String apell1;
	private String apell2;
	private String usuAct;
	private boolean activo;
	private String examinador;
	private String instructor;

	public String getCdgoNif() {
		return cdgoNif;
	}

	public void setCdgoNif(String cdgoNif) {
		this.cdgoNif = cdgoNif;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApell1() {
		return apell1;
	}

	public void setApell1(String apell1) {
		this.apell1 = apell1;
	}

	public String getApell2() {
		return apell2;
	}

	public void setApell2(String apell2) {
		this.apell2 = apell2;
	}

	public String getUsuAct() {
		return usuAct;
	}

	public void setUsuAct(String usuAct) {
		this.usuAct = usuAct;
	}

	public boolean getActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public String getExaminador() {
		return examinador;
	}

	public void setExaminador(String examinador) {
		this.examinador = examinador;
	}

	public String getInstructor() {
		return instructor;
	}

	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}

}
