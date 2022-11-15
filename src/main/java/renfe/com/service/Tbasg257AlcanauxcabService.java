package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.model.dto.Tbasg257AlcanauxcabDto;
import renfe.com.model.entity.Tbasg257Alcanauxcab;

public interface Tbasg257AlcanauxcabService {

	public List<Tbasg257AlcanauxcabDto> getAllTbasg257Alcanauxcab(Tbasg257AlcanauxcabDto filter);

	public Tbasg257AlcanauxcabDto findByCdgoAlcanauxcab(Integer cdgoAlcanauxcab);

	public Tbasg257AlcanauxcabDto createTbasg257Alcanauxcab(Tbasg257AlcanauxcabDto tbasg257AlcanauxcabDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg257AlcanauxcabDto updateTbasg257Alcanauxcab(Integer cdgoAlcanauxcab,
			Tbasg257AlcanauxcabDto tbasg257AlcanauxcabDto) throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg257Alcanauxcab(Integer cdgoAlcanauxcab);

	public List<Tbasg257AlcanauxcabDto> findByCdgoAlcanauxcabIn(List<Integer> cdgoAlcanauxcab);

	public List<Tbasg257AlcanauxcabDto> getAuxCabCount();

	public List<Tbasg257AlcanauxcabDto> getAuxCabListAscendente();

	public List<Tbasg257AlcanauxcabDto> getAuxCabListDescendente();

	public List<Tbasg257AlcanauxcabDto> getAuxCab(String cdgoAlcanauxcab);
	
	public List<Tbasg257AlcanauxcabDto> getAuxCabNombre(String cdgoAlcanauxcab);

	public List<Tbasg257AlcanauxcabDto> getAuxCabActiveList();

	public int insertAuxCab(Tbasg257Alcanauxcab bean);

	public int updateAuxCab(Tbasg257Alcanauxcab bean);
	
	public int estadoAuxCab(Tbasg257Alcanauxcab bean);

}
