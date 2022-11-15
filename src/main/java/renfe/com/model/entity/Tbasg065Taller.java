package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG065_TALLER")
public class Tbasg065Taller {

	@Id
	@Column(name = "T065_IDTALLER")
	private Long t065Idtaller;

	@Column(name = "T065_BLACTIVO")
	private String t065Blactivo;

	@NotNull
	@Column(name = "T065_CODIGO")
	private String t065Codigo;

	@Column(name = "T065_FECULTACT")
	private Date t065Fecultact;

	@NotNull
	@Column(name = "T065_NIFDIRECT")
	private String t065Nifdirect;

	@NotNull
	@Column(name = "T065_NOMBRE")
	private String t065Nombre;

	@NotNull
	@Column(name = "T065_NOMBREDIRECT")
	private String t065Nombredirect;

	@Column(name = "T065_USUULTACT")
	private String t065Usuultact;

	public Long getT065Idtaller() {
		return this.t065Idtaller;
	}

	public void setT065Idtaller(Long t065Idtaller) {
		this.t065Idtaller = t065Idtaller;
	}

	public String getT065Blactivo() {
		return this.t065Blactivo;
	}

	public String getT065Codigo() {
		return this.t065Codigo;
	}

	public Date getT065Fecultact() {
		return this.t065Fecultact;
	}

	public String getT065Nifdirect() {
		return this.t065Nifdirect;
	}

	public String getT065Nombre() {
		return this.t065Nombre;
	}

	public String getT065Nombredirect() {
		return this.t065Nombredirect;
	}

	public String getT065Usuultact() {
		return this.t065Usuultact;
	}

	public void setT065Blactivo(String t065Blactivo) {
		this.t065Blactivo = t065Blactivo;
	}

	public void setT065Codigo(String t065Codigo) {
		this.t065Codigo = t065Codigo;
	}

	public void setT065Fecultact(Date t065Fecultact) {
		this.t065Fecultact = t065Fecultact;
	}

	public void setT065Nifdirect(String t065Nifdirect) {
		this.t065Nifdirect = t065Nifdirect;
	}

	public void setT065Nombre(String t065Nombre) {
		this.t065Nombre = t065Nombre;
	}

	public void setT065Nombredirect(String t065Nombredirect) {
		this.t065Nombredirect = t065Nombredirect;
	}

	public void setT065Usuultact(String t065Usuultact) {
		this.t065Usuultact = t065Usuultact;
	}

}