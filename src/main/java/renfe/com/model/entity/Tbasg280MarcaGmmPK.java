package renfe.com.model.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@AttributeOverrides({ @AttributeOverride(name = "desgMatricula", column = @Column(name = "DESG_MATRICULA")),
		@AttributeOverride(name = "fchaAct", column = @Column(name = "FCHA_ACT")) })
public class Tbasg280MarcaGmmPK implements Serializable {

	private static final long serialVersionUID = 1L;

	private String desgMatricula;
	private Date fchaAct;

	public String getDesgMatricula() {
		return this.desgMatricula;
	}

	public Date getFchaAct() {
		return this.fchaAct;
	}

	public void setDesgMatricula(String desgMatricula) {
		this.desgMatricula = desgMatricula;
	}

	public void setFchaAct(Date fchaAct) {
		this.fchaAct = fchaAct;
	}

}