package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG047_TIPPER")
public class Tbasg047Tipper {

	@Id
	@Column(name = "T047_IDTIPPER")
	private Long t047Idtipper;

	@Column(name = "T047_BLACTIVO")
	private String t047Blactivo;

	@NotNull
	@Column(name = "T047_CODIGO")
	private String t047Codigo;

	@Column(name = "T047_FECULTACT")
	private Date t047Fecultact;

	@NotNull
	@Column(name = "T047_NOMBRE")
	private String t047Nombre;

	@Column(name = "T047_USUULTACT")
	private String t047Usuultact;

	public Long getT047Idtipper() {
		return this.t047Idtipper;
	}

	public void setT047Idtipper(Long t047Idtipper) {
		this.t047Idtipper = t047Idtipper;
	}

	public String getT047Blactivo() {
		return this.t047Blactivo;
	}

	public String getT047Codigo() {
		return this.t047Codigo;
	}

	public Date getT047Fecultact() {
		return this.t047Fecultact;
	}

	public String getT047Nombre() {
		return this.t047Nombre;
	}

	public String getT047Usuultact() {
		return this.t047Usuultact;
	}

	public void setT047Blactivo(String t047Blactivo) {
		this.t047Blactivo = t047Blactivo;
	}

	public void setT047Codigo(String t047Codigo) {
		this.t047Codigo = t047Codigo;
	}

	public void setT047Fecultact(Date t047Fecultact) {
		this.t047Fecultact = t047Fecultact;
	}

	public void setT047Nombre(String t047Nombre) {
		this.t047Nombre = t047Nombre;
	}

	public void setT047Usuultact(String t047Usuultact) {
		this.t047Usuultact = t047Usuultact;
	}

}