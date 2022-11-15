package renfe.com.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG068_DICCIO")
public class Tbasg068Diccio {

	@Id
	@Column(name = "T068_IDDICCIO")
	private Long t068Iddiccio;

	@NotNull
	@Column(name = "T068_NOMBRE")
	private String t068Nombre;

	@NotNull
	@Column(name = "T068_TIPO")
	private String t068Tipo;

	public Long getT068Iddiccio() {
		return this.t068Iddiccio;
	}

	public void setT068Iddiccio(Long t068Iddiccio) {
		this.t068Iddiccio = t068Iddiccio;
	}

	public String getT068Nombre() {
		return this.t068Nombre;
	}

	public String getT068Tipo() {
		return this.t068Tipo;
	}

	public void setT068Nombre(String t068Nombre) {
		this.t068Nombre = t068Nombre;
	}

	public void setT068Tipo(String t068Tipo) {
		this.t068Tipo = t068Tipo;
	}

}