package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg146Actaincal;
import renfe.com.model.entity.Tbasg146ActaincalPK;

public interface Tbasg146ActaincalRepository
		extends JpaRepository<Tbasg146Actaincal, Tbasg146ActaincalPK>, Tbasg146ActaincalRepositoryCustom {

	// Optional<Tbasg146Actaincal> findByTbasg146actaincalpk(Tbasg146ActaincalPK
	// tbasg146actaincalpk);
	public Optional<Tbasg146Actaincal> findById(Tbasg146ActaincalPK tbasg146actaincalpk);

	public List<Tbasg146Actaincal> findByTbasg146actaincalpkIn(Collection<Tbasg146ActaincalPK> tbasg146actaincalpk);
}
