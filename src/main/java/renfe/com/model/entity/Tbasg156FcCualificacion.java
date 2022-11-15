package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG156_FC_CUALIFICACION")
public class Tbasg156FcCualificacion {

	@Id
	@Column(name = "CDGO_CUALIFICACION")
	private int cdgoCualificacion;

	@Column(name = "DESG_DESCRIPCION")
	private String desgDescripcion;

	@NotNull
	@Column(name = "DESG_NOMBRE")
	private String desgNombre;

	@Column(name = "DESG_USUACT")
	private String desgUsuact;

	@Column(name = "FCHA_ACT")
	private Date fchaAct;

	@Column(name = "MRCA_ACTIVO")
	private char mrcaActivo;

	@Column(name = "CDGO_CATEGORIA")
	private int cdgoCategoria;
	/*@ManyToOne
	@JoinColumn(name = "CDGO_CATEGORIA", nullable = false, foreignKey = @ForeignKey(name = "CDGO$CAT"))
	private Tbasg155FcCategoria cdgoCategoria;*/

	public int getCdgoCualificacion() {
		return this.cdgoCualificacion;
	}

	public void setCdgoCualificacion(int object) {
		this.cdgoCualificacion = object;
	}

	public String getDesgDescripcion() {
		return this.desgDescripcion;
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

	public char getMrcaActivo() {
		return this.mrcaActivo;
	}

	public void setDesgDescripcion(String desgDescripcion) {
		this.desgDescripcion = desgDescripcion;
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

	public void setMrcaActivo(char object) {
		this.mrcaActivo = object;
	}

	public int getCdgoCategoria() {
		return this.cdgoCategoria;
	}

	public void setCdgoCategoria(int object) {
		this.cdgoCategoria = object;
	}

}