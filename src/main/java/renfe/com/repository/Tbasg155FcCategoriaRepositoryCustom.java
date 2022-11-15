package renfe.com.repository;

import java.util.List;

import renfe.com.model.dto.Tbasg155FcCategoriaDto;
import renfe.com.model.entity.Tbasg155FcCategoria;

public interface Tbasg155FcCategoriaRepositoryCustom {

	public List<Tbasg155FcCategoria> getFcCategoriaCount();

	public List<Tbasg155FcCategoria> getFcCategoriaListAscendente();

	public List<Tbasg155FcCategoria> getFcCategoriaListDescendente();

	public List<Tbasg155FcCategoria> getFcCategoria(String cdgoCategoria);

	public List<Tbasg155FcCategoria> getFcCategoriaByNombre(String desgDescripcion);

	public List<Tbasg155FcCategoria> getFcCategoriaListActive();

	public List<Tbasg155FcCategoria> getFcCategoriaIdiomaList();

	public List<Tbasg155FcCategoriaDto> getFcCategoriaByNombre2(String desgDescripcion);

	public int insertFcCategoria(Tbasg155FcCategoria bean);

	public int updateFcCategoria(Tbasg155FcCategoria bean);
	
	public int estadoFcCategoria(Tbasg155FcCategoria bean);

}
