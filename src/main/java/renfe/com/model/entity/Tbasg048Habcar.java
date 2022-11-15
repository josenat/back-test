package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG048_HABCAR")
public class Tbasg048Habcar {

	@Id
	@Column(name = "T048_IDHABCAR")
	private Long t048Idhabcar;

	@Column(name = "T048_BLACTIVO")
	private String t048Blactivo;

	@Column(name = "T048_FECULTACT")
	private Date t048Fecultact;

	@NotNull
	@Column(name = "T048_IDTIPHAB")
	private Integer t048Idtiphab;

	@Column(name = "T048_USUULTACT")
	private String t048Usuultact;

	@ManyToOne
	@JoinColumn(name = "T048_IDCARGO", nullable = false, foreignKey = @ForeignKey(name = "FK1AS048"))
	private Tbasg010Cargos t048Idcargo;

	public Long getT048Idhabcar() {
		return this.t048Idhabcar;
	}

	public void setT048Idhabcar(Long t048Idhabcar) {
		this.t048Idhabcar = t048Idhabcar;
	}

	public String getT048Blactivo() {
		return this.t048Blactivo;
	}

	public Date getT048Fecultact() {
		return this.t048Fecultact;
	}

	public Integer getT048Idtiphab() {
		return this.t048Idtiphab;
	}

	public String getT048Usuultact() {
		return this.t048Usuultact;
	}

	public void setT048Blactivo(String t048Blactivo) {
		this.t048Blactivo = t048Blactivo;
	}

	public void setT048Fecultact(Date t048Fecultact) {
		this.t048Fecultact = t048Fecultact;
	}

	public void setT048Idtiphab(Integer t048Idtiphab) {
		this.t048Idtiphab = t048Idtiphab;
	}

	public void setT048Usuultact(String t048Usuultact) {
		this.t048Usuultact = t048Usuultact;
	}

	public Tbasg010Cargos getT048Idcargo() {
		return this.t048Idcargo;
	}

	public void setT048Idcargo(Tbasg010Cargos t048Idcargo) {
		this.t048Idcargo = t048Idcargo;
	}

}