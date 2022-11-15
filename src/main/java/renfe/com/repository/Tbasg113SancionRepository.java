package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg113Sancion;

public interface Tbasg113SancionRepository
		extends JpaRepository<Tbasg113Sancion, Integer>, Tbasg113SancionRepositoryCustom {

	// Optional<Tbasg113Sancion> findByCdgoSancion(Integer cdgoSancion);
	public Optional<Tbasg113Sancion> findByCdgoSancion(Integer cdgoSancion);

	public List<Tbasg113Sancion> findByCdgoSancionIn(Collection<Integer> cdgoSancion);
}
