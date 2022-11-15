package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg208RepErrInact;

public interface Tbasg208RepErrInactRepository
		extends JpaRepository<Tbasg208RepErrInact, Integer>, Tbasg208RepErrInactRepositoryCustom {

	// Optional<Tbasg208RepErrInact> findByCdgoReprocesado(Integer cdgoReprocesado);
	public Optional<Tbasg208RepErrInact> findByCdgoReprocesado(Integer cdgoReprocesado);

	public List<Tbasg208RepErrInact> findByCdgoReprocesadoIn(Collection<Integer> cdgoReprocesado);
}
