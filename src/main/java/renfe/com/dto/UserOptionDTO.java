package renfe.com.dto;

import java.util.List;
import java.util.Vector;

public class UserOptionDTO {
	String cdgoProceso;
	String desgProceso;
	String desgAyuda;
	List<UserSubOptionDTO> subOptions;

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

	public List<UserSubOptionDTO> getSubOptions() {
		return subOptions;
	}

	public void setSubOptions(List<UserSubOptionDTO> subOptions) {
		this.subOptions = subOptions;
	}

}
