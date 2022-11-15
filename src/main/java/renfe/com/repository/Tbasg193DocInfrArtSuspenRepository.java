package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg193DocInfrArtSuspen;

public interface Tbasg193DocInfrArtSuspenRepository
		extends JpaRepository<Tbasg193DocInfrArtSuspen, Integer>, Tbasg193DocInfrArtSuspenRepositoryCustom {

	// Optional<Tbasg193DocInfrArtSuspen> findByCdgoArticulo(Integer cdgoArticulo);
	public Optional<Tbasg193DocInfrArtSuspen> findByCdgoArticulo(Integer cdgoArticulo);

	public List<Tbasg193DocInfrArtSuspen> findByCdgoArticuloIn(Collection<Integer> cdgoArticulo);
}
