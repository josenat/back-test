package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.model.dto.Tbasg139CursomateDto;
import renfe.com.model.entity.Tbasg139Cursomate;

public interface Tbasg139CursomateService {

	public List<Tbasg139CursomateDto> getAllTbasg139Cursomate(Tbasg139CursomateDto filter);

	public Tbasg139CursomateDto findByCdgoCursomat(Integer cdgoCursomat);

	public Tbasg139CursomateDto createTbasg139Cursomate(Tbasg139CursomateDto tbasg139CursomateDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg139CursomateDto updateTbasg139Cursomate(Integer cdgoCursomat, Tbasg139CursomateDto tbasg139CursomateDto)
			throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg139Cursomate(Integer cdgoCursomat);

	public List<Tbasg139CursomateDto> findByCdgoCursomatIn(List<Integer> cdgoCursomat);

	public List<Tbasg139CursomateDto> getCursoMateCount();

	public List<Tbasg139CursomateDto> getCursoMateListAscendente();

	public List<Tbasg139CursomateDto> getCursoMateListDescendente();

	public List<Tbasg139CursomateDto> getCursoMate(String cdgoCursomat);

	public int insertCursoMate(Tbasg139Cursomate bean);

	public int updateCursoMate(Tbasg139Cursomate bean);

	public int deleteCursoMate(Tbasg139Cursomate bean);

}
