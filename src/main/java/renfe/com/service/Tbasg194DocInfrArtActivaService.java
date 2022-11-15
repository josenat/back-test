package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.model.dto.Tbasg194DocInfrArtActivaDto;

public interface Tbasg194DocInfrArtActivaService {

	public List<Tbasg194DocInfrArtActivaDto> getAllTbasg194DocInfrArtActiva(Tbasg194DocInfrArtActivaDto filter);

	public Tbasg194DocInfrArtActivaDto findByCdgoArticulo(Integer cdgoArticulo);

	public Tbasg194DocInfrArtActivaDto createTbasg194DocInfrArtActiva(
			Tbasg194DocInfrArtActivaDto tbasg194DocInfrArtActivaDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg194DocInfrArtActivaDto updateTbasg194DocInfrArtActiva(Integer cdgoArticulo,
			Tbasg194DocInfrArtActivaDto tbasg194DocInfrArtActivaDto)
			throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg194DocInfrArtActiva(Integer cdgoArticulo);

	public List<Tbasg194DocInfrArtActivaDto> findByCdgoArticuloIn(List<Integer> cdgoArticulo);

	public List<Tbasg194DocInfrArtActivaDto> getDocInfrArtActivaList();

	public List<Tbasg194DocInfrArtActivaDto> getDocInfrArtActivaByCdgoArticulo(String cdgoArticulo);

}
