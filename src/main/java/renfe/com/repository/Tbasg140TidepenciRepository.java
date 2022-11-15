package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg140Tidepenci;

public interface Tbasg140TidepenciRepository
		extends JpaRepository<Tbasg140Tidepenci, Integer>, Tbasg140TidepenciRepositoryCustom {

	// Optional<Tbasg140Tidepenci> findByCdgoTipodep(Integer cdgoTipodep);
	public Optional<Tbasg140Tidepenci> findByCdgoTipodep(Integer cdgoTipodep);

	public List<Tbasg140Tidepenci> findByCdgoTipodepIn(Collection<Integer> cdgoTipodep);
}
