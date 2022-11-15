package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg260Habilifunc;
import renfe.com.model.entity.Tbasg260HabilifuncPK;

public interface Tbasg260HabilifuncRepository
		extends JpaRepository<Tbasg260Habilifunc, Tbasg260HabilifuncPK>, Tbasg260HabilifuncRepositoryCustom {

	// Optional<Tbasg260Habilifunc> findByTbasg260habilifuncpk(Tbasg260HabilifuncPK
	// tbasg260habilifuncpk);
	public Optional<Tbasg260Habilifunc> findById(Tbasg260HabilifuncPK tbasg260habilifuncpk);

	public List<Tbasg260Habilifunc> findByTbasg260habilifuncpkIn(Collection<Tbasg260HabilifuncPK> tbasg260habilifuncpk);
}
