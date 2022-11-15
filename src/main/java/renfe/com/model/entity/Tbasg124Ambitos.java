package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG124_AMBITOS", schema = "PASG")
public class Tbasg124Ambitos {

	@Id
	@Column(name = "CDGO_AMBITOS")
	private Long cdgoAmbitos;

	@Column(name = "CDGO_GERENCIA")
	private String cdgoGerencia;

	@NotNull
	@Column(name = "CDGO_TIPOHAB")
	private Integer cdgoTipohab;

	@NotNull
	@Column(name = "DESG_NOMBRE")
	private String desgNombre;

	@Column(name = "DESG_USUACT")
	private String desgUsuact;

	@Column(name = "FCHA_ACT")
	private Date fchaAct;

	@Column(name = "MRCA_ACTIVO")
	private String mrcaActivo;

	/*@ManyToOne
	@JoinColumn(name = "CDGO_PROVINCIA", nullable = false, foreignKey = @ForeignKey(name = "CDGO$PRO"))
	private Tbasg106Provincia cdgoProvincia;*/
	
	@Column(name = "CDGO_PROVINCIA")
	private Integer cdgoProvincia;

	/*@ManyToOne
	@JoinColumn(name = "CDGO_TIPODEP", nullable = false, foreignKey = @ForeignKey(name = "CDGO$TIP"))
	private Tbasg140Tidepenci cdgoTipodep;*/
	
	@Column(name = "CDGO_TIPODEP")
	private Integer cdgoTipodep;

	public Long getCdgoAmbitos() {
		return this.cdgoAmbitos;
	}

	public void setCdgoAmbitos(Long cdgoAmbitos) {
		this.cdgoAmbitos = cdgoAmbitos;
	}

	public String getCdgoGerencia() {
		return this.cdgoGerencia;
	}

	public Integer getCdgoTipohab() {
		return this.cdgoTipohab;
	}

	public String getDesgNombre() {
		return this.desgNombre;
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

	public void setCdgoGerencia(String cdgoGerencia) {
		this.cdgoGerencia = cdgoGerencia;
	}

	public void setCdgoTipohab(Integer cdgoTipohab) {
		this.cdgoTipohab = cdgoTipohab;
	}

	public void setDesgNombre(String desgNombre) {
		this.desgNombre = desgNombre;
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

	public Integer getCdgoProvincia() {
		return this.cdgoProvincia;
	}

	public Integer getCdgoTipodep() {
		return this.cdgoTipodep;
	}

	public void setCdgoProvincia(Integer cdgoProvincia) {
		this.cdgoProvincia = cdgoProvincia;
	}

	public void setCdgoTipodep(Integer cdgoTipodep) {
		this.cdgoTipodep = cdgoTipodep;
	}

}