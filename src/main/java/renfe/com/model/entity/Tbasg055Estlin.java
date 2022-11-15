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
@Table(name = "TBASG055_ESTLIN")
public class Tbasg055Estlin {

	@Id
	@Column(name = "T055_IDESTACILINEA")
	private Long t055Idestacilinea;

	@Column(name = "T055_BLACTIVO")
	private String t055Blactivo;

	@NotNull
	@Column(name = "T055_DIST")
	private Integer t055Dist;

	@Column(name = "T055_FECULTACT")
	private Date t055Fecultact;

	@Column(name = "T055_ORDENESTACION")
	private Integer t055Ordenestacion;

	@NotNull
	@Column(name = "T055_PK")
	private String t055Pk;

	@Column(name = "T055_USUULTACT")
	private String t055Usuultact;

	@ManyToOne
	@JoinColumn(name = "T055_IDLINEA", nullable = false, foreignKey = @ForeignKey(name = "FK1AS055"))
	private Tbasg054Lineas t055Idlinea;

	@ManyToOne
	@JoinColumn(name = "T055_IDESTACION", nullable = false, foreignKey = @ForeignKey(name = "FK2AS055"))
	private Tbasg053Estaci t055Idestacion;

	public Long getT055Idestacilinea() {
		return this.t055Idestacilinea;
	}

	public void setT055Idestacilinea(Long t055Idestacilinea) {
		this.t055Idestacilinea = t055Idestacilinea;
	}

	public String getT055Blactivo() {
		return this.t055Blactivo;
	}

	public Integer getT055Dist() {
		return this.t055Dist;
	}

	public Date getT055Fecultact() {
		return this.t055Fecultact;
	}

	public Integer getT055Ordenestacion() {
		return this.t055Ordenestacion;
	}

	public String getT055Pk() {
		return this.t055Pk;
	}

	public String getT055Usuultact() {
		return this.t055Usuultact;
	}

	public void setT055Blactivo(String t055Blactivo) {
		this.t055Blactivo = t055Blactivo;
	}

	public void setT055Dist(Integer t055Dist) {
		this.t055Dist = t055Dist;
	}

	public void setT055Fecultact(Date t055Fecultact) {
		this.t055Fecultact = t055Fecultact;
	}

	public void setT055Ordenestacion(Integer t055Ordenestacion) {
		this.t055Ordenestacion = t055Ordenestacion;
	}

	public void setT055Pk(String t055Pk) {
		this.t055Pk = t055Pk;
	}

	public void setT055Usuultact(String t055Usuultact) {
		this.t055Usuultact = t055Usuultact;
	}

	public Tbasg054Lineas getT055Idlinea() {
		return this.t055Idlinea;
	}

	public Tbasg053Estaci getT055Idestacion() {
		return this.t055Idestacion;
	}

	public void setT055Idlinea(Tbasg054Lineas t055Idlinea) {
		this.t055Idlinea = t055Idlinea;
	}

	public void setT055Idestacion(Tbasg053Estaci t055Idestacion) {
		this.t055Idestacion = t055Idestacion;
	}

}