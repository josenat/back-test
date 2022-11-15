package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg206RepErrSalud;

public interface Tbasg206RepErrSaludRepository
		extends JpaRepository<Tbasg206RepErrSalud, Integer>, Tbasg206RepErrSaludRepositoryCustom {

	// Optional<Tbasg206RepErrSalud> findByCdgoReprocesado(Integer cdgoReprocesado);
	public Optional<Tbasg206RepErrSalud> findByCdgoReprocesado(Integer cdgoReprocesado);

	public List<Tbasg206RepErrSalud> findByCdgoReprocesadoIn(Collection<Integer> cdgoReprocesado);
}
