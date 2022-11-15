package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG220_USUARIOS_EXTERNOS", schema = "PASG")
public class Tbasg220UsuariosExternos {

	@Id
	@Column(name = "T220_CDGO_USU_EXT")
	private Long t220CdgoUsuExt;

	@NotNull
	@Column(name = "T220_CDGO_EMPRESA")
	private Integer t220CdgoEmpresa;

	@NotNull
	@Column(name = "T220_CDGO_USUARIO")
	private String t220CdgoUsuario;

	@NotNull
	@Column(name = "T220_DESG_USUACT")
	private String t220DesgUsuact;

	@Column(name = "T220_FCHA_ACT")
	private Date t220FchaAct;

	@NotNull
	@Column(name = "T220_MRCA_ACTIVO")
	private String t220MrcaActivo;

	public Long getT220CdgoUsuExt() {
		return this.t220CdgoUsuExt;
	}

	public void setT220CdgoUsuExt(Long t220CdgoUsuExt) {
		this.t220CdgoUsuExt = t220CdgoUsuExt;
	}

	public Integer getT220CdgoEmpresa() {
		return this.t220CdgoEmpresa;
	}

	public String getT220CdgoUsuario() {
		return this.t220CdgoUsuario;
	}

	public String getT220DesgUsuact() {
		return this.t220DesgUsuact;
	}

	public Date getT220FchaAct() {
		return this.t220FchaAct;
	}

	public String getT220MrcaActivo() {
		return this.t220MrcaActivo;
	}

	public void setT220CdgoEmpresa(Integer t220CdgoEmpresa) {
		this.t220CdgoEmpresa = t220CdgoEmpresa;
	}

	public void setT220CdgoUsuario(String t220CdgoUsuario) {
		this.t220CdgoUsuario = t220CdgoUsuario;
	}

	public void setT220DesgUsuact(String t220DesgUsuact) {
		this.t220DesgUsuact = t220DesgUsuact;
	}

	public void setT220FchaAct(Date t220FchaAct) {
		this.t220FchaAct = t220FchaAct;
	}

	public void setT220MrcaActivo(String t220MrcaActivo) {
		this.t220MrcaActivo = t220MrcaActivo;
	}

}