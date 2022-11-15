package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg158GcCategoria;

public interface Tbasg158GcCategoriaRepository
		extends JpaRepository<Tbasg158GcCategoria, String>, Tbasg158GcCategoriaRepositoryCustom {

	// Optional<Tbasg158GcCategoria> findByCdgoCategoria(String cdgoCategoria);
	public Optional<Tbasg158GcCategoria> findByCdgoCategoria(String cdgoCategoria);

	public List<Tbasg158GcCategoria> findByCdgoCategoriaIn(Collection<String> cdgoCategoria);
}
