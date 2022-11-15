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
@Table(name = "TBASG005_ACCESO")
public class Tbasg005Acceso {

	@Id
	@Column(name = "T005_IDACCESO")
	private Long t005Idacceso;

	@Column(name = "T005_BLACTIVO")
	private String t005Blactivo;

	@Column(name = "T005_FECULTACT")
	private Date t005Fecultact;

	@Column(name = "T005_USUULTACT")
	private String t005Usuultact;

	@ManyToOne
	@JoinColumn(name = "T005_IDPERMIS", nullable = false, foreignKey = @ForeignKey(name = "FK1AS005"))
	private Tbasg062Permis t005Idpermis;

	@ManyToOne
	@JoinColumn(name = "T005_IDFUNCIO", nullable = false, foreignKey = @ForeignKey(name = "FK2AS005"))
	private Tbasg003Funcio t005Idfuncio;

	@ManyToOne
	@JoinColumn(name = "T005_IDPERFIL", nullable = false, foreignKey = @ForeignKey(name = "FK3AS005"))
	private Tbasg002Perfil t005Idperfil;

	public Long getT005Idacceso() {
		return this.t005Idacceso;
	}

	public void setT005Idacceso(Long t005Idacceso) {
		this.t005Idacceso = t005Idacceso;
	}

	public String getT005Blactivo() {
		return this.t005Blactivo;
	}

	public Date getT005Fecultact() {
		return this.t005Fecultact;
	}

	public String getT005Usuultact() {
		return this.t005Usuultact;
	}

	public void setT005Blactivo(String t005Blactivo) {
		this.t005Blactivo = t005Blactivo;
	}

	public void setT005Fecultact(Date t005Fecultact) {
		this.t005Fecultact = t005Fecultact;
	}

	public void setT005Usuultact(String t005Usuultact) {
		this.t005Usuultact = t005Usuultact;
	}

	public Tbasg062Permis getT005Idpermis() {
		return this.t005Idpermis;
	}

	public Tbasg003Funcio getT005Idfuncio() {
		return this.t005Idfuncio;
	}

	public Tbasg002Perfil getT005Idperfil() {
		return this.t005Idperfil;
	}

	public void setT005Idpermis(Tbasg062Permis t005Idpermis) {
		this.t005Idpermis = t005Idpermis;
	}

	public void setT005Idfuncio(Tbasg003Funcio t005Idfuncio) {
		this.t005Idfuncio = t005Idfuncio;
	}

	public void setT005Idperfil(Tbasg002Perfil t005Idperfil) {
		this.t005Idperfil = t005Idperfil;
	}

}