package renfe.com.dto;

import java.util.List;
import java.util.Vector;

public class UserOptionDTO {
	String cdgoProceso;
	String desgProceso;
	String desgAyuda;
	String cdgoColor;
	List<UserSubOptionDTO> subOption;

	public String getCdgoProceso() {
		return cdgoProceso;
	}

	public void setCdgoProceso(String cdgoProceso) {
		this.cdgoProceso = cdgoProceso;
	}

	public String getDesgProceso() {
		return desgProceso;
	}

	public void setDesgProceso(String desgProceso) {
		this.desgProceso = desgProceso;
	}

	public String getDesgAyuda() {
		return desgAyuda;
	}

	public void setDesgAyuda(String desgAyuda) {
		this.desgAyuda = desgAyuda;
	}

	public String getCdgoColor() {
		return cdgoColor;
	}

	public void setCdgoColor(String cdgoColor) {
		this.cdgoColor = cdgoColor;
	}

	public List<UserSubOptionDTO> getSubOption() {
		return subOption;
	}

	public void setSubOption(List<UserSubOptionDTO> subOption) {
		this.subOption = subOption;
	}

}
