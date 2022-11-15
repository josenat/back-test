package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg280MarcaGmm;
import renfe.com.model.entity.Tbasg280MarcaGmmPK;

public interface Tbasg280MarcaGmmRepository
		extends JpaRepository<Tbasg280MarcaGmm, Tbasg280MarcaGmmPK>, Tbasg280MarcaGmmRepositoryCustom {

	// Optional<Tbasg280MarcaGmm> findByTbasg280marcagmmpk(Tbasg280MarcaGmmPK
	// tbasg280marcagmmpk);
	public Optional<Tbasg280MarcaGmm> findById(Tbasg280MarcaGmmPK tbasg280marcagmmpk);

	public List<Tbasg280MarcaGmm> findByTbasg280marcagmmpkIn(Collection<Tbasg280MarcaGmmPK> tbasg280marcagmmpk);
}
