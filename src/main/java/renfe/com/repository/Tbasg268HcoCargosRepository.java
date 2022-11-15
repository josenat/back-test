package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg268HcoCargos;
import renfe.com.model.entity.Tbasg268HcoCargosPK;

public interface Tbasg268HcoCargosRepository
		extends JpaRepository<Tbasg268HcoCargos, Tbasg268HcoCargosPK>, Tbasg268HcoCargosRepositoryCustom {

	// Optional<Tbasg268HcoCargos> findByTbasg268hcocargospk(Tbasg268HcoCargosPK
	// tbasg268hcocargospk);
	public Optional<Tbasg268HcoCargos> findById(Tbasg268HcoCargosPK tbasg268hcocargos);

	//public List<Tbasg268HcoCargos> findByTbasg268hcocargospkIn(Collection<Tbasg268HcoCargos> tbasg268hcocargos);
}
