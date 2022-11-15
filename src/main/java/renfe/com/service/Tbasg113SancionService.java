package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.model.dto.Tbasg113SancionDto;
import renfe.com.model.entity.Tbasg113Sancion;

public interface Tbasg113SancionService {

	public List<Tbasg113SancionDto> getAllTbasg113Sancion(Tbasg113SancionDto filter);

	public Tbasg113SancionDto findByCdgoSancion(Integer cdgoSancion);

	public Tbasg113SancionDto createTbasg113Sancion(Tbasg113SancionDto tbasg113SancionDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg113SancionDto updateTbasg113Sancion(Integer cdgoSancion, Tbasg113SancionDto tbasg113SancionDto)
			throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg113Sancion(Integer cdgoSancion);

	public List<Tbasg113SancionDto> findByCdgoSancionIn(List<Integer> cdgoSancion);

	public List<Tbasg113SancionDto> getSancionCount();

	public List<Tbasg113SancionDto> getSancionActiveCount();

	public List<Tbasg113SancionDto> getSancionListAscendente();

	public List<Tbasg113SancionDto> getSancionListDescendente();

	public List<Tbasg113SancionDto> getSancionActiveListAscendente();

	public List<Tbasg113SancionDto> getSancionActiveListDescendente();

	public List<Tbasg113SancionDto> getSancion(String cdgoSancion);

	public int insertSancion(Tbasg113Sancion bean);

	public int updateSancion(Tbasg113Sancion bean);
	
	public int estadoSancion(Tbasg113Sancion bean);

}
