package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg123Tipohabil;

public interface Tbasg123TipohabilRepository
		extends JpaRepository<Tbasg123Tipohabil, Integer>, Tbasg123TipohabilRepositoryCustom {

	// Optional<Tbasg123Tipohabil> findByCdgoTipohab(Integer cdgoTipohab);
	public Optional<Tbasg123Tipohabil> findByCdgoTipohab(Integer cdgoTipohab);

	public List<Tbasg123Tipohabil> findByCdgoTipohabIn(Collection<Integer> cdgoTipohab);
}
