package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg147Subserie;
import renfe.com.model.entity.Tbasg147SubseriePK;

public interface Tbasg147SubserieRepository
		extends JpaRepository<Tbasg147Subserie, Tbasg147SubseriePK>, Tbasg147SubserieRepositoryCustom {

	// Optional<Tbasg147Subserie> findByTbasg147subseriepk(Tbasg147SubseriePK
	// tbasg147subseriepk);
	public Optional<Tbasg147Subserie> findById(Tbasg147SubseriePK tbasg147subseriepk);

	public List<Tbasg147Subserie> findByTbasg147subseriepkIn(Collection<Tbasg147SubseriePK> tbasg147subseriepk);
}
