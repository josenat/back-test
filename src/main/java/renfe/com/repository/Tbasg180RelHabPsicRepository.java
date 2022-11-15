package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg180RelHabPsic;
import renfe.com.model.entity.Tbasg180RelHabPsicPK;

public interface Tbasg180RelHabPsicRepository
		extends JpaRepository<Tbasg180RelHabPsic, Tbasg180RelHabPsicPK>, Tbasg180RelHabPsicRepositoryCustom {

	// Optional<Tbasg180RelHabPsic> findByTbasg180relhabpsicpk(Tbasg180RelHabPsicPK
	// tbasg180relhabpsicpk);
	public Optional<Tbasg180RelHabPsic> findById(Tbasg180RelHabPsicPK tbasg180relhabpsicpk);

	public List<Tbasg180RelHabPsic> findByTbasg180relhabpsicpkIn(Collection<Tbasg180RelHabPsicPK> tbasg180relhabpsicpk);
}
