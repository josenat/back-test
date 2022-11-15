package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.model.dto.Tbasg192DocInfrGerenciaterrDto;

public interface Tbasg192DocInfrGerenciaterrService {

	public List<Tbasg192DocInfrGerenciaterrDto> getAllTbasg192DocInfrGerenciaterr(
			Tbasg192DocInfrGerenciaterrDto filter);

	public Tbasg192DocInfrGerenciaterrDto findByCdgoGerencia(Integer cdgoGerencia);

	public Tbasg192DocInfrGerenciaterrDto createTbasg192DocInfrGerenciaterr(
			Tbasg192DocInfrGerenciaterrDto tbasg192DocInfrGerenciaterrDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg192DocInfrGerenciaterrDto updateTbasg192DocInfrGerenciaterr(Integer cdgoGerencia,
			Tbasg192DocInfrGerenciaterrDto tbasg192DocInfrGerenciaterrDto)
			throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg192DocInfrGerenciaterr(Integer cdgoGerencia);

	public List<Tbasg192DocInfrGerenciaterrDto> findByCdgoGerenciaIn(List<Integer> cdgoGerencia);

	public List<Tbasg192DocInfrGerenciaterrDto> getDocInfrGerenciaTerrList();

	public List<Tbasg192DocInfrGerenciaterrDto> getDocInfrGerenciaTerrByCdgoGerencia(String cdgoGerencia);

}
