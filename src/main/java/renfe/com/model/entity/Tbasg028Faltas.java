package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG028_FALTAS")
public class Tbasg028Faltas {

	@Id
	@Column(name = "T028_IDFALT")
	private Long t028Idfalt;

	@Column(name = "T028_BLACTIVO")
	private String t028Blactivo;

	@NotNull
	@Column(name = "T028_CODIGO")
	private String t028Codigo;

	@Column(name = "T028_FECULTACT")
	private Date t028Fecultact;

	@NotNull
	@Column(name = "T028_NOMBRE")
	private String t028Nombre;

	@Column(name = "T028_USUULTACT")
	private String t028Usuultact;

	public Long getT028Idfalt() {
		return this.t028Idfalt;
	}

	public void setT028Idfalt(Long t028Idfalt) {
		this.t028Idfalt = t028Idfalt;
	}

	public String getT028Blactivo() {
		return this.t028Blactivo;
	}

	public String getT028Codigo() {
		return this.t028Codigo;
	}

	public Date getT028Fecultact() {
		return this.t028Fecultact;
	}

	public String getT028Nombre() {
		return this.t028Nombre;
	}

	public String getT028Usuultact() {
		return this.t028Usuultact;
	}

	public void setT028Blactivo(String t028Blactivo) {
		this.t028Blactivo = t028Blactivo;
	}

	public void setT028Codigo(String t028Codigo) {
		this.t028Codigo = t028Codigo;
	}

	public void setT028Fecultact(Date t028Fecultact) {
		this.t028Fecultact = t028Fecultact;
	}

	public void setT028Nombre(String t028Nombre) {
		this.t028Nombre = t028Nombre;
	}

	public void setT028Usuultact(String t028Usuultact) {
		this.t028Usuultact = t028Usuultact;
	}

}