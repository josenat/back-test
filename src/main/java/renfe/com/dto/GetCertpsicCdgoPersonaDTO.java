package renfe.com.dto;


import java.sql.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GetCertpsicCdgoPersonaDTO {

	@Id
	@Column (name="CDGO_CERTPSIC")
	private Long cdgoCertpsic;
	
	@Column (name="CDGO_PERSONA")
	private Integer cdgoPersona;
	
	@Column (name="FCHA_RECONOC")
	private Date fechReconoc;
	
	@Column (name="FCHA_PROXREV")
	private Date fchaProxrev;
	
	@Column (name="MRCA_ACTIVO")
	private String mrcaActivo;
	
	@Column (name="CDGO_MOTIVO")
	private Long cdgoMotivo;
	
	@Column (name="DESC_MOTIVO")
	private String desgNombreMotivo;
	
	@Column (name="CDGO_CALIFI")
	private Long cdgoCalifi;
	
	@Column (name="DESC_CALIFI")
	private String desgNombreCalifi;
	
	@Column (name="CDGO_PSICAMB")
	private Long cdgoPsicamb;
	
	@Column (name="DESC_PSICAMB")
	private String desgNombrePsicamb;
	
	@Column (name="CDGO_CENMED")
	private Long cdgoCenmed;
	
	@Column (name="DESC_CENMED")
	private String desgNombreCenmed;
	
	@Column (name="PERS_NOMBRE")
	private String nombre;
	
	@Column (name="PERS_APELL1")
	private String apellido1;
	
	@Column (name="PERS_APELL2")
	private String apellido2;

	public Long getCdgoCertpsic() {
		return cdgoCertpsic;
	}

	public void setCdgoCertpsic(Long cdgoCertpsic) {
		this.cdgoCertpsic = cdgoCertpsic;
	}

	public Integer getCdgoPersona() {
		return cdgoPersona;
	}

	public void setCdgoPersona(Integer cdgoPersona) {
		this.cdgoPersona = cdgoPersona;
	}

	public Date getFechReconoc() {
		return fechReconoc;
	}

	public void setFechReconoc(Date fechReconoc) {
		this.fechReconoc = fechReconoc;
	}

	public Date getFchaProxrev() {
		return fchaProxrev;
	}

	public void setFchaProxrev(Date fchaProxrev) {
		this.fchaProxrev = fchaProxrev;
	}

	public String getMrcaActivo() {
		return mrcaActivo;
	}

	public void setMrcaActivo(String mrcaActivo) {
		this.mrcaActivo = mrcaActivo;
	}

	public Long getCdgoMotivo() {
		return cdgoMotivo;
	}

	public void setCdgoMotivo(Long cdgoMotivo) {
		this.cdgoMotivo = cdgoMotivo;
	}

	public String getDesgNombreMotivo() {
		return desgNombreMotivo;
	}

	public void setDesgNombreMotivo(String desgNombreMotivo) {
		this.desgNombreMotivo = desgNombreMotivo;
	}

	public Long getCdgoCalifi() {
		return cdgoCalifi;
	}

	public void setCdgoCalifi(Long cdgoCalifi) {
		this.cdgoCalifi = cdgoCalifi;
	}

	public String getDesgNombreCalifi() {
		return desgNombreCalifi;
	}

	public void setDesgNombreCalifi(String desgNombreCalifi) {
		this.desgNombreCalifi = desgNombreCalifi;
	}

	public Long getCdgoPsicamb() {
		return cdgoPsicamb;
	}

	public void setCdgoPsicamb(Long cdgoPsicamb) {
		this.cdgoPsicamb = cdgoPsicamb;
	}

	public String getDesgNombrePsicamb() {
		return desgNombrePsicamb;
	}

	public void setDesgNombrePsicamb(String desgNombrePsicamb) {
		this.desgNombrePsicamb = desgNombrePsicamb;
	}

	public Long getCdgoCenmed() {
		return cdgoCenmed;
	}

	public void setCdgoCenmed(Long cdgoCenmed) {
		this.cdgoCenmed = cdgoCenmed;
	}

	public String getDesgNombreCenmed() {
		return desgNombreCenmed;
	}

	public void setDesgNombreCenmed(String desgNombreCenmed) {
		this.desgNombreCenmed = desgNombreCenmed;
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
	
	
	
}
