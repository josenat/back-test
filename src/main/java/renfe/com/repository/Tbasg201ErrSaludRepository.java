package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg201ErrSalud;

public interface Tbasg201ErrSaludRepository
		extends JpaRepository<Tbasg201ErrSalud, Integer>, Tbasg201ErrSaludRepositoryCustom {

	// Optional<Tbasg201ErrSalud> findByCdgoError(Integer cdgoError);
	public Optional<Tbasg201ErrSalud> findByCdgoError(Integer cdgoError);

	public List<Tbasg201ErrSalud> findByCdgoErrorIn(Collection<Integer> cdgoError);
}
