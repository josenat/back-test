package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg257Alcanauxcab;

public interface Tbasg257AlcanauxcabRepository
		extends JpaRepository<Tbasg257Alcanauxcab, Integer>, Tbasg257AlcanauxcabRepositoryCustom {

	// Optional<Tbasg257Alcanauxcab> findByCdgoAlcanauxcab(Integer cdgoAlcanauxcab);
	public Optional<Tbasg257Alcanauxcab> findByCdgoAlcanauxcab(Integer cdgoAlcanauxcab);

	public List<Tbasg257Alcanauxcab> findByCdgoAlcanauxcabIn(Collection<Integer> cdgoAlcanauxcab);
}
