package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG085_RECAGR")
public class Tbasg085Recagr {

	@Id
	@Column(name = "T085_IDRECAGR")
	private Long t085Idrecagr;

	@Column(name = "T085_BLACTIVO")
	private String t085Blactivo;

	@Column(name = "T085_FECULTACT")
	private Date t085Fecultact;

	@NotNull
	@Column(name = "T085_IDAGRUPA")
	private Integer t085Idagrupa;

	@NotNull
	@Column(name = "T085_IDRECICL")
	private Integer t085Idrecicl;

	@Column(name = "T085_USUULTACT")
	private String t085Usuultact;

	public Long getT085Idrecagr() {
		return this.t085Idrecagr;
	}

	public void setT085Idrecagr(Long t085Idrecagr) {
		this.t085Idrecagr = t085Idrecagr;
	}

	public String getT085Blactivo() {
		return this.t085Blactivo;
	}

	public Date getT085Fecultact() {
		return this.t085Fecultact;
	}

	public Integer getT085Idagrupa() {
		return this.t085Idagrupa;
	}

	public Integer getT085Idrecicl() {
		return this.t085Idrecicl;
	}

	public String getT085Usuultact() {
		return this.t085Usuultact;
	}

	public void setT085Blactivo(String t085Blactivo) {
		this.t085Blactivo = t085Blactivo;
	}

	public void setT085Fecultact(Date t085Fecultact) {
		this.t085Fecultact = t085Fecultact;
	}

	public void setT085Idagrupa(Integer t085Idagrupa) {
		this.t085Idagrupa = t085Idagrupa;
	}

	public void setT085Idrecicl(Integer t085Idrecicl) {
		this.t085Idrecicl = t085Idrecicl;
	}

	public void setT085Usuultact(String t085Usuultact) {
		this.t085Usuultact = t085Usuultact;
	}

}