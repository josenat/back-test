package renfe.com.model.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TBASG231_EMAIL_PSICOFISICOS")
public class Tbasg231EmailPsicofisicos {

	@EmbeddedId
	private Tbasg231EmailPsicofisicosPK tbasg231emailpsicofisicospk;

	@Column(name = "CORREO")
	private String correo;

	@Column(name = "DESTINATARIO")
	private String destinatario;

	@Column(name = "GRAFICO")
	private Integer grafico;

	@Column(name = "MERCADO")
	private String mercado;

	@Column(name = "RESIDENCIA")
	private String residencia;

	public Tbasg231EmailPsicofisicosPK getTbasg231emailpsicofisicospk() {
		return this.tbasg231emailpsicofisicospk;
	}

	public void setTbasg231emailpsicofisicospk(Tbasg231EmailPsicofisicosPK tbasg231emailpsicofisicospk) {
		this.tbasg231emailpsicofisicospk = tbasg231emailpsicofisicospk;
	}

	public String getCorreo() {
		return this.correo;
	}

	public String getDestinatario() {
		return this.destinatario;
	}

	public Integer getGrafico() {
		return this.grafico;
	}

	public String getMercado() {
		return this.mercado;
	}

	public String getResidencia() {
		return this.residencia;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

	public void setGrafico(Integer grafico) {
		this.grafico = grafico;
	}

	public void setMercado(String mercado) {
		this.mercado = mercado;
	}

	public void setResidencia(String residencia) {
		this.residencia = residencia;
	}

}