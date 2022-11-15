package renfe.com.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG074_AMBITO")
public class Tbasg074Ambito {

	@Id
	@Column(name = "T074_IDAMBITO")
	private Long t074Idambito;

	@NotNull
	@Column(name = "T074_CODIGO")
	private String t074Codigo;

	@NotNull
	@Column(name = "T074_NOMBRE")
	private String t074Nombre;

	public Long getT074Idambito() {
		return this.t074Idambito;
	}

	public void setT074Idambito(Long t074Idambito) {
		this.t074Idambito = t074Idambito;
	}

	public String getT074Codigo() {
		return this.t074Codigo;
	}

	public String getT074Nombre() {
		return this.t074Nombre;
	}

	public void setT074Codigo(String t074Codigo) {
		this.t074Codigo = t074Codigo;
	}

	public void setT074Nombre(String t074Nombre) {
		this.t074Nombre = t074Nombre;
	}

}