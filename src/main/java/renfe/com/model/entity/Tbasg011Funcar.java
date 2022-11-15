package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG011_FUNCAR")
public class Tbasg011Funcar {

	@Id
	@Column(name = "T011_IDFUNCAR")
	private Long t011Idfuncar;

	@Column(name = "T011_BLACTIVO")
	private String t011Blactivo;

	@NotNull
	@Column(name = "T011_CODIGO")
	private String t011Codigo;

	@Column(name = "T011_FECULTACT")
	private Date t011Fecultact;

	@NotNull
	@Column(name = "T011_NOMBRE")
	private String t011Nombre;

	@Column(name = "T011_USUULTACT")
	private String t011Usuultact;

	public Long getT011Idfuncar() {
		return this.t011Idfuncar;
	}

	public void setT011Idfuncar(Long t011Idfuncar) {
		this.t011Idfuncar = t011Idfuncar;
	}

	public String getT011Blactivo() {
		return this.t011Blactivo;
	}

	public String getT011Codigo() {
		return this.t011Codigo;
	}

	public Date getT011Fecultact() {
		return this.t011Fecultact;
	}

	public String getT011Nombre() {
		return this.t011Nombre;
	}

	public String getT011Usuultact() {
		return this.t011Usuultact;
	}

	public void setT011Blactivo(String t011Blactivo) {
		this.t011Blactivo = t011Blactivo;
	}

	public void setT011Codigo(String t011Codigo) {
		this.t011Codigo = t011Codigo;
	}

	public void setT011Fecultact(Date t011Fecultact) {
		this.t011Fecultact = t011Fecultact;
	}

	public void setT011Nombre(String t011Nombre) {
		this.t011Nombre = t011Nombre;
	}

	public void setT011Usuultact(String t011Usuultact) {
		this.t011Usuultact = t011Usuultact;
	}

}