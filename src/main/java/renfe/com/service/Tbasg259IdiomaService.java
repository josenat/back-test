package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.model.dto.Tbasg259IdiomaDto;

public interface Tbasg259IdiomaService {

	public List<Tbasg259IdiomaDto> getAllTbasg259Idioma(Tbasg259IdiomaDto filter);

	public Tbasg259IdiomaDto findByCdgoIdioma(String cdgoIdioma);

	public Tbasg259IdiomaDto createTbasg259Idioma(Tbasg259IdiomaDto tbasg259IdiomaDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg259IdiomaDto updateTbasg259Idioma(String cdgoIdioma, Tbasg259IdiomaDto tbasg259IdiomaDto)
			throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg259Idioma(String cdgoIdioma);

	public List<Tbasg259IdiomaDto> findByCdgoIdiomaIn(List<String> cdgoIdioma);

	public List<Tbasg259IdiomaDto> getListaIdiomas();

	public List<Tbasg259IdiomaDto> getListaIdiomasActivos();

}
