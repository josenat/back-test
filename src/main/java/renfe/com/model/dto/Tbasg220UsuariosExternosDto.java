package renfe.com.model.dto;

import java.sql.Date;

public class Tbasg220UsuariosExternosDto {

	private Integer t220CdgoEmpresa;
	private String t220CdgoUsuario;
	private Integer t220CdgoUsuExt;
	private String t220DesgUsuact;
	private Date t220FchaAct;
	private String t220MrcaActivo;

	public Integer getT220CdgoEmpresa() {
		return this.t220CdgoEmpresa;
	}

	public void setT220CdgoEmpresa(Integer t220CdgoEmpresa) {
		this.t220CdgoEmpresa = t220CdgoEmpresa;
	}

	public String getT220CdgoUsuario() {
		return this.t220CdgoUsuario;
	}

	public void setT220CdgoUsuario(String t220CdgoUsuario) {
		this.t220CdgoUsuario = t220CdgoUsuario;
	}

	public Integer getT220CdgoUsuExt() {
		return this.t220CdgoUsuExt;
	}

	public void setT220CdgoUsuExt(Integer t220CdgoUsuExt) {
		this.t220CdgoUsuExt = t220CdgoUsuExt;
	}

	public String getT220DesgUsuact() {
		return this.t220DesgUsuact;
	}

	public void setT220DesgUsuact(String t220DesgUsuact) {
		this.t220DesgUsuact = t220DesgUsuact;
	}

	public Date getT220FchaAct() {
		return this.t220FchaAct;
	}

	public void setT220FchaAct(Date t220FchaAct) {
		this.t220FchaAct = t220FchaAct;
	}

	public String getT220MrcaActivo() {
		return this.t220MrcaActivo;
	}

	public void setT220MrcaActivo(String t220MrcaActivo) {
		this.t220MrcaActivo = t220MrcaActivo;
	}

}