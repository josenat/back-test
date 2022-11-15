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
@Table(name = "TBASG004_USUPER")
public class Tbasg004Usuper {

	@Id
	@Column(name = "T004_IDUSUPER")
	private Long t004Idusuper;

	@Column(name = "T004_BLACTIVO")
	private String t004Blactivo;

	@Column(name = "T004_FECULTACT")
	private Date t004Fecultact;

	@Column(name = "T004_USUULTACT")
	private String t004Usuultact;

	@ManyToOne
	@JoinColumn(name = "T004_IDUSUARI", nullable = false, foreignKey = @ForeignKey(name = "FK1AS004"))
	private Tbasg001Usuari t004Idusuari;

	@ManyToOne
	@JoinColumn(name = "T004_IDPERFIL", nullable = false, foreignKey = @ForeignKey(name = "FK2AS004"))
	private Tbasg002Perfil t004Idperfil;

	public Long getT004Idusuper() {
		return this.t004Idusuper;
	}

	public void setT004Idusuper(Long t004Idusuper) {
		this.t004Idusuper = t004Idusuper;
	}

	public String getT004Blactivo() {
		return this.t004Blactivo;
	}

	public Date getT004Fecultact() {
		return this.t004Fecultact;
	}

	public String getT004Usuultact() {
		return this.t004Usuultact;
	}

	public void setT004Blactivo(String t004Blactivo) {
		this.t004Blactivo = t004Blactivo;
	}

	public void setT004Fecultact(Date t004Fecultact) {
		this.t004Fecultact = t004Fecultact;
	}

	public void setT004Usuultact(String t004Usuultact) {
		this.t004Usuultact = t004Usuultact;
	}

	public Tbasg001Usuari getT004Idusuari() {
		return this.t004Idusuari;
	}

	public Tbasg002Perfil getT004Idperfil() {
		return this.t004Idperfil;
	}

	public void setT004Idusuari(Tbasg001Usuari t004Idusuari) {
		this.t004Idusuari = t004Idusuari;
	}

	public void setT004Idperfil(Tbasg002Perfil t004Idperfil) {
		this.t004Idperfil = t004Idperfil;
	}

}