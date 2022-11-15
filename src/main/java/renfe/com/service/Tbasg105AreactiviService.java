package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.dto.GetAreActiviListAscendenteDTO;
import renfe.com.dto.GetAreActiviListComboDTO;
import renfe.com.dto.GetSociedadesByCodAreaActivListDTO;
import renfe.com.model.dto.Tbasg105AreactiviDto;
import renfe.com.model.entity.Tbasg105Areactivi;

public interface Tbasg105AreactiviService {

	public List<Tbasg105AreactiviDto> getAllTbasg105Areactivi(Tbasg105AreactiviDto filter);

	public Tbasg105AreactiviDto findByCdgoAreact(Integer cdgoAreact);

	public Tbasg105AreactiviDto createTbasg105Areactivi(Tbasg105AreactiviDto tbasg105AreactiviDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg105AreactiviDto updateTbasg105Areactivi(Integer cdgoAreact, Tbasg105AreactiviDto tbasg105AreactiviDto)
			throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg105Areactivi(Integer cdgoAreact);

	public List<Tbasg105AreactiviDto> findByCdgoAreactIn(List<Integer> cdgoAreact);

	public List<Tbasg105AreactiviDto> getAreActiviCount();

	public List<GetAreActiviListComboDTO> getAreActiviListCombo();

	public List<GetAreActiviListAscendenteDTO> getAreActiviListAscendente();

	public List<Tbasg105AreactiviDto> getAreActiviListDescendente();

	public List<Tbasg105AreactiviDto> getAreActiviActiveListAscendente();

	public List<Tbasg105AreactiviDto> getAreActiviActiveListDescendente();

	public List<Tbasg105AreactiviDto> getAreActiviListAscendenteDESG_NOMBRE();

	public List<Tbasg105AreactiviDto> getAreActiviListAscendenteSelectedByLevel();

	public List<Tbasg105AreactiviDto> getAreActiviActiveListAscendenteDESG_NOMBRE();

	public List<Tbasg105AreactiviDto> getAreActiviActiveListDescendenteDESG_NOMBRE();

	public List<Tbasg105AreactiviDto> getAreActivi(String cdgoAreact);
	
	public List<Tbasg105AreactiviDto> getAllAreAct();

	public List<Tbasg105AreactiviDto> getAreActiviActiveListCodes();

	public List<Tbasg105AreactiviDto> getAreActiviListByAreTerList(List<Integer>estadosList);

	public List<Tbasg105AreactiviDto> getAreActiviListByAreTerListAll();

	public List<Tbasg105AreactiviDto> getCodAreActiviListByAreTerList();

	public int insertAreActivi(Tbasg105Areactivi bean);

	public int updateAreActivi(Tbasg105Areactivi bean);
	
	public int estadoAreActivi(Tbasg105Areactivi bean);

	public List<Tbasg105AreactiviDto> getAreTerListAscendenteCDGO_ARETER();

	public List<Tbasg105AreactiviDto> getAreTerActiveListAscendenteCDGO_ARETER();

	public List<Tbasg105AreactiviDto> getSociedadesByCodAreaActiv(List<Integer> listAreaActi);

	public List<Tbasg105AreactiviDto> getSociedadesByCodAreaActivAll();

	public List<GetSociedadesByCodAreaActivListDTO> getSociedadesByCodAreaActivList();

}
