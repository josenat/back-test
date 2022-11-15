package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg209RepErrForma;

public interface Tbasg209RepErrFormaRepository
		extends JpaRepository<Tbasg209RepErrForma, Integer>, Tbasg209RepErrFormaRepositoryCustom {

	// Optional<Tbasg209RepErrForma> findByCdgoReprocesado(Integer cdgoReprocesado);
	public Optional<Tbasg209RepErrForma> findByCdgoReprocesado(Integer cdgoReprocesado);

	public List<Tbasg209RepErrForma> findByCdgoReprocesadoIn(Collection<Integer> cdgoReprocesado);
}
