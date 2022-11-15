package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG154_OP_TARJETA")
public class Tbasg154OpTarjeta {

	@EmbeddedId
	private Tbasg154OpTarjetaPK tbasg154optarjetapk;

	@Column(name = "DESG_USUACT")
	private String desgUsuact;

	@NotNull
	@Column(name = "DESG_USUARIO")
	private String desgUsuario;

	@Column(name = "FCHA_ACT")
	private Date fchaAct;

	@Column(name = "MRCA_ACTIVO")
	private String mrcaActivo;

	@ManyToOne
	@JoinColumn(name = "CDGO_NUMSERIE", nullable = true, foreignKey = @ForeignKey(name = "CDGO$NUM"))
	private Tbasg153Tarjeta cdgoNumserie;
	
	/*
	 * FIXME CUIDADO FALTA LA PROPIEDAD DE DesgOperacion
	 * Por ahora cree los getters y setters para que no de error al compilar
	 */

	@ManyToOne
	@JoinColumn(name = "CDGO_OPERACION", nullable = false, foreignKey = @ForeignKey(name = "CDGO$OPE"))
	private Tbasg165TipoOpTarjeta cdgoOperacion;

	public Tbasg154OpTarjetaPK getTbasg154optarjetapk() {
		return this.tbasg154optarjetapk;
	}

	public void setTbasg154optarjetapk(Tbasg154OpTarjetaPK tbasg154optarjetapk) {
		this.tbasg154optarjetapk = tbasg154optarjetapk;
	}

	public String getDesgUsuact() {
		return this.desgUsuact;
	}

	public String getDesgUsuario() {
		return this.desgUsuario;
	}

	public Date getFchaAct() {
		return this.fchaAct;
	}

	public String getMrcaActivo() {
		return this.mrcaActivo;
	}

	public void setDesgUsuact(String desgUsuact) {
		this.desgUsuact = desgUsuact;
	}

	public void setDesgUsuario(String desgUsuario) {
		this.desgUsuario = desgUsuario;
	}

	public void setFchaAct(Date fchaAct) {
		this.fchaAct = fchaAct;
	}

	public void setMrcaActivo(String mrcaActivo) {
		this.mrcaActivo = mrcaActivo;
	}

	public Tbasg153Tarjeta getCdgoNumserie() {
		return this.cdgoNumserie;
	}
	
	public Object getDesgOperacion() {
		return null;
	}

	public Tbasg165TipoOpTarjeta getCdgoOperacion() {
		return this.cdgoOperacion;
	}

	public void setCdgoNumserie(Tbasg153Tarjeta cdgoNumserie) {
		this.cdgoNumserie = cdgoNumserie;
	}
	
	public void setDesgOperacion(Object desgOperacion) {
		
	}

	public void setCdgoOperacion(Tbasg165TipoOpTarjeta cdgoOperacion) {
		this.cdgoOperacion = cdgoOperacion;
	}

}