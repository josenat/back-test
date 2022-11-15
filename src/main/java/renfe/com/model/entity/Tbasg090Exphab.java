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
@Table(name = "TBASG090_EXPHAB")
public class Tbasg090Exphab {

	@Id
	@Column(name = "T090_IDEXPHAB")
	private Long t090Idexphab;

	@Column(name = "T090_BLACTIVO")
	private String t090Blactivo;

	@Column(name = "T090_FECULTACT")
	private Date t090Fecultact;

	@NotNull
	@Column(name = "T090_IDEXP")
	private Integer t090Idexp;

	@Column(name = "T090_USUULTACT")
	private String t090Usuultact;

	@ManyToOne
	@JoinColumn(name = "T090_IDPERHAB", nullable = false, foreignKey = @ForeignKey(name = "FK1AS090"))
	private Tbasg032Perhab t090Idperhab;

	public Long getT090Idexphab() {
		return this.t090Idexphab;
	}

	public void setT090Idexphab(Long t090Idexphab) {
		this.t090Idexphab = t090Idexphab;
	}

	public String getT090Blactivo() {
		return this.t090Blactivo;
	}

	public Date getT090Fecultact() {
		return this.t090Fecultact;
	}

	public Integer getT090Idexp() {
		return this.t090Idexp;
	}

	public String getT090Usuultact() {
		return this.t090Usuultact;
	}

	public void setT090Blactivo(String t090Blactivo) {
		this.t090Blactivo = t090Blactivo;
	}

	public void setT090Fecultact(Date t090Fecultact) {
		this.t090Fecultact = t090Fecultact;
	}

	public void setT090Idexp(Integer t090Idexp) {
		this.t090Idexp = t090Idexp;
	}

	public void setT090Usuultact(String t090Usuultact) {
		this.t090Usuultact = t090Usuultact;
	}

	public Tbasg032Perhab getT090Idperhab() {
		return this.t090Idperhab;
	}

	public void setT090Idperhab(Tbasg032Perhab t090Idperhab) {
		this.t090Idperhab = t090Idperhab;
	}

}