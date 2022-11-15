package renfe.com.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GetPerByEstadoListResultDTO {
	
	@Id
	@Column(name = "CDGO_PERSONA")
	private Integer cdgoPersona;
	@Column(name = "DESG_NIFPAS")
	private String nif;
	@Column(name = "DESG_MATRICULA")
	private String matricula;
	@Column(name = "DESG_NOMBRE")
	private String nombre;
	@Column(name = "DESG_APELL1")
	private String apell1;
	@Column(name = "DESG_APELL2")
	private String apell2;
	@Column(name = "CDGO_AREACT")
	private Integer cdgoAreAct;
	@Column(name = "CDGO_ARETER")
	private Integer cdgoAreTer;
	@Column(name = "CDGO_CENTCONT")
	private String cdgoCentCont;
	@Column(name = "AREACTNAME")
	private String areActName;
	@Column(name = "ARETERNAME")
	private String areTerName;
	@Column(name = "CENTCONTNAME")
	private String centContName;

	public Integer getCdgoPersona() {
		return cdgoPersona;
	}

	public void setCdgoPersona(Integer cdgoPersona) {
		this.cdgoPersona = cdgoPersona;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
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

	public Integer getCdgoAreAct() {
		return cdgoAreAct;
	}

	public void setCdgoAreAct(Integer cdgoAreAct) {
		this.cdgoAreAct = cdgoAreAct;
	}

	public Integer getCdgoAreTer() {
		return cdgoAreTer;
	}

	public void setCdgoAreTer(Integer cdgoAreTer) {
		this.cdgoAreTer = cdgoAreTer;
	}

	public String getCdgoCentCont() {
		return cdgoCentCont;
	}

	public void setCdgoCentCont(String cdgoCentCont) {
		this.cdgoCentCont = cdgoCentCont;
	}

	public String getAreActName() {
		return areActName;
	}

	public void setAreActName(String areActName) {
		this.areActName = areActName;
	}

	public String getAreTerName() {
		return areTerName;
	}

	public void setAreTerName(String areTerName) {
		this.areTerName = areTerName;
	}

	public String getCentContName() {
		return centContName;
	}

	public void setCentContName(String centContName) {
		this.centContName = centContName;
	}

}
