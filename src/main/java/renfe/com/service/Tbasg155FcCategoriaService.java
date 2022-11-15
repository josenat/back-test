package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.model.dto.Tbasg155FcCategoriaDto;
import renfe.com.model.entity.Tbasg155FcCategoria;

public interface Tbasg155FcCategoriaService {

	public List<Tbasg155FcCategoriaDto> getAllTbasg155FcCategoria(Tbasg155FcCategoriaDto filter);

	public Tbasg155FcCategoriaDto findByCdgoCategoria(Integer cdgoCategoria);

	public Tbasg155FcCategoriaDto createTbasg155FcCategoria(Tbasg155FcCategoriaDto tbasg155FcCategoriaDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg155FcCategoriaDto updateTbasg155FcCategoria(Integer cdgoCategoria,
			Tbasg155FcCategoriaDto tbasg155FcCategoriaDto) throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg155FcCategoria(Integer cdgoCategoria);

	public List<Tbasg155FcCategoriaDto> findByCdgoCategoriaIn(List<Integer> cdgoCategoria);

	public List<Tbasg155FcCategoriaDto> getFcCategoriaCount();

	public List<Tbasg155FcCategoriaDto> getFcCategoriaListAscendente();

	public List<Tbasg155FcCategoriaDto> getFcCategoriaListDescendente();

	public List<Tbasg155FcCategoriaDto> getFcCategoria(String cdgoCategoria);

	public List<Tbasg155FcCategoriaDto> getFcCategoriaByNombre(String desgDescripcion);

	public List<Tbasg155FcCategoriaDto> getFcCategoriaListActive();

	public List<Tbasg155FcCategoriaDto> getFcCategoriaIdiomaList();

	public List<Tbasg155FcCategoriaDto> getFcCategoriaByNombre2(String desgDescripcion);

	public int insertFcCategoria(Tbasg155FcCategoria bean);

	public int updateFcCategoria(Tbasg155FcCategoria bean);
	
	public int estadoFcCategoria(Tbasg155FcCategoria bean);

}
