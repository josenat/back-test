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
@Table(name = "TBASG063_EMPRES")
public class Tbasg063Empres {

	@Id
	@Column(name = "T063_IDEMPRESA")
	private Long t063Idempresa;

	@Column(name = "T063_BLACTIVO")
	private String t063Blactivo;

	@NotNull
	@Column(name = "T063_CIF")
	private String t063Cif;

	@NotNull
	@Column(name = "T063_CODPOST")
	private String t063Codpost;

	@Column(name = "T063_ESCALERA")
	private String t063Escalera;

	@Column(name = "T063_FECULTACT")
	private Date t063Fecultact;

	@NotNull
	@Column(name = "T063_MUNICIP")
	private String t063Municip;

	@NotNull
	@Column(name = "T063_NOMBRE")
	private String t063Nombre;

	@Column(name = "T063_NUMVIA")
	private String t063Numvia;

	@Column(name = "T063_PLANTA")
	private String t063Planta;

	@Column(name = "T063_PUERTA")
	private String t063Puerta;

	@Column(name = "T063_USUULTACT")
	private String t063Usuultact;

	@NotNull
	@Column(name = "T063_VIA")
	private String t063Via;

	@ManyToOne
	@JoinColumn(name = "T063_IDTIPVIA", nullable = false, foreignKey = @ForeignKey(name = "FK1AS009"))
	private Tbasg051Tipvia t063Idtipvia;

	@ManyToOne
	@JoinColumn(name = "T063_IDPROVIN", nullable = false, foreignKey = @ForeignKey(name = "FK2AS009"))
	private Tbasg050Provin t063Idprovin;

	public Long getT063Idempresa() {
		return this.t063Idempresa;
	}

	public void setT063Idempresa(Long t063Idempresa) {
		this.t063Idempresa = t063Idempresa;
	}

	public String getT063Blactivo() {
		return this.t063Blactivo;
	}

	public String getT063Cif() {
		return this.t063Cif;
	}

	public String getT063Codpost() {
		return this.t063Codpost;
	}

	public String getT063Escalera() {
		return this.t063Escalera;
	}

	public Date getT063Fecultact() {
		return this.t063Fecultact;
	}

	public String getT063Municip() {
		return this.t063Municip;
	}

	public String getT063Nombre() {
		return this.t063Nombre;
	}

	public String getT063Numvia() {
		return this.t063Numvia;
	}

	public String getT063Planta() {
		return this.t063Planta;
	}

	public String getT063Puerta() {
		return this.t063Puerta;
	}

	public String getT063Usuultact() {
		return this.t063Usuultact;
	}

	public String getT063Via() {
		return this.t063Via;
	}

	public void setT063Blactivo(String t063Blactivo) {
		this.t063Blactivo = t063Blactivo;
	}

	public void setT063Cif(String t063Cif) {
		this.t063Cif = t063Cif;
	}

	public void setT063Codpost(String t063Codpost) {
		this.t063Codpost = t063Codpost;
	}

	public void setT063Escalera(String t063Escalera) {
		this.t063Escalera = t063Escalera;
	}

	public void setT063Fecultact(Date t063Fecultact) {
		this.t063Fecultact = t063Fecultact;
	}

	public void setT063Municip(String t063Municip) {
		this.t063Municip = t063Municip;
	}

	public void setT063Nombre(String t063Nombre) {
		this.t063Nombre = t063Nombre;
	}

	public void setT063Numvia(String t063Numvia) {
		this.t063Numvia = t063Numvia;
	}

	public void setT063Planta(String t063Planta) {
		this.t063Planta = t063Planta;
	}

	public void setT063Puerta(String t063Puerta) {
		this.t063Puerta = t063Puerta;
	}

	public void setT063Usuultact(String t063Usuultact) {
		this.t063Usuultact = t063Usuultact;
	}

	public void setT063Via(String t063Via) {
		this.t063Via = t063Via;
	}

	public Tbasg051Tipvia getT063Idtipvia() {
		return this.t063Idtipvia;
	}

	public Tbasg050Provin getT063Idprovin() {
		return this.t063Idprovin;
	}

	public void setT063Idtipvia(Tbasg051Tipvia t063Idtipvia) {
		this.t063Idtipvia = t063Idtipvia;
	}

	public void setT063Idprovin(Tbasg050Provin t063Idprovin) {
		this.t063Idprovin = t063Idprovin;
	}

}