package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg207RepErrActiv;

public interface Tbasg207RepErrActivRepository
		extends JpaRepository<Tbasg207RepErrActiv, Integer>, Tbasg207RepErrActivRepositoryCustom {

	// Optional<Tbasg207RepErrActiv> findByCdgoReprocesado(Integer cdgoReprocesado);
	public Optional<Tbasg207RepErrActiv> findByCdgoReprocesado(Integer cdgoReprocesado);

	public List<Tbasg207RepErrActiv> findByCdgoReprocesadoIn(Collection<Integer> cdgoReprocesado);
}
