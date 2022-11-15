package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.model.dto.Tbasg133SerieDto;
import renfe.com.model.entity.Tbasg133Serie;

public interface Tbasg133SerieService {

	public List<Tbasg133SerieDto> getAllTbasg133Serie(Tbasg133SerieDto filter);

	public Tbasg133SerieDto findByCdgoSerie(String cdgoSerie);

	public Tbasg133SerieDto createTbasg133Serie(Tbasg133SerieDto tbasg133SerieDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg133SerieDto updateTbasg133Serie(String cdgoSerie, Tbasg133SerieDto tbasg133SerieDto)
			throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg133Serie(String cdgoSerie);

	public List<Tbasg133SerieDto> findByCdgoSerieIn(List<String> cdgoSerie);

	public List<Tbasg133SerieDto> getSerieCount();

	public List<Tbasg133SerieDto> getSerieListAscendente();

	public List<Tbasg133SerieDto> getSerieListDescendente();

	public List<Tbasg133SerieDto> getSerie(String cdgoSerie);
	
	public List<Tbasg133SerieDto> getSerieNombre(String cdgoSerie);

	public List<Tbasg133SerieDto> getSerieByNombre(/** FIXME revisar tipo */
	Object nombre);

	public List<Tbasg133SerieDto> getSerieListActive();
	
	public List<Tbasg133SerieDto> getSerieActiveListAscendente();

	public int insertSerie(Tbasg133Serie bean);

	public int updateSerie(Tbasg133Serie bean);
	
	public int estadoSerie(Tbasg133Serie bean);

}
