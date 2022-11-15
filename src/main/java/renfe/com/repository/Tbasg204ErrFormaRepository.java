package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg204ErrForma;

public interface Tbasg204ErrFormaRepository
		extends JpaRepository<Tbasg204ErrForma, Integer>, Tbasg204ErrFormaRepositoryCustom {

	// Optional<Tbasg204ErrForma> findByCdgoError(Integer cdgoError);
	public Optional<Tbasg204ErrForma> findByCdgoError(Integer cdgoError);

	public List<Tbasg204ErrForma> findByCdgoErrorIn(Collection<Integer> cdgoError);
}
