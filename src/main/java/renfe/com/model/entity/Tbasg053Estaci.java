package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG053_ESTACI")
public class Tbasg053Estaci {

	@Id
	@Column(name = "T053_IDESTACION")
	private Long t053Idestacion;

	@Column(name = "CDGO_PROVIN")
	private String cdgoProvin;

	@Column(name = "T053_BLACTIVO")
	private String t053Blactivo;

	@Column(name = "T053_CDGO_PROVIN")
	private Integer t053CdgoProvin;

	@NotNull
	@Column(name = "T053_CODIGO")
	private String t053Codigo;

	@Column(name = "T053_FECULTACT")
	private Date t053Fecultact;

	@NotNull
	@Column(name = "T053_NOMBRE")
	private String t053Nombre;

	@Column(name = "T053_USUULTACT")
	private String t053Usuultact;

	public Long getT053Idestacion() {
		return this.t053Idestacion;
	}

	public void setT053Idestacion(Long t053Idestacion) {
		this.t053Idestacion = t053Idestacion;
	}

	public String getCdgoProvin() {
		return this.cdgoProvin;
	}

	public String getT053Blactivo() {
		return this.t053Blactivo;
	}

	public Integer getT053CdgoProvin() {
		return this.t053CdgoProvin;
	}

	public String getT053Codigo() {
		return this.t053Codigo;
	}

	public Date getT053Fecultact() {
		return this.t053Fecultact;
	}

	public String getT053Nombre() {
		return this.t053Nombre;
	}

	public String getT053Usuultact() {
		return this.t053Usuultact;
	}

	public void setCdgoProvin(String cdgoProvin) {
		this.cdgoProvin = cdgoProvin;
	}

	public void setT053Blactivo(String t053Blactivo) {
		this.t053Blactivo = t053Blactivo;
	}

	public void setT053CdgoProvin(Integer t053CdgoProvin) {
		this.t053CdgoProvin = t053CdgoProvin;
	}

	public void setT053Codigo(String t053Codigo) {
		this.t053Codigo = t053Codigo;
	}

	public void setT053Fecultact(Date t053Fecultact) {
		this.t053Fecultact = t053Fecultact;
	}

	public void setT053Nombre(String t053Nombre) {
		this.t053Nombre = t053Nombre;
	}

	public void setT053Usuultact(String t053Usuultact) {
		this.t053Usuultact = t053Usuultact;
	}

}