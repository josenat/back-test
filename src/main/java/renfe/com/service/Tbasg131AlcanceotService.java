package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.model.dto.Tbasg131AlcanceotDto;
import renfe.com.model.entity.Tbasg131Alcanceot;

public interface Tbasg131AlcanceotService {

	public List<Tbasg131AlcanceotDto> getAllTbasg131Alcanceot(Tbasg131AlcanceotDto filter);

	public Tbasg131AlcanceotDto findByCdgoAlcanceot(Integer cdgoAlcanceot);

	public Tbasg131AlcanceotDto createTbasg131Alcanceot(Tbasg131AlcanceotDto tbasg131AlcanceotDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg131AlcanceotDto updateTbasg131Alcanceot(Integer cdgoAlcanceot,
			Tbasg131AlcanceotDto tbasg131AlcanceotDto) throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg131Alcanceot(Integer cdgoAlcanceot);

	public List<Tbasg131AlcanceotDto> findByCdgoAlcanceotIn(List<Integer> cdgoAlcanceot);

	public List<Tbasg131AlcanceotDto> getAlcanceOtCount();
	
	public List<Tbasg131AlcanceotDto> getAlcanceOtList();

	public List<Tbasg131AlcanceotDto> getAlcanceOtListAscendente();

	public List<Tbasg131AlcanceotDto> getAlcanceOtListDescendente();

	public List<Tbasg131AlcanceotDto> getAlcanceOt(Integer cdgoAlcanceot);

	public List<Tbasg131AlcanceotDto> getAlcanceOtInfSer(Integer cdgoAlcanceot);

	public List<Tbasg131AlcanceotDto> getAlcanceOtNombre(String cdgoAlcanceot);

	public List<Tbasg131AlcanceotDto> getAlcanceOtActiveList();

	public int insertAlcanceOt(Tbasg131Alcanceot bean);

	public int updateAlcanceOt(Tbasg131Alcanceot bean);
	
	public int estadoAlcanceOt(Tbasg131Alcanceot bean);

}
