package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg139Cursomate;

public interface Tbasg139CursomateRepository
		extends JpaRepository<Tbasg139Cursomate, Integer>, Tbasg139CursomateRepositoryCustom {

	// Optional<Tbasg139Cursomate> findByCdgoCursomat(Integer cdgoCursomat);
	public Optional<Tbasg139Cursomate> findByCdgoCursomat(Integer cdgoCursomat);

	public List<Tbasg139Cursomate> findByCdgoCursomatIn(Collection<Integer> cdgoCursomat);
}
