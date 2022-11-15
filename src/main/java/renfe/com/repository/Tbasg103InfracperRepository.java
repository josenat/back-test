package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg103Infracper;

public interface Tbasg103InfracperRepository
		extends JpaRepository<Tbasg103Infracper, Integer>, Tbasg103InfracperRepositoryCustom {

	// Optional<Tbasg103Infracper> findByCdgoInfrper(Integer cdgoInfrper);
	public Optional<Tbasg103Infracper> findByCdgoInfrper(Integer cdgoInfrper);

	public List<Tbasg103Infracper> findByCdgoInfrperIn(Collection<Integer> cdgoInfrper);
}
