package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg129Entornos;

public interface Tbasg129EntornosRepository
		extends JpaRepository<Tbasg129Entornos, Integer>, Tbasg129EntornosRepositoryCustom {

	// Optional<Tbasg129Entornos> findByCdgoEntorno(Integer cdgoEntorno);
	public Optional<Tbasg129Entornos> findByCdgoEntorno(Integer cdgoEntorno);

	public List<Tbasg129Entornos> findByCdgoEntornoIn(Collection<Integer> cdgoEntorno);
}
