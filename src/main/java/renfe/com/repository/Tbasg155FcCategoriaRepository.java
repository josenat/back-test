package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg155FcCategoria;

public interface Tbasg155FcCategoriaRepository
		extends JpaRepository<Tbasg155FcCategoria, Integer>, Tbasg155FcCategoriaRepositoryCustom {

	// Optional<Tbasg155FcCategoria> findByCdgoCategoria(Integer cdgoCategoria);
	public Optional<Tbasg155FcCategoria> findByCdgoCategoria(Integer cdgoCategoria);

	public List<Tbasg155FcCategoria> findByCdgoCategoriaIn(Collection<Integer> cdgoCategoria);
}
