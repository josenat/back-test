package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG179_FICHERO_REF")
public class Tbasg179FicheroRef {

	@Id
	@Column(name = "CDGO_FICHERO")
	private Long cdgoFichero;

	@NotNull
	@Column(name = "DESG_FICHERO")
	private String desgFichero;

	@NotNull
	@Column(name = "FCHA_FICHERO")
	private Date fchaFichero;

	public Long getCdgoFichero() {
		return this.cdgoFichero;
	}

	public void setCdgoFichero(Long cdgoFichero) {
		this.cdgoFichero = cdgoFichero;
	}

	public String getDesgFichero() {
		return this.desgFichero;
	}

	public Date getFchaFichero() {
		return this.fchaFichero;
	}

	public void setDesgFichero(String desgFichero) {
		this.desgFichero = desgFichero;
	}

	public void setFchaFichero(Date fchaFichero) {
		this.fchaFichero = fchaFichero;
	}

}