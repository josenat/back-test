package renfe.com.model.entity;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@AttributeOverrides({ @AttributeOverride(name = "cdgoClave", column = @Column(name = "CDGO_CLAVE")),
		@AttributeOverride(name = "cdgoReferenciadoc", column = @Column(name = "CDGO_REFERENCIADOC")) })
public class Tbasg177DocOrdenActiDatoPK implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer cdgoClave;
	private Integer cdgoReferenciadoc;

	public Integer getCdgoClave() {
		return this.cdgoClave;
	}

	public Integer getCdgoReferenciadoc() {
		return this.cdgoReferenciadoc;
	}

	public void setCdgoClave(Integer cdgoClave) {
		this.cdgoClave = cdgoClave;
	}

	public void setCdgoReferenciadoc(Integer cdgoReferenciadoc) {
		this.cdgoReferenciadoc = cdgoReferenciadoc;
	}

}