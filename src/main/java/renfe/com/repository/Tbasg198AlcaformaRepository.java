package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg198Alcaforma;
import renfe.com.model.entity.Tbasg198AlcaformaPK;

public interface Tbasg198AlcaformaRepository
		extends JpaRepository<Tbasg198Alcaforma, Tbasg198AlcaformaPK>, Tbasg198AlcaformaRepositoryCustom {

	// Optional<Tbasg198Alcaforma> findByTbasg198alcaformapk(Tbasg198AlcaformaPK
	// tbasg198alcaformapk);
	public Optional<Tbasg198Alcaforma> findById(Tbasg198AlcaformaPK tbasg198alcaformapk);

	public List<Tbasg198Alcaforma> findByTbasg198alcaformapkIn(Collection<Tbasg198AlcaformaPK> tbasg198alcaformapk);
}
