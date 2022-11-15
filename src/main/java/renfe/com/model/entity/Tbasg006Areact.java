package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG006_AREACT", schema = "PASG")
public class Tbasg006Areact {

	@Id
	@Column(name = "T006_IDAREACT")
	private Long t006Idareact;

	@Column(name = "T006_BLACTIVO")
	private String t006Blactivo;

	@NotNull
	@Column(name = "T006_CODIGO")
	private String t006Codigo;

	@Column(name = "T006_FECULTACT")
	private Date t006Fecultact;

	@NotNull
	@Column(name = "T006_NOMBRE")
	private String t006Nombre;

	@Column(name = "T006_USUULTACT")
	private String t006Usuultact;

	public Long getT006Idareact() {
		return this.t006Idareact;
	}

	public void setT006Idareact(Long t006Idareact) {
		this.t006Idareact = t006Idareact;
	}

	public String getT006Blactivo() {
		return this.t006Blactivo;
	}

	public String getT006Codigo() {
		return this.t006Codigo;
	}

	public Date getT006Fecultact() {
		return this.t006Fecultact;
	}

	public String getT006Nombre() {
		return this.t006Nombre;
	}

	public String getT006Usuultact() {
		return this.t006Usuultact;
	}

	public void setT006Blactivo(String t006Blactivo) {
		this.t006Blactivo = t006Blactivo;
	}

	public void setT006Codigo(String t006Codigo) {
		this.t006Codigo = t006Codigo;
	}

	public void setT006Fecultact(Date t006Fecultact) {
		this.t006Fecultact = t006Fecultact;
	}

	public void setT006Nombre(String t006Nombre) {
		this.t006Nombre = t006Nombre;
	}

	public void setT006Usuultact(String t006Usuultact) {
		this.t006Usuultact = t006Usuultact;
	}

}