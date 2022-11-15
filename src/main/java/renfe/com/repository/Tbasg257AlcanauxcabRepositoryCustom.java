package renfe.com.repository;

import java.util.List;

import renfe.com.model.entity.Tbasg257Alcanauxcab;

public interface Tbasg257AlcanauxcabRepositoryCustom {

	public List<Tbasg257Alcanauxcab> getAuxCabCount();

	public List<Tbasg257Alcanauxcab> getAuxCabListAscendente();

	public List<Tbasg257Alcanauxcab> getAuxCabListDescendente();

	public List<Tbasg257Alcanauxcab> getAuxCab(String cdgoAlcanauxcab);
	
	public List<Tbasg257Alcanauxcab> getAuxCabNombre(String cdgoAlcanauxcab);
	
	public List<Tbasg257Alcanauxcab> getAuxCabActiveList();

	public int insertAuxCab(Tbasg257Alcanauxcab bean);

	public int updateAuxCab(Tbasg257Alcanauxcab bean);
	
	public int estadoAuxCab(Tbasg257Alcanauxcab bean);

}
