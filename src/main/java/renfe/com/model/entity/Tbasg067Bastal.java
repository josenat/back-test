package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TBASG067_BASTAL")
public class Tbasg067Bastal {

	@Id
	@Column(name = "T067_IDBASTALL")
	private Long t067Idbastall;

	@Column(name = "T067_BLACTIVO")
	private String t067Blactivo;

	@Column(name = "T067_FECULTACT")
	private Date t067Fecultact;

	@Column(name = "T067_USUULTACT")
	private String t067Usuultact;

	@ManyToOne
	@JoinColumn(name = "T067_IDTALLER", nullable = false, foreignKey = @ForeignKey(name = "FK1AS067"))
	private Tbasg065Taller t067Idtaller;

	@ManyToOne
	@JoinColumn(name = "T067_IDBASE", nullable = false, foreignKey = @ForeignKey(name = "FK2AS067"))
	private Tbasg070Base t067Idbase;

	public Long getT067Idbastall() {
		return this.t067Idbastall;
	}

	public void setT067Idbastall(Long t067Idbastall) {
		this.t067Idbastall = t067Idbastall;
	}

	public String getT067Blactivo() {
		return this.t067Blactivo;
	}

	public Date getT067Fecultact() {
		return this.t067Fecultact;
	}

	public String getT067Usuultact() {
		return this.t067Usuultact;
	}

	public void setT067Blactivo(String t067Blactivo) {
		this.t067Blactivo = t067Blactivo;
	}

	public void setT067Fecultact(Date t067Fecultact) {
		this.t067Fecultact = t067Fecultact;
	}

	public void setT067Usuultact(String t067Usuultact) {
		this.t067Usuultact = t067Usuultact;
	}

	public Tbasg065Taller getT067Idtaller() {
		return this.t067Idtaller;
	}

	public Tbasg070Base getT067Idbase() {
		return this.t067Idbase;
	}

	public void setT067Idtaller(Tbasg065Taller t067Idtaller) {
		this.t067Idtaller = t067Idtaller;
	}

	public void setT067Idbase(Tbasg070Base t067Idbase) {
		this.t067Idbase = t067Idbase;
	}

}