package renfe.com.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG199_DAT_CONF_D")
public class Tbasg199DatConfD {

	@Id
	@Column(name = "CLAVE")
	private Long clave;

	@NotNull
	@Column(name = "TIPO")
	private String tipo;

	@NotNull
	@Column(name = "VALOR")
	private String valor;

	public Long getClave() {
		return this.clave;
	}

	public void setClave(Long clave) {
		this.clave = clave;
	}

	public String getTipo() {
		return this.tipo;
	}

	public String getValor() {
		return this.valor;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

}