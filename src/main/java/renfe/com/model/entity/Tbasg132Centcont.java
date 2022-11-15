package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG132_CENTCONT", schema = "PASGS")
public class Tbasg132Centcont {

	@Id
	@Column(name = "CDGO_CENTCONT")
	private String cdgoCentcont;

	@NotNull
	@Column(name = "CDGO_ARETER")
	private Integer cdgoAreter;
	
	@NotNull
	@Column(name = "DESG_NOMBRE")
	private String desgNombre;

	@Column(name = "DESG_USUACT")
	private String desgUsuact;

	@Column(name = "FCHA_ACT")
	private Date fchaAct;

	@Column(name = "MRCA_ACTIVO")
	private String mrcaActivo;

	
	@Column(name = "DESG_BUZONCORREO")
	private String desgBuzoncorreo;

	public String getCdgoCentcont() {
		return this.cdgoCentcont;
	}

	public void setCdgoCentcont(String cdgoCentcont) {
		this.cdgoCentcont = cdgoCentcont;
	}

	public Integer getCdgoAreter() {
		return cdgoAreter;
	}

	public void setCdgoAreter(Integer cdgoAreter) {
		this.cdgoAreter = cdgoAreter;
	}

	public String getDesgNombre() {
		return desgNombre;
	}

	public void setDesgNombre(String desgNombre) {
		this.desgNombre = desgNombre;
	}

	public String getDesgUsuact() {
		return desgUsuact;
	}

	public void setDesgUsuact(String desgUsuact) {
		this.desgUsuact = desgUsuact;
	}

	public Date getFchaAct() {
		return fchaAct;
	}

	public void setFchaAct(Date fchaAct) {
		this.fchaAct = fchaAct;
	}

	public String getMrcaActivo() {
		return mrcaActivo;
	}

	public void setMrcaActivo(String mrcaActivo) {
		this.mrcaActivo = mrcaActivo;
	}

	public String getDesgBuzoncorreo() {
		return desgBuzoncorreo;
	}

	public void setDesgBuzoncorreo(String desgBuzoncorreo) {
		this.desgBuzoncorreo = desgBuzoncorreo;
	}

}