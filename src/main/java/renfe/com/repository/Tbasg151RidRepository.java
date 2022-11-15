package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg151Rid;

public interface Tbasg151RidRepository extends JpaRepository<Tbasg151Rid, Integer>, Tbasg151RidRepositoryCustom {

	// Optional<Tbasg151Rid> findByCdgoExpedient(Integer cdgoExpedient);
	public Optional<Tbasg151Rid> findByCdgoExpedient(Integer cdgoExpedient);

	public List<Tbasg151Rid> findByCdgoExpedientIn(Collection<Integer> cdgoExpedient);
}
