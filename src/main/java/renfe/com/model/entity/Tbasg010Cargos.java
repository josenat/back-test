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
@Table(name = "TBASG010_CARGOS")
public class Tbasg010Cargos {

	@Id
	@Column(name = "T010_IDCARGO")
	private Long t010Idcargo;

	@Column(name = "T010_BLACTIVO")
	private String t010Blactivo;

	@NotNull
	@Column(name = "T010_CODIGO")
	private String t010Codigo;

	@Column(name = "T010_FECULTACT")
	private Date t010Fecultact;

	@NotNull
	@Column(name = "T010_NOMBRE")
	private String t010Nombre;

	@Column(name = "T010_USUULTACT")
	private String t010Usuultact;

	@ManyToOne
	@JoinColumn(name = "T010_IDTIPPER", nullable = false, foreignKey = @ForeignKey(name = "FK1AS010"))
	private Tbasg047Tipper t010Idtipper;

	public Long getT010Idcargo() {
		return this.t010Idcargo;
	}

	public void setT010Idcargo(Long t010Idcargo) {
		this.t010Idcargo = t010Idcargo;
	}

	public String getT010Blactivo() {
		return this.t010Blactivo;
	}

	public String getT010Codigo() {
		return this.t010Codigo;
	}

	public Date getT010Fecultact() {
		return this.t010Fecultact;
	}

	public String getT010Nombre() {
		return this.t010Nombre;
	}

	public String getT010Usuultact() {
		return this.t010Usuultact;
	}

	public void setT010Blactivo(String t010Blactivo) {
		this.t010Blactivo = t010Blactivo;
	}

	public void setT010Codigo(String t010Codigo) {
		this.t010Codigo = t010Codigo;
	}

	public void setT010Fecultact(Date t010Fecultact) {
		this.t010Fecultact = t010Fecultact;
	}

	public void setT010Nombre(String t010Nombre) {
		this.t010Nombre = t010Nombre;
	}

	public void setT010Usuultact(String t010Usuultact) {
		this.t010Usuultact = t010Usuultact;
	}

	public Tbasg047Tipper getT010Idtipper() {
		return this.t010Idtipper;
	}

	public void setT010Idtipper(Tbasg047Tipper t010Idtipper) {
		this.t010Idtipper = t010Idtipper;
	}

}