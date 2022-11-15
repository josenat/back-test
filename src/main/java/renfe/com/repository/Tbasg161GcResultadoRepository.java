package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg161GcResultado;
import renfe.com.model.entity.Tbasg161GcResultadoPK;

public interface Tbasg161GcResultadoRepository
		extends JpaRepository<Tbasg161GcResultado, Tbasg161GcResultadoPK>, Tbasg161GcResultadoRepositoryCustom {

	// Optional<Tbasg161GcResultado>
	// findByTbasg161gcresultadopk(Tbasg161GcResultadoPK tbasg161gcresultadopk);
	public Optional<Tbasg161GcResultado> findById(Tbasg161GcResultadoPK tbasg161gcresultadopk);

	public List<Tbasg161GcResultado> findByTbasg161gcresultadopkIn(
			Collection<Tbasg161GcResultadoPK> tbasg161gcresultadopk);
}
