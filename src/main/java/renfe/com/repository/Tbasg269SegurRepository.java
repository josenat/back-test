package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg269Segur;

public interface Tbasg269SegurRepository extends JpaRepository<Tbasg269Segur, Integer>, Tbasg269SegurRepositoryCustom {

	// Optional<Tbasg269Segur> findByCdgoSeguridad(Integer cdgoSeguridad);
	public Optional<Tbasg269Segur> findByCdgoSeguridad(Integer cdgoSeguridad);

	public List<Tbasg269Segur> findByCdgoSeguridadIn(Collection<Integer> cdgoSeguridad);
}
