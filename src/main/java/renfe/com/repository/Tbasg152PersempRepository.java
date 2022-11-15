package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg152Persemp;
import renfe.com.model.entity.Tbasg152PersempPK;

public interface Tbasg152PersempRepository
		extends JpaRepository<Tbasg152Persemp, Tbasg152PersempPK>, Tbasg152PersempRepositoryCustom {

	// Optional<Tbasg152Persemp> findByTbasg152persemppk(Tbasg152PersempPK
	// tbasg152persemppk);
	public Optional<Tbasg152Persemp> findById(Tbasg152PersempPK tbasg152persemppk);

	public List<Tbasg152Persemp> findByTbasg152persemppkIn(Collection<Tbasg152PersempPK> tbasg152persemppk);
}
