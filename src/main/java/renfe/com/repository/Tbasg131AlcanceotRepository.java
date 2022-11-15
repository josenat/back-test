package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg131Alcanceot;

public interface Tbasg131AlcanceotRepository
		extends JpaRepository<Tbasg131Alcanceot, Integer>, Tbasg131AlcanceotRepositoryCustom {

	// Optional<Tbasg131Alcanceot> findByCdgoAlcanceot(Integer cdgoAlcanceot);
	public Optional<Tbasg131Alcanceot> findByCdgoAlcanceot(Integer cdgoAlcanceot);

	public List<Tbasg131Alcanceot> findByCdgoAlcanceotIn(Collection<Integer> cdgoAlcanceot);
}
