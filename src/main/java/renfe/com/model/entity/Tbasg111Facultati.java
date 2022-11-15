package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG111_FACULTATI", schema = "PASG")
public class Tbasg111Facultati {

	public Tbasg111Facultati() {
		// TODO Auto-generated constructor stub
	}
	
		
	public Tbasg111Facultati(Integer cdgoFacult) {
		super();
		this.cdgoFacult = cdgoFacult;
	}


	@Id
	@Column(name = "CDGO_FACULT")
	private Integer cdgoFacult;

	@NotNull
	@Column(name = "DESG_APELL1")
	private String desgApell1;

	@Column(name = "DESG_APELL2")
	private String desgApell2;

	@NotNull
	@Column(name = "DESG_NOMBRE")
	private String desgNombre;

	@NotNull
	@Column(name = "DESG_NUMCOLEGIADO")
	private String desgNumcolegiado;

	@Column(name = "DESG_USUACT")
	private String desgUsuact;

	@Column(name = "FCHA_ACT")
	private Date fchaAct;

	@Column(name = "MRCA_ACTIVO")
	private String mrcaActivo;
	
	@Column(name = "CDGO_CENMED")
	private Integer cdgoCenmed;

	/*@ManyToOne
	@JoinColumn(name = "CDGO_CENMED", nullable = true, foreignKey = @ForeignKey(name = "CDGO$CEN"))
	private Tbasg108Centmedic cdgoCenmed;*/

	public Integer getCdgoFacult() {
		return this.cdgoFacult;
	}

	public void setCdgoFacult(Integer cdgoFacult) {
		this.cdgoFacult = cdgoFacult;
	}

	public String getDesgApell1() {
		return this.desgApell1;
	}

	public String getDesgApell2() {
		return this.desgApell2;
	}

	public String getDesgNombre() {
		return this.desgNombre;
	}

	public String getDesgNumcolegiado() {
		return this.desgNumcolegiado;
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

	public void setDesgApell1(String desgApell1) {
		this.desgApell1 = desgApell1;
	}

	public void setDesgApell2(String desgApell2) {
		this.desgApell2 = desgApell2;
	}

	public void setDesgNombre(String desgNombre) {
		this.desgNombre = desgNombre;
	}

	public void setDesgNumcolegiado(String desgNumcolegiado) {
		this.desgNumcolegiado = desgNumcolegiado;
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

	public Integer getCdgoCenmed() {
		return this.cdgoCenmed;
	}

	public void setCdgoCenmed(Integer cdgoCenmed) {
		this.cdgoCenmed = cdgoCenmed;
	}

}