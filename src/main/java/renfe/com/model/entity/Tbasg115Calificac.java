package renfe.com.model.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG115_CALIFICAC", schema = "PASG")
public class Tbasg115Calificac {

	public Tbasg115Calificac() {
		// TODO Auto-generated constructor stub
	}
	
	public Tbasg115Calificac(Integer cdgoCalifi) {
		super();
		this.cdgoCalifi = cdgoCalifi;
	}

	@Id
	@Column(name = "CDGO_CALIFI")
	private Integer cdgoCalifi;

	@NotNull
	@Column(name = "DESG_NOMBRE")
	private String desgNombre;

	@NotNull
	@Column(name = "DESG_TIPOCALIF")
	private String desgTipocalif;

	@Column(name = "DESG_USUACT")
	private String desgUsuact;

	@Column(name = "FCHA_ACT")
	private Date fchaAct;

	@Column(name = "MRCA_ACTIVO")
	private String mrcaActivo;

	public Integer getCdgoCalifi() {
		return this.cdgoCalifi;
	}

	public void setCdgoCalifi(Integer cdgoCalifi) {
		this.cdgoCalifi = cdgoCalifi;
	}

	public String getDesgNombre() {
		return this.desgNombre;
	}

	public String getDesgTipocalif() {
		return this.desgTipocalif;
	}

	public String getDesgUsuact() {
		return this.desgUsuact;
	}

	public Date getFchaAct() {
		return this.fchaAct;
	}

	public String getMrcaActivo() {
		return this.mrcaActivo;
	}

	public void setDesgNombre(String desgNombre) {
		this.desgNombre = desgNombre;
	}

	public void setDesgTipocalif(String desgTipocalif) {
		this.desgTipocalif = desgTipocalif;
	}

	public void setDesgUsuact(String desgUsuact) {
		this.desgUsuact = desgUsuact;
	}

	public void setFchaAct(Date fchaAct) {
		this.fchaAct = fchaAct;
	}

	public void setMrcaActivo(String mrcaActivo) {
		this.mrcaActivo = mrcaActivo;
	}
	
}