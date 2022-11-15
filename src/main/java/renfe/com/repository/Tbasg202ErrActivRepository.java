package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg202ErrActiv;

public interface Tbasg202ErrActivRepository
		extends JpaRepository<Tbasg202ErrActiv, Integer>, Tbasg202ErrActivRepositoryCustom {

	// Optional<Tbasg202ErrActiv> findByCdgoError(Integer cdgoError);
	public Optional<Tbasg202ErrActiv> findByCdgoError(Integer cdgoError);

	public List<Tbasg202ErrActiv> findByCdgoErrorIn(Collection<Integer> cdgoError);
}
