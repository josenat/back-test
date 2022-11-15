package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg168AnotacionInspector;

public interface Tbasg168AnotacionInspectorRepository
		extends JpaRepository<Tbasg168AnotacionInspector, Integer>, Tbasg168AnotacionInspectorRepositoryCustom {

	// Optional<Tbasg168AnotacionInspector> findByCdgoAnotacion(Integer
	// cdgoAnotacion);
	public Optional<Tbasg168AnotacionInspector> findByCdgoAnotacion(Integer cdgoAnotacion);

	public List<Tbasg168AnotacionInspector> findByCdgoAnotacionIn(Collection<Integer> cdgoAnotacion);
}
