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
@Table(name = "TBASG001_USUARI")
public class Tbasg001Usuari {

	@Id
	@Column(name = "T001_IDUSUARI")
	private Long t001Idusuari;

	@Column(name = "T001_BLACTIVO")
	private String t001Blactivo;

	@NotNull
	@Column(name = "T001_CUENTRED")
	private String t001Cuentred;

	@Column(name = "T001_FECULTACT")
	private Date t001Fecultact;

	@NotNull
	@Column(name = "T001_NOMBRE")
	private String t001Nombre;

	@Column(name = "T001_USUULTACT")
	private String t001Usuultact;

	@ManyToOne
	@JoinColumn(name = "T001_IDARETER", nullable = false, foreignKey = @ForeignKey(name = "FK1AS001"))
	private Tbasg007Areter t001Idareter;

	@ManyToOne
	@JoinColumn(name = "T001_IDAREASANI", nullable = false, foreignKey = @ForeignKey(name = "FK2AS001"))
	private Tbasg059Aresan t001Idareasani;

	@ManyToOne
	@JoinColumn(name = "T001_IDAREAFOR", nullable = false, foreignKey = @ForeignKey(name = "FK3AS001"))
	private Tbasg057Arefor t001Idareafor;

	@ManyToOne
	@JoinColumn(name = "T001_IDAREACT", nullable = false, foreignKey = @ForeignKey(name = "FK4AS001"))
	private Tbasg006Areact t001Idareact;

	public Long getT001Idusuari() {
		return this.t001Idusuari;
	}

	public void setT001Idusuari(Long t001Idusuari) {
		this.t001Idusuari = t001Idusuari;
	}

	public String getT001Blactivo() {
		return this.t001Blactivo;
	}

	public String getT001Cuentred() {
		return this.t001Cuentred;
	}

	public Date getT001Fecultact() {
		return this.t001Fecultact;
	}

	public String getT001Nombre() {
		return this.t001Nombre;
	}

	public String getT001Usuultact() {
		return this.t001Usuultact;
	}

	public void setT001Blactivo(String t001Blactivo) {
		this.t001Blactivo = t001Blactivo;
	}

	public void setT001Cuentred(String t001Cuentred) {
		this.t001Cuentred = t001Cuentred;
	}

	public void setT001Fecultact(Date t001Fecultact) {
		this.t001Fecultact = t001Fecultact;
	}

	public void setT001Nombre(String t001Nombre) {
		this.t001Nombre = t001Nombre;
	}

	public void setT001Usuultact(String t001Usuultact) {
		this.t001Usuultact = t001Usuultact;
	}

	public Tbasg007Areter getT001Idareter() {
		return this.t001Idareter;
	}

	public Tbasg059Aresan getT001Idareasani() {
		return this.t001Idareasani;
	}

	public Tbasg057Arefor getT001Idareafor() {
		return this.t001Idareafor;
	}

	public Tbasg006Areact getT001Idareact() {
		return this.t001Idareact;
	}

	public void setT001Idareter(Tbasg007Areter t001Idareter) {
		this.t001Idareter = t001Idareter;
	}

	public void setT001Idareasani(Tbasg059Aresan t001Idareasani) {
		this.t001Idareasani = t001Idareasani;
	}

	public void setT001Idareafor(Tbasg057Arefor t001Idareafor) {
		this.t001Idareafor = t001Idareafor;
	}

	public void setT001Idareact(Tbasg006Areact t001Idareact) {
		this.t001Idareact = t001Idareact;
	}

}