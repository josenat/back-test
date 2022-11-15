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
@Table(name = "TBASG091_EXPREC")
public class Tbasg091Exprec {

	@Id
	@Column(name = "T091_IDEXPREC")
	private Long t091Idexprec;

	@Column(name = "T091_BLACTIVO")
	private String t091Blactivo;

	@Column(name = "T091_FECULTACT")
	private Date t091Fecultact;

	@NotNull
	@Column(name = "T091_IDEXP")
	private Integer t091Idexp;

	@Column(name = "T091_USUULTACT")
	private String t091Usuultact;

	@ManyToOne
	@JoinColumn(name = "T091_IDRECPER", nullable = false, foreignKey = @ForeignKey(name = "FK1AS091"))
	private Tbasg027Recper t091Idrecper;

	public Long getT091Idexprec() {
		return this.t091Idexprec;
	}

	public void setT091Idexprec(Long t091Idexprec) {
		this.t091Idexprec = t091Idexprec;
	}

	public String getT091Blactivo() {
		return this.t091Blactivo;
	}

	public Date getT091Fecultact() {
		return this.t091Fecultact;
	}

	public Integer getT091Idexp() {
		return this.t091Idexp;
	}

	public String getT091Usuultact() {
		return this.t091Usuultact;
	}

	public void setT091Blactivo(String t091Blactivo) {
		this.t091Blactivo = t091Blactivo;
	}

	public void setT091Fecultact(Date t091Fecultact) {
		this.t091Fecultact = t091Fecultact;
	}

	public void setT091Idexp(Integer t091Idexp) {
		this.t091Idexp = t091Idexp;
	}

	public void setT091Usuultact(String t091Usuultact) {
		this.t091Usuultact = t091Usuultact;
	}

	public Tbasg027Recper getT091Idrecper() {
		return this.t091Idrecper;
	}

	public void setT091Idrecper(Tbasg027Recper t091Idrecper) {
		this.t091Idrecper = t091Idrecper;
	}

}