package renfe.com.repository;

import java.util.List;

import renfe.com.model.entity.Tbasg131Alcanceot;

public interface Tbasg131AlcanceotRepositoryCustom {

	public List<Tbasg131Alcanceot> getAlcanceOtCount();
	
	public List<Tbasg131Alcanceot> getAlcanceOtList();

	public List<Tbasg131Alcanceot> getAlcanceOtListAscendente();

	public List<Tbasg131Alcanceot> getAlcanceOtListDescendente();

	public List<Tbasg131Alcanceot> getAlcanceOt(Integer cdgoAlcanceot);

	public List<Tbasg131Alcanceot> getAlcanceOtInfSer(Integer cdgoAlcanceot);
	
	public List<Tbasg131Alcanceot> getAlcanceOtNombre(String cdgoAlcanceot);

	public List<Tbasg131Alcanceot> getAlcanceOtActiveList();

	public int insertAlcanceOt(Tbasg131Alcanceot bean);

	public int updateAlcanceOt(Tbasg131Alcanceot bean);
	
	public int estadoAlcanceOt(Tbasg131Alcanceot bean);

}
