package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.model.dto.Tbasg190DocInfrOrdenanteDto;

public interface Tbasg190DocInfrOrdenanteService {

	public List<Tbasg190DocInfrOrdenanteDto> getAllTbasg190DocInfrOrdenante(Tbasg190DocInfrOrdenanteDto filter);

	public Tbasg190DocInfrOrdenanteDto findByCdgoOrdenante(Integer cdgoOrdenante);

	public Tbasg190DocInfrOrdenanteDto createTbasg190DocInfrOrdenante(
			Tbasg190DocInfrOrdenanteDto tbasg190DocInfrOrdenanteDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg190DocInfrOrdenanteDto updateTbasg190DocInfrOrdenante(Integer cdgoOrdenante,
			Tbasg190DocInfrOrdenanteDto tbasg190DocInfrOrdenanteDto)
			throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg190DocInfrOrdenante(Integer cdgoOrdenante);

	public List<Tbasg190DocInfrOrdenanteDto> findByCdgoOrdenanteIn(List<Integer> cdgoOrdenante);

	public List<Tbasg190DocInfrOrdenanteDto> getDocInfrOrdenanteList();

	public List<Tbasg190DocInfrOrdenanteDto> getDocInfrOrdenanteByCdgoOrdenante(String cdgoOrdenante);

}
