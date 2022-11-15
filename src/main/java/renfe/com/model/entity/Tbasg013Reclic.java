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
@Table(name = "TBASG013_RECLIC")
public class Tbasg013Reclic {

	@Id
	@Column(name = "T013_IDRECLIC")
	private Long t013Idreclic;

	@Column(name = "T013_BLACTIVO")
	private String t013Blactivo;

	@Column(name = "T013_FECULTACT")
	private Date t013Fecultact;

	@NotNull
	@Column(name = "T013_IDREC")
	private Integer t013Idrec;

	@Column(name = "T013_USUULTACT")
	private String t013Usuultact;

	@ManyToOne
	@JoinColumn(name = "T013_IDLICENC", nullable = false, foreignKey = @ForeignKey(name = "FK1AS013"))
	private Tbasg020Licenc t013Idlicenc;

	public Long getT013Idreclic() {
		return this.t013Idreclic;
	}

	public void setT013Idreclic(Long t013Idreclic) {
		this.t013Idreclic = t013Idreclic;
	}

	public String getT013Blactivo() {
		return this.t013Blactivo;
	}

	public Date getT013Fecultact() {
		return this.t013Fecultact;
	}

	public Integer getT013Idrec() {
		return this.t013Idrec;
	}

	public String getT013Usuultact() {
		return this.t013Usuultact;
	}

	public void setT013Blactivo(String t013Blactivo) {
		this.t013Blactivo = t013Blactivo;
	}

	public void setT013Fecultact(Date t013Fecultact) {
		this.t013Fecultact = t013Fecultact;
	}

	public void setT013Idrec(Integer t013Idrec) {
		this.t013Idrec = t013Idrec;
	}

	public void setT013Usuultact(String t013Usuultact) {
		this.t013Usuultact = t013Usuultact;
	}

	public Tbasg020Licenc getT013Idlicenc() {
		return this.t013Idlicenc;
	}

	public void setT013Idlicenc(Tbasg020Licenc t013Idlicenc) {
		this.t013Idlicenc = t013Idlicenc;
	}

}