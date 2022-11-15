package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg127Lineas;

public interface Tbasg127LineasRepository
		extends JpaRepository<Tbasg127Lineas, String>, Tbasg127LineasRepositoryCustom {

	// Optional<Tbasg127Lineas> findByCdgoLinea(String cdgoLinea);
	public Optional<Tbasg127Lineas> findByCdgoLinea(String cdgoLinea);

	public List<Tbasg127Lineas> findByCdgoLineaIn(Collection<String> cdgoLinea);
}
