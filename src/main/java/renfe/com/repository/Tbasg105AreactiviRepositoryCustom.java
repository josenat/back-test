package renfe.com.repository;

import java.util.List;

import renfe.com.dto.GetAreActiviListAscendenteDTO;
import renfe.com.dto.GetAreActiviListComboDTO;
import renfe.com.dto.GetSociedadesByCodAreaActivListDTO;
import renfe.com.model.entity.Tbasg105Areactivi;

public interface Tbasg105AreactiviRepositoryCustom {

	public List<Tbasg105Areactivi> getAreActiviCount();

	public List<GetAreActiviListComboDTO> getAreActiviListCombo();

	public List<GetAreActiviListAscendenteDTO> getAreActiviListAscendente();

	public List<Tbasg105Areactivi> getAreActiviListDescendente();

	public List<Tbasg105Areactivi> getAreActiviActiveListAscendente();

	public List<Tbasg105Areactivi> getAreActiviActiveListDescendente();

	public List<Tbasg105Areactivi> getAreActiviListAscendenteDESG_NOMBRE();

	public List<Tbasg105Areactivi> getAreActiviListAscendenteSelectedByLevel();

	public List<Tbasg105Areactivi> getAreActiviActiveListAscendenteDESG_NOMBRE();

	public List<Tbasg105Areactivi> getAreActiviActiveListDescendenteDESG_NOMBRE();

	public List<Tbasg105Areactivi> getAreActivi(String cdgoAreact);

	public List<Tbasg105Areactivi> getAreActiviActiveListCodes();

	public List<Tbasg105Areactivi> getAreActiviListByAreTerList(List<Integer>estadosList);

	public List<Tbasg105Areactivi> getAreActiviListByAreTerListAll();

	public int insertAreActivi(Tbasg105Areactivi bean);

	public int updateAreActivi(Tbasg105Areactivi bean);
	
	public int estadoAreActivi(Tbasg105Areactivi bean);

	public List<Tbasg105Areactivi> getAreTerListAscendenteCDGO_ARETER();

	public List<Tbasg105Areactivi> getAreTerActiveListAscendenteCDGO_ARETER();

	public List<Tbasg105Areactivi> getSociedadesByCodAreaActiv();

	public List<Tbasg105Areactivi> getSociedadesByCodAreaActivAll();
	
	public List<Tbasg105Areactivi> getCodAreActiviListByAreTerList();
	
	public List<GetSociedadesByCodAreaActivListDTO> getSociedadesByCodAreaActivList();	
	
	public List<Tbasg105Areactivi> getSociedadesByCodAreaActiv(List<Integer> listAreaActi);

	
}
