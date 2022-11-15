package renfe.com.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG069_BLOQUE")
public class Tbasg069Bloque {

	@Id
	@Column(name = "T069_IDBLOQUEO")
	private Long t069Idbloqueo;

	@NotNull
	@Column(name = "T069_IDREGISTRO")
	private Integer t069Idregistro;

	@NotNull
	@Column(name = "T069_TABLA")
	private String t069Tabla;

	@NotNull
	@Column(name = "T069_USUARIO")
	private String t069Usuario;

	public Long getT069Idbloqueo() {
		return this.t069Idbloqueo;
	}

	public void setT069Idbloqueo(Long t069Idbloqueo) {
		this.t069Idbloqueo = t069Idbloqueo;
	}

	public Integer getT069Idregistro() {
		return this.t069Idregistro;
	}

	public String getT069Tabla() {
		return this.t069Tabla;
	}

	public String getT069Usuario() {
		return this.t069Usuario;
	}

	public void setT069Idregistro(Integer t069Idregistro) {
		this.t069Idregistro = t069Idregistro;
	}

	public void setT069Tabla(String t069Tabla) {
		this.t069Tabla = t069Tabla;
	}

	public void setT069Usuario(String t069Usuario) {
		this.t069Usuario = t069Usuario;
	}

}