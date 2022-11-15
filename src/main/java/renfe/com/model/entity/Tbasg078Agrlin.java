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
@Table(name = "TBASG078_AGRLIN")
public class Tbasg078Agrlin {

	@Id
	@Column(name = "T078_IDAGRLIN")
	private Long t078Idagrlin;

	@Column(name = "T078_BLACTIVO")
	private String t078Blactivo;

	@Column(name = "T078_FECULTACT")
	private Date t078Fecultact;

	@NotNull
	@Column(name = "T078_IDAGRUPA")
	private Integer t078Idagrupa;

	@Column(name = "T078_USUULTACT")
	private String t078Usuultact;

	@ManyToOne
	@JoinColumn(name = "T078_IDLINEA", nullable = false, foreignKey = @ForeignKey(name = "FK2AS078"))
	private Tbasg054Lineas t078Idlinea;

	@ManyToOne
	@JoinColumn(name = "T078_IDESTOR", nullable = false, foreignKey = @ForeignKey(name = "FK3AS078"))
	private Tbasg053Estaci t078Idestor;

	@ManyToOne
	@JoinColumn(name = "T078_IDESTDES", nullable = false, foreignKey = @ForeignKey(name = "FK4AS078"))
	private Tbasg053Estaci t078Idestdes;

	public Long getT078Idagrlin() {
		return this.t078Idagrlin;
	}

	public void setT078Idagrlin(Long t078Idagrlin) {
		this.t078Idagrlin = t078Idagrlin;
	}

	public String getT078Blactivo() {
		return this.t078Blactivo;
	}

	public Date getT078Fecultact() {
		return this.t078Fecultact;
	}

	public Integer getT078Idagrupa() {
		return this.t078Idagrupa;
	}

	public String getT078Usuultact() {
		return this.t078Usuultact;
	}

	public void setT078Blactivo(String t078Blactivo) {
		this.t078Blactivo = t078Blactivo;
	}

	public void setT078Fecultact(Date t078Fecultact) {
		this.t078Fecultact = t078Fecultact;
	}

	public void setT078Idagrupa(Integer t078Idagrupa) {
		this.t078Idagrupa = t078Idagrupa;
	}

	public void setT078Usuultact(String t078Usuultact) {
		this.t078Usuultact = t078Usuultact;
	}

	public Tbasg054Lineas getT078Idlinea() {
		return this.t078Idlinea;
	}

	public Tbasg053Estaci getT078Idestor() {
		return this.t078Idestor;
	}

	public Tbasg053Estaci getT078Idestdes() {
		return this.t078Idestdes;
	}

	public void setT078Idlinea(Tbasg054Lineas t078Idlinea) {
		this.t078Idlinea = t078Idlinea;
	}

	public void setT078Idestor(Tbasg053Estaci t078Idestor) {
		this.t078Idestor = t078Idestor;
	}

	public void setT078Idestdes(Tbasg053Estaci t078Idestdes) {
		this.t078Idestdes = t078Idestdes;
	}

}