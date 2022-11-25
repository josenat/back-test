package renfe.com.dto;

import java.util.ArrayList;
import java.util.Map;

public class UserRoleDTO {
	private String cdgoRolmaster;
	private String desgRol;

	private ArrayList<SubOptionLevelDTO> levels;

	public ArrayList<SubOptionLevelDTO> getLevels() {
		return levels;
	}
	
	public void setLevels(ArrayList<SubOptionLevelDTO> levels) {
		this.levels = levels;
	}
	
	public String getCdgoRolmaster() {
		return cdgoRolmaster;
	}

	public void setCdgoRolmaster(String cdgoRolmaster) {
		this.cdgoRolmaster = cdgoRolmaster;
	}

	public String getDesgRol() {
		return desgRol;
	}

	public void setDesgRol(String desgRol) {
		this.desgRol = desgRol;
	}
	
	
}
