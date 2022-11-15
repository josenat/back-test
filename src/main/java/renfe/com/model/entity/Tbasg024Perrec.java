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
@Table(name = "TBASG024_PERREC")
public class Tbasg024Perrec {

	@Id
	@Column(name = "T024_IDPERREC")
	private Long t024Idperrec;

	@Column(name = "T024_BLACTIVO")
	private String t024Blactivo;

	@NotNull
	@Column(name = "T024_CODIGO")
	private String t024Codigo;

	@Column(name = "T024_FECULTACT")
	private Date t024Fecultact;

	@NotNull
	@Column(name = "T024_NOMBRE")
	private String t024Nombre;

	@NotNull
	@Column(name = "T024_NUMANOS")
	private Integer t024Numanos;

	@NotNull
	@Column(name = "T024_NUMMESES")
	private Integer t024Nummeses;

	@Column(name = "T024_TIPFORM")
	private String t024Tipform;

	@Column(name = "T024_USUULTACT")
	private String t024Usuultact;

	@ManyToOne
	@JoinColumn(name = "T024_IDTIPLIC", nullable = false, foreignKey = @ForeignKey(name = "FK1AS024"))
	private Tbasg015Tiplic t024Idtiplic;

	public Long getT024Idperrec() {
		return this.t024Idperrec;
	}

	public void setT024Idperrec(Long t024Idperrec) {
		this.t024Idperrec = t024Idperrec;
	}

	public String getT024Blactivo() {
		return this.t024Blactivo;
	}

	public String getT024Codigo() {
		return this.t024Codigo;
	}

	public Date getT024Fecultact() {
		return this.t024Fecultact;
	}

	public String getT024Nombre() {
		return this.t024Nombre;
	}

	public Integer getT024Numanos() {
		return this.t024Numanos;
	}

	public Integer getT024Nummeses() {
		return this.t024Nummeses;
	}

	public String getT024Tipform() {
		return this.t024Tipform;
	}

	public String getT024Usuultact() {
		return this.t024Usuultact;
	}

	public void setT024Blactivo(String t024Blactivo) {
		this.t024Blactivo = t024Blactivo;
	}

	public void setT024Codigo(String t024Codigo) {
		this.t024Codigo = t024Codigo;
	}

	public void setT024Fecultact(Date t024Fecultact) {
		this.t024Fecultact = t024Fecultact;
	}

	public void setT024Nombre(String t024Nombre) {
		this.t024Nombre = t024Nombre;
	}

	public void setT024Numanos(Integer t024Numanos) {
		this.t024Numanos = t024Numanos;
	}

	public void setT024Nummeses(Integer t024Nummeses) {
		this.t024Nummeses = t024Nummeses;
	}

	public void setT024Tipform(String t024Tipform) {
		this.t024Tipform = t024Tipform;
	}

	public void setT024Usuultact(String t024Usuultact) {
		this.t024Usuultact = t024Usuultact;
	}

	public Tbasg015Tiplic getT024Idtiplic() {
		return this.t024Idtiplic;
	}

	public void setT024Idtiplic(Tbasg015Tiplic t024Idtiplic) {
		this.t024Idtiplic = t024Idtiplic;
	}

}