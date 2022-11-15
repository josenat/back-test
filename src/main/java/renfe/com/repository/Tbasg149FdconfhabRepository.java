package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg149Fdconfhab;

public interface Tbasg149FdconfhabRepository
		extends JpaRepository<Tbasg149Fdconfhab, Integer>, Tbasg149FdconfhabRepositoryCustom {

	// Optional<Tbasg149Fdconfhab> findByCdgoFirma(Integer cdgoFirma);
	public Optional<Tbasg149Fdconfhab> findByCdgoFirma(Integer cdgoFirma);

	public List<Tbasg149Fdconfhab> findByCdgoFirmaIn(Collection<Integer> cdgoFirma);
}
