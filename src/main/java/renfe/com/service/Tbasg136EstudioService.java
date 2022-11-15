package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.model.dto.Tbasg136EstudioDto;
import renfe.com.model.entity.Tbasg136Estudio;

public interface Tbasg136EstudioService {

	public List<Tbasg136EstudioDto> getAllTbasg136Estudio(Tbasg136EstudioDto filter);

	public Tbasg136EstudioDto findByCdgoEstudio(Integer cdgoEstudio);

	public Tbasg136EstudioDto createTbasg136Estudio(Tbasg136EstudioDto tbasg136EstudioDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg136EstudioDto updateTbasg136Estudio(Integer cdgoEstudio, Tbasg136EstudioDto tbasg136EstudioDto)
			throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg136Estudio(Integer cdgoEstudio);

	public List<Tbasg136EstudioDto> findByCdgoEstudioIn(List<Integer> cdgoEstudio);

	public List<Tbasg136EstudioDto> getEstudioCount();

	public List<Tbasg136EstudioDto> getEstudioListAscendente();

	public List<Tbasg136EstudioDto> getEstudioListDescendente();

	public List<Tbasg136EstudioDto> getEstudioActiveListAscendente();

	public List<Tbasg136EstudioDto> getEstudioActiveListDescendente();

	public List<Tbasg136EstudioDto> getEstudio(String cdgoEstudio);

	public int insertEstudio(Tbasg136Estudio bean);

	public int updateEstudio(Tbasg136Estudio bean);
	
	public int estadoEstudio(Tbasg136Estudio bean);

}
