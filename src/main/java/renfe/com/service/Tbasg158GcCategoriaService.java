package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.model.dto.Tbasg158GcCategoriaDto;

public interface Tbasg158GcCategoriaService {

	public List<Tbasg158GcCategoriaDto> getAllTbasg158GcCategoria(Tbasg158GcCategoriaDto filter);

	public Tbasg158GcCategoriaDto findByCdgoCategoria(String cdgoCategoria);

	public Tbasg158GcCategoriaDto createTbasg158GcCategoria(Tbasg158GcCategoriaDto tbasg158GcCategoriaDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg158GcCategoriaDto updateTbasg158GcCategoria(String cdgoCategoria,
			Tbasg158GcCategoriaDto tbasg158GcCategoriaDto) throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg158GcCategoria(String cdgoCategoria);

	public List<Tbasg158GcCategoriaDto> findByCdgoCategoriaIn(List<String> cdgoCategoria);

	public List<Tbasg158GcCategoriaDto> getGcCategoriasActiveList();

}
