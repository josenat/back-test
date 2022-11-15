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
@Table(name = "TBASG017_HABILI")
public class Tbasg017Habili {

	@Id
	@Column(name = "T017_IDHAB")
	private Long t017Idhab;

	@Column(name = "T017_BLACTIVO")
	private String t017Blactivo;

	@NotNull
	@Column(name = "T017_CODIGO")
	private String t017Codigo;

	@Column(name = "T017_FECULTACT")
	private Date t017Fecultact;

	@NotNull
	@Column(name = "T017_IDAMBMAN")
	private Integer t017Idambman;

	@NotNull
	@Column(name = "T017_IDTIPHAB")
	private Integer t017Idtiphab;

	@NotNull
	@Column(name = "T017_IDTIPMER")
	private Integer t017Idtipmer;

	@NotNull
	@Column(name = "T017_NOMBRE")
	private String t017Nombre;

	@Column(name = "T017_USUULTACT")
	private String t017Usuultact;

	@ManyToOne
	@JoinColumn(name = "T017_IDLICENC", nullable = false, foreignKey = @ForeignKey(name = "FK2AS017"))
	private Tbasg020Licenc t017Idlicenc;

	@ManyToOne
	@JoinColumn(name = "T017_IDVEH", nullable = false, foreignKey = @ForeignKey(name = "FK3AS017"))
	private Tbasg044Vehicu t017Idveh;

	@ManyToOne
	@JoinColumn(name = "T017_IDTIPDEP", nullable = false, foreignKey = @ForeignKey(name = "FK4AS017"))
	private Tbasg045Tipdep t017Idtipdep;

	@ManyToOne
	@JoinColumn(name = "T017_IDLINEA", nullable = false, foreignKey = @ForeignKey(name = "FK6AS017"))
	private Tbasg054Lineas t017Idlinea;

	@ManyToOne
	@JoinColumn(name = "T017_IDSERIE", nullable = false, foreignKey = @ForeignKey(name = "FK7AS017"))
	private Tbasg064Serie t017Idserie;

	public Long getT017Idhab() {
		return this.t017Idhab;
	}

	public void setT017Idhab(Long t017Idhab) {
		this.t017Idhab = t017Idhab;
	}

	public String getT017Blactivo() {
		return this.t017Blactivo;
	}

	public String getT017Codigo() {
		return this.t017Codigo;
	}

	public Date getT017Fecultact() {
		return this.t017Fecultact;
	}

	public Integer getT017Idambman() {
		return this.t017Idambman;
	}

	public Integer getT017Idtiphab() {
		return this.t017Idtiphab;
	}

	public Integer getT017Idtipmer() {
		return this.t017Idtipmer;
	}

	public String getT017Nombre() {
		return this.t017Nombre;
	}

	public String getT017Usuultact() {
		return this.t017Usuultact;
	}

	public void setT017Blactivo(String t017Blactivo) {
		this.t017Blactivo = t017Blactivo;
	}

	public void setT017Codigo(String t017Codigo) {
		this.t017Codigo = t017Codigo;
	}

	public void setT017Fecultact(Date t017Fecultact) {
		this.t017Fecultact = t017Fecultact;
	}

	public void setT017Idambman(Integer t017Idambman) {
		this.t017Idambman = t017Idambman;
	}

	public void setT017Idtiphab(Integer t017Idtiphab) {
		this.t017Idtiphab = t017Idtiphab;
	}

	public void setT017Idtipmer(Integer t017Idtipmer) {
		this.t017Idtipmer = t017Idtipmer;
	}

	public void setT017Nombre(String t017Nombre) {
		this.t017Nombre = t017Nombre;
	}

	public void setT017Usuultact(String t017Usuultact) {
		this.t017Usuultact = t017Usuultact;
	}

	public Tbasg020Licenc getT017Idlicenc() {
		return this.t017Idlicenc;
	}

	public Tbasg044Vehicu getT017Idveh() {
		return this.t017Idveh;
	}

	public Tbasg045Tipdep getT017Idtipdep() {
		return this.t017Idtipdep;
	}

	public Tbasg054Lineas getT017Idlinea() {
		return this.t017Idlinea;
	}

	public Tbasg064Serie getT017Idserie() {
		return this.t017Idserie;
	}

	public void setT017Idlicenc(Tbasg020Licenc t017Idlicenc) {
		this.t017Idlicenc = t017Idlicenc;
	}

	public void setT017Idveh(Tbasg044Vehicu t017Idveh) {
		this.t017Idveh = t017Idveh;
	}

	public void setT017Idtipdep(Tbasg045Tipdep t017Idtipdep) {
		this.t017Idtipdep = t017Idtipdep;
	}

	public void setT017Idlinea(Tbasg054Lineas t017Idlinea) {
		this.t017Idlinea = t017Idlinea;
	}

	public void setT017Idserie(Tbasg064Serie t017Idserie) {
		this.t017Idserie = t017Idserie;
	}

}