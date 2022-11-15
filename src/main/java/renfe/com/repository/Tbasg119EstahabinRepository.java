package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg119Estahabin;
import renfe.com.model.entity.Tbasg119EstahabinPK;

public interface Tbasg119EstahabinRepository
		extends JpaRepository<Tbasg119Estahabin, Tbasg119EstahabinPK>, Tbasg119EstahabinRepositoryCustom {

	// Optional<Tbasg119Estahabin> findByTbasg119estahabinpk(Tbasg119EstahabinPK
	// tbasg119estahabinpk);
	public Optional<Tbasg119Estahabin> findById(Tbasg119EstahabinPK tbasg119estahabinpk);

	public List<Tbasg119Estahabin> findByTbasg119estahabinpkIn(Collection<Tbasg119EstahabinPK> tbasg119estahabinpk);
}
