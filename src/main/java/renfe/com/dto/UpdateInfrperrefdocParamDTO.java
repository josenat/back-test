package renfe.com.dto;

public class UpdateInfrperrefdocParamDTO {

	private Integer cdgoReferenciaDoc;
	private String usuAct;
	private int cdgoInfrper;

	public Integer getCdgoReferenciaDoc() {
		return cdgoReferenciaDoc;
	}

	public void setCdgoReferenciaDoc(Integer cdgoReferenciaDoc) {
		this.cdgoReferenciaDoc = cdgoReferenciaDoc;
	}

	public String getUsuAct() {
		return usuAct;
	}

	public void setUsuAct(String usuAct) {
		this.usuAct = usuAct;
	}

	public int getCdgoInfrper() {
		return cdgoInfrper;
	}

	public void setCdgoInfrper(int cdgoInfrper) {
		this.cdgoInfrper = cdgoInfrper;
	}

}
