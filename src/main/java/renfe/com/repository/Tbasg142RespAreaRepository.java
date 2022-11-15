package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg142RespArea;

public interface Tbasg142RespAreaRepository
		extends JpaRepository<Tbasg142RespArea, Integer>, Tbasg142RespAreaRepositoryCustom {

	// Optional<Tbasg142RespArea> findByCdgoAreact(Integer cdgoAreact);
	public Optional<Tbasg142RespArea> findByCdgoAreact(Integer cdgoAreact);

	public List<Tbasg142RespArea> findByCdgoAreactIn(Collection<Integer> cdgoAreact);
}
