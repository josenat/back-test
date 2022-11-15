package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg116Estados;

public interface Tbasg116EstadosRepository
		extends JpaRepository<Tbasg116Estados, Integer>, Tbasg116EstadosRepositoryCustom {

	// Optional<Tbasg116Estados> findByCdgoEstado(Integer cdgoEstado);
	public Optional<Tbasg116Estados> findByCdgoEstado(Integer cdgoEstado);

	public List<Tbasg116Estados> findByCdgoEstadoIn(Collection<Integer> cdgoEstado);
}
