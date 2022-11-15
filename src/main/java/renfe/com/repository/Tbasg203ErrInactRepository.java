package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg203ErrInact;

public interface Tbasg203ErrInactRepository
		extends JpaRepository<Tbasg203ErrInact, Integer>, Tbasg203ErrInactRepositoryCustom {

	// Optional<Tbasg203ErrInact> findByCdgoError(Integer cdgoError);
	public Optional<Tbasg203ErrInact> findByCdgoError(Integer cdgoError);

	public List<Tbasg203ErrInact> findByCdgoErrorIn(Collection<Integer> cdgoError);
}
