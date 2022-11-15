package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg200ErrFich;

public interface Tbasg200ErrFichRepository 
extends JpaRepository<Tbasg200ErrFich, Integer>, Tbasg200ErrFichRepositoryCustom {

	public Optional<Tbasg200ErrFich> findByCdgoError(Integer cdgoError);

	public List<Tbasg200ErrFich> findByCdgoErrorIn(Collection<Integer> cdgoError);
}
