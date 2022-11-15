package renfe.com.dto;



import java.sql.Date;


import org.springframework.format.annotation.DateTimeFormat;

public class SetExpedientesPersonaListDTO {

	
	private String desgNifpas;
	
	
	private String desgMatricula;

	
	private String desgNombre;
	
	
	private String desgApell1;
	

	private String desgApell2;
	
	
	private Integer cdgoAreact;
	
	
	private Integer cdgoAreter;
	
	
	private String cdgoCentcont;
	
	
	private String mrcaActivo;
	
	
	private Integer cdgoTipoHab;
	
	
	private Integer[] cdgoEmpresa;
	

	private String personal;
	
	
	private String cdgoEstadoAcre;
	
	
	private String cdgoTipoAcre;
	
	
	private Integer cdgoEstadoHab;


	public String getDesgNifpas() {
		return desgNifpas;
	}


	public void setDesgNifpas(String desNifPas) {
		this.desgNifpas = desNifPas;
	}


	public String getDesgMatricula() {
		return desgMatricula;
	}


	public void setDesgMatricula(String desgMatricula) {
		this.desgMatricula = desgMatricula;
	}


	public String getDesgNombre() {
		return desgNombre;
	}


	public void setDesgNombre(String desgNombre) {
		this.desgNombre = desgNombre;
	}


	public String getDesgApell1() {
		return desgApell1;
	}


	public void setDesgApell1(String desgApell1) {
		this.desgApell1 = desgApell1;
	}


	public String getDesgApell2() {
		return desgApell2;
	}


	public void setDesgApell2(String desgApell2) {
		this.desgApell2 = desgApell2;
	}


	public Integer getCdgoAreact() {
		return cdgoAreact;
	}


	public void setCdgoAreact(Integer cdgoAreact) {
		this.cdgoAreact = cdgoAreact;
	}


	public Integer getCdgoAreter() {
		return cdgoAreter;
	}


	public void setCdgoAreter(Integer cdgoAreter) {
		this.cdgoAreter = cdgoAreter;
	}


	public String getCdgoCentcont() {
		return cdgoCentcont;
	}


	public void setCdgoCentcont(String cdgoCentcont) {
		this.cdgoCentcont = cdgoCentcont;
	}


	public String getMrcaActivo() {
		return mrcaActivo;
	}


	public void setMrcaActivo(String mrcaActivo) {
		this.mrcaActivo = mrcaActivo;
	}


	public Integer getCdgoTipoHab() {
		return cdgoTipoHab;
	}


	public void setCdgoTipoHab(Integer cdgoTipoHab) {
		this.cdgoTipoHab = cdgoTipoHab;
	}

	public String getCdgoTipoAcre() {
		return cdgoTipoAcre;
	}


	public void setCdgoTipoAcre(String cdgoTipoAcre) {
		this.cdgoTipoAcre = cdgoTipoAcre;
	}


	public String getCdgoEstadoAcre() {
		return cdgoEstadoAcre;
	}


	public void setCdgoEstadoAcre(String cdgoEstadoAcre) {
		this.cdgoEstadoAcre = cdgoEstadoAcre;
	}


	public Integer getCdgoEstadoHab() {
		return cdgoEstadoHab;
	}


	public void setCdgoEstadoHab(Integer cdgoEstadoHab) {
		this.cdgoEstadoHab = cdgoEstadoHab;
	}
	
	public Integer[] getCdgoEmpresa() {
		return cdgoEmpresa;
	}
	

	public void setCdgoEmpresa(Integer[] cdgoEmpresa) {
		this.cdgoEmpresa = cdgoEmpresa;
	}
//	public Integer[] getCdgoEmpresa() {
//		return cdgoEmpresa;
//	}

	public String getPersonal() {
		return personal;
	}


	public void setPersonal(String personal) {
		this.personal = personal;
	}
	
}

