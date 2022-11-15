package renfe.com.repository;

import java.util.List;

import renfe.com.model.entity.Tbasg139Cursomate;

public interface Tbasg139CursomateRepositoryCustom {

	public List<Tbasg139Cursomate> getCursoMateCount();

	public List<Tbasg139Cursomate> getCursoMateListAscendente();

	public List<Tbasg139Cursomate> getCursoMateListDescendente();

	public List<Tbasg139Cursomate> getCursoMate(String cdgoCursomat);

	public int insertCursoMate(Tbasg139Cursomate bean);

	public int updateCursoMate(Tbasg139Cursomate bean);

	public int deleteCursoMate(Tbasg139Cursomate bean);

}
