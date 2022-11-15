package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg159GcConcepto;
import renfe.com.model.entity.Tbasg159GcConceptoPK;

public interface Tbasg159GcConceptoRepository
		extends JpaRepository<Tbasg159GcConcepto, Tbasg159GcConceptoPK>, Tbasg159GcConceptoRepositoryCustom {

	// Optional<Tbasg159GcConcepto> findByTbasg159gcconceptopk(Tbasg159GcConceptoPK
	// tbasg159gcconceptopk);
	public Optional<Tbasg159GcConcepto> findById(Tbasg159GcConceptoPK tbasg159gcconceptopk);

	public List<Tbasg159GcConcepto> findByTbasg159gcconceptopkIn(Collection<Tbasg159GcConceptoPK> tbasg159gcconceptopk);
}
