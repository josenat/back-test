package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg114Gradoinci;

public interface Tbasg114GradoinciRepository
		extends JpaRepository<Tbasg114Gradoinci, Integer>, Tbasg114GradoinciRepositoryCustom {

	// Optional<Tbasg114Gradoinci> findByCdgoGrado(Integer cdgoGrado);
	public Optional<Tbasg114Gradoinci> findByCdgoGrado(Integer cdgoGrado);

	public List<Tbasg114Gradoinci> findByCdgoGradoIn(Collection<Integer> cdgoGrado);
}
