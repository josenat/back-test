package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.dto.GetAreTerListAscendenteDTO;
import renfe.com.model.dto.Tbasg141AreterDto;
import renfe.com.model.entity.Tbasg141Areter;

public interface Tbasg141AreterService {

	public List<Tbasg141AreterDto> getAllTbasg141Areter(Tbasg141AreterDto filter);

	public Tbasg141AreterDto findByCdgoAreter(Integer cdgoAreter);

	public Tbasg141AreterDto createTbasg141Areter(Tbasg141AreterDto tbasg141AreterDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg141AreterDto updateTbasg141Areter(Integer cdgoAreter, Tbasg141AreterDto tbasg141AreterDto)
			throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg141Areter(Integer cdgoAreter);

	public List<Tbasg141AreterDto> findByCdgoAreterIn(List<Integer> cdgoAreter);

	public List<Tbasg141AreterDto> getAreTerCount();

	public List<Tbasg141AreterDto> getAreTerListDescendenteCDGO_ARETER(Integer cdgoAreAct);

	public List<Tbasg141AreterDto> getAreTerListAscendenteDESG_NOMBRE();

	public List<Tbasg141AreterDto> getAreTerListDescendenteDESG_NOMBRE();

	public List<Tbasg141AreterDto> getAreTerActiveListDescendenteCDGO_ARETER();

	public List<Tbasg141AreterDto> getAreTerActiveListAscendenteDESG_NOMBRE();

	public List<Tbasg141AreterDto> getAreTerActiveListDescendenteDESG_NOMBRE();

	public List<Tbasg141AreterDto> getAreTerActiveListByCdgoAreact(Integer cdgoAreact);

	public List<Tbasg141AreterDto> getAreTer(String cdgoAreter);
	
	public List<GetAreTerListAscendenteDTO> getAreTerListAscendente();
	
	public List<GetAreTerListAscendenteDTO> getAreTerActiveListAscendente();

	public List<Tbasg141AreterDto> getListAreTerByCodsAreTer(List<Integer>cdgoAreTerList);

	public int insertAreTer(Tbasg141Areter bean);

	public int updateAreTer(Tbasg141Areter bean);
	
	public int estadoAreTer(Tbasg141Areter bean);

	public List<Tbasg141AreterDto> descAreaActPersona(String cdgoPersona);

	

}
