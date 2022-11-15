package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG155_FC_CATEGORIA")
public class Tbasg155FcCategoria {

	@Id
	@Column(name = "CDGO_CATEGORIA")
	private int cdgoCategoria;

	@NotNull
	@Column(name = "DESG_DESCRIPCION")
	private String desgDescripcion;

	@Column(name = "DESG_USUACT")
	private String desgUsuact;

	@Column(name = "FCHA_ACT")
	private Date fchaAct;

	@Column(name = "MRCA_ACTIVO")
	private char mrcaActivo;

	public int getCdgoCategoria() {
		return this.cdgoCategoria;
	}

	public void setCdgoCategoria(int object) {
		this.cdgoCategoria = object;
	}

	public String getDesgDescripcion() {
		return this.desgDescripcion;
	}

	public String getDesgUsuact() {
		return this.desgUsuact;
	}

	public Date getFchaAct() {
		return this.fchaAct;
	}

	public char getMrcaActivo() {
		return this.mrcaActivo;
	}

	public void setDesgDescripcion(String desgDescripcion) {
		this.desgDescripcion = desgDescripcion;
	}

	public void setDesgUsuact(String desgUsuact) {
		this.desgUsuact = desgUsuact;
	}

	public void setFchaAct(Date fchaAct) {
		this.fchaAct = fchaAct;
	}

	public void setMrcaActivo(char object) {
		this.mrcaActivo = object;
	}

}