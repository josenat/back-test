package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.model.dto.Tbasg129EntornosDto;
import renfe.com.model.entity.Tbasg129Entornos;

public interface Tbasg129EntornosService {

	public List<Tbasg129EntornosDto> getAllTbasg129Entornos(Tbasg129EntornosDto filter);

	public Tbasg129EntornosDto findByCdgoEntorno(Integer cdgoEntorno);

	public Tbasg129EntornosDto createTbasg129Entornos(Tbasg129EntornosDto tbasg129EntornosDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg129EntornosDto updateTbasg129Entornos(Integer cdgoEntorno, Tbasg129EntornosDto tbasg129EntornosDto)
			throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg129Entornos(Integer cdgoEntorno);

	public List<Tbasg129EntornosDto> findByCdgoEntornoIn(List<Integer> cdgoEntorno);

	public List<Tbasg129EntornosDto> getEntornosCount();

	public List<Tbasg129EntornosDto> getEntornosListAscendente();
	
	public List<Tbasg129EntornosDto> getEntornosList();

	public List<Tbasg129EntornosDto> getEntornosListDescendente();

	public List<Tbasg129EntornosDto> getEntornosActiveListAscendente(String nombreLargo);

	public List<Tbasg129EntornosDto> getEntornosActiveListDescendente(String nombreLargo);

	public List<Tbasg129EntornosDto> getEntornosActiveWithTramosListAscendente();

	public List<Tbasg129EntornosDto> getEntornosActiveWithTramosListDescendente();

	public List<Tbasg129EntornosDto> getEntornos(Integer cdgoEntorno);
	
	public List<Tbasg129EntornosDto> getEntornosNombre(String cdgoEntorno);

	public List<Tbasg129EntornosDto> getAlcanceEntorno(Integer cdgoEntorno);

	public List<Tbasg129EntornosDto> getEntornosByNomCorto(String desgNomcorto);

	public int insertEntornos(Tbasg129Entornos bean);

	public int updateEntornos(Tbasg129Entornos bean);

}

