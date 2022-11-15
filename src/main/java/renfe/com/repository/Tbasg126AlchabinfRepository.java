package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg126Alchabinf;

public interface Tbasg126AlchabinfRepository
		extends JpaRepository<Tbasg126Alchabinf, Integer>, Tbasg126AlchabinfRepositoryCustom {

	// Optional<Tbasg126Alchabinf> findByCdgoAlchabinf(Integer cdgoAlchabinf);
	public Optional<Tbasg126Alchabinf> findByCdgoAlchabinf(Integer cdgoAlchabinf);

	public List<Tbasg126Alchabinf> findByCdgoAlchabinfIn(Collection<Integer> cdgoAlchabinf);
}
