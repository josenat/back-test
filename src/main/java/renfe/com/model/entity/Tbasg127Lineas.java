package renfe.com.model.entity;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG127_LINEAS", schema = "PASG")
public class Tbasg127Lineas {

	@Id
	@Column(name = "CDGO_LINEA")
	private String cdgoLinea;

	@NotNull
	@Column(name = "CDGO_NUMESTACIONES")
	private Integer cdgoNumestaciones;

	@NotNull
	@Column(name = "DESG_NOMBRE")
	private String desgNombre;

	@Column(name = "DESG_SOPORTEDOC")
	private String desgSoportedoc;

	@Column(name = "DESG_USUACT")
	private String desgUsuact;

	@Column(name = "FCHA_ACT")
	private Date fchaAct;

	@Column(name = "MRCA_ACTIVO")
	private char mrcaActivo;

	public String getCdgoLinea() {
		return this.cdgoLinea;
	}

	public void setCdgoLinea(String cdgoLinea) {
		this.cdgoLinea = cdgoLinea;
	}

	public Integer getCdgoNumestaciones() {
		return this.cdgoNumestaciones;
	}

	public String getDesgNombre() {
		return this.desgNombre;
	}

	public String getDesgSoportedoc() {
		return this.desgSoportedoc;
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

	public void setCdgoNumestaciones(Integer cdgoNumestaciones) {
		this.cdgoNumestaciones = cdgoNumestaciones;
	}

	public void setDesgNombre(String desgNombre) {
		this.desgNombre = desgNombre;
	}

	public void setDesgSoportedoc(String desgSoportedoc) {
		this.desgSoportedoc = desgSoportedoc;
	}

	public void setDesgUsuact(String desgUsuact) {
		this.desgUsuact = desgUsuact;
	}

	public void setFchaAct(Date fchaAct) {
		this.fchaAct = fchaAct;
	}

	public void setMrcaActivo(char mrcaActivo) {
		this.mrcaActivo = mrcaActivo;
	}

}