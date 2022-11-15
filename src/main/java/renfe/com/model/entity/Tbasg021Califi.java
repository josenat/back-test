package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG021_CALIFI")
public class Tbasg021Califi {

	@Id
	@Column(name = "T021_IDCAL")
	private Long t021Idcal;

	@Column(name = "T021_BLACTIVO")
	private String t021Blactivo;

	@NotNull
	@Column(name = "T021_CODIGO")
	private String t021Codigo;

	@Column(name = "T021_FECULTACT")
	private Date t021Fecultact;

	@NotNull
	@Column(name = "T021_NOMBRE")
	private String t021Nombre;

	@NotNull
	@Column(name = "T021_TIPCAL")
	private String t021Tipcal;

	@Column(name = "T021_USUULTACT")
	private String t021Usuultact;

	public Long getT021Idcal() {
		return this.t021Idcal;
	}

	public void setT021Idcal(Long t021Idcal) {
		this.t021Idcal = t021Idcal;
	}

	public String getT021Blactivo() {
		return this.t021Blactivo;
	}

	public String getT021Codigo() {
		return this.t021Codigo;
	}

	public Date getT021Fecultact() {
		return this.t021Fecultact;
	}

	public String getT021Nombre() {
		return this.t021Nombre;
	}

	public String getT021Tipcal() {
		return this.t021Tipcal;
	}

	public String getT021Usuultact() {
		return this.t021Usuultact;
	}

	public void setT021Blactivo(String t021Blactivo) {
		this.t021Blactivo = t021Blactivo;
	}

	public void setT021Codigo(String t021Codigo) {
		this.t021Codigo = t021Codigo;
	}

	public void setT021Fecultact(Date t021Fecultact) {
		this.t021Fecultact = t021Fecultact;
	}

	public void setT021Nombre(String t021Nombre) {
		this.t021Nombre = t021Nombre;
	}

	public void setT021Tipcal(String t021Tipcal) {
		this.t021Tipcal = t021Tipcal;
	}

	public void setT021Usuultact(String t021Usuultact) {
		this.t021Usuultact = t021Usuultact;
	}

}