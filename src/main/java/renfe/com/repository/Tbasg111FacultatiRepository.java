package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg111Facultati;

public interface Tbasg111FacultatiRepository
		extends JpaRepository<Tbasg111Facultati, Integer>, Tbasg111FacultatiRepositoryCustom {

	// Optional<Tbasg111Facultati> findByCdgoFacult(Integer cdgoFacult);
	public Optional<Tbasg111Facultati> findByCdgoFacult(Integer cdgoFacult);

	public List<Tbasg111Facultati> findByCdgoFacultIn(Collection<Integer> cdgoFacult);
}
