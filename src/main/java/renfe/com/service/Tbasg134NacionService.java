package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.model.dto.Tbasg134NacionDto;
import renfe.com.model.entity.Tbasg134Nacion;

public interface Tbasg134NacionService {

	public List<Tbasg134NacionDto> getAllTbasg134Nacion(Tbasg134NacionDto filter);

	public Tbasg134NacionDto findByCdgoNacion(Integer cdgoNacion);

	public Tbasg134NacionDto createTbasg134Nacion(Tbasg134NacionDto tbasg134NacionDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg134NacionDto updateTbasg134Nacion(Integer cdgoNacion, Tbasg134NacionDto tbasg134NacionDto)
			throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg134Nacion(Integer cdgoNacion);

	public List<Tbasg134NacionDto> findByCdgoNacionIn(List<Integer> cdgoNacion);

	public List<Tbasg134NacionDto> getNacionCount();

	public List<Tbasg134NacionDto> getNacionListAscendente();

	public List<Tbasg134NacionDto> getNacionListDescendente();

	public List<Tbasg134NacionDto> getNacionActiveListAscendente();

	public List<Tbasg134NacionDto> getNacionActiveListDescendente();

	public List<Tbasg134NacionDto> getNacion(String cdgoNacion);

	public int insertNacion(Tbasg134Nacion bean);

	public int updateNacion(Tbasg134Nacion bean);
	
	public int estadoNacion(Tbasg134Nacion bean);

}
