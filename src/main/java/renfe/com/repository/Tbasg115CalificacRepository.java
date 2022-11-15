package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg115Calificac;

public interface Tbasg115CalificacRepository
		extends JpaRepository<Tbasg115Calificac, Integer>, Tbasg115CalificacRepositoryCustom {

	// Optional<Tbasg115Calificac> findByCdgoCalifi(Integer cdgoCalifi);
	public Optional<Tbasg115Calificac> findByCdgoCalifi(Integer cdgoCalifi);

	public List<Tbasg115Calificac> findByCdgoCalifiIn(Collection<Integer> cdgoCalifi);
}
