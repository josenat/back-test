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
@Table(name = "TBASG020_LICENC")
public class Tbasg020Licenc {

	@Id
	@Column(name = "T020_IDLICENC")
	private Long t020Idlicenc;

	@Column(name = "T020_BLACTIVO")
	private String t020Blactivo;

	@NotNull
	@Column(name = "T020_CODIGO")
	private String t020Codigo;

	@Column(name = "T020_FECULTACT")
	private Date t020Fecultact;

	@NotNull
	@Column(name = "T020_NOMBRE")
	private String t020Nombre;

	@Column(name = "T020_USUULTACT")
	private String t020Usuultact;

	@ManyToOne
	@JoinColumn(name = "T020_IDTIPLIC", nullable = false, foreignKey = @ForeignKey(name = "FK1AS020"))
	private Tbasg015Tiplic t020Idtiplic;

	public Long getT020Idlicenc() {
		return this.t020Idlicenc;
	}

	public void setT020Idlicenc(Long t020Idlicenc) {
		this.t020Idlicenc = t020Idlicenc;
	}

	public String getT020Blactivo() {
		return this.t020Blactivo;
	}

	public String getT020Codigo() {
		return this.t020Codigo;
	}

	public Date getT020Fecultact() {
		return this.t020Fecultact;
	}

	public String getT020Nombre() {
		return this.t020Nombre;
	}

	public String getT020Usuultact() {
		return this.t020Usuultact;
	}

	public void setT020Blactivo(String t020Blactivo) {
		this.t020Blactivo = t020Blactivo;
	}

	public void setT020Codigo(String t020Codigo) {
		this.t020Codigo = t020Codigo;
	}

	public void setT020Fecultact(Date t020Fecultact) {
		this.t020Fecultact = t020Fecultact;
	}

	public void setT020Nombre(String t020Nombre) {
		this.t020Nombre = t020Nombre;
	}

	public void setT020Usuultact(String t020Usuultact) {
		this.t020Usuultact = t020Usuultact;
	}

	public Tbasg015Tiplic getT020Idtiplic() {
		return this.t020Idtiplic;
	}

	public void setT020Idtiplic(Tbasg015Tiplic t020Idtiplic) {
		this.t020Idtiplic = t020Idtiplic;
	}

}