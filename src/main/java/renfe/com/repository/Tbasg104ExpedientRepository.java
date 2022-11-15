package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg104Expedient;

public interface Tbasg104ExpedientRepository
		extends JpaRepository<Tbasg104Expedient, Integer>, Tbasg104ExpedientRepositoryCustom {

	// Optional<Tbasg104Expedient> findByCdgoExpedient(Integer cdgoExpedient);
	public Optional<Tbasg104Expedient> findByCdgoExpedient(Integer cdgoExpedient);

	public List<Tbasg104Expedient> findByCdgoExpedientIn(Collection<Integer> cdgoExpedient);
}
