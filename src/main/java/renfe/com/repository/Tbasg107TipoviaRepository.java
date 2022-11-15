package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg107Tipovia;

public interface Tbasg107TipoviaRepository
		extends JpaRepository<Tbasg107Tipovia, Integer>, Tbasg107TipoviaRepositoryCustom {

	// Optional<Tbasg107Tipovia> findByCdgoTipovia(Integer cdgoTipovia);
	public Optional<Tbasg107Tipovia> findByCdgoTipovia(Integer cdgoTipovia);

	public List<Tbasg107Tipovia> findByCdgoTipoviaIn(Collection<Integer> cdgoTipovia);
}
