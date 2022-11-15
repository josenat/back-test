package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.model.dto.Tbasg193DocInfrArtSuspenDto;

public interface Tbasg193DocInfrArtSuspenService {

	public List<Tbasg193DocInfrArtSuspenDto> getAllTbasg193DocInfrArtSuspen(Tbasg193DocInfrArtSuspenDto filter);

	public Tbasg193DocInfrArtSuspenDto findByCdgoArticulo(Integer cdgoArticulo);

	public Tbasg193DocInfrArtSuspenDto createTbasg193DocInfrArtSuspen(
			Tbasg193DocInfrArtSuspenDto tbasg193DocInfrArtSuspenDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg193DocInfrArtSuspenDto updateTbasg193DocInfrArtSuspen(Integer cdgoArticulo,
			Tbasg193DocInfrArtSuspenDto tbasg193DocInfrArtSuspenDto)
			throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg193DocInfrArtSuspen(Integer cdgoArticulo);

	public List<Tbasg193DocInfrArtSuspenDto> findByCdgoArticuloIn(List<Integer> cdgoArticulo);

	public List<Tbasg193DocInfrArtSuspenDto> getDocInfrArtSuspenList();

	public List<Tbasg193DocInfrArtSuspenDto> getDocInfrArtSuspenByCdgoArticulo(String cdgoArticulo);

}
