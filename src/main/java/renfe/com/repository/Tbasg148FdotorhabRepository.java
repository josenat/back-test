package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg148Fdotorhab;

public interface Tbasg148FdotorhabRepository
		extends JpaRepository<Tbasg148Fdotorhab, Integer>, Tbasg148FdotorhabRepositoryCustom {

	// Optional<Tbasg148Fdotorhab> findByCdgoFirma(Integer cdgoFirma);
	public Optional<Tbasg148Fdotorhab> findByCdgoFirma(Integer cdgoFirma);

	public List<Tbasg148Fdotorhab> findByCdgoFirmaIn(Collection<Integer> cdgoFirma);
}
