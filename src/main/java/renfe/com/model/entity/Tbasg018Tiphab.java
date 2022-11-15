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
@Table(name = "TBASG018_TIPHAB")
public class Tbasg018Tiphab {

	@Id
	@Column(name = "T018_IDTIPHAB")
	private Long t018Idtiphab;

	@Column(name = "T018_BLACTIVO")
	private String t018Blactivo;

	@NotNull
	@Column(name = "T018_CODIGO")
	private String t018Codigo;

	@Column(name = "T018_FECULTACT")
	private Date t018Fecultact;

	@NotNull
	@Column(name = "T018_NOMBRE")
	private String t018Nombre;

	@Column(name = "T018_USUULTACT")
	private String t018Usuultact;

	@ManyToOne
	@JoinColumn(name = "T018_IDTIPREV", nullable = false, foreignKey = @ForeignKey(name = "FK1AS018"))
	private Tbasg023Tiprev t018Idtiprev;

	public Long getT018Idtiphab() {
		return this.t018Idtiphab;
	}

	public void setT018Idtiphab(Long t018Idtiphab) {
		this.t018Idtiphab = t018Idtiphab;
	}

	public String getT018Blactivo() {
		return this.t018Blactivo;
	}

	public String getT018Codigo() {
		return this.t018Codigo;
	}

	public Date getT018Fecultact() {
		return this.t018Fecultact;
	}

	public String getT018Nombre() {
		return this.t018Nombre;
	}

	public String getT018Usuultact() {
		return this.t018Usuultact;
	}

	public void setT018Blactivo(String t018Blactivo) {
		this.t018Blactivo = t018Blactivo;
	}

	public void setT018Codigo(String t018Codigo) {
		this.t018Codigo = t018Codigo;
	}

	public void setT018Fecultact(Date t018Fecultact) {
		this.t018Fecultact = t018Fecultact;
	}

	public void setT018Nombre(String t018Nombre) {
		this.t018Nombre = t018Nombre;
	}

	public void setT018Usuultact(String t018Usuultact) {
		this.t018Usuultact = t018Usuultact;
	}

	public Tbasg023Tiprev getT018Idtiprev() {
		return this.t018Idtiprev;
	}

	public void setT018Idtiprev(Tbasg023Tiprev t018Idtiprev) {
		this.t018Idtiprev = t018Idtiprev;
	}

}