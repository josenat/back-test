package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg192DocInfrGerenciaterr;

public interface Tbasg192DocInfrGerenciaterrRepository
		extends JpaRepository<Tbasg192DocInfrGerenciaterr, Integer>, Tbasg192DocInfrGerenciaterrRepositoryCustom {

	// Optional<Tbasg192DocInfrGerenciaterr> findByCdgoGerencia(Integer
	// cdgoGerencia);
	public Optional<Tbasg192DocInfrGerenciaterr> findByCdgoGerencia(Integer cdgoGerencia);

	public List<Tbasg192DocInfrGerenciaterr> findByCdgoGerenciaIn(Collection<Integer> cdgoGerencia);
}
