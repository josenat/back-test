package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg162GcFiltro;

public interface Tbasg162GcFiltroRepository
		extends JpaRepository<Tbasg162GcFiltro, Integer>, Tbasg162GcFiltroRepositoryCustom {

	// Optional<Tbasg162GcFiltro> findByCdgoFiltro(Integer cdgoFiltro);
	public Optional<Tbasg162GcFiltro> findByCdgoFiltro(Integer cdgoFiltro);

	public List<Tbasg162GcFiltro> findByCdgoFiltroIn(Collection<Integer> cdgoFiltro);
}
